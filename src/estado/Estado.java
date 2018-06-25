package estado;

import efectos.Efecto;
import efectos.EfectoDeCampo;
import efectos.EfectoDeVolteo;
import efectos.EfectoEspeciales;
import efectos.EfectoInvocacionMonstruo;
import efectos.EfectoNulo;

public abstract class Estado {

	public abstract void activar(EfectoDeVolteo efectoDeVolteo);

	public abstract void activar(EfectoInvocacionMonstruo efectoInvocacionMonstruo);

	public abstract void activar(EfectoNulo efectoNulo);

	public abstract void activar(EfectoDeCampo efectoDeCampo);

	public abstract void activar(EfectoEspeciales efectoEspeciales);
	
	public void activar(Efecto efecto) {
		efecto.serActivadoPor(this);
	}
}
