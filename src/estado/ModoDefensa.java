package estado;

public class ModoDefensa extends Estado {

	@Override
	public boolean esModoAtaque() {
		return false;
	}

	@Override
	public boolean esModoDefensa() {
		return true;
	}

	@Override
	public boolean esInactivo() {
		return false;
	}

}
