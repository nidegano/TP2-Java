package testsIntegracion;

import static org.junit.Assert.assertEquals;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import cartas.AlphaTheMagnetWarrior;
import cartas.AncientBrain;
import cartas.BrazoDerechoExodia;
import cartas.BrazoIzquierdoExodia;
import cartas.CilindroMagico;
import cartas.DragonBlancoDeOjosAzules;
import cartas.DragonDefinitivo;
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
import juego.ContenedorDeCartas;
import juego.Juego;
import juego.Jugador;
import juego.Mazo;

public class SegundaEntregaTest {
	
	@Test
	public void testPongoUnMonstruoEnCadaLadoActivoUnaCartaWastelandYAumenta200DeAtaqueMiMonstruoY300DeDefensaElOtro() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();
		
		Campo campoA = new Campo(mazoA);
		Campo campoB = new Campo(mazoB);
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		AncientBrain monstruoA = new AncientBrain();
		AncientBrain monstruoB = new AncientBrain();
		
		Wasteland wasteland = new Wasteland();
		
		mazoA.agregar(monstruoA);
		mazoB.agregar(monstruoB);
		mazoA.agregar(wasteland);
		
		monstruoA.asignarDuenio(jugadorA);
		monstruoB.asignarDuenio(jugadorB);
		wasteland.asignarDuenio(jugadorA);
		
		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();
		
		monstruoA.invocarEnModoAtaque(); //no es lo mismo invocarEnModoAtaque que colocarEnModoAtaque, invocar podria hacer mas cosas que solo cambiar el estado
		monstruoB.invocarEnModoAtaque();
		
		wasteland.colocarBocaArriba();
		
		monstruoA.atacar(monstruoB);
		
		int vidaEsperadaDeJugadorB = 8000 - ((1000 + 200) - (700 + 300));
		
		assertEquals(vidaEsperadaDeJugadorB,jugadorB.vida());	
	}
	
	@Test
	public void testPongoUnMonstruoEnCadaLadoActivoUnaCartaSogenYAumenta200DeAtaqueMiMonstruoY500DeDefensaElOtro() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();
		
		Campo campoA = new Campo(mazoA);
		Campo campoB = new Campo(mazoB);
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		AncientBrain monstruoA = new AncientBrain();
		AncientBrain monstruoB = new AncientBrain();
		
		Sogen sogen = new Sogen();
		
		monstruoA.asignarDuenio(jugadorA);
		monstruoB.asignarDuenio(jugadorB);
		sogen.asignarDuenio(jugadorA);
		
		mazoA.agregar(monstruoA);
		mazoA.agregar(sogen);
		mazoB.agregar(monstruoB);
		
		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();
		
		monstruoA.invocarEnModoAtaque();
		monstruoB.invocarEnModoAtaque();
		
		sogen.colocarBocaArriba();
		
		monstruoA.atacar(monstruoB);
		
		int vidaEsperadaDeJugadorB = 8000 - ((1000 + 200) - (700 + 300));
		
		assertEquals(vidaEsperadaDeJugadorB,jugadorB.vida());	
	}
	
	@Test
	public void testActivoUnaCartaOllaDeLaCodiciaYSeTomanDosCartasDelMazo() {
		Mazo mazoA = new Mazo();
		
		OllaDeLaCodicia ollaDeLaCodicia = new OllaDeLaCodicia();
		
		mazoA.agregar(ollaDeLaCodicia);	
		
		mazoA.agregar(new Jinzo());
		mazoA.agregar(new Jinzo());

		Campo campoA = new Campo(mazoA);
		
		Jugador jugadorA = new Jugador(campoA);
		
		ollaDeLaCodicia.asignarDuenio(jugadorA);
		
		jugadorA.tomarCartaDelMazo();
		
		ollaDeLaCodicia.colocarBocaArriba();
		
		int cartasEsperadasEnMano = 2;
		
		assertEquals(cartasEsperadasEnMano,jugadorA.cantidadDeCartasEnMano());	
	}
	
	@Test
	public void testPongoDosMonstruosEnemigosActivoUnaCartaFisuraYMuereElMonstruoDeMenorAtaque() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();
		
		Campo campoA = new Campo(mazoA);
		Campo campoB = new Campo(mazoB);
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		Jinzo monstruo1 = new Jinzo(); // es el de menor ataque de los dos
		CabezaExodia monstruo2 = new CabezaExodia();
		
		Fisura fisura = new Fisura();
		
		mazoA.agregar(fisura);
		mazoB.agregar(monstruo1);
		mazoB.agregar(monstruo2);
		
		monstruo1.asignarDuenio(jugadorB);
		monstruo2.asignarDuenio(jugadorB);
		fisura.asignarDuenio(jugadorA);
		
		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();
		
		monstruo1.invocarEnModoAtaque();
		monstruo2.invocarEnModoAtaque();
		
		fisura.colocarBocaArriba();
		
		assertTrue(campoB.estaLaCartaEnCementerio(monstruo1));	
	}
	
	@Test
	public void testPongoUnMonstruoEnCadaLadoSiendoElPropioUnJinzoYVeoQueSePuedeAtacarDirectamenteAlJugadorContrario() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();
		
		Campo campoA = new Campo(mazoA);
		Campo campoB = new Campo(mazoB);
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		Jinzo jinzo = new Jinzo();
		CabezaExodia monstruoB = new CabezaExodia();
		
		jinzo.asignarDuenio(jugadorA);
		monstruoB.asignarDuenio(jugadorB);
		
		mazoA.agregar(jinzo);
		mazoB.agregar(monstruoB);
		
		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();
		
		jinzo.invocarEnModoAtaque();
		monstruoB.invocarEnModoDefensa();
		
		jinzo.atacarDirectamenteAlOponente();
		
		int vidaEsperadaDeJugadorB = 8000 - 500;
		
		assertEquals(vidaEsperadaDeJugadorB,jugadorB.vida());	
	}
	
	@Test
	public void testPongo3DragonesBlancosDeOjosAzulesPongoUnDragonDefinitivoYSeSacrificanLosTresDragonesBlancosDeOjosAzules() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();
		
		Campo campoA = new Campo(mazoA);
		Campo campoB = new Campo(mazoB);
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		ContenedorDeCartas sacrificios1 = this.prepararTantosMonstruosParaSacrificar(2, jugadorA);
		ContenedorDeCartas sacrificios2 = this.prepararTantosMonstruosParaSacrificar(2, jugadorA);
		ContenedorDeCartas sacrificios3 = this.prepararTantosMonstruosParaSacrificar(2, jugadorA);
		
		DragonBlancoDeOjosAzules dragon1 = new DragonBlancoDeOjosAzules(sacrificios1);
		DragonBlancoDeOjosAzules dragon2 = new DragonBlancoDeOjosAzules(sacrificios2);
		DragonBlancoDeOjosAzules dragon3 = new DragonBlancoDeOjosAzules(sacrificios3);
		
		dragon1.asignarDuenio(jugadorA);
		dragon2.asignarDuenio(jugadorA);
		dragon3.asignarDuenio(jugadorA);
		
		mazoA.agregar(dragon1);
		mazoA.agregar(dragon2);
		mazoA.agregar(dragon3);
		
		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();
		
		dragon1.invocarEnModoAtaque();
		dragon2.invocarEnModoAtaque();
		dragon3.invocarEnModoAtaque();
		
		ContenedorDeCartas sacrificios = new ContenedorDeCartas(3);
		sacrificios.agregar(dragon1);
		sacrificios.agregar(dragon2);
		sacrificios.agregar(dragon3);
		
		DragonDefinitivo dragonDefinitivo = new DragonDefinitivo(sacrificios); //se pasa las referencias a los dragones
		dragonDefinitivo.asignarDuenio(jugadorA);
		
		mazoA.agregar(dragonDefinitivo);
		jugadorA.tomarCartaDelMazo();
		
		dragonDefinitivo.invocarEnModoAtaque(); // se sacrifica a los dragones
		
		assertTrue(campoA.estaDentro(dragonDefinitivo));
		assertTrue(campoA.estaLaCartaEnCementerio(dragon1));	
		assertTrue(campoA.estaLaCartaEnCementerio(dragon2));	
		assertTrue(campoA.estaLaCartaEnCementerio(dragon3));	
	}
	
	@Test
	public void testPongoUnMonstruoEnCadaLadoSiendoElPropioUnInsectoComeHombresBocaAbajoYAlSerAtacadoEsteDestruyeAlAtacanteSolamente() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();
		
		Campo campoA = new Campo(mazoA);
		Campo campoB = new Campo(mazoB);
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CabezaExodia monstruoB = new CabezaExodia();
		
		insectoComeHombres.asignarDuenio(jugadorA);
		monstruoB.asignarDuenio(jugadorB);
		
		mazoA.agregar(insectoComeHombres);
		mazoB.agregar(monstruoB);
		
		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();
		
		insectoComeHombres.invocarEnModoDefensaBocaAbajo();
		monstruoB.invocarEnModoAtaque();
		
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
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();
		
		Campo campoA = new Campo(mazoA);
		Campo campoB = new Campo(mazoB);
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		CilindroMagico cilindroMagico = new CilindroMagico();
		
		insectoComeHombres.asignarDuenio(jugadorA);
		cilindroMagico.asignarDuenio(jugadorB);
		
		mazoA.agregar(insectoComeHombres);
		mazoB.agregar(cilindroMagico);
		
		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();
		
		insectoComeHombres.invocarEnModoAtaque();
		cilindroMagico.colocarBocaAbajo();
		
		insectoComeHombres.atacarDirectamenteAlOponente();
		
		int vidaEsperadaDeJugadorA = 8000 - 450;
		int vidaEsperadaDeJugadorB = 8000;
		
		assertEquals(vidaEsperadaDeJugadorA,jugadorA.vida());
		assertEquals(vidaEsperadaDeJugadorB,jugadorB.vida());
	}
	
	@Test
	public void testPongoUnMonstruoEnAmbosLadosYUnReinforcementsDeMiLadoYCuandoElMonstruoEnemigoMeAtacaMiMontruoAumentaElAtaqueEn500() {
		Mazo mazoA = new Mazo();
		Mazo mazoB = new Mazo();
		
		Campo campoA = new Campo(mazoA);
		Campo campoB = new Campo(mazoB);
		
		Jugador jugadorA = new Jugador(campoA);
		Jugador jugadorB = new Jugador(campoB);
		
		jugadorA.asignarOponente(jugadorB);
		jugadorB.asignarOponente(jugadorA);
		
		CabezaExodia monstruoA = new CabezaExodia();
		AlphaTheMagnetWarrior monstruoB = new AlphaTheMagnetWarrior(); //carta nueva
		Reinforcements cilindroMagico = new Reinforcements();
		
		monstruoA.asignarDuenio(jugadorA);
		monstruoB.asignarDuenio(jugadorB);
		
		cilindroMagico.asignarDuenio(jugadorA);
		
		mazoA.agregar(monstruoA);
		mazoA.agregar(cilindroMagico);
		mazoB.agregar(monstruoB);
		
		jugadorA.tomarCartaDelMazo();
		jugadorA.tomarCartaDelMazo();
		jugadorB.tomarCartaDelMazo();
		
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
		Campo campoB = new Campo(mazoB);
		Jugador jugadorB = new Jugador(campoB);
		
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
		Campo campoB = new Campo(mazoB);
		Jugador jugadorB = new Jugador(campoB);
		
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
	
	private ContenedorDeCartas prepararTantosMonstruosParaSacrificar(int cantidadDeMonstruos,Jugador dueñoDeSacrificio) {
		
		ContenedorDeCartas sacrificios = new ContenedorDeCartas(cantidadDeMonstruos);
		
		for (int i = 1 ; i<=cantidadDeMonstruos ;i++) {
			
			Jinzo jinzo = new Jinzo();
			sacrificios.agregar(jinzo);
			jinzo.asignarDuenio(dueñoDeSacrificio);			
		}
		return sacrificios;
	}
	
}
