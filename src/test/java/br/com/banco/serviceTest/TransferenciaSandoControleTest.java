package br.com.banco.serviceTest;
import br.com.banco.controler.TransferenciaSaldoController;
import br.com.banco.service.TransferenciaSaldoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class TransferenciaSandoControleTest {

    @Mock
    private TransferenciaSaldoService transferenciaSaldoService;

    @InjectMocks
    private TransferenciaSaldoController transferenciaSaldoController;

    @Test
    void calcularSaldoTotalPorConta() {
        // Dados de teste
        Long idConta = 1L;
        BigDecimal saldoTotalEsperado = BigDecimal.valueOf(1000);

        // Mock do serviço
        when(transferenciaSaldoService.calcularSaldoTotalPorConta(idConta))
                .thenReturn(saldoTotalEsperado);

        // Chamar o método do controlador
        ResponseEntity<BigDecimal> response = transferenciaSaldoController.calcularSaldoTotalPorConta(idConta);

        // Verificar o resultado
        assertEquals(saldoTotalEsperado, response.getBody());
    }

    @Test
    void calcularSaldoTotalPorPeriodoEContaEOperador() {
        // Dados de teste
        String nomeOperador = "Maria";
        BigDecimal saldoTotalEsperado = BigDecimal.valueOf(500);

        // Mock do serviço
        when(transferenciaSaldoService.calcularSaldoTotalPorPeriodoEContaEOperador(nomeOperador))
                .thenReturn(saldoTotalEsperado);

        // Chamar o método do controlador
        ResponseEntity<BigDecimal> response = transferenciaSaldoController.calcularSaldoTotalPorPeriodoEContaEOperador(nomeOperador);

        // Verificar o resultado
        assertEquals(saldoTotalEsperado, response.getBody());
    }

    @Test
    void calcularSaldoTotalPorPeriodo() {
        // Dados de teste
        LocalDate inicio = LocalDate.of(2020, 1, 1);
        LocalDate fim = LocalDate.of(2021, 12, 31);
        BigDecimal saldoTotalEsperado = BigDecimal.valueOf(2000);

        // Mock do serviço
        when(transferenciaSaldoService.calcularSaldoTotalPorPeriodo(
                LocalDateTime.of(inicio, LocalTime.MIN),
                LocalDateTime.of(fim, LocalTime.MAX)))
                .thenReturn(saldoTotalEsperado);

        // Chamar o método do controlador
        ResponseEntity<BigDecimal> response = transferenciaSaldoController.calcularSaldoTotalPorPeriodo(inicio, fim);

        // Verificar o resultado
        assertEquals(saldoTotalEsperado, response.getBody());
    }

    @Test
    void calcularSaldoTotalPorPeriodoEConta() {
        // Dados de teste
        LocalDate inicio = LocalDate.of(2020, 1, 1);
        LocalDate fim = LocalDate.of(2021, 12, 31);
        Long idConta = 3L;
        BigDecimal saldoTotalEsperado = BigDecimal.valueOf(1500);

        // Mock do serviço
        when(transferenciaSaldoService.calcularSaldoTotalPorPeriodoEConta(
                LocalDateTime.of(inicio, LocalTime.MIN),
                LocalDateTime.of(fim, LocalTime.MAX),
                idConta))
                .thenReturn(saldoTotalEsperado);

        // Chamar o método do controlador
        ResponseEntity<BigDecimal> response = transferenciaSaldoController.calcularSaldoTotalPorPeriodoEConta(inicio, fim, idConta);

        // Verificar o resultado
        assertEquals(saldoTotalEsperado, response.getBody());
    }

    @Test
    void calcularSaldoTotalPorPeriodoEOperador() {
        // Dados de teste
        LocalDate inicio = LocalDate.of(2015, 1, 1);
        LocalDate fim = LocalDate.of(2022, 12, 31);
        String nomeOperador = "Ma";
        BigDecimal saldoTotalEsperado = BigDecimal.valueOf(3000);

        // Mock do serviço
        when(transferenciaSaldoService.calcularSaldoTotalPorPeriodoEOperador(
                LocalDateTime.of(inicio, LocalTime.MIN),
                LocalDateTime.of(fim, LocalTime.MAX),
                nomeOperador))
                .thenReturn(saldoTotalEsperado);

        // Chamar o método do controlador
        ResponseEntity<BigDecimal> response = transferenciaSaldoController.calcularSaldoTotalPorPeriodoEOperador(inicio, fim, nomeOperador);

        // Verificar o resultado
        assertEquals(saldoTotalEsperado, response.getBody());
    }
}
