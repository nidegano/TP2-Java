package efectos;

public class EfectoOllaDeLaCodicia extends Efecto {

	@Override
	public void activar() {
		this.jugadorDuenio.tomarCartaDelMazo();
		this.jugadorDuenio.tomarCartaDelMazo();
	}

}
