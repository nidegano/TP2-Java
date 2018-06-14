package cartas;

import estado.ModoInactivo;

public class CartaTrampa extends Carta {

	public void colocarBocaAbajo() {
		this.estado = new ModoInactivo();
	}

	public boolean estaBocaAbajo() {
		return this.estado.esInactivo();
	}

}
