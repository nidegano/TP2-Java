package vista;

import java.io.FileInputStream;

import java.util.ArrayList;

import cartas.Carta;
import cartas.CartaDeCampo;
import cartas.CartaEspecial;
import cartas.CartaMagica;
import cartas.CartaMonstruo;
import cartas.CartaTrampa;
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
import opciones.Atacar;
import opciones.BotonInvocarEnModoDefensaBocaAbajoConSacrificio;
import opciones.BotonInvocarEnModoDefensaConSacrificio;
import opciones.CambiarAModoDefensa;
import opciones.CambiarAModoDefensaBocaAbajo;
import opciones.CambiarModoAtaque;
import opciones.ColocarBocaAbajo;
import opciones.ColocarBocaArriba;
import opciones.ColocarCartaDeCampo;
import opciones.Descartar;
import opciones.InvocarEnModoAtaque;
import opciones.InvocarEnModoAtaqueConSacrificio;
import opciones.InvocarEnModoDefensa;
import opciones.InvocarEnModoDefensaBocaAbajo;
import v.BotonListo;
import v.Vista;

public class Grilla extends Application {

	//Grilla en si
	private GridPane gridPane;
	
	//Soporte para mostrar la imagen de la carta seleccionada
	private ImageView imagenPredeterminada;
	private HBox marcoDeLaImagen;
	
	//Labels
	private Label labelDeJugadorA;
	private Label labelDeJugadorB;
	private Label labelDeTurno;
	private Label labelDeFase;
	
	//Collections de botones similares de VistaCampoJugadores
	private ArrayList<BotonMano> vistaCartaManoJugadorA;
	private ArrayList<BotonMano> vistaCartaManoJugadorB;
	private ArrayList<BotonCartaEspecial> vistaCartaEspecialesJugadorA;
	private ArrayList<BotonCartaEspecial> vistaCartaEspecialesJugadorB;
	private ArrayList<BotonCartaMonstruo> vistaCartaMonstruosJugadorA;
	private ArrayList<BotonCartaMonstruo> vistaCartaMonstruosJugadorB;
	
	//Botones Cartas de Campo
	private BotonCampo vistaCartaDeCampoJugadorA;
	private BotonCampo vistaCartaDeCampoJugadorB;
	
	//Botones Mazo
	private BotonMazo botonMazoJugadorA;
	private BotonMazo botonMazoJugadorB;
	
	//Botones Cementerio
	private BotonCementerio botonCementerioJugadorA;
	private BotonCementerio botonCementerioJugadorB;
	
	//Botones que son propios del juego y no de un Campo especifico de un jugador	
	private BotonFinalizarFase botonDeFinalizarFase;
	private BotonListo botonDeListo;
	
	//Opciones	
	private CambiarModoAtaque opcionCambiarAModoAtaque;
	private CambiarAModoDefensa opcionCambiarAModoDefensa;
	private CambiarAModoDefensaBocaAbajo opcionCambiarAModoDefensaBocaAbajo;
	
	private ColocarBocaAbajo opcionColocarBocaAbajo;
	private ColocarBocaArriba opcionColocarBocaArriba;
	private ColocarCartaDeCampo opcionColocarCartaDeCampo;
	
	private InvocarEnModoAtaque opcionInvocarEnModoAtaque;
	private InvocarEnModoDefensa opcionInvocarEnModoDefensa;
	private InvocarEnModoDefensaBocaAbajo opcionInvocarEnModoDefensaBocaAbajo;
	
	private InvocarEnModoAtaqueConSacrificio opcionInvocarEnModoAtaqueConSacrificio;
	private BotonInvocarEnModoDefensaConSacrificio opcionInvocarEnModoDefensaConSacrificio;
	private BotonInvocarEnModoDefensaBocaAbajoConSacrificio opcionInvocarEnModoDefensaBocaAbajoConSacrificio;
	
	private Atacar opcionAtacar;
	private Descartar opcionDescartar;

	public Grilla(Jugador jugador1, Jugador jugador2, Juego juego,Vista vista) throws Exception {

		this.inicializarGridPane();
		
		this.inicializarSoporteParaImagenDeCartaSeleccionada();
		
		this.inicializarLabels();
		
		this.inicializarVistasCartaDeVistaCampoJugadores(vista);

		this.vistaCartaDeCampoJugadorA = new BotonCampo("Campo", this.imagenPredeterminada);
		this.vistaCartaDeCampoJugadorB = new BotonCampo("Campo", this.imagenPredeterminada);

		this.botonMazoJugadorA = new BotonMazo(jugador1, this);
		this.botonMazoJugadorB = new BotonMazo(jugador2, this);

		this.botonCementerioJugadorA = new BotonCementerio();
		this.botonCementerioJugadorB = new BotonCementerio();

		this.botonDeFinalizarFase = new BotonFinalizarFase(juego);
		this.botonDeListo = new BotonListo(vista);

		this.inicializarOpciones();

		this.agregarBotonesALaGrilla();
	}

	private void inicializarOpciones() {
		this.opcionAtacar = new BotonAtacar();
		this.botonCambioModoAtaque = new BotonCambioModoAtaque();
		this.opcionCambiarAModoDefensa = new BotonCambioModoDefensa();

		this.opcionInvocarEnModoAtaque = new BotonInvocarEnModoAtaque();
		this.opcionInvocarEnModoDefensa = new BotonInvocarEnModoDefensa();
		this.opcionInvocarEnModoDefensaBocaAbajo = new BotonInvocarEnModoDefensaBocaAbajo();
		this.opcionColocarBocaAbajo = new BotonColocarBocaAbajo();
		this.opcionColocarBocaArriba = new BotonColocarBocaArriba();
		this.opcionColocarCartaDeCampo = new BotonColocarCartaDeCampo();
		
	}

	private void inicializarVistasCartaDeVistaCampoJugadores(Vista vista) {
		this.vistaCartaManoJugadorA = new ArrayList<BotonMano>();
		BotonMano botonMano1Jugador1 = new BotonMano(this.imagenPredeterminada);
		BotonMano botonMano2Jugador1 = new BotonMano(this.imagenPredeterminada);
		BotonMano botonMano3Jugador1 = new BotonMano(this.imagenPredeterminada);
		BotonMano botonMano4Jugador1 = new BotonMano(this.imagenPredeterminada);
		BotonMano botonMano5Jugador1 = new BotonMano(this.imagenPredeterminada);
		BotonMano botonMano6Jugador1 = new BotonMano(this.imagenPredeterminada);
		BotonMano botonMano7Jugador1 = new BotonMano(this.imagenPredeterminada);
		this.vistaCartaManoJugadorA.add(botonMano1Jugador1);
		this.vistaCartaManoJugadorA.add(botonMano2Jugador1);
		this.vistaCartaManoJugadorA.add(botonMano3Jugador1);
		this.vistaCartaManoJugadorA.add(botonMano4Jugador1);
		this.vistaCartaManoJugadorA.add(botonMano5Jugador1);
		this.vistaCartaManoJugadorA.add(botonMano6Jugador1);
		this.vistaCartaManoJugadorA.add(botonMano7Jugador1);

		this.vistaCartaManoJugadorB = new ArrayList<BotonMano>();
		BotonMano botonMano1Jugador2 = new BotonMano(this.imagenPredeterminada);
		BotonMano botonMano2Jugador2 = new BotonMano(this.imagenPredeterminada);
		BotonMano botonMano3Jugador2 = new BotonMano(this.imagenPredeterminada);
		BotonMano botonMano4Jugador2 = new BotonMano(this.imagenPredeterminada);
		BotonMano botonMano5Jugador2 = new BotonMano(this.imagenPredeterminada);
		BotonMano botonMano6Jugador2 = new BotonMano(this.imagenPredeterminada);
		BotonMano botonMano7Jugador2 = new BotonMano(this.imagenPredeterminada);
		this.vistaCartaManoJugadorB.add(botonMano1Jugador2);
		this.vistaCartaManoJugadorB.add(botonMano2Jugador2);
		this.vistaCartaManoJugadorB.add(botonMano3Jugador2);
		this.vistaCartaManoJugadorB.add(botonMano4Jugador2);
		this.vistaCartaManoJugadorB.add(botonMano5Jugador2);
		this.vistaCartaManoJugadorB.add(botonMano6Jugador2);
		this.vistaCartaManoJugadorB.add(botonMano7Jugador2);

		this.vistaCartaEspecialesJugadorA = new ArrayList<BotonCartaEspecial>();
		BotonCartaEspecial botonCartaEspecial1Jugador1 = new BotonCartaEspecial("Especial 1", this.imagenPredeterminada);
		BotonCartaEspecial botonCartaEspecial2Jugador1 = new BotonCartaEspecial("Especial 2", this.imagenPredeterminada);
		BotonCartaEspecial botonCartaEspecial3Jugador1 = new BotonCartaEspecial("Especial 3", this.imagenPredeterminada);
		BotonCartaEspecial botonCartaEspecial4Jugador1 = new BotonCartaEspecial("Especial 4", this.imagenPredeterminada);
		BotonCartaEspecial botonCartaEspecial5Jugador1 = new BotonCartaEspecial("Especial 5", this.imagenPredeterminada);
		this.vistaCartaEspecialesJugadorA.add(botonCartaEspecial1Jugador1);
		this.vistaCartaEspecialesJugadorA.add(botonCartaEspecial2Jugador1);
		this.vistaCartaEspecialesJugadorA.add(botonCartaEspecial3Jugador1);
		this.vistaCartaEspecialesJugadorA.add(botonCartaEspecial4Jugador1);
		this.vistaCartaEspecialesJugadorA.add(botonCartaEspecial5Jugador1);

		this.vistaCartaEspecialesJugadorB = new ArrayList<BotonCartaEspecial>();
		BotonCartaEspecial botonCartaEspecial1Jugador2 = new BotonCartaEspecial("Especial 1", this.imagenPredeterminada);
		BotonCartaEspecial botonCartaEspecial2Jugador2 = new BotonCartaEspecial("Especial 2", this.imagenPredeterminada);
		BotonCartaEspecial botonCartaEspecial3Jugador2 = new BotonCartaEspecial("Especial 3", this.imagenPredeterminada);
		BotonCartaEspecial botonCartaEspecial4Jugador2 = new BotonCartaEspecial("Especial 4", this.imagenPredeterminada);
		BotonCartaEspecial botonCartaEspecial5Jugador2 = new BotonCartaEspecial("Especial 5", this.imagenPredeterminada);
		this.vistaCartaEspecialesJugadorB.add(botonCartaEspecial1Jugador2);
		this.vistaCartaEspecialesJugadorB.add(botonCartaEspecial2Jugador2);
		this.vistaCartaEspecialesJugadorB.add(botonCartaEspecial3Jugador2);
		this.vistaCartaEspecialesJugadorB.add(botonCartaEspecial4Jugador2);
		this.vistaCartaEspecialesJugadorB.add(botonCartaEspecial5Jugador2);

		this.vistaCartaMonstruosJugadorA = new ArrayList<BotonCartaMonstruo>();
		BotonCartaMonstruo botonCartaMonstruo1Jugador1 = new BotonCartaMonstruo("Monstruo 1", this.imagenPredeterminada);
		BotonCartaMonstruo botonCartaMonstruo2Jugador1 = new BotonCartaMonstruo("Monstruo 2", this.imagenPredeterminada);
		BotonCartaMonstruo botonCartaMonstruo3Jugador1 = new BotonCartaMonstruo("Monstruo 3", this.imagenPredeterminada);
		BotonCartaMonstruo botonCartaMonstruo4Jugador1 = new BotonCartaMonstruo("Monstruo 4", this.imagenPredeterminada);
		BotonCartaMonstruo botonCartaMonstruo5Jugador1 = new BotonCartaMonstruo("Monstruo 5", this.imagenPredeterminada);
		this.vistaCartaMonstruosJugadorA.add(botonCartaMonstruo1Jugador1);
		this.vistaCartaMonstruosJugadorA.add(botonCartaMonstruo2Jugador1);
		this.vistaCartaMonstruosJugadorA.add(botonCartaMonstruo3Jugador1);
		this.vistaCartaMonstruosJugadorA.add(botonCartaMonstruo4Jugador1);
		this.vistaCartaMonstruosJugadorA.add(botonCartaMonstruo5Jugador1);

		this.vistaCartaMonstruosJugadorB = new ArrayList<BotonCartaMonstruo>();
		BotonCartaMonstruo botonCartaMonstruo1Jugador2 = new BotonCartaMonstruo("Monstruo 1", this.imagenPredeterminada);
		BotonCartaMonstruo botonCartaMonstruo2Jugador2 = new BotonCartaMonstruo("Monstruo 2", this.imagenPredeterminada);
		BotonCartaMonstruo botonCartaMonstruo3Jugador2 = new BotonCartaMonstruo("Monstruo 3", this.imagenPredeterminada);
		BotonCartaMonstruo botonCartaMonstruo4Jugador2 = new BotonCartaMonstruo("Monstruo 4", this.imagenPredeterminada);
		BotonCartaMonstruo botonCartaMonstruo5Jugador2 = new BotonCartaMonstruo("Monstruo 5", this.imagenPredeterminada);
		this.vistaCartaMonstruosJugadorB.add(botonCartaMonstruo1Jugador2);
		this.vistaCartaMonstruosJugadorB.add(botonCartaMonstruo2Jugador2);
		this.vistaCartaMonstruosJugadorB.add(botonCartaMonstruo3Jugador2);
		this.vistaCartaMonstruosJugadorB.add(botonCartaMonstruo4Jugador2);
		this.vistaCartaMonstruosJugadorB.add(botonCartaMonstruo5Jugador2);		
	}

	private void inicializarLabels() {
		this.labelDeJugadorA = new Label("JUGADOR 1");
		this.labelDeJugadorB = new Label("JUGADOR 2");
		this.labelDeTurno = new Label("");
		this.labelDeFase = new Label("");		
	}

	private void inicializarSoporteParaImagenDeCartaSeleccionada() {
		FileInputStream input = new FileInputStream("resources/images/carta_dorso.png");
		Image image = new Image(input);
		this.imagenPredeterminada = new ImageView(image);
		this.marcoDeLaImagen = new HBox(this.imagenPredeterminada);		
	}

	private void inicializarGridPane() {
		this.gridPane = new GridPane();
		this.gridPane.setHgap(10);
		this.gridPane.setVgap(10);
		this.gridPane.setAlignment(Pos.CENTER);		
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
		this.gridPane.add(this.botonMazoJugadorA, 1, 1, 1, 1);
		this.gridPane.add(this.botonCementerioJugadorA, 1, 5, 1, 1);
		this.gridPane.add(this.vistaCartaDeCampoJugadorA, 9, 5, 1, 1);

		int i = 2;
		for (BotonMano unBoton : this.vistaCartaManoJugadorA) {
			this.gridPane.add(unBoton, i, 2, 1, 1);
			i++;
		}

		i = 3;
		for (BotonCartaEspecial unBoton : this.vistaCartaEspecialesJugadorA) {
			this.gridPane.add(unBoton, i, 3, 1, 1);
			i++;
		}

		i = 3;
		for (BotonCartaMonstruo unBoton : this.vistaCartaMonstruosJugadorA) {
			this.gridPane.add(unBoton, i, 4, 1, 1);
			i++;
		}

		// JUGADOR 2
		this.gridPane.add(this.botonMazoJugadorB, 9, 11, 1, 1);
		this.gridPane.add(this.botonCementerioJugadorB, 9, 7, 1, 1);
		this.gridPane.add(this.vistaCartaDeCampoJugadorB, 1, 7, 1, 1);

		i = 2;
		for (BotonMano unBoton : this.vistaCartaManoJugadorB) {
			this.gridPane.add(unBoton, i, 10, 1, 1);
			i++;
		}

		i = 3;
		for (BotonCartaEspecial unBoton : this.vistaCartaEspecialesJugadorB) {
			this.gridPane.add(unBoton, i, 9, 1, 1);
			i++;
		}

		i = 3;
		for (BotonCartaMonstruo unBoton : this.vistaCartaMonstruosJugadorB) {
			this.gridPane.add(unBoton, i, 8, 1, 1);
			i++;
		}

		// PANEL DE ACCION
		this.gridPane.add(this.labelDeJugadorA, 0, 0, 1, 1);
		this.gridPane.add(this.labelDeJugadorB, 0, 12, 1, 1);
		this.gridPane.add(this.labelDeTurno, 13, 3, 1, 1);
		this.gridPane.add(this.labelDeFase, 13, 4, 1, 1);

		this.gridPane.add(this.hbox, 13, 6, 1, 1);

		this.gridPane.add(this.botonDeFinalizarFase, 13, 5, 1, 1);

		// this.gridPane.add(this.botonInvocar, 13, 7, 1, 1);
		// this.gridPane.add(this.botonSacrificar, 13, 8, 1, 1);

		this.gridPane.add(this.opcionInvocarEnModoAtaque, 13, 7, 1, 1);
		this.gridPane.add(this.opcionInvocarEnModoDefensa, 13, 8, 1, 1);
		this.gridPane.add(this.opcionInvocarEnModoDefensaBocaAbajo, 13, 9, 1, 1);

		this.gridPane.add(this.opcionColocarBocaAbajo, 13, 7, 1, 1);
		this.gridPane.add(this.opcionColocarBocaArriba, 13, 8, 1, 1);

		this.gridPane.add(this.opcionColocarCartaDeCampo, 13, 7, 1, 1);

		this.gridPane.add(this.opcionAtacar, 13, 7, 1, 1);
		// this.gridPane.add(this.botonCambioModoAtaque, 13, 14, 1, 1);
		// this.gridPane.add(this.botonCambioModoDefensa, 13, 15, 1, 1);

		this.actualizarGrilla();

	}

	public void actualizarGrilla() {
		this.labelDeFase.setText("FASE: ".concat(this.juego.jugadorDeTurno().obtenerFase().nombre()));

		if (this.juego.jugadorDeTurno().equals(this.jugador1)) {

			this.labelDeTurno.setText("TURNO: JUGADOR 1");
			this.bloquearBotonesJugador2();
			for (Button unBoton : this.vistaCartaManoJugadorA)
				unBoton.setVisible(true);
			for (Button unBoton : this.vistaCartaManoJugadorB)
				unBoton.setVisible(false);

			if (this.juego.jugadorDeTurno().obtenerFase().getClass() == FaseInicial.class) {
				this.bloquearBotonesJugador1();
				this.botonMazoJugadorA.setDisable(false);
				this.asignarMano();
			}

			if (this.juego.jugadorDeTurno().obtenerFase().getClass() == FasePreparacion.class) {
				this.bloquearBotonesJugador1();
				for (Button unBoton : this.vistaCartaManoJugadorA)
					unBoton.setDisable(false);
			}

			if (this.juego.jugadorDeTurno().obtenerFase().getClass() == FaseAtaque.class) {
				this.bloquearBotonesJugador1();
				for (Button unBoton : this.vistaCartaMonstruosJugadorA)
					unBoton.setDisable(false);
				for (Button unBoton : this.vistaCartaMonstruosJugadorB)
					unBoton.setDisable(false);
			}

			if (this.juego.jugadorDeTurno().obtenerFase().getClass() == FaseFinal.class) {
				this.bloquearBotonesJugador1();
				for (Button unBoton : this.vistaCartaEspecialesJugadorA)
					unBoton.setDisable(false);
				for (Button unBoton : this.vistaCartaEspecialesJugadorB)
					unBoton.setDisable(false);
			}

		} else {
			this.labelDeTurno.setText("TURNO: JUGADOR 2");
			this.bloquearBotonesJugador1();
			for (Button unBoton : this.vistaCartaManoJugadorA)
				unBoton.setVisible(false);
			for (Button unBoton : this.vistaCartaManoJugadorB)
				unBoton.setVisible(true);

			if (this.juego.jugadorDeTurno().obtenerFase().getClass() == FaseInicial.class) {
				this.bloquearBotonesJugador2();
				this.botonMazoJugadorB.setDisable(false);
				this.asignarMano();
			}

			if (this.juego.jugadorDeTurno().obtenerFase().getClass() == FasePreparacion.class) {
				this.bloquearBotonesJugador2();
				for (Button unBoton : this.vistaCartaManoJugadorB)
					unBoton.setDisable(false);
			}

			if (this.juego.jugadorDeTurno().obtenerFase().getClass() == FaseAtaque.class) {
				this.bloquearBotonesJugador2();
				for (Button unBoton : this.vistaCartaMonstruosJugadorB)
					unBoton.setDisable(false);
				for (Button unBoton : this.vistaCartaMonstruosJugadorA)
					unBoton.setDisable(false);
			}

			if (this.juego.jugadorDeTurno().obtenerFase().getClass() == FaseFinal.class) {
				this.bloquearBotonesJugador2();
				for (Button unBoton : this.vistaCartaEspecialesJugadorA)
					unBoton.setDisable(false);
				for (Button unBoton : this.vistaCartaEspecialesJugadorB)
					unBoton.setDisable(false);
			}
		}
	}

	public void actualizarGrillaPorSeleccionDeCartaDeMano(CartaMonstruo unaCarta) {
		this.opcionInvocarEnModoAtaque.setVisible(true);
		this.opcionInvocarEnModoDefensa.setVisible(true);
		this.opcionInvocarEnModoDefensaBocaAbajo.setVisible(true);
		this.opcionColocarBocaAbajo.setVisible(false);
		this.opcionColocarBocaArriba.setVisible(false);
		this.opcionColocarCartaDeCampo.setVisible(false);

		this.opcionInvocarEnModoAtaque.asignarCarta(unaCarta, this);
		this.opcionInvocarEnModoDefensa.asignarCarta(unaCarta, this);
		this.opcionInvocarEnModoDefensaBocaAbajo.asignarCarta(unaCarta, this);
	}

	public void actualizarGrillaPorSeleccionDeCartaDeMano(CartaTrampa unaCarta) {
		this.opcionInvocarEnModoAtaque.setVisible(false);
		this.opcionInvocarEnModoDefensa.setVisible(false);
		this.opcionInvocarEnModoDefensaBocaAbajo.setVisible(false);
		this.opcionColocarBocaAbajo.setVisible(true);
		this.opcionColocarBocaArriba.setVisible(false);
		this.opcionColocarCartaDeCampo.setVisible(false);

		this.opcionColocarBocaAbajo.asignarCarta(unaCarta, this);
		this.opcionColocarBocaArriba.asignarCarta(unaCarta, this);
	}

	public void actualizarGrillaPorSeleccionDeCartaDeMano(CartaMagica unaCarta) {
		this.opcionInvocarEnModoAtaque.setVisible(false);
		this.opcionInvocarEnModoDefensa.setVisible(false);
		this.opcionInvocarEnModoDefensaBocaAbajo.setVisible(false);
		this.opcionColocarBocaAbajo.setVisible(true);
		this.opcionColocarBocaArriba.setVisible(this.juego.jugadorDeTurno().obtenerFase() instanceof FaseFinal);
		this.opcionColocarCartaDeCampo.setVisible(false);

		this.opcionColocarBocaAbajo.asignarCarta(unaCarta, this);
		this.opcionColocarBocaArriba.asignarCarta(unaCarta, this);
	}

	public void actualizarGrillaPorSeleccionDeCartaDeMano(CartaDeCampo unaCarta) {
		this.opcionInvocarEnModoAtaque.setVisible(false);
		this.opcionInvocarEnModoDefensa.setVisible(false);
		this.opcionInvocarEnModoDefensaBocaAbajo.setVisible(false);
		this.opcionColocarBocaAbajo.setVisible(false);
		this.opcionColocarBocaArriba.setVisible(false);
		this.opcionColocarCartaDeCampo.setVisible(true);
		;

		this.opcionColocarCartaDeCampo.asignarCarta(unaCarta, this);
	}

	public void actualizarGrillaPorSeleccionDeCartaDeMano(Carta unaCarta) {

		unaCarta.provocarActualizacionDeLaGrillaSegunTipo(this);

		this.opcionAtacar.setVisible(false);
		this.botonCambioModoAtaque.setVisible(false);
		this.opcionCambiarAModoDefensa.setVisible(false);
	}

	public void actualizarPorInvocacionDeUnMonstruo(CartaMonstruo unaCarta) {

		if (this.juego.jugadorDeTurno().equals(this.jugador1)) {

			BotonMano unBotonMano = this.obtenerBotonDeCarta(unaCarta, this.vistaCartaManoJugadorA);
			unBotonMano.limpiar();
			BotonCartaMonstruo unBotonMonstruo = this.obtenerBotonMonstruoLibre(this.vistaCartaMonstruosJugadorA);
			unBotonMonstruo.asignarCarta(unaCarta, this);
		} else {
			BotonMano unBotonMano = this.obtenerBotonDeCarta(unaCarta, this.vistaCartaManoJugadorB);
			unBotonMano.limpiar();
			BotonCartaMonstruo unBotonMonstruo = this.obtenerBotonMonstruoLibre(this.vistaCartaMonstruosJugadorB);
			unBotonMonstruo.asignarCarta(unaCarta, this);
		}
	}

	public void actualizarPorInvocacionDeUnaCartaEspecial(CartaMagica unaCarta) {

		if (this.juego.jugadorDeTurno().equals(this.jugador1)) {

			BotonMano unBotonMano = this.obtenerBotonDeCarta(unaCarta, this.vistaCartaManoJugadorA);
			unBotonMano.limpiar();
			BotonCartaEspecial unBotonEspecial = this.obtenerBotonEspecialLibre(this.vistaCartaEspecialesJugadorA);
			unBotonEspecial.asignarCarta(unaCarta, this);
		} else {
			BotonMano unBotonMano = this.obtenerBotonDeCarta(unaCarta, this.vistaCartaManoJugadorB);
			unBotonMano.limpiar();
			BotonCartaEspecial unBotonEspecial = this.obtenerBotonEspecialLibre(this.vistaCartaEspecialesJugadorB);
			unBotonEspecial.asignarCarta(unaCarta, this);
		}
	}

	public void actualizarPorInvocacionDeUnaCartaEspecial(CartaTrampa unaCarta) {

		if (this.juego.jugadorDeTurno().equals(this.jugador1)) {

			BotonMano unBotonMano = this.obtenerBotonDeCarta(unaCarta, this.vistaCartaManoJugadorA);
			unBotonMano.limpiar();
			BotonCartaEspecial unBotonEspecial = this.obtenerBotonEspecialLibre(this.vistaCartaEspecialesJugadorA);
			unBotonEspecial.asignarCarta(unaCarta, this);
		} else {
			BotonMano unBotonMano = this.obtenerBotonDeCarta(unaCarta, this.vistaCartaManoJugadorB);
			unBotonMano.limpiar();
			BotonCartaEspecial unBotonEspecial = this.obtenerBotonEspecialLibre(this.vistaCartaEspecialesJugadorB);
			unBotonEspecial.asignarCarta(unaCarta, this);
		}
	}

	public void actualizarPorInvocacionDeUnaCartaDeCampo(CartaDeCampo unaCarta) {

		if (this.juego.jugadorDeTurno().equals(this.jugador1)) {

			BotonMano unBotonMano = this.obtenerBotonDeCarta(unaCarta, this.vistaCartaManoJugadorA);
			unBotonMano.limpiar();
			BotonCampo unBotonCampo = this.vistaCartaDeCampoJugadorA;
			unBotonCampo.asignarCarta(unaCarta, this);
		} else {
			BotonMano unBotonMano = this.obtenerBotonDeCarta(unaCarta, this.vistaCartaManoJugadorB);
			unBotonMano.limpiar();
			BotonCampo unBotonCampo = this.vistaCartaDeCampoJugadorB;
			unBotonCampo.asignarCarta(unaCarta, this);
		}
	}

	public void actualizarGrillaPorInvocacion(Carta unaCarta) {

		unaCarta.actualizarGrillaPorinvocacionSegunCorrespondaPorElTipo(this);
	}

	public void actualizarGrillaPorSeleccionDeCartaMonstruo() {
		this.opcionAtacar.setVisible(true);
		this.botonCambioModoAtaque.setVisible(true);
		this.opcionCambiarAModoDefensa.setVisible(true);
		// this.botonInvocar.setVisible(false);
		// this.botonSacrificar.setVisible(false);
	}

	public void actualizarGrillaPorSeleccionDeCartaEspecial() {
		this.opcionAtacar.setVisible(false);
		this.botonCambioModoAtaque.setVisible(false);
		this.opcionCambiarAModoDefensa.setVisible(false);
		// this.botonInvocar.setVisible(true);
		// this.botonSacrificar.setVisible(false);
		this.opcionColocarBocaArriba.setVisible(true);
	}

	private void asignarMano() {
		for (int i = 0; i < this.jugador1.cantidadDeCartasEnMano(); i++) {
			BotonMano unBoton = this.vistaCartaManoJugadorA.get(i);
			System.out.println(unBoton.estaLibre());
			if (unBoton.estaLibre()) {
				unBoton.asignarCarta(this.jugador1.obtenerMano().obtenerCarta(i), this);
			}
		}
		for (int i = 0; i < this.jugador2.cantidadDeCartasEnMano(); i++) {
			BotonMano unBoton = this.vistaCartaManoJugadorB.get(i);
			if (unBoton.estaLibre()) {
				unBoton.asignarCarta(this.jugador2.obtenerMano().obtenerCarta(i), this);
			}
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
		this.vistaCartaDeCampoJugadorA.setDisable(true);
		this.botonCementerioJugadorA.setDisable(true);
		this.botonMazoJugadorA.setDisable(true);
		for (Button unBoton : this.vistaCartaEspecialesJugadorA)
			unBoton.setDisable(true);
		for (Button unBoton : this.vistaCartaMonstruosJugadorA)
			unBoton.setDisable(true);
		for (Button unBoton : this.vistaCartaManoJugadorA)
			unBoton.setDisable(true);
	}

	private void bloquearBotonesJugador2() {
		this.vistaCartaDeCampoJugadorB.setDisable(true);
		this.botonCementerioJugadorB.setDisable(true);
		this.botonMazoJugadorB.setDisable(true);
		for (Button unBoton : this.vistaCartaEspecialesJugadorB)
			unBoton.setDisable(true);
		for (Button unBoton : this.vistaCartaMonstruosJugadorB)
			unBoton.setDisable(true);
		for (Button unBoton : this.vistaCartaManoJugadorB)
			unBoton.setDisable(true);
	}

}