package opciones;

import cartas.Carta;
import javafx.scene.control.Button;
import v.Vista;

public abstract class Opcion extends Button {
	
	protected Vista vista;
	
	public Opcion(Vista vista) {
		super("-");
		this.vista = vista;
		
		this.setMaxSize(200, 200);
		this.setVisible(false);
	}
	
	public abstract void aplicarComando(Carta cartaSeleccionada);
}
