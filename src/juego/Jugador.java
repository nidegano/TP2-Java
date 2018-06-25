package juego;

import java.util.Iterator;

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

	public boolean perdiste() {
		return  ( vida == 0 ) || (this.tenesLasPartesDeExodiaEnTuMano()) || (campo.noTieneCartasEnELMazo()) ;
	}

	private boolean tenesLasPartesDeExodiaEnTuMano() {
		int suma = 0;
		
		Iterator<Carta> it = mano.iterator();
		while ( it.hasNext() ) {
			Carta carta = it.next();
			carta.sumarSiSosParteDeExodia(suma);
		}
		
		return suma == 5;
	}

}
