package estado;

public class EstadoMuerto extends Estado {

	@Override
	public boolean esModoAtaque() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esModoDefensa() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esInactivo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esActivo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estaMuerta() {
		// TODO Auto-generated method stub
		return true;
	}

}
