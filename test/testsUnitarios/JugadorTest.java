package testsUnitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cartas.AgujeroOscuro;
import cartas.Carta;
import cartas.ExodiaCabeza;
import excepciones.CartaNoEstaEnCampoException;
import excepciones.CartaNoPuedeIrAlCementerioSinMorirException;
import juego.Jugador;
import juego.Mazo;

public class JugadorTest {

	@Test
	public void testDebilitar100PuntosDejaAlJugadorCon7900DeVida() {
		Jugador jugador = new Jugador(new Mazo());
		int vidaAlPrincipio = jugador.vida();
		jugador.debilitar(100);
		int vidaAlFinal = vidaAlPrincipio - 100;

		assertEquals(vidaAlFinal, jugador.vida());
	}

	@Test
	public void testDebilitar0PuntosDejaAlJugadorConLaMismaVidaDelPrincipio() {
		Jugador jugador = new Jugador(new Mazo());
		int vidaAlPrincipio = jugador.vida();
		jugador.debilitar(0);

		assertEquals(vidaAlPrincipio, jugador.vida());
	}

	@Test
	public void testColocarCartaMonstruoEnModoAtaquePoneACartaMonstruoEnModoAtaque() {
		Mazo mazo = new Mazo();
		ExodiaCabeza monstruo = new ExodiaCabeza();
		mazo.agregar(monstruo);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();
		jugador.colocarCartaMonstruoEnModoAtaque(monstruo);

		assertTrue(monstruo.estaEnModoAtaque());
	}

	@Test
	public void testColocarCartaMonstruoEnModoDefensaPoneACartaMonstruoEnModoDefensa() {
		Mazo mazo = new Mazo();
		ExodiaCabeza monstruo = new ExodiaCabeza();
		mazo.agregar(monstruo);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();
		jugador.colocarCartaMonstruoEnModoDefensa(monstruo);

		assertTrue(monstruo.estaEnModoDefensa());
	}

	@Test
	public void testColocarCartaMagicaBocaArribaPoneACartaMagicaBocaArriba() {
		Mazo mazo = new Mazo();
		AgujeroOscuro monstruo = new AgujeroOscuro();
		mazo.agregar(monstruo);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();
		jugador.colocarCartaMagicaBocaArriba(monstruo);

		assertTrue(monstruo.estaBocaArriba());
	}

	@Test
	public void testSacrificarMonstruoSinPonerloEnElCampoTiraCartaNoEstaEnCampoException() {
		Mazo mazo = new Mazo();
		ExodiaCabeza monstruo = new ExodiaCabeza();
		mazo.agregar(monstruo);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();

		try {
			jugador.sacrificarMonstruo(monstruo);
			assertTrue(false);
		} catch (CartaNoEstaEnCampoException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testSacrificarMonstruoHabiendoloPuestoEnElCampoYElMonstruoMuere() {
		Mazo mazo = new Mazo();
		ExodiaCabeza monstruo = new ExodiaCabeza();
		mazo.agregar(monstruo);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(monstruo);
		jugador.sacrificarMonstruo(monstruo);

		assertTrue(monstruo.estaMuerta());
	}

	@Test
	public void testEnviarCartaMonstruoAlCementerioSinQueElMonstruoEsteMuertoTiraCartaNoPuedeIrAlCementerioSinMorirException() {
		Mazo mazo = new Mazo();
		ExodiaCabeza monstruo = new ExodiaCabeza();
		mazo.agregar(monstruo);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();

		try {
			jugador.enviarCartaMonstruoAlCementerio(monstruo);
			assertTrue(false);
		} catch (CartaNoPuedeIrAlCementerioSinMorirException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testDestruirCartasEnCampoSeColocaDosCartaMonstruoEnCampoYMueren() {
		Mazo mazo = new Mazo();
		ExodiaCabeza monstruo1 = new ExodiaCabeza();
		ExodiaCabeza monstruo2 = new ExodiaCabeza();
		mazo.agregar(monstruo1);
		mazo.agregar(monstruo2);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(monstruo1);
		jugador.colocarCartaMonstruoEnModoAtaque(monstruo2);
		jugador.destruirCartasEnCampo();

		assertTrue(monstruo1.estaMuerta());
		assertTrue(monstruo2.estaMuerta());
	}

	@Test
	public void testDestruirCartasEnCampoSeColocaDosCartaMagicasEnCampoYMueren() {
		Mazo mazo = new Mazo();
		AgujeroOscuro magica1 = new AgujeroOscuro();
		AgujeroOscuro magica2 = new AgujeroOscuro();
		mazo.agregar(magica1);
		mazo.agregar(magica2);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMagicaBocaArriba(magica1); // se coloca en el campo
		jugador.colocarCartaMagicaBocaArriba(magica2); // se coloca en el campo
		jugador.destruirCartasEnCampo();

		assertTrue(magica1.estaMuerta());
		assertTrue(magica2.estaMuerta());
	}

	@Test
	public void testEnviarCartasMuertasAlCementerioSeSeMatanDosCartaMonstruoDeTresYAparecenEnElCementerio() {
		Mazo mazo = new Mazo();
		ExodiaCabeza monstruo1 = new ExodiaCabeza();
		ExodiaCabeza monstruo2 = new ExodiaCabeza();
		ExodiaCabeza monstruo3 = new ExodiaCabeza();
		mazo.agregar(monstruo1);
		mazo.agregar(monstruo2);
		mazo.agregar(monstruo3);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(monstruo1); // se coloca en el campo
		jugador.colocarCartaMonstruoEnModoAtaque(monstruo2); // se coloca en el campo
		jugador.colocarCartaMonstruoEnModoAtaque(monstruo3); // se coloca en el campo

		monstruo1.matar();
		monstruo2.matar();

		jugador.enviarCartasMuertasAlCementerio();

		assertTrue(jugador.estaLaCartaEnCementerio(monstruo1));
		assertTrue(jugador.estaLaCartaEnCementerio(monstruo2));
		assertFalse(jugador.estaLaCartaEnCementerio(monstruo3));
	}

	@Test
	public void testEnviarCartasMuertasAlCementerioSeSeMatanDosCartaMagicasDeTresYAparecenEnElCementerio() {
		Mazo mazo = new Mazo();
		AgujeroOscuro magica1 = new AgujeroOscuro();
		AgujeroOscuro magica2 = new AgujeroOscuro();
		AgujeroOscuro magica3 = new AgujeroOscuro();
		mazo.agregar(magica1);
		mazo.agregar(magica2);
		mazo.agregar(magica3);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMagicaBocaArriba(magica1); // se coloca en el campo
		jugador.colocarCartaMagicaBocaArriba(magica2); // se coloca en el campo
		jugador.colocarCartaMagicaBocaArriba(magica3); // se coloca en el campo

		magica1.matar();
		magica2.matar();

		jugador.enviarCartasMuertasAlCementerio();

		assertTrue(jugador.estaLaCartaEnCementerio(magica1));
		assertTrue(jugador.estaLaCartaEnCementerio(magica2));
		assertFalse(jugador.estaLaCartaEnCementerio(magica3));
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorTomaDelMazoUnaCarta() {
		Mazo mazo = new Mazo();
		Carta carta = new Carta();
		mazo.agregar(carta);

	
		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();
		
		assertTrue(jugador.esDuenioDe(carta));
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorPoneLaCartaMonstruoEnLaZonaDeMonstruos() {
		Mazo mazo = new Mazo();
		ExodiaCabeza monstruo = new ExodiaCabeza();
		mazo.agregar(monstruo);

	
		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();
		jugador.colocarCartaMonstruoEnModoAtaque(monstruo); //coloca la carta en la zona de monstruos
		
		assertTrue(jugador.esDuenioDe(monstruo));
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorPoneLaCartaMagicaEnLaZonaEspeciales () {
		Mazo mazo = new Mazo();
		AgujeroOscuro magica = new AgujeroOscuro();
		mazo.agregar(magica);

	
		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();
		jugador.colocarCartaMagicaBocaArriba(magica); //coloca la carta en la zona de especiales
		
		assertTrue(jugador.esDuenioDe(magica));
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorNoTomaLaCartaDelMazo() {
		Mazo mazo = new Mazo();
		Carta carta = new Carta();
		mazo.agregar(carta);

		Jugador jugador = new Jugador(mazo);
		
		assertFalse(jugador.esDuenioDe(carta));
	}
}
