package testsUnitarios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cartas.InsectoComeHombres;
import cartas.Jinzo;
import juego.ContenedorDeCartas;

public class EstadoTest {

	@Test
	public void testPuntosAsociadosACartaMonstruoEnModoAtaque() {
		Jinzo jinzo = new Jinzo();
		ContenedorDeCartas sacrificios = new ContenedorDeCartas(1);
		sacrificios.agregar(new InsectoComeHombres() );
		
		jinzo.colocarEnModoAtaque(sacrificios);
		assertEquals(2400, jinzo.puntosAUtilizarSegunEstado());
	}

	@Test
	public void testPuntosAsociadosACartaMonstruoEnModoDefensa() {
		Jinzo jinzo = new Jinzo();
		jinzo.colocarEnModoDefensa();
		assertEquals(1500, jinzo.puntosAUtilizarSegunEstado());
	}

}
