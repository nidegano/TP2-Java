package botones;

import cartas.Carta;
import cartas.CartaNula;
import javafx.scene.control.Button;
import v.Vista;

public abstract class VistaCarta extends Button {
	
	protected Carta carta;
	protected Vista vista;

	public VistaCarta(Vista vista) {
		
		super("-");
		this.carta = new CartaNula();
		this.vista = vista;
		
		this.setMaxSize(100, 25);
		this.setMinSize(100, 25);
		this.setDisable(true);
		
		this.setOnAction(value -> {
			this.vista.avisarDeLaSeleccionDeUnaVistaDeCarta(this.carta);
		});
	}
	
	public void asignarCarta(Carta carta) {
		this.carta = carta;
		this.setText(this.carta.obtenerNombre());
	}
	
	public abstract void vaciar();
}
