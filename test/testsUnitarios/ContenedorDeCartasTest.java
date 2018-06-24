package testsUnitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	public void testMatarTodasLasCartasAgrega5CartasAplicaElMetodoYChequeoUnaPorUnaQueTodasLasCartasEstenMuertas() {
		ContenedorDeCartas contenedor = new ContenedorDeCartas(5);
		List<Carta> cartas = this.crearTantasCartas(4);
		this.agregarCartasAContenedor(contenedor,cartas);
		contenedor.matarATodasLasCartas();
		
		assertTrue(this.todasLasCartasEstanMuertas(cartas));
	}
	
	@Test
	public void testEnviarCartasMuertasAlCementerioAgregaVariasCartasLasMataATodasYVerificaQueTodasEstenEnElCementerio() {
		ContenedorDeCartas contenedor = new ContenedorDeCartas(5);
		
		Carta carta1 = new CartaDePrueba();
		Carta carta2 = new CartaDePrueba();
		Carta carta3 = new CartaDePrueba();
		Carta carta4 = new CartaDePrueba();
		
		contenedor.agregar(carta1);
		contenedor.agregar(carta2);
		contenedor.agregar(carta3);
		contenedor.agregar(carta4);
		
		contenedor.matarATodasLasCartas();
		
		ContenedorDeCartas cementerio = new ContenedorDeCartas(5);
		contenedor.enviarCartasMuertasAlCementerio(cementerio);
		
		assertTrue(cementerio.estaDentro(carta1));
		assertTrue(cementerio.estaDentro(carta2));
		assertTrue(cementerio.estaDentro(carta3));
		assertTrue(cementerio.estaDentro(carta4));
	}
	
	@Test
	public void testEnviarCartasMuertasAlCementerioAgregaVariasCartasLasMataAAlgunasYVerificaQueTodasEsasAlgunasEstenEnElCementerio() {
		ContenedorDeCartas contenedor = new ContenedorDeCartas(5);
		
		Carta carta1 = new CartaDePrueba();
		Carta carta2 = new CartaDePrueba();
		Carta carta3 = new CartaDePrueba();
		Carta carta4 = new CartaDePrueba();
		
		contenedor.agregar(carta1);
		contenedor.agregar(carta2);
		contenedor.agregar(carta3);
		contenedor.agregar(carta4);
		
		carta1.matar();
		carta2.matar();
		carta3.matar();
		
		ContenedorDeCartas cementerio = new ContenedorDeCartas(5);
		contenedor.enviarCartasMuertasAlCementerio(cementerio);
		
		assertTrue(cementerio.estaDentro(carta1));
		assertTrue(cementerio.estaDentro(carta2));
		assertTrue(cementerio.estaDentro(carta3));
		assertFalse(cementerio.estaDentro(carta4));
	}

	private boolean todasLasCartasEstanMuertas(List<Carta> cartas) {
		for (Carta carta : cartas) {
			if (!carta.estaMuerta())
				return false;
		}		
		return true;
	}

	private void agregarCartasAContenedor(ContenedorDeCartas contenedor, List<Carta> cartas) {
		for (Carta carta : cartas)
			contenedor.agregar(carta);
	}

	private List<Carta> crearTantasCartas(int cantidad) {
		List<Carta> cartas = new ArrayList<Carta>();
		for (int i = 1; i<=cantidad;i++)
			cartas.add(new CartaDePrueba());
		return cartas;
	}

}
