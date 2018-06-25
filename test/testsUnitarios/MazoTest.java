package testsUnitarios;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import cartas.Carta;
import cartas.Jinzo;
import juego.Mazo;

public class MazoTest {

	@Test
	public void testTomarUnaCartaSeRemueveUnaCartaDeMazoYAlPreguntarSiEsaCartaEstaDentroDevuelveFalse() {
		Carta unaCarta = new Jinzo();
		Mazo mazo = new Mazo();
		mazo.agregar(unaCarta);
		mazo.tomarUnaCarta();

		assertFalse(mazo.estaDentro(unaCarta));
	}
}
