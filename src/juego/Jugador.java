package juego;

import cartas.*;
import excepciones.CartaNoEstaEnCampoException;
import excepciones.CartaNoPuedeIrAlCementerioSinMorirException;

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
		ContenedorDeCartas sacrificios = new ContenedorDeCartas(0);
		cartaMonstruo.colocarEnModoAtaque(sacrificios);
		this.pasarCartaMonstruoDeLaManoALaZonaMonstruos(cartaMonstruo);
	}

	public void colocarCartaMonstruoEnModoDefensa(CartaMonstruo cartaMonstruo) {
		cartaMonstruo.colocarEnModoDefensa();
		this.pasarCartaMonstruoDeLaManoALaZonaMonstruos(cartaMonstruo);
	}

	public void colocarCartaMagicaBocaArriba(CartaMagica cartaMagica) {
		cartaMagica.colocarBocaArriba();
		this.pasarCartaMagicaDeLaManoALaZonaDeCartasEspeciales(cartaMagica);
	}

	public void sacrificarMonstruo(CartaMonstruo carta) {
		this.chequearQueElMonstruoEsteEnLaZonaDeMonstruos(carta);
		carta.matar();
		this.enviarCartaMonstruoAlCementerio(carta);
	}

	public void enviarCartaMonstruoAlCementerio(CartaMonstruo carta) {
		this.chequearQueEsteMuerta(carta);
		if (this.zonaMonstruos.estaDentro(carta))
			this.zonaMonstruos.remover(carta);
		if (this.mano.estaDentro(carta))
			this.mano.remover(carta);
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
	}

	public void enviarCartasMuertasAlCementerio() {
		this.zonaMonstruos.enviarCartasMuertasAlCementerio(this.cementerio);
		this.zonaCartasEspeciales.enviarCartasMuertasAlCementerio(this.cementerio);
	}

	public boolean esDuenioDe(Carta carta) {
		// aca usaria el ContenedorDeCartas "seleccion" pero por ahora hago que chequee
		// todos sus contenedores de cartas.
		return this.mano.estaDentro(carta) || this.zonaMonstruos.estaDentro(carta) || this.zonaCartasEspeciales.estaDentro(carta);
	}

	private void chequearQueElMonstruoEsteEnLaZonaDeMonstruos(CartaMonstruo carta) {
		if (!this.zonaMonstruos.estaDentro(carta))
			throw new CartaNoEstaEnCampoException();
	}

	private void chequearQueEsteMuerta(Carta carta) {
		if (!carta.estaMuerta())
			throw new CartaNoPuedeIrAlCementerioSinMorirException();
	}

	private void pasarCartaMonstruoDeLaManoALaZonaMonstruos(CartaMonstruo carta) {
		this.mano.remover(carta);
		this.zonaMonstruos.agregar(carta);
	}

	private void pasarCartaMagicaDeLaManoALaZonaDeCartasEspeciales(CartaMagica carta) {
		this.mano.remover(carta);
		this.zonaCartasEspeciales.agregar(carta);
	}

}
