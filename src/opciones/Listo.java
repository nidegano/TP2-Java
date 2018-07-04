package opciones;

import vista.Vista;

public class Listo extends Opcion {

	public Listo(Vista vista) {
		super(vista);
		this.setText("Listo");
		
		this.setOnAction(value -> {
			
			this.vista.finalizarInvocacionPorSacrificio();
		});
	}
}
