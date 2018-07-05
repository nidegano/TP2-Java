package vista;

public class TextoDisplay {

	private Grilla grilla;
	
	public TextoDisplay(Grilla grilla) {
		this.grilla = grilla;
	}
	
	public void informarQueTalJugadorPerdio(String nombre) {
		this.grilla.cambiarLabelDeTextoDisplayPor("PERDIO: ".concat(nombre));
	}

}
