package efectos;

public class EfectoAgujeroOscuro extends Efecto {

	@Override
	public void activar() {
		this.jugadorDuenio.destruirCartasEnCampo();
		this.jugadorOponente.destruirCartasEnCampo();
	}

}
