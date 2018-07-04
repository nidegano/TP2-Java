package juego;

import cartas.Carta;
import cartas.CartaMagica;
import cartas.CartaMonstruo;
import excepciones.ContenedorDeCartasVacioException;
import excepciones.MazoSinCartasException;

public class Campo {

	private ContenedorDeCartas cementerio;
	private ContenedorDeCartas zonaMonstruos;
	private ContenedorDeCartas zonaCartasEspeciales;
	private ContenedorDeCartas zonaCartasDeCampo;
	private Mazo mazo;

	private ContenedorDeCartas contenedorCartasMagicas;
	private ContenedorDeCartas contenedorCartasTrampa;

	public Campo(Mazo mazo) {
		this.cementerio = new ContenedorDeCartas(40);
		this.zonaMonstruos = new ContenedorDeCartas(5);
		this.zonaCartasEspeciales = new ContenedorDeCartas(5);
		this.zonaCartasDeCampo = new ContenedorDeCartas(1);
		this.mazo = mazo;
		this.contenedorCartasMagicas = new ContenedorDeCartas(12);
		this.contenedorCartasTrampa = new ContenedorDeCartas(12);
	}

	public Carta tomarUnaCartaDelMazo() throws MazoSinCartasException {
		return this.mazo.tomarUnaCarta();
	}

	public boolean estaDentro(Carta carta) {
		return this.zonaCartasDeCampo.estaDentro(carta) || this.zonaCartasEspeciales.estaDentro(carta)
				|| this.zonaMonstruos.estaDentro(carta) || this.contenedorCartasMagicas.estaDentro(carta)
				|| this.contenedorCartasTrampa.estaDentro(carta);
	}

	public void destruirTodasLasCartas() {
		this.zonaCartasEspeciales.matarATodasLasCartas();
		this.zonaMonstruos.matarATodasLasCartas();
		this.contenedorCartasMagicas.matarATodasLasCartas();
		this.contenedorCartasTrampa.matarATodasLasCartas();
		this.zonaCartasDeCampo.matarATodasLasCartas();
	}

	public boolean estaLaCartaEnCementerio(Carta carta) {
		return this.cementerio.estaDentro(carta);
	}

	public ContenedorDeCartas obtenerCementerio() {
		return this.cementerio;
	}

	public ContenedorDeCartas obtenerZonaMonstruos() {
		return this.zonaMonstruos;
	}

	public ContenedorDeCartas obtenerZonaEspeciales() {
		return this.zonaCartasEspeciales;
	}

	public ContenedorDeCartas obtenerZonaCartasDeCampo() {
		return this.zonaCartasDeCampo;
	}

	public CartaMonstruo obtenerElMonstruoDeMenorAtaque() throws ContenedorDeCartasVacioException {
		Carta monstruoDeMenorAtaque = this.zonaMonstruos.obtenerPrimero();
		int puntosDelDeMenorAtaque = ((CartaMonstruo) monstruoDeMenorAtaque).obtenerPuntosDeAtaque();
		int puntosAEvaluar;

		for (Carta monstruo : this.zonaMonstruos) {
			puntosAEvaluar = ((CartaMonstruo) monstruo).obtenerPuntosDeAtaque();
			if (puntosAEvaluar < puntosDelDeMenorAtaque) {
				puntosDelDeMenorAtaque = puntosAEvaluar;
				monstruoDeMenorAtaque = monstruo;
			}
		}
		return (CartaMonstruo) monstruoDeMenorAtaque;
	}

	public ContenedorDeCartas obtenerContenedorCartasMagicas() {
		return this.contenedorCartasMagicas;
	}

	public ContenedorDeCartas obtenerContenedorCartasTrampa() {
		return this.contenedorCartasTrampa;
	}

	public boolean tieneCartasEnElMazo() {
		return mazo.hayCartas();
	}

	public Mazo mazo() {
		return this.mazo;
	}

	public void asignarATodasLasCartasMagicasUnEstadoDeColocablesBocaArriba() {
		for (Carta cartaMagica : this.contenedorCartasMagicas) {
			((CartaMagica)cartaMagica).asignarEstadoDeColocableBocaArriba();
		}
	}

	public void asignarATodasLasCartasMagicasUnEstadoDeDeBocaAbajo() {
		for (Carta cartaMagica : this.contenedorCartasMagicas) {
			((CartaMagica)cartaMagica).asignarEstadoDeBocaAbajo();
		}
	}

}
