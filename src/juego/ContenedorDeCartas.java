package juego;

import java.util.ArrayList;
import java.util.Iterator;

import cartas.Carta;
import excepciones.CapacidadMaximaException;
import excepciones.CartaNoEstaEnContenedorDeCartasException;
import excepciones.ContenedorDeCartasVacioException;

public class ContenedorDeCartas implements Iterable<Carta> {

	protected ArrayList<Carta> cartas;
	protected int capacidad;

	public ContenedorDeCartas(int capacidad) {
		this.cartas = new ArrayList<Carta>();
		this.capacidad = capacidad;
	}

	public void agregar(Carta carta) {
		if (this.cartas.size() == this.capacidad)
			throw new CapacidadMaximaException();
		if (!this.estaDentro(carta))
			this.cartas.add(carta);
	}

	public Carta obtenerPrimero() {
		try {
			return this.cartas.get(0);
		} catch (IndexOutOfBoundsException e) {
			throw new ContenedorDeCartasVacioException();
		}
	}

	public boolean estaDentro(Carta carta) {
		return this.cartas.contains(carta);
	}

	public void remover(Carta carta) {
		if (!this.estaDentro(carta))
			throw new CartaNoEstaEnContenedorDeCartasException();
		this.cartas.remove(carta);
	}

	public void matarATodasLasCartas() {
		Iterator<Carta> iterator = this.iterator();
		while ((iterator.hasNext()) && (this.cartas.size() != 0)) {
			Carta carta = iterator.next();
			carta.matar();
		}
	}

	public int cantidad() {
		return this.cartas.size();
	}

	public boolean hayCartas() {
		return this.cantidad() != 0;
	}

	@Override
	public Iterator<Carta> iterator() {
		return cartas.iterator();
	}

}
