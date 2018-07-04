package juego;

import java.util.Collections;

import cartas.*;
import excepciones.MazoSinCartasException;
import vista.Vista;

public class Mazo extends ContenedorDeCartas {

	public Mazo() {
		super(40);
	}

	public Carta tomarUnaCarta() {
		try {
			return this.cartas.remove(0);
		} catch (IndexOutOfBoundsException e) {
			throw new MazoSinCartasException();
		}
	}

	public void generarCartas() {
		// CARTAS MONSTRUO
		for (int i = 0; i <= 3; i++) {
			this.agregar(new AlphaTheMagnetWarrior());
			this.agregar(new AncientBrain());
			this.agregar(new DragonArmadoOscuro());
			this.agregar(new EspadachinSilencioso());
			this.agregar(new InsectoComeHombres());
			this.agregar(new Jinzo());
		}
		this.agregar(new DragonBlancoDeOjosAzules());
		this.agregar(new DragonBlancoDeOjosAzules());
		this.agregar(new DragonBlancoDeOjosAzules());
		this.agregar(new DragonDefinitivo());
		// CARTAS MAGICAS
		this.agregar(new Fisura());
		this.agregar(new OllaDeLaCodicia());
		// CARTAS TRAMPA
		this.agregar(new CilindroMagico());
		this.agregar(new AgujeroOscuro());
		this.agregar(new Reinforcements());
		// CARTAS DE CAMPO
		this.agregar(new Sogen());
		this.agregar(new Wasteland());
		// CARTAS EXODIA
		this.agregar(new CabezaExodia());
		this.agregar(new BrazoDerechoExodia());
		this.agregar(new BrazoIzquierdoExodia());
		this.agregar(new PiernaDerechaExodia());
		this.agregar(new PiernaIzquierdaExodia());

		Collections.shuffle(this.cartas);
	}

	public void asignarComoDuenioDeTodasLasCartasA(Jugador jugador) {
		for (Carta carta : this.cartas) {
			carta.asignarDuenio(jugador);
		}
	}

	public void asignarVistaACartas(Vista vista) {
		for (Carta carta : this.cartas) {
			carta.asignarVista(vista);
		}
	}

}
