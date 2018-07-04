package botones;

import cartas.CartaNula;
import vista.Vista;

public class VistaCartaDeCampo extends VistaCarta {

	public VistaCartaDeCampo(Vista vista) {
		super(vista);
		this.setText("De Campo");
	}

	@Override
	public void vaciar() {
		this.carta = new CartaNula();
		this.setText("De Campo");
	}
}
