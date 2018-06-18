package juego;

import java.util.ArrayList;

import cartas.Carta;
import excepciones.CapacidadMaximaException;
import excepciones.CartaNoEstaException;
import excepciones.ContenedorDeCartasVacioException;

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
			throw new CartaNoEstaException();
		this.cartas.remove(carta);
	}

	public void matarATodasLasCartas() {
		for (Carta carta : this.cartas)
			carta.matar();
	}

	public void enviarCartasMuertasAlCementerio(ContenedorDeCartas cementerio) {
		for (Carta carta : this.cartas)
			if (carta.estaMuerta())
				cementerio.agregar(carta);
	}

}
