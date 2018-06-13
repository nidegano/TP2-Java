package estado;

public class ModoActivo extends Estado {

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
		return true;
	}

	@Override
	public boolean estaMuerta() {
		// TODO Auto-generated method stub
		return false;
	}

}
