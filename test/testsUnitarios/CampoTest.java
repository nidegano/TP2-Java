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
import excepciones.CapacidadMaximaException;
import excepciones.ContenedorDeCartasVacioException;
import excepciones.MazoSinCartasException;
import juego.Campo;
import juego.ContenedorDeCartas;
import juego.Mazo;

public class CampoTest {

	@Test(expected = MazoSinCartasException.class)
	public void testTomarUnaCartaDelMazoCuandoNoTieneCartaDevuelveExcepcion() throws MazoSinCartasException {
		Mazo mazo = new Mazo();
		Campo campo = new Campo(mazo);
		campo.tomarUnaCartaDelMazo();
	}

	@Test
	public void testTomarUnaCartaDelMazoCuandoTieneUnaUnicaCartaDevuelveLaMisma()
			throws CapacidadMaximaException, MazoSinCartasException {
		Mazo mazo = new Mazo();
		mazo.agregar(new InsectoComeHombres());
		Campo campo = new Campo(mazo);
		Carta carta = campo.tomarUnaCartaDelMazo();
		assertEquals(carta.obtenerNombre(), "Insecto Come Hombres");
	}

	@Test
	public void testEstaDentroDevuelveTrueCuandoEstaLaCartaEnELCampo() throws CapacidadMaximaException {
		Campo campo = new Campo(new Mazo());
		ContenedorDeCartas zonaMonstruos = campo.obtenerZonaMonstruos();
		CartaMonstruo monstruo = new InsectoComeHombres();
		zonaMonstruos.agregar(monstruo);
		assertTrue(campo.estaDentro(monstruo));
	}

	@Test
	public void testEstaDentroDevuelveFalseCuandoNoEstaLaCartaEnELCampo() {
		Campo campo = new Campo(new Mazo());
		assertFalse(campo.estaDentro(new InsectoComeHombres()));
	}

	@Test
	public void testTieneCartasEnElMazoDevuelveTrueCuandoHayUnaCarta() throws CapacidadMaximaException {
		Mazo mazo = new Mazo();
		mazo.agregar(new InsectoComeHombres());
		Campo campo = new Campo(mazo);
		assertTrue(campo.tieneCartasEnElMazo());
	}

	@Test
	public void testTieneCartasEnElMazoDevuelveTrueCuandoHayMasde1Carta() throws CapacidadMaximaException {
		Mazo mazo = new Mazo();
		mazo.agregar(new InsectoComeHombres());
		mazo.agregar(new OllaDeLaCodicia());
		mazo.agregar(new Sogen());
		Campo campo = new Campo(mazo);
		assertTrue(campo.tieneCartasEnElMazo());
	}

	@Test
	public void testTieneCartasEnElMazoDevuelveFalseCuandoNoHayCartas() {
		Campo campo = new Campo(new Mazo());

		assertFalse(campo.tieneCartasEnElMazo());
	}

	@Test
	public void testObtenerElMonstruoDeMenorAtaqueEntreExodiaCabezaEInsectoComeHombresDevuelveAlInsecto()
			throws CapacidadMaximaException, ContenedorDeCartasVacioException {
		Campo campo = new Campo(new Mazo());
		ContenedorDeCartas zonaMonstruos = campo.obtenerZonaMonstruos();
		zonaMonstruos.agregar(new InsectoComeHombres());
		zonaMonstruos.agregar(new CabezaExodia());
		CartaMonstruo monstruo = campo.obtenerElMonstruoDeMenorAtaque();
		assertEquals(monstruo.obtenerNombre(), "Insecto Come Hombres");
	}

}
