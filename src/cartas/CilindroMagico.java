package cartas;

import efectos.EfectoCilindroMagico;

public class CilindroMagico extends CartaTrampa {

	public CilindroMagico() {
		super();
		this.efecto = new EfectoCilindroMagico(this);
	}

	@Override
	public void sumarSiSosParteDeExodia(int suma) {
		// TODO Auto-generated method stub
		
	}
}
