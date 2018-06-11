package cartas;

import estado.ModoInactivo;

public class DragonBlancoDeOjosAzules extends CartaMonstruo {

	public DragonBlancoDeOjosAzules() {
		this.puntosDeAtaque = 3000;
		this.puntosDeDefensa = 2500;
		this.nivel = 8;
		this.estado = new ModoInactivo();
	}
	
	public void atacar(CartaMonstruo otroMonstruo) {
		//otroMonstruo compara estos puntos con su ATK y se manda al cementerio de ser necesario
		//O le saca vida a su dueño
		otroMonstruo.atacado(this.puntosDeAtaque);
	}
}
