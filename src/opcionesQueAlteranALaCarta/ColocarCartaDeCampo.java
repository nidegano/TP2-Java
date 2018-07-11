package opcionesQueAlteranALaCarta;

import cartas.CartaDeCampo;
import excepciones.YaHayUnaCartaDeCampoColocadaException;
import vista.ControladorVisual;

public class ColocarCartaDeCampo extends Opcion {

	public ColocarCartaDeCampo(ControladorVisual vista) {
		super(vista);
		this.setText("colocar carta de campo");
		
		this.setOnAction(value -> {
			
			CartaDeCampo cartaSeleccionada = (CartaDeCampo) this.controladorVisual.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
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
