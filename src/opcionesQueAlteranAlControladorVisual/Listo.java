package opcionesQueAlteranAlControladorVisual;

import opcionesQueAlteranALaCarta.Opcion;
import vista.ControladorVisual;

public class Listo extends Opcion {

	public Listo(ControladorVisual vista) {
		super(vista);
		this.setText("Listo");
		
		this.setOnAction(value -> {
			
			this.controladorVisual.finalizarInvocacionPorSacrificio();
		});
	}
}
