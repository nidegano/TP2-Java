package cartas;

import botones.VistaCarta;
import configuraciones.ConfiguracionDeOpciones;
import estados.ModoCartaDeCampoInvocada;
import estados.ModoCartaDeCampoSinInvocar;
import excepciones.CapacidadMaximaException;
import excepciones.CartaNoEstaEnContenedorDeCartasException;
import excepciones.YaHayUnaCartaDeCampoColocadaException;
import juego.Campo;
import vista.VistaCampoJugadores;

public abstract class CartaDeCampo extends CartaEspecial {
	
	public CartaDeCampo() {
		super();
		this.estado = new ModoCartaDeCampoSinInvocar();
	}

	@Override
	public void agregarEnCampo(Campo campo) {
		try {
			campo.obtenerZonaCartasDeCampo().agregar(this);
			this.contenedoresQueLaContienen.add(campo.obtenerZonaCartasDeCampo());
			this.contenedoresQueLaContienen.remove(this.jugadorDuenio.obtenerMano());
			this.jugadorDuenio.obtenerMano().remover(this);
		}
		catch (CapacidadMaximaException e) {
			throw new YaHayUnaCartaDeCampoColocadaException();
		} catch (CartaNoEstaEnContenedorDeCartasException e) {
			// e.printStackTrace();
		}
	}
	
	public void chequearQueNoHayaCartaDeCampoColocada() {
		if (this.jugadorDuenio.campo().obtenerZonaCartasDeCampo().hayCartas()) {
			throw new YaHayUnaCartaDeCampoColocadaException();
		}
	}
	
	public void colocarCartaDeCampo() {
		try {
			this.agregarEnCampo(this.jugadorDuenio.campo());
			this.estado = new ModoCartaDeCampoInvocada();
			this.activar();
		}
		catch (YaHayUnaCartaDeCampoColocadaException e) {
			// e.printStackTrace();
		}
	}
	
	@Override
	public ConfiguracionDeOpciones obtenerConfiguracionDeOpcionesSegunTipoYEstado() {
		return this.estado.obtenerConfiguracionDeOpciones();
	}
	
	@Override
	public VistaCarta obtenerLugarVacioMedianteVistaCampoJugadores(VistaCampoJugadores vistaCampoJugadores) {
		return vistaCampoJugadores.obtenerUnLugarVacio(this);
	}
}
