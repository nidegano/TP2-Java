package testsIntegracion;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import cartas.AgujeroOscuro;
import cartas.CilindroMagico;
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
		
		Mazo mazo = new Mazo();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();
		mazo.agregar(insectoComeHombres);
		
		Jugador jugador = new Jugador(mazo);
		jugador.tomarCartaDelMazo();

		jugador.colocarCartaMonstruoEnModoAtaque(insectoComeHombres);
		jugador.sacrificarMonstruo(insectoComeHombres);

		assertTrue(jugador.estaLaCartaEnCementerio(insectoComeHombres));
	}

}