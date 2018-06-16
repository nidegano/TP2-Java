package estado;

public abstract class Estado {

	private boolean estaMuerta;
	
	public boolean estaMuerta() {
		
		return this.estaMuerta;
	}

	public void transformarAMuerto() {
		
		this.estaMuerta = true;
	}
}
