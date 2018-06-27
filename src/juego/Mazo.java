package juego;

import cartas.Carta;
import excepciones.MazoSinCartasException;

public class Mazo extends ContenedorDeCartas {

	public Mazo() {
		super(40); // 40 cartas en el mazo
	}

	public Carta tomarUnaCarta() {
		try {
			return this.cartas.remove(0);
		} 
		catch(IndexOutOfBoundsException e) {
			throw new MazoSinCartasException();
		}
	}

}
