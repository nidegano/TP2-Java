package cartas;

import java.util.ArrayList;

import java.util.List;

import efectos.Efecto;
import efectos.EfectoNulo;
import juego.Campo;
import juego.ContenedorDeCartas;
import juego.Jugador;
import juego.Mano;
import juego.RecolectorDePartesDeExodia;

public abstract class Carta {

	protected Jugador jugadorDuenio;
	protected List<ContenedorDeCartas> contenedoresQueLaContienen;
	protected Efecto efecto;

	public Carta() {
		this.contenedoresQueLaContienen = new ArrayList<ContenedorDeCartas>();
		this.efecto = new EfectoNulo(this);
	}

	public abstract void agregarEnCampo(Campo campo);
	//Cada vez que la metamos en un contenedor, hay que agregar ese contenedor a this.contenedoresQueLaContienen

	public void asignarDuenio(Jugador jugador) {
		this.jugadorDuenio = jugador;
	}

	public void matar() {
		ContenedorDeCartas cementerio = this.jugadorDuenio.obtenerCementerio();
		cementerio.agregar(this);
		this.quitarDeLosContenedoresEnLosQueEstaba();
	}
	
	public void serAgregadaALaMano(Mano mano) {
		this.contenedoresQueLaContienen.add(mano);
	}

	private void quitarDeLosContenedoresEnLosQueEstaba() {
		for (ContenedorDeCartas contenedor :this.contenedoresQueLaContienen) {
			contenedor.remover(this);
		}
	}

	public abstract void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia);
}
