package cartas;

public class Puntos {

	private int valor;
	
	public Puntos(int valor) {
		this.valor = valor;
	}
	
	public void aumentar(int aumento) {
		this.valor += aumento;
	}
	
	public void disminuit(int disminucion) {
		this.valor -= disminucion;
	}
	
	public int valor() {
		return this.valor;
	}
}
