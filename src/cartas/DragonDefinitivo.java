package cartas;

import juego.ContenedorDeCartas;

public class DragonDefinitivo extends CartaRequiereSacrificios {
	
	public DragonDefinitivo(ContenedorDeCartas sacrificios) {
		super(sacrificios);
		this.sacrificiosRequeridos = 3;
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.puntosDeAtaque = new Puntos(4500);
		this.puntosDeDefensa = new Puntos(3800);
		this.nivel = 12;
		this.sacrificios = sacrificios;
	}

}
