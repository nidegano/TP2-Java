package testsUnitarios;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cartas.Carta;
import cartas.Jinzo;
import excepciones.CapacidadMaximaException;
import excepciones.CartaNoEstaEnContenedorDeCartasException;
import excepciones.ContenedorDeCartasVacioException;
import juego.ContenedorDeCartas;

public class ContenedorDeCartasTest {

	@Test
	public void testAgregarSeAgregaUnCartaYAlUsarEstaDentroDevuelveTrue() throws CapacidadMaximaException {
		Carta unaCarta = new Jinzo();
		ContenedorDeCartas contenedor = new ContenedorDeCartas(5);
		contenedor.agregar(unaCarta);
		assertTrue(contenedor.estaDentro(unaCarta));
	}

	@Test(expected = CapacidadMaximaException.class)
	public void testAgregarSeAgreganMasCartasQueLaCapacidadYTiraUnaCapacidadMaximaException() throws CapacidadMaximaException {
		ContenedorDeCartas contenedor = new ContenedorDeCartas(3);
		contenedor.agregar(new Jinzo());
		contenedor.agregar(new Jinzo());
		contenedor.agregar(new Jinzo());
		contenedor.agregar(new Jinzo());
	}

	@Test 
	public void testAgregarSeAgreganTantasCartasComoLaCapacidadYNoTiraUnaCapacidadMaximaException() throws CapacidadMaximaException {
		ContenedorDeCartas contenedor = new ContenedorDeCartas(3);
		contenedor.agregar(new Jinzo());
		contenedor.agregar(new Jinzo());
		contenedor.agregar(new Jinzo());
		assertTrue(true);
	}

	@Test
	public void testObtenerPrimeroSeAgreganDosCartasYDevuelveLaPrimera() throws CapacidadMaximaException, ContenedorDeCartasVacioException {
		Carta unaCarta = new Jinzo();
		Carta otraCarta = new Jinzo();
		ContenedorDeCartas contenedor = new ContenedorDeCartas(5);
		contenedor.agregar(unaCarta);
		contenedor.agregar(otraCarta);
		assertEquals(unaCarta, contenedor.obtenerPrimero());
	}

	@Test(expected = ContenedorDeCartasVacioException.class)
	public void testObtenerPrimeroConContenedorVacioTiraUnaContenedorDeCartasVacioException() throws ContenedorDeCartasVacioException {
		ContenedorDeCartas contenedor = new ContenedorDeCartas(3);
		contenedor.obtenerPrimero();
	}

	@Test
	public void testEstaDentroSeAgreganUnaCartaYCuandoSePreguntaPorEsaCartaDevuelveTrue() throws CapacidadMaximaException {
		Carta unaCarta = new Jinzo();
		ContenedorDeCartas contenedor = new ContenedorDeCartas(5);
		contenedor.agregar(unaCarta);
		assertTrue(contenedor.estaDentro(unaCarta));
	}

	@Test
	public void testEstaDentroSeAgreganUnaCartaYCuandoSePreguntaPorOtraCartaDevuelveFalse() throws CapacidadMaximaException {
		Carta unaCarta = new Jinzo();
		Carta otraCarta = new Jinzo();
		ContenedorDeCartas contenedor = new ContenedorDeCartas(5);
		contenedor.agregar(unaCarta);
		assertFalse(contenedor.estaDentro(otraCarta));
	}

	@Test
	public void testEstaDentroNoSeAgregaNingunaCartaYCuandoSePreguntaPorUnaCartaDevuelveFalse() {
		Carta unaCarta = new Jinzo();
		ContenedorDeCartas contenedor = new ContenedorDeCartas(5);
		assertFalse(contenedor.estaDentro(unaCarta));
	}

	@Test
	public void testRemoverSeRemueveUnaCartaYCuandoSePreguntaEstaDentroSobreEsaCartaDevuelveFalse() throws CapacidadMaximaException, CartaNoEstaEnContenedorDeCartasException {
		Carta unaCarta = new Jinzo();
		ContenedorDeCartas contenedor = new ContenedorDeCartas(5);
		contenedor.agregar(unaCarta);
		contenedor.remover(unaCarta);
		assertFalse(contenedor.estaDentro(unaCarta));
	}

	@Test (expected = CartaNoEstaEnContenedorDeCartasException.class)
	public void testRemoverCuandoSeQuiereRemoverUnaCartaQueNoEstaTiraCartaNoEstaException()
			throws CartaNoEstaEnContenedorDeCartasException {
		ContenedorDeCartas contenedor = new ContenedorDeCartas(3);
		Carta unaCarta = new Jinzo();
		contenedor.remover(unaCarta);
	}

}
