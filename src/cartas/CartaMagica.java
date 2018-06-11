package cartas;

import estado.ModoActivo;
import estado.ModoInactivo;

public class CartaMagica extends Carta {

	
	
	public void colocarBocaArriba() {
		this.estado = new ModoActivo();
	}

	public boolean estaBocaArriba() {
		return this.estado.esActivo();
	}

	public void colocarBocaAbajo() {
		this.estado = new ModoInactivo();
	}

	public boolean estaBocaAbajo() {
		return this.estado.esInactivo();
	}
}
