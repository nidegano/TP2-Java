package cartas;

import juego.Campo;

public abstract class CartaDePrueba extends Carta {

	@Override
	public void agregarEnCampo(Campo campo) {}

	@Override
	public abstract void sumarSiSosParteDeExodia(int suma);

}
