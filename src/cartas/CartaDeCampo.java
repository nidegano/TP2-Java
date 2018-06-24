package cartas;

import juego.Campo;
import juego.Jugador;

public class CartaDeCampo extends CartaEspecial {
	
	@Override
	public void agregarEnCampo(Campo campo) {
		campo.obtenerZonaCartasDeCampo().agregar(this);
		this.contenedoresQueLaContienen.add(campo.obtenerZonaCartasDeCampo());		
	}
}
