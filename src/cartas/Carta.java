package cartas;

import estado.Estado;

public abstract class Carta {

	protected Estado estado;

	public boolean estaMuerta() {
		return this.estado instanceof ModoMuerta;
	}

	public void matar() {
		this.estado = new ModoMuerta();
	}
}
