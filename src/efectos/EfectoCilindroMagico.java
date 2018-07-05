package efectos;

import cartas.Carta;


public class EfectoCilindroMagico extends EfectoEspeciales {

	public EfectoCilindroMagico(Carta cartaDuenia) {
		super(cartaDuenia);
	}

	@Override
	public void activar(){
		int danioQueIvaACausarElMonstruoAtacante = this.monstruoEnemigoObjetivo.obtenerPuntosDeAtaque();
		this.jugadorOponente.debilitar(danioQueIvaACausarElMonstruoAtacante);
		this.cartaDuenia.matar();
		this.interrumpirAtaque();
	}

}
