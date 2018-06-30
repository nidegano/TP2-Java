package juego;

import cartas.*;
import excepciones.MazoSinCartasException;

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
		this.agregar(new AgujeroOscuro());
		this.agregar(new AlphaTheMagnetWarrior());
		this.agregar(new AncientBrain());
		this.agregar(new BrazoDerechoExodia());
		this.agregar(new BrazoIzquierdoExodia());
		this.agregar(new CabezaExodia());
		this.agregar(new CilindroMagico());
		this.agregar(new Fisura());
		this.agregar(new InsectoComeHombres());
		this.agregar(new Jinzo());
		this.agregar(new OllaDeLaCodicia());
		this.agregar(new PiernaDerechaExodia());
		this.agregar(new PiernaIzquierdaExodia());
		this.agregar(new Reinforcements());
		this.agregar(new Sogen());
		this.agregar(new Wasteland());
	}

}
