package cartas;

import efectos.EfectoCilindroMagico;

public class CilindroMagico extends CartaTrampa {

	public CilindroMagico() {
		super();
		this.efecto = new EfectoCilindroMagico(this);
	}

}
