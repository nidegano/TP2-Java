package estado;

public class ModoAtaque extends Estado {

	@Override
	public boolean esModoAtaque() {
		return true;
	}

	@Override
	public boolean esModoDefensa() {
		return false;
	}

	@Override
	public boolean esInactivo() {
		return false;
	}

}
