package testsUnitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cartas.AgujeroOscuro;
import cartas.Carta;
import cartas.CartaDePrueba;
import cartas.CabezaExodia;
import excepciones.CartaNoEstaEnCampoException;
import excepciones.CartaNoPuedeIrAlCementerioSinMorirException;
import juego.Campo;
import juego.Jugador;
import juego.Mazo;

public class JugadorTest {

	@Test
	public void testDebilitar100PuntosDejaAlJugadorCon7900DeVida() {
		Jugador jugador = new Jugador(new Campo(new Mazo()));
		int vidaAlPrincipio = jugador.vida();
		jugador.debilitar(100);
		int vidaAlFinal = vidaAlPrincipio - 100;

		assertEquals(vidaAlFinal, jugador.vida());
	}

	@Test
	public void testDebilitar0PuntosDejaAlJugadorConLaMismaVidaDelPrincipio() {
		Jugador jugador = new Jugador(new Campo(new Mazo()));
		int vidaAlPrincipio = jugador.vida();
		jugador.debilitar(0);

		assertEquals(vidaAlPrincipio, jugador.vida());
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorTomaDelMazoUnaCarta() {
		Mazo mazo = new Mazo();
		Carta carta = new CartaDePrueba();
		mazo.agregar(carta);

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		jugador.tomarCartaDelMazo();
		
		assertTrue(jugador.esDuenioDe(carta));
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorPoneLaCartaMonstruoEnLaZonaDeMonstruos() {
		Mazo mazo = new Mazo();
		CabezaExodia monstruo = new CabezaExodia();
		mazo.agregar(monstruo);

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		monstruo.asignarDuenio(jugador);
		
		jugador.tomarCartaDelMazo();
		monstruo.invocarEnModoAtaque(); //coloca la carta en la zona de monstruos
		
		assertTrue(jugador.esDuenioDe(monstruo));
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorPoneLaCartaMagicaEnLaZonaEspeciales () {
		Mazo mazo = new Mazo();
		AgujeroOscuro magica = new AgujeroOscuro();
		mazo.agregar(magica);

		Campo campo = new Campo(mazo);

		Jugador jugadorA = new Jugador(campo);
		Jugador jugadorB = new Jugador(campo);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		magica.asignarDuenio(jugadorA);
		
		jugadorA.tomarCartaDelMazo();
		magica.colocarBocaArriba(); //coloca la carta en la zona de especiales
		
		assertTrue(jugadorA.esDuenioDe(magica));
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorNoTomaLaCartaDelMazo() {
		Mazo mazo = new Mazo();
		Carta carta = new CartaDePrueba();
		mazo.agregar(carta);

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		
		assertFalse(jugador.esDuenioDe(carta));
	}
}
