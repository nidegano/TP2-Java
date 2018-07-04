package juego;

import botones.VistaCarta;
import configuracionesDeVistaCampoJugador.ConfiguracionDeLaVistaCampoJugador;
import vista.Grilla;

public class JugadorB extends Jugador {

	public JugadorB(Campo campo) {
		super(campo);
	}

	@Override
	public VistaCarta obtenerLugarParaVistaCartaMonstruoDependiendoDelJugadorATravezDeGrilla(Grilla grilla) {
		return grilla.obtenerUnLugarVacioParaCartaMonstruoDeJugadorB();
	}

	@Override
	public VistaCarta obtenerLugarParaVistaCartaEspecialDependiendoDelJugadorATravezDeGrilla(Grilla grilla) {
		return grilla.obtenerUnLugarVacioParaCartaEspecialDeJugadorB();
	}

	@Override
	public VistaCarta obtenerLugarParaVistaCartaDeCampoDependiendoDelJugadorATravezDeGrilla(Grilla grilla) {
		return grilla.obtenerUnLugarVacioParaCartaDeCampoDeJugadorB();
	}
	
	@Override
	public void determinarQueMonstruosHabilitarSegunQueJugadorEsATravezDeGrilla(Grilla grilla) {
		grilla.activarSoloLasVistasCartaMonstruosDeJugadorA();
	}

	@Override
	public void determinarComoCambiarElLabelDelTurnoDependiendoDeQueJugadorEsElTurnoATravezDeGrilla(Grilla grilla) {
		grilla.cambiarLabelDeTurnoActualPorJugadorB();
	}
	
	@Override
	public ConfiguracionDeLaVistaCampoJugador determinarElEstadoDeLaVistaCampoJugadoresDependiendoDeQuienSeaElTurnoYLaFase() {
		return this.fase.determinarElEstadoDeLaVistaCampoJugadoresConJugadorBEnTurno();
	}
	
	@Override
	public VistaCarta obtenerLugarVacioDeLaZonaDeManoATravezDeLaGrilla(Grilla grilla) {
		return grilla.obtenerUnLugarVacioDeZonaManoJugadorB();
		//se chequea antes de pedir lugar si se puede o no
	}
}
