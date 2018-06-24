package cartas;

import efectos.EfectoSogen;

public class Sogen extends CartaDeCampo {
	
	public Sogen() {
		super();
		this.efecto = new EfectoSogen();
	}
}
