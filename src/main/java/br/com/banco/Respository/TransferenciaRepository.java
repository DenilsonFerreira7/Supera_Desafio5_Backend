package br.com.banco.Respository;
import br.com.banco.Models.TransacaoModels;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface TransferenciaRepository extends JpaRepository <TransacaoModels,Long> {


    List<TransacaoModels> findAllByContaId(Long idConta);

    List<TransacaoModels> findAllByDataTransferenciaBetween(LocalDateTime inicio, LocalDateTime fim);

    List<TransacaoModels> findAllByNomeOperadorTransacao(String nomeOperador);

    List<TransacaoModels> findAllByContaIdAndDataTransferenciaBetween(Long idConta, LocalDateTime inicio, LocalDateTime fim);

    BigDecimal calcularSaldoTotalPorConta(Long idConta);

    BigDecimal calcularSaldoTotalPorPeriodo(LocalDateTime inicio, LocalDateTime fim);
}