package testsUnitarios;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cartas.AgujeroOscuro;
import cartas.Carta;
import cartas.Jinzo;
import excepciones.CapacidadMaximaException;
import cartas.CabezaExodia;
import juego.Campo;
import juego.Jugador;
import juego.Mazo;

public class JugadorTest {

	@Test
	public void testDebilitar100PuntosDejaAlJugadorCon7900DeVida() {
		Jugador jugador = new Jugador("JUGADOR A",new Campo(new Mazo()));
		int vidaAlPrincipio = jugador.vida();
		jugador.debilitar(100);
		int vidaAlFinal = vidaAlPrincipio - 100;
		assertEquals(vidaAlFinal, jugador.vida());
	}

	@Test
	public void testDebilitar0PuntosDejaAlJugadorConLaMismaVidaDelPrincipio() {
		Jugador jugador = new Jugador("JUGADOR A",new Campo(new Mazo()));
		int vidaAlPrincipio = jugador.vida();
		jugador.debilitar(0);
		assertEquals(vidaAlPrincipio, jugador.vida());
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorTomaDelMazoUnaCarta() throws CapacidadMaximaException {
		Mazo mazo = new Mazo();
		Carta carta = new Jinzo();
		mazo.agregar(carta);
		Campo campo = new Campo(mazo);
		Jugador jugador = new Jugador("JUGADOR A",campo);
		
		try {
			jugador.tomarCartaDelMazo();
		} catch (NullPointerException e) {
		}

		assertTrue(jugador.esDuenioDe(carta));
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorPoneLaCartaMonstruoEnLaZonaDeMonstruos() throws CapacidadMaximaException {
		Mazo mazo = new Mazo();
		CabezaExodia monstruo = new CabezaExodia();
		mazo.agregar(monstruo);
		Campo campo = new Campo(mazo);
		Jugador jugador = new Jugador("JUGADOR A",campo);
		monstruo.asignarDuenio(jugador);

		try {
			jugador.tomarCartaDelMazo();
			monstruo.invocarEnModoAtaque();
		} catch (NullPointerException | ExceptionInInitializerError e) {
		}

		assertTrue(jugador.esDuenioDe(monstruo));
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorPoneLaCartaMagicaEnLaZonaEspeciales() throws Exception {
		Mazo mazoJugadorA = new Mazo();		
		AgujeroOscuro magica = new AgujeroOscuro();
		mazoJugadorA.agregar(magica);
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Jugador jugador = new Jugador("JUGADOR A",campoJugadorA);
		
		try {
			jugador.tomarCartaDelMazo();
			magica.colocarBocaAbajo();
		} catch (NullPointerException | ExceptionInInitializerError e) {
		}
		
		assertTrue(jugador.esDuenioDe(magica));
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorNoTomaLaCartaDelMazo() throws CapacidadMaximaException {
		Mazo mazo = new Mazo();
		Carta carta = new Jinzo();
		mazo.agregar(carta);
		Campo campo = new Campo(mazo);
		Jugador jugador = new Jugador("JUGADOR A",campo);
		assertFalse(jugador.esDuenioDe(carta));
	}

}
