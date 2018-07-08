package vista;

import java.util.ArrayList;

import cartas.Carta;
import cartas.CartaMonstruo;
import cartas.CartaNula;
import javafx.stage.Stage;
import juego.Juego;
import juego.Jugador;
import modosDeVista.ModoNormal;
import modosDeVista.ModoSeleccionParaAtacar;
import modosDeVista.ModoSeleccionParaSacrificio;
import modosDeVista.ModoVista;
import opciones.Atacar;
import opciones.InvocarConSacrificio;
import opciones.Opcion;

public class Vista {
	
	private Juego juego;
	
	private Grilla grilla;
	private VistaCampoJugadores vistaCampoJugadores;
	private PanelDeAccion panelDeAccion;
	private TextoDisplay textoDisplay;
	
	private Carta cartaSeleccionada;
	private ModoVista modoVista;
	private Opcion opcionQuePidioElCambioDeModo;
	private ArrayList<CartaMonstruo> seleccionesSecundarias;
	
	public Vista(Jugador jugadorA, Jugador jugadorB, Juego juego) throws Exception {
		
		this.juego = juego;
		
		this.grilla = new Grilla(jugadorA,jugadorB,juego,this); //se contruye y coloca todo lo necesario (botones y labels)
		this.vistaCampoJugadores = new VistaCampoJugadores(jugadorA,jugadorB,grilla,this);
		this.panelDeAccion = new PanelDeAccion(grilla);
		this.textoDisplay = new TextoDisplay(grilla);
		
		this.cartaSeleccionada = new CartaNula();
		this.modoVista = new ModoNormal(this);
		this.seleccionesSecundarias = new ArrayList<CartaMonstruo>();
	}

	public Vista() {
		// para testear
	}

	public Carta obtenerCartaSeleccionada() {
		return this.cartaSeleccionada;
	}

	public VistaCampoJugadores obtenerVistaCampoJugadores() {
		return this.vistaCampoJugadores;
	}

	public void start(Stage primaryStage) throws Exception {
		this.grilla.start(primaryStage);
	}

	public void cambiarCartaSeleccionActualPor(Carta cartaNuevaSeleccion) {
		this.cartaSeleccionada = cartaNuevaSeleccion;
		this.panelDeAccion.actualizarPorCambioDeCartaSeleccionada(cartaNuevaSeleccion);
	}

	public Jugador jugadorDeTurno() {
		return this.juego.jugadorDeTurno();
	}

	public void actualizarPorCambioDeTurno(Jugador jugadorDeTurno) {
		this.vistaCampoJugadores.actualizarPorCambioDeTurno(jugadorDeTurno);
		this.panelDeAccion.actualizarPorCambioDeTurno(jugadorDeTurno);
		this.panelDeAccion.actualizarPorCambioDeFaseALaFase(jugadorDeTurno.obtenerFase());
		this.liberarSeleccion();
	}

	public void seTomoEstaCartaDelMazo(Carta unaCarta) {
		this.vistaCampoJugadores.seTomoEstaCartaDelMazo(unaCarta);
	}

	public void terminarJuego(String nombre){
		this.textoDisplay.informarQueTalJugadorPerdio(nombre);
		this.vistaCampoJugadores.actualizarPorFinDeJuego();
		this.liberarSeleccion();
	}

	public void liberarSeleccion() {
		this.cartaSeleccionada = new CartaNula();
		this.panelDeAccion.actualizarPorCambioDeCartaSeleccionada(this.cartaSeleccionada);
	}
	
	public void avisarDeLaSeleccionDeUnaVistaDeCarta(Carta cartaNuevaSeleccion) {
		this.modoVista.avisarDeLaSeleccionDeUnaVistaDeCarta(cartaNuevaSeleccion);
	}
	
	public void avisarDeLaSeleccionDeJugador() {
		this.modoVista.avisarDeLaSeleccionDeJugador();
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
	
	private void colocarLaConfiguracionDeLosBotonesEnElEstadoPrevioAlCambioDeModo() {
		this.vistaCampoJugadores.actualizarPorCambioDeTurno(this.juego.jugadorDeTurno());		
	}

	public void cambiarAModoSeleccionParaSacrificio(Opcion opcionQuePidioElCambioDeModo) {
		this.modoVista = new ModoSeleccionParaSacrificio(this);
		this.grilla.botonDeListoHacerVisible(true);
		this.opcionQuePidioElCambioDeModo = opcionQuePidioElCambioDeModo;
		this.vistaCampoJugadores.actualizarPorModoSeleccionParaSacrificar();
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
	
	public void cambiarAModoSeleccionParaAtacar(Atacar atacar) {
		this.modoVista = new ModoSeleccionParaAtacar(this);
		this.vistaCampoJugadores.actualizarPorModoSeleccionParaAtacar();
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

}
