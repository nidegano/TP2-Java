package juego;


public class FaseTrampas implements Fase {


		@Override
		public String nombre() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void ejecutar(Jugador jugador) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean termino() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Fase faseSiguiente() {
			return new FaseFinalTurno();
		}

		@Override
		public boolean puedeTomarCarta() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void tomoCartaDelMazo() {
			// TODO Auto-generated method stub

		}

		@Override
		public void finalizar() {
			// TODO Auto-generated method stub

		}

}
