package juego;

import cartas.Carta;

public class Mazo extends ContenedorDeCartas {

	public Mazo() {
		super(40); // 40 cartas en el mazo
	}

	public Carta tomarUnaCarta() {
		return this.cartas.remove(0);
	}

	public int capacidad() {
		return this.capacidad;
	}

}
