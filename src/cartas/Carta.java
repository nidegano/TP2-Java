package cartas;

import estado.Estado;
import estado.Muerto;
import estado.ModoInactivo;

public abstract class Carta {

	protected Estado estado;

	public Carta() {
		this.estado = new ModoInactivo();
	}

	public boolean estaMuerta() {
		return this.estado instanceof Muerto;
	}

	public void matar() {
		this.estado = new Muerto();
	}

}
