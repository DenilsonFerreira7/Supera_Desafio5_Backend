package br.com.banco.Respository;
import br.com.banco.Models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transacao, Long> {


    List<Transacao> findAllByUserBancoIdConta(Long idConta);

    List<Transacao> findAllByDataTransferenciaBetween(LocalDateTime inicio, LocalDateTime fim);

    List<Transacao> findAllByNomeOperadorTransacao(String nomeOperador);

    List<Transacao> findAllByUserBancoIdContaAndDataTransferenciaBetween(Long idConta, LocalDateTime inicio, LocalDateTime fim);

    @Query("SELECT SUM(t.valor) FROM Transacao t WHERE t.userBanco.id = :contaId")
    BigDecimal calcularSaldoTotalPorConta(Long contaId);

    @Query("SELECT SUM(t.valor) FROM Transacao t WHERE t.dataTransferencia BETWEEN :inicio AND :fim")
    BigDecimal calcularSaldoTotalPorPeriodo(LocalDateTime inicio, LocalDateTime fim);

    @Query("SELECT COALESCE(SUM(t.valor), 0) FROM Transacao t")
    BigDecimal calcularSaldoTotal();
}