package br.com.banco.respository;
import br.com.banco.models.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {


    // Busca todas as transferências associadas a uma determinada conta
    List<Transferencia> findAllByUserContaIdConta(Long idConta);


    // Busca todas as transferências realizadas dentro de um determinado período de tempo
    List<Transferencia> findAllByDataTransferenciaBetween(LocalDateTime inicio, LocalDateTime fim);


    // Busca todas as transferências realizadas por um determinado operador
    List<Transferencia> findAllByNomeOperadorTransacao(String nomeOperador);


    // Busca todas as transferências associadas a uma determinada conta e realizadas dentro de um determinado período de tempo
    List<Transferencia> findAllByUserContaIdContaAndDataTransferenciaBetween(Long idConta, LocalDateTime inicio, LocalDateTime fim);


    // Calcula o saldo total de uma determinada conta
    @Query("SELECT SUM(t.valor) FROM Transferencia t WHERE t.userConta.idConta = :contaId")
    BigDecimal calcularSaldoTotalPorConta(Long contaId);


    // Calcula o saldo total das transferências realizadas dentro de um determinado período de tempo
    @Query("SELECT SUM(t.valor) FROM Transferencia t WHERE t.dataTransferencia BETWEEN :inicio AND :fim")
    BigDecimal calcularSaldoTotalPorPeriodo(LocalDateTime inicio, LocalDateTime fim);


    // Calcula o saldo total de todas as transferências
    @Query("SELECT COALESCE(SUM(t.valor), 0) FROM Transferencia t")
    BigDecimal calcularSaldoTotal();
}