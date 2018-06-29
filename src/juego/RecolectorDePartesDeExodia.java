package juego;

import java.util.ArrayList;
import java.util.List;

import cartas.BrazoDerechoExodia;
import cartas.BrazoIzquierdoExodia;
import cartas.CabezaExodia;
import cartas.Carta;
import cartas.PiernaDerechaExodia;
import cartas.PiernaIzquierdaExodia;
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

	public void siEsUnaParteDelExodiaQueNoTeniaRecolectar(Carta carta) {
		carta.serRecolectadaPorElRecolectorDePartesDeExodia(this);
	}

	public void recolectarBrazoIzquierdo(BrazoIzquierdoExodia brazoIzquierdoExodia) {
		if (!this.lugarParaElBrazoIzquierdo.hayCartas())
			this.lugarParaElBrazoIzquierdo.agregar(brazoIzquierdoExodia);

		if (this.tengoTodasLasPartesDeExodia())
			throw new TengoTodasLasPartesDeExodiaException();
	}

	public void recolectarBrazoDerecho(BrazoDerechoExodia brazoDerechoExodia) {
		if (!this.lugarParaElBrazoDerecho.hayCartas())
			this.lugarParaElBrazoDerecho.agregar(brazoDerechoExodia);

		if (this.tengoTodasLasPartesDeExodia())
			throw new TengoTodasLasPartesDeExodiaException();
	}

	public void recolectarPiernaDerecha(PiernaDerechaExodia piernaDerechaExodia) {
		if (!this.lugarParaLaPiernaDerecha.hayCartas())
			this.lugarParaLaPiernaDerecha.agregar(piernaDerechaExodia);

		if (this.tengoTodasLasPartesDeExodia())
			throw new TengoTodasLasPartesDeExodiaException();
	}

	public void recolectarPiernaIzquierda(PiernaIzquierdaExodia piernaIzquierdaExodia) {
		if (!this.lugarParaLaPiernaIzquierda.hayCartas())
			this.lugarParaLaPiernaIzquierda.agregar(piernaIzquierdaExodia);

		if (this.tengoTodasLasPartesDeExodia())
			throw new TengoTodasLasPartesDeExodiaException();
	}

	public void recolectarCabeza(CabezaExodia cabezaExodia) {
		if (!this.lugarParaLaCabeza.hayCartas())
			this.lugarParaLaCabeza.agregar(cabezaExodia);

		if (this.tengoTodasLasPartesDeExodia())
			throw new TengoTodasLasPartesDeExodiaException();
	}

	private boolean tengoTodasLasPartesDeExodia() {
		return this.lugarParaLaCabeza.hayCartas() &&
				this.lugarParaElBrazoDerecho.hayCartas() &&
				this.lugarParaElBrazoIzquierdo.hayCartas() &&
				this.lugarParaLaPiernaDerecha.hayCartas() &&
				this.lugarParaLaPiernaIzquierda.hayCartas();
	}

	public void remover(Carta carta) {
		for (ContenedorDeCartas lugar : this.lugares) {
			if (lugar.estaDentro(carta))
				lugar.remover(carta);
		}
	}

}
