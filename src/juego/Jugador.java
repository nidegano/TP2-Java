package juego;

import cartas.*;
//import excepciones.AtaqueIntervenidoException;
import excepciones.SinVidaException;

public class Jugador {

	private int vida;
	private Mano mano;
	private Campo campo;
	private Jugador oponente;
	private Fase fase = new FaseInicioDeJuego();
	private Juego juego;

	public Jugador(Campo campo) {
		this.vida = 8000;
		this.mano = new Mano();
		this.campo = campo;
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

		Carta unaCarta = this.campo.tomarUnaCartaDelMazo();
		this.mano.agregar(unaCarta);
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

	public void iniciarTurno() {
		fase = new FaseInicial();

		this.tomarCartaDelMazo();
		juego.actualizar();
	}

	public void siguienteFase() {
		fase = fase.faseSiguiente();
	}

	public Fase obtenerFase() {
		return fase;
	}

	public void asignarJuego(Juego juego) {
		this.juego = juego;		
	}

	public void jugar() {
		this.fase.ejecutar(this);
		
		if (this.fase.termino()) {
			this.fase = this.fase.faseSiguiente();
			this.juego.informarQueTerminoElTurnoDe(this);
		}
	}

}
