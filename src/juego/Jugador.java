package juego;

import cartas.*;
import excepciones.AtaqueIntervenidoException;

public class Jugador {

	private int vida;
	private Mano mano;
	private Campo campo;
	private Jugador oponente;

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
	}

	public void tomarCartaDelMazo() {
		try {
		      Carta unaCarta = this.campo.tomarUnaCartaDelMazo();
		      this.mano.agregar(unaCarta);
		} 
		catch(IndexOutOfBoundsException e) {
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

	public void serAtacadoPor(CartaMonstruo cartaMonstruo) {
		
		//uso Proxy
		
		try {			
			ContenedorDeCartas cartasTrampa = this.campo().obtenerContenedorCartasTrampa();

			if (cartasTrampa.hayCartas()) {
				CartaTrampa trampaQueLeTocaActivarse = (CartaTrampa)cartasTrampa.obtenerPrimero();
				trampaQueLeTocaActivarse.colocarBocaArriba(cartaMonstruo);
			}			
		}
		catch (AtaqueIntervenidoException e) {
			throw new AtaqueIntervenidoException();
		}
	}
		
	public boolean perdiste() {
		return  ( vida == 0 ) ||  !(campo.tieneCartasEnELMazo()) || oponente.tenesTodasLasPartesDeExodiaEnTuMano();
	}

	private boolean tenesTodasLasPartesDeExodiaEnTuMano() {
		return this.mano.tenesTodasLasPartesDeExodia();
	}

	public Mano obtenerMano() {
		return this.mano;
	}
}
