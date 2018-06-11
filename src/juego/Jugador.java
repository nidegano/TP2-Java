package juego;

import java.util.ArrayList;

import cartas.*;

public class Jugador {

	private int vida;
	private ArrayList<Carta> mano;
	private ArrayList<Carta> cementerio;
	private ArrayList<CartaMonstruo> monstruos;
	private ArrayList<Carta> cartasEspeciales;

	public Jugador() {
		this.vida = 8000;
		this.mano = new ArrayList<Carta>();
		this.cementerio = new ArrayList<Carta>();
		this.monstruos = new ArrayList<CartaMonstruo>();
		this.cartasEspeciales = new ArrayList<Carta>();
	}

	public void agregarCartaAMano(Carta carta) {
		this.mano.add(carta);
	}

	public void colocarCartaMonstruo(CartaMonstruo carta) {
		this.mano.remove(carta);
		this.monstruos.add(carta);
	}

	public void colocarCartaMagica(CartaMagica carta) {
		this.mano.remove(carta);
		this.cartasEspeciales.add(carta);
	}

	public void colocarCartaTrampa(CartaTrampa carta) {
		this.mano.remove(carta);
		this.cartasEspeciales.add(carta);
	}

	public void sacrificarMonstruo(CartaMonstruo carta) {
		this.mano.remove(carta);
		this.cementerio.add(carta);
	}

	public boolean estaLaCartaEnCementerio(Carta carta) {
		return this.cementerio.contains(carta);
	}

	public void meAtaca(Jugador jugadorA) {
		// TODO Auto-generated method stub

	}

	public int vida() {
		return this.vida;
	}

}
