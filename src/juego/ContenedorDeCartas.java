package juego;

import java.util.ArrayList;
import java.util.List;

import cartas.Carta;
import excepciones.CapacidadMaximaException;

public class ContenedorDeCartas {

	protected ArrayList<Carta> cartas;
	protected int capacidad;

	public ContenedorDeCartas(int capacidad) {
		this.cartas = new ArrayList<Carta>();
		this.capacidad = capacidad;
	}

	public void agregar(Carta carta) {
		if (this.cartas.size() == this.capacidad)
			throw new CapacidadMaximaException();
		this.cartas.add(carta);
	}

	public Carta obtenerPrimero() {

		return this.cartas.get(0);
	}

	public boolean estaDentro(Carta carta) {
		
		return this.cartas.contains(carta);
	}

	public void remover(Carta carta) {
		
		this.cartas.remove(carta);
	}

	public List<Carta> transferirTodasLasCartas() {
		
		return this.cartas;
	}

	public void eliminarTodasLasCartas() {
		
		for (Carta carta : this.cartas) {
			this.remover(carta);
		}
	}

	public List<Carta> obtenerCartasMuertas() {
		
		List<Carta> muertas = new ArrayList<Carta>();
		
		for (Carta carta : this.cartas) {
			if (carta.estaMuerta()) {
				muertas.add(carta);
			}
		}
		return muertas;
	}

	public void matarATodasLasCartas() {
		
		for (Carta carta : this.cartas) {

			carta.matar();
		}
	}
}
