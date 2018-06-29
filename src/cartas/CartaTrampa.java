package cartas;

import estado.ModoActivo;
import juego.Campo;

public abstract class CartaTrampa extends CartaEspecial {

	@Override
	public void agregarEnCampo(Campo campo) {
		campo.obtenerZonaEspeciales().agregar(this);
		this.contenedoresQueLaContienen.add(campo.obtenerZonaEspeciales());

		campo.obtenerContenedorCartasTrampa().agregar(this);
		this.contenedoresQueLaContienen.add(campo.obtenerContenedorCartasTrampa());

		this.contenedoresQueLaContienen.remove(this.jugadorDuenio.obtenerMano());
		this.jugadorDuenio.obtenerMano().remover(this);
	}

	public void colocarBocaArriba(CartaMonstruo monstruoEnemigo, CartaMonstruo monstruoPropio) {
		this.estado = new ModoActivo();
		this.activar(monstruoEnemigo, monstruoPropio);
	}

	public void colocarBocaArriba(CartaMonstruo monstruoEnemigo) {
		this.estado = new ModoActivo();
		this.activar(monstruoEnemigo);
	}

}
