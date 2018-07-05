package opciones;

import cartas.CartaDeCampo;
import excepciones.YaHayUnaCartaDeCampoColocadaException;
import vista.Vista;

public class ColocarCartaDeCampo extends Opcion {

	public ColocarCartaDeCampo(Vista vista) {
		super(vista);
		this.setText("colocar carta de campo");
		
		this.setOnAction(value -> {
			
			CartaDeCampo cartaSeleccionada = (CartaDeCampo) this.vista.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(CartaDeCampo cartaSeleccionada) {
		try {
			cartaSeleccionada.chequearQueNoHayaCartaDeCampoColocada();
			cartaSeleccionada.desasignarSuVistaCartaDelLugarDeManoEnVistaCampoJugadoresEnElQueEstaba();
			cartaSeleccionada.vistaCarta().agregarAVistaCampoJugadores();
			cartaSeleccionada.colocarCartaDeCampo();
		}
		catch (YaHayUnaCartaDeCampoColocadaException e) {
			e.printStackTrace();
		}

	}
}
