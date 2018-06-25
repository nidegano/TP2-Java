package testsIntegracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cartas.EspadachinSilencioso;
import cartas.DragonArmadoOscuro;
import cartas.DragonBlancoDeOjosAzules;
import cartas.InsectoComeHombres;
import juego.Campo;
import juego.ContenedorDeCartas;
import juego.Jugador;
import juego.Mazo;

public class JuegoTest {

	@Test
	public void testColocarCartaMonstruoEnModoAtaque() {
		Mazo mazo = new Mazo();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		mazo.agregar(insectoComeHombres);
		Campo campo = new Campo(mazo);
		Jugador jugador = new Jugador(campo);
		insectoComeHombres.asignarDuenio(jugador);

		insectoComeHombres.invocarEnModoAtaque();

		assertEquals(450, insectoComeHombres.puntosAUtilizarSegunEstado());
	}

	@Test
	public void testColocarCartaMonstruoEnModoDefensa() {
		Mazo mazo = new Mazo();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		mazo.agregar(insectoComeHombres);
		Campo campo = new Campo(mazo);
		Jugador jugador = new Jugador(campo);
		insectoComeHombres.asignarDuenio(jugador);

		insectoComeHombres.invocarEnModoDefensa();

		assertEquals(600, insectoComeHombres.puntosAUtilizarSegunEstado());
	}

	@Test
	public void testMuereMonstruoYApareceEnCementerio() {
		Mazo mazo = new Mazo();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		mazo.agregar(insectoComeHombres);
		Campo campo = new Campo(mazo);
		Jugador jugador = new Jugador(campo);
		insectoComeHombres.asignarDuenio(jugador);
		
		insectoComeHombres.matar();
		
		assertTrue(campo.estaLaCartaEnCementerio(insectoComeHombres));
	}

	@Test
	public void testInvocarUnaCartaMonstruoDe5EstrellasSacrificaAUnMonstruoDelJugadorQueLoInvoca() {
		Mazo mazo = new Mazo();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		mazo.agregar(insectoComeHombres);
		Campo campo = new Campo(mazo);
		Jugador jugador = new Jugador(campo);
		insectoComeHombres.asignarDuenio(jugador);
		insectoComeHombres.invocarEnModoAtaque();
		
		ContenedorDeCartas sacrificios = new ContenedorDeCartas(1);
		sacrificios.agregar(insectoComeHombres);
		EspadachinSilencioso espadachinSilencioso = new EspadachinSilencioso(sacrificios);
		mazo.agregar(espadachinSilencioso);
		espadachinSilencioso.asignarDuenio(jugador);
		espadachinSilencioso.invocarEnModoAtaque();

		assertTrue(campo.estaLaCartaEnCementerio(insectoComeHombres));
	}

	@Test
	public void testInvocarUnaCartaMonstruoDe7EstrellasSacrificaADosMonstruosDelJugadorQueLoInvoca() {
		Mazo mazo = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		InsectoComeHombres otroInsectoComeHombres = new InsectoComeHombres();

		mazo.agregar(insectoComeHombres);
		mazo.agregar(otroInsectoComeHombres);

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		insectoComeHombres.asignarDuenio(jugador);
		otroInsectoComeHombres.asignarDuenio(jugador);

		insectoComeHombres.invocarEnModoAtaque();
		otroInsectoComeHombres.invocarEnModoAtaque();

		ContenedorDeCartas sacrificios = new ContenedorDeCartas(2);
		sacrificios.agregar(insectoComeHombres);
		sacrificios.agregar(otroInsectoComeHombres);
		DragonArmadoOscuro dragonArmadoOscuro = new DragonArmadoOscuro(sacrificios);
		dragonArmadoOscuro.asignarDuenio(jugador);
		dragonArmadoOscuro.invocarEnModoAtaque();

		assertTrue(campo.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(campo.estaLaCartaEnCementerio(otroInsectoComeHombres));
	}

	@Test
	public void testInvocarUnaCartaMonstruoDe8EstrellasSacrificaADosMonstruosDelJugadorQueLoInvoca() {
		Mazo mazo = new Mazo();

		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		InsectoComeHombres otroInsectoComeHombres = new InsectoComeHombres();

		mazo.agregar(insectoComeHombres);
		mazo.agregar(otroInsectoComeHombres);

		Campo campo = new Campo(mazo);

		Jugador jugador = new Jugador(campo);
		insectoComeHombres.asignarDuenio(jugador);
		otroInsectoComeHombres.asignarDuenio(jugador);

		insectoComeHombres.invocarEnModoAtaque();
		otroInsectoComeHombres.invocarEnModoAtaque();
		
		ContenedorDeCartas sacrificios = new ContenedorDeCartas(2);
		sacrificios.agregar(insectoComeHombres);
		sacrificios.agregar(otroInsectoComeHombres);
		DragonBlancoDeOjosAzules dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules(sacrificios);
		dragonBlancoDeOjosAzules.asignarDuenio(jugador);
		dragonBlancoDeOjosAzules.invocarEnModoAtaque();

		assertTrue(campo.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(campo.estaLaCartaEnCementerio(otroInsectoComeHombres));
	}

}
