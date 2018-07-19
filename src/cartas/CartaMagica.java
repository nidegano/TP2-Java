package cartas;

import configuraciones.ConfiguracionDeOpciones;
import estados.EstadoColocableBocaArriba;
import estados.EstadoInvocableDesdeLaMano;
import estados.ModoBocaAbajo;
import excepciones.CapacidadMaximaException;
import excepciones.CartaNoEstaEnContenedorDeCartasException;
import juego.Campo;

public abstract class CartaMagica extends CartaEspecial {

	public CartaMagica() {
		super();
		this.estado = new EstadoInvocableDesdeLaMano();
	}

	@Override
	public void agregarEnCampo(Campo campo) {
		try {
			campo.obtenerZonaEspeciales().agregar(this);
			this.contenedoresQueLaContienen.add(campo.obtenerZonaEspeciales());
	
			campo.obtenerContenedorCartasMagicas().agregar(this);
			this.contenedoresQueLaContienen.add(campo.obtenerContenedorCartasMagicas());
	
			this.contenedoresQueLaContienen.remove(this.jugadorDuenio.obtenerMano());
			this.jugadorDuenio.obtenerMano().remover(this);
		}
		catch (CapacidadMaximaException | CartaNoEstaEnContenedorDeCartasException e) {
			// e.printStackTrace();
			
		}
	}

	public void asignarEstadoDeColocableBocaArriba() {
		this.estado = new EstadoColocableBocaArriba();
	}
	
	public void asignarEstadoDeBocaAbajo() {
		this.estado = new ModoBocaAbajo();
	}
	
	@Override
	public ConfiguracionDeOpciones obtenerConfiguracionDeOpcionesSegunTipoYEstado() {
		return this.estado.obtenerConfiguracionDeOpciones();
	}
}
