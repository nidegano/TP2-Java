package juego;

import java.util.Collections;

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
		// CARTAS MONSTRUO
		this.agregar(new AlphaTheMagnetWarrior());
		this.agregar(new AncientBrain());
		this.agregar(new InsectoComeHombres());
		this.agregar(new Jinzo());
		// CARTAS MAGICAS
		this.agregar(new Fisura());
		this.agregar(new OllaDeLaCodicia());
		// CARTAS TRAMPA
		this.agregar(new CilindroMagico());
		this.agregar(new AgujeroOscuro());
		this.agregar(new Reinforcements());
		//CARTAS DE CAMPO
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

}
