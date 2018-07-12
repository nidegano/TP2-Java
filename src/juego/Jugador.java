package juego;

import botones.VistaCarta;
import cartas.*;
import excepciones.CapacidadMaximaException;
import excepciones.ContenedorDeCartasVacioException;

import excepciones.MazoSinCartasException;
import excepciones.NoSePuedeTomarMasCartasDelMazoExceptionPorqueYaSeTomoUnaEnFaseInicial;
import excepciones.TengoTodasLasPartesDeExodiaException;
import fases.Fase;
import fases.FaseInicioDeJuego;
import fases.FaseJuegoTerminado;
import vista.Grilla;

public class Jugador {

	protected int vida;
	protected Mano mano;
	protected Campo campo;
	protected Jugador oponente;
	protected Fase fase = new FaseInicioDeJuego();
	protected Juego juego;
	protected String nombre;

	public Jugador(String nombre , Campo campo) {
		this.vida = 8000;
		this.mano = new Mano();
		this.campo = campo;
		this.nombre = nombre;
	}

	public void asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo() {
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

	public VistaCarta obtenerLugarParaVistaCartaMonstruoDependiendoDelJugadorATravezDeGrilla(Grilla grilla) {
		if( this.nombre == "JUGADOR A" ) {
			return grilla.obtenerUnLugarVacioParaCartaMonstruoDeJugadorA();
		}	
		return grilla.obtenerUnLugarVacioParaCartaMonstruoDeJugadorB();
	}

	public VistaCarta obtenerLugarParaVistaCartaEspecialDependiendoDelJugadorATravezDeGrilla(Grilla grilla) {
		if( this.nombre == "JUGADOR A" ) {
			return grilla.obtenerUnLugarVacioParaCartaEspecialDeJugadorA();
		}
		return grilla.obtenerUnLugarVacioParaCartaEspecialDeJugadorB();
	}

	public VistaCarta obtenerLugarParaVistaCartaDeCampoDependiendoDelJugadorATravezDeGrilla(Grilla grilla) {
		if( this.nombre == "JUGADOR A" ) {
			return grilla.obtenerUnLugarVacioParaCartaDeCampoDeJugadorA();
		}
		return grilla.obtenerUnLugarVacioParaCartaDeCampoDeJugadorB();
	}

	public void asignarATodasLasCartasMagicasUnEstadoDeColocablesBocaArriba() {
		this.campo.asignarATodasLasCartasMagicasUnEstadoDeColocablesBocaArriba();
	}

	public void asignarATodasLasCartasMagicasUnEstadoDeBocaAbajo() {
		this.campo.asignarATodasLasCartasMagicasUnEstadoDeDeBocaAbajo();
	}

	public void habilitarLasVistasCartaMonstruoQueNoEstenVaciasDelOponente(Grilla grilla) {
		if( this.nombre == "JUGADOR A" ) {
			grilla.habilitarLasVistasCartaMonstruoQueNoEstenVaciasDelJugadorB();
		}
		else {
			grilla.habilitarLasVistasCartaMonstruoQueNoEstenVaciasDelJugadorA();
		}
	}

	public VistaCarta obtenerLugarVacioDeLaZonaDeManoATravezDeLaGrilla(Grilla grilla) {
		if( this.nombre == "JUGADOR A" ) {
			return grilla.obtenerUnLugarVacioDeZonaManoJugadorA();
			//se chequea antes de pedir lugar si se puede o no
		}
		return grilla.obtenerUnLugarVacioDeZonaManoJugadorB();
	}

	public String nombre() {
		return this.nombre; 
	}

	public void renovarLaPosibilidadDeAtacarDeTodasLasCartasMonstruo() {
		this.campo.renovarLaPosibilidadDeAtacarDeTodasLasCartasMonstruo();
	}
}