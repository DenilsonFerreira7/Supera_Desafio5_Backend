package br.com.banco.service;
import br.com.banco.exceptions.NotFoundExeption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.banco.respository.TransferenciaRepository;
import br.com.banco.models.Transacao;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final TransferenciaRepository transferenciaRepository;

    public List<Transacao> buscarTransferenciasPorConta(Long idConta) {
        List<Transacao> transferencias = transferenciaRepository.findAllByUserBancoIdConta(idConta);
        if (transferencias.isEmpty()) {
            throw new NotFoundExeption("Não foram encontradas transações para o número da conta fornecido.");
        }
        return transferencias;
    }


    // Retorna as transferências relacionadas a um período de tempo
    public List<Transacao> buscarTransferenciasPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        List<Transacao> transferencias = transferenciaRepository.findAllByDataTransferenciaBetween(inicio, fim);
        if (transferencias.isEmpty()) {
            throw new NotFoundExeption("Não foram encontradas transações para o período fornecido.");
        }
        return transferencias;
    }


    // Retorna as transferências relacionadas a um operador de transação
    public List<Transacao> buscarTransferenciasPorOperador(String nomeOperador) {
        List<Transacao> transferencias = transferenciaRepository.findAllByNomeOperadorTransacao(nomeOperador);
        if (transferencias.isEmpty()) {
            throw new NotFoundExeption("Não foram encontradas transações para o operador fornecido.");
        }
        return transferencias;
    }


    // Retorna as transferências com base no período de tempo e nome do operador
    public List<Transacao> buscarTransferenciasPorContaEPeriodo(Long idConta, LocalDateTime inicio, LocalDateTime fim) {
        List<Transacao> transferencias = transferenciaRepository.findAllByUserBancoIdContaAndDataTransferenciaBetween(idConta, inicio, fim);
        if (transferencias.isEmpty()) {
            throw new NotFoundExeption("Não foram encontradas transações para a conta e período fornecidos.");
        }
        return transferencias;
    }


    // Calcula o saldo total por conta
    public BigDecimal calcularSaldoTotalPorConta(Long idConta) {
        BigDecimal saldoTotal = transferenciaRepository.calcularSaldoTotalPorConta(idConta);
        if (saldoTotal == null) {
            throw new NotFoundExeption("Não foi possível calcular o saldo total para a conta fornecida, verifique se a conta existe");
        }
        return saldoTotal.setScale(2, RoundingMode.HALF_UP);
    }


    // Calcula o saldo total por período
    public BigDecimal calcularSaldoTotalPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        BigDecimal saldoTotal = transferenciaRepository.calcularSaldoTotalPorPeriodo(inicio, fim);
        if (saldoTotal == null) {
            throw new NotFoundExeption("Não foi possível calcular o saldo total para o período fornecido.");
        }
        return saldoTotal.setScale(2, RoundingMode.HALF_UP);
    }

    //buscar todas as transferencias
    public List<Transacao> buscarTodasTransferencias() {
        List<Transacao> transferencias = transferenciaRepository.findAll();
        if (transferencias.isEmpty()) {
            throw new NotFoundExeption("Não foram encontradas transferências.");
        }
        return transferencias;
    }

    //Calcular saldo total
    public BigDecimal calcularSaldoTotal() {
        BigDecimal saldoTotal = transferenciaRepository.calcularSaldoTotal();
        if (saldoTotal == null) {
            throw new NotFoundExeption("Não foi possível calcular o saldo total.");
        }
        return saldoTotal.setScale(2, RoundingMode.HALF_UP);
    }
}