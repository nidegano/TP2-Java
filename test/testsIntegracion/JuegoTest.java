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
import juego.Campo;
import juego.ContenedorDeCartas;
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
	public void testMuereMonstruoYApareceEnCementerio() {
		Mazo mazo = new Mazo();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		mazo.agregar(insectoComeHombres);
		
		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		jugador.tomarCartaDelMazo();
		
		insectoComeHombres.matar();
		
		assertTrue(campo.estaLaCartaEnCementerio(insectoComeHombres));
	}

	@Test
	public void testInvocarUnaCartaMonstruoDe5EstrellasSacrificaAUnMonstruoDelJugadorQueLoInvoca() {
		Mazo mazo = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		EspadachinSilencioso espadachinSilencioso = new EspadachinSilencioso();

		mazo.agregar(insectoComeHombres);
		mazo.agregar(espadachinSilencioso);

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		
		ContenedorDeCartas sacrificios = new ContenedorDeCartas(1);
		sacrificios.agregar(insectoComeHombres);

		espadachinSilencioso.colocarEnModoAtaque(sacrificios);

		assertTrue(campo.estaLaCartaEnCementerio(insectoComeHombres));
	}

	@Test
	public void testInvocarUnaCartaMonstruoDe6EstrellasSacrificaAUnMonstruoDelJugadorQueLoInvoca() {
		Mazo mazo = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		Jinzo jinzo = new Jinzo();

		mazo.agregar(insectoComeHombres);
		mazo.agregar(jinzo);

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);

		ContenedorDeCartas sacrificios = new ContenedorDeCartas(1);
		sacrificios.agregar(insectoComeHombres);
		
		jinzo.colocarEnModoAtaque(sacrificios);

		assertTrue(campo.estaLaCartaEnCementerio(insectoComeHombres));
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

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugador.colocarCartaMonstruoEnModoAtaque(otroInsectoComeHombres);

		ContenedorDeCartas sacrificios = new ContenedorDeCartas(2);
		sacrificios.agregar(insectoComeHombres);
		sacrificios.agregar(otroInsectoComeHombres);
		
		dragonArmadoOscuro.colocarEnModoAtaque(sacrificios);

		assertTrue(campo.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(campo.estaLaCartaEnCementerio(otroInsectoComeHombres));
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

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugador.colocarCartaMonstruoEnModoAtaque(otroInsectoComeHombres);
		
		ContenedorDeCartas sacrificios = new ContenedorDeCartas(2);
		sacrificios.agregar(insectoComeHombres);
		sacrificios.agregar(otroInsectoComeHombres);

		dragonBlancoDeOjosAzules.colocarEnModoAtaque(sacrificios);

		assertTrue(campo.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(campo.estaLaCartaEnCementerio(otroInsectoComeHombres));
	}

}
