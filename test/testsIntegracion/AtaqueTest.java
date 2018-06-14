package testsIntegracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cartas.AgujeroOscuro;
import cartas.ExodiaCabeza;
import cartas.InsectoComeHombres;
import juego.Batalla;
import juego.Jugador;
import juego.Mazo;

public class AtaqueTest {

	@Test
	public void testJugadorAAtacaConUnMonstruoMasFuerteQueElDeBAmbosEnModoAtaqueSeDestruyeElDeBYSeLastimaB() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();

		ExodiaCabeza exodiaCabeza = new ExodiaCabeza();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();

		mazoA.agregar(exodiaCabeza);
		mazoB.agregar(insectoComeHombres);

		Jugador jugadorA = new Jugador(mazoA);
		Jugador jugadorB = new Jugador(mazoB);

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		jugadorA.colocarCartaMonstruoEnModoAtaque(exodiaCabeza);
		jugadorB.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);

		Batalla batalla = new Batalla(jugadorA, jugadorB);
		batalla.librarBatalla();

		// VIDA DEL JUGADOR B - (ATAQUE DE DRAGON - ATAQUE DE INSECTO)
		int vida = 8000 - (1000 - 450);
		assertTrue(jugadorB.estaLaCartaEnCementerio(insectoComeHombres));
		assertEquals(vida, jugadorB.vida());
	}

	@Test
	public void testJugadorAAtacaConUnMonstruoMasDebilQueElDeBAmbosEnModoAtaqueSeDestruyeSuPropioMonstruoYSeLastimaA() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		ExodiaCabeza exodiaCabeza = new ExodiaCabeza();

		mazoA.agregar(insectoComeHombres);
		mazoB.agregar(exodiaCabeza);

		Jugador jugadorA = new Jugador(mazoA);
		Jugador jugadorB = new Jugador(mazoB);

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		jugadorA.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugadorB.colocarCartaMonstruoEnModoAtaque(exodiaCabeza);

		Batalla batalla = new Batalla(jugadorA, jugadorB);
		batalla.librarBatalla();

		// VIDA DEL JUGADOR A - (ATAQUE DE DRAGON - ATAQUE DE INSECTO)
		int vida = 8000 - (1000 - 450);
		assertTrue(jugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertEquals(vida, jugadorA.vida());
	}

	@Test
	public void testJugadorAAtacaConUnMonstruoIgualDeFuerteQueElDeBEnModoAtaqueSeDestruyenAmbosMonstruosYNadieSeLastima() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		InsectoComeHombres otroInsectoComeHombres = new InsectoComeHombres();

		mazoA.agregar(insectoComeHombres);
		mazoB.agregar(otroInsectoComeHombres);

		Jugador jugadorA = new Jugador(mazoA);
		Jugador jugadorB = new Jugador(mazoB);

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		jugadorA.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugadorB.colocarCartaMonstruoEnModoAtaque(otroInsectoComeHombres);

		Batalla batalla = new Batalla(jugadorA, jugadorB);
		batalla.librarBatalla();

		int vida = 8000;
		assertTrue(jugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(jugadorB.estaLaCartaEnCementerio(otroInsectoComeHombres));
		assertEquals(vida, jugadorA.vida());
		assertEquals(vida, jugadorB.vida());
	}

	@Test
	public void testJugadorAAtacaConUnMonstruoMasDebilAlDeBEnModoDefensaNingunMonstruoSeDestruyeYNadieSeLastima() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		ExodiaCabeza exodiaCabeza = new ExodiaCabeza();

		mazoA.agregar(insectoComeHombres);
		mazoB.agregar(exodiaCabeza);

		Jugador jugadorA = new Jugador(mazoA);
		Jugador jugadorB = new Jugador(mazoB);

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		jugadorA.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugadorB.colocarCartaMonstruoEnModoDefensa(exodiaCabeza);

		Batalla batalla = new Batalla(jugadorA, jugadorB);
		batalla.librarBatalla();

		int vida = 8000;
		assertFalse(jugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertFalse(jugadorB.estaLaCartaEnCementerio(exodiaCabeza));
		assertEquals(vida, jugadorA.vida());
		assertEquals(vida, jugadorB.vida());
	}

	@Test
	public void testJugadorAAtacaConUnMonstruoMasFuerteAlDeBEnModoDefensaSeDestruyeElMonstruoDeBYNadieSeLastima() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		ExodiaCabeza exodiaCabeza = new ExodiaCabeza();

		mazoA.agregar(exodiaCabeza);
		mazoB.agregar(insectoComeHombres);

		Jugador jugadorA = new Jugador(mazoA);
		Jugador jugadorB = new Jugador(mazoB);

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		jugadorA.colocarCartaMonstruoEnModoAtaque(exodiaCabeza);
		jugadorB.colocarCartaMonstruoEnModoDefensa(insectoComeHombres);

		Batalla batalla = new Batalla(jugadorA, jugadorB);
		batalla.librarBatalla();

		int vida = 8000;
		assertTrue(jugadorB.estaLaCartaEnCementerio(insectoComeHombres));
		assertEquals(vida, jugadorA.vida());
		assertEquals(vida, jugadorB.vida());
	}

	@Test
	public void testJugadorADestruyeTodosLosMonstruosConAgujeroOscuro() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		ExodiaCabeza exodiaCabeza = new ExodiaCabeza();
		AgujeroOscuro agujeroOscuro = new AgujeroOscuro();

		mazoA.agregar(insectoComeHombres);
		mazoA.agregar(agujeroOscuro);
		mazoB.agregar(exodiaCabeza);

		Jugador jugadorA = new Jugador(mazoA);
		Jugador jugadorB = new Jugador(mazoB);

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		jugadorA.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugadorB.colocarCartaMonstruoEnModoDefensa(exodiaCabeza);

		jugadorA.tomarCartaDelMazo();
		jugadorA.colocarCartaMagicaBocaArriba(agujeroOscuro);

		agujeroOscuro.efecto(jugadorA, jugadorB);

		assertTrue(jugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(jugadorB.estaLaCartaEnCementerio(exodiaCabeza));
	}

}
