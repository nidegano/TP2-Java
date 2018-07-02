package cartas;

import java.util.ArrayList;

import java.util.List;

import efectos.Efecto;
import efectos.EfectoNulo;
import javafx.scene.image.Image;
import juego.Campo;
import juego.ContenedorDeCartas;
import juego.Jugador;
import juego.Mano;
import juego.RecolectorDePartesDeExodia;
import vista.Grilla;

public abstract class Carta {

	protected Jugador jugadorDuenio;
	protected List<ContenedorDeCartas> contenedoresQueLaContienen;
	protected Efecto efecto;
	protected String nombre;
	protected Image imagen;

	public Carta() {
		this.contenedoresQueLaContienen = new ArrayList<ContenedorDeCartas>();
		this.efecto = new EfectoNulo(this);
	}

	public abstract void agregarEnCampo(Campo campo);
	// Cada vez que la metamos en un contenedor, hay que agregar ese contenedor a
	// this.contenedoresQueLaContienen

	public abstract void serRecolectadaPorElRecolectorDePartesDeExodia(
			RecolectorDePartesDeExodia recolectorDePartesDeExodia);

	public void asignarDuenio(Jugador jugador) {
		this.jugadorDuenio = jugador;
	}
	
	public Jugador obtenerDuenio() {
		return this.jugadorDuenio;
	}

	public void matar() {
		ContenedorDeCartas cementerio = this.jugadorDuenio.obtenerCementerio();
		cementerio.agregar(this);
		this.quitarDeLosContenedoresEnLosQueEstaba();
	}

	public void serAgregadaALaMano(Mano mano) {
		this.contenedoresQueLaContienen.add(mano);
	}

	public String obtenerNombre() {
		return this.nombre;
	}

	public Image obtenerImagen() {
		return this.imagen;
	}

	private void quitarDeLosContenedoresEnLosQueEstaba() {
		for (ContenedorDeCartas contenedor : this.contenedoresQueLaContienen)
			contenedor.remover(this);
		this.removerContenedoresQueLacontienen();
	}

	private void removerContenedoresQueLacontienen() {
		this.contenedoresQueLaContienen = new ArrayList<ContenedorDeCartas>();
	}

	public abstract void provocarActualizacionDeLaGrillaSegunTipo(Grilla grilla);

	public abstract void actualizarGrillaPorinvocacionSegunCorrespondaPorElTipo(Grilla grilla);

}
