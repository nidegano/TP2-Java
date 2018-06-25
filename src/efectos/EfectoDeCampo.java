package efectos;

import cartas.Carta;
import cartas.CartaMonstruo;
import estado.Estado;
import juego.ContenedorDeCartas;

public class EfectoDeCampo extends Efecto {

	public EfectoDeCampo(Carta cartaDueña) {
		super(cartaDueña);
	}

	protected int aumentoDePuntosDeAtaque;
	protected int aumentoDePuntosDeDefensa;

	@Override
	public void activar() {
		ContenedorDeCartas zonaMonstruosDuenio = this.jugadorDuenio.campo().obtenerZonaMonstruos();
		ContenedorDeCartas zonaMonstruosOponente = this.jugadorOponente.campo().obtenerZonaMonstruos();

		for (Carta monstruo : zonaMonstruosDuenio)
			((CartaMonstruo) monstruo).aumentarPuntosDeAtaqueEn(aumentoDePuntosDeAtaque);

		for (Carta monstruo : zonaMonstruosOponente)
			((CartaMonstruo) monstruo).aumentarPuntosDeDefensaEn(aumentoDePuntosDeDefensa);
	}

	@Override
	public void serActivadoPor(Estado estadoDeLaCarta) {
		estadoDeLaCarta.activar(this);		
	}

}
