package cartas;

import estado.Estado;
import estado.ModoActivo;
import estado.ModoInactivo;


public class Carta {

	protected Estado estado;

	public boolean estaMuerta() {
		return this.estado instanceof ModoMuerta;
	}

	public void matar() {
		this.estado = new ModoMuerta();
	}
	
	public void colocarBocaArriba() {
		this.estado = new ModoActivo();
	}

	public void colocarBocaAbajo() {
		this.estado = new ModoInactivo();
	}

	public boolean estaBocaArriba() {
		return this.estado instanceof ModoActivo;
	}

	public boolean estaBocaAbajo() {
		return this.estado instanceof ModoInactivo;
	}
}
