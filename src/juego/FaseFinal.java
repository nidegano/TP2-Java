package juego;

import excepciones.NoSePuedeInvocarMonstruosEnEstaFase;

public class FaseFinal implements Fase {

	private boolean termino;

	@Override
	public String nombre() {
		return "Fase Final";
	}

	@Override
	public void ejecutar(Jugador jugador) {
		jugador.asignarATodasLasCartasMagicasUnEstadoDeColocablesBocaArriba();
	}

	@Override
	public boolean termino() {
		return this.termino;
	}

	@Override
	public Fase faseSiguiente() {
		return new FaseInicial();
	}

	@Override
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
		throw new NoSePuedeInvocarMonstruosEnEstaFase();		
	}

}
