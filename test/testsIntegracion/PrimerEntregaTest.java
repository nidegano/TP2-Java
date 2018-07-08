package testsIntegracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import cartas.*;
import excepciones.*;
import juego.*;
import vista.Vista;
import vista.VistaMock;

public class PrimerEntregaTest {

	@Test
	public void testColocarCartaMonstruoEnModoAtaque() throws Exception {
		Mazo mazo = new Mazo();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		mazo.agregar(insectoComeHombres);
		Campo campo = new Campo(mazo);
		Jugador jugadorA = new Jugador("JUGADOR A",campo);
		insectoComeHombres.asignarDuenio(jugadorA);
		
		try {
			jugadorA.tomarCartaDelMazo();
		} catch (NullPointerException e) {
		}
		insectoComeHombres.invocarEnModoAtaque();

		assertEquals(450, insectoComeHombres.puntosAUtilizarSegunEstado());
	}

	@Test
	public void testColocarCartaMonstruoEnModoDefensa() throws CapacidadMaximaException {
		Mazo mazo = new Mazo();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		mazo.agregar(insectoComeHombres);
		Campo campo = new Campo(mazo);
		Jugador jugadorA = new Jugador("JUGADOR A",campo);
		insectoComeHombres.asignarDuenio(jugadorA);

		try {
			jugadorA.tomarCartaDelMazo();
		} catch (NullPointerException e) {
		}
		insectoComeHombres.invocarEnModoDefensa();

		assertEquals(600, insectoComeHombres.puntosAUtilizarSegunEstado());
	}

	@Test
	public void testMuereMonstruoYApareceEnCementerio() throws Exception {
		Mazo mazoA = new Mazo();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		mazoA.agregar(insectoComeHombres);
		Campo campoA = new Campo(mazoA);
		Jugador jugadorA = new Jugador("JUGADOR A",campoA);
		insectoComeHombres.asignarDuenio(jugadorA);
		
		Mazo mazoB = new Mazo();
		Campo campoB = new Campo(mazoB);
		Jugador jugadorB = new Jugador("JUGADOR B",campoB);

		Juego juego = new Juego(jugadorA, jugadorB);
		Vista vista = null;
		try {
			vista = new Vista(jugadorA, jugadorB, juego);
		} catch (NullPointerException | ExceptionInInitializerError e) {
		}
		juego.asignarVista(vista);
		
		insectoComeHombres.matar();

		assertTrue(campoA.estaLaCartaEnCementerio(insectoComeHombres));
	}

	@Test
	public void testInvocarUnaCartaMonstruoDe5EstrellasSacrificaAUnMonstruoDelJugadorQueLoInvoca() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		
		mazoJugadorA.agregar(insectoComeHombres);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		insectoComeHombres.invocarEnModoAtaque();

		ArrayList<CartaMonstruo> sacrificios = new ArrayList<CartaMonstruo>();
		sacrificios.add(insectoComeHombres);
		EspadachinSilencioso espadachinSilencioso = new EspadachinSilencioso();
		mazoJugadorA.agregar(espadachinSilencioso);
		espadachinSilencioso.asignarDuenio(jugadorA);

		mazoJugadorA.agregar(espadachinSilencioso);
		jugadorA.tomarCartaDelMazo();
		espadachinSilencioso.invocarEnModoAtaque(sacrificios);

		assertTrue(campoJugadorA.estaLaCartaEnCementerio(insectoComeHombres));
	}

	@Test
	public void testInvocarUnaCartaMonstruoDe7EstrellasSacrificaADosMonstruosDelJugadorQueLoInvoca() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		InsectoComeHombres otroInsectoComeHombres = new InsectoComeHombres();

		mazoJugadorA.agregar(insectoComeHombres);
		mazoJugadorA.agregar(otroInsectoComeHombres);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();

		insectoComeHombres.invocarEnModoAtaque();
		otroInsectoComeHombres.invocarEnModoAtaque();

		ArrayList<CartaMonstruo> sacrificios = new ArrayList<CartaMonstruo>();
		sacrificios.add(insectoComeHombres);
		sacrificios.add(otroInsectoComeHombres);
		DragonArmadoOscuro dragonArmadoOscuro = new DragonArmadoOscuro();
		dragonArmadoOscuro.asignarDuenio(jugadorA);
		mazoJugadorA.agregar(dragonArmadoOscuro);

		jugadorA.tomarCartaDelMazo();
		dragonArmadoOscuro.invocarEnModoAtaque(sacrificios);

		assertTrue(campoJugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(campoJugadorA.estaLaCartaEnCementerio(otroInsectoComeHombres));
	}

	@Test
	public void testInvocarUnaCartaMonstruoDe8EstrellasSacrificaADosMonstruosDelJugadorQueLoInvoca() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		InsectoComeHombres otroInsectoComeHombres = new InsectoComeHombres();

		mazoJugadorA.agregar(insectoComeHombres);
		mazoJugadorA.agregar(otroInsectoComeHombres);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();

		insectoComeHombres.invocarEnModoAtaque();
		otroInsectoComeHombres.invocarEnModoAtaque();

		ArrayList<CartaMonstruo> sacrificios = new ArrayList<CartaMonstruo>();
		sacrificios.add(insectoComeHombres);
		sacrificios.add(otroInsectoComeHombres);
		DragonBlancoDeOjosAzules dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
		dragonBlancoDeOjosAzules.asignarDuenio(jugadorA);

		mazoJugadorA.agregar(dragonBlancoDeOjosAzules);
		jugadorA.tomarCartaDelMazo();
		dragonBlancoDeOjosAzules.invocarEnModoAtaque(sacrificios);

		assertTrue(campoJugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(campoJugadorA.estaLaCartaEnCementerio(otroInsectoComeHombres));
	}

	@Test
	public void testJugadorAAtacaConUnMonstruoMasFuerteQueElDeBAmbosEnModoAtaqueSeDestruyeElDeBYSeLastimaB() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		CabezaExodia exodiaCabeza = new CabezaExodia();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();

		mazoJugadorA.agregar(exodiaCabeza);
		mazoJugadorB.agregar(insectoComeHombres);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		exodiaCabeza.invocarEnModoAtaque();
		insectoComeHombres.invocarEnModoAtaque();

		exodiaCabeza.atacar(insectoComeHombres);

		// VIDA DEL JUGADOR B - (ATAQUE DE EXODIA - ATAQUE DE INSECTO)
		int vida = 8000 - (1000 - 450);
		assertTrue(campoJugadorB.estaLaCartaEnCementerio(insectoComeHombres));
		assertEquals(vida, jugadorB.vida());
	}

	@Test
	public void testJugadorAAtacaConUnMonstruoMasDebilQueElDeBAmbosEnModoAtaqueSeDestruyeSuPropioMonstruoYSeLastimaA() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CabezaExodia exodiaCabeza = new CabezaExodia();

		mazoJugadorA.agregar(insectoComeHombres);
		mazoJugadorB.agregar(exodiaCabeza);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		insectoComeHombres.invocarEnModoAtaque();
		exodiaCabeza.invocarEnModoAtaque();

		insectoComeHombres.atacar(exodiaCabeza);

		// VIDA DEL JUGADOR A - (ATAQUE DE DRAGON - ATAQUE DE INSECTO)
		int vida = 8000 - (1000 - 450);
		assertTrue(campoJugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertEquals(vida, jugadorA.vida());
	}

	@Test
	public void testJugadorAAtacaConUnMonstruoIgualDeFuerteQueElDeBEnModoAtaqueSeDestruyenAmbosMonstruosYNadieSeLastima() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		InsectoComeHombres otroInsectoComeHombres = new InsectoComeHombres();

		mazoJugadorA.agregar(insectoComeHombres);
		mazoJugadorB.agregar(otroInsectoComeHombres);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////
		
		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		insectoComeHombres.invocarEnModoAtaque();
		otroInsectoComeHombres.invocarEnModoAtaque();

		insectoComeHombres.atacar(otroInsectoComeHombres);

		int vida = 8000;
		assertTrue(campoJugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(campoJugadorB.estaLaCartaEnCementerio(otroInsectoComeHombres));
		assertEquals(vida, jugadorA.vida());
		assertEquals(vida, jugadorB.vida());
	}

	@Test
	public void testJugadorAAtacaConUnMonstruoMasDebilAlDeBEnModoDefensaSeDestruyeElMonstruoDeAYNadieSeLastima() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CabezaExodia exodiaCabeza = new CabezaExodia();

		mazoJugadorA.agregar(insectoComeHombres);
		mazoJugadorB.agregar(exodiaCabeza);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		insectoComeHombres.invocarEnModoAtaque();
		exodiaCabeza.invocarEnModoDefensa();

		insectoComeHombres.atacar(exodiaCabeza);

		int vida = 8000;
		assertTrue(campoJugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertEquals(vida, jugadorA.vida());
		assertEquals(vida, jugadorB.vida());
	}

	@Test
	public void testJugadorAAtacaConUnMonstruoMasFuerteAlDeBEnModoDefensaSeDestruyeElMonstruoDeBYNadieSeLastima() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CabezaExodia exodiaCabeza = new CabezaExodia();
		
		mazoJugadorA.agregar(exodiaCabeza);
		mazoJugadorB.agregar(insectoComeHombres);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		exodiaCabeza.invocarEnModoAtaque();
		insectoComeHombres.invocarEnModoDefensa();

		exodiaCabeza.atacar(insectoComeHombres);

		int vida = 8000;
		assertTrue(campoJugadorB.estaLaCartaEnCementerio(insectoComeHombres));
		assertEquals(vida, jugadorA.vida());
		assertEquals(vida, jugadorB.vida());
	}

	@Test
	public void testJugadorADestruyeTodosLosMonstruosConAgujeroOscuro() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CabezaExodia exodiaCabeza = new CabezaExodia();
		AgujeroOscuro agujeroOscuro = new AgujeroOscuro();

		mazoJugadorA.agregar(insectoComeHombres);
		mazoJugadorA.agregar(agujeroOscuro);
		mazoJugadorB.agregar(exodiaCabeza);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		insectoComeHombres.invocarEnModoAtaque();
		exodiaCabeza.invocarEnModoDefensa();

		jugadorA.tomarCartaDelMazo();
		agujeroOscuro.colocarBocaArriba();

		assertTrue(campoJugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(campoJugadorB.estaLaCartaEnCementerio(exodiaCabeza));
	}

	@Test
	public void testJugadorSeQuedaSinVida() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		AlphaTheMagnetWarrior alpha = new AlphaTheMagnetWarrior();

		mazoJugadorA.agregar(alpha);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();

		alpha.invocarEnModoAtaque();

		// puntosAtaque de alpha = 1400
		// entonces ataco 6 veces para que el oponente se quede sin vida
		alpha.atacarDirectamenteAlOponente();
		alpha.atacarDirectamenteAlOponente();
		alpha.atacarDirectamenteAlOponente();
		alpha.atacarDirectamenteAlOponente();
		alpha.atacarDirectamenteAlOponente();
		alpha.atacarDirectamenteAlOponente();

	}

}
