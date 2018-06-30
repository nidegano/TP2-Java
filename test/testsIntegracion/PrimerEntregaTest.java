package testsIntegracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cartas.EspadachinSilencioso;
import cartas.AgujeroOscuro;
import cartas.CabezaExodia;
import cartas.DragonArmadoOscuro;
import cartas.DragonBlancoDeOjosAzules;
import cartas.InsectoComeHombres;
import juego.Campo;
import juego.ContenedorDeCartas;
import juego.Jugador;
import juego.Mazo;

public class PrimerEntregaTest {

	@Test
	public void testColocarCartaMonstruoEnModoAtaque() {
		Mazo mazo = new Mazo();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		mazo.agregar(insectoComeHombres);
		Campo campo = new Campo(mazo);
		Jugador jugador = new Jugador(campo);
		insectoComeHombres.asignarDuenio(jugador);

		jugador.tomarCartaDelMazo();
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

		jugador.tomarCartaDelMazo();
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

		jugador.tomarCartaDelMazo();
		insectoComeHombres.invocarEnModoAtaque();

		ContenedorDeCartas sacrificios = new ContenedorDeCartas(1);
		sacrificios.agregar(insectoComeHombres);
		EspadachinSilencioso espadachinSilencioso = new EspadachinSilencioso(sacrificios);
		mazo.agregar(espadachinSilencioso);
		espadachinSilencioso.asignarDuenio(jugador);

		mazo.agregar(espadachinSilencioso);
		jugador.tomarCartaDelMazo();
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

		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();

		insectoComeHombres.invocarEnModoAtaque();
		otroInsectoComeHombres.invocarEnModoAtaque();

		ContenedorDeCartas sacrificios = new ContenedorDeCartas(2);
		sacrificios.agregar(insectoComeHombres);
		sacrificios.agregar(otroInsectoComeHombres);
		DragonArmadoOscuro dragonArmadoOscuro = new DragonArmadoOscuro(sacrificios);
		dragonArmadoOscuro.asignarDuenio(jugador);
		mazo.agregar(dragonArmadoOscuro);

		jugador.tomarCartaDelMazo();
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

		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();

		insectoComeHombres.invocarEnModoAtaque();
		otroInsectoComeHombres.invocarEnModoAtaque();

		ContenedorDeCartas sacrificios = new ContenedorDeCartas(2);
		sacrificios.agregar(insectoComeHombres);
		sacrificios.agregar(otroInsectoComeHombres);
		DragonBlancoDeOjosAzules dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules(sacrificios);
		dragonBlancoDeOjosAzules.asignarDuenio(jugador);

		mazo.agregar(dragonBlancoDeOjosAzules);
		jugador.tomarCartaDelMazo();
		dragonBlancoDeOjosAzules.invocarEnModoAtaque();

		assertTrue(campo.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(campo.estaLaCartaEnCementerio(otroInsectoComeHombres));
	}

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

		assertTrue(campoA.estaLaCartaEnCementerio(insectoComeHombres));
		assertTrue(campoB.estaLaCartaEnCementerio(exodiaCabeza));
	}

}