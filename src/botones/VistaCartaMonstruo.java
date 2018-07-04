package botones;

import cartas.CartaNula;
import vista.Vista;

public class VistaCartaMonstruo extends VistaCarta {

	public VistaCartaMonstruo(Vista vista) {
		super(vista);
		this.setText("-");
	}

	@Override
	public void vaciar() {
		this.carta = new CartaNula();
		this.setText("-");
	}
}
