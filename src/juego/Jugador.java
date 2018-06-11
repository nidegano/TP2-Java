package juego;

import java.util.ArrayList;

import cartas.*;

public class Jugador {

	private int vida;
	private ArrayList<Carta> mano;
	private ArrayList<Carta> cementerio;
	private ArrayList<CartaMonstruo> monstruos;
	private ArrayList<Carta> cartasEspeciales;
	Mazo mazo;

	public Jugador(Mazo mazo) {
		this.vida = 8000;
		this.mano = new ArrayList<Carta>();
		this.cementerio = new ArrayList<Carta>();
		this.monstruos = new ArrayList<CartaMonstruo>();
		this.cartasEspeciales = new ArrayList<Carta>();
		this.mazo = mazo;
	}

	public void tomarCartaDelMazo() {
		
		Carta unaCarta = mazo.tomarUnaCarta();
		this.mano.add(unaCarta);
	}

	public void sacrificarMonstruo(CartaMonstruo carta) {
		this.mano.remove(carta);
		this.cementerio.add(carta);
	}

	public boolean estaLaCartaEnCementerio(Carta carta) {
		return this.cementerio.contains(carta);
	}

	public void meAtaca(Jugador jugadorA) {
		
		
	}

	public int vida() {
		return this.vida;
	}

	public void colocarCartaMonstruoEnModoAtaque(CartaMonstruo cartaMonstruo) {
		
		transferirCartaMonstruoAlCampo(cartaMonstruo);		
		cartaMonstruo.colocarEnModoAtaque();
		this.monstruos.add(cartaMonstruo);
	}

	public void colocarCartaMonstruoEnModoDefensa(CartaMonstruo cartaMonstruo) {

		transferirCartaMonstruoAlCampo(cartaMonstruo);		
		cartaMonstruo.colocarEnModoDefensa();
		this.monstruos.add(cartaMonstruo);
	}

	public void colocarCartaMagicaBocaArriba(CartaMagica cartaMagica) {

		transferirCartaMagicaAlCampo(cartaMagica);		
		cartaMagica.colocarBocaArriba();
		this.cartasEspeciales.add(cartaMagica);
	}
	
	private void transferirCartaMonstruoAlCampo(CartaMonstruo carta) {
		this.mano.remove(carta);
		this.monstruos.add(carta);
	}

	private void transferirCartaMagicaAlCampo(CartaMagica carta) {
		this.mano.remove(carta);
		this.cartasEspeciales.add(carta);
	}

	private void transferirCartaTrampaAlCampo(CartaTrampa carta) {
		this.mano.remove(carta);
		this.cartasEspeciales.add(carta);
	}

}
