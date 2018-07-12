package vista;

import java.io.File;
import java.util.ArrayList;

import cartas.Carta;
import cartas.CartaMonstruo;
import cartas.CartaNula;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import juego.Juego;
import juego.Jugador;
import modosDeControlador.ModoNormal;
import modosDeControlador.ModoSeleccionParaAtacar;
import modosDeControlador.ModoSeleccionParaSacrificio;
import opcionesQueAlteranALaCarta.Opcion;
import opcionesQueAlteranAlControladorVisual.Atacar;
import opcionesQueAlteranAlControladorVisual.InvocarConSacrificio;
import modosDeControlador.ModoDelControladorVisual;

public class ControladorVisual {
	
	private Juego juego;
	
	private Grilla grilla;
	private VistaCampoJugadores vistaCampoJugadores;
	private PanelDeAccion panelDeAccion;
	private TextoDisplay textoDisplay;
	
	private Carta cartaSeleccionada;
	private ModoDelControladorVisual modoVista;
	private InvocarConSacrificio opcionQuePidioElCambioDeModo;
	private ArrayList<CartaMonstruo> seleccionesSecundarias;
	
	private MediaPlayer sonidoDeAtaque;
	private MediaPlayer sonidoDeSacrificio;
	private MediaPlayer sonidoDeSeleccionDeCarta;

//Constructores
	
	public ControladorVisual(Jugador jugadorA, Jugador jugadorB, Juego juego) throws Exception {
		
		this.juego = juego;
		
		this.grilla = new Grilla(jugadorA,jugadorB,juego,this); //se contruye y coloca todo lo necesario (botones y labels)
		this.vistaCampoJugadores = new VistaCampoJugadores(jugadorA,jugadorB,grilla,this);
		this.panelDeAccion = new PanelDeAccion(grilla);
		this.textoDisplay = new TextoDisplay(grilla);
		
		this.cartaSeleccionada = new CartaNula();
		this.modoVista = new ModoNormal(this);
		this.seleccionesSecundarias = new ArrayList<CartaMonstruo>();
		
		this.inicializarSonidos();
	}

	private void inicializarSonidos() {
		
		String musicFile = "resources/sounds/ataque.wav";
		Media sound = new Media(new File(musicFile).toURI().toString());
		this.sonidoDeAtaque = new MediaPlayer(sound);
		
		String musicFile2 = "resources/sounds/sacrificio.wav";
		Media sound2 = new Media(new File(musicFile2).toURI().toString());
		this.sonidoDeSacrificio = new MediaPlayer(sound2);
		
		String musicFile3 = "resources/sounds/click.wav";
		Media sound3 = new Media(new File(musicFile3).toURI().toString());
		this.sonidoDeSeleccionDeCarta  = new MediaPlayer(sound3);
		
	}

	public ControladorVisual() {
		// para testear
	}


	
//Getters
	
	public Carta obtenerCartaSeleccionada() {
		return this.cartaSeleccionada;
	}

	public VistaCampoJugadores obtenerVistaCampoJugadores() {
		return this.vistaCampoJugadores;
	}

	public Jugador obtenerJugadorDeTurno() {
		return this.juego.jugadorDeTurno();
	}

	
	
//Metodos de carta seleccionada
	
	public void cambiarCartaSeleccionActualPor(Carta cartaNuevaSeleccion) {
		this.cartaSeleccionada = cartaNuevaSeleccion;
		this.panelDeAccion.actualizarPorCambioDeCartaSeleccionada(cartaNuevaSeleccion);
	}
	
	public void liberarSeleccion() {
		this.cartaSeleccionada = new CartaNula();
		this.panelDeAccion.actualizarPorCambioDeCartaSeleccionada(this.cartaSeleccionada);
	}
	
	
	
//Cambio de modo
	
	public void cambiarAModoSeleccionParaAtacar(Atacar atacar) {
		
		this.modoVista = new ModoSeleccionParaAtacar(this);
		this.vistaCampoJugadores.actualizarPorModoSeleccionParaAtacar();
		this.panelDeAccion.ocultarOpciones();
	}
	
	private void cambiarAModoNormal() {
		this.modoVista = new ModoNormal(this);
		this.colocarLaConfiguracionDeLosBotonesEnElEstadoPrevioAlCambioDeModo();
		this.grilla.deshabilitarBotonesQueRepresentanALosJugadores();
		
		//reinicio al estado inicial atributos
		this.opcionQuePidioElCambioDeModo = null;
		this.seleccionesSecundarias = new ArrayList<CartaMonstruo>();
		
		this.liberarSeleccion();
	}
	
	public void cambiarAModoSeleccionParaSacrificio(Opcion opcionQuePidioElCambioDeModo) {
		this.modoVista = new ModoSeleccionParaSacrificio(this);
		this.grilla.botonDeListoHacerVisible(true);
		this.opcionQuePidioElCambioDeModo = (InvocarConSacrificio) opcionQuePidioElCambioDeModo;
		this.vistaCampoJugadores.actualizarPorModoSeleccionParaSacrificar();
		this.panelDeAccion.ocultarOpciones();
	}

	private void colocarLaConfiguracionDeLosBotonesEnElEstadoPrevioAlCambioDeModo() {
		this.vistaCampoJugadores.cargarConfiguracionActual();
	}


	
//Reacciones ante un clickeo
	
	public void avisarDeLaSeleccionDeUnaVistaDeCarta(Carta cartaNuevaSeleccion) {
		this.activarSonidoDeClick();
		this.modoVista.avisarDeLaSeleccionDeUnaVistaDeCarta(cartaNuevaSeleccion);
	}

	public void avisarDeLaSeleccionDeJugador() {
		this.modoVista.avisarDeLaSeleccionDeJugador();
	}
		
	public void agregarSeleccionALasSeleccionesSecundarias(Carta cartaNuevaSeleccion) {
		this.seleccionesSecundarias.add((CartaMonstruo) cartaNuevaSeleccion); //cast seguro por contexto
		cartaNuevaSeleccion.vistaCarta().deshabilitar();
	}
	
	public void finalizarInvocacionPorSacrificio() {
		((InvocarConSacrificio) this.opcionQuePidioElCambioDeModo).finalizarInvocacionPorSacrificio(this.cartaSeleccionada,this.seleccionesSecundarias);
		this.grilla.botonDeListoHacerVisible(false);
		this.cambiarAModoNormal();
		this.activarSonidoDeSacrificio();
	}

	public void finalizarComandoDeAtacar(Carta cartaNuevaSeleccion) {
		((CartaMonstruo) this.cartaSeleccionada).atacar((CartaMonstruo) cartaNuevaSeleccion);
		this.vistaCampoJugadores.actualizarVidaJugadores();
		this.cambiarAModoNormal();
		this.liberarSeleccion();
		this.activarSonidoDeAtaque();
	}

	public void finalizarComandoDeAtacarAJugador() {

		((CartaMonstruo) this.cartaSeleccionada).atacarDirectamenteAlOponente();
		this.vistaCampoJugadores.actualizarVidaJugadores();
		this.cambiarAModoNormal();
		this.liberarSeleccion();
		this.activarSonidoDeAtaque();
	}

	
//Actualizar
	
	public void actualizarPorCambioDeTurno(Jugador jugadorDeTurno) {
		this.cambiarAModoNormal();
		this.vistaCampoJugadores.actualizarPorCambioDeTurno();
		this.panelDeAccion.actualizarPorCambioDeTurno(jugadorDeTurno);
		this.panelDeAccion.actualizarPorCambioDeFaseALaFase(jugadorDeTurno.obtenerFase());
		this.liberarSeleccion();
	}

//Otros	
	
	public void start(Stage primaryStage) throws Exception {
		this.grilla.start(primaryStage);
	}
	
	public void seTomoEstaCartaDelMazo(Carta unaCarta) {
		this.vistaCampoJugadores.seTomoEstaCartaDelMazo(unaCarta);
	}

	public void terminarJuego(String nombre){
		this.textoDisplay.informarQueTalJugadorPerdio(nombre);
		this.vistaCampoJugadores.actualizarPorFinDeJuego();
		this.liberarSeleccion();
	}

	public void reseleccionarCarta(CartaMonstruo cartaSeleccionada) {
		this.avisarDeLaSeleccionDeUnaVistaDeCarta(cartaSeleccionada);
	}
	
	private void activarSonidoDeAtaque() {
		this.sonidoDeAtaque.play();	
	}
	
	private void activarSonidoDeSacrificio() {
		this.sonidoDeSacrificio.play();	
	}
	
	private void activarSonidoDeClick() {
		this.sonidoDeSeleccionDeCarta.play();	
	}
}
