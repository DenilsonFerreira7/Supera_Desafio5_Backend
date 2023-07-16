package br.com.banco.service;
import br.com.banco.exceptions.NotFoundExeption;
import br.com.banco.models.Transferencia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.banco.respository.TransferenciaRepository;
import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;

    public List<Transferencia> buscarTransferenciasPorConta(Long idConta) {
        List<Transferencia> transferencias = transferenciaRepository.findAllByUserContaIdConta(idConta);
        if (transferencias.isEmpty()) {
            throw new NotFoundExeption("Não foram encontradas transações para o número da conta fornecido.");
        }
        return transferencias;
    }


    // Transferências por periodo de datas
    public List<Transferencia> buscarTransferenciasPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return transferenciaRepository.findAllByDataTransferenciaBetween(inicio, fim);
    }


    // Transferências por nome de operador
    public List<Transferencia> buscarTransferenciasPorOperador(String nomeOperador) {
        List<Transferencia> transferencias = transferenciaRepository.findAllByNomeOperadorTransacao(nomeOperador);
        if (transferencias.isEmpty()) {
            throw new NotFoundExeption("Não foram encontradas transações para o operador fornecido.");
        }
        return transferencias;
    }


    // Transferências por período de datas e nome do operador
    public List<Transferencia> buscarTransferenciasPorContaEPeriodo(Long idConta, LocalDateTime inicio, LocalDateTime fim) {
        List<Transferencia> transferencias = transferenciaRepository.buscarTransferenciasPorContaEPeriodo(idConta, inicio, fim);
        if (transferencias.isEmpty()) {
            throw new NotFoundExeption("Não foram encontradas transações para a conta e período fornecidos.");
        }
        return transferencias;
    }


    // Transferencias por periodo de datas e nome do operador
    public List<Transferencia> buscarTransferenciasPorPeriodoEOperador(LocalDateTime inicio, LocalDateTime fim, String nomeOperadorTransacao) {
        List<Transferencia> transferencias = transferenciaRepository.findByDataTransferenciaBetweenAndNomeOperadorTransacao(inicio, fim, nomeOperadorTransacao);
        if (transferencias.isEmpty()){
            throw new NotFoundExeption("Não foram encontradas transações para a conta e período fornecidos");
        }
        return  transferencias;
    }


    //buscar todas as transferencias
    public List<Transferencia> buscarTodasTransferencias() {
        List<Transferencia> transferencias = transferenciaRepository.findAll();
        if (transferencias.isEmpty()) {
            throw new NotFoundExeption("Não foram encontradas transferências.");
        }
        return transferencias;
    }
}