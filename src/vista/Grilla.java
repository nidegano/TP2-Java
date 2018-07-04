package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import botones.VistaCarta;
import botones.VistaCartaDeCampo;
import botones.VistaCartaEspecial;
import botones.VistaCartaMano;
import botones.VistaCartaMonstruo;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
	private ImageView imagenAMostrar;
	private ImageView imagenPredeterminada;
	private HBox marcoDeLaImagen;
	
	//Labels
	private Label labelDeJugadorA;
	private Label labelDeJugadorB;
	private Label labelVidaDeJugadorA;
	private Label labelVidaDeJugadorB;
	private Label labelDeTurno;
	private Label labelDeFase;
	
	//Collections de botones similares de VistaCampoJugadores
	private ArrayList<VistaCartaMano> vistaCartaManoJugadorA;
	private ArrayList<VistaCartaMano> vistaCartaManoJugadorB;
	private ArrayList<VistaCartaEspecial> vistaCartaEspecialesJugadorA;
	private ArrayList<VistaCartaEspecial> vistaCartaEspecialesJugadorB;
	private ArrayList<VistaCartaMonstruo> vistaCartaMonstruosJugadorA;
	private ArrayList<VistaCartaMonstruo> vistaCartaMonstruosJugadorB;
	
	//Botones Cartas de Campo
	private VistaCartaDeCampo vistaCartaDeCampoJugadorA;
	private VistaCartaDeCampo vistaCartaDeCampoJugadorB;
	
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

	public Grilla(JugadorA jugadorA, JugadorB jugadorB, Juego juego,Vista vista) throws Exception {

		this.inicializarGridPane();
		
		this.inicializarSoporteParaImagenDeCartaSeleccionada();
		
		this.inicializarLabels();
		
		this.inicializarVistasCartaDeVistaCampoJugadores(vista);

		this.vistaCartaDeCampoJugadorA = new VistaCartaDeCampo(vista);
		this.vistaCartaDeCampoJugadorB = new VistaCartaDeCampo(vista);

		this.botonMazoJugadorA = new BotonMazo(jugadorA);
		this.botonMazoJugadorB = new BotonMazo(jugadorB);

		this.botonCementerioJugadorA = new BotonCementerio();
		this.botonCementerioJugadorB = new BotonCementerio();

		this.botonDeFinalizarFase = new BotonFinalizarFase(juego);
		this.botonDeListo = new BotonListo(vista);

		this.inicializarOpciones(vista);

		this.agregarBotonesALaGrilla();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Al-Go-Oh!");
		Scene scene = new Scene(this.gridPane, 1200, 1200);
		primaryStage.setFullScreen(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void inicializarOpciones(Vista vista) {
		
		this.opcionCambiarAModoAtaque = new CambiarModoAtaque(vista);
		this.opcionCambiarAModoDefensa = new CambiarAModoDefensa(vista);
		this.opcionCambiarAModoDefensaBocaAbajo = new CambiarAModoDefensaBocaAbajo(vista);
		
		this.opcionColocarBocaAbajo = new ColocarBocaAbajo(vista);
		this.opcionColocarBocaArriba = new ColocarBocaArriba(vista);
		this.opcionColocarCartaDeCampo = new ColocarCartaDeCampo(vista);
		
		this.opcionInvocarEnModoAtaque = new InvocarEnModoAtaque(vista);
		this.opcionInvocarEnModoDefensa = new InvocarEnModoDefensa(vista);
		this.opcionInvocarEnModoDefensaBocaAbajo = new InvocarEnModoDefensaBocaAbajo(vista);
		
		this.opcionInvocarEnModoAtaqueConSacrificio = new InvocarEnModoAtaqueConSacrificio(vista);
		this.opcionInvocarEnModoDefensaConSacrificio = new BotonInvocarEnModoDefensaConSacrificio(vista);
		this.opcionInvocarEnModoDefensaBocaAbajoConSacrificio = new BotonInvocarEnModoDefensaBocaAbajoConSacrificio(vista);	
		
		this.opcionAtacar = new Atacar(vista);
		this.opcionDescartar = new Descartar(vista);
	}

// Inicialziar
	
	private void inicializarVistasCartaDeVistaCampoJugadores(Vista vista) {
		
		//Se inicializa la collection de "slots" (Vistas) que se corresponden con la mano
		this.vistaCartaManoJugadorA = new ArrayList<VistaCartaMano>();		
		this.vistaCartaManoJugadorA.add(new VistaCartaMano(vista));
		this.vistaCartaManoJugadorA.add(new VistaCartaMano(vista));
		this.vistaCartaManoJugadorA.add(new VistaCartaMano(vista));
		this.vistaCartaManoJugadorA.add(new VistaCartaMano(vista));
		this.vistaCartaManoJugadorA.add(new VistaCartaMano(vista));
		this.vistaCartaManoJugadorA.add(new VistaCartaMano(vista));
		this.vistaCartaManoJugadorA.add(new VistaCartaMano(vista));

		this.vistaCartaManoJugadorB = new ArrayList<VistaCartaMano>();		
		this.vistaCartaManoJugadorB.add(new VistaCartaMano(vista));
		this.vistaCartaManoJugadorB.add(new VistaCartaMano(vista));
		this.vistaCartaManoJugadorB.add(new VistaCartaMano(vista));
		this.vistaCartaManoJugadorB.add(new VistaCartaMano(vista));
		this.vistaCartaManoJugadorB.add(new VistaCartaMano(vista));
		this.vistaCartaManoJugadorB.add(new VistaCartaMano(vista));
		this.vistaCartaManoJugadorB.add(new VistaCartaMano(vista));

		//Se inicializa la collection de "slots" (Vistas) que se corresponden con la zona de cartas especiales
		this.vistaCartaEspecialesJugadorA = new ArrayList<VistaCartaEspecial>();
		this.vistaCartaEspecialesJugadorA.add(new VistaCartaEspecial(vista));
		this.vistaCartaEspecialesJugadorA.add(new VistaCartaEspecial(vista));
		this.vistaCartaEspecialesJugadorA.add(new VistaCartaEspecial(vista));
		this.vistaCartaEspecialesJugadorA.add(new VistaCartaEspecial(vista));
		this.vistaCartaEspecialesJugadorA.add(new VistaCartaEspecial(vista));

		this.vistaCartaEspecialesJugadorB = new ArrayList<VistaCartaEspecial>();
		this.vistaCartaEspecialesJugadorB.add(new VistaCartaEspecial(vista));
		this.vistaCartaEspecialesJugadorB.add(new VistaCartaEspecial(vista));
		this.vistaCartaEspecialesJugadorB.add(new VistaCartaEspecial(vista));
		this.vistaCartaEspecialesJugadorB.add(new VistaCartaEspecial(vista));
		this.vistaCartaEspecialesJugadorB.add(new VistaCartaEspecial(vista));

		//Se inicializa la collection de "slots" (Vistas) que se corresponden con la zona de cartas monstruo
		this.vistaCartaMonstruosJugadorA = new ArrayList<VistaCartaMonstruo>();
		this.vistaCartaMonstruosJugadorA.add(new VistaCartaMonstruo(vista));
		this.vistaCartaMonstruosJugadorA.add(new VistaCartaMonstruo(vista));
		this.vistaCartaMonstruosJugadorA.add(new VistaCartaMonstruo(vista));
		this.vistaCartaMonstruosJugadorA.add(new VistaCartaMonstruo(vista));
		this.vistaCartaMonstruosJugadorA.add(new VistaCartaMonstruo(vista));

		this.vistaCartaMonstruosJugadorB = new ArrayList<VistaCartaMonstruo>();
		this.vistaCartaMonstruosJugadorB.add(new VistaCartaMonstruo(vista));
		this.vistaCartaMonstruosJugadorB.add(new VistaCartaMonstruo(vista));
		this.vistaCartaMonstruosJugadorB.add(new VistaCartaMonstruo(vista));
		this.vistaCartaMonstruosJugadorB.add(new VistaCartaMonstruo(vista));
		this.vistaCartaMonstruosJugadorB.add(new VistaCartaMonstruo(vista));	
	}

	private void inicializarLabels() {
		this.labelDeJugadorA = new Label("JUGADOR A");
		this.labelDeJugadorB = new Label("JUGADOR B");
		this.labelVidaDeJugadorA = new Label("-");
		this.labelVidaDeJugadorB = new Label("-");
		this.labelDeTurno = new Label("");
		this.labelDeFase = new Label("");		
	}

	private void inicializarSoporteParaImagenDeCartaSeleccionada() throws FileNotFoundException {
		FileInputStream input = new FileInputStream("resources/images/carta_dorso.png");
		Image image = new Image(input);
		this.imagenPredeterminada = new ImageView(image);
		this.imagenAMostrar = this.imagenPredeterminada;
		this.marcoDeLaImagen = new HBox(this.imagenAMostrar);		
	}

	private void inicializarGridPane() {
		this.gridPane = new GridPane();
		this.gridPane.setHgap(10);
		this.gridPane.setVgap(10);
		this.gridPane.setAlignment(Pos.CENTER);		
	}

	private void agregarBotonesALaGrilla() {
		// JUGADOR 1
		this.gridPane.add(this.botonMazoJugadorA, 1, 1, 1, 1);
		this.gridPane.add(this.botonCementerioJugadorA, 1, 5, 1, 1);
		this.gridPane.add(this.vistaCartaDeCampoJugadorA, 9, 5, 1, 1);

		int i = 2;
		for (VistaCarta unSlot : this.vistaCartaManoJugadorA) {
			this.gridPane.add(unSlot, i, 2, 1, 1);
			i++;
		}

		i = 3;
		for (VistaCartaEspecial unSlot : this.vistaCartaEspecialesJugadorA) {
			this.gridPane.add(unSlot, i, 3, 1, 1);
			i++;
		}

		i = 3;
		for (VistaCartaMonstruo unSlot : this.vistaCartaMonstruosJugadorA) {
			this.gridPane.add(unSlot, i, 4, 1, 1);
			i++;
		}

		// JUGADOR 2
		this.gridPane.add(this.botonMazoJugadorB, 9, 11, 1, 1);
		this.gridPane.add(this.botonCementerioJugadorB, 9, 7, 1, 1);
		this.gridPane.add(this.vistaCartaDeCampoJugadorB, 1, 7, 1, 1);

		i = 2;
		for (VistaCarta unSlot : this.vistaCartaManoJugadorB) {
			this.gridPane.add(unSlot, i, 10, 1, 1);
			i++;
		}

		i = 3;
		for (VistaCartaEspecial unSlot : this.vistaCartaEspecialesJugadorB) {
			this.gridPane.add(unSlot, i, 9, 1, 1);
			i++;
		}

		i = 3;
		for (VistaCartaMonstruo unSlot : this.vistaCartaMonstruosJugadorB) {
			this.gridPane.add(unSlot, i, 8, 1, 1);
			i++;
		}
		
		//ESTRUCTURA DEL PANEL DE ACCION
		this.gridPane.add(this.labelDeJugadorA, 0, 0, 1, 1);
		this.gridPane.add(this.labelDeJugadorB, 0, 12, 1, 1);
		this.gridPane.add(this.labelDeTurno, 13, 3, 1, 1);
		this.gridPane.add(this.labelDeFase, 13, 4, 1, 1);

		this.gridPane.add(this.marcoDeLaImagen, 13, 6, 1, 1);
		this.gridPane.add(this.botonDeFinalizarFase, 13, 5, 1, 1);
		this.gridPane.add(this.botonDeListo, 13, 5,1,1);
		
		//OPCIONES
		this.gridPane.add(this.opcionCambiarAModoAtaque, 13, 7, 1, 1);
		this.gridPane.add(this.opcionCambiarAModoDefensa, 13, 8, 1, 1);
		this.gridPane.add(this.opcionCambiarAModoDefensaBocaAbajo, 13, 9, 1, 1);
		
		this.gridPane.add(this.opcionColocarBocaAbajo, 13, 7, 1, 1);
		this.gridPane.add(this.opcionColocarBocaArriba, 13, 7, 1, 1);
		this.gridPane.add(this.opcionColocarCartaDeCampo, 13, 7, 1, 1);
		
		this.gridPane.add(this.opcionInvocarEnModoAtaque, 13, 7, 1, 1);
		this.gridPane.add(this.opcionInvocarEnModoDefensa, 13, 8, 1, 1);
		this.gridPane.add(this.opcionInvocarEnModoDefensaBocaAbajo, 13, 9, 1, 1);
		
		this.gridPane.add(this.opcionInvocarEnModoAtaqueConSacrificio, 13, 7, 1, 1);
		this.gridPane.add(this.opcionInvocarEnModoDefensaConSacrificio, 13, 8, 1, 1);
		this.gridPane.add(this.opcionInvocarEnModoDefensaBocaAbajoConSacrificio, 13, 9, 1, 1);	
		
		this.gridPane.add(this.opcionAtacar, 13, 7, 1, 1);
		this.gridPane.add(this.opcionDescartar, 13, 10, 1, 1); //esta tiene que estar siempre habilitada
	}

	
	
// Buscar un Lugar vacio para VistaCarta que se quiere colocar en VistaCampoJugadores
	
	public VistaCarta obtenerUnLugarVacioParaCartaMonstruoDeJugadorA() {
		for (VistaCartaMonstruo lugar : this.vistaCartaMonstruosJugadorA) {
			if(lugar.estaLibre()) {
				return lugar;
			}
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}

	public VistaCarta obtenerUnLugarVacioParaCartaEspecialDeJugadorA() {
		for (VistaCartaEspecial lugar : this.vistaCartaEspecialesJugadorA) {
			if(lugar.estaLibre()) {
				return lugar;
			}
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}

	public VistaCarta obtenerUnLugarVacioParaCartaDeCampoDeJugadorA() {
		if(this.vistaCartaDeCampoJugadorA.estaLibre()) {
			return this.vistaCartaDeCampoJugadorA;
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}
	
	public VistaCarta obtenerUnLugarVacioParaCartaMonstruoDeJugadorB() {
		for (VistaCartaMonstruo lugar : this.vistaCartaMonstruosJugadorB) {
			if(lugar.estaLibre()) {
				return lugar;
			}
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}

	public VistaCarta obtenerUnLugarVacioParaCartaEspecialDeJugadorB() {
		for (VistaCartaEspecial lugar : this.vistaCartaEspecialesJugadorB) {
			if(lugar.estaLibre()) {
				return lugar;
			}
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}

	public VistaCarta obtenerUnLugarVacioParaCartaDeCampoDeJugadorB() {
		if(this.vistaCartaDeCampoJugadorB.estaLibre()) {
			return this.vistaCartaDeCampoJugadorA;
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}

	

	
// Settear Visibilidad de Opciones
	
	public void botonDeListoHacerVisible(boolean b) {
		this.botonDeListo.setVisible(b);
	}
	
	public void opcionCambiarAModoAtaqueHacerVisible(boolean b) {
		this.opcionCambiarAModoAtaque.setVisible(b);
	}

	public void opcionCambiarAModoDefensaHacerVisible(boolean b) {
		this.opcionCambiarAModoDefensa.setVisible(b);
	}

	public void opcionCambiarAModoDefensaBocaAbajoHacerVisible(boolean b) {
		this.opcionCambiarAModoDefensaBocaAbajo.setVisible(b);
	}

	public void opcionColocarBocaAbajoHacerVisible(boolean b) {
		this.opcionColocarBocaAbajo.setVisible(b);
		
	}

	public void opcionColocarBocaArribaHacerVisible(boolean b) {
		this.opcionColocarBocaArriba.setVisible(b);
	}

	public void opcionColocarCartaDeCampoHacerVisible(boolean b) {
		this.opcionColocarCartaDeCampo.setVisible(b);	
	}

	public void opcionInvocarEnModoAtaqueHacerVisible(boolean b) {
		this.opcionInvocarEnModoAtaque.setVisible(b);
	}

	public void opcionInvocarEnModoDefensaHacerVisible(boolean b) {
		this.opcionInvocarEnModoDefensa.setVisible(b);
	}

	public void opcionInvocarEnModoDefensaBocaAbajoHacerVisible(boolean b) {
		this.opcionInvocarEnModoDefensaBocaAbajo.setVisible(b);	
	}

	public void opcionInvocarEnModoAtaqueConSacrificioHacerVisible(boolean b) {
		this.opcionInvocarEnModoAtaqueConSacrificio.setVisible(b);
	}

	public void opcionInvocarEnModoDefensaConSacrificioHacerVisible(boolean b) {
		this.opcionInvocarEnModoDefensaConSacrificio.setVisible(b);
	}

	public void opcionInvocarEnModoDefensaBocaAbajoConSacrificioHacerVisible(boolean b) {
		this.opcionInvocarEnModoDefensaBocaAbajoConSacrificio.setVisible(b);
	}

	public void opcionAtacarHacerVisible(boolean b) {
		this.opcionAtacar.setVisible(b);
	}

	public void opcionDescartarHacerVisible(boolean b) {
		this.opcionDescartar.setVisible(b);
	}

	
// Cambios de Estado Interno
	
	
	public void asignarNuevaVidaALabelDeJugadorA(int nuevaVida) {
		this.labelVidaDeJugadorA.setText(Integer.toString(nuevaVida));
	}
	
	public void asignarNuevaVidaALabelDeJugadorB(int nuevaVida) {
		this.labelVidaDeJugadorA.setText(Integer.toString(nuevaVida));
	}

	public void cambiarImagenPor(ImageView nuevaImagenAMostrar) {
		this.imagenAMostrar = nuevaImagenAMostrar;
	}
	
	public void deshabilitarTodosLasVistasCarta() {
		
		this.botonCementerioJugadorA.setDisable(true);
		this.botonCementerioJugadorB.setDisable(true);
		
		this.botonMazoJugadorA.setDisable(true);
		this.botonMazoJugadorB.setDisable(true);
		
		this.vistaCartaDeCampoJugadorA.setDisable(true);
		this.vistaCartaDeCampoJugadorB.setDisable(true);
		
		this.deshabilitarTodasLasVistasDe(this.vistaCartaManoJugadorA);
		this.deshabilitarTodasLasVistasDe(this.vistaCartaManoJugadorB);
		this.deshabilitarTodasLasVistasDe(this.vistaCartaEspecialesJugadorA);
		this.deshabilitarTodasLasVistasDe(this.vistaCartaEspecialesJugadorB);
		this.deshabilitarTodasLasVistasDe(this.vistaCartaMonstruosJugadorA);
		this.deshabilitarTodasLasVistasDe(this.vistaCartaMonstruosJugadorB);		
	}
	

	private void deshabilitarTodasLasVistasDe(ArrayList<? extends VistaCarta> collectionDeVistasCarta) {
		for (VistaCarta vistaCarta : collectionDeVistasCarta) {
			vistaCarta.setDisable(true);
		}
	}

	public void activarSoloLasVistasCartaMonstruosDeJugadorA() {
		this.habilitarTodasLasVistasDe(this.vistaCartaManoJugadorA);
	}

	public void activarSoloLasVistasCartaMonstruosDeJugadorB() {
		this.habilitarTodasLasVistasDe(this.vistaCartaManoJugadorB);		
	}
	
	private void habilitarTodasLasVistasDe(ArrayList<? extends VistaCarta> collectionDeVistasCarta) {
		for (VistaCarta vistaCarta : collectionDeVistasCarta) {
			vistaCarta.setDisable(false);
		}
	}

	
	
	/*
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
	}*/
}