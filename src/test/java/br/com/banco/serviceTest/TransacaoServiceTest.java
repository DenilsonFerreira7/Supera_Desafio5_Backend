package br.com.banco.serviceTest;
import br.com.banco.exceptions.NotFoundExeption;
import br.com.banco.models.Transferencia;
import br.com.banco.respository.TransferenciaRepository;
import br.com.banco.service.TransferenciaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

//TESTE UNITARIO PARA VALIDAR VERIFICAÇÃO DA CONTA POR (id)
class TransacaoServiceTest {

    private TransferenciaService transferenciaService;

    @Mock
    private TransferenciaRepository transferenciaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        transferenciaService = new TransferenciaService(transferenciaRepository);
    }

    @Test
    void buscarTransferenciasPorConta_DeveRetornarTransferenciasQuandoEncontradas() {
        // Define o ID da conta a ser testada
        Long idConta = 1L;

        // Cria uma lista de transferências simuladas
        List<Transferencia> transferencias = new ArrayList<>();
        transferencias.add(new Transferencia());

        // Configura o comportamento simulado do repositório ao chamar o método findAllByUserContaIdConta
        when(transferenciaRepository.findAllByUserContaIdConta(idConta)).thenReturn(transferencias);

        // Chama o método do serviço a ser testado
        List<Transferencia> resultado = transferenciaService.buscarTransferenciasPorConta(idConta);

        // Verifica se o resultado retornado é igual à lista simulada de transferências
        Assertions.assertEquals(transferencias, resultado);

        // Verifica se o método findAllByUserContaIdConta do repositório foi chamado com o ID da conta correto
        verify(transferenciaRepository).findAllByUserContaIdConta(idConta);
    }

    @Test
    void buscarTransferenciasPorConta_DeveLancarExcecaoQuandoNaoEncontrarTransferencias() {
        // Define o ID da conta a ser testada
        Long idConta = 1L;

        // Configura o comportamento simulado do repositório ao chamar o método findAllByUserContaIdConta
        when(transferenciaRepository.findAllByUserContaIdConta(idConta)).thenReturn(new ArrayList<>());

        // Verifica se o método lança uma exceção do tipo NotFoundExeption ao chamar o método buscarTransferenciasPorConta
        Assertions.assertThrows(NotFoundExeption.class,
                () -> transferenciaService.buscarTransferenciasPorConta(idConta));

        // Verifica se o método findAllByUserContaIdConta do repositório foi chamado com o ID da conta correto
        verify(transferenciaRepository).findAllByUserContaIdConta(idConta);
    }
}