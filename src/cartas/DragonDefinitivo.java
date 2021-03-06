package cartas;

public class DragonDefinitivo extends CartaRequiereSacrificios {

	public DragonDefinitivo() {
		super();
		this.sacrificiosRequeridos = 3;
		this.puntosDeAtaque = new Puntos(4500);
		this.puntosDeDefensa = new Puntos(3800);
		this.nivel = 12;
		this.nombre = "Dragon Blanco de Ojos Azules Definitivo";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_DragonDefinitivo.png");
	}

}
