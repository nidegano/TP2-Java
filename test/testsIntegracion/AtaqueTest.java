package testsIntegracion;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import cartas.AgujeroOscuro;
import cartas.DragonBlancoDeOjosAzules;
import cartas.InsectoComeHombres;
import estado.ModoActivo;
import estado.ModoAtaque;
import estado.ModoDefensa;
import juego.Jugador;

class AtaqueTest {

	@Test
	void testJugadorADestruyeMonstruoDeJugadorBYLoLastima() {
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		DragonBlancoDeOjosAzules dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();

		jugadorA.agregarCartaAMano(dragonBlancoDeOjosAzules);
		jugadorB.agregarCartaAMano(insectoComeHombres);
		jugadorA.colocarCartaMonstruo(dragonBlancoDeOjosAzules, new ModoAtaque());
		jugadorB.colocarCartaMonstruo(insectoComeHombres, new ModoAtaque());
		
		jugadorB.meAtaca(jugadorA);
		
		//VIDA DEL JUGADOR B - (ATAQUE DE DRAGON - ATAQUE DE INSECTO)
		int vida = 8000 - (3000 - 450);
		assertTrue(jugadorB.estaLaCartaEnCementerio(insectoComeHombres));
		assertEquals(vida, jugadorB.vida()); 
	}
	
	@Test
	void testJugadorADestruyeSuPropioMonstruoYSeLastima() {
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		DragonBlancoDeOjosAzules dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();

		jugadorA.agregarCartaAMano(insectoComeHombres);
		jugadorB.agregarCartaAMano(dragonBlancoDeOjosAzules);
		jugadorA.colocarCartaMonstruo(insectoComeHombres, new ModoAtaque());
		jugadorB.colocarCartaMonstruo(dragonBlancoDeOjosAzules, new ModoAtaque());
		
		jugadorB.meAtaca(jugadorA);
		
		//VIDA DEL JUGADOR A - (ATAQUE DE DRAGON - ATAQUE DE INSECTO)
		int vida = 8000 - (3000 - 450);
		assertTrue(jugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertEquals(vida, jugadorA.vida()); 
	}
	
	@Test
	void testJugadorADestruyeMonstruosYNadieSeLastima() {
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		InsectoComeHombres otroInsectoComeHombres = new InsectoComeHombres();

		jugadorA.agregarCartaAMano(insectoComeHombres);
		jugadorB.agregarCartaAMano(otroInsectoComeHombres);
		jugadorA.colocarCartaMonstruo(insectoComeHombres, new ModoAtaque());
		jugadorB.colocarCartaMonstruo(otroInsectoComeHombres, new ModoAtaque());
		
		jugadorB.meAtaca(jugadorA);
		
		int vida = 8000;
		assertTrue(jugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(jugadorB.estaLaCartaEnCementerio(otroInsectoComeHombres));
		assertEquals(vida, jugadorA.vida()); 
		assertEquals(vida, jugadorB.vida()); 
	}
	
	@Test
	void testJugadorAAtacaMonstruoEnModoDefensaDeJugadorBYNoLastima() {
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		DragonBlancoDeOjosAzules dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();

		jugadorA.agregarCartaAMano(insectoComeHombres);
		jugadorB.agregarCartaAMano(dragonBlancoDeOjosAzules);
		jugadorA.colocarCartaMonstruo(insectoComeHombres, new ModoAtaque());
		jugadorB.colocarCartaMonstruo(dragonBlancoDeOjosAzules, new ModoDefensa());
		
		jugadorB.meAtaca(jugadorA);
		
		int vida = 8000;
		assertFalse(jugadorB.estaLaCartaEnCementerio(dragonBlancoDeOjosAzules));
		assertEquals(vida, jugadorB.vida()); 
	}
	
	@Test
	void testJugadorADestruyeTodosLosMonstruosConAgujeroOscuro() {
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		DragonBlancoDeOjosAzules dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
		AgujeroOscuro agujeroOscuro = new AgujeroOscuro();

		jugadorA.agregarCartaAMano(insectoComeHombres);
		jugadorA.agregarCartaAMano(agujeroOscuro);
		jugadorB.agregarCartaAMano(dragonBlancoDeOjosAzules);
		jugadorA.colocarCartaMonstruo(insectoComeHombres, new ModoAtaque());
		jugadorB.colocarCartaMonstruo(dragonBlancoDeOjosAzules, new ModoDefensa());
		jugadorA.colocarCartaMagica(agujeroOscuro, new ModoActivo());
		
		int vida = 8000;
		assertTrue(jugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(jugadorB.estaLaCartaEnCementerio(dragonBlancoDeOjosAzules));
		assertEquals(vida, jugadorA.vida());
		assertEquals(vida, jugadorB.vida()); 
	}

}
