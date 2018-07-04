package cartas;

import efectos.EfectoFisura;

public class Fisura extends CartaMagica {

	public Fisura() {
		super();
		this.efecto = new EfectoFisura(this);
		this.nombre = "Fisura";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_Fisura.png");
	}

}