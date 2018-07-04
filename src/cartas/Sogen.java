package cartas;

import efectos.EfectoSogen;

public class Sogen extends CartaDeCampo {

	public Sogen() {
		super();
		this.efecto = new EfectoSogen(this);
		this.nombre = "Sogen";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_Sogen.png");
	}

}
