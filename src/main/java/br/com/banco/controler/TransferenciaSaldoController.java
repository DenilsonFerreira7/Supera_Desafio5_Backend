package br.com.banco.controler;
import br.com.banco.service.TransferenciaSaldoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@RestController
@RequiredArgsConstructor
@RequestMapping("/saldo")


public class TransferenciaSaldoController {


    private final TransferenciaSaldoService transferenciaSaldoService;


    //RETORNA SALDO TOTAL POR (id) DA CONTA
    //TEST: GET http://localhost:8080/saldo/conta/1  /FEITO
    @GetMapping(value = "/conta/{idConta}", produces = "application/json")
    public ResponseEntity<BigDecimal> calcularSaldoTotalPorConta(@PathVariable Long idConta) {
        BigDecimal saldoTotal = transferenciaSaldoService.calcularSaldoTotalPorConta(idConta);
        return ResponseEntity.ok(saldoTotal);
    }


    // RETORNA SALDO TOTAL POR NOME DO OPERADOR
    //http://localhost:8080/saldo/totalPeriodoEContaOperador/Maria
    @GetMapping(value = "/totalPeriodoEContaOperador/{nomeOperadorTransacao}", produces = "application/json")
    public ResponseEntity<BigDecimal> calcularSaldoTotalPorPeriodoEContaEOperador(@PathVariable String nomeOperadorTransacao) {
        BigDecimal saldoTotal = transferenciaSaldoService.calcularSaldoTotalPorPeriodoEContaEOperador(nomeOperadorTransacao);
        return ResponseEntity.ok(saldoTotal);
    }


    //RETORNA SALDO POR PERIODO SELECIONADO
    //TEST: http://localhost:8080/saldo/totalPeriodo?inicio=2020-01-01&fim=2021-12-31 /FEITO
    @GetMapping(value = "/totalPeriodo", produces = "application/json")
    public ResponseEntity<BigDecimal> calcularSaldoTotalPorPeriodo(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate inicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fim) {
        LocalDateTime dataHoraInicio = inicio.atStartOfDay();
        LocalDateTime dataHoraFim = fim.atTime(LocalTime.MAX);
        BigDecimal saldoTotal = transferenciaSaldoService.calcularSaldoTotalPorPeriodo(dataHoraInicio, dataHoraFim);
        return ResponseEntity.ok(saldoTotal);
    }


    // RETORNA SALDO TOTAL POR ID PERIODO E DATA
    // TEST: http://localhost:8080/saldo/totalPeriodoEConta?inicio=2020-01-01&fim=2021-12-31&idConta=3 /FEITO
    @GetMapping(value = "/totalPeriodoEConta", produces = "application/json")
    public ResponseEntity<BigDecimal> calcularSaldoTotalPorPeriodoEConta(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate inicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fim,
            @RequestParam Long idConta) {
        LocalDateTime dataHoraInicio = inicio.atStartOfDay();
        LocalDateTime dataHoraFim = fim.atTime(LocalTime.MAX);
        BigDecimal saldoTotal = transferenciaSaldoService.calcularSaldoTotalPorPeriodoEConta(dataHoraInicio, dataHoraFim, idConta);
        return ResponseEntity.ok(saldoTotal);
    }


    //RETORNA SALDO TOTAL POR NOME DO OPERADOR E PERIODO DE DATAS
    //TEST: http://localhost:8080/saldo/totalPeriodoEOperador?inicio=2015-01-01&fim=2022-12-31&nomeOperador=Ma
    @GetMapping(value = "/totalPeriodoEOperador", produces = "application/json")
    public ResponseEntity<BigDecimal> calcularSaldoTotalPorPeriodoEOperador(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate inicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fim,
            @RequestParam String nomeOperador) {
        LocalDateTime dataHoraInicio = inicio.atStartOfDay();
        LocalDateTime dataHoraFim = fim.atTime(LocalTime.MAX);
        BigDecimal saldoTotal = transferenciaSaldoService.calcularSaldoTotalPorPeriodoEOperador(dataHoraInicio, dataHoraFim, nomeOperador);
        return ResponseEntity.ok(saldoTotal);
    }
}