package efectos;

import cartas.Carta;

public class EfectoWasteland extends EfectoDeCampo {

	public EfectoWasteland(Carta cartaDuenia) {
		super(cartaDuenia);
		this.aumentoDePuntosDeAtaque = 200;
		this.aumentoDePuntosDeDefensa = 300;
	}

}
