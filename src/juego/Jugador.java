package juego;

import java.util.ArrayList;

import java.util.List;

import cartas.*;

public class Jugador {

	private int vida;
	private ArrayList<Carta> mano;
	private ArrayList<Carta> cementerio;
	private ContenedorDeCartas zonaMonstruos;
	private ArrayList<Carta> cartasEspeciales;
	private Mazo mazo;

	public Jugador(Mazo mazo) {
		this.vida = 8000;
		this.mano = new ArrayList<Carta>();
		this.cementerio = new ArrayList<Carta>();
		this.zonaMonstruos = new ContenedorDeCartas(5);
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
	
	public void colocarCartaMonstruoDeUnSacrificioEnModoAtaque(CartaMonstruo cartaMonstruo) {
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
		return (CartaMonstruo) this.zonaMonstruos.obtenerPrimero();
	}

	public void sacrificarMonstruo(CartaMonstruo carta) {
		this.mano.remove(carta);
		this.cementerio.add(carta);
	}

	public void enviarAlCementerio(CartaMonstruo carta) {
		this.zonaMonstruos.remover(carta);
		this.cementerio.add(carta);
	}

	public boolean estaLaCartaEnZonaDeMonstruo(Carta carta) {
		return this.zonaMonstruos.estaDentro(carta);
	}

	public boolean estaLaCartaEnCementerio(Carta carta) {
		return this.cementerio.contains(carta);
	}

	private void transferirCartaMonstruoAlCampo(CartaMonstruo carta) {
		this.mano.remove(carta);
		this.zonaMonstruos.agregar(carta);
	}

	private void transferirCartaMagicaAlCampo(CartaMagica carta) {
		this.mano.remove(carta);
		this.cartasEspeciales.add(carta);
	}

	public Carta elegirMagica() {
		return this.cartasEspeciales.get(0);
	}

	public void destruirCartasEnCampo() {
		
		this.zonaMonstruos.matarATodasLasCartas();
		this.enviarCartasMuertasAlCementerio();
	}

	public void enviarCartasMuertasAlCementerio() {
		
		List<Carta> cartasMuertas = this.zonaMonstruos.obtenerCartasMuertas();
		
		for (Carta carta : cartasMuertas) {
			this.cementerio.add(carta);
		}
	}
}
