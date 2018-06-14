package estado;

public class Muerto extends Estado {

	@Override
	public boolean esModoAtaque() {
		return false;
	}

	@Override
	public boolean esModoDefensa() {
		return false;
	}

	@Override
	public boolean esInactivo() {
		return false;
	}

	@Override
	public boolean esActivo() {
		return false;
	}

	@Override
	public boolean estaMuerta() {
		return true;
	}

}
