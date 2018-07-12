package botones;

import cartas.Carta;
import cartas.CartaNula;
import javafx.scene.control.Button;
import vista.ControladorVisual;
import vista.VistaCampoJugadores;

public class VistaCartaConcreta extends Button implements VistaCarta{
	
	protected Carta carta;
	protected ControladorVisual controladorVisual;

	public VistaCartaConcreta(ControladorVisual vista) {
		
		super("-");
		this.carta = new CartaNula();
		this.controladorVisual = vista;
		
		this.setMaxSize(100, 25);
		this.setMinSize(100, 25);
		this.setVisible(true);
		this.setDisable(true);
		
		this.setOnAction(value -> {
			this.controladorVisual.avisarDeLaSeleccionDeUnaVistaDeCarta(this.carta);
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
		
		VistaCampoJugadores vistaCampoJugadores = this.controladorVisual.obtenerVistaCampoJugadores();
		VistaCarta lugar = vistaCampoJugadores.obtenerUnLugarVacio(this.carta); 
		//dependiendo del tipo de la carta busca en la zona correcta
		
		lugar.reemplazarPor(this); //tambien se asigna la carta a la vista
		this.carta.asignarVistaCarta(lugar);
		//la vista en la que estamos (la que no es lugar) al finalizar el metodo queda desreferenciada del programa
	}
	
	public void agregarALaZonaDeLaManoDelJugadorCorrespondiente() {
		
		VistaCampoJugadores vistaCampoJugadores = this.controladorVisual.obtenerVistaCampoJugadores();
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
		this.asignarCarta(vistaCarta.carta()); //la carta que almacena es lo que determina como es la VistaCarta
	}

	public void desvincular() {
		this.desvincularCartaDeEstaVistaCarta();
		this.controladorVisual.liberarSeleccion();
	}

	private void desvincularCartaDeEstaVistaCarta() {
		VistaCarta nuevaVistaCartaParaLaCarta = new VistaCartaConcreta(this.controladorVisual); //creo una nueva VistaCarta
		nuevaVistaCartaParaLaCarta.asignarCarta(this.carta); //le asigno la carta
		this.carta.asignarVistaCarta(nuevaVistaCartaParaLaCarta); //a la carta le asigno la nueva VistaCarta
		this.vaciar(); // a la anterior VistaCarta la desvinculo de la carta pero no de la Vista
	}

	public void deshabilitar() {
		this.setDisable(true);
	}

	public ControladorVisual vista() {
		return this.controladorVisual;
	}

	public Carta carta() {
		return this.carta;
	}
}
