package opciones;

import java.util.ArrayList;

import cartas.Carta;
import cartas.CartaMonstruo;
import v.Vista;

public abstract class InvocarConSacrificio extends Opcion {

	public InvocarConSacrificio(Vista vista) {
		super(vista);
	}

	public abstract void finalizarInvocacionPorSacrificio(Carta cartaSeleccionada, ArrayList<CartaMonstruo> seleccionesSecundarias);
}