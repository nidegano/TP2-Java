package cartas;

public class DragonBlancoDeOjosAzules extends CartaRequiereSacrificios {

	public DragonBlancoDeOjosAzules() {
		super();
		this.sacrificiosRequeridos = 2;
		this.puntosDeAtaque = new Puntos(3000);
		this.puntosDeDefensa = new Puntos(2500);
		this.nivel = 8;
		this.nombre = "Dragon Blanco de Ojos Azules";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_DragonBlancoDeOjosAzules.png");
	}

}
