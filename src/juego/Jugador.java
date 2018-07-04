package juego;

import botones.VistaCarta;
import cartas.*;
import configuracionesDeVistaCampoJugador.ConfiguracionDeLaVistaCampoJugador;
//import excepciones.AtaqueIntervenidoException;
import excepciones.SinVidaException;
import fases.Fase;
import fases.FaseInicioDeJuego;
import fases.FasePreparacion;
import vista.Grilla;

public abstract class Jugador {

	private int vida;
	private Mano mano;
	private Campo campo;
	private Jugador oponente;
	protected Fase fase = new FaseInicioDeJuego();
	private Juego juego;
	private boolean sePuedeSeguirInvocandoMonstruos;

	public Jugador(Campo campo) {
		this.vida = 8000;
		this.mano = new Mano();
		this.campo = campo;
		this.sePuedeSeguirInvocandoMonstruos = true;

		this.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
	}

	private void asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo() {
		this.campo.mazo().asignarComoDuenioDeTodasLasCartasA(this);
	}

	public void asignarOponente(Jugador oponente) {
		this.oponente = oponente;
	}

	public int vida() {
		return this.vida;
	}

	public void debilitar(int puntosDeVidaADebilitar) {
		this.vida = this.vida - puntosDeVidaADebilitar;
		if (vida <= 0)
			throw new SinVidaException(this);
	}

	public void tomarCartaDelMazo() {
		this.fase.tomoCartaDelMazo();
		Carta unaCarta = this.campo.tomarUnaCartaDelMazo();
		this.mano.agregar(unaCarta);
		this.juego.seTomoEstaCartaDelMazo(unaCarta);
	}

	public boolean esDuenioDe(Carta carta) {
		return this.mano.estaDentro(carta) || this.campo.estaDentro(carta);
	}

	public Campo campo() {
		return this.campo;
	}

	public int cantidadDeCartasEnMano() {
		return this.mano.cantidad();
	}

	public void destruirCartasEnCampo() {
		this.campo.destruirTodasLasCartas();
	}

	public ContenedorDeCartas obtenerCementerio() {
		return this.campo.obtenerCementerio();
	}

	public Jugador oponente() {
		return this.oponente;
	}

	public void serAtacadoPor(CartaMonstruo cartaMonstruo) {
		// PATRON PROXY
		ContenedorDeCartas cartasTrampa = campo.obtenerContenedorCartasTrampa();
		if (cartasTrampa.hayCartas()) {
			CartaTrampa trampaQueLeTocaActivarse = (CartaTrampa) cartasTrampa.obtenerPrimero();
			trampaQueLeTocaActivarse.colocarBocaArriba(cartaMonstruo);
		}
	}

	public Mano obtenerMano() {
		return this.mano;
	}

	public void inicioJuego() {
		this.tomarCartaDelMazo();
		this.tomarCartaDelMazo();
		this.tomarCartaDelMazo();
		this.tomarCartaDelMazo();
		this.tomarCartaDelMazo();
	}

	/*
	 * public void iniciarTurno() { this.fase = new FaseInicial();
	 * this.juego.actualizar(); }
	 */

	public void siguienteFase() {
		this.fase = this.fase.faseSiguiente();
	}

	public Fase obtenerFase() {
		return this.fase;
	}

	public boolean puedeTomarCarta() {
		return this.fase.puedeTomarCarta();
	}

	public void asignarJuego(Juego juego) {
		this.juego = juego;
	}

	public void jugar() {
		this.fase.ejecutar(this);
		if (this.fase.termino()) {
			this.fase = this.fase.faseSiguiente();
			this.juego.informarQueElJugadorDeTurnoTerminoSuTurno();
		}
	}

	public void finalizarFase() {
		this.fase.finalizar();
		if (this.fase.termino()) {
			this.fase = this.fase.faseSiguiente();
			this.juego.informarQueElJugadorDeTurnoTerminoSuTurno();
		}
	}

	public boolean sePuedenSeguirInvocandoMonstruos() {
		return this.sePuedeSeguirInvocandoMonstruos;
	}

	public void avisarALaFaseQueSeInvocaUnMonstruo() {
		if (this.fase.getClass().equals(FasePreparacion.class)) {
			this.sePuedeSeguirInvocandoMonstruos = false;
		}
	}

	public void reiniciarLaPosibilidadDeInvocarMonstruos() {
		this.sePuedeSeguirInvocandoMonstruos = true;
	}

	public abstract VistaCarta obtenerLugarParaVistaCartaMonstruoDependiendoDelJugadorATravezDeGrilla(
			Grilla grilla);

	public abstract VistaCarta obtenerLugarParaVistaCartaEspecialDependiendoDelJugadorATravezDeGrilla(
			Grilla grilla);

	public abstract VistaCarta obtenerLugarParaVistaCartaDeCampoDependiendoDelJugadorATravezDeGrilla(
			Grilla grilla);

	public void asignarATodasLasCartasMagicasUnEstadoDeColocablesBocaArriba() {
		this.campo.asignarATodasLasCartasMagicasUnEstadoDeColocablesBocaArriba();
	}

	public void asignarATodasLasCartasMagicasUnEstadoDeBocaAbajo() {
		this.campo.asignarATodasLasCartasMagicasUnEstadoDeDeBocaAbajo();
	}

	public abstract void determinarQueMonstruosHabilitarSegunQueJugadorEsATravezDeGrilla(Grilla grilla);

	public abstract void determinarComoCambiarElLabelDelTurnoDependiendoDeQueJugadorEsElTurnoATravezDeGrilla(Grilla grilla);

	public abstract ConfiguracionDeLaVistaCampoJugador determinarElEstadoDeLaVistaCampoJugadoresDependiendoDeQuienSeaElTurnoYLaFase();

	public abstract VistaCarta obtenerLugarVacioDeLaZonaDeManoATravezDeLaGrilla(Grilla grilla);
}
