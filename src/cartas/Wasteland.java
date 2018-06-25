package cartas;

import efectos.EfectoWasteland;

public class Wasteland extends CartaDeCampo {

	public Wasteland() {
		super();
		this.efecto = new EfectoWasteland(this);
	}

	@Override
	public void sumarSiSosParteDeExodia(int suma) {
		// TODO Auto-generated method stub
		
	}

}
