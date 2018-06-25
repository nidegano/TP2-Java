package testsUnitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cartas.Carta;
import cartas.CartaDePrueba;
import excepciones.CapacidadMaximaException;
import excepciones.CartaNoEstaEnContenedorDeCartasException;
import excepciones.ContenedorDeCartasVacioException;
import juego.ContenedorDeCartas;

public class ContenedorDeCartasTest {
	
	@Test
	public void testAgregarSeAgregaUnCartaYAlUsarEstaDentroDevuelveTrue() {
		Carta unaCarta = new CartaDePrueba();
		ContenedorDeCartas contenedor = new ContenedorDeCartas(5);
		
		contenedor.agregar(unaCarta);
		
		assertTrue(contenedor.estaDentro(unaCarta));		
	}
	
	@Test
	public void testAgregarSeAgreganMasCartasQueLaCapacidadYTiraUnaCapacidadMaximaException() {
		ContenedorDeCartas contenedor = new ContenedorDeCartas(3);
		
		try {
			contenedor.agregar(new CartaDePrueba());
			contenedor.agregar(new CartaDePrueba());
			contenedor.agregar(new CartaDePrueba());
			contenedor.agregar(new CartaDePrueba());
			assertTrue(false);
		}
		catch (CapacidadMaximaException e) {
			assertTrue(true);			
		}
	}
	
	@Test
	public void testAgregarSeAgreganTantasCartasComoLaCapacidadYNoTiraUnaCapacidadMaximaException() {
		ContenedorDeCartas contenedor = new ContenedorDeCartas(3);
	
		try {
			contenedor.agregar(new CartaDePrueba());
			contenedor.agregar(new CartaDePrueba());
			contenedor.agregar(new CartaDePrueba());
			assertTrue(true);
		}
		catch (CapacidadMaximaException e) {
			assertTrue(false);			
		}	
	}
	
	@Test
	public void testObtenerPrimeroSeAgreganDosCartasYDevuelveLaPrimera() {
		Carta unaCarta = new CartaDePrueba();
		Carta otraCarta = new CartaDePrueba();
		ContenedorDeCartas contenedor = new ContenedorDeCartas(5);
		
		contenedor.agregar(unaCarta);
		contenedor.agregar(otraCarta);
		
		assertEquals(unaCarta,contenedor.obtenerPrimero());		
	}
	
	@Test
	public void testObtenerPrimeroConContenedorVacioTiraUnaContenedorDeCartasVacioException() {
		ContenedorDeCartas contenedor = new ContenedorDeCartas(3);
		
		try {
			contenedor.obtenerPrimero();
			assertTrue(false);
		}
		catch (ContenedorDeCartasVacioException e) {
			assertTrue(true);		
		}
	}
	
	@Test
	public void testEstaDentroSeAgreganUnaCartaYCuandoSePreguntaPorEsaCartaDevuelveTrue() {
		Carta unaCarta = new CartaDePrueba();
		ContenedorDeCartas contenedor = new ContenedorDeCartas(5);
		contenedor.agregar(unaCarta);
		
		assertTrue(contenedor.estaDentro(unaCarta));		
	}
	
	@Test
	public void testEstaDentroSeAgreganUnaCartaYCuandoSePreguntaPorOtraCartaDevuelveFalse() {
		Carta unaCarta = new CartaDePrueba();
		Carta otraCarta = new CartaDePrueba();
		ContenedorDeCartas contenedor = new ContenedorDeCartas(5);
		contenedor.agregar(unaCarta);
		
		assertFalse(contenedor.estaDentro(otraCarta));		
	}
	
	@Test
	public void testEstaDentroNoSeAgregaNingunaCartaYCuandoSePreguntaPorUnaCartaDevuelveFalse() {
		Carta unaCarta = new CartaDePrueba();
		ContenedorDeCartas contenedor = new ContenedorDeCartas(5);
		
		assertFalse(contenedor.estaDentro(unaCarta));		
	}
	
	@Test
	public void testRemoverSeRemueveUnaCartaYCuandoSePreguntaEstaDentroSobreEsaCartaDevuelveFalse() {
		Carta unaCarta = new CartaDePrueba();
		ContenedorDeCartas contenedor = new ContenedorDeCartas(5);
		contenedor.agregar(unaCarta);
		contenedor.remover(unaCarta);
		
		assertFalse(contenedor.estaDentro(unaCarta));		
	}
	
	@Test
	public void testRemoverCuandoSeQuiereRemoverUnaCartaQueNoEstaTiraCartaNoEstaException() {
		ContenedorDeCartas contenedor = new ContenedorDeCartas(3);
		Carta unaCarta = new CartaDePrueba();
		
		try {
			contenedor.remover(unaCarta);
			assertTrue(false);
		}
		catch (CartaNoEstaEnContenedorDeCartasException e) {
			assertTrue(true);		
		}		
	}

}
