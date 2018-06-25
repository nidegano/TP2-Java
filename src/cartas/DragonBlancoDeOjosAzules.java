package cartas;

import juego.ContenedorDeCartas;

public class DragonBlancoDeOjosAzules extends CartaRequiereSacrificios {

	public DragonBlancoDeOjosAzules(ContenedorDeCartas sacrificios) {
		super(sacrificios);
		this.sacrificiosRequeridos = 2;
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.puntosDeAtaque = new Puntos(3000);
		this.puntosDeDefensa = new Puntos(2500);
		this.nivel = 8;
	}

	@Override
	public void sumarSiSosParteDeExodia(int suma) {
		// TODO Auto-generated method stub
		
	}

}
