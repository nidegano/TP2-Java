package cartas;

public class AncientBrain extends CartaMonstruo {

	public AncientBrain() {
		super();
		this.puntosDeAtaque = new Puntos(1000);
		this.puntosDeDefensa = new Puntos(700);
		this.nivel = 3;
		this.nombre = "Ancient Brain";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_AncientBrain.png");
	}

}
