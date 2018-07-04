package testsUnitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cartas.CabezaExodia;
import cartas.Carta;
import cartas.CartaMonstruo;
import cartas.InsectoComeHombres;
import cartas.OllaDeLaCodicia;
import cartas.Sogen;
import excepciones.MazoSinCartasException;
import juego.Campo;
import juego.ContenedorDeCartas;
import juego.Mazo;

public class CampoTest {
	
	@Test (expected = MazoSinCartasException.class)
	public void testTomarUnaCartaDelMazoCuandoNoTieneCartaDevuelveExcepcion() {
		Campo campo = new Campo(new Mazo());
		
		campo.tomarUnaCartaDelMazo();
	}
	
	@Test 
	public void testTomarUnaCartaDelMazoCuandoTieneUnaUnicaCartaDevuelveLaMisma() {
		Mazo mazo = new Mazo();
		mazo.agregar(new InsectoComeHombres());
		Campo campo = new Campo(mazo);
		
		Carta carta = campo.tomarUnaCartaDelMazo();
		assertEquals(carta.obtenerNombre(), "Insecto Come Hombres");
	}
	
	@Test
	public void testEstaDentroDevuelveTrueCuandoEstaLaCartaEnELCampo() {
		Campo campo = new Campo( new Mazo() );
		ContenedorDeCartas zonaMonstruos = campo.obtenerZonaMonstruos();
		
		CartaMonstruo monstruo = new InsectoComeHombres();
		zonaMonstruos.agregar(monstruo);
		
		assertTrue(campo.estaDentro(monstruo));
	}
	
	@Test
	public void testEstaDentroDevuelveFalseCuandoNoEstaLaCartaEnELCampo() {
		Campo campo = new Campo( new Mazo() );
		
		assertFalse(campo.estaDentro(new InsectoComeHombres()));
	}
	
	@Test
	public void testTieneCartasEnElMazoDevuelveTrueCuandoHayUnaCarta() {
		Mazo mazo = new Mazo();
		mazo.agregar(new InsectoComeHombres());
		
		Campo campo = new Campo( mazo );
		
        assertTrue(campo.tieneCartasEnElMazo());
	}
	
	@Test
	public void testTieneCartasEnElMazoDevuelveTrueCuandoHayMasde1Carta() {
		Mazo mazo = new Mazo();
		mazo.agregar(new InsectoComeHombres());
		mazo.agregar(new OllaDeLaCodicia());
		mazo.agregar(new Sogen());
		
		Campo campo = new Campo( mazo );
		
        assertTrue(campo.tieneCartasEnElMazo());
	}

	
	@Test
	public void testTieneCartasEnElMazoDevuelveFalseCuandoNoHayCartas() {
		Campo campo = new Campo( new Mazo() );
		
        assertFalse(campo.tieneCartasEnElMazo());
	}
	
	@Test
	public void testObtenerElMonstruoDeMenorAtaqueEntreExodiaCabezaEInsectoComeHombresDevuelveAlInsecto() {
		Campo campo = new Campo( new Mazo() );
		
		ContenedorDeCartas zonaMonstruos = campo.obtenerZonaMonstruos();
		zonaMonstruos.agregar(new InsectoComeHombres());
		zonaMonstruos.agregar(new CabezaExodia());
		
		CartaMonstruo monstruo = campo.obtenerElMonstruoDeMenorAtaque();
        assertEquals(monstruo.obtenerNombre(), "Insecto Come Hombres");
	}
}
