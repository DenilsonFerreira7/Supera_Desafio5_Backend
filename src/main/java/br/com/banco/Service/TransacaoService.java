package br.com.banco.Service;
import br.com.banco.Models.TransacaoModels;
import br.com.banco.Respository.TransferenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Service
public class TransacaoService {

    private final TransferenciaRepository transferenciaRepository;


    //Retornar os dados de transferência de acordo com o número da conta bancária:
    public List<TransacaoModels> buscarTransferenciasPorConta(Long idConta) {
        return transferenciaRepository.findAllByContaId(idConta);
    }


    //Retornar as transferências relacionadas a um período de tempo:
    public List<TransacaoModels> buscarTransferenciasPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return transferenciaRepository.findAllByDataTransferenciaBetween(inicio, fim);
    }


    //Retornar as transferências relacionadas a um operador de transação:
    public List<TransacaoModels> buscarTransferenciasPorOperador(String nomeOperador) {
        return transferenciaRepository.findAllByNomeOperadorTransacao(nomeOperador);
    }


    //Retornar as transferências com base no período de tempo e nome do operador:
    public List<TransacaoModels> buscarTransferenciasPorContaEPeriodo(Long idConta, LocalDateTime inicio, LocalDateTime fim) {
        return transferenciaRepository.findAllByContaIdAndDataTransferenciaBetween(idConta, inicio, fim);
    }


    //Saldo total por conta
    public BigDecimal calcularSaldoTotalPorConta(Long idConta) {
        return transferenciaRepository.calcularSaldoTotalPorConta(idConta);
    }


    //Saldo total por periodo
    public BigDecimal calcularSaldoTotalPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return transferenciaRepository.calcularSaldoTotalPorPeriodo(inicio, fim);
    }
}