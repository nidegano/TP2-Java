package juego;

import java.util.ArrayList;
import java.util.Iterator;

import cartas.*;

public class Jugador {

	private int vida;
	private ArrayList<Carta> mano;
	private ArrayList<Carta> cementerio;
	private ArrayList<CartaMonstruo> monstruos;
	private ArrayList<Carta> cartasEspeciales;
	private Mazo mazo;

	public Jugador(Mazo mazo) {
		this.vida = 8000;
		this.mano = new ArrayList<Carta>();
		this.cementerio = new ArrayList<Carta>();
		this.monstruos = new ArrayList<CartaMonstruo>();
		this.cartasEspeciales = new ArrayList<Carta>();
		this.mazo = mazo;
	}

	public int vida() {
		return this.vida;
	}

	public void debilitar(int puntosDeVidaADebilitar) {
		this.vida = this.vida - puntosDeVidaADebilitar;
	}

	public void tomarCartaDelMazo() {
		Carta unaCarta = mazo.tomarUnaCarta();
		this.mano.add(unaCarta);
	}

	public void colocarCartaMonstruoEnModoAtaque(CartaMonstruo cartaMonstruo) {
		cartaMonstruo.colocarEnModoAtaque();
		this.transferirCartaMonstruoAlCampo(cartaMonstruo);
	}

	public void colocarCartaMonstruoEnModoDefensa(CartaMonstruo cartaMonstruo) {
		cartaMonstruo.colocarEnModoDefensa();
		this.transferirCartaMonstruoAlCampo(cartaMonstruo);
	}

	public void colocarCartaMagicaBocaArriba(CartaMagica cartaMagica) {
		cartaMagica.colocarBocaArriba();
		this.transferirCartaMagicaAlCampo(cartaMagica);
	}

	public CartaMonstruo elegirMonstruo() {
		return this.monstruos.get(0);
	}

	public void sacrificarMonstruo(CartaMonstruo carta) {
		this.mano.remove(carta);
		this.cementerio.add(carta);
	}

	public void enviarAlCementerio(CartaMonstruo carta) {
		this.monstruos.remove(carta);
		this.cementerio.add(carta);
	}

	public boolean estaLaCartaEnZonaDeMonstruo(Carta carta) {
		return this.monstruos.contains(carta);
	}

	public boolean estaLaCartaEnCementerio(Carta carta) {
		return this.cementerio.contains(carta);
	}

	private void transferirCartaMonstruoAlCampo(CartaMonstruo carta) {
		this.mano.remove(carta);
		this.monstruos.add(carta);
	}

	private void transferirCartaMagicaAlCampo(CartaMagica carta) {
		this.mano.remove(carta);
		this.cartasEspeciales.add(carta);
	}

	public Carta elegirMagica() {
		return this.cartasEspeciales.get(0);
	}

	public void destruirCartasEnCampo() {
		Iterator<CartaMonstruo> iter = monstruos.iterator();
		
		//itero la lista monstruos. 
		while(iter.hasNext()) {
			this.cementerio.add(iter.next()); //agrego carta al cementerio
			iter.remove(); //la borro de la lista
		}
	}
}
