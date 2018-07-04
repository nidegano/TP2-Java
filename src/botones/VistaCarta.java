package botones;

import cartas.Carta;
import cartas.CartaNula;
import javafx.scene.control.Button;
import v.Vista;
import v.VistaCampoJugadores;

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
	
	public void asignarCarta(Carta carta) {//no usar este metodo para vaciar
		this.carta = carta;
		this.setText(this.carta.obtenerNombre());
	}
	
	public abstract void vaciar();

	public void agregarAVistaCampoJugadores() {
		
		VistaCampoJugadores vistaCampoJugadores = this.vista.obtenerVistaCampoJugadores();
		VistaCarta lugar = vistaCampoJugadores.obtenerUnLugarVacio(this.carta); 
		//dependiendo del tipo de la carta busca en la zona correcta
		
		lugar.reemplazarPor(this);
		this.carta.asignarVista(lugar);
		//la vista en la que estamos (la que no es lugar) al finalizar el metodo queda desreferenciada de programa
	}
	
	public boolean estaLibre() {
		return this.carta.getClass().equals(CartaNula.class); //no encontramos otra forma de hacerlo
	}

	private void reemplazarPor(VistaCarta vistaCarta) {
		this.carta = vistaCarta.carta;
		this.setText(vistaCarta.getText());
	}

	public void liberarPorMuerteDeCarta() {
		this.vaciar();
		this.vista.liberarSeleccion();
	}

	public void deshabilitar() {
		this.setDisable(true);
	}
}
