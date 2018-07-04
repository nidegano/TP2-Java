package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;


import java.util.List;

import botones.VistaCarta;
import configuraciones.ConfiguracionDeOpciones;
import efectos.Efecto;
import efectos.EfectoNulo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import juego.Campo;
import juego.ContenedorDeCartas;
import juego.Jugador;
import juego.Mano;
import juego.RecolectorDePartesDeExodia;
import vista.Vista;
import vista.VistaCampoJugadores;

public abstract class Carta {

	protected Jugador jugadorDuenio;
	protected List<ContenedorDeCartas> contenedoresQueLaContienen;
	protected Efecto efecto;
	protected String nombre;
	protected ImageView imagen;
	protected VistaCarta vistaCarta;

	public Carta() {
		this.contenedoresQueLaContienen = new ArrayList<ContenedorDeCartas>();
		this.efecto = new EfectoNulo(this);
		this.crearVistaCarta();
		//mas adelante se le asigna la vista a la VistaCarta de la carta
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
		this.vistaCarta.liberarPorMuerteDeCarta(); //tambien limpia la de la vistaCampoJugadores
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

	public ImageView obtenerImagen() {
		return this.imagen;
	}

	public VistaCarta vistaCarta() {
		return this.vistaCarta;
	}

	private void quitarDeLosContenedoresEnLosQueEstaba() {
		for (ContenedorDeCartas contenedor : this.contenedoresQueLaContienen)
			contenedor.remover(this);
		this.removerContenedoresQueLacontienen();
	}

	private void removerContenedoresQueLacontienen() {
		this.contenedoresQueLaContienen = new ArrayList<ContenedorDeCartas>();
	}

	public abstract VistaCarta obtenerLugarVacioMedianteVistaCampoJugadores(VistaCampoJugadores vistaCampoJugadores);

	public void asignarVistaCarta(VistaCarta vistaNueva) {
		this.vistaCarta = vistaNueva;
	}

	public void asignarVista(Vista vista) {
		this.vistaCarta.asignarVista(vista);
	}
	
	protected void colocarImagenEnCartaDesdeArchivoDeRuta(String ruta) {
		FileInputStream input = null;
		try {
			input = new FileInputStream(ruta);
		} catch (FileNotFoundException e) {
		}
		this.imagen = new ImageView(new Image(input));
	}

	protected void crearVistaCarta() {
		this.vistaCarta = new VistaCarta();
		this.vistaCarta.asignarCarta(this);
	}

	public abstract ConfiguracionDeOpciones obtenerConfiguracionDeOpcionesSegunTipoYEstado();

	public VistaCarta obtenerVistaCarta() {
		return this.vistaCarta;
	}

	public abstract void desasignarVistaALugarDeManoEnVistaCampoJugadores();

}
