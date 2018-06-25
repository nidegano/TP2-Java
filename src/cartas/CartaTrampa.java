package cartas;

import juego.Campo;

public abstract class CartaTrampa extends CartaEspecial {

	@Override
	public void agregarEnCampo(Campo campo) {
	}

	@Override
	public abstract void sumarSiSosParteDeExodia(int suma);

}
