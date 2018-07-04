package testsUnitarios;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cartas.AgujeroOscuro;
import cartas.Carta;
import cartas.Jinzo;
import cartas.CabezaExodia;
import juego.Campo;
import juego.Juego;
import juego.Jugador;
import juego.JugadorA;
import juego.JugadorB;
import juego.Mazo;
import vista.Vista;

public class JugadorTest {

	@Test
	public void testDebilitar100PuntosDejaAlJugadorCon7900DeVida() {
		Jugador jugador = new JugadorA(new Campo(new Mazo()));
		int vidaAlPrincipio = jugador.vida();
		jugador.debilitar(100);
		int vidaAlFinal = vidaAlPrincipio - 100;

		assertEquals(vidaAlFinal, jugador.vida());
	}

	@Test
	public void testDebilitar0PuntosDejaAlJugadorConLaMismaVidaDelPrincipio() {
		Jugador jugador = new JugadorA(new Campo(new Mazo()));
		int vidaAlPrincipio = jugador.vida();
		jugador.debilitar(0);

		assertEquals(vidaAlPrincipio, jugador.vida());
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorTomaDelMazoUnaCarta() {
		Mazo mazo = new Mazo();
		Carta carta = new Jinzo();
		mazo.agregar(carta);

		Campo campo = new Campo(mazo);

		Jugador jugador = new JugadorA(campo);
		jugador.tomarCartaDelMazo();

		assertTrue(jugador.esDuenioDe(carta));
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorPoneLaCartaMonstruoEnLaZonaDeMonstruos() {
		Mazo mazo = new Mazo();
		CabezaExodia monstruo = new CabezaExodia();
		mazo.agregar(monstruo);

		Campo campo = new Campo(mazo);

		Jugador jugador = new JugadorA(campo);
		monstruo.asignarDuenio(jugador);

		jugador.tomarCartaDelMazo();
		monstruo.invocarEnModoAtaque(); // coloca la carta en la zona de monstruos

		assertTrue(jugador.esDuenioDe(monstruo));
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorPoneLaCartaMagicaEnLaZonaEspeciales() throws Exception {
		
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		
		// Aca van las cartas a agregar al mazo para testeo
		
		AgujeroOscuro magica = new AgujeroOscuro();
		mazoJugadorA.agregar(magica);
		
		//------------------------------------------------

		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		JugadorA jugadorA = new JugadorA(campoJugadorA);
		JugadorB jugadorB = new JugadorB(campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new Vista(jugadorA,jugadorB,juego);
		
		juego.asignarVista(vista);
		mazoJugadorA.asignarVistaCartaACartas(vista);
		mazoJugadorB.asignarVistaCartaACartas(vista);
		//------------------------------------------------
		
		jugadorA.tomarCartaDelMazo();
		magica.colocarBocaAbajo(); // coloca la carta en la zona de especiales

		assertTrue(jugadorA.esDuenioDe(magica));
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorNoTomaLaCartaDelMazo() {
		Mazo mazo = new Mazo();
		Carta carta = new Jinzo();
		mazo.agregar(carta);

		Campo campo = new Campo(mazo);

		Jugador jugador = new JugadorA(campo);

		assertFalse(jugador.esDuenioDe(carta));
	}

}
