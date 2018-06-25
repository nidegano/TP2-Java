package efectos;


import cartas.Carta;

public class EfectoReinforcements extends EfectoEspeciales {

	public EfectoReinforcements(Carta cartaDueña) {
		super(cartaDueña);
	}

	@Override
	public void activar() {
		this.monstruoPropioObjetivo.aumentarPuntosDeAtaqueEn(500);
		this.cartaDueña.matar();
	}

}
