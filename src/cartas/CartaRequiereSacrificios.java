package cartas;

import java.util.ArrayList;

import configuraciones.ConfiguracionDeOpciones;
import estados.EstadoMonstruoRequiereSacrificioSinInvocar;
import excepciones.CantidadInadecuadaDeSacrificiosException;

public abstract class CartaRequiereSacrificios extends CartaMonstruo {

	protected ArrayList<CartaMonstruo> sacrificios;
	protected int sacrificiosRequeridos;
	
	public CartaRequiereSacrificios() {
		super();
		this.estado = new EstadoMonstruoRequiereSacrificioSinInvocar();
	}

	protected void chequearQueLaCantidadDeSacrificiosSeaCorrecta(ArrayList<CartaMonstruo> sacrificios) {
		if (sacrificios.size() != this.sacrificiosRequeridos)
			throw new CantidadInadecuadaDeSacrificiosException();
	}
	
	@Override
	public void invocarEnModoAtaque() {
		throw new CantidadInadecuadaDeSacrificiosException();
	}
	
	@Override
	public void invocarEnModoDefensa() {
		throw new CantidadInadecuadaDeSacrificiosException();
	}
	
	@Override
	public void invocarEnModoDefensaBocaAbajo() {
		throw new CantidadInadecuadaDeSacrificiosException();
	}

	public void invocarEnModoAtaque(ArrayList<CartaMonstruo> sacrificios) {
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.sacrificios = sacrificios;
		this.colocarEnModoAtaque();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.efecto.activar();
		for (Carta monstruo : this.sacrificios)
			monstruo.matar();
	}
	
	public void invocarEnModoDefensa(ArrayList<CartaMonstruo> sacrificios) {
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.sacrificios = sacrificios;
		this.colocarEnModoDefensa();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.efecto.activar();
		for (Carta monstruo : this.sacrificios)
			monstruo.matar();
	}
	
	public void invocarEnModoDefensaBocaAbajo(ArrayList<CartaMonstruo> sacrificios) {
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.sacrificios = sacrificios;
		this.colocarEnModoDefensaBocaAbajo();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.efecto.activar();
		for (Carta monstruo : this.sacrificios)
			monstruo.matar();
	}

	@Override
	public ConfiguracionDeOpciones obtenerConfiguracionDeOpcionesSegunTipoYEstado() {
		return this.estado.obtenerConfiguracionDeOpciones();
	}

}
