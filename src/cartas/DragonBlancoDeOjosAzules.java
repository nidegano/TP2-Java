package cartas;

import estado.ModoInactivo;

public class DragonBlancoDeOjosAzules extends MonstruoRequiereDosSacrificios {

	public DragonBlancoDeOjosAzules() {
		this.puntosDeAtaque = 3000;
		this.puntosDeDefensa = 2500;
		this.nivel = 8;
		this.estado = new ModoInactivo();
	}

}
