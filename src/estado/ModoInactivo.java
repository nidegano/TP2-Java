package estado;

public class ModoInactivo extends Estado {

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
		return true;
	}

	@Override
	public boolean esActivo() {
		// TODO Auto-generated method stub
		return false;
	}

}
