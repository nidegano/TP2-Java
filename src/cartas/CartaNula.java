package cartas;

import botones.VistaCarta;
import configuraciones.ConfiguracionDeOpciones;
import configuraciones.MostrarOpcionesDeCartaNula;
import excepciones.NoSePuedeColocarUnaCartaNulaEnCampoException;
import juego.Campo;
import juego.RecolectorDePartesDeExodia;
import vista.VistaCampoJugadores;

public class CartaNula extends Carta {

	public CartaNula() {
		super();
		this.nombre = "-";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_dorso.png");
	}
	
	public void agregarEnCampo(Campo campo) {
	}

	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) {
	}

	@Override
	public VistaCarta obtenerLugarVacioMedianteVistaCampoJugadores(VistaCampoJugadores vistaCampoJugadores) {
		try {
			throw new NoSePuedeColocarUnaCartaNulaEnCampoException();
		} catch (NoSePuedeColocarUnaCartaNulaEnCampoException e) {
			// e.printStackTrace();
		}
		return null;
	}

	@Override
	public ConfiguracionDeOpciones obtenerConfiguracionDeOpcionesSegunTipoYEstado() {
		return new MostrarOpcionesDeCartaNula();
	}

	@Override
	public void desasignarSuVistaCartaDelLugarDeManoEnVistaCampoJugadoresEnElQueEstaba() {
		//una carta nula no se asigna a un lugar de mano
	}
}
