package cartas;

import estado.ModoInactivo;
import juego.Campo;

public class CartaTrampa extends Carta {

	public void colocarBocaAbajo() {
		this.estado = new ModoInactivo();
	}

	public boolean estaBocaAbajo() {
		return this.estado instanceof ModoInactivo;
	}

	@Override
	public void agregarEnCampo(Campo campo) {
		// TODO Auto-generated method stub
		
	}

}
