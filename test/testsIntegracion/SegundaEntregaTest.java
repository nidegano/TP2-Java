package testsIntegracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import cartas.AlphaTheMagnetWarrior;
import cartas.BrazoDerechoExodia;
import cartas.BrazoIzquierdoExodia;
import cartas.CilindroMagico;
import cartas.DragonBlancoDeOjosAzules;
import cartas.DragonDefinitivo;
import cartas.EspadachinSilencioso;
import cartas.CabezaExodia;
import cartas.Fisura;
import cartas.InsectoComeHombres;
import cartas.Jinzo;
import cartas.OllaDeLaCodicia;
import cartas.PiernaDerechaExodia;
import cartas.PiernaIzquierdaExodia;
import cartas.Reinforcements;
import cartas.Sogen;
import cartas.Wasteland;
import juego.Campo;
import juego.Juego;
import juego.Jugador;
import juego.Mazo;

public class SegundaEntregaTest {
	
	@Test
	public void testPongoUnMonstruoEnCadaLadoActivoUnaCartaWastelandYAumenta200DeAtaqueMiMonstruoY300DeDefensaElOtro() {
		
		Campo campoA = new Campo(new Mazo());
		Campo campoB = new Campo(new Mazo());
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		EspadachinSilencioso monstruoA = new EspadachinSilencioso();
		EspadachinSilencioso monstruoB = new EspadachinSilencioso();
		
		Wasteland wasteland = new Wasteland();
		
		monstruoA.asignarDueño(jugadorA);
		monstruoB.asignarDueño(jugadorB);
		wasteland.asignarDueño(jugadorA);
		
		monstruoA.invocarEnModoAtaque(); //no es lo mismo invocarEnModoAtaque que colocarEnModoAtaque, invocar podria hacer mas cosas que solo cambiar el estado
		monstruoB.invocarEnModoDefensa();
		
		wasteland.colocarBocaArriba();
		
		monstruoA.atacar(monstruoB);
		
		int vidaEsperadaDeJugadorB = 8000 - ((2300 + 200) - (1000 + 300));
		
		assertEquals(vidaEsperadaDeJugadorB,jugadorB.vida());	
	}
	
	@Test
	public void testPongoUnMonstruoEnCadaLadoActivoUnaCartaSogenYAumenta200DeAtaqueMiMonstruoY500DeDefensaElOtro() {
		
		Campo campoA = new Campo(new Mazo());
		Campo campoB = new Campo(new Mazo());
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		EspadachinSilencioso monstruoA = new EspadachinSilencioso();
		EspadachinSilencioso monstruoB = new EspadachinSilencioso();
		
		Sogen sogen = new Sogen();
		
		monstruoA.asignarDueño(jugadorA);
		monstruoB.asignarDueño(jugadorB);
		sogen.asignarDueño(jugadorA);
		
		monstruoA.invocarEnModoAtaque();
		monstruoB.invocarEnModoDefensa();
		
		sogen.colocarBocaArriba();
		
		monstruoA.atacar(monstruoB);
		
		int vidaEsperadaDeJugadorB = 8000 - ((2300 + 200) - (1000 + 300));
		
		assertEquals(vidaEsperadaDeJugadorB,jugadorB.vida());	
	}
	
	@Test
	public void testActivoUnaCartaOllaDeLaCodiciaYSeTomanDosCartasDelMazo() {
		
		Mazo mazoA = new Mazo();
		
		Campo campoA = new Campo(mazoA);
		
		Jugador jugadorA = new Jugador(campoA);
		
		OllaDeLaCodicia ollaDeLaCodicia = new OllaDeLaCodicia();
		ollaDeLaCodicia.asignarDueño(jugadorA);
		ollaDeLaCodicia.colocarBocaArriba();
		
		int cartasEsperadasEnMano = 2;
		
		assertEquals(cartasEsperadasEnMano,jugadorA.cartasEnMano());	
	}
	
	@Test
	public void testPongoDosMonstruosEnemigosActivoUnaCartaFisuraYMuereElMonstruoDeMenorAtaque() {
		
		Campo campoA = new Campo(new Mazo());
		Campo campoB = new Campo(new Mazo());
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		Jinzo monstruo1 = new Jinzo();
		CabezaExodia monstruo2 = new CabezaExodia();
		
		Fisura fisura = new Fisura();
		
		monstruo1.asignarDueño(jugadorB);
		monstruo2.asignarDueño(jugadorB);
		fisura.asignarDueño(jugadorA);
		
		monstruo1.invocarEnModoAtaque();
		monstruo2.invocarEnModoAtaque();
		
		fisura.colocarBocaArriba();
		
		assertTrue(campoB.estaLaCartaEnCementerio(monstruo2));	
	}
	
	@Test
	public void testPongoUnMonstruoEnCadaLadoSiendoElPropioUnJinzoYVeoQueSePuedeAtacarDirectamenteAlJugadorContrario() {
		
		Campo campoA = new Campo(new Mazo());
		Campo campoB = new Campo(new Mazo());
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		Jinzo jinzo = new Jinzo();
		CabezaExodia monstruoB = new CabezaExodia();
		
		jinzo.asignarDueño(jugadorA);
		monstruoB.asignarDueño(jugadorB);
		
		jinzo.invocarEnModoAtaque();
		monstruoB.invocarEnModoDefensa();
		
		jinzo.atacarDirectamenteAlJugador(jugadorB);
		
		int vidaEsperadaDeJugadorB = 8000 - 500;
		
		assertEquals(vidaEsperadaDeJugadorB,jugadorB.vida());	
	}
	
	@Test
	public void testPongo3DragonesBlancosDeOjosAzulesPongoUnDragonDefinitivoYSeSacrificanLosTresDragonesBlancosDeOjosAzules() {
		
		Campo campoA = new Campo(new Mazo());
		
		Jugador jugadorA = new Jugador(campoA);
		
		DragonBlancoDeOjosAzules dragon1 = new DragonBlancoDeOjosAzules();
		DragonBlancoDeOjosAzules dragon2 = new DragonBlancoDeOjosAzules();
		DragonBlancoDeOjosAzules dragon3 = new DragonBlancoDeOjosAzules();
		
		dragon1.asignarDueño(jugadorA);
		dragon2.asignarDueño(jugadorA);
		dragon3.asignarDueño(jugadorA);
		
		dragon1.invocarEnModoAtaque();
		dragon2.invocarEnModoAtaque();
		dragon3.invocarEnModoAtaque();
		
		DragonDefinitivo dragonDefinitivo = new DragonDefinitivo(dragon1,dragon2,dragon3); //se pasa las referencias a los dragones
		dragonDefinitivo.invocarEnModoAtaque(); // se sacrifica a los dragones
		
		assertTrue(campoA.estaLaCartaEnCementerio(dragon1));	
		assertTrue(campoA.estaLaCartaEnCementerio(dragon2));	
		assertTrue(campoA.estaLaCartaEnCementerio(dragon3));	
	}
	
	@Test
	public void testPongoUnMonstruoEnCadaLadoSiendoElPropioUnInsectoComeHombresBocaAbajoYAlSerAtacadoEsteDestruyeAlAtacanteSolamente() {
		
		Campo campoA = new Campo(new Mazo());
		Campo campoB = new Campo(new Mazo());
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CabezaExodia monstruoB = new CabezaExodia();
		
		insectoComeHombres.asignarDueño(jugadorA);
		monstruoB.asignarDueño(jugadorB);
		
		insectoComeHombres.invocarEnModoDefensaBocaAbajo();
		monstruoB.invocarEnModoDefensa();
		
		monstruoB.atacar(insectoComeHombres);
		
		int vidaEsperadaDeJugadorA = 8000;
		int vidaEsperadaDeJugadorB = 8000;
		
		assertTrue(campoB.estaLaCartaEnCementerio(monstruoB));	
		assertFalse(campoA.estaLaCartaEnCementerio(insectoComeHombres));	
		assertEquals(vidaEsperadaDeJugadorA,jugadorA.vida());
		assertEquals(vidaEsperadaDeJugadorB,jugadorB.vida());
	}
	
	@Test
	public void testPongoUnMonstruoEnemigoYUnCilindroMagicoDeMiLadoYCuandoElMonstruoEnemigoMeAtacaSeNiegaElAtaqueYloRecibeElJugadorEnemigo() {
		
		Campo campoA = new Campo(new Mazo());
		Campo campoB = new Campo(new Mazo());
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CilindroMagico cilindroMagico = new CilindroMagico();
		
		insectoComeHombres.asignarDueño(jugadorA);
		cilindroMagico.asignarDueño(jugadorB);
		
		insectoComeHombres.invocarEnModoAtaque();
		cilindroMagico.colocarBocaAbajo();
		
		insectoComeHombres.atacarDirectamenteAlJugador(jugadorB);
		
		int vidaEsperadaDeJugadorA = 8000;
		int vidaEsperadaDeJugadorB = 8000 - 450;
		
		assertEquals(vidaEsperadaDeJugadorA,jugadorA.vida());
		assertEquals(vidaEsperadaDeJugadorB,jugadorB.vida());
	}
	
	@Test
	public void testPongoUnMonstruoEnAmbosLadosYUnReinforcementsDeMiLadoYCuandoElMonstruoEnemigoMeAtacaMiMontruoAumentaElAtaqueEn500() {
		
		Campo campoA = new Campo(new Mazo());
		Campo campoB = new Campo(new Mazo());
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		CabezaExodia monstruoA = new CabezaExodia();
		AlphaTheMagnetWarrior monstruoB = new AlphaTheMagnetWarrior(); //carta nueva
		Reinforcements cilindroMagico = new Reinforcements();
		
		monstruoA.asignarDueño(jugadorA);
		monstruoB.asignarDueño(jugadorB);
		
		cilindroMagico.asignarDueño(jugadorA);
		
		monstruoA.invocarEnModoAtaque();
		monstruoB.invocarEnModoAtaque();
		
		cilindroMagico.colocarBocaAbajo();
		
		monstruoB.atacar(monstruoA);
		
		int vidaEsperadaDeJugadorA = 8000;
		int vidaEsperadaDeJugadorB = 8000 - 100;
		
		assertTrue(campoB.estaLaCartaEnCementerio(monstruoB));	
		assertFalse(campoA.estaLaCartaEnCementerio(monstruoA));	
		assertEquals(vidaEsperadaDeJugadorA,jugadorA.vida());
		assertEquals(vidaEsperadaDeJugadorB,jugadorB.vida());
	}
	
	@Test
	public void testElJugadorTieneQueTomarUnaCartaDelMazoEstandoEsteVacioPierde() {
		
		Mazo mazoA = new Mazo(); //esta vacio	
		Campo campoA = new Campo(mazoA);
		Jugador jugadorA = new Jugador(campoA);
		
		Mazo mazoB = new Mazo();
		Campo campoB = new Campo(mazoA);
		Jugador jugadorB = new Jugador(campoA);
		
		Juego juego = new Juego(jugadorA,jugadorB);
		
		jugadorA.tomarCartaDelMazo();

		assertTrue(juego.perdioJugador(jugadorA));	
	}
	
	@Test
	public void testElJugadorTieneLasCincoPartesDelExodiaYElOtroPierde() {
		
		Mazo mazoA = new Mazo();	
		Campo campoA = new Campo(mazoA);
		Jugador jugadorA = new Jugador(campoA);
		
		Mazo mazoB = new Mazo();
		Campo campoB = new Campo(mazoA);
		Jugador jugadorB = new Jugador(campoA);
		
		Juego juego = new Juego(jugadorA,jugadorB);
		
		mazoA.agregar(new CabezaExodia());
		mazoA.agregar(new BrazoIzquierdoExodia());
		mazoA.agregar(new BrazoDerechoExodia());
		mazoA.agregar(new PiernaIzquierdaExodia());
		mazoA.agregar(new PiernaDerechaExodia());
		
		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();

		assertTrue(juego.perdioJugador(jugadorB));	
	}
	
}
