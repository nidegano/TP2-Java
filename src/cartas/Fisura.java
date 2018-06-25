package cartas;

import efectos.EfectoFisura;

public class Fisura extends CartaMagica {

	public Fisura() {
		super();
		this.efecto = new EfectoFisura(this);
	}

	@Override
	public void sumarSiSosParteDeExodia(int suma) {
		// TODO Auto-generated method stub
		
	}

}