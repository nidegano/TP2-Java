package efectos;

public class EfectoAgujeroOscuro extends Efecto {

	@Override
	public void activar() {
		this.jugadorDueño.destruirCartasEnCampo();
		this.jugadorOponente.destruirCartasEnCampo();
	}

}
