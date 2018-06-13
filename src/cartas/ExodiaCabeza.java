package cartas;

import estado.ModoInactivo;

public class ExodiaCabeza extends CartaMonstruo {

	public ExodiaCabeza() {
		this.puntosDeAtaque = 1000;
		this.puntosDeDefensa = 1000;
		this.nivel = 3;
		this.estado = new ModoInactivo();
	}

}
