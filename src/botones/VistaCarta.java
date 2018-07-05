package botones;

import cartas.Carta;
import cartas.CartaNula;
import javafx.scene.control.Button;
import vista.Vista;
import vista.VistaCampoJugadores;

public class VistaCarta extends Button {
	
	protected Carta carta;
	protected Vista vista;

	public VistaCarta(Vista vista) {
		
		super("-");
		this.carta = new CartaNula();
		this.vista = vista;
		
		this.setMaxSize(150, 25);
		this.setMinSize(150, 25);
		this.setVisible(true);
		this.setDisable(true);
		
		this.setOnAction(value -> {
			this.vista.avisarDeLaSeleccionDeUnaVistaDeCarta(this.carta);
		});
	}
	
	public void asignarCarta(Carta carta) {
		this.carta = carta;
		this.setText(this.carta.obtenerNombre());
	}
	
	public void vaciar() {
		this.asignarCarta(new CartaNula());
	}

	public void agregarAVistaCampoJugadores() {
		
		VistaCampoJugadores vistaCampoJugadores = this.vista.obtenerVistaCampoJugadores();
		VistaCarta lugar = vistaCampoJugadores.obtenerUnLugarVacio(this.carta); 
		//dependiendo del tipo de la carta busca en la zona correcta
		
		lugar.reemplazarPor(this); //tambien se asigna la carta a la vista
		this.carta.asignarVistaCarta(lugar);
		//la vista en la que estamos (la que no es lugar) al finalizar el metodo queda desreferenciada del programa
	}
	
	public void agregarALaZonaDeLaManoDelJugadorCorrespondiente() {
		
		VistaCampoJugadores vistaCampoJugadores = this.vista.obtenerVistaCampoJugadores();
		VistaCarta lugar = vistaCampoJugadores.obtenerUnLugarVacioDeLaZonaDeManoDependiendoDelJugadorATravezDeLaGrilla(this.carta); 
		//dependiendo del tipo de la carta busca en la zona correcta
		
		lugar.reemplazarPor(this);
		this.carta.asignarVistaCarta(lugar);
		//la vista en la que estamos (la que no es lugar) al finalizar el metodo queda desreferenciada de programa
	}
	
	public boolean estaLibre() {
		return this.carta.getClass().equals(CartaNula.class); //no encontramos otra forma de hacerlo
	}

	public void reemplazarPor(VistaCarta vistaCarta) {
		this.asignarCarta(vistaCarta.carta); //la carta que almacena es lo que determina como es la VistaCarta
	}

	public void desvincular() {
		this.desvincularCartaDeEstaVistaCarta();
		this.vista.liberarSeleccion();
	}

	private void desvincularCartaDeEstaVistaCarta() {
		VistaCarta nuevaVistaCartaParaLaCarta = new VistaCarta(this.vista); //creo una nueva VistaCarta
		nuevaVistaCartaParaLaCarta.asignarCarta(this.carta); //le asigno la carta
		this.carta.asignarVistaCarta(nuevaVistaCartaParaLaCarta); //a la carta le asigno la nueva VistaCarta
		this.vaciar(); // a la anterior VistaCarta la desvinculo de la carta pero no de la Vista
	}

	public void deshabilitar() {
		this.setDisable(true);
	}

	public Vista vista() {
		return this.vista;
	}

	public Carta carta() {
		return this.carta;
	}
}
