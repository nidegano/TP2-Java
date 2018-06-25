package efectos;

import cartas.Carta;

public class EfectoSogen extends EfectoDeCampo {

	public EfectoSogen(Carta cartaDueña) {
		super(cartaDueña);
		this.aumentoDePuntosDeAtaque = 200;
		this.aumentoDePuntosDeDefensa = 500;
	}

}
