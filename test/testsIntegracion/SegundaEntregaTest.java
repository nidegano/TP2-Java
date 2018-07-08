package testsIntegracion;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import cartas.*;
import juego.*;
import vista.Vista;
import vista.VistaMock;

public class SegundaEntregaTest {

	@Test
	public void testPongoUnMonstruoEnCadaLadoActivoUnaCartaWastelandYAumenta200DeAtaqueMiMonstruoY300DeDefensaElOtro() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		AncientBrain monstruoA = new AncientBrain();
		AncientBrain monstruoB = new AncientBrain();

		Wasteland wasteland = new Wasteland();

		mazoJugadorA.agregar(monstruoA);
		mazoJugadorB.agregar(monstruoB);
		mazoJugadorA.agregar(wasteland);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();

		monstruoA.invocarEnModoAtaque();

		monstruoB.invocarEnModoAtaque();

		wasteland.colocarBocaArriba();

		monstruoA.atacar(monstruoB);

		int vidaEsperadaDeJugadorB = 8000 - ((1000 + 200) - (700 + 300));

		assertEquals(vidaEsperadaDeJugadorB, jugadorB.vida());
	}

	@Test
	public void testPongoUnMonstruoEnCadaLadoActivoUnaCartaSogenYAumenta200DeAtaqueMiMonstruoY500DeDefensaElOtro() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		AncientBrain monstruoA = new AncientBrain();
		AncientBrain monstruoB = new AncientBrain();

		Sogen sogen = new Sogen();

		mazoJugadorA.agregar(monstruoA);
		mazoJugadorA.agregar(sogen);
		mazoJugadorB.agregar(monstruoB);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		monstruoA.invocarEnModoAtaque();
		monstruoB.invocarEnModoAtaque();

		sogen.colocarBocaArriba();

		monstruoA.atacar(monstruoB);

		int vidaEsperadaDeJugadorB = 8000 - ((1000 + 200) - (700 + 300));

		assertEquals(vidaEsperadaDeJugadorB, jugadorB.vida());
	}

	@Test
	public void testActivoUnaCartaOllaDeLaCodiciaYSeTomanDosCartasDelMazo() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		OllaDeLaCodicia ollaDeLaCodicia = new OllaDeLaCodicia();

		mazoJugadorA.agregar(ollaDeLaCodicia);
		mazoJugadorA.agregar(new Jinzo());
		mazoJugadorA.agregar(new Jinzo());
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		
		ollaDeLaCodicia.colocarBocaAbajo();
		ollaDeLaCodicia.colocarBocaArriba();

		int cartasEsperadasEnMano = 2;

		assertEquals(cartasEsperadasEnMano, jugadorA.cantidadDeCartasEnMano());
	}

	@Test
	public void testPongoDosMonstruosEnemigosActivoUnaCartaFisuraYMuereElMonstruoDeMenorAtaque() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		Jinzo monstruo1 = new Jinzo(); // es el de menor ataque de los dos
		CabezaExodia monstruo2 = new CabezaExodia();

		Fisura fisura = new Fisura();

		mazoJugadorA.agregar(fisura);
		mazoJugadorB.agregar(monstruo1);
		mazoJugadorB.agregar(monstruo2);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		monstruo1.invocarEnModoAtaque();
		monstruo2.invocarEnModoAtaque();

		fisura.colocarBocaAbajo();
		fisura.colocarBocaArriba();

		assertTrue(campoJugadorB.estaLaCartaEnCementerio(monstruo1));
	}

	@Test
	public void testPongoUnMonstruoEnCadaLadoSiendoElPropioUnJinzoYVeoQueSePuedeAtacarDirectamenteAlJugadorContrario() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		Jinzo jinzo = new Jinzo();
		CabezaExodia monstruoB = new CabezaExodia();

		mazoJugadorA.agregar(jinzo);
		mazoJugadorB.agregar(monstruoB);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);	

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		jinzo.invocarEnModoAtaque();
		monstruoB.invocarEnModoDefensa();

		jinzo.atacarDirectamenteAlOponente();

		int vidaEsperadaDeJugadorB = 8000 - 500;

		assertEquals(vidaEsperadaDeJugadorB, jugadorB.vida());
	}

	@Test
	public void testPongo3DragonesBlancosDeOjosAzulesPongoUnDragonDefinitivoYSeSacrificanLosTresDragonesBlancosDeOjosAzules() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		DragonBlancoDeOjosAzules dragon1 = new DragonBlancoDeOjosAzules();
		DragonBlancoDeOjosAzules dragon2 = new DragonBlancoDeOjosAzules();
		DragonBlancoDeOjosAzules dragon3 = new DragonBlancoDeOjosAzules();

		mazoJugadorA.agregar(dragon1);
		mazoJugadorA.agregar(dragon2);
		mazoJugadorA.agregar(dragon3);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();

		dragon1.invocarEnModoAtaque();
		dragon2.invocarEnModoAtaque();
		dragon3.invocarEnModoAtaque();

		ArrayList<CartaMonstruo> sacrificios = new ArrayList<CartaMonstruo>();
		sacrificios.add(dragon1);
		sacrificios.add(dragon2);
		sacrificios.add(dragon3);

		DragonDefinitivo dragonDefinitivo = new DragonDefinitivo(); // se pasa las referencias a los dragones
		dragonDefinitivo.asignarDuenio(jugadorA);

		mazoJugadorA.agregar(dragonDefinitivo);
		jugadorA.tomarCartaDelMazo();

		dragonDefinitivo.invocarEnModoAtaque(sacrificios); // se sacrifica a los dragones

		assertTrue(campoJugadorA.estaDentro(dragonDefinitivo));
		assertTrue(campoJugadorA.estaLaCartaEnCementerio(dragon1));
		assertTrue(campoJugadorA.estaLaCartaEnCementerio(dragon2));
		assertTrue(campoJugadorA.estaLaCartaEnCementerio(dragon3));
	}

	@Test
	public void testPongoUnMonstruoEnCadaLadoSiendoElPropioUnInsectoComeHombresBocaAbajoYAlSerAtacadoEsteDestruyeAlAtacanteSolamente() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CabezaExodia monstruoB = new CabezaExodia();

		mazoJugadorA.agregar(insectoComeHombres);
		mazoJugadorB.agregar(monstruoB);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		insectoComeHombres.invocarEnModoDefensaBocaAbajo();
		monstruoB.invocarEnModoAtaque();

		monstruoB.atacar(insectoComeHombres);

		int vidaEsperadaDeJugadorA = 8000;
		int vidaEsperadaDeJugadorB = 8000;

		assertTrue(campoJugadorB.estaLaCartaEnCementerio(monstruoB));
		assertFalse(campoJugadorA.estaLaCartaEnCementerio(insectoComeHombres));
		assertEquals(vidaEsperadaDeJugadorA, jugadorA.vida());
		assertEquals(vidaEsperadaDeJugadorB, jugadorB.vida());
	}

	@Test
	public void testPongoUnMonstruoEnemigoYUnCilindroMagicoDeMiLadoYCuandoElMonstruoEnemigoMeAtacaSeNiegaElAtaqueYloRecibeElJugadorEnemigo() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CilindroMagico cilindroMagico = new CilindroMagico();

		mazoJugadorA.agregar(insectoComeHombres);
		mazoJugadorB.agregar(cilindroMagico);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		insectoComeHombres.invocarEnModoAtaque();
		cilindroMagico.colocarBocaAbajo();

		insectoComeHombres.atacarDirectamenteAlOponente();

		int vidaEsperadaDeJugadorA = 8000 - 450;
		int vidaEsperadaDeJugadorB = 8000;

		assertEquals(vidaEsperadaDeJugadorA, jugadorA.vida());
		assertEquals(vidaEsperadaDeJugadorB, jugadorB.vida());
	}

	@Test
	public void testPongoUnMonstruoEnAmbosLadosYUnReinforcementsDeMiLadoYCuandoElMonstruoEnemigoMeAtacaMiMontruoAumentaElAtaqueEn500() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		CabezaExodia monstruoA = new CabezaExodia();
		AlphaTheMagnetWarrior monstruoB = new AlphaTheMagnetWarrior();
		Reinforcements cilindroMagico = new Reinforcements();

		mazoJugadorA.agregar(monstruoA);
		mazoJugadorA.agregar(cilindroMagico);
		mazoJugadorB.agregar(monstruoB);
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();

		monstruoA.invocarEnModoAtaque();
		monstruoB.invocarEnModoAtaque();

		cilindroMagico.colocarBocaAbajo();

		monstruoB.atacar(monstruoA);

		int vidaEsperadaDeJugadorA = 8000;
		int vidaEsperadaDeJugadorB = 8000 - 100;

		assertTrue(campoJugadorB.estaLaCartaEnCementerio(monstruoB));
		assertFalse(campoJugadorA.estaLaCartaEnCementerio(monstruoA));
		assertEquals(vidaEsperadaDeJugadorA, jugadorA.vida());
		assertEquals(vidaEsperadaDeJugadorB, jugadorB.vida());
	}

	@Test
	public void testElJugadorTieneQueTomarUnaCartaDelMazoEstandoEsteVacioPierde() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		
		assertEquals(jugadorB.nombre(),juego.ganador());
	}

	@Test
	public void testElJugadorTieneLasCincoPartesDelExodiaYElOtroPierde() throws Exception {
		// INICIALIZACION DEL JUEGO
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		//////Aca se agregan y crean las cartas///////
		
		mazoJugadorA.agregar(new CabezaExodia());
		mazoJugadorA.agregar(new BrazoIzquierdoExodia());
		mazoJugadorA.agregar(new BrazoDerechoExodia());
		mazoJugadorA.agregar(new PiernaIzquierdaExodia());
		mazoJugadorA.agregar(new PiernaDerechaExodia());
		mazoJugadorB.agregar(new InsectoComeHombres());
		
		//////////////////////////////////////////////
		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new VistaMock();
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		//////Fin de inicializacion de contexto///////

		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();
		
		assertEquals(jugadorA.nombre(),juego.ganador());
	}
}
