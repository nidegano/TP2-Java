package cartas;

import estado.ModoInactivo;

public class InsectoComeHombres extends CartaMonstruo {

	public InsectoComeHombres() {
		this.puntosDeAtaque = 450;
		this.puntosDeDefensa = 600;
		this.nivel = 2;
		this.estado = new ModoInactivo();
	}
	
	public void atacado(int puntosDeAtaque) {
		int cantidad = 0;
		if(puntosDeAtaque > this.puntosDeAtaque) {
			cantidad = puntosDeAtaque - this.puntosDeAtaque;
			this.duenioDeLaCarta.reducirVida(cantidad);
			this.duenioDeLaCarta.mandarAlCementerio(this);
		}
		
		
	}
}
