package vista;


import cartas.Carta;
import javafx.stage.Stage;
import juego.Jugador;
import opciones.Atacar;
import opciones.Opcion;

public class VistaMock extends Vista {

	public VistaMock() throws Exception {
		super();
	}
	
	@Override
	public Carta obtenerCartaSeleccionada() {
		return null;
	}
	
	@Override
	public VistaCampoJugadores obtenerVistaCampoJugadores() {
		return null;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	}

	@Override
	public void cambiarCartaSeleccionActualPor(Carta cartaNuevaSeleccion) {
	}

	@Override
	public Jugador jugadorDeTurno() {
		return null;
	}

	@Override
	public void actualizarPorCambioDeTurno(Jugador jugadorDeTurno) {
	}

	@Override
	public void seTomoEstaCartaDelMazo(Carta unaCarta) {
	}

	@Override
	public void terminarJuego(String nombre){
	}

	@Override
	public void liberarSeleccion() {
	}
	
	@Override
	public void avisarDeLaSeleccionDeUnaVistaDeCarta(Carta cartaNuevaSeleccion) {
	}
	
	@Override
	public void avisarDeLaSeleccionDeJugador() {
	}

	@Override
	public void cambiarAModoSeleccionParaSacrificio(Opcion opcionQuePidioElCambioDeModo) {
	}

	@Override
	public void agregarSeleccionALasSeleccionesSecundarias(Carta cartaNuevaSeleccion) {
	}
	
	@Override
	public void finalizarInvocacionPorSacrificio() {
	}
	
	@Override
	public void cambiarAModoSeleccionParaAtacar(Atacar atacar) {
	}
	
	@Override
	public void finalizarComandoDeAtacar(Carta cartaNuevaSeleccion) {
	}

	@Override
	public void finalizarComandoDeAtacarAJugador() {
	}

}
