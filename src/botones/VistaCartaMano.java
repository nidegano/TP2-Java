package botones;

import cartas.CartaNula;
import vista.Vista;

public class VistaCartaMano extends VistaCarta {

	public VistaCartaMano(Vista vista) {
		super(vista);
		this.setText("-");
	}

	@Override
	public void vaciar() {
		this.carta = new CartaNula();
		this.setText("-");
	}
}
