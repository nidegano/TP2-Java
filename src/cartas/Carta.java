package cartas;

import estado.Estado;
import estado.ModoMuerta;

public abstract class Carta {

	protected Estado estado;

	public boolean estaMuerta() {
		return this.estado instanceof ModoMuerta;
	}

	public void matar() {
		this.estado = new ModoMuerta();
	}
}
