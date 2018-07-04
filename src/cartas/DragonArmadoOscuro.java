package cartas;

public class DragonArmadoOscuro extends CartaRequiereSacrificios {

	public DragonArmadoOscuro() {
		super();
		this.sacrificiosRequeridos = 2;
		this.puntosDeAtaque = new Puntos(2800);
		this.puntosDeDefensa = new Puntos(1000);
		this.nivel = 7;
		this.nombre = "Dragon Armado Oscuro";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_DragonArmadoOscuro.png");
	}

}
