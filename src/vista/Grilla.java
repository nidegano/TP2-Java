package vista;

import java.io.FileInputStream;
import java.util.ArrayList;

import cartas.Carta;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import juego.*;

public class Grilla extends Application {

	private Jugador jugador1;
	private Jugador jugador2;
	private Juego juego;
	private GridPane gridPane;
	private ImageView imageView;
	private HBox hbox;
	private Label labelJugador1;
	private Label labelJugador2;
	private Label labelTurno;
	private Label labelFase;
	private ArrayList<BotonMano> botonesManoJugador1;
	private ArrayList<BotonMano> botonesManoJugador2;
	private ArrayList<BotonCartaEspecial> botonesCartasEspecialesJugador1;
	private ArrayList<BotonCartaEspecial> botonesCartasEspecialesJugador2;
	private ArrayList<BotonCartaMonstruo> botonesCartasMonstruosJugador1;
	private ArrayList<BotonCartaMonstruo> botonesCartasMonstruosJugador2;
	private BotonMazo botonMazoJugador1;
	private BotonMazo botonMazoJugador2;
	private BotonCementerio botonCementerioJugador1;
	private BotonCementerio botonCementerioJugador2;
	private BotonCampo botonCampoJugador1;
	private BotonCampo botonCampoJugador2;
	private BotonInvocar botonInvocar;
	private BotonSacrificar botonSacrificar;
	private BotonAtacar botonAtacar;
	private BotonCambioModoAtaque botonCambioModoAtaque;
	private BotonCambioModoDefensa botonCambioModoDefensa;
	private BotonFinalizarFase botonFinalizarFase;
	
	private BotonInvocarEnModoAtaque botonInvocarEnModoAtaque;
	private BotonInvocarEnModoDefensa botonInvocarEnModoDefensa;
	private BotonInvocarEnModoDefensaBocaAbajo botonInvocarEnModoDefensaBocaAbajo;
	private BotonColocarBocaAbajo botonColocarBocaAbajo;
	private BotonColocarBocaArriba botonColocarBocaArriba;
	private BotonColocarCartaDeCampo botonColocarCartaDeCampo;

	public Grilla(Jugador jugador1, Jugador jugador2, Juego juego) throws Exception {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;

		this.juego = juego;

		this.gridPane = new GridPane();
		this.gridPane.setHgap(10);
		this.gridPane.setVgap(10);
		this.gridPane.setAlignment(Pos.CENTER);

		FileInputStream input = new FileInputStream("resources/images/carta_dorso.png");
		Image image = new Image(input);
		this.imageView = new ImageView(image);
		this.hbox = new HBox(this.imageView);

		this.labelJugador1 = new Label("JUGADOR 1");
		this.labelJugador2 = new Label("JUGADOR 2");

		this.labelTurno = new Label("");
		this.labelFase = new Label("");

		this.botonesManoJugador1 = new ArrayList<BotonMano>();
		BotonMano botonMano1Jugador1 = new BotonMano(this.imageView);
		BotonMano botonMano2Jugador1 = new BotonMano(this.imageView);
		BotonMano botonMano3Jugador1 = new BotonMano(this.imageView);
		BotonMano botonMano4Jugador1 = new BotonMano(this.imageView);
		BotonMano botonMano5Jugador1 = new BotonMano(this.imageView);
		BotonMano botonMano6Jugador1 = new BotonMano(this.imageView);
		BotonMano botonMano7Jugador1 = new BotonMano(this.imageView);
		this.botonesManoJugador1.add(botonMano1Jugador1);
		this.botonesManoJugador1.add(botonMano2Jugador1);
		this.botonesManoJugador1.add(botonMano3Jugador1);
		this.botonesManoJugador1.add(botonMano4Jugador1);
		this.botonesManoJugador1.add(botonMano5Jugador1);
		this.botonesManoJugador1.add(botonMano6Jugador1);
		this.botonesManoJugador1.add(botonMano7Jugador1);

		this.botonesManoJugador2 = new ArrayList<BotonMano>();
		BotonMano botonMano1Jugador2 = new BotonMano(this.imageView);
		BotonMano botonMano2Jugador2 = new BotonMano(this.imageView);
		BotonMano botonMano3Jugador2 = new BotonMano(this.imageView);
		BotonMano botonMano4Jugador2 = new BotonMano(this.imageView);
		BotonMano botonMano5Jugador2 = new BotonMano(this.imageView);
		BotonMano botonMano6Jugador2 = new BotonMano(this.imageView);
		BotonMano botonMano7Jugador2 = new BotonMano(this.imageView);
		this.botonesManoJugador2.add(botonMano1Jugador2);
		this.botonesManoJugador2.add(botonMano2Jugador2);
		this.botonesManoJugador2.add(botonMano3Jugador2);
		this.botonesManoJugador2.add(botonMano4Jugador2);
		this.botonesManoJugador2.add(botonMano5Jugador2);
		this.botonesManoJugador2.add(botonMano6Jugador2);
		this.botonesManoJugador2.add(botonMano7Jugador2);

		this.botonesCartasEspecialesJugador1 = new ArrayList<BotonCartaEspecial>();
		BotonCartaEspecial botonCartaEspecial1Jugador1 = new BotonCartaEspecial("Especial 1", this.imageView);
		BotonCartaEspecial botonCartaEspecial2Jugador1 = new BotonCartaEspecial("Especial 2", this.imageView);
		BotonCartaEspecial botonCartaEspecial3Jugador1 = new BotonCartaEspecial("Especial 3", this.imageView);
		BotonCartaEspecial botonCartaEspecial4Jugador1 = new BotonCartaEspecial("Especial 4", this.imageView);
		BotonCartaEspecial botonCartaEspecial5Jugador1 = new BotonCartaEspecial("Especial 5", this.imageView);
		this.botonesCartasEspecialesJugador1.add(botonCartaEspecial1Jugador1);
		this.botonesCartasEspecialesJugador1.add(botonCartaEspecial2Jugador1);
		this.botonesCartasEspecialesJugador1.add(botonCartaEspecial3Jugador1);
		this.botonesCartasEspecialesJugador1.add(botonCartaEspecial4Jugador1);
		this.botonesCartasEspecialesJugador1.add(botonCartaEspecial5Jugador1);

		this.botonesCartasEspecialesJugador2 = new ArrayList<BotonCartaEspecial>();
		BotonCartaEspecial botonCartaEspecial1Jugador2 = new BotonCartaEspecial("Especial 1", this.imageView);
		BotonCartaEspecial botonCartaEspecial2Jugador2 = new BotonCartaEspecial("Especial 2", this.imageView);
		BotonCartaEspecial botonCartaEspecial3Jugador2 = new BotonCartaEspecial("Especial 3", this.imageView);
		BotonCartaEspecial botonCartaEspecial4Jugador2 = new BotonCartaEspecial("Especial 4", this.imageView);
		BotonCartaEspecial botonCartaEspecial5Jugador2 = new BotonCartaEspecial("Especial 5", this.imageView);
		this.botonesCartasEspecialesJugador2.add(botonCartaEspecial1Jugador2);
		this.botonesCartasEspecialesJugador2.add(botonCartaEspecial2Jugador2);
		this.botonesCartasEspecialesJugador2.add(botonCartaEspecial3Jugador2);
		this.botonesCartasEspecialesJugador2.add(botonCartaEspecial4Jugador2);
		this.botonesCartasEspecialesJugador2.add(botonCartaEspecial5Jugador2);

		this.botonesCartasMonstruosJugador1 = new ArrayList<BotonCartaMonstruo>();
		BotonCartaMonstruo botonCartaMonstruo1Jugador1 = new BotonCartaMonstruo("Monstruo 1", this.imageView);
		BotonCartaMonstruo botonCartaMonstruo2Jugador1 = new BotonCartaMonstruo("Monstruo 2", this.imageView);
		BotonCartaMonstruo botonCartaMonstruo3Jugador1 = new BotonCartaMonstruo("Monstruo 3", this.imageView);
		BotonCartaMonstruo botonCartaMonstruo4Jugador1 = new BotonCartaMonstruo("Monstruo 4", this.imageView);
		BotonCartaMonstruo botonCartaMonstruo5Jugador1 = new BotonCartaMonstruo("Monstruo 5", this.imageView);
		this.botonesCartasMonstruosJugador1.add(botonCartaMonstruo1Jugador1);
		this.botonesCartasMonstruosJugador1.add(botonCartaMonstruo2Jugador1);
		this.botonesCartasMonstruosJugador1.add(botonCartaMonstruo3Jugador1);
		this.botonesCartasMonstruosJugador1.add(botonCartaMonstruo4Jugador1);
		this.botonesCartasMonstruosJugador1.add(botonCartaMonstruo5Jugador1);

		this.botonesCartasMonstruosJugador2 = new ArrayList<BotonCartaMonstruo>();
		BotonCartaMonstruo botonCartaMonstruo1Jugador2 = new BotonCartaMonstruo("Monstruo 1", this.imageView);
		BotonCartaMonstruo botonCartaMonstruo2Jugador2 = new BotonCartaMonstruo("Monstruo 2", this.imageView);
		BotonCartaMonstruo botonCartaMonstruo3Jugador2 = new BotonCartaMonstruo("Monstruo 3", this.imageView);
		BotonCartaMonstruo botonCartaMonstruo4Jugador2 = new BotonCartaMonstruo("Monstruo 4", this.imageView);
		BotonCartaMonstruo botonCartaMonstruo5Jugador2 = new BotonCartaMonstruo("Monstruo 5", this.imageView);
		this.botonesCartasMonstruosJugador2.add(botonCartaMonstruo1Jugador2);
		this.botonesCartasMonstruosJugador2.add(botonCartaMonstruo2Jugador2);
		this.botonesCartasMonstruosJugador2.add(botonCartaMonstruo3Jugador2);
		this.botonesCartasMonstruosJugador2.add(botonCartaMonstruo4Jugador2);
		this.botonesCartasMonstruosJugador2.add(botonCartaMonstruo5Jugador2);

		this.botonMazoJugador1 = new BotonMazo(jugador1, this);
		this.botonMazoJugador2 = new BotonMazo(jugador2, this);

		this.botonCementerioJugador1 = new BotonCementerio();
		this.botonCementerioJugador2 = new BotonCementerio();

		this.botonCampoJugador1 = new BotonCampo(this.imageView);
		this.botonCampoJugador2 = new BotonCampo(this.imageView);

		this.botonFinalizarFase = new BotonFinalizarFase(this.juego, this);
		this.botonInvocar = new BotonInvocar();
		this.botonSacrificar = new BotonSacrificar();
		this.botonAtacar = new BotonAtacar();
		this.botonCambioModoAtaque = new BotonCambioModoAtaque();
		this.botonCambioModoDefensa = new BotonCambioModoDefensa();
		
		this.botonInvocarEnModoAtaque = new BotonInvocarEnModoAtaque();
		this.botonInvocarEnModoDefensa = new BotonInvocarEnModoDefensa();
		this.botonInvocarEnModoDefensaBocaAbajo = new BotonInvocarEnModoDefensaBocaAbajo();
		this.botonColocarBocaAbajo = new BotonColocarBocaAbajo();
		this.botonColocarBocaArriba = new BotonColocarBocaArriba();
		this.botonColocarCartaDeCampo = new BotonColocarCartaDeCampo();

		this.agregarBotonesALaGrilla();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Al-Go-Oh!");

		this.asignarMano();

		Scene scene = new Scene(this.gridPane, 1200, 1200);
		// primaryStage.setFullScreen(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void agregarBotonesALaGrilla() {
		// JUGADOR 1
		this.gridPane.add(this.botonMazoJugador1, 1, 1, 1, 1);
		this.gridPane.add(this.botonCementerioJugador1, 1, 5, 1, 1);
		this.gridPane.add(this.botonCampoJugador1, 9, 5, 1, 1);

		int i = 2;
		for (BotonMano unBoton : this.botonesManoJugador1) {
			this.gridPane.add(unBoton, i, 2, 1, 1);
			i++;
		}

		i = 3;
		for (BotonCartaEspecial unBoton : this.botonesCartasEspecialesJugador1) {
			this.gridPane.add(unBoton, i, 3, 1, 1);
			i++;
		}

		i = 3;
		for (BotonCartaMonstruo unBoton : this.botonesCartasMonstruosJugador1) {
			this.gridPane.add(unBoton, i, 4, 1, 1);
			i++;
		}

		// JUGADOR 2
		this.gridPane.add(this.botonMazoJugador2, 9, 11, 1, 1);
		this.gridPane.add(this.botonCementerioJugador2, 9, 7, 1, 1);
		this.gridPane.add(this.botonCampoJugador2, 1, 7, 1, 1);

		i = 2;
		for (BotonMano unBoton : this.botonesManoJugador2) {
			this.gridPane.add(unBoton, i, 10, 1, 1);
			i++;
		}

		i = 3;
		for (BotonCartaEspecial unBoton : this.botonesCartasEspecialesJugador2) {
			this.gridPane.add(unBoton, i, 9, 1, 1);
			i++;
		}

		i = 3;
		for (BotonCartaMonstruo unBoton : this.botonesCartasMonstruosJugador2) {
			this.gridPane.add(unBoton, i, 8, 1, 1);
			i++;
		}

		// PANEL DE ACCION
		this.gridPane.add(this.labelJugador1, 0, 0, 1, 1);
		this.gridPane.add(this.labelJugador2, 0, 12, 1, 1);
		this.gridPane.add(this.labelTurno, 13, 3, 1, 1);
		this.gridPane.add(this.labelFase, 13, 4, 1, 1);

		this.gridPane.add(this.hbox, 13, 6, 1, 1);

		this.gridPane.add(this.botonFinalizarFase, 13, 5, 1, 1);

		//this.gridPane.add(this.botonInvocar, 13, 7, 1, 1);
		//this.gridPane.add(this.botonSacrificar, 13, 8, 1, 1);
		
		this.gridPane.add(this.botonInvocarEnModoAtaque, 13, 7, 1, 1);
		this.gridPane.add(this.botonCambioModoDefensa, 13, 8, 1, 1);
		this.gridPane.add(this.botonInvocarEnModoDefensaBocaAbajo, 13, 9, 1, 1);
		
		this.gridPane.add(this.botonColocarBocaAbajo, 13, 7, 1, 1);
		this.gridPane.add(this.botonColocarBocaArriba, 13, 8, 1, 1);
		
		this.gridPane.add(this.botonColocarCartaDeCampo, 13, 7, 1, 1);

		this.gridPane.add(this.botonAtacar, 13, 7, 1, 1);
		//this.gridPane.add(this.botonCambioModoAtaque, 13, 14, 1, 1);
		//this.gridPane.add(this.botonCambioModoDefensa, 13, 15, 1, 1);

		this.actualizarGrilla();

	}

	public void actualizarGrilla() {
		this.labelFase.setText("FASE: ".concat(this.juego.jugadorDeTurno().obtenerFase().nombre()));

		if (this.juego.jugadorDeTurno().equals(this.jugador1)) {

			this.labelTurno.setText("TURNO: JUGADOR 1");
			this.bloquearBotonesJugador2();
			for (Button unBoton : this.botonesManoJugador1)
				unBoton.setVisible(true);
			for (Button unBoton : this.botonesManoJugador2)
				unBoton.setVisible(false);

			if (this.juego.jugadorDeTurno().obtenerFase().getClass() == FaseInicial.class) {
				this.bloquearBotonesJugador1();
				this.botonMazoJugador1.setDisable(false);
				this.asignarMano();
			}

			if (this.juego.jugadorDeTurno().obtenerFase().getClass() == FasePreparacion.class) {
				this.bloquearBotonesJugador1();
				for (Button unBoton : this.botonesManoJugador1)
					unBoton.setDisable(false);
			}

			if (this.juego.jugadorDeTurno().obtenerFase().getClass() == FaseAtaque.class) {
				this.bloquearBotonesJugador1();
				for (Button unBoton : this.botonesCartasMonstruosJugador1)
					unBoton.setDisable(false);
				for (Button unBoton : this.botonesCartasMonstruosJugador2)
					unBoton.setDisable(false);
			}

		} else {
			this.labelTurno.setText("TURNO: JUGADOR 2");
			this.bloquearBotonesJugador1();
			for (Button unBoton : this.botonesManoJugador1)
				unBoton.setVisible(false);
			for (Button unBoton : this.botonesManoJugador2)
				unBoton.setVisible(true);

			if (this.juego.jugadorDeTurno().obtenerFase().getClass() == FaseInicial.class) {
				this.bloquearBotonesJugador2();
				this.botonMazoJugador2.setDisable(false);
				this.asignarMano();
			}

			if (this.juego.jugadorDeTurno().obtenerFase().getClass() == FasePreparacion.class) {
				this.bloquearBotonesJugador2();
				for (Button unBoton : this.botonesManoJugador2)
					unBoton.setDisable(false);
			}

			if (this.juego.jugadorDeTurno().obtenerFase().getClass() == FaseAtaque.class) {
				this.bloquearBotonesJugador2();
				for (Button unBoton : this.botonesCartasMonstruosJugador2)
					unBoton.setDisable(false);
				for (Button unBoton : this.botonesCartasMonstruosJugador1)
					unBoton.setDisable(false);
			}
		}
	}

	public void actualizarGrillaPorSeleccionDeCartaDeMano(Carta unaCarta) {
		this.botonAtacar.setVisible(false);
		this.botonCambioModoAtaque.setVisible(false);
		this.botonCambioModoDefensa.setVisible(false);
		//this.botonInvocar.setVisible(true);
		//this.botonSacrificar.setVisible(true);
		//this.botonInvocar.asignarCarta(unaCarta, this);
		//this.botonSacrificar.asignarCarta(unaCarta, this);
	}

	public void actualizarGrillaPorInvocacion(Carta unaCarta) {
		this.botonAtacar.setVisible(false);
		this.botonCambioModoAtaque.setVisible(false);
		this.botonCambioModoDefensa.setVisible(false);
		//this.botonInvocar.setVisible(false);
		//this.botonSacrificar.setVisible(false);

		if (this.juego.jugadorDeTurno().equals(this.jugador1)) {
			if (unaCarta.esMonstruo()) {
				BotonMano unBotonMano = this.obtenerBotonDeCarta(unaCarta, this.botonesManoJugador1);
				unBotonMano.limpiar();
				BotonCartaMonstruo unBotonMonstruo = this
						.obtenerBotonMonstruoLibre(this.botonesCartasMonstruosJugador1);
				unBotonMonstruo.asignarCarta(unaCarta, this);
			}
			if (unaCarta.esEspecial()) {
				BotonMano unBotonMano = this.obtenerBotonDeCarta(unaCarta, this.botonesManoJugador1);
				unBotonMano.limpiar();
				BotonCartaEspecial unBotonEspecial = this
						.obtenerBotonEspecialLibre(this.botonesCartasEspecialesJugador1);
				unBotonEspecial.asignarCarta(unaCarta, this);
			}
		} else {
			if (unaCarta.esMonstruo()) {
				BotonMano unBotonMano = this.obtenerBotonDeCarta(unaCarta, this.botonesManoJugador2);
				unBotonMano.limpiar();
				BotonCartaMonstruo unBotonMonstruo = this
						.obtenerBotonMonstruoLibre(this.botonesCartasMonstruosJugador2);
				unBotonMonstruo.asignarCarta(unaCarta, this);
			}
			if (unaCarta.esEspecial()) {
				BotonMano unBotonMano = this.obtenerBotonDeCarta(unaCarta, this.botonesManoJugador2);
				unBotonMano.limpiar();
				BotonCartaEspecial unBotonEspecial = this
						.obtenerBotonEspecialLibre(this.botonesCartasEspecialesJugador2);
				unBotonEspecial.asignarCarta(unaCarta, this);
			}
		}
	}

	public void actualizarGrillaPorSeleccionDeCartaMonstruo() {
		this.botonAtacar.setVisible(true);
		this.botonCambioModoAtaque.setVisible(true);
		this.botonCambioModoDefensa.setVisible(true);
		//this.botonInvocar.setVisible(false);
		//this.botonSacrificar.setVisible(false);
	}

	public void actualizarGrillaPorSeleccionDeCartaEspecial() {
		this.botonAtacar.setVisible(false);
		this.botonCambioModoAtaque.setVisible(false);
		this.botonCambioModoDefensa.setVisible(false);
		//this.botonInvocar.setVisible(true);
		//this.botonSacrificar.setVisible(false);
	}

	private void asignarMano() {
		for (int i = 0; i < this.jugador1.cantidadDeCartasEnMano(); i++) {
			BotonMano unBoton = this.botonesManoJugador1.get(i);
			unBoton.asignarCarta(this.jugador1.obtenerMano().obtenerCarta(i), this);
		}
		for (int i = 0; i < this.jugador2.cantidadDeCartasEnMano(); i++) {
			BotonMano unBoton = this.botonesManoJugador2.get(i);
			unBoton.asignarCarta(this.jugador2.obtenerMano().obtenerCarta(i), this);
		}
	}

	private BotonMano obtenerBotonDeCarta(Carta unaCarta, ArrayList<BotonMano> botones) {
		for (BotonMano unBoton : botones) {
			if (unBoton.obtenerCarta().equals(unaCarta))
				return unBoton;
		}
		return null;
	}

	private BotonCartaMonstruo obtenerBotonMonstruoLibre(ArrayList<BotonCartaMonstruo> botones) {
		for (BotonCartaMonstruo unBoton : botones) {
			if (unBoton.estaLibre())
				return unBoton;
		}
		return null;
	}

	private BotonCartaEspecial obtenerBotonEspecialLibre(ArrayList<BotonCartaEspecial> botones) {
		for (BotonCartaEspecial unBoton : botones) {
			if (unBoton.estaLibre())
				return unBoton;
		}
		return null;
	}

	private void bloquearBotonesJugador1() {
		this.botonCampoJugador1.setDisable(true);
		this.botonCementerioJugador1.setDisable(true);
		this.botonMazoJugador1.setDisable(true);
		for (Button unBoton : this.botonesCartasEspecialesJugador1)
			unBoton.setDisable(true);
		for (Button unBoton : this.botonesCartasMonstruosJugador1)
			unBoton.setDisable(true);
		for (Button unBoton : this.botonesManoJugador1)
			unBoton.setDisable(true);
	}

	private void bloquearBotonesJugador2() {
		this.botonCampoJugador2.setDisable(true);
		this.botonCementerioJugador2.setDisable(true);
		this.botonMazoJugador2.setDisable(true);
		for (Button unBoton : this.botonesCartasEspecialesJugador2)
			unBoton.setDisable(true);
		for (Button unBoton : this.botonesCartasMonstruosJugador2)
			unBoton.setDisable(true);
		for (Button unBoton : this.botonesManoJugador2)
			unBoton.setDisable(true);
	}

}