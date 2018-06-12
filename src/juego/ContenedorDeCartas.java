package juego;

import java.util.ArrayList;

import cartas.Carta;
import excepciones.CapacidadMaximaException;

public class ContenedorDeCartas {

	protected ArrayList<Carta> cartas;
	protected int capacidad;

	public ContenedorDeCartas() {
		this.cartas = new ArrayList<Carta>();
	}

	public void agregar(Carta carta) {
		if (this.cartas.size() == this.capacidad)
			throw new CapacidadMaximaException();
		this.cartas.add(carta);
	}

}
