package cartas;

import estado.EstadoDeCartaEspecial;
import estado.ModoActivo;
import estado.ModoInactivo;
import juego.Campo;
import juego.Jugador;

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
		this.agregarEnCampo(this.jugadorDuenio.campo());
	}

	public void colocarBocaArriba() {
		this.estado = new ModoActivo();
		this.activar();
	}

	public void colocarBocaAbajo() {
		this.estado = new ModoInactivo();
		// this.desactivar()?
	}

}
