package juego;

import cartas.Carta;
import cartas.CartaMonstruo;

public class Campo {

	private ContenedorDeCartas cementerio;
	private ContenedorDeCartas zonaMonstruos;
	private ContenedorDeCartas zonaCartasEspeciales;
	private ContenedorDeCartas zonaCartasDeCampo;
	private Mazo mazo;

	public Campo(Mazo mazo) {

		this.cementerio = new ContenedorDeCartas(mazo.capacidad());
		this.zonaMonstruos = new ContenedorDeCartas(5);
		this.zonaCartasEspeciales = new ContenedorDeCartas(5);
		this.zonaCartasDeCampo = new ContenedorDeCartas(1);
		this.mazo = mazo;
	}

	public Carta tomarUnaCartaDelMazo() {
		return this.mazo.tomarUnaCarta();
	}
	
	public boolean estaDentro(Carta carta) {
		return this.zonaCartasDeCampo.estaDentro(carta) &&
				this.zonaCartasEspeciales.estaDentro(carta) &&
				this.zonaMonstruos.estaDentro(carta);
	}

	public void destruirTodasLasCartas() {
		this.zonaCartasEspeciales.matarATodasLasCartas();
		this.zonaMonstruos.matarATodasLasCartas();
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


	public CartaMonstruo obtenerElMonstruoDeMenorAtaque() {
		
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
}
