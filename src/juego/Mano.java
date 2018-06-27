package juego;


import cartas.Carta;
import excepciones.CapacidadMaximaException;
import excepciones.CartaNoEstaEnContenedorDeCartasException;


public class Mano extends ContenedorDeCartas {

	private RecolectorDePartesDeExodia recolectorDePartesDeExodia;
	
	public Mano() {
		super(7);
		this.recolectorDePartesDeExodia = new RecolectorDePartesDeExodia();
	}
	
	@Override
	public void agregar(Carta carta) {
		if (this.cartas.size() == this.capacidad)
			throw new CapacidadMaximaException();
		this.cartas.add(carta);
		carta.serAgregadaALaMano(this);
		
			recolectorDePartesDeExodia.siEsUnaParteDelExodiaQueNoTeniaRecolectar(carta);
	}
	
	@Override
	public void remover(Carta carta) {
		if (!this.estaDentro(carta))
			throw new CartaNoEstaEnContenedorDeCartasException();
		this.cartas.remove(carta);
		
		recolectorDePartesDeExodia.remover(carta);
	}

/*	public boolean tenesTodasLasPartesDeExodia() {
		return recolectorDePartesDeExodia.tenesTodasLasPartesDelExodia();
	}*/

}
