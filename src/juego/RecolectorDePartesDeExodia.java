package juego;

import java.util.ArrayList;
import java.util.List;

import cartas.BrazoDerechoExodia;
import cartas.BrazoIzquierdoExodia;
import cartas.CabezaExodia;
import cartas.Carta;
import cartas.PiernaDerechaExodia;
import cartas.PiernaIzquierdaExodia;
import excepciones.CapacidadMaximaException;
import excepciones.CartaNoEstaEnContenedorDeCartasException;
import excepciones.TengoTodasLasPartesDeExodiaException;

public class RecolectorDePartesDeExodia {

	private ContenedorDeCartas lugarParaLaCabeza;
	private ContenedorDeCartas lugarParaElBrazoIzquierdo;
	private ContenedorDeCartas lugarParaElBrazoDerecho;
	private ContenedorDeCartas lugarParaLaPiernaIzquierda;
	private ContenedorDeCartas lugarParaLaPiernaDerecha;
	private List<ContenedorDeCartas> lugares;

	public RecolectorDePartesDeExodia() {
		this.lugarParaLaCabeza = new ContenedorDeCartas(1);
		this.lugarParaElBrazoIzquierdo = new ContenedorDeCartas(1);
		this.lugarParaElBrazoDerecho = new ContenedorDeCartas(1);
		this.lugarParaLaPiernaIzquierda = new ContenedorDeCartas(1);
		this.lugarParaLaPiernaDerecha = new ContenedorDeCartas(1);
		this.lugares = new ArrayList<ContenedorDeCartas>();

		lugares.add(this.lugarParaLaCabeza);
		lugares.add(this.lugarParaElBrazoDerecho);
		lugares.add(this.lugarParaElBrazoIzquierdo);
		lugares.add(this.lugarParaLaPiernaDerecha);
		lugares.add(this.lugarParaLaPiernaIzquierda);
	}

	public void siEsUnaParteDelExodiaQueNoTeniaRecolectar(Carta carta) throws TengoTodasLasPartesDeExodiaException {
		carta.serRecolectadaPorElRecolectorDePartesDeExodia(this);
	}

	public void recolectarBrazoIzquierdo(BrazoIzquierdoExodia brazoIzquierdoExodia) throws TengoTodasLasPartesDeExodiaException {
		if (!this.lugarParaElBrazoIzquierdo.hayCartas())
			try {
				this.lugarParaElBrazoIzquierdo.agregar(brazoIzquierdoExodia);
			} catch (CapacidadMaximaException e) {
				// e.printStackTrace();
			}

		if (this.tengoTodasLasPartesDeExodia())
			throw new TengoTodasLasPartesDeExodiaException();
	}

	public void recolectarBrazoDerecho(BrazoDerechoExodia brazoDerechoExodia) throws TengoTodasLasPartesDeExodiaException {
		if (!this.lugarParaElBrazoDerecho.hayCartas())
			try {
				this.lugarParaElBrazoDerecho.agregar(brazoDerechoExodia);
			} catch (CapacidadMaximaException e) {
				// e.printStackTrace();
			}

		if (this.tengoTodasLasPartesDeExodia())
			throw new TengoTodasLasPartesDeExodiaException();
	}

	public void recolectarPiernaDerecha(PiernaDerechaExodia piernaDerechaExodia) throws TengoTodasLasPartesDeExodiaException {
		if (!this.lugarParaLaPiernaDerecha.hayCartas())
			try {
				this.lugarParaLaPiernaDerecha.agregar(piernaDerechaExodia);
			} catch (CapacidadMaximaException e) {
				// e.printStackTrace();
			}

		if (this.tengoTodasLasPartesDeExodia())
			throw new TengoTodasLasPartesDeExodiaException();
	}

	public void recolectarPiernaIzquierda(PiernaIzquierdaExodia piernaIzquierdaExodia) throws TengoTodasLasPartesDeExodiaException {
		if (!this.lugarParaLaPiernaIzquierda.hayCartas())
			try {
				this.lugarParaLaPiernaIzquierda.agregar(piernaIzquierdaExodia);
			} catch (CapacidadMaximaException e) {
				// e.printStackTrace();
			}

		if (this.tengoTodasLasPartesDeExodia())
			throw new TengoTodasLasPartesDeExodiaException();
	}

	public void recolectarCabeza(CabezaExodia cabezaExodia) throws TengoTodasLasPartesDeExodiaException {
		if (!this.lugarParaLaCabeza.hayCartas())
			try {
				this.lugarParaLaCabeza.agregar(cabezaExodia);
			} catch (CapacidadMaximaException e) {
				// e.printStackTrace();
			}

		if (this.tengoTodasLasPartesDeExodia())
			throw new TengoTodasLasPartesDeExodiaException();
	}

	private boolean tengoTodasLasPartesDeExodia() {
		return this.lugarParaLaCabeza.hayCartas() && this.lugarParaElBrazoDerecho.hayCartas()
				&& this.lugarParaElBrazoIzquierdo.hayCartas() && this.lugarParaLaPiernaDerecha.hayCartas()
				&& this.lugarParaLaPiernaIzquierda.hayCartas();
	}

	public void remover(Carta carta) {
		for (ContenedorDeCartas lugar : this.lugares) {
			if (lugar.estaDentro(carta))
				try {
					lugar.remover(carta);
				} catch (CartaNoEstaEnContenedorDeCartasException e) {
					// e.printStackTrace();
				}
		}
	}

}
