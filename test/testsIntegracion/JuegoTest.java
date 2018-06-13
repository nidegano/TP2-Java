package testsIntegracion;

import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;

import cartas.AgujeroOscuro;
import cartas.CartaMonstruoDe5Estrellas;
import cartas.CartaMonstruoDe6Estrellas;
import cartas.CartaMonstruoDe7Estrellas;
import cartas.CilindroMagico;
import cartas.DragonBlancoDeOjosAzules;
import cartas.InsectoComeHombres;
import juego.Jugador;
import juego.Mazo;

class JuegoTest {

	@Test
	void testColocarCartaMonstruoEnModoAtaque() {
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		insectoComeHombres.colocarEnModoAtaque();

		assertTrue(insectoComeHombres.estaEnModoAtaque());
	}

	@Test
	void testColocarCartaMonstruoEnModoDefensa() {
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		insectoComeHombres.colocarEnModoDefensa();

		assertTrue(insectoComeHombres.estaEnModoDefensa());
	}

	@Test
	void testColocarCartaMagicaBocaAbajo() {
		AgujeroOscuro agujeroOscuro = new AgujeroOscuro();
		agujeroOscuro.colocarBocaAbajo();

		assertTrue(agujeroOscuro.estaBocaAbajo());
	}

	@Test
	void testColocarCartaTrampaBocaAbajo() {
		CilindroMagico cilindroMagico = new CilindroMagico();
		cilindroMagico.colocarBocaAbajo();

		assertTrue(cilindroMagico.estaBocaAbajo());
	}

	@Test
	void testSacrificarMonstruo() {
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		Mazo mazo = new Mazo();
		mazo.agregar(insectoComeHombres);
		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugador.sacrificarMonstruo(insectoComeHombres);

		assertTrue(jugador.estaLaCartaEnCementerio(insectoComeHombres));
	}
	
	@Test
	void testInvocarUnaCartaMonstruoDe5EstrellasSacrificaAUnMonstruoDelJugadorQueLoInvoca() {
		Mazo mazo = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CartaMonstruoDe5Estrellas unaCartaMonstruoDe5Estrellas = new CartaMonstruoDe5Estrellas();

		mazo.agregar(insectoComeHombres);
		mazo.agregar(unaCartaMonstruoDe5Estrellas);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		
		unaCartaMonstruoDe5Estrellas.colocarEnModoAtaque(insectoComeHombres);
		jugador.enviarCartasMuertasAlCementerio();
		
		assertTrue(jugador.estaLaCartaEnCementerio(insectoComeHombres));
	}
	
	@Test
	void testInvocarUnaCartaMonstruoDe6EstrellasSacrificaAUnMonstruoDelJugadorQueLoInvoca() {
		Mazo mazo = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CartaMonstruoDe6Estrellas unaCartaMonstruoDe6Estrellas = new CartaMonstruoDe6Estrellas();

		mazo.agregar(insectoComeHombres);
		mazo.agregar(unaCartaMonstruoDe6Estrellas);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		
		unaCartaMonstruoDe6Estrellas.colocarEnModoAtaque(insectoComeHombres);
		jugador.enviarCartasMuertasAlCementerio();
		
		assertTrue(jugador.estaLaCartaEnCementerio(insectoComeHombres));
	}
	
	@Test
	void testInvocarUnaCartaMonstruoDe7EstrellasSacrificaADosMonstruosDelJugadorQueLoInvoca() {
		Mazo mazo = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		InsectoComeHombres otroInsectoComeHombres = new InsectoComeHombres();
		CartaMonstruoDe7Estrellas unaCartaMonstruoDe7Estrellas = new CartaMonstruoDe7Estrellas();

		mazo.agregar(insectoComeHombres);
		mazo.agregar(otroInsectoComeHombres);
		mazo.agregar(unaCartaMonstruoDe7Estrellas);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugador.colocarCartaMonstruoEnModoAtaque(otroInsectoComeHombres);
		
		unaCartaMonstruoDe7Estrellas.colocarEnModoAtaque(insectoComeHombres,otroInsectoComeHombres);
		jugador.enviarCartasMuertasAlCementerio();
		
		assertTrue(jugador.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(jugador.estaLaCartaEnCementerio(otroInsectoComeHombres));
	}
	
	@Test
	void testInvocarUnaCartaMonstruoDe8EstrellasSacrificaADosMonstruosDelJugadorQueLoInvoca() {
		Mazo mazo = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		InsectoComeHombres otroInsectoComeHombres = new InsectoComeHombres();
		DragonBlancoDeOjosAzules unaCartaMonstruoDe8Estrellas = new DragonBlancoDeOjosAzules();

		mazo.agregar(insectoComeHombres);
		mazo.agregar(otroInsectoComeHombres);
		mazo.agregar(unaCartaMonstruoDe8Estrellas);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugador.colocarCartaMonstruoEnModoAtaque(otroInsectoComeHombres);
		
		unaCartaMonstruoDe8Estrellas.colocarEnModoAtaque(insectoComeHombres,otroInsectoComeHombres);
		jugador.enviarCartasMuertasAlCementerio();
		
		assertTrue(jugador.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(jugador.estaLaCartaEnCementerio(otroInsectoComeHombres));

	}	
	

}