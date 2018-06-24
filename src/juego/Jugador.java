package juego;

import cartas.*;
import excepciones.CartaNoEstaEnCampoException;
import excepciones.CartaNoPuedeIrAlCementerioSinMorirException;

public class Jugador {

	private int vida;
	private ContenedorDeCartas mano;
	private Campo campo;

	public Jugador(Campo campo) {
		this.vida = 8000;
		this.mano = new ContenedorDeCartas(7);
		this.campo = campo;
	}

	public int vida() {
		return this.vida;
	}

	public void debilitar(int puntosDeVidaADebilitar) {
		this.vida = this.vida - puntosDeVidaADebilitar;
	}

	public void tomarCartaDelMazo() {
		Carta unaCarta = campo.tomarUnaCartaDelMazo();
		this.mano.agregar(unaCarta);
	}

	public void colocarCartaMonstruoEnModoAtaque(CartaMonstruo cartaMonstruo) {
		cartaMonstruo.agregarEnCampo(this.campo);
		cartaMonstruo.colocarEnModoAtaque();
	}

	public void colocarCartaMonstruoEnModoDefensa(CartaMonstruo cartaMonstruo) {
		cartaMonstruo.agregarEnCampo(this.campo);
		cartaMonstruo.colocarEnModoDefensa();
	}

	public void colocarCartaMagicaBocaArriba(CartaMagica cartaMagica) {
		cartaMagica.agregarEnCampo(this.campo);
		cartaMagica.colocarBocaArriba();
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
		campo.destruirTodasLasCartas();
	}
}
