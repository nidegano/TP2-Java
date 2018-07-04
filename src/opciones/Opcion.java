package opciones;

import javafx.scene.control.Button;
import vista.Vista;

public abstract class Opcion extends Button {
	
	protected Vista vista;
	
	public Opcion(Vista vista) {
		super("-");
		this.vista = vista;
		
		this.setMaxSize(200, 200);
		this.setVisible(false);
	}
}
