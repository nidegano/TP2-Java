package opcionesQueAlteranAlControladorVisual;

import java.util.ArrayList;

import cartas.Carta;
import cartas.CartaMonstruo;
import opcionesQueAlteranALaCarta.Opcion;
import vista.ControladorVisual;

public abstract class InvocarConSacrificio extends Opcion {

	public InvocarConSacrificio(ControladorVisual vista) {
		super(vista);
	}

	public abstract void finalizarInvocacionPorSacrificio(Carta cartaSeleccionada, ArrayList<CartaMonstruo> sacrificios);

}
