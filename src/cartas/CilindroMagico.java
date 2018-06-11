package cartas;

import estado.ModoInactivo;

public class CilindroMagico extends CartaTrampa {

	public void colocarBocaAbajo() {
		this.estado = new ModoInactivo();
	}

	public boolean estaBocaAbajo() {
		return this.estado.esInactivo();
	}

}
