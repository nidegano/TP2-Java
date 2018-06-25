package efectos;

import cartas.Carta;
import cartas.CartaMonstruo;
import juego.ContenedorDeCartas;

public class EfectoDeCampo extends Efecto {

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

}
