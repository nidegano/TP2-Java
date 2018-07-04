package cartas;

import botones.VistaCarta;
import configuraciones.ConfiguracionDeOpciones;
import estados.ModoCartaDeCampoInvocada;
import excepciones.CapacidadMaximaException;
import excepciones.CartaNoEstaEnContenedorDeCartasException;
import excepciones.YaHayUnaCartaDeCampoColocadaException;
import juego.Campo;
import vista.VistaCampoJugadores;

public abstract class CartaDeCampo extends CartaEspecial {

	@Override
	public void agregarEnCampo(Campo campo) {
		try {
			this.agregarSiempreYCuandoNoHayaUnaCartaDeCampoYa(campo);
		}
		catch (YaHayUnaCartaDeCampoColocadaException e) {
			e.printStackTrace();
		}
	}
	
	public void colocarCartaDeCampo() {
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.estado = new ModoCartaDeCampoInvocada();
		this.activar();
	}

	private void agregarSiempreYCuandoNoHayaUnaCartaDeCampoYa(Campo campo) throws YaHayUnaCartaDeCampoColocadaException {
		try {
			campo.obtenerZonaCartasDeCampo().agregar(this);
			this.contenedoresQueLaContienen.add(campo.obtenerZonaCartasDeCampo());
			this.contenedoresQueLaContienen.remove(this.jugadorDuenio.obtenerMano());
			this.jugadorDuenio.obtenerMano().remover(this);
		}
		catch (CapacidadMaximaException | CartaNoEstaEnContenedorDeCartasException e) {
			throw new YaHayUnaCartaDeCampoColocadaException();
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
	
	@Override
	public void desasignarVistaALugarDeManoEnVistaCampoJugadores() {
		VistaCarta vistaCartaActual = this.vistaCarta;
		VistaCarta vistaCartaNueva = new VistaCarta(vistaCartaActual.vista());
		vistaCartaNueva.reemplazarPor(vistaCartaActual);
		vistaCartaActual.vaciar();
		this.vistaCarta = vistaCartaNueva;
	}
}
