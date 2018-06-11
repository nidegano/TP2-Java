package cartas;

import estado.ModoInactivo;

public class AgujeroOscuro extends CartaMagica {

	public AgujeroOscuro() {
		this.estado = new ModoInactivo();
	}

	public void colocarBocaAbajo() {
		this.estado = new ModoInactivo();
	}

	public boolean estaBocaAbajo() {
		return this.estado.esInactivo();
	}

}
