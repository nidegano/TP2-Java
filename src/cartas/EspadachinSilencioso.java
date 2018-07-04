package cartas;

public class EspadachinSilencioso extends CartaRequiereSacrificios {

	public EspadachinSilencioso() {
		super();
		this.sacrificiosRequeridos = 1;
		this.puntosDeAtaque = new Puntos(2300);
		this.puntosDeDefensa = new Puntos(1000);
		this.nivel = 5;
		this.nombre = "Espadachin Silencioso";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_EspadachinSilencioso.png");
	}

}
