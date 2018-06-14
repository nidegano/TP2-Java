package cartas;

import estado.ModoActivo;
import estado.ModoInactivo;

public class CartaMagica extends Carta {

	public void colocarBocaArriba() {
		this.estado = new ModoActivo();
	}

	public void colocarBocaAbajo() {
		this.estado = new ModoInactivo();
	}

	public boolean estaBocaArriba() {
		return this.estado.esActivo();
	}

	public boolean estaBocaAbajo() {
		return this.estado.esInactivo();
	}

}
