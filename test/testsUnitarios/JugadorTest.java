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
	public void testColocarCartaMonstruoEnModoAtaquePoneACartaMonstruoEnModoAtaque() {
		Mazo mazo = new Mazo();
		CabezaExodia monstruo = new CabezaExodia();
		mazo.agregar(monstruo);
		
		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		jugador.tomarCartaDelMazo();
		jugador.colocarCartaMonstruoEnModoAtaque(monstruo);

		assertTrue(monstruo.estaEnModoAtaque());
	}

	@Test
	public void testColocarCartaMonstruoEnModoDefensaPoneACartaMonstruoEnModoDefensa() {
		Mazo mazo = new Mazo();
		CabezaExodia monstruo = new CabezaExodia();
		mazo.agregar(monstruo);

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		jugador.tomarCartaDelMazo();
		jugador.colocarCartaMonstruoEnModoDefensa(monstruo);

		assertTrue(monstruo.estaEnModoDefensa());
	}

	@Test
	public void testColocarCartaMagicaBocaArribaPoneACartaMagicaBocaArriba() {
		Mazo mazo = new Mazo();
		AgujeroOscuro monstruo = new AgujeroOscuro();
		mazo.agregar(monstruo);

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		jugador.tomarCartaDelMazo();
		jugador.colocarCartaMagicaBocaArriba(monstruo);

		assertTrue(monstruo.estaBocaArriba());
	}

	@Test
	public void testDestruirCartasEnCampoSeColocaDosCartaMonstruoEnCampoYMueren() {
		Mazo mazo = new Mazo();
		CabezaExodia monstruo1 = new CabezaExodia();
		CabezaExodia monstruo2 = new CabezaExodia();
		mazo.agregar(monstruo1);
		mazo.agregar(monstruo2);

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
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

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
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
		CabezaExodia monstruo1 = new CabezaExodia();
		CabezaExodia monstruo2 = new CabezaExodia();
		CabezaExodia monstruo3 = new CabezaExodia();
		mazo.agregar(monstruo1);
		mazo.agregar(monstruo2);
		mazo.agregar(monstruo3);

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(monstruo1); // se coloca en el campo
		jugador.colocarCartaMonstruoEnModoAtaque(monstruo2); // se coloca en el campo
		jugador.colocarCartaMonstruoEnModoAtaque(monstruo3); // se coloca en el campo

		monstruo1.matar();
		monstruo2.matar();

		assertTrue(campo.estaLaCartaEnCementerio(monstruo1));
		assertTrue(campo.estaLaCartaEnCementerio(monstruo2));
		assertFalse(campo.estaLaCartaEnCementerio(monstruo3));
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

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMagicaBocaArriba(magica1); // se coloca en el campo
		jugador.colocarCartaMagicaBocaArriba(magica2); // se coloca en el campo
		jugador.colocarCartaMagicaBocaArriba(magica3); // se coloca en el campo

		magica1.matar();
		magica2.matar();

		assertTrue(campo.estaLaCartaEnCementerio(magica1));
		assertTrue(campo.estaLaCartaEnCementerio(magica2));
		assertFalse(campo.estaLaCartaEnCementerio(magica3));
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
		jugador.tomarCartaDelMazo();
		jugador.colocarCartaMonstruoEnModoAtaque(monstruo); //coloca la carta en la zona de monstruos
		
		assertTrue(jugador.esDuenioDe(monstruo));
	}

	@Test
	public void testEsDuenioDevuelveTrueCuandoJugadorPoneLaCartaMagicaEnLaZonaEspeciales () {
		Mazo mazo = new Mazo();
		AgujeroOscuro magica = new AgujeroOscuro();
		mazo.agregar(magica);

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		jugador.tomarCartaDelMazo();
		jugador.colocarCartaMagicaBocaArriba(magica); //coloca la carta en la zona de especiales
		
		assertTrue(jugador.esDuenioDe(magica));
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
