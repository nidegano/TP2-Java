package efectos;

import cartas.Carta;

public class EfectoWasteland extends EfectoDeCampo {

	public EfectoWasteland(Carta cartaDueña) {
		super(cartaDueña);
		this.aumentoDePuntosDeAtaque = 200;
		this.aumentoDePuntosDeDefensa = 300;
	}

}
