package testsUnitarios;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import cartas.Carta;

public class CartaTest {

	@Test
	public void testUnaCartaRecienCreadaNoEstaBocaAbajoBocaArribaNiMuerta() {
		Carta carta = new Carta();

		assertFalse(carta.estaBocaAbajo());
		assertFalse(carta.estaBocaArriba());
		assertFalse(carta.estaMuerta());
	}

	@Test
	public void testEstaBocaAbajoDevuelveTrueCuandoLaColocoBocaAbajo() {
		Carta carta = new Carta();

		carta.colocarBocaAbajo();
		assertTrue(carta.estaBocaAbajo());
	}

	@Test
	public void testEstaBocaAbajoDevuelveFalseCuandoLaColocoBocaArriba() {
		Carta carta = new Carta();

		carta.colocarBocaArriba();
		assertFalse(carta.estaBocaAbajo());
	}

	@Test
	public void testEstaBocaArribaDevuelveTrueCuandoLaColocoBocaArriba() {
		Carta carta = new Carta();

		carta.colocarBocaArriba();
		assertTrue(carta.estaBocaArriba());
	}

	@Test
	public void testEstaBocaArribaDevuelveFalseCuandoLaColocoBocaAbajo() {
		Carta carta = new Carta();

		carta.colocarBocaAbajo();
		assertFalse(carta.estaBocaArriba());
	}

	@Test
	public void testEstaMuertaDevuelveTrueSiLaMato() {
		Carta carta = new Carta();

		carta.matar();
		assertTrue(carta.estaMuerta());
	}

	@Test
	public void testEstaMuertaDevuelveFalseSiLaColocoBocaAbajo() {
		Carta carta = new Carta();

		carta.colocarBocaAbajo();
		assertFalse(carta.estaMuerta());
	}

	@Test
	public void testEstaMuertaDevuelveFalseSiLaColocoBocaArriba() {
		Carta carta = new Carta();

		carta.colocarBocaArriba();
		assertFalse(carta.estaMuerta());
	}
}
