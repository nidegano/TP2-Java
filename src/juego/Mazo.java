package juego;

import cartas.Carta;

public class Mazo extends ContenedorDeCartas {
	public Jugador duenioDelMazo;

	public Mazo() {
		super();
		this.capacidad = 40;
	}

	public Carta tomarUnaCarta() {
		Carta carta = this.cartas.get(0);
		this.cartas.remove(0);
		return carta;
	}
	
	public void asignarDuenioDelMazo(Jugador jugador) {
		this.duenioDelMazo = jugador;
	}
}
