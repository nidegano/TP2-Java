package juego;

import java.util.ArrayList;

import cartas.*;

public class Jugador {

	private int vida;
	private ArrayList<Carta> mano;
	private ArrayList<Carta> cementerio;
	private ContenedorDeCartas zonaMonstruos;
	private ContenedorDeCartas zonaCartasEspeciales;
	private Mazo mazo;

	public Jugador(Mazo mazo) {
		this.vida = 8000;
		this.mano = new ArrayList<Carta>();
		this.cementerio = new ArrayList<Carta>();
		this.zonaMonstruos = new ContenedorDeCartas(5);
		this.zonaCartasEspeciales = new ContenedorDeCartas(5);
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

	public void colocarCartaMagicaBocaArriba(Carta cartaMagica) {
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

	public boolean estaLaCartaEnZonaDeMonstruo(CartaMonstruo carta) {
		return this.zonaMonstruos.estaDentro(carta);
	}

	public boolean estaLaCartaEnCementerio(Carta carta) {
		return this.cementerio.contains(carta);
	}

	public void destruirCartasEnCampo() {
		this.zonaMonstruos.matarATodasLasCartas();
		this.zonaCartasEspeciales.matarATodasLasCartas();
		this.enviarCartasMuertasAlCementerio();
	}

	public void enviarCartasMuertasAlCementerio() {
		this.zonaMonstruos.enviarCartasMuertasAlCementerio(this.cementerio);
		this.zonaCartasEspeciales.enviarCartasMuertasAlCementerio(this.cementerio);
	}
	
	private void transferirCartaMonstruoAlCampo(CartaMonstruo carta) {
		this.mano.remove(carta);
		this.zonaMonstruos.agregar(carta);
	}

	private void transferirCartaMagicaAlCampo(Carta carta) {
		this.mano.remove(carta);
		this.zonaCartasEspeciales.agregar(carta);
	}

	public boolean esDueñoDe(CartaMonstruo cartaMonstruo) {
		//aca usaria el ContenedorDeCartas "seleccion" pero por ahora hago que chequee todos sus contenedores de cartas.		
		
		return  this.mano.contains(cartaMonstruo) ||
				this.zonaMonstruos.estaDentro(cartaMonstruo) ||
				this.zonaCartasEspeciales.estaDentro(cartaMonstruo);
	}

}
