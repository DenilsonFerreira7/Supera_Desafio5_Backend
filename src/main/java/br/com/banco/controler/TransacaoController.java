package br.com.banco.controler;
import br.com.banco.models.Transacao;
import br.com.banco.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;


    @GetMapping(value = "/conta/{idConta}", produces = "application/json")
    public ResponseEntity<List<Transacao>> buscarTransferenciasPorConta(@PathVariable Long idConta) {
        List<Transacao> transferencias = transacaoService.buscarTransferenciasPorConta(idConta);
        return ResponseEntity.ok(transferencias);
    }


    //RETORNA LISTA DE TRANSACAO POR PERIODO
    @GetMapping(value = "/periodo", produces = "application/json")
    public ResponseEntity<List<Transacao>> buscarTransferenciasPorPeriodo(
        @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime inicio,
        @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime fim) {
        List<Transacao> transferencias;
        if (inicio != null && fim != null) {
            transferencias = transacaoService.buscarTransferenciasPorPeriodo(inicio, fim);
        } else {
            transferencias = transacaoService.buscarTodasTransferencias();
        }
        return ResponseEntity.ok(transferencias);
    }


    //BUSCAR TRANSAÇÃO POR NOME DE OPERADOR
    @GetMapping(value = "/operador", produces = "application/json")
    public ResponseEntity<List<Transacao>> buscarTransferenciasPorOperador(@RequestParam String nomeOperador) {
        List<Transacao> transferencias = transacaoService.buscarTransferenciasPorOperador(nomeOperador);
        return ResponseEntity.ok(transferencias);
    }


    //RETORNA TRANSAÇÕES POR PERIODO PASSANDO NUMERO DA CONTA (id) E PERIODO DE DATAS, SE NAO INSERIDO PERIODO RETORNA TODOS
    @GetMapping(value = "/conta-periodo", produces = "application/json")
    public ResponseEntity<List<Transacao>> buscarTransferenciasPorContaEPeriodo(
            @RequestParam(required = false) Long idConta,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime inicio,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime fim) {
        List<Transacao> transferencias;
        if (idConta != null && inicio != null && fim != null) {
            transferencias = transacaoService.buscarTransferenciasPorContaEPeriodo(idConta, inicio, fim);
        } else {
            transferencias = transacaoService.buscarTodasTransferencias();
        }
        return ResponseEntity.ok(transferencias);
    }


    //RETORNA SALDO TOTAL POR (id) DA CONTA
    @GetMapping(value = "/saldo/conta/{idConta}", produces = "application/json")
    public ResponseEntity<BigDecimal> calcularSaldoTotalPorConta(@PathVariable Long idConta) {
        BigDecimal saldoTotal = transacaoService.calcularSaldoTotalPorConta(idConta);
        return ResponseEntity.ok(saldoTotal);
    }


    //RETORNA SALDO POR PERIODO SELECIONADO, SE NÃO FOR INSERIDO VALOR RETORNA TOTAL
    @GetMapping(value = "/saldo/periodo", produces = "application/json")
    public ResponseEntity<BigDecimal> calcularSaldoTotalPorPeriodo(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime inicio,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime fim) {
        BigDecimal saldoTotal;
        if (inicio != null && fim != null) {
            saldoTotal = transacaoService.calcularSaldoTotalPorPeriodo(inicio, fim);
        } else {
            saldoTotal = transacaoService.calcularSaldoTotal();
        }
        return ResponseEntity.ok(saldoTotal);
    }
}