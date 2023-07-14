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


    //Calcular saldo total
    public BigDecimal calcularSaldoTotal() {
        BigDecimal saldoTotal = transferenciaRepository.calcularSaldoTotal();
        if (saldoTotal == null) {
            throw new NotFoundExeption("Não foi possível calcular o saldo total.");
        }
        return saldoTotal.setScale(2, RoundingMode.HALF_UP);
    }
}