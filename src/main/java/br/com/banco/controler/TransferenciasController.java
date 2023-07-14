package br.com.banco.controler;
import br.com.banco.models.Transferencia;
import br.com.banco.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping("/transferencia")
public class TransferenciasController {


    private final TransferenciaService transferenciaService;


    //BUSCAR TRANSFERÊNCIA POR CONTA
    //TEST: GET http://localhost:8080/transferencia/conta/1
    @GetMapping(value = "/conta/{idConta}", produces = "application/json")
    public ResponseEntity<List<Transferencia>> buscarTransferenciasPorConta(@PathVariable Long idConta) {
        List<Transferencia> transferencias = transferenciaService.buscarTransferenciasPorConta(idConta);
        return ResponseEntity.ok(transferencias);
    }


    //RETORNA LISTA DE TRANSFERÊNCIAS POR PERIODO
    //TEST: GET http://localhost:8080/transferencia/periodo?inicio=2021-01-01T00:00:00&fim=2021-01-31T23:59:59
    @GetMapping(value = "/periodo", produces = "application/json")
    public ResponseEntity<List<Transferencia>> buscarTransferenciasPorPeriodo(
        @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime inicio,
        @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime fim) {
        List<Transferencia> transferencias;
        if (inicio != null && fim != null) {
            transferencias = transferenciaService.buscarTransferenciasPorPeriodo(inicio, fim);
        } else {
            transferencias = transferenciaService.buscarTodasTransferencias();
        }
        return ResponseEntity.ok(transferencias);
    }


    //BUSCAR TRANSFERÊNCIAS POR NOME DE OPERADOR
    //TEST: GET http://localhost:8080/transferencia/operador?nomeOperador=Beltrano
    @GetMapping(value = "/operador", produces = "application/json")
    public ResponseEntity<List<Transferencia>> buscarTransferenciasPorOperador(@RequestParam String nomeOperador) {
        List<Transferencia> transferencias = transferenciaService.buscarTransferenciasPorOperador(nomeOperador);
        return ResponseEntity.ok(transferencias);
    }


    //RETORNA TRANSFERÊNCIAS POR PERIODO PASSANDO NUMERO DA CONTA (id) E PERIODO DE DATAS, SE NAO INSERIDO PERIODO RETORNA TODOS
    //TEST: GET http://localhost:8080/transferencia/conta-periodo?idConta=2&inicio=2021-01-01T00:00:00&fim=2021-01-31T23:59:59
    @GetMapping(value = "/conta-periodo", produces = "application/json")
    public ResponseEntity<List<Transferencia>> buscarTransferenciasPorContaEPeriodo(
            @RequestParam(required = false) Long idConta,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime inicio,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime fim) {
        List<Transferencia> transferencias;
        if (idConta != null && inicio != null && fim != null) {
            transferencias = transferenciaService.buscarTransferenciasPorContaEPeriodo(idConta, inicio, fim);
        } else {
            transferencias = transferenciaService.buscarTodasTransferencias();
        }
        return ResponseEntity.ok(transferencias);
    }
}