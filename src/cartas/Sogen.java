package cartas;

import efectos.EfectoSogen;

public class Sogen extends CartaDeCampo {

	public Sogen() {
		super();
		this.efecto = new EfectoSogen(this);
	}

	@Override
	public void sumarSiSosParteDeExodia(int suma) {
		// TODO Auto-generated method stub
		
	}

}
