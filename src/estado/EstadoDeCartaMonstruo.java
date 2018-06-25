package estado;

import cartas.Puntos;
import efectos.Efecto;
import efectos.EfectoDeCampo;
import efectos.EfectoDeVolteo;
import efectos.EfectoEspeciales;
import efectos.EfectoInvocacionMonstruo;
import efectos.EfectoNulo;
import juego.FormaDeAfectarAlJugador;

public abstract class EstadoDeCartaMonstruo extends Estado {

	protected Puntos puntosAsociadosAlEstado;

	public int puntosAsociadosAlEstado() {
		return this.puntosAsociadosAlEstado.valor();
	}

	public abstract FormaDeAfectarAlJugador formaDeAfectar(int diferencia);
	
	@Override
	public void activar(EfectoNulo efectoNulo) {}

	@Override
	public void activar(EfectoDeCampo efectoDeCampo) {}

	@Override
	public void activar(EfectoEspeciales efectoEspeciales) {}
}
