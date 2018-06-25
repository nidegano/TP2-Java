package juego;

import cartas.*;

public class Jugador {

	private int vida;
	private ContenedorDeCartas mano;
	private Campo campo;
	private Jugador oponente;

	public Jugador(Campo campo) {
		this.vida = 8000;
		this.mano = new ContenedorDeCartas(7);
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
		Carta unaCarta = this.campo.tomarUnaCartaDelMazo();
		this.mano.agregar(unaCarta);
	}

	public boolean esDuenioDe(Carta carta) {
		return this.mano.estaDentro(carta) || this.campo.estaDentro(carta);
	}

	public Campo campo() {
		return this.campo;
	}

	public ContenedorDeCartas cartasEnMano() {
		return this.mano;
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

}
