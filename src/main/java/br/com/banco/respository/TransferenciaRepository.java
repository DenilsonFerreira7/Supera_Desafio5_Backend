package br.com.banco.respository;
import br.com.banco.models.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {


    // Filtra todas as transferências associadas a uma determinada  id da conta
    List<Transferencia> findAllByUserContaIdConta(Long idConta);


    // Filtra todas as transferências realizadas dentro de um determinado período de tempo
    List<Transferencia> findAllByDataTransferenciaBetween(LocalDateTime inicio, LocalDateTime fim);


    // Filtra todas as transferências realizadas por um determinado operador
    @Query("SELECT t FROM Transferencia t WHERE LOWER(t.nomeOperadorTransacao) LIKE LOWER(CONCAT('%', :nomeOperador, '%'))")
    List<Transferencia> findAllByNomeOperadorTransacao(String nomeOperador);


    // Filtra lista de transferencias passando id e periodo de datas
    @Query("SELECT t FROM Transferencia t WHERE t.userConta.idConta = :idConta AND t.dataTransferencia BETWEEN :inicio AND :fim")
    List<Transferencia> buscarTransferenciasPorContaEPeriodo(Long idConta, LocalDateTime inicio, LocalDateTime fim);


    // Filtra o saldo total de uma determinada conta
    @Query("SELECT SUM(t.valor) FROM Transferencia t WHERE t.userConta.idConta = :contaId")
    BigDecimal calcularSaldoTotalPorConta(Long contaId);


    // Filtra o saldo total das transferências realizadas dentro de um determinado período de tempo
    @Query("SELECT SUM(t.valor) FROM Transferencia t WHERE t.dataTransferencia BETWEEN :inicio AND :fim")
    BigDecimal calcularSaldoTotalPorPeriodo(LocalDateTime inicio, LocalDateTime fim);


    // Filtra o saldo total de todas as transferências
    @Query("SELECT COALESCE(SUM(t.valor), 0) FROM Transferencia t")
    BigDecimal calcularSaldoTotal();


    // Filtra saldo total de determinado id por periodo de datas
    @Query("SELECT SUM(t.valor) FROM Transferencia t WHERE t.userConta.idConta = :idConta AND t.dataTransferencia BETWEEN :inicio AND :fim")
    BigDecimal calcularSaldoTotalPorPeriodoEConta(LocalDateTime inicio, LocalDateTime fim, Long idConta);


    // Filtra saldo total por nome de operador
    @Query("SELECT SUM(t.valor) FROM Transferencia t WHERE LOWER(t.nomeOperadorTransacao) LIKE CONCAT('%', LOWER(:nomeOperadorTransacao), '%')")
    BigDecimal calcularSaldoTotalPorPeriodoEContaEOperador(@Param("nomeOperadorTransacao") String nomeOperadorTransacao);


    // Filtra lista de transferencia por nome de operador entre datas
    @Query("SELECT t FROM Transferencia t WHERE t.dataTransferencia BETWEEN :inicio AND :fim AND LOWER(t.nomeOperadorTransacao) LIKE CONCAT('%', LOWER(:nomeOperadorTransacao), '%')")
    List<Transferencia> findByDataTransferenciaBetweenAndNomeOperadorTransacao(LocalDateTime inicio, LocalDateTime fim, String nomeOperadorTransacao);


    // Filtra saldo tota por nome de operador entre datas
    @Query("SELECT COALESCE(SUM(t.valor), 0) FROM Transferencia t WHERE t.dataTransferencia BETWEEN :inicio AND :fim AND LOWER(t.nomeOperadorTransacao) LIKE LOWER(CONCAT('%', :nomeOperadorTransacao, '%'))")
    BigDecimal calcularSaldoTotalPorPeriodoEOperador(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim, @Param("nomeOperadorTransacao") String nomeOperadorTransacao);


}