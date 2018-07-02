package cartas;

import estado.ModoActivo;
import excepciones.CartaNoEstaEnContenedorDeCartasException;
import juego.Campo;
import vista.Grilla;

public abstract class CartaTrampa extends CartaEspecial {

	@Override
	public void agregarEnCampo(Campo campo) {
		campo.obtenerZonaEspeciales().agregar(this);
		this.contenedoresQueLaContienen.add(campo.obtenerZonaEspeciales());

		campo.obtenerContenedorCartasTrampa().agregar(this);
		this.contenedoresQueLaContienen.add(campo.obtenerContenedorCartasTrampa());

		try {
			this.contenedoresQueLaContienen.remove(this.jugadorDuenio.obtenerMano());
			this.jugadorDuenio.obtenerMano().remover(this);
		}
		catch (CartaNoEstaEnContenedorDeCartasException e) {}
	}

	public void colocarBocaArriba(CartaMonstruo monstruoEnemigo, CartaMonstruo monstruoPropio) {
		this.estado = new ModoActivo();
		this.activar(monstruoEnemigo, monstruoPropio);
	}

	public void colocarBocaArriba(CartaMonstruo monstruoEnemigo) {
		this.estado = new ModoActivo();
		this.activar(monstruoEnemigo);
	}

	@Override
	public void provocarActualizacionDeLaGrillaSegunTipo(Grilla grilla) {
		grilla.actualizarGrillaPorSeleccionDeCartaDeMano(this);
	}
	
	@Override
	public void actualizarGrillaPorinvocacionSegunCorrespondaPorElTipo(Grilla grilla) {
		grilla.actualizarPorInvocacionDeUnaCartaEspecial(this);
	}

}
