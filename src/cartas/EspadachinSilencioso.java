package cartas;

import juego.ContenedorDeCartas;

public class EspadachinSilencioso extends CartaRequiereSacrificios {

	public EspadachinSilencioso(ContenedorDeCartas sacrificios) {
		super(sacrificios);
		this.sacrificiosRequeridos = 1;
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.puntosDeAtaque = new Puntos(2300);
		this.puntosDeDefensa = new Puntos(1000);
		this.nivel = 5;
	}

	@Override
	public void sumarSiSosParteDeExodia(int suma) {
		// TODO Auto-generated method stub
		
	}

}
