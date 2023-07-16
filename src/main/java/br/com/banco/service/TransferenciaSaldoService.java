package br.com.banco.service;
import br.com.banco.exceptions.NotFoundExeption;
import br.com.banco.respository.TransferenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransferenciaSaldoService {


    private final TransferenciaRepository transferenciaRepository;


    //Saldo total por conta
    public BigDecimal calcularSaldoTotalPorConta(Long idConta) {
        BigDecimal saldoTotal = transferenciaRepository.calcularSaldoTotalPorConta(idConta);
        if (saldoTotal == null) {
            throw new NotFoundExeption("Não foi possível calcular o saldo total para a conta fornecida, verifique se a conta existe");
        }
        return saldoTotal.setScale(2, RoundingMode.HALF_UP);
    }


    //Saldo total por periodo de datas
    public BigDecimal calcularSaldoTotalPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        BigDecimal saldoTotal = transferenciaRepository.calcularSaldoTotalPorPeriodo(inicio, fim);
        if (saldoTotal == null) {
            throw new NotFoundExeption("Não foi possível calcular o saldo total para o período fornecido.");
        }
        return saldoTotal.setScale(2, RoundingMode.HALF_UP);
    }


    // Saldo total por periodo e id da conta
    public BigDecimal calcularSaldoTotalPorPeriodoEConta(LocalDateTime inicio, LocalDateTime fim, Long idConta) {
        BigDecimal saldoTotal = transferenciaRepository.calcularSaldoTotalPorPeriodoEConta(inicio, fim, idConta);
        if (saldoTotal == null) {
            throw new NotFoundExeption("Saldo total não encontrado");
        }
        return saldoTotal.setScale(2, RoundingMode.HALF_UP);
    }


    // Saldo total por periodo de datas  e nome do operador
    public BigDecimal calcularSaldoTotalPorPeriodoEContaEOperador(String nomeOperadorTransacao) {
        BigDecimal saldoTotal = transferenciaRepository.calcularSaldoTotalPorPeriodoEContaEOperador(nomeOperadorTransacao);
        if (saldoTotal == null) {
            throw new NotFoundExeption("Saldo total não encontrado");
        }
        return saldoTotal.setScale(2, RoundingMode.HALF_UP);
    }


    // Saldo total por periodo e nome do operador
    public BigDecimal calcularSaldoTotalPorPeriodoEOperador(LocalDateTime inicio, LocalDateTime fim, String nomeOperadorTransacao) {
        BigDecimal saldoTotal = transferenciaRepository.calcularSaldoTotalPorPeriodoEOperador(inicio, fim, nomeOperadorTransacao);
        if (saldoTotal == null) {
            throw new NotFoundExeption("Saldo não encontrado");
        }
        return saldoTotal.setScale(2, RoundingMode.HALF_UP);
    }
}