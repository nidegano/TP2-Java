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
	public void asignarDueño(Jugador jugadorDueño) {
		this.jugadorDueño = jugadorDueño;
		this.efecto.aisgnarJugadoresEfecto(jugadorDueño, jugadorDueño.oponente());
	}
	
	public void activar() {
		this.estado.activar(this.efecto);
		this.agregarEnCampo(this.jugadorDueño.campo());
	}
	
	public void colocarBocaArriba() {
		this.estado = new ModoActivo();
		this.activar();
	}
	
	public void colocarBocaAbajo() {
		this.estado = new ModoInactivo();
		//this.desactivar()?
	}

}
