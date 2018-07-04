package vista;

import java.util.ArrayList;

import cartas.Carta;
import cartas.CartaMonstruo;
import cartas.CartaNula;
import fases.Fase;
import javafx.stage.Stage;
import juego.Juego;
import juego.Jugador;
import juego.JugadorA;
import juego.JugadorB;
import opciones.Atacar;
import opciones.InvocarConSacrificio;
import opciones.Opcion;

public class Vista {
	
	private Juego juego;
	
	private Grilla grilla;
	private VistaCampoJugadores vistaCampoJugadores;
	private PanelDeAccion panelDeAccion;
	//private TextoDisplay textoDisplay;
	
	private Carta cartaSeleccionada;
	private ModoVista modoVista;
	private Opcion opcionQuePidioElCambioDeModo;
	private ArrayList<CartaMonstruo> seleccionesSecundarias;
	
	public Vista(JugadorA jugadorA, JugadorB jugadorB, Juego juego) throws Exception {
		
		this.juego = juego;
		
		this.grilla = new Grilla(jugadorA,jugadorB,juego,this); //se contruye y coloca todo lo necesario (botones y labels)
		this.vistaCampoJugadores = new VistaCampoJugadores(jugadorA,jugadorB,grilla,this);
		this.panelDeAccion = new PanelDeAccion(grilla);
		//this.textoDisplay = new TextoDisplay();
		
		this.cartaSeleccionada = new CartaNula();
		this.modoVista = new ModoNormal(this);
		this.seleccionesSecundarias = new ArrayList<CartaMonstruo>();
	}

	public void avisarDeLaSeleccionDeUnaVistaDeCarta(Carta cartaNuevaSeleccion) {
		this.modoVista.avisarDeLaSeleccionDeUnaVistaDeCarta(cartaNuevaSeleccion);
	}

	public Carta obtenerCartaSeleccionada() {
		return this.cartaSeleccionada;
	}

	public VistaCampoJugadores obtenerVistaCampoJugadores() {
		return this.vistaCampoJugadores;
	}

	public void start(Stage primaryStage) throws Exception {
		grilla.start(primaryStage);
	}

	public void cambiarAModoSeleccionParaSacrificio(Opcion opcionQuePidioElCambioDeModo) {
		this.modoVista = new ModoSeleccionParaSacrificio(this);
		this.grilla.botonDeListoHacerVisible(true);
		this.opcionQuePidioElCambioDeModo = opcionQuePidioElCambioDeModo;
	}
	
	public void cambiarAModoSeleccionParaAtacar(Atacar atacar) {
		this.modoVista = new ModoSeleccionParaAtacar(this);
		this.vistaCampoJugadores.actualizarPorModoSeleccionParaAtacar();
	}

	public void liberarSeleccion() {
		this.cartaSeleccionada = new CartaNula();
		this.panelDeAccion.actualizarPorCambioDeCartaSeleccionada(this.cartaSeleccionada);
	}

	public void cambiarCartaSeleccionActualPor(Carta cartaNuevaSeleccion) {
		this.cartaSeleccionada = cartaNuevaSeleccion;
		this.panelDeAccion.actualizarPorCambioDeCartaSeleccionada(cartaNuevaSeleccion);
	}

	public void finalizarComandoDeAtacar(Carta cartaNuevaSeleccion) {
		((CartaMonstruo) this.cartaSeleccionada).atacar((CartaMonstruo) cartaNuevaSeleccion);
		//los casts son seguros por que en este contexto las unicas selecciones de cartas posibles son monstruos
		//aca va a haber problema con lo de atacar directamente al jugador
		this.vistaCampoJugadores.actualizarVidaJugadores();
		this.cambiarAModoNormal();
		this.cartaSeleccionada.obtenerVistaCarta().deshabilitar(); //esto es porque si ya ataco no puede atacar devuelta
	}

	private void cambiarAModoNormal() {
		this.modoVista = new ModoNormal(this);	
		this.vistaCampoJugadores.actualizarPorCambioDeTurno(this.juego.jugadorDeTurno());
		//para que cualquier configuracion de botones vuelva a como estaba antes
	}

	public Jugador jugadorDeTurno() {
		return this.juego.jugadorDeTurno();
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

	public void actualizarPorCambioDeFaseALaFase(Fase faseNueva) {
		this.panelDeAccion.actualizarPorCambioDeFaseALaFase(faseNueva);
	}

	public void actualizarPorCambioDeTurno(Jugador jugadorDeTurno) {
		this.vistaCampoJugadores.actualizarPorCambioDeTurno(jugadorDeTurno);
		this.panelDeAccion.actualizarPorCambioDeTurno(jugadorDeTurno);
	}

	public void seTomoEstaCartaDelMazo(Carta unaCarta) {
		this.vistaCampoJugadores.seTomoEstaCartaDelMazo(unaCarta);
	}
}
