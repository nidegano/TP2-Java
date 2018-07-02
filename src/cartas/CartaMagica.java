package cartas;

import juego.Campo;
import vista.Grilla;

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

	@Override
	public void provocarActualizacionDeLaGrillaSegunTipo(Grilla grilla) {
		grilla.actualizarGrillaPorSeleccionDeCartaDeMano(this);
	}

	@Override
	public void actualizarGrillaPorinvocacionSegunCorrespondaPorElTipo(Grilla grilla) {
		grilla.actualizarPorInvocacionDeUnaCartaEspecial(this);
	}
}
