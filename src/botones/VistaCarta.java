package botones;

import cartas.Carta;
import vista.ControladorVisual;

public interface VistaCarta {

	
	public void asignarCarta(Carta carta);
	
	public void vaciar();

	public void agregarAVistaCampoJugadores();
	
	public void agregarALaZonaDeLaManoDelJugadorCorrespondiente();
	
	public boolean estaLibre();

	public void reemplazarPor(VistaCarta vistaCarta);
	
	public void desvincular();

	public void deshabilitar();

	public ControladorVisual vista();

	public Carta carta();
}
