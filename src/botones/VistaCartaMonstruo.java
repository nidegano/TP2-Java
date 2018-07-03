package botones;

import cartas.CartaNula;
import v.Vista;

public class VistaCartaMonstruo extends VistaCarta {

	public VistaCartaMonstruo(Vista vista) {
		super(vista);
		this.setText("Monstruo");
	}

	@Override
	public void vaciar() {
		this.carta = new CartaNula();
		this.setText("Monstruo");
	}
}
