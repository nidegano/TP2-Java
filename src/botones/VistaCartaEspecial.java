package botones;

import cartas.CartaNula;
import v.Vista;

public class VistaCartaEspecial extends VistaCarta {

	public VistaCartaEspecial(Vista vista) {
		super(vista);
		this.setText("Especial");
	}

	@Override
	public void vaciar() {
		this.carta = new CartaNula();
		this.setText("Especial");
	}
}
