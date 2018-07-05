package juego;

import botones.VistaCarta;
import cartas.*;
import configuracionesDeVistaCampoJugadores.ConfiguracionDeLaVistaCampoJugadores;
import excepciones.CapacidadMaximaException;
import excepciones.ContenedorDeCartasVacioException;

import excepciones.MazoSinCartasException;
import excepciones.NoSePuedeTomarMasCartasDelMazoExceptionPorqueYaSeTomoUnaEnFaseInicial;
import excepciones.TengoTodasLasPartesDeExodiaException;
import fases.Fase;
import fases.FaseInicioDeJuego;
import fases.FaseJuegoTerminado;
import fases.FasePreparacion;
import vista.Grilla;

public abstract class Jugador {

	protected int vida;
	protected Mano mano;
	protected Campo campo;
	protected Jugador oponente;
	protected Fase fase = new FaseInicioDeJuego();
	protected Juego juego;
	protected boolean sePuedeSeguirInvocandoMonstruos;
	protected String nombre;

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

	public void debilitar(int puntosDeVidaADebilitar){
		this.vida = this.vida - puntosDeVidaADebilitar;
		if (vida <= 0) {
			this.fase = new FaseJuegoTerminado();
			this.oponente.fase = new FaseJuegoTerminado();
			this.juego.perdioJugador(this);
		}
	}

	public void tomarCartaDelMazo(){
		try {
			this.fase.tomoCartaDelMazo();
			Carta unaCarta = this.campo.tomarUnaCartaDelMazo();
			this.mano.agregarAMano(unaCarta);
			this.juego.seTomoEstaCartaDelMazo(unaCarta);
		}
		catch (CapacidadMaximaException | NoSePuedeTomarMasCartasDelMazoExceptionPorqueYaSeTomoUnaEnFaseInicial e) {
			e.printStackTrace();
		} 
		catch (TengoTodasLasPartesDeExodiaException e) {
			this.fase = new FaseJuegoTerminado();
			this.oponente.fase = new FaseJuegoTerminado();
			this.juego.perdioJugador(this.oponente);
		} 
		catch (MazoSinCartasException e) {
			this.fase = new FaseJuegoTerminado();
			this.oponente.fase = new FaseJuegoTerminado();
			this.juego.perdioJugador(this);

		}
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

	public void serAtacadoPor(CartaMonstruo cartaMonstruo) throws ContenedorDeCartasVacioException {
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

	public void inicioJuego() throws CapacidadMaximaException {
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

	public void jugar(){
		try {
			this.fase.ejecutar(this);
		} catch (CapacidadMaximaException e) {
			e.printStackTrace();
		}
		if (this.fase.termino()) {
			this.fase = this.fase.faseSiguiente();
			this.juego.informarQueElJugadorDeTurnoTerminoSuTurno();
		}
	}

	public void finalizarFase(){
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

	public abstract void determinarQueHabilitarAlMomentoDeElegirMonstruosSegunQueJugadorEsATravezDeGrilla(Grilla grilla);

	public abstract void determinarComoCambiarElLabelDelTurnoDependiendoDeQueJugadorEsElTurnoATravezDeGrilla(Grilla grilla);

	public abstract ConfiguracionDeLaVistaCampoJugadores determinarElEstadoDeLaVistaCampoJugadoresDependiendoDeQuienSeaElTurnoYLaFase();

	public abstract VistaCarta obtenerLugarVacioDeLaZonaDeManoATravezDeLaGrilla(Grilla grilla);

	public String nombre() {
		return this.nombre; 
	}

	public void renovarLaPosibilidadDeAtacarDeTodasLasCartasMonstruo() {
		this.campo.renovarLaPosibilidadDeAtacarDeTodasLasCartasMonstruo();
	}
}