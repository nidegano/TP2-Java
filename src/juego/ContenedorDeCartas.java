package juego;

import java.util.ArrayList;
import java.util.List;

import cartas.Carta;

public class ContenedorDeCartas {

	protected List<Carta> cartas;
	protected int capacidad;

	public ContenedorDeCartas() {
		this.cartas = new ArrayList<Carta>();
	}

	public void agregar(Carta carta) {
		this.cartas.add(carta);
	}

}
