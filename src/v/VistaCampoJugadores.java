package v;

import ConfiguracionesDeVistaCampoJugador.ConfiguracionDeLaVistaCampoJugador;
import botones.VistaCarta;
import cartas.Carta;
import cartas.CartaDeCampo;
import cartas.CartaEspecial;
import cartas.CartaMonstruo;
import juego.Jugador;
import juego.JugadorA;
import juego.JugadorB;
import vista.Grilla;

public class VistaCampoJugadores {
	
	private Grilla grilla;
	
	private JugadorA jugadorA;
	private JugadorB jugadorB;
	private Vista vista;

	public VistaCampoJugadores(JugadorA jugadorA,JugadorB jugadorB,Grilla grilla,Vista vista) {
		this.grilla = grilla;
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
		this.vista = vista;
	}

	public VistaCarta obtenerUnLugarVacio(Carta carta) {

		return carta.obtenerLugarVacioMedianteVistaCampoJugadores(this);
	}
	
	public VistaCarta obtenerUnLugarVacio(CartaMonstruo carta) {
		return carta.obtenerDuenio().obtenerLugarParaVistaCartaMonstruoDependiendoDelJugadorATravezDeGrilla(this.grilla);
	}
	
	public VistaCarta obtenerUnLugarVacio(CartaEspecial carta) {
		return carta.obtenerDuenio().obtenerLugarParaVistaCartaEspecialDependiendoDelJugadorATravezDeGrilla(this.grilla);
	}
	
	public VistaCarta obtenerUnLugarVacio(CartaDeCampo carta) {
		return carta.obtenerDuenio().obtenerLugarParaVistaCartaDeCampoDependiendoDelJugadorATravezDeGrilla(this.grilla);
	}

	public void actualizarPorModoSeleccionParaAtacar() {
		this.grilla.deshabilitarTodosLasVistasCarta();
		this.activarSoloLasVistasCartaMonstruosDeJugadorDeTurno(this.vista.jugadorDeTurno());
		//aca falta lo de si no hay monstruos se activa para atacar al jugador
	}

	private void activarSoloLasVistasCartaMonstruosDeJugadorDeTurno(Jugador jugadorDeTurno) {
		jugadorDeTurno.determinarQueMonstruosHabilitarSegunQueJugadorEsATravezDeGrilla(this.grilla);
	}

	public void actualizarVidaJugadores() {
		this.grilla.asignarNuevaVidaALabelDeJugadorA(this.jugadorA.vida());
		this.grilla.asignarNuevaVidaALabelDeJugadorB(this.jugadorB.vida());
	}

	public void actualizarPorCambioDeTurno(Jugador jugadorDeTurno) {
		ConfiguracionDeLaVistaCampoJugador configuracion = jugadorDeTurno.determinarElEstadoDeLaVistaCampoJugadoresDependiendoDeQuienSeaElTurnoYLaFase();
		configuracion.configurar(this.grilla);
	}
}
