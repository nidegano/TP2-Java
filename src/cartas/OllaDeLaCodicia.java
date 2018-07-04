package cartas;

import efectos.EfectoOllaDeLaCodicia;

public class OllaDeLaCodicia extends CartaMagica {

	public OllaDeLaCodicia() {
		super();
		this.efecto = new EfectoOllaDeLaCodicia(this);
		this.nombre = "Olla de la Codicia";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_OllaDeLaCodicia.png");
	}

}
