package br.com.banco.controler;
import br.com.banco.models.Transferencia;
import br.com.banco.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping("/transferencia")
public class TransferenciasController {


    private final TransferenciaService transferenciaService;


    // BUSCA TRANSFERÊNCIAS POR ID DA CONTA
    // TEST:  http://localhost:8080/transferencia/conta/1
    @GetMapping(value = "/conta/{idConta}", produces = "application/json")
    public ResponseEntity<List<Transferencia>> buscarTransferenciasPorConta(@PathVariable Long idConta) {
        List<Transferencia> transferencias = transferenciaService.buscarTransferenciasPorConta(idConta);
        return ResponseEntity.ok(transferencias);
    }


    // BUSCA LISTA DE TRANSFERÊNCIAS POR PERIODO
    // TEST: GET http://localhost:8080/transferencia/periodo?inicio=2021-01-01&fim=2021-01-31
    @GetMapping(value = "/periodo", produces = "application/json")
    public ResponseEntity<List<Transferencia>> buscarTransferenciasPorPeriodo(
            @RequestParam(required = false) String inicio,
            @RequestParam(required = false) String fim) {
        LocalDateTime dataInicio = inicio != null ? LocalDate.parse(inicio).atStartOfDay() : null;
        LocalDateTime dataFim = fim != null ? LocalDate.parse(fim).atTime(LocalTime.MAX) : null;
        List<Transferencia> transferencias = transferenciaService.buscarTransferenciasPorPeriodo(dataInicio, dataFim);
        return ResponseEntity.ok(transferencias);
    }


    //BUSCA TRANSFERÊNCIAS POR NOME DE OPERADOR
    //TEST: GET http://localhost:8080/transferencia/operador?nomeOperador=Beltrano
    @GetMapping(value = "/operador", produces = "application/json")
    public ResponseEntity<List<Transferencia>> buscarTransferenciasPorOperador(@RequestParam String nomeOperador) {
        List<Transferencia> transferencias = transferenciaService.buscarTransferenciasPorOperador(nomeOperador);
        return ResponseEntity.ok(transferencias);
    }


    //BUSCA TRANSFERÊNCIAS POR PERIODO PASSANDO NUMERO DA CONTA (id) }
    //TEST: http://localhost:8080/transferencia/conta-periodo?idConta=2&inicio=2021-01-01&fim=2021-01-31
    @GetMapping(value = "/conta-periodo", produces = "application/json")
    public ResponseEntity<List<Transferencia>> buscarTransferenciasPorContaEPeriodo(
            @RequestParam(required = false) Long idConta,
            @RequestParam(required = false) String inicio,
            @RequestParam(required = false) String fim) {
        LocalDateTime dataHoraInicio = inicio != null ? LocalDate.parse(inicio).atStartOfDay() : null;
        LocalDateTime dataHoraFim = fim != null ? LocalDate.parse(fim).atTime(LocalTime.MAX) : null;
        List<Transferencia> transferencias = transferenciaService.buscarTransferenciasPorContaEPeriodo
                (idConta, dataHoraInicio, dataHoraFim);
        return ResponseEntity.ok(transferencias);
    }


    //BUSCA TRANSFERENCIAS POR OPERADOR PASSANDO UM PERIODO DE DATAS
    //TEST: http://localhost:8080/transferencia/periodo-operador?inicio=2015-01-01&fim=2023-12-31&nomeOperador=Mar
    @GetMapping(value = "/periodo-operador", produces = "application/json")
    public ResponseEntity<List<Transferencia>> buscarTransferenciasPorPeriodoEOperador(
            @RequestParam(required = false) String inicio,
            @RequestParam(required = false) String fim,
            @RequestParam(required = false) String nomeOperador) {
        LocalDateTime dataHoraInicio = inicio != null ? LocalDate.parse(inicio).atStartOfDay() : null;
        LocalDateTime dataHoraFim = fim != null ? LocalDate.parse(fim).atTime(LocalTime.MAX) : null;
        List<Transferencia> transferencias = transferenciaService.buscarTransferenciasPorPeriodoEOperador(dataHoraInicio, dataHoraFim, nomeOperador);
        return ResponseEntity.ok(transferencias);
    }
}