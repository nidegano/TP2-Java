package cartas;

import estado.ModoInactivo;

public class InsectoComeHombres extends CartaMonstruo {

	public InsectoComeHombres() {
		this.puntosDeAtaque = 450;
		this.puntosDeDefensa = 600;
		this.nivel = 2;
		this.estado = new ModoInactivo();
	}

}
