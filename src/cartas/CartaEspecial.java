package cartas;

import efectos.Efecto;
import estado.EstadoDeCartaEspecial;
import estado.ModoInactivo;
import juego.Campo;
import juego.Jugador;

public class CartaEspecial extends Carta {
	
	protected EstadoDeCartaEspecial estado;
	protected Efecto efecto;
	
	public CartaEspecial() {
		this.estado = new ModoInactivo();
	}
	
	@Override
	public void agregarEnCampo(Campo campo) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void asignarDueño(Jugador jugadorDueño) {
		this.jugadorDueño = jugadorDueño;
		this.efecto.aisgnarJugadoresEfecto(jugadorDueño, jugadorDueño.oponente());
	}
	
	public void activar() {
		this.estado.activar(this.efecto);
	}

}
