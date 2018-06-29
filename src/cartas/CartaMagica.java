package cartas;

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

}
