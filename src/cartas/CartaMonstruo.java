package cartas;

import estado.EstadoDeCartaMonstruo;
import estado.ModoAtaque;
import estado.ModoDefensa;
import juego.FormaDeAfectarAlJugador;

public abstract class CartaMonstruo extends Carta {

	protected int puntosDeAtaque;
	protected int puntosDeDefensa;
	protected int nivel;

	public void colocarEnModoAtaque() {
		
		this.estado = new ModoAtaque(puntosDeAtaque);
	}

	public void colocarEnModoDefensa() {
		
		this.estado = new ModoDefensa(puntosDeDefensa);;
	}
	
	public boolean estaEnModoAtaque() {
		return this.estado instanceof ModoAtaque;
	}

	public boolean estaEnModoDefensa() {
		return this.estado instanceof ModoDefensa;
	}

	public FormaDeAfectarAlJugador enfrentarCon(CartaMonstruo monstruoAtacado) {
		
		return ((ModoAtaque) this.estado).determinarFormaDeAfectarAlJugadorQueCorresponda(monstruoAtacado.estado);
	}

	public int puntosAUtilizarSegunEstado() {

		return ((EstadoDeCartaMonstruo) this.estado).puntosAsociadosAlEstado();
	}
}
