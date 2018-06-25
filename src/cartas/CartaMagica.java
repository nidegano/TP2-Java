package cartas;

import juego.Campo;

public abstract class CartaMagica extends CartaEspecial {

	public CartaMagica() {
		super();
	}

	@Override
	public void agregarEnCampo(Campo campo) {
		campo.obtenerZonaEspeciales().agregar(this);
		this.contenedoresQueLaContienen.add(campo.obtenerZonaEspeciales());
	}

	@Override
	public abstract void sumarSiSosParteDeExodia(int suma);

}
