package efectos;

import cartas.Carta;

public class EfectoCilindroMagico extends EfectoEspeciales {

	public EfectoCilindroMagico(Carta cartaDueña) {
		super(cartaDueña);
	}

	@Override
	public void activar() {		
		int dañoQueIvaACausarElMonstruoAtacante = this.monstruoEnemigoObjetivo.obtenerPuntosDeAtaque();
		this.jugadorOponente.debilitar(dañoQueIvaACausarElMonstruoAtacante);
		this.cartaDueña.matar();
		this.interrumpirAtaque();
	}
}
