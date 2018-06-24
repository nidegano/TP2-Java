package cartas;

import estado.EstadoDeCartaMonstruo;
import estado.ModoAtaque;
import estado.ModoDefensa;
import juego.Campo;
import juego.ContenedorDeCartas;
import juego.FormaDeAfectarAlJugador;
import juego.Jugador;

public class CartaMonstruo extends Carta {

	protected EstadoDeCartaMonstruo estado;
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

	public int puntosAUtilizarSegunEstado() {
		return ((EstadoDeCartaMonstruo) this.estado).puntosAsociadosAlEstado();
	}
	
	public FormaDeAfectarAlJugador formaDeAfectar(int diferencia) {
		return estado.formaDeAfectar(diferencia);
	}

	@Override
	public void agregarEnCampo(Campo campo) {
		
		campo.obtenerZonaMonstruos().agregar(this);
		this.contenedoresQueLaContienen.add(campo.obtenerZonaMonstruos());
	}
	
	public void atacarDirectamenteAlJugador(Jugador jugadorB) {
		// TODO Auto-generated method stub
		
	}
	
	public void atacar(CartaMonstruo monstruoAtacado) {

		FormaDeAfectarAlJugador formaDeAfectar = monstruoAtacado.determinarLaFormaDeAfectarAlJugador(this);

		int diferencia = this.determinarDiferenciaDePuntosDeAtaqueODefensaEntreLosMonstruos(monstruoAtacado);

		if (diferencia > 0) {
			monstruoAtacado.perder(formaDeAfectar);
			
		} else if (diferencia < 0) {
			this.perder(formaDeAfectar);
		} 
		else {
			monstruoAtacado.perder(formaDeAfectar);
			this.perder(formaDeAfectar);
		}
	}
	
	private FormaDeAfectarAlJugador determinarLaFormaDeAfectarAlJugador(CartaMonstruo monstruoAtacado) {
		
		int diferencia = this.determinarDiferenciaDePuntosDeAtaqueODefensaEntreLosMonstruos(monstruoAtacado);
		
		return monstruoAtacado.formaDeAfectar(diferencia);
	}

	private void perder(FormaDeAfectarAlJugador formaDeAfectar) {
		
		formaDeAfectar.afectar(this.jugadorDueño);
		this.matar();
	}

	private int determinarDiferenciaDePuntosDeAtaqueODefensaEntreLosMonstruos(CartaMonstruo monstruoAtacado) {
		
		return this.estado.puntosAsociadosAlEstado() - monstruoAtacado.estado.puntosAsociadosAlEstado();
	}
}
