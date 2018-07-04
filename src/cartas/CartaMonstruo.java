package cartas;

import botones.VistaCarta;
import configuraciones.ConfiguracionDeOpciones;
import estado.EstadoDeCartaMonstruo;
import estado.EstadoMonstruoSinInvocar;
import estado.ModoAtaque;
import estado.ModoDefensa;
import estado.ModoDefensaBocaAbajo;
import excepciones.AtaqueIntervenidoException;
import excepciones.ParaAtacarDirectamenteAlJugadorNoTieneQueHaberMonstruosInvocadosException;
import juego.Campo;
import juego.ContenedorDeCartas;
import juego.FormaDeAfectarAlJugador;
import juego.RecolectorDePartesDeExodia;
import v.VistaCampoJugadores;

public abstract class CartaMonstruo extends Carta {

	protected EstadoDeCartaMonstruo estado;
	protected Puntos puntosDeAtaque;
	protected Puntos puntosDeDefensa;
	protected int nivel;

	public CartaMonstruo() {
		super();
		this.estado = new EstadoMonstruoSinInvocar();
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
		this.agregarEnCampo(this.jugadorDuenio.campo()); // aca va a haber un problema al cambiar el modo en el campo
		this.activarEfectoSiCorresponde(); // podria pasar que se active el mismo efecto dos veces
	}
	
	public void chequearSiSePuedeInvocarMonstruo() {
		this.jugadorDuenio.obtenerFase().chequearSiSePuedeInvocaMonstruo(); 
		//tira SoloSePuedeInvocarUnSoloMonstruoEnEstaFase si ya hay invocado
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
		this.contenedoresQueLaContienen.remove(this.jugadorDuenio.obtenerMano());
		this.jugadorDuenio.obtenerMano().remover(this);
	}

	public void atacarDirectamenteAlOponente() {
		try {
			this.jugadorDuenio.oponente().serAtacadoPor(this);
			this.jugadorDuenio.oponente().debilitar(this.obtenerPuntosDeAtaque());
		} catch (AtaqueIntervenidoException e) {
		}
	}

	public void atacar(CartaMonstruo monstruoAtacado) {
		// PATRON PROXY
		try {
			monstruoAtacado.serAtacadoPor(this);

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
		} catch (AtaqueIntervenidoException e) {
		}
	}

	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) {
	}

	protected void serAtacadoPor(CartaMonstruo cartaMonstruo) {
		// PATRON PROXY
		try {
			this.efecto.asignarMonstruoEnemigoObjetivo(cartaMonstruo);
			this.activarEfectoSiCorresponde();

			ContenedorDeCartas cartasTrampa = this.jugadorDuenio.campo().obtenerContenedorCartasTrampa();

			if (cartasTrampa.hayCartas()) {
				CartaTrampa trampaQueTocaActivar = (CartaTrampa) cartasTrampa.obtenerPrimero();
				trampaQueTocaActivar.colocarBocaArriba(cartaMonstruo, this);
			}
		} catch (AtaqueIntervenidoException e) {
			throw new AtaqueIntervenidoException();
		} finally {
			this.efecto.desasignarObjetivo();// no quiero que quede guardada una referencia que no tiene nada que ver
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
		ContenedorDeCartas ContenedorDeMonstruosInvocados = this.jugadorDuenio.oponente().campo()
				.obtenerZonaMonstruos();
		if (ContenedorDeMonstruosInvocados.hayCartas())
			throw new ParaAtacarDirectamenteAlJugadorNoTieneQueHaberMonstruosInvocadosException();
	}

	protected void activarEfectoSiCorresponde() {
		this.estado.activar(this.efecto);
	}

	public void colocarEnModoDefensaBocaAbajo() {
		this.estado = new ModoDefensaBocaAbajo(this.puntosDeDefensa);
	}

	public void colocarEnModoAtaque() {
		this.estado = new ModoAtaque(this.puntosDeAtaque);
	}

	public void colocarEnModoDefensa() {
		this.estado = new ModoDefensa(this.puntosDeDefensa);
	}
	
	@Override
	public ConfiguracionDeOpciones obtenerConfiguracionDeOpcionesSegunTipoYEstado() {
		return this.estado.obtenerConfiguracionDeOpciones();
	}
	
	@Override
	public VistaCarta obtenerLugarVacioMedianteVistaCampoJugadores(VistaCampoJugadores vistaCampoJugadores) {
		return vistaCampoJugadores.obtenerUnLugarVacio(this);
	}

}
