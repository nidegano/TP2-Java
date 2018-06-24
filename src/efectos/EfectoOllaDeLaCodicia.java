package efectos;

public class EfectoOllaDeLaCodicia extends Efecto {

	@Override
	public void activar() {
		this.jugadorDueño.tomarCartaDelMazo();
		this.jugadorDueño.tomarCartaDelMazo();
	}

}
