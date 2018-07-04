package cartas;

import efectos.EfectoAgujeroOscuro;

public class AgujeroOscuro extends CartaMagica {

	public AgujeroOscuro() {
		super();
		this.efecto = new EfectoAgujeroOscuro(this);
		this.nombre = "Agujero Oscuro";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_AgujeroOscuro.png");
		this.crearVistaCarta();
		//mas adelante se le asigna la vista a la VistaCarta de la carta
	}
}
