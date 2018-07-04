package juego;

import botones.VistaCarta;
import configuracionesDeVistaCampoJugador.ConfiguracionDeLaVistaCampoJugador;
import vista.Grilla;

public class JugadorA extends Jugador {

	public JugadorA(Campo campo) {
		super(campo);
	}

	@Override
	public VistaCarta obtenerLugarParaVistaCartaMonstruoDependiendoDelJugadorATravezDeGrilla(Grilla grilla) {
		return grilla.obtenerUnLugarVacioParaCartaMonstruoDeJugadorA();
	}

	@Override
	public VistaCarta obtenerLugarParaVistaCartaEspecialDependiendoDelJugadorATravezDeGrilla(Grilla grilla) {
		return grilla.obtenerUnLugarVacioParaCartaEspecialDeJugadorA();
	}

	@Override
	public VistaCarta obtenerLugarParaVistaCartaDeCampoDependiendoDelJugadorATravezDeGrilla(Grilla grilla) {
		return grilla.obtenerUnLugarVacioParaCartaDeCampoDeJugadorA();
	}

	@Override
	public void determinarQueMonstruosHabilitarSegunQueJugadorEsATravezDeGrilla(Grilla grilla) {
		grilla.activarSoloLasVistasCartaMonstruosDeJugadorA();
	}

	@Override
	public void determinarComoCambiarElLabelDelTurnoDependiendoDeQueJugadorEsElTurnoATravezDeGrilla(Grilla grilla) {
		grilla.cambiarLabelDeTurnoActualPorJugadorA();
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugador determinarElEstadoDeLaVistaCampoJugadoresDependiendoDeQuienSeaElTurnoYLaFase() {
		return this.fase.determinarElEstadoDeLaVistaCampoJugadoresConJugadorAEnTurno();
	}

	@Override
	public VistaCarta obtenerLugarVacioDeLaZonaDeManoATravezDeLaGrilla(Grilla grilla) {
		return grilla.obtenerUnLugarVacioDeZonaManoJugadorA();
		//se chequea antes de pedir lugar si se puede o no
	}
}
