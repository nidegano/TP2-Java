package cartas;

import botones.VistaCarta;
import configuraciones.ConfiguracionDeOpciones;
import estados.EstadoDeCartaEspecial;
import estados.ModoBocaAbajo;
import estados.ModoBocaArriba;
import estados.ModoCartaEspecialSinInvocar;
import juego.Campo;
import juego.Jugador;
import juego.RecolectorDePartesDeExodia;
import v.VistaCampoJugadores;

public abstract class CartaEspecial extends Carta {

	protected EstadoDeCartaEspecial estado;

	public CartaEspecial() {
		super();
		this.estado = new ModoCartaEspecialSinInvocar();
	}

	@Override
	public abstract void agregarEnCampo(Campo campo);

	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) {
	}

	@Override
	public void asignarDuenio(Jugador jugador) {
		this.jugadorDuenio = jugador;
		this.efecto.aisgnarJugadoresEfecto(jugador, jugador.oponente());
	}

	public void activar() {
		this.estado.activar(this.efecto);
	}

	public void activar(CartaMonstruo monstruoEnemigo) {
		this.efecto.asignarMonstruoEnemigoObjetivo(monstruoEnemigo);
		this.activar();
	}

	public void activar(CartaMonstruo monstruoEnemigo, CartaMonstruo monstruoPropio) {
		this.efecto.asignarMonstruoEnemigoObjetivo(monstruoEnemigo);
		this.efecto.asignarMonstruoPropioObjetivo(monstruoPropio);
		this.activar();
	}

	public void colocarBocaArriba() {
		this.estado = new ModoBocaArriba();
		//this.agregarEnCampo(this.jugadorDuenio.campo());
		this.activar();
	}

	public void colocarBocaAbajo() {
		this.estado = new ModoBocaAbajo();
		this.agregarEnCampo(this.jugadorDuenio.campo());
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
