package cartas;

import juego.Campo;

public abstract class CartaDeCampo extends CartaEspecial {

	@Override
	public void agregarEnCampo(Campo campo) {
		campo.obtenerZonaCartasDeCampo().agregar(this);
		this.contenedoresQueLaContienen.add(campo.obtenerZonaCartasDeCampo());
		
		this.contenedoresQueLaContienen.remove(this.jugadorDuenio.obtenerMano());
		this.jugadorDuenio.obtenerMano().remover(this);
	}
}
