package testsIntegracion;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cartas.AgujeroOscuro;
import cartas.CabezaExodia;
import cartas.InsectoComeHombres;
import juego.Campo;
import juego.Jugador;
import juego.Mazo;

public class AtaqueTest {

	@Test
	public void testJugadorAAtacaConUnMonstruoMasFuerteQueElDeBAmbosEnModoAtaqueSeDestruyeElDeBYSeLastimaB() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();

		CabezaExodia exodiaCabeza = new CabezaExodia();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();

		mazoA.agregar(exodiaCabeza);
		mazoB.agregar(insectoComeHombres);

		Campo campoA = new Campo(mazoA);
		Campo campoB = new Campo(mazoB);
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		exodiaCabeza.asignarDuenio(jugadorA);
		insectoComeHombres.asignarDuenio(jugadorB);

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		exodiaCabeza.invocarEnModoAtaque();
		insectoComeHombres.invocarEnModoAtaque();

		exodiaCabeza.atacar(insectoComeHombres);

		// VIDA DEL JUGADOR B - (ATAQUE DE EXODIA - ATAQUE DE INSECTO)
		int vida = 8000 - (1000 - 450);
		assertTrue(campoB.estaLaCartaEnCementerio(insectoComeHombres));
		assertEquals(vida, jugadorB.vida());
	}

	@Test
	public void testJugadorAAtacaConUnMonstruoMasDebilQueElDeBAmbosEnModoAtaqueSeDestruyeSuPropioMonstruoYSeLastimaA() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CabezaExodia exodiaCabeza = new CabezaExodia();

		mazoA.agregar(insectoComeHombres);
		mazoB.agregar(exodiaCabeza);

		Campo campoA = new Campo(mazoA);
		Campo campoB = new Campo(mazoB);
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		insectoComeHombres.asignarDuenio(jugadorA);
		exodiaCabeza.asignarDuenio(jugadorB);

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		insectoComeHombres.invocarEnModoAtaque();
		exodiaCabeza.invocarEnModoAtaque();

		insectoComeHombres.atacar(exodiaCabeza);

		// VIDA DEL JUGADOR A - (ATAQUE DE DRAGON - ATAQUE DE INSECTO)
		int vida = 8000 - (1000 - 450);
		assertTrue(campoA.estaLaCartaEnCementerio(insectoComeHombres));
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

		Campo campoA = new Campo(mazoA);
		Campo campoB = new Campo(mazoB);
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		insectoComeHombres.asignarDuenio(jugadorA);
		otroInsectoComeHombres.asignarDuenio(jugadorB);

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		insectoComeHombres.invocarEnModoAtaque();
		otroInsectoComeHombres.invocarEnModoAtaque();

		insectoComeHombres.atacar(otroInsectoComeHombres);

		int vida = 8000;
		assertTrue(campoA.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(campoB.estaLaCartaEnCementerio(otroInsectoComeHombres));
		assertEquals(vida, jugadorA.vida());
		assertEquals(vida, jugadorB.vida());
	}

	@Test
	public void testJugadorAAtacaConUnMonstruoMasDebilAlDeBEnModoDefensaSeDestruyeElMonstruoDeAYNadieSeLastima() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CabezaExodia exodiaCabeza = new CabezaExodia();

		mazoA.agregar(insectoComeHombres);
		mazoB.agregar(exodiaCabeza);

		Campo campoA = new Campo(mazoA);
		Campo campoB = new Campo(mazoB);
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		insectoComeHombres.asignarDuenio(jugadorA);
		exodiaCabeza.asignarDuenio(jugadorB);

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		insectoComeHombres.invocarEnModoAtaque();
		exodiaCabeza.invocarEnModoDefensa();

		insectoComeHombres.atacar(exodiaCabeza);

		int vida = 8000;
		assertTrue(campoA.estaLaCartaEnCementerio(insectoComeHombres));
		assertEquals(vida, jugadorA.vida());
		assertEquals(vida, jugadorB.vida());
	}

	@Test
	public void testJugadorAAtacaConUnMonstruoMasFuerteAlDeBEnModoDefensaSeDestruyeElMonstruoDeBYNadieSeLastima() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CabezaExodia exodiaCabeza = new CabezaExodia();

		mazoA.agregar(exodiaCabeza);
		mazoB.agregar(insectoComeHombres);

		Campo campoA = new Campo(mazoA);
		Campo campoB = new Campo(mazoB);
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		exodiaCabeza.asignarDuenio(jugadorA);
		insectoComeHombres.asignarDuenio(jugadorB);

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		exodiaCabeza.invocarEnModoAtaque();
		insectoComeHombres.invocarEnModoDefensa();

		exodiaCabeza.atacar(insectoComeHombres);

		int vida = 8000;
		assertTrue(campoB.estaLaCartaEnCementerio(insectoComeHombres));
		assertEquals(vida, jugadorA.vida());
		assertEquals(vida, jugadorB.vida());
	}

	@Test
	public void testJugadorADestruyeTodosLosMonstruosConAgujeroOscuro() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CabezaExodia exodiaCabeza = new CabezaExodia();
		AgujeroOscuro agujeroOscuro = new AgujeroOscuro();

		mazoA.agregar(insectoComeHombres);
		mazoA.agregar(agujeroOscuro);
		mazoB.agregar(exodiaCabeza);

		Campo campoA = new Campo(mazoA);
		Campo campoB = new Campo(mazoB);
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		insectoComeHombres.asignarDuenio(jugadorA);
		exodiaCabeza.asignarDuenio(jugadorB);
		agujeroOscuro.asignarDuenio(jugadorA);

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		insectoComeHombres.invocarEnModoAtaque();
		exodiaCabeza.invocarEnModoDefensa();

		jugadorA.tomarCartaDelMazo();
		agujeroOscuro.colocarBocaArriba();

		agujeroOscuro.activar();

		assertTrue(campoA.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(campoB.estaLaCartaEnCementerio(exodiaCabeza));
	}

}
