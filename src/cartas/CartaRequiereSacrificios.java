package cartas;

import excepciones.CantidadInadecuadaDeSacrificiosException;
import juego.ContenedorDeCartas;

public class CartaRequiereSacrificios extends CartaMonstruo {

	protected ContenedorDeCartas sacrificios;
	protected int sacrificiosRequeridos;

	public CartaRequiereSacrificios(ContenedorDeCartas sacrificios) {
		this.sacrificios = sacrificios;
	}

	protected void chequearQueLaCantidadDeSacrificiosSeaCorrecta(ContenedorDeCartas sacrificios) {
		if (sacrificios.cantidad() != this.sacrificiosRequeridos)
			throw new CantidadInadecuadaDeSacrificiosException();
	}

	public void invocarEnModoAtaque() {
		this.colocarEnModoAtaque();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.efecto.activar();
		for (Carta monstruo : this.sacrificios)
			monstruo.matar();
	}

}
