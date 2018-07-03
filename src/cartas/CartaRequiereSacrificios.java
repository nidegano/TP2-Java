package cartas;

import excepciones.CantidadInadecuadaDeSacrificiosException;
import juego.ContenedorDeCartas;
import vista.Grilla;

public abstract class CartaRequiereSacrificios extends CartaMonstruo {

	protected ContenedorDeCartas sacrificios;
	protected int sacrificiosRequeridos;

	protected void chequearQueLaCantidadDeSacrificiosSeaCorrecta(ContenedorDeCartas sacrificios) {
		if (sacrificios.cantidad() != this.sacrificiosRequeridos)
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

	public void invocarEnModoAtaque(ContenedorDeCartas sacrificios) {
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.sacrificios = sacrificios;
		this.colocarEnModoAtaque();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.efecto.activar();
		for (Carta monstruo : this.sacrificios)
			monstruo.matar();
	}
	
	public void invocarEnModoDefensa(ContenedorDeCartas sacrificios) {
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.sacrificios = sacrificios;
		this.colocarEnModoDefensa();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.efecto.activar();
		for (Carta monstruo : this.sacrificios)
			monstruo.matar();
	}
	
	public void invocarEnModoDefensaBocaAbajo(ContenedorDeCartas sacrificios) {
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.sacrificios = sacrificios;
		this.colocarEnModoDefensaBocaAbajo();
		this.agregarEnCampo(this.jugadorDuenio.campo());
		this.efecto.activar();
		for (Carta monstruo : this.sacrificios)
			monstruo.matar();
	}

	@Override
	public void provocarActualizacionDeLaGrillaSegunTipo(Grilla grilla) {
		grilla.actualizarGrillaPorSeleccionDeCartaDeMano(this);
	}

}
