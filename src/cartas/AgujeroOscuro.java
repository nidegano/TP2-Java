package cartas;

import efectos.EfectoAgujeroOscuro;

public class AgujeroOscuro extends CartaMagica {

	public AgujeroOscuro() {
		super();
		this.efecto = new EfectoAgujeroOscuro(this);
	}

}
