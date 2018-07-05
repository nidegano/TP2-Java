package vista;

import botones.VistaCarta;
import cartas.Carta;
import cartas.CartaDeCampo;
import cartas.CartaEspecial;
import cartas.CartaMonstruo;
import configuracionesDeVistaCampoJugadores.ConfiguracionDeLaVistaCampoJugadores;
import juego.Jugador;
import juego.JugadorA;
import juego.JugadorB;

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

	public VistaCarta obtenerUnLugarVacioDeLaZonaDeManoDependiendoDelJugadorATravezDeLaGrilla(Carta carta) {
		return carta.obtenerDuenio().obtenerLugarVacioDeLaZonaDeManoATravezDeLaGrilla(this.grilla);
	}
	
	public void actualizarPorModoSeleccionParaAtacar() {
		this.grilla.deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores();
		this.activarSoloLasVistasCartaMonstruosNoVaciasDelOponenteDeJugadorDeTurno(this.vista.jugadorDeTurno());
	}

	public void actualizarVidaJugadores() {
		this.grilla.asignarNuevaVidaALabelDeJugadorA(this.jugadorA.vida());
		this.grilla.asignarNuevaVidaALabelDeJugadorB(this.jugadorB.vida());
	}

	public void actualizarPorCambioDeTurno(Jugador jugadorDeTurno) {
		this.actualizarVidaJugadores();
		ConfiguracionDeLaVistaCampoJugadores configuracion = jugadorDeTurno.determinarElEstadoDeLaVistaCampoJugadoresDependiendoDeQuienSeaElTurnoYLaFase();
		configuracion.configurar(this.grilla);
	}

	public void seTomoEstaCartaDelMazo(Carta unaCarta) {
		unaCarta.vistaCarta().agregarALaZonaDeLaManoDelJugadorCorrespondiente();
	}

	public void actualizarPorModoSeleccionParaSacrificar() {
		this.grilla.deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores();
		this.activarSoloLasVistasCartaMonstruosDeJugadorDeTurno(this.vista.jugadorDeTurno());
	}

	private void activarSoloLasVistasCartaMonstruosDeJugadorDeTurno(Jugador jugadorDeTurno) {
		jugadorDeTurno.oponente().determinarQueHabilitarAlMomentoDeElegirMonstruosSegunQueJugadorEsATravezDeGrilla(this.grilla);
	}
	
	private void activarSoloLasVistasCartaMonstruosNoVaciasDelOponenteDeJugadorDeTurno(Jugador jugadorDeTurno) {
		jugadorDeTurno.determinarQueHabilitarAlMomentoDeElegirMonstruosSegunQueJugadorEsATravezDeGrilla(this.grilla);
	}

	public void actualizarPorFinDeJuego() {
		this.grilla.deshabilitarTodosLosBotones();
	}
}
