package vista;

public class TextoDisplay {

	private Grilla grilla;
	
	public TextoDisplay(Grilla grilla) {
		this.grilla = grilla;
	}
	
	public void informarJugadorPerdio(String nombre) {
		this.grilla.cambiarLabelDeTextoDisplayPor(nombre);
	}

}
