package cartas;

import estado.EstadoDeCartaMonstruo;
import estado.ModoAtaque;
import estado.ModoDefensa;
import excepciones.ParaAtacarDirectamenteAlJugadorNoTieneQueHaberMonstruosInvocadosException;
import juego.Campo;
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

	public void invocarEnModoAtaque() {
		this.colocarEnModoAtaque();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.efecto.activar();
	}

	public void invocarEnModoDefensa() {
		this.colocarEnModoDefensa();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.efecto.activar();
	}

	public void colocarEnModoAtaque() {
		this.estado = new ModoAtaque(this.puntosDeAtaque);
	}

	public void colocarEnModoDefensa() {
		this.estado = new ModoDefensa(this.puntosDeDefensa);
	}

	public int puntosAUtilizarSegunEstado() {
		return ((EstadoDeCartaMonstruo) this.estado).puntosAsociadosAlEstado();
	}

	public FormaDeAfectarAlJugador formaDeAfectar(int diferencia) {
		return this.estado.formaDeAfectar(diferencia);
	}

	@Override
	public void agregarEnCampo(Campo campo) {
		campo.obtenerZonaMonstruos().agregar(this);
		this.contenedoresQueLaContienen.add(campo.obtenerZonaMonstruos());
	}

	public void atacarDirectamenteAlOponente() {
		this.chequearQueNoHayaMonstruosDelOponenteInvocados();
		this.jugadorDuenio.oponente().debilitar(this.obtenerPuntosDeAtaque());
	}

	private void chequearQueNoHayaMonstruosDelOponenteInvocados() {
		int cantidadDeMonstruosInvocados = this.jugadorDuenio.oponente().campo().obtenerZonaMonstruos().cantidad();
		if (cantidadDeMonstruosInvocados != 0)
			throw new ParaAtacarDirectamenteAlJugadorNoTieneQueHaberMonstruosInvocadosException();
	}

	public void atacar(CartaMonstruo monstruoAtacado) {
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

	private FormaDeAfectarAlJugador determinarLaFormaDeAfectarAlJugador(CartaMonstruo monstruoAtacado) {
		int diferencia = this.determinarDiferenciaDePuntosDeAtaqueODefensaEntreLosMonstruos(monstruoAtacado);
		return monstruoAtacado.formaDeAfectar(diferencia);
	}

	private void perder(FormaDeAfectarAlJugador formaDeAfectar) {
		formaDeAfectar.afectar(this.jugadorDuenio);
		this.matar();
	}

	private int determinarDiferenciaDePuntosDeAtaqueODefensaEntreLosMonstruos(CartaMonstruo monstruoAtacado) {
		return this.estado.puntosAsociadosAlEstado() - monstruoAtacado.estado.puntosAsociadosAlEstado();
	}

	public void aumentarPuntosDeAtaqueEn(int aumentoDePuntosDeAtaque) {
		this.puntosDeAtaque.aumentar(aumentoDePuntosDeAtaque);
	}

	public void aumentarPuntosDeDefensaEn(int aumentoDePuntosDeDefensa) {
		this.puntosDeDefensa.aumentar(aumentoDePuntosDeDefensa);
	}

	@Override
	public abstract void sumarSiSosParteDeExodia(int suma);

}
