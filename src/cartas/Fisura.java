package cartas;

import efectos.EfectoAgujeroOscuro;
import efectos.EfectoFisura;

public class Fisura extends CartaMagica {
	
	public Fisura() {
		super();
		this.efecto = new EfectoFisura();
	}

}