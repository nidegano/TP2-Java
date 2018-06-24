package cartas;

import efectos.EfectoAgujeroOscuro;
import efectos.EfectoOllaDeLaCodicia;

public class OllaDeLaCodicia extends CartaMagica {

	public OllaDeLaCodicia() {
		super();
		this.efecto = new EfectoOllaDeLaCodicia();
	}
}
