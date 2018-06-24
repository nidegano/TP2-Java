package cartas;

import java.util.ArrayList;
import java.util.List;

import efectos.Efecto;
import estado.Estado;
import estado.ModoActivo;
import estado.ModoInactivo;
import juego.Campo;
import juego.ContenedorDeCartas;
import juego.Jugador;

public abstract class Carta {

	protected Jugador jugadorDueño;
	protected List<ContenedorDeCartas> contenedoresQueLaContienen;
	protected Efecto efecto;
	
	public Carta() {
		this.contenedoresQueLaContienen = new ArrayList<ContenedorDeCartas>();
	}
	
	public void asignarDueño(Jugador jugador) {
		this.jugadorDueño = jugador;
	}
	
	public abstract void agregarEnCampo(Campo campo); 
	//aca cada vez que la metamos en un contenedor hay que agregar ese contenedor a contenedoresQueLaContienen

	public void matar() {
		ContenedorDeCartas cementerio = this.jugadorDueño.obtenerCementerio();
		cementerio.agregar(this);
		this.quitarDeLosContenedoresEnLosQueEstaba();
	}
	
	private void quitarDeLosContenedoresEnLosQueEstaba() {
		
		for (ContenedorDeCartas contenedor : this.contenedoresQueLaContienen) {
			contenedor.remover(this);
		}
	}
}
