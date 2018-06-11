package testsIntegracion;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import cartas.AgujeroOscuro;
import cartas.DragonBlancoDeOjosAzules;
import cartas.InsectoComeHombres;
import juego.Jugador;
import juego.Mazo;

class AtaqueTest {

	@Test
	void testJugadorADestruyeMonstruoDeJugadorBYLoLastima() {
		
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();
		
		DragonBlancoDeOjosAzules dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		
		mazoA.agregar(dragonBlancoDeOjosAzules);
		mazoB.agregar(insectoComeHombres);
		
		Jugador jugadorA = new Jugador(mazoA);
		Jugador jugadorB = new Jugador(mazoB);
		
		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();
		
		jugadorA.colocarCartaMonstruoEnModoAtaque(dragonBlancoDeOjosAzules);
		jugadorB.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		
		jugadorB.meAtaca(jugadorA);
		
		//VIDA DEL JUGADOR B - (ATAQUE DE DRAGON - ATAQUE DE INSECTO)
		int vida = 8000 - (3000 - 450);
		assertTrue(jugadorB.estaLaCartaEnCementerio(insectoComeHombres));
		assertEquals(vida, jugadorB.vida()); 
	}
	
	@Test
	void testJugadorADestruyeSuPropioMonstruoYSeLastima() {
		
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();
		
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		DragonBlancoDeOjosAzules dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
		
		mazoA.agregar(insectoComeHombres);
		mazoB.agregar(dragonBlancoDeOjosAzules);
		
		Jugador jugadorA = new Jugador(mazoA);
		Jugador jugadorB = new Jugador(mazoB);
		
		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();
	
		jugadorA.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugadorB.colocarCartaMonstruoEnModoAtaque(dragonBlancoDeOjosAzules);
		
		jugadorB.meAtaca(jugadorA);
		
		//VIDA DEL JUGADOR A - (ATAQUE DE DRAGON - ATAQUE DE INSECTO)
		int vida = 8000 - (3000 - 450);
		assertTrue(jugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertEquals(vida, jugadorA.vida()); 
	}
	
	@Test
	void testJugadorADestruyeMonstruosYNadieSeLastima() {
		
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
		
		jugadorB.meAtaca(jugadorA);
		
		int vida = 8000;
		assertTrue(jugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(jugadorB.estaLaCartaEnCementerio(otroInsectoComeHombres));
		assertEquals(vida, jugadorA.vida()); 
		assertEquals(vida, jugadorB.vida()); 
	}
	
	@Test
	void testJugadorAAtacaMonstruoEnModoDefensaDeJugadorBYNoLastima() {
		
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();
		
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		DragonBlancoDeOjosAzules dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
		
		mazoA.agregar(insectoComeHombres);
		mazoB.agregar(dragonBlancoDeOjosAzules);
		
		Jugador jugadorA = new Jugador(mazoA);
		Jugador jugadorB = new Jugador(mazoB);
		
		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();
		
		jugadorA.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugadorB.colocarCartaMonstruoEnModoDefensa(dragonBlancoDeOjosAzules);
		
		jugadorB.meAtaca(jugadorA);
		
		int vida = 8000;
		assertFalse(jugadorB.estaLaCartaEnCementerio(dragonBlancoDeOjosAzules));
		assertEquals(vida, jugadorB.vida()); 
	}
	
	@Test
	void testJugadorADestruyeTodosLosMonstruosConAgujeroOscuro() {
		
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();
		
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		DragonBlancoDeOjosAzules dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
		AgujeroOscuro agujeroOscuro = new AgujeroOscuro();
		
		mazoA.agregar(insectoComeHombres);
		mazoA.agregar(agujeroOscuro);
		mazoB.agregar(dragonBlancoDeOjosAzules);
		
		Jugador jugadorA = new Jugador(mazoA);
		Jugador jugadorB = new Jugador(mazoB);
		
		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();
		
		jugadorA.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugadorB.colocarCartaMonstruoEnModoDefensa(dragonBlancoDeOjosAzules);
		
		jugadorA.tomarCartaDelMazo();
		jugadorA.colocarCartaMagicaBocaArriba(agujeroOscuro);
		
		int vida = 8000;
		assertTrue(jugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(jugadorB.estaLaCartaEnCementerio(dragonBlancoDeOjosAzules));
		assertEquals(vida, jugadorA.vida());
		assertEquals(vida, jugadorB.vida()); 
	}

}
