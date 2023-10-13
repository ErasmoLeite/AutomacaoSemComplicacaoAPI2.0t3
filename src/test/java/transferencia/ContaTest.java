package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvio;

    @BeforeEach
    void setUp() {
        xuxa = new Cliente("Xuxa", "12345678900", "111111");
        silvioSantos = new Cliente("Silvio Santos", "00987654321", "22222");

        contaXuxa = new Conta("0025", "2254", 2500.00, xuxa);
        contaSilvio = new Conta("0026", "2251", 3500.00, silvioSantos);
    }


    // Transacoes Entre Contas
    @Test
    public void realizarTransacaoXuxa() {
        contaXuxa.realizarTransferencia(1000.00, contaSilvio);

        assertEquals(1500.00, contaXuxa.getSaldo());
        assertEquals(4500.00, contaSilvio.getSaldo());
    }

    @Test
    public void realizarTransacaoSilvio() {
        contaSilvio.realizarTransferencia(1000.00, contaXuxa);

        assertEquals(3500.00, contaXuxa.getSaldo());
        assertEquals(2500.00, contaSilvio.getSaldo());
    }

    @Test
    public void realizarDepositoXuxa() {
        contaXuxa.realizarDeposito(1000.00);
        assertEquals(3500, contaXuxa.getSaldo());
    }

    @Test
    public void realizarDepositoSilvio() {
        contaSilvio.realizarDeposito(1000.00);
        assertEquals(4500, contaSilvio.getSaldo());
    }


    @Test
    public void realizarTransferenciaInvalidaXuxa() {
        boolean resultado = contaXuxa.realizarTransferencia(3500.00, contaSilvio);
        assertFalse(resultado);
    }


    @Test
    public void realizarTransferenciaInvalidaSilvio() {
        boolean resultado = contaSilvio.realizarTransferencia(5500.00, contaSilvio);
        assertFalse(resultado);
    }


    // Validacoes Informacoes  XUXA


    @Test
    public void validarClienteXuxa() {
        assertEquals("Xuxa", xuxa.getNome());
    }

    @Test
    public void validarRgXuxa() {
        assertEquals("111111", xuxa.getRg());
    }

    @Test
    public void validarCpfXuxa() {
        assertEquals("12345678900", xuxa.getCpf());
    }

    @Test
    public void validarAgenciaXuxa() {
        assertEquals("0025", contaXuxa.getAgencia());
    }

    @Test
    public void validarContaXuxa() {
        assertEquals("2254", contaXuxa.getNumeroConta());
    }

    @Test
    void getProprietarioXuxa() {
        assertEquals(xuxa, contaXuxa.getProprietario());
    }


    // Validacoes Informacoes Silvio

    @Test
    public void validarClienteSilvio() {
        assertEquals("Silvio Santos", silvioSantos.getNome());
    }
        @Test
        void getProprietarioSilvio() {
            assertEquals(silvioSantos, contaSilvio.getProprietario());
        }

    @Test
    public void validarCpfSilvio() {
        assertEquals("00987654321", silvioSantos.getCpf());
    }


    @Test
    public void validarRgSilvio() {
        assertEquals("22222", silvioSantos.getRg());
}


    @Test
    public void validarAgenciaSilvio(){
        assertEquals("0026", contaSilvio.getAgencia());
    }

    @Test
    public void validarContaSilvio(){
        assertEquals("2251", contaSilvio.getNumeroConta());
    }


    }
