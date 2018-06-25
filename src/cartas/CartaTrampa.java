package cartas;

import estado.ModoActivo;
import juego.Campo;

public class CartaTrampa extends CartaEspecial{

	@Override
	public void agregarEnCampo(Campo campo) {
		campo.obtenerZonaEspeciales().agregar(this);
		this.contenedoresQueLaContienen.add(campo.obtenerZonaEspeciales());
		
		campo.obtenerContenedorCartasTrampa().agregar(this);
		this.contenedoresQueLaContienen.add(campo.obtenerContenedorCartasTrampa());
	}

	public void colocarBocaArriba(CartaMonstruo cartaMonstruo) {
		this.estado = new ModoActivo();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.activar(cartaMonstruo);		
	}
}
