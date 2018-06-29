package cartas;

import juego.ContenedorDeCartas;

public class DragonArmadoOscuro extends CartaRequiereSacrificios {

	public DragonArmadoOscuro(ContenedorDeCartas sacrificios) {
		super(sacrificios);
		this.sacrificiosRequeridos = 2;
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.puntosDeAtaque = new Puntos(2800);
		this.puntosDeDefensa = new Puntos(1000);
		this.nivel = 7;
	}

}
