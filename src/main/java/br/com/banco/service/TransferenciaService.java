package br.com.banco.service;
import br.com.banco.exceptions.NotFoundExeption;
import br.com.banco.models.Transferencia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.banco.respository.TransferenciaRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
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


    // Retorna as transferências relacionadas a um período de tempo
    public List<Transferencia> buscarTransferenciasPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        List<Transferencia> transferencias = transferenciaRepository.findAllByDataTransferenciaBetween(inicio, fim);
        if (transferencias.isEmpty()) {
            throw new NotFoundExeption("Não foram encontradas transações para o período fornecido.");
        }
        return transferencias;
    }


    // Retorna as transferências relacionadas a um operador de transação
    public List<Transferencia> buscarTransferenciasPorOperador(String nomeOperador) {
        List<Transferencia> transferencias = transferenciaRepository.findAllByNomeOperadorTransacao(nomeOperador);
        if (transferencias.isEmpty()) {
            throw new NotFoundExeption("Não foram encontradas transações para o operador fornecido.");
        }
        return transferencias;
    }


    // Retorna as transferências com base no período de tempo e nome do operador
    public List<Transferencia> buscarTransferenciasPorContaEPeriodo(Long idConta, LocalDateTime inicio, LocalDateTime fim) {
        List<Transferencia> transferencias = transferenciaRepository.findAllByUserContaIdContaAndDataTransferenciaBetween(idConta, inicio, fim);
        if (transferencias.isEmpty()) {
            throw new NotFoundExeption("Não foram encontradas transações para a conta e período fornecidos.");
        }
        return transferencias;
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