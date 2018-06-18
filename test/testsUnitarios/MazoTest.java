package testsUnitarios;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

import cartas.Carta;
import juego.Mazo;

public class MazoTest {

	@Test
	public void testTomarUnaCartaSeRemueveUnaCartaDeMazoYAlPreguntarSiEsaCartaEstaDentroDevuelveFalse() {
		Carta unaCarta = new Carta();
		Mazo mazo = new Mazo();
		mazo.agregar(unaCarta);
		mazo.tomarUnaCarta();

		assertFalse(mazo.estaDentro(unaCarta));
	}
}
