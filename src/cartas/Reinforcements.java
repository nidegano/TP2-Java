package cartas;

import efectos.EfectoReinforcements;

public class Reinforcements extends CartaTrampa {

	public Reinforcements() {
		super();
		this.efecto = new EfectoReinforcements(this);
	}

	@Override
	public void sumarSiSosParteDeExodia(int suma) {
		// TODO Auto-generated method stub
		
	}
}
