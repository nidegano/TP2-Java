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

	@Override
	public boolean esActivo() {
		return false;
	}

	@Override
	public boolean estaMuerta() {
		// TODO Auto-generated method stub
		return false;
	}

}
