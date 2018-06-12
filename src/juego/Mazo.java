package juego;

import cartas.Carta;

public class Mazo extends ContenedorDeCartas {

	public Mazo() {
		super();
		this.capacidad = 40;
	}

	public Carta tomarUnaCarta() {
		Carta carta = this.cartas.get(0);
		this.cartas.remove(0);
		return carta;
	}

}
