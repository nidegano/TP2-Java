package juego;

import ConfiguracionesDeVistaCampoJugador.ConfiguracionDeLaVistaCampoJugador;
import botones.VistaCarta;
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
		grilla.activarSoloLasVistasCartaMonstruosDeJugadorB();
	}

	@Override
	public void determinarComoCambiarElLabelDelTurnoDependiendoDeQueJugadorEsElTurnoATravezDeGrilla(Grilla grilla) {
		grilla.cambiarLabelDeTurnoActualPorJugadorB();
	}
	
	@Override
	public ConfiguracionDeLaVistaCampoJugador determinarElEstadoDeLaVistaCampoJugadoresDependiendoDeQuienSeaElTurnoYLaFase() {
		return this.fase.determinarElEstadoDeLaVistaCampoJugadoresConJugadorBEnTurno();
	}
}
