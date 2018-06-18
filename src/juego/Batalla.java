package juego;

import cartas.CartaMonstruo;

import excepciones.LaCartaPasadaNoPerteneceANingunJugadorException;
import excepciones.MonstruoAtacanteNoEstabaEnModoAtaqueException;

public class Batalla {

	private Jugador jugador1;
	private Jugador jugador2;
	private FormaDeAfectarAlJugador formaDeAfectar;

	public Batalla(Jugador unJugadorAtacante, Jugador unJugadorAtacado) {
		this.jugador1 = unJugadorAtacante;
		this.jugador2 = unJugadorAtacado;
		this.formaDeAfectar = new NoRestar();
	}
	
	public void librarBatalla(CartaMonstruo monstruoAtacante, CartaMonstruo monstruoAtacado) {
		
		this.chequearQueElMonstruoAtacanteEsteEnModoAtacar(monstruoAtacante);
		
		Jugador jugadorAtacante = this.determinarElDuenioDeLaCarta(monstruoAtacante);
		Jugador jugadorDefensor = this.determinarElDuenioDeLaCarta(monstruoAtacado);
		
		this.formaDeAfectar = this.determinarLaFormaDeAfectarAlJugador(monstruoAtacante,monstruoAtacado);
		
		int diferencia = this.determinarDiferenciaDePuntosDeAtaqueODefensaEntreLosMonstruos(monstruoAtacante,monstruoAtacado);
		
		if (diferencia>0) {
			this.afectar(jugadorDefensor,diferencia);
			monstruoAtacado.matar();
		}
		else if (diferencia<0){
			this.afectar(jugadorAtacante,-diferencia); 
										   //notar que en este caso mato al atacante incluso si el atacado estaba
			monstruoAtacante.matar();	   //en modo defensa. Esto no contradice las especificaciones y seria un supuesto
		}								   //nuestro a  anotar.
		else {
			monstruoAtacado.matar(); 	   //aca tambien mueren los dos incluso si el atacado estaba en modo defensa.
			monstruoAtacante.matar();	   //de nuevo, esto no contradice las especificaciones y seria un supuesto.
		}
	}

	private FormaDeAfectarAlJugador determinarLaFormaDeAfectarAlJugador(CartaMonstruo monstruoAtacante,
			CartaMonstruo monstruoAtacado) {	
			
		return monstruoAtacante.enfrentarCon(monstruoAtacado);
	}

	private void afectar(Jugador jugador, int diferencia) {
		
		this.formaDeAfectar.afectar(jugador,diferencia);
	}

	private Jugador determinarElDuenioDeLaCarta(CartaMonstruo cartaMonstruo) {
		if (this.jugador1.esDuenioDe(cartaMonstruo))
			return this.jugador1;
		if (this.jugador2.esDuenioDe(cartaMonstruo))
			return this.jugador2;
		else
			throw new LaCartaPasadaNoPerteneceANingunJugadorException();
	}

	private int determinarDiferenciaDePuntosDeAtaqueODefensaEntreLosMonstruos(CartaMonstruo atacante,
			CartaMonstruo atacado) {
		
		return atacante.puntosAUtilizarSegunEstado() - atacado.puntosAUtilizarSegunEstado();
	}
	
	private void chequearQueElMonstruoAtacanteEsteEnModoAtacar(CartaMonstruo monstruoAtacante) {
	
		if (!monstruoAtacante.estaEnModoAtaque()) {
			throw new MonstruoAtacanteNoEstabaEnModoAtaqueException();
		}
	}
}
