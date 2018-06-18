package juego;

import cartas.*;

public class Jugador {

	private int vida;
	private ContenedorDeCartas mano;
	private ContenedorDeCartas cementerio;
	private ContenedorDeCartas zonaMonstruos;
	private ContenedorDeCartas zonaCartasEspeciales;
	private Mazo mazo;

	public Jugador(Mazo mazo) {
		this.vida = 8000;
		this.mano = new ContenedorDeCartas(5);
		this.cementerio = new ContenedorDeCartas(mazo.capacidad());
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
		this.mano.agregar(unaCarta);
	}

	public void colocarCartaMonstruoEnModoAtaque(CartaMonstruo cartaMonstruo) {
		cartaMonstruo.colocarEnModoAtaque();
		this.pasarCartaMonstruoDeLaManoAlCampo(cartaMonstruo);
	}

	public void colocarCartaMonstruoEnModoDefensa(CartaMonstruo cartaMonstruo) {
		cartaMonstruo.colocarEnModoDefensa();
		this.pasarCartaMonstruoDeLaManoAlCampo(cartaMonstruo);
	}

	public void colocarCartaMagicaBocaArriba(CartaMagica cartaMagica) {
		cartaMagica.colocarBocaArriba();
		this.pasarCartaMagicaDeLaManoAlCampo(cartaMagica);
	}

	public CartaMonstruo elegirMonstruo() {
		return (CartaMonstruo) this.zonaMonstruos.obtenerPrimero();
	}

	public void sacrificarMonstruo(CartaMonstruo carta) {
		this.mano.remover(carta);
		this.cementerio.agregar(carta);
	}

	public void enviarAlCementerio(CartaMonstruo carta) {
		this.zonaMonstruos.remover(carta);
		this.cementerio.agregar(carta);
	}

	public boolean estaLaCartaEnZonaDeMonstruo(CartaMonstruo carta) {
		return this.zonaMonstruos.estaDentro(carta);
	}

	public boolean estaLaCartaEnCementerio(Carta carta) {
		return this.cementerio.estaDentro(carta);
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
	
	private void pasarCartaMonstruoDeLaManoAlCampo(CartaMonstruo carta) {
		this.mano.remover(carta);
		this.zonaMonstruos.agregar(carta);
	}

	private void pasarCartaMagicaDeLaManoAlCampo(CartaMagica carta) {
		this.mano.remover(carta);
		this.zonaCartasEspeciales.agregar(carta);
	}

	public boolean esDueñoDe(CartaMonstruo cartaMonstruo) {
		//aca usaria el ContenedorDeCartas "seleccion" pero por ahora hago que chequee todos sus contenedores de cartas.		
		
		return  this.mano.estaDentro(cartaMonstruo) ||
				this.zonaMonstruos.estaDentro(cartaMonstruo) ||
				this.zonaCartasEspeciales.estaDentro(cartaMonstruo);
	}

}
