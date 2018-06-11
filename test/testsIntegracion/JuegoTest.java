package testsIntegracion;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import cartas.AgujeroOscuro;
import cartas.CilindroMagico;
import cartas.InsectoComeHombres;
import estado.ModoAtaque;
import estado.ModoDefensa;
import estado.ModoInactivo;
import juego.Jugador;

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
		
		Jugador jugador = new Jugador();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();

		jugador.agregarCartaAMano(insectoComeHombres);
		insectoComeHombres.colocarEnModoAtaque();
		jugador.sacrificarMonstruo(insectoComeHombres);

		assertTrue(jugador.estaLaCartaEnCementerio(insectoComeHombres));
	}

}
