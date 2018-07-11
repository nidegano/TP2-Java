package fases;

import excepciones.NoSePuedeInvocarMonstruosEnEstaFase;
import excepciones.NoSePuedeTomarMasCartasDelMazoExceptionPorqueYaSeTomoUnaEnFaseInicial;
import juego.Jugador;

public class FaseInicial implements Fase {

	private int contador;

	public FaseInicial() {
		this.contador = 0;
	}

	public String nombre() {
		return "Fase Inicial";
	}

	public void ejecutar(Jugador jugador) {
		jugador.asignarATodasLasCartasMagicasUnEstadoDeBocaAbajo(); //osea no colocableBocaArriba
	}

	public boolean termino() {
		return this.contador >= 1;
	}

	public Fase faseSiguiente() {
		return new FasePreparacion();
	}

	public void tomoCartaDelMazo() throws NoSePuedeTomarMasCartasDelMazoExceptionPorqueYaSeTomoUnaEnFaseInicial {
		if (this.contador >= 1)
			throw new NoSePuedeTomarMasCartasDelMazoExceptionPorqueYaSeTomoUnaEnFaseInicial();
		this.contador = this.contador + 1;
	}

	public boolean puedeTomarCarta() {
		return !this.termino();
	}

	@Override
	public void finalizar() {
		// la unica forma de finalizar esta fase es tomando una carta del mazo
	}
	
	@Override
	public void chequearSiSePuedeInvocaMonstruo() throws NoSePuedeInvocarMonstruosEnEstaFase {
		throw new NoSePuedeInvocarMonstruosEnEstaFase();		
	}

}
