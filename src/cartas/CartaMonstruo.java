package cartas;

import estado.EstadoDeCartaMonstruo;
import estado.ModoAtaque;
import estado.ModoDefensa;
import juego.Campo;
import juego.ContenedorDeCartas;
import juego.FormaDeAfectarAlJugador;
import juego.Jugador;

public class CartaMonstruo extends Carta {

	protected int puntosDeAtaque;
	protected int puntosDeDefensa;
	protected int nivel;
	
	public CartaMonstruo () {
		super();
	}
	
	public void invocarEnModoAtaque() {
		this.colocarEnModoAtaque();
		this.agregarEnCampo(this.jugadorDueño.campo());
	}
	
	public void invocarEnModoDefensa() {
		this.colocarEnModoDefensa();
		this.agregarEnCampo(this.jugadorDueño.campo());
	}

	public void colocarEnModoAtaque() {
		this.estado = new ModoAtaque(puntosDeAtaque);
	}

	public void colocarEnModoDefensa() {
		this.estado = new ModoDefensa(puntosDeDefensa);
	}

	public boolean estaEnModoAtaque() {
		return this.estado instanceof ModoAtaque;
	}

	public boolean estaEnModoDefensa() {
		return this.estado instanceof ModoDefensa;
	}

	public int puntosAUtilizarSegunEstado() {
		return ((EstadoDeCartaMonstruo) this.estado).puntosAsociadosAlEstado();
	}
	
	public FormaDeAfectarAlJugador formaDeAfectar() {
		return ((EstadoDeCartaMonstruo) estado).formaDeAfectar();
	}

	@Override
	public void agregarEnCampo(Campo campo) {
		// TODO Auto-generated method stub
		
	}
	
	public void atacar(CartaMonstruo monstruoAtacado) {
		// TODO Auto-generated method stub
	}
	
	public void atacarDirectamenteAlJugador(Jugador jugadorB) {
		// TODO Auto-generated method stub
		
	}
}
