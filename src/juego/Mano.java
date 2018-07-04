package juego;

import cartas.Carta;
import excepciones.CapacidadMaximaException;
import excepciones.CartaNoEstaEnContenedorDeCartasException;
import excepciones.TengoTodasLasPartesDeExodiaException;

public class Mano extends ContenedorDeCartas {

	private RecolectorDePartesDeExodia recolectorDePartesDeExodia;

	public Mano() {
		super(7);
		this.recolectorDePartesDeExodia = new RecolectorDePartesDeExodia();
	}

	public void agregarAMano(Carta carta) throws CapacidadMaximaException, TengoTodasLasPartesDeExodiaException {
		if (this.cartas.size() == this.capacidad)
			throw new CapacidadMaximaException();
		this.cartas.add(carta);
		carta.serAgregadaALaMano(this);
		recolectorDePartesDeExodia.siEsUnaParteDelExodiaQueNoTeniaRecolectar(carta);
	}

	@Override
	public void remover(Carta carta) throws CartaNoEstaEnContenedorDeCartasException {
		if (!this.estaDentro(carta))
			throw new CartaNoEstaEnContenedorDeCartasException();
		this.cartas.remove(carta);
		recolectorDePartesDeExodia.remover(carta);
	}

	public Carta obtenerCarta(int posicion) {
		return this.cartas.get(posicion);
	}

}
