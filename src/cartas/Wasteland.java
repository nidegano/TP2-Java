package cartas;

import efectos.EfectoWasteland;

public class Wasteland extends CartaDeCampo {

	public Wasteland() {
		super();
		this.efecto = new EfectoWasteland(this);
	}

}
