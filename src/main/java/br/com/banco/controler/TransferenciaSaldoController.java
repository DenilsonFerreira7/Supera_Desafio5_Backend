package br.com.banco.controler;
import br.com.banco.service.TransferenciaSaldoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@RestController
@RequiredArgsConstructor
@RequestMapping("/saldo")


public class TransferenciaSaldoController {


    private final TransferenciaSaldoService transferenciaSaldoService;


    //RETORNA SALDO TOTAL POR (id) DA CONTA
    //TEST: GET http://localhost:8080/saldo/conta/1
    @GetMapping(value = "/conta/{idConta}", produces = "application/json")
    public ResponseEntity<BigDecimal> calcularSaldoTotalPorConta(@PathVariable Long idConta) {
        BigDecimal saldoTotal = transferenciaSaldoService.calcularSaldoTotalPorConta(idConta);
        return ResponseEntity.ok(saldoTotal);
    }


    //RETORNA SALDO POR PERIODO SELECIONADO, SE NÃO FOR INSERIDO VALOR RETORNA TOTAL
    //TEST: GET http://localhost:8080/saldo/periodo?inicio=2021-01-01T00:00:00&fim=2021-01-31T23:59:59
     @GetMapping(value = "/periodo", produces = "application/json")
    public ResponseEntity<BigDecimal> calcularSaldoTotalPorPeriodo(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime inicio,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime fim) {
        BigDecimal saldoTotal;
        if (inicio != null && fim != null) {
            saldoTotal = transferenciaSaldoService.calcularSaldoTotalPorPeriodo(inicio, fim);
        } else {
            saldoTotal = transferenciaSaldoService.calcularSaldoTotal();
        }
        return ResponseEntity.ok(saldoTotal);
    }
}