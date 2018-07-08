package testsUnitarios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import juego.Campo;
import juego.Jugador;
import juego.Mazo;
import juego.Restar;

public class TestRestar {

	@Test
	public void testAfectarLeRestaALaVidaAlJugador() {
		Jugador jugador = new Jugador("JUGADOR A",new Campo(new Mazo()));
		Restar restar = new Restar(2000);
		int esperado = 8000 - 2000;
		restar.afectar(jugador);
		assertEquals(esperado, jugador.vida());
	}

}
