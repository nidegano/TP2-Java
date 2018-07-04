package cartas;

public class AlphaTheMagnetWarrior extends CartaMonstruo {

	public AlphaTheMagnetWarrior() {
		super();
		this.puntosDeAtaque = new Puntos(1400);
		this.puntosDeDefensa = new Puntos(1700);
		this.nivel = 4;
		this.nombre = "Alpha The Magnet Warrior";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_AlphaTheMagnetWarrior.png");
	}

}
