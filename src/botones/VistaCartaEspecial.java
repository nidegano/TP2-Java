package botones;

import cartas.CartaNula;
import vista.Vista;

public class VistaCartaEspecial extends VistaCarta {

	public VistaCartaEspecial(Vista vista) {
		super(vista);
		this.setText("-");
	}

	@Override
	public void vaciar() {
		this.carta = new CartaNula();
		this.setText("-");
	}
}
