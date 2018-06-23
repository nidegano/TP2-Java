package cartas;

import juego.Campo;
import juego.Jugador;

public class CartaDeCampo extends Carta {
	
	@Override
	public void agregarEnCampo(Campo campo) {
		// TODO Auto-generated method stub
		
	}
	
	public void activar() {
		this.agregarEnCampo(this.jugadorDueño.campo());
		//activar efecto?
	}

}
