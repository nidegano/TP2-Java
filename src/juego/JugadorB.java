package juego;

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
}
