package cartas;

import estado.EstadoDeCartaEspecial;
import estado.ModoActivo;
import estado.ModoInactivo;
import juego.Campo;
import juego.Jugador;
import juego.RecolectorDePartesDeExodia;

public abstract class CartaEspecial extends Carta {

	protected EstadoDeCartaEspecial estado;

	public CartaEspecial() {
		super();
		this.estado = new ModoInactivo();
	}

	@Override
	public abstract void agregarEnCampo(Campo campo);

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
		this.estado = new ModoActivo();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.activar();
	}

	public void colocarBocaAbajo() {
		this.estado = new ModoInactivo();
		this.agregarEnCampo(this.jugadorDuenio.campo());
	}
	
	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) {}

}
