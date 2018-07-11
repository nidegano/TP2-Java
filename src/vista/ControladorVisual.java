package vista;

import java.util.ArrayList;

import cartas.Carta;
import cartas.CartaMonstruo;
import cartas.CartaNula;
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
	}
	
	public void finalizarComandoDeAtacar(Carta cartaNuevaSeleccion) {
		((CartaMonstruo) this.cartaSeleccionada).atacar((CartaMonstruo) cartaNuevaSeleccion);
		this.vistaCampoJugadores.actualizarVidaJugadores();
		this.cambiarAModoNormal();
		this.liberarSeleccion();
	}

	public void finalizarComandoDeAtacarAJugador() {

		((CartaMonstruo) this.cartaSeleccionada).atacarDirectamenteAlOponente();
		this.vistaCampoJugadores.actualizarVidaJugadores();
		this.cambiarAModoNormal();
		this.liberarSeleccion();
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


}
