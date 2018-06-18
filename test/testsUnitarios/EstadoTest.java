package testsUnitarios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cartas.Jinzo;

public class EstadoTest {

	@Test
	public void testPuntosAsociadosACartaMonstruoEnModoAtaque() {
		Jinzo jinzo = new Jinzo();
		jinzo.colocarEnModoAtaque();
		assertEquals(2400, jinzo.puntosAUtilizarSegunEstado());
	}

	@Test
	public void testPuntosAsociadosACartaMonstruoEnModoDefensa() {
		Jinzo jinzo = new Jinzo();
		jinzo.colocarEnModoDefensa();
		assertEquals(1500, jinzo.puntosAUtilizarSegunEstado());
	}

}
