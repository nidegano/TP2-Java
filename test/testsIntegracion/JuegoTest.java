package testsIntegracion;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cartas.AgujeroOscuro;
import cartas.EspadachinSilencioso;
import cartas.Jinzo;
import cartas.DragonArmadoOscuro;
import cartas.CilindroMagico;
import cartas.DragonBlancoDeOjosAzules;
import cartas.InsectoComeHombres;
import juego.Jugador;
import juego.Mazo;

public class JuegoTest {

	@Test
	public void testColocarCartaMonstruoEnModoAtaque() {
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		insectoComeHombres.colocarEnModoAtaque();

		assertTrue(insectoComeHombres.estaEnModoAtaque());
	}

	@Test
	public void testColocarCartaMonstruoEnModoDefensa() {
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		insectoComeHombres.colocarEnModoDefensa();

		assertTrue(insectoComeHombres.estaEnModoDefensa());
	}

	@Test
	public void testColocarCartaMagicaBocaAbajo() {
		AgujeroOscuro agujeroOscuro = new AgujeroOscuro();
		agujeroOscuro.colocarBocaAbajo();

		assertTrue(agujeroOscuro.estaBocaAbajo());
	}

	@Test
	public void testColocarCartaTrampaBocaAbajo() {
		CilindroMagico cilindroMagico = new CilindroMagico();
		cilindroMagico.colocarBocaAbajo();

		assertTrue(cilindroMagico.estaBocaAbajo());
	}

	@Test
	public void testSacrificarMonstruo() {
		Mazo mazo = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();

		mazo.agregar(insectoComeHombres);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugador.sacrificarMonstruo(insectoComeHombres);

		assertTrue(jugador.estaLaCartaEnCementerio(insectoComeHombres));
	}

	@Test
	public void testInvocarUnaCartaMonstruoDe5EstrellasSacrificaAUnMonstruoDelJugadorQueLoInvoca() {
		Mazo mazo = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		EspadachinSilencioso espadachinSilencioso = new EspadachinSilencioso();

		mazo.agregar(insectoComeHombres);
		mazo.agregar(espadachinSilencioso);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);

		espadachinSilencioso.colocarEnModoAtaque(insectoComeHombres);
		jugador.enviarCartasMuertasAlCementerio();

		assertTrue(jugador.estaLaCartaEnCementerio(insectoComeHombres));
	}

	@Test
	public void testInvocarUnaCartaMonstruoDe6EstrellasSacrificaAUnMonstruoDelJugadorQueLoInvoca() {
		Mazo mazo = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		Jinzo jinzo = new Jinzo();

		mazo.agregar(insectoComeHombres);
		mazo.agregar(jinzo);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);

		jinzo.colocarEnModoAtaque(insectoComeHombres);
		jugador.enviarCartasMuertasAlCementerio();

		assertTrue(jugador.estaLaCartaEnCementerio(insectoComeHombres));
	}

	@Test
	public void testInvocarUnaCartaMonstruoDe7EstrellasSacrificaADosMonstruosDelJugadorQueLoInvoca() {
		Mazo mazo = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		InsectoComeHombres otroInsectoComeHombres = new InsectoComeHombres();
		DragonArmadoOscuro dragonArmadoOscuro = new DragonArmadoOscuro();

		mazo.agregar(insectoComeHombres);
		mazo.agregar(otroInsectoComeHombres);
		mazo.agregar(dragonArmadoOscuro);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugador.colocarCartaMonstruoEnModoAtaque(otroInsectoComeHombres);

		dragonArmadoOscuro.colocarEnModoAtaque(insectoComeHombres, otroInsectoComeHombres);
		jugador.enviarCartasMuertasAlCementerio();

		assertTrue(jugador.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(jugador.estaLaCartaEnCementerio(otroInsectoComeHombres));
	}

	@Test
	public void testInvocarUnaCartaMonstruoDe8EstrellasSacrificaADosMonstruosDelJugadorQueLoInvoca() {
		Mazo mazo = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		InsectoComeHombres otroInsectoComeHombres = new InsectoComeHombres();
		DragonBlancoDeOjosAzules dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();

		mazo.agregar(insectoComeHombres);
		mazo.agregar(otroInsectoComeHombres);
		mazo.agregar(dragonBlancoDeOjosAzules);

		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugador.colocarCartaMonstruoEnModoAtaque(otroInsectoComeHombres);

		dragonBlancoDeOjosAzules.colocarEnModoAtaque(insectoComeHombres, otroInsectoComeHombres);
		jugador.enviarCartasMuertasAlCementerio();

		assertTrue(jugador.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(jugador.estaLaCartaEnCementerio(otroInsectoComeHombres));
	}

}
