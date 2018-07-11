package opcionesQueAlteranALaCarta;

import javafx.scene.control.Button;
import vista.ControladorVisual;

public abstract class Opcion extends Button {
	
	protected ControladorVisual controladorVisual;
	
	public Opcion(ControladorVisual vista) {
		super("-");
		this.controladorVisual = vista;
		
		this.setMaxSize(400, 200);
		this.setVisible(false);
	}
}
