package br.com.banco.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.banco.Respository.TransferenciaRepository;
import br.com.banco.Models.Transacao;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final TransferenciaRepository transferenciaRepository;

    // Retorna os dados de transferência de acordo com o número da conta bancária
    public List<Transacao> buscarTransferenciasPorConta(Long idConta) {
        return transferenciaRepository.findAllByUserBancoIdConta(idConta);
    }

    // Retorna as transferências relacionadas a um período de tempo
    public List<Transacao> buscarTransferenciasPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return transferenciaRepository.findAllByDataTransferenciaBetween(inicio, fim);
    }

    // Retorna as transferências relacionadas a um operador de transação
    public List<Transacao> buscarTransferenciasPorOperador(String nomeOperador) {
        return transferenciaRepository.findAllByNomeOperadorTransacao(nomeOperador);
    }

    // Retorna as transferências com base no período de tempo e nome do operador
    public List<Transacao> buscarTransferenciasPorContaEPeriodo(Long idConta, LocalDateTime inicio, LocalDateTime fim) {
        return transferenciaRepository.findAllByUserBancoIdContaAndDataTransferenciaBetween(idConta, inicio, fim);
    }

    // Calcula o saldo total por conta
    public BigDecimal calcularSaldoTotalPorConta(Long idConta) {
        BigDecimal saldoTotal = transferenciaRepository.calcularSaldoTotalPorConta(idConta);
        return saldoTotal != null ? saldoTotal.setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    // Calcula o saldo total por período
    public BigDecimal calcularSaldoTotalPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        BigDecimal saldoTotal = transferenciaRepository.calcularSaldoTotalPorPeriodo(inicio, fim);
        return saldoTotal != null ? saldoTotal.setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    //buscar todas as transferencias
    public List<Transacao> buscarTodasTransferencias() {
        return transferenciaRepository.findAll();
    }

    //Calcular saldo total
    public BigDecimal calcularSaldoTotal() {
        return transferenciaRepository.calcularSaldoTotal();
    }
}