package cartas;

import estado.EstadoDeCartaMonstruo;

import estado.ModoAtaque;
import estado.ModoDefensa;
import estado.ModoDefensaBocaAbajo;
import excepciones.AtaqueIntervenidoException;
import excepciones.ParaAtacarDirectamenteAlJugadorNoTieneQueHaberMonstruosInvocadosException;
import juego.Campo;
import juego.ContenedorDeCartas;
import juego.FormaDeAfectarAlJugador;

public abstract class CartaMonstruo extends Carta {

	protected EstadoDeCartaMonstruo estado;
	protected Puntos puntosDeAtaque;
	protected Puntos puntosDeDefensa;
	protected int nivel;

	public CartaMonstruo() {
		super();
	}

	public int obtenerPuntosDeAtaque() {
		return this.puntosDeAtaque.valor();
	}
	
	public void aumentarPuntosDeAtaqueEn(int aumentoDePuntosDeAtaque) {
		this.puntosDeAtaque.aumentar(aumentoDePuntosDeAtaque);
	}

	public void aumentarPuntosDeDefensaEn(int aumentoDePuntosDeDefensa) {
		this.puntosDeDefensa.aumentar(aumentoDePuntosDeDefensa);
	}

	public void invocarEnModoAtaque() {
		this.colocarEnModoAtaque();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.activarEfectoSiCorresponde();
	}

	public void invocarEnModoDefensa() {
		this.colocarEnModoDefensa();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.activarEfectoSiCorresponde();
	}
	
	public void invocarEnModoDefensaBocaAbajo() {
		this.colocarEnModoDefensaBocaAbajo();
		this.agregarEnCampo(this.jugadorDuenio.campo());
	}

	public int puntosAUtilizarSegunEstado() {
		return ((EstadoDeCartaMonstruo) this.estado).puntosAsociadosAlEstado();
	}

	@Override
	public void agregarEnCampo(Campo campo) {
		campo.obtenerZonaMonstruos().agregar(this);
		this.contenedoresQueLaContienen.add(campo.obtenerZonaMonstruos());
	}

	public void atacarDirectamenteAlOponente() {
		this.chequearQueNoHayaMonstruosDelOponenteInvocados();
		
		try {
			this.jugadorDuenio.oponente().serAtacadoPor(this);
			this.jugadorDuenio.oponente().debilitar(this.obtenerPuntosDeAtaque());
		}
		catch (AtaqueIntervenidoException e) {}		

	}

	public void atacar(CartaMonstruo monstruoAtacado) {
		
		try {
			monstruoAtacado.serAtacadoPor(this);//uso Proxy	
		
			FormaDeAfectarAlJugador formaDeAfectar = this.determinarLaFormaDeAfectarAlJugador(monstruoAtacado);
			int diferencia = this.determinarDiferenciaDePuntosDeAtaqueODefensaEntreLosMonstruos(monstruoAtacado);
	
			if (diferencia > 0) {
				monstruoAtacado.perder(formaDeAfectar);
			} else if (diferencia < 0) {
				this.perder(formaDeAfectar);
			} else {
				monstruoAtacado.perder(formaDeAfectar);
				this.perder(formaDeAfectar);
			}
		}
		catch (AtaqueIntervenidoException e) {}		
	}

	protected void serAtacadoPor(CartaMonstruo cartaMonstruo) {
		
		//uso Proxy
		
		try {
			this.efecto.asignarMonstruoObjetivo(cartaMonstruo);
			this.activarEfectoSiCorresponde(); //posibles efectos de volteo
			
			ContenedorDeCartas cartasTrampa = this.jugadorDuenio.campo().obtenerContenedorCartasTrampa();

			if (cartasTrampa.hayCartas()) {
				CartaTrampa trampaQueTocaActivar = (CartaTrampa)cartasTrampa.obtenerPrimero();
				trampaQueTocaActivar.colocarBocaArriba(cartaMonstruo);
			}			
		}
		catch (AtaqueIntervenidoException e) {
			throw new AtaqueIntervenidoException();
		}
		finally {
			this.efecto.desasignarObjetivo();//no quiero que quede guardada una referencia que no tiene nada que ver
		}
	}
	
	protected FormaDeAfectarAlJugador formaDeAfectar(int diferencia) {
		return this.estado.formaDeAfectar(diferencia);
	}

	protected FormaDeAfectarAlJugador determinarLaFormaDeAfectarAlJugador(CartaMonstruo monstruoAtacado) {
		int diferencia = this.determinarDiferenciaDePuntosDeAtaqueODefensaEntreLosMonstruos(monstruoAtacado);
		return monstruoAtacado.formaDeAfectar(diferencia);
	}

	protected void perder(FormaDeAfectarAlJugador formaDeAfectar) {
		formaDeAfectar.afectar(this.jugadorDuenio);
		this.matar();
	}

	protected int determinarDiferenciaDePuntosDeAtaqueODefensaEntreLosMonstruos(CartaMonstruo monstruoAtacado) {
		return this.estado.puntosAsociadosAlEstado() - monstruoAtacado.estado.puntosAsociadosAlEstado();
	}
	

	protected void chequearQueNoHayaMonstruosDelOponenteInvocados() {
		ContenedorDeCartas ContenedorDeMonstruosInvocados = this.jugadorDuenio.oponente().campo().obtenerZonaMonstruos();
		if (ContenedorDeMonstruosInvocados.hayCartas())
			throw new ParaAtacarDirectamenteAlJugadorNoTieneQueHaberMonstruosInvocadosException();
	}

	protected void activarEfectoSiCorresponde() {
		this.estado.activar(this.efecto);		
	}
	
	
	protected void colocarEnModoDefensaBocaAbajo() {
		this.estado = new ModoDefensaBocaAbajo(this.puntosDeDefensa);
	}

	protected void colocarEnModoAtaque() {
		this.estado = new ModoAtaque(this.puntosDeAtaque);
	}

	protected void colocarEnModoDefensa() {
		this.estado = new ModoDefensa(this.puntosDeDefensa);
	}
	
	@Override
	public abstract void sumarSiSosParteDeExodia(int suma);

}
