package cartas;

import java.util.ArrayList;

import configuraciones.ConfiguracionDeOpciones;
import estados.EstadoMonstruoRequiereSacrificioSinInvocar;
import excepciones.CantidadInadecuadaDeSacrificiosException;

public abstract class CartaRequiereSacrificios extends CartaMonstruo {

	protected int sacrificiosRequeridos;
	
	public CartaRequiereSacrificios() {
		super();
		this.estado = new EstadoMonstruoRequiereSacrificioSinInvocar();
	}

	protected void chequearQueLaCantidadDeSacrificiosSeaCorrecta(ArrayList<CartaMonstruo> sacrificios) throws CantidadInadecuadaDeSacrificiosException{
		if (sacrificios.size() != this.sacrificiosRequeridos)
			throw new CantidadInadecuadaDeSacrificiosException();
	}

	public void invocarEnModoAtaque(ArrayList<CartaMonstruo> sacrificios) throws CantidadInadecuadaDeSacrificiosException  {
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.colocarEnModoAtaque();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.efecto.activar();
		for (Carta monstruo : sacrificios)
			monstruo.matar();

	}
	
	public void invocarEnModoDefensa(ArrayList<CartaMonstruo> sacrificios) throws CantidadInadecuadaDeSacrificiosException {
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.colocarEnModoDefensa();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.efecto.activar();
		for (Carta monstruo : sacrificios)
			monstruo.matar();
	}
	
	public void invocarEnModoDefensaBocaAbajo(ArrayList<CartaMonstruo> sacrificios) throws CantidadInadecuadaDeSacrificiosException  {
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.colocarEnModoDefensaBocaAbajo();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.efecto.activar();
		for (Carta monstruo : sacrificios)
			monstruo.matar();
	}

	@Override
	public ConfiguracionDeOpciones obtenerConfiguracionDeOpcionesSegunTipoYEstado() {
		return this.estado.obtenerConfiguracionDeOpciones();
	}

}
