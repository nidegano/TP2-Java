package cartas;

import botones.VistaCarta;
import configuraciones.ConfiguracionDeOpciones;
import configuraciones.MostrarOpcionesDeCartaNula;
import excepciones.NoSePuedeColocarUnaCartaNulaEnCampoException;
import juego.Campo;
import juego.RecolectorDePartesDeExodia;
import v.VistaCampoJugadores;

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
		throw new NoSePuedeColocarUnaCartaNulaEnCampoException();
	}

	@Override
	public ConfiguracionDeOpciones obtenerConfiguracionDeOpcionesSegunTipoYEstado() {
		return new MostrarOpcionesDeCartaNula();
	}
}
