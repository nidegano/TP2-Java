package testsUnitarios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cartas.Carta;
import cartas.Jinzo;
import excepciones.MazoSinCartasException;
import juego.Mazo;

public class MazoTest {

	@Test(expected = MazoSinCartasException.class)
	public void testTomarUnaCartaDelMazoVacioDevelveExcepcion() {
		Mazo mazo = new Mazo();
		mazo.tomarUnaCarta();

	}
	
	@Test
	public void testTomarUnaCartaDelMazoConUnaUnicaCartaDevuelveLaMisma() {
		Mazo mazo = new Mazo();
		
		mazo.agregar(new Jinzo());
		Carta carta = mazo.tomarUnaCarta();
		
		assertEquals("Jinzo", carta.obtenerNombre());
	}

}
