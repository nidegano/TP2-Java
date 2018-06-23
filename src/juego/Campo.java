package juego;

import cartas.Carta;
import cartas.CabezaExodia;

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
		// TODO Auto-generated method stub
		return null;
	}

	public boolean estaEnCementerio(Carta carta) {
		// TODO Auto-generated method stub
		return false;
	}
}
