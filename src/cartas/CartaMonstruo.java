package cartas;

import botones.VistaCarta;
import configuraciones.ConfiguracionDeOpciones;
import estados.EstadoDeCartaMonstruo;
import estados.EstadoMonstruoSinInvocar;
import estados.ModoAtaque;
import estados.ModoDefensa;
import estados.ModoDefensaBocaAbajo;
import excepciones.AtaqueIntervenidoException;
import excepciones.CapacidadMaximaException;
import excepciones.CartaNoEstaEnContenedorDeCartasException;
import excepciones.ContenedorDeCartasVacioException;

import excepciones.NoSePuedeInvocarMonstruosEnEstaFase;
import excepciones.ParaAtacarDirectamenteAlJugadorNoTieneQueHaberMonstruosInvocadosException;
import excepciones.SoloSePuedeInvocarUnSoloMonstruoEnEstaFase;
import excepciones.TengoTodasLasPartesDeExodiaException;
import juego.Campo;
import juego.ContenedorDeCartas;
import juego.FormaDeAfectarAlJugador;
import juego.RecolectorDePartesDeExodia;
import vista.VistaCampoJugadores;

public abstract class CartaMonstruo extends Carta {

	protected EstadoDeCartaMonstruo estado;
	protected Puntos puntosDeAtaque;
	protected Puntos puntosDeDefensa;
	protected int nivel;
	protected boolean yaAtaco;

	public CartaMonstruo() {
		super();
		this.estado = new EstadoMonstruoSinInvocar();
		this.yaAtaco = false;
	}
	
	public void renovarLaPosibilidadDeAtacar() {
		this.yaAtaco = false;
	}
	
	public boolean yaAtaco() {
		return this.yaAtaco;
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

	public void invocarEnModoAtaque(){
		this.colocarEnModoAtaque();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.activarEfectoSiCorresponde();
	}
	
	public void chequearSiSePuedeInvocarMonstruo() throws NoSePuedeInvocarMonstruosEnEstaFase, SoloSePuedeInvocarUnSoloMonstruoEnEstaFase,
	CapacidadMaximaException{
		this.jugadorDuenio.obtenerFase().chequearSiSePuedeInvocaMonstruo(); 
		//tira SoloSePuedeInvocarUnSoloMonstruoEnEstaFase si ya se invoco uno en la fase
		if (this.jugadorDuenio.campo().obtenerZonaMonstruos().estaLleno()) {
			throw new CapacidadMaximaException();
		}
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
		try {
			campo.obtenerZonaMonstruos().agregar(this);
			this.contenedoresQueLaContienen.add(campo.obtenerZonaMonstruos());
			this.contenedoresQueLaContienen.remove(this.jugadorDuenio.obtenerMano());
			this.jugadorDuenio.obtenerMano().remover(this);
		}
		catch (CapacidadMaximaException | CartaNoEstaEnContenedorDeCartasException e) {
			e.printStackTrace();
		}
	}

	public void atacarDirectamenteAlOponente(){
		try {
			this.jugadorDuenio.oponente().serAtacadoPor(this);
			this.jugadorDuenio.oponente().debilitar(this.obtenerPuntosDeAtaque());
			this.yaAtaco = true;
		} catch (AtaqueIntervenidoException | ContenedorDeCartasVacioException e) {
			
		}
	}

	public void atacar(CartaMonstruo monstruoAtacado){
		// PATRON PROXY
		this.yaAtaco = true;
		try {
			monstruoAtacado.serAtacadoPor(this);

			FormaDeAfectarAlJugador formaDeAfectar = this.determinarLaFormaDeAfectarAlJugador(monstruoAtacado);
			int diferencia = this.determinarDiferenciaDePuntosDeAtaqueODefensaEntreLosMonstruos(monstruoAtacado);

			if (diferencia > 0) {
				monstruoAtacado.perder(formaDeAfectar);

				try {
					this.vistaCarta.deshabilitar(); //para que no vuelva a atacar
				}
				catch (NullPointerException e) {
					//esto es solo para poder ejecutar el test
				}
			} else if (diferencia < 0) {
				this.perder(formaDeAfectar);
				try {
					monstruoAtacado.vistaCarta().deshabilitar(); //para que no vuelva a atacar
				}
				catch (NullPointerException e) {
					//esto es solo para poder ejecutar el test
				}
			} else {
				monstruoAtacado.perder(formaDeAfectar);
				this.perder(formaDeAfectar);
			}
		} catch (AtaqueIntervenidoException e) {
		}
	}

	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) throws TengoTodasLasPartesDeExodiaException {
	}

	protected void serAtacadoPor(CartaMonstruo cartaMonstruo) throws AtaqueIntervenidoException {
		// PATRON PROXY
		try {
			this.efecto.asignarMonstruoEnemigoObjetivo(cartaMonstruo);
			this.activarEfectoSiCorresponde();

			ContenedorDeCartas cartasTrampa = this.jugadorDuenio.campo().obtenerContenedorCartasTrampa();

			if (cartasTrampa.hayCartas()) {
				CartaTrampa trampaQueTocaActivar = (CartaTrampa) cartasTrampa.obtenerPrimero();
				trampaQueTocaActivar.colocarBocaArriba(cartaMonstruo, this);
			}
		} catch (AtaqueIntervenidoException | ContenedorDeCartasVacioException e) {
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

	protected void perder(FormaDeAfectarAlJugador formaDeAfectar){
		formaDeAfectar.afectar(this.jugadorDuenio);
		this.matar();
	}

	protected int determinarDiferenciaDePuntosDeAtaqueODefensaEntreLosMonstruos(CartaMonstruo monstruoAtacado) {
		return this.estado.puntosAsociadosAlEstado() - monstruoAtacado.estado.puntosAsociadosAlEstado();
	}

	protected void chequearQueNoHayaMonstruosDelOponenteInvocados() throws ParaAtacarDirectamenteAlJugadorNoTieneQueHaberMonstruosInvocadosException {
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

	public void cambiarAModoDefensa() {
		this.colocarEnModoDefensa();
	}

	public void cambiarAModoAtaque() {
		this.colocarEnModoAtaque();
	}

	public void cambiarAModoDefensaBocaAbajo() {
		this.colocarEnModoDefensaBocaAbajo();
	}
}
