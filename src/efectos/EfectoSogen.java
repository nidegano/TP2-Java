package efectos;

import cartas.Carta;

public class EfectoSogen extends EfectoDeCampo {

	public EfectoSogen(Carta cartaDuenia) {
		super(cartaDuenia);
		this.aumentoDePuntosDeAtaque = 200;
		this.aumentoDePuntosDeDefensa = 500;
	}

}
