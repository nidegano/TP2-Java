package cartas;

import efectos.Efecto;
import estado.EstadoDeCartaEspecial;
import estado.ModoActivo;
import estado.ModoInactivo;
import juego.Campo;
import juego.Jugador;

public abstract class CartaEspecial extends Carta {
	
	protected EstadoDeCartaEspecial estado;
	protected Efecto efecto;
	
	public CartaEspecial() {
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
	}
	
	public void colocarBocaAbajo() {
		this.estado = new ModoInactivo();
	}

}
