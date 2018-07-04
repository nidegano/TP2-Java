package cartas;

import botones.VistaCarta;
import botones.VistaCartaDeCampo;
import configuraciones.ConfiguracionDeOpciones;
import estados.ModoCartaDeCampoInvocada;
import excepciones.YaHayUnaCartaDeCampoColocadaException;
import juego.Campo;
import vista.VistaCampoJugadores;

public abstract class CartaDeCampo extends CartaEspecial {

	@Override
	public void agregarEnCampo(Campo campo) {

		this.agregarSiempreYCuandoNoHayaUnaCartaDeCampoYa(campo);
	}
	
	public void colocarCartaDeCampo() {
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.estado = new ModoCartaDeCampoInvocada();
		this.activar();
	}

	private void agregarSiempreYCuandoNoHayaUnaCartaDeCampoYa(Campo campo) {

		if (!campo.obtenerZonaCartasDeCampo().hayCartas()) {
			campo.obtenerZonaCartasDeCampo().agregar(this);
			this.contenedoresQueLaContienen.add(campo.obtenerZonaCartasDeCampo());
			this.contenedoresQueLaContienen.remove(this.jugadorDuenio.obtenerMano());
			this.jugadorDuenio.obtenerMano().remover(this);
		}
		else {
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
		VistaCarta vistaCartaNueva = new VistaCartaDeCampo(vistaCartaActual.vista());
		vistaCartaNueva.reemplazarPor(vistaCartaActual);
		vistaCartaActual.vaciar();
		this.vistaCarta = vistaCartaNueva;
	}
}
