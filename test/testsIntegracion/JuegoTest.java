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
		Jugador jugador = new Jugador();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();

		jugador.agregarCartaAMano(insectoComeHombres);
		jugador.colocarCartaMonstruo(insectoComeHombres, new ModoAtaque());

		assertTrue(jugador.tieneCartaMonstruoEnModoAtaque());
	}

	@Test
	void testColocarCartaMonstruoEnModoDefensa() {
		Jugador jugador = new Jugador();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();

		jugador.agregarCartaAMano(insectoComeHombres);
		jugador.colocarCartaMonstruo(insectoComeHombres, new ModoDefensa());

		assertTrue(jugador.tieneCartaMonstruoEnModoDefensa());
	}

	@Test
	void testColocarCartaMagicaBocaAbajo() {
		Jugador jugador = new Jugador();
		AgujeroOscuro agujeroOscuro = new AgujeroOscuro();

		jugador.agregarCartaAMano(agujeroOscuro);
		jugador.colocarCartaMagica(agujeroOscuro, new ModoInactivo());

		assertTrue(jugador.tieneCartaMagicaInactiva());
	}

	@Test
	void testColocarCartaTrampaBocaAbajo() {
		Jugador jugador = new Jugador();
		CilindroMagico cilindroMagico = new CilindroMagico();

		jugador.agregarCartaAMano(cilindroMagico);
		jugador.colocarCartaTrampa(cilindroMagico, new ModoInactivo());

		assertTrue(jugador.tieneCartaTrampaInactiva());
	}

	@Test
	void testSacrificarMonstruo() {
		Jugador jugador = new Jugador();
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres();

		jugador.agregarCartaAMano(insectoComeHombres);
		jugador.colocarCartaMonstruo(insectoComeHombres, new ModoAtaque());

		jugador.sacrificarMonstruo(insectoComeHombres);

		assertTrue(jugador.estaEnCementerio(insectoComeHombres));
	}

}
