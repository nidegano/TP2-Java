package botones;

import cartas.CartaNula;
import v.Vista;

public class VistaCartaMano extends VistaCarta {

	public VistaCartaMano(Vista vista) {
		super(vista);
		this.setText("Mano");
	}

	@Override
	public void vaciar() {
		this.carta = new CartaNula();
		this.setText("Mano");
	}
}