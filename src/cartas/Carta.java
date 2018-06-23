package cartas;

import estado.Estado;
import estado.ModoActivo;
import estado.ModoInactivo;
import estado.ModoMuerta;
import juego.Campo;
import juego.Jugador;

public abstract class Carta {

	protected Estado estado;
	protected Jugador jugadorDueño;
	
	public void asignarDueño(Jugador jugador) {
		this.jugadorDueño = jugador;
	}
	
	public abstract void agregarEnCampo(Campo campo);

	public boolean estaMuerta() {
		return this.estado instanceof ModoMuerta;
	}

	public void matar() {
		this.estado = new ModoMuerta();
	}

	public void colocarBocaArriba() {
		this.estado = new ModoActivo();
		this.agregarEnCampo(this.jugadorDueño.campo());
	}

	public void colocarBocaAbajo() {
		this.estado = new ModoInactivo();
	}

	public boolean estaBocaArriba() {
		return this.estado instanceof ModoActivo;
	}

	public boolean estaBocaAbajo() {
		return this.estado instanceof ModoInactivo;
	}

}
