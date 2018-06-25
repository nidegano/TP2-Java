package cartas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import efectos.Efecto;
import efectos.EfectoNulo;
import juego.Campo;
import juego.ContenedorDeCartas;
import juego.Jugador;

public abstract class Carta {

	protected Jugador jugadorDuenio;
	protected List<ContenedorDeCartas> contenedoresQueLaContienen;
	protected Efecto efecto;

	public Carta() {
		this.contenedoresQueLaContienen = new ArrayList<ContenedorDeCartas>();
		this.efecto = new EfectoNulo();
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

	private void quitarDeLosContenedoresEnLosQueEstaba() {
		Iterator<ContenedorDeCartas> iterator = this.contenedoresQueLaContienen.iterator();
		while (iterator.hasNext()) {
			ContenedorDeCartas contenedor = iterator.next();
			contenedor.remover(this);
		}	
	}

}
