package cartas;

import configuraciones.ConfiguracionDeOpciones;
import estado.EstadoColocableBocaArriba;
import estado.ModoBocaAbajo;
import juego.Campo;

public abstract class CartaMagica extends CartaEspecial {

	public CartaMagica() {
		super();
	}

	@Override
	public void agregarEnCampo(Campo campo) {
		campo.obtenerZonaEspeciales().agregar(this);
		this.contenedoresQueLaContienen.add(campo.obtenerZonaEspeciales());

		campo.obtenerContenedorCartasMagicas().agregar(this);
		this.contenedoresQueLaContienen.add(campo.obtenerContenedorCartasMagicas());

		this.contenedoresQueLaContienen.remove(this.jugadorDuenio.obtenerMano());
		this.jugadorDuenio.obtenerMano().remover(this);
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
