package cartas;

import juego.Campo;

public abstract class CartaDeCampo extends CartaEspecial {

	@Override
	public void agregarEnCampo(Campo campo) {
		
		this.agregarSiempreYCuandoNoHayaUnaCartaDeCampoYa(campo);
	}

	private void agregarSiempreYCuandoNoHayaUnaCartaDeCampoYa(Campo campo){
		
		if (!campo.obtenerZonaCartasDeCampo().hayCartas()) {
			campo.obtenerZonaCartasDeCampo().agregar(this);
			this.contenedoresQueLaContienen.add(campo.obtenerZonaCartasDeCampo());
			this.contenedoresQueLaContienen.remove(this.jugadorDuenio.obtenerMano());
			this.jugadorDuenio.obtenerMano().remover(this);
		}
		//de lo contrario se ignora la peticion de agregarla a la zona de cartas de campo
	}
}
