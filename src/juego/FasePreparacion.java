
package juego;

import excepciones.SoloSePuedeInvocarUnSoloMonstruoEnEstaFase;

public class FasePreparacion implements Fase {

	private boolean termino = false;
	private boolean yaSeInvocoUnMonstruo = false;

	public String nombre() {
		return "Fase de Preparacion";
	}

	public void ejecutar(Jugador jugador) {
		//jugador.campo().renovarLaPosibilidadDeAtacarEnCartasMonstruo();
		//jugador.reiniciarLaPosibilidadDeInvocarMonstruos();
	}

	public boolean termino() {
		return this.termino;
	}

	public Fase faseSiguiente() {
		return new FaseAtaque();
	}

	public boolean puedeTomarCarta() {
		return false;
	}

	@Override
	public void tomoCartaDelMazo() {
	}

	@Override
	public void finalizar() {
		this.termino = true;
	}
	
	@Override
	public void chequearSiSePuedeInvocaMonstruo() {
		if (this.yaSeInvocoUnMonstruo) {
			throw new SoloSePuedeInvocarUnSoloMonstruoEnEstaFase();
		}
		this.yaSeInvocoUnMonstruo = true;
	}
}
