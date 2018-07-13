package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import botones.BotonCementerio;
import botones.BotonFinalizarFase;
import botones.BotonJugadorA;
import botones.BotonJugadorB;
import botones.BotonMazo;
import botones.VistaCartaConcreta;
import cartas.CartaMonstruo;
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
import opcionesQueAlteranAlControladorVisual.Atacar;
import opcionesQueAlteranAlControladorVisual.InvocarEnModoDefensaBocaAbajoConSacrificio;
import opcionesQueAlteranAlControladorVisual.InvocarEnModoDefensaConSacrificio;
import opcionesQueAlteranAlControladorVisual.Listo;
import opcionesQueAlteranALaCarta.CambiarAModoDefensa;
import opcionesQueAlteranALaCarta.CambiarAModoDefensaBocaAbajo;
import opcionesQueAlteranALaCarta.CambiarModoAtaque;
import opcionesQueAlteranALaCarta.ColocarBocaAbajo;
import opcionesQueAlteranALaCarta.ColocarBocaArriba;
import opcionesQueAlteranALaCarta.ColocarCartaDeCampo;
import opcionesQueAlteranALaCarta.Descartar;
import opcionesQueAlteranALaCarta.InvocarEnModoAtaque;
import opcionesQueAlteranAlControladorVisual.InvocarEnModoAtaqueConSacrificio;
import opcionesQueAlteranALaCarta.InvocarEnModoDefensa;
import opcionesQueAlteranALaCarta.InvocarEnModoDefensaBocaAbajo;

public class Grilla extends Application {

	//Grilla en si
	private GridPane gridPane;
	
	//Soporte para mostrar la imagen de la carta seleccionada
	private ImageView imagenAMostrar;
	private ImageView imagenPredeterminada;
	private HBox marcoDeLaImagen;
	
	//Labels
	private Label displayDeTexto;
	private Label labelDeJugadorA;
	private Label labelDeJugadorB;
	private Label labelVidaDeJugadorA;
	private Label labelVidaDeJugadorB;
	private Label labelDeTurno;
	private Label labelDeFase;
	
	//Collections de botones similares de VistaCampoJugadores
	private ArrayList<VistaCartaConcreta> vistaCartaManoJugadorA;
	private ArrayList<VistaCartaConcreta> vistaCartaManoJugadorB;
	private ArrayList<VistaCartaConcreta> vistaCartaEspecialesJugadorA;
	private ArrayList<VistaCartaConcreta> vistaCartaEspecialesJugadorB;
	private ArrayList<VistaCartaConcreta> vistaCartaMonstruosJugadorA;
	private ArrayList<VistaCartaConcreta> vistaCartaMonstruosJugadorB;
	
	//Botones que representan a los jugadores como entidades cliqueables
	private BotonJugadorA botonJugadorA;
	private BotonJugadorB botonJugadorB;
	
	//Botones Cartas de Campo
	private VistaCartaConcreta vistaCartaDeCampoJugadorA;
	private VistaCartaConcreta vistaCartaDeCampoJugadorB;
	
	//Botones Mazo
	private BotonMazo botonMazoJugadorA;
	private BotonMazo botonMazoJugadorB;
	
	//Botones Cementerio
	private BotonCementerio botonCementerioJugadorA;
	private BotonCementerio botonCementerioJugadorB;
	
	//Botones que son propios del juego y no de un Campo especifico de un jugador	
	private BotonFinalizarFase botonDeFinalizarFase;
	private Listo botonDeListo;
	
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
	private InvocarEnModoDefensaConSacrificio opcionInvocarEnModoDefensaConSacrificio;
	private InvocarEnModoDefensaBocaAbajoConSacrificio opcionInvocarEnModoDefensaBocaAbajoConSacrificio;
	
	private Atacar opcionAtacar;
	private Descartar opcionDescartar;

	public Grilla(Jugador jugadorA, Jugador jugadorB, Juego juego,ControladorVisual controladorVisual) throws Exception {

		this.inicializarGridPane();
		
		this.inicializarSoporteParaImagenDeCartaSeleccionada();
		
		this.inicializarLabels();
		
		this.inicializarVistasCartaDeVistaCampoJugadores(controladorVisual);
		
		this.botonJugadorA = new BotonJugadorA(controladorVisual);
		this.botonJugadorB = new BotonJugadorB(controladorVisual);

		this.vistaCartaDeCampoJugadorA = new VistaCartaConcreta(controladorVisual);
		this.vistaCartaDeCampoJugadorB = new VistaCartaConcreta(controladorVisual);

		this.botonMazoJugadorA = new BotonMazo(juego);
		this.botonMazoJugadorB = new BotonMazo(juego);

		this.botonCementerioJugadorA = new BotonCementerio();
		this.botonCementerioJugadorB = new BotonCementerio();

		this.botonDeFinalizarFase = new BotonFinalizarFase(juego);
		this.botonDeListo = new Listo(controladorVisual);

		this.inicializarOpciones(controladorVisual);
		this.agregarBotonesALaGrilla();
		this.configurarBotonesFaseInicioDeJuego();
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Al-Go-Oh!");
		Scene scene = new Scene(this.gridPane, 1200, 1200);
		primaryStage.setFullScreen(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
	
// Inicialziar
	
	private void inicializarOpciones(ControladorVisual controladorVisual) {
		
		this.opcionCambiarAModoAtaque = new CambiarModoAtaque(controladorVisual);
		this.opcionCambiarAModoDefensa = new CambiarAModoDefensa(controladorVisual);
		this.opcionCambiarAModoDefensaBocaAbajo = new CambiarAModoDefensaBocaAbajo(controladorVisual);
		
		this.opcionColocarBocaAbajo = new ColocarBocaAbajo(controladorVisual);
		this.opcionColocarBocaArriba = new ColocarBocaArriba(controladorVisual);
		this.opcionColocarCartaDeCampo = new ColocarCartaDeCampo(controladorVisual);
		
		this.opcionInvocarEnModoAtaque = new InvocarEnModoAtaque(controladorVisual);
		this.opcionInvocarEnModoDefensa = new InvocarEnModoDefensa(controladorVisual);
		this.opcionInvocarEnModoDefensaBocaAbajo = new InvocarEnModoDefensaBocaAbajo(controladorVisual);
		
		this.opcionInvocarEnModoAtaqueConSacrificio = new InvocarEnModoAtaqueConSacrificio(controladorVisual);
		this.opcionInvocarEnModoDefensaConSacrificio = new InvocarEnModoDefensaConSacrificio(controladorVisual);
		this.opcionInvocarEnModoDefensaBocaAbajoConSacrificio = new InvocarEnModoDefensaBocaAbajoConSacrificio(controladorVisual);	
		
		this.opcionAtacar = new Atacar(controladorVisual);
		this.opcionDescartar = new Descartar(controladorVisual);
	}

	private void inicializarVistasCartaDeVistaCampoJugadores(ControladorVisual controladorVisual) {
		
		//Se inicializa la collection de "slots" (Vistas) que se corresponden con la mano
		this.vistaCartaManoJugadorA = new ArrayList<VistaCartaConcreta>();		
		this.vistaCartaManoJugadorA.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaManoJugadorA.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaManoJugadorA.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaManoJugadorA.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaManoJugadorA.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaManoJugadorA.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaManoJugadorA.add(new VistaCartaConcreta(controladorVisual));

		this.vistaCartaManoJugadorB = new ArrayList<VistaCartaConcreta>();		
		this.vistaCartaManoJugadorB.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaManoJugadorB.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaManoJugadorB.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaManoJugadorB.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaManoJugadorB.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaManoJugadorB.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaManoJugadorB.add(new VistaCartaConcreta(controladorVisual));

		//Se inicializa la collection de "slots" (Vistas) que se corresponden con la zona de cartas especiales
		this.vistaCartaEspecialesJugadorA = new ArrayList<VistaCartaConcreta>();
		this.vistaCartaEspecialesJugadorA.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaEspecialesJugadorA.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaEspecialesJugadorA.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaEspecialesJugadorA.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaEspecialesJugadorA.add(new VistaCartaConcreta(controladorVisual));

		this.vistaCartaEspecialesJugadorB = new ArrayList<VistaCartaConcreta>();
		this.vistaCartaEspecialesJugadorB.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaEspecialesJugadorB.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaEspecialesJugadorB.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaEspecialesJugadorB.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaEspecialesJugadorB.add(new VistaCartaConcreta(controladorVisual));

		//Se inicializa la collection de "slots" (Vistas) que se corresponden con la zona de cartas monstruo
		this.vistaCartaMonstruosJugadorA = new ArrayList<VistaCartaConcreta>();
		this.vistaCartaMonstruosJugadorA.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaMonstruosJugadorA.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaMonstruosJugadorA.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaMonstruosJugadorA.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaMonstruosJugadorA.add(new VistaCartaConcreta(controladorVisual));

		this.vistaCartaMonstruosJugadorB = new ArrayList<VistaCartaConcreta>();
		this.vistaCartaMonstruosJugadorB.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaMonstruosJugadorB.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaMonstruosJugadorB.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaMonstruosJugadorB.add(new VistaCartaConcreta(controladorVisual));
		this.vistaCartaMonstruosJugadorB.add(new VistaCartaConcreta(controladorVisual));	
	}

	private void inicializarLabels() {
		this.displayDeTexto = new Label("INFORMACION");
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
		// JUGADOR A
		this.gridPane.add(this.botonMazoJugadorA, 1, 1, 1, 1);
		this.gridPane.add(this.botonCementerioJugadorA, 1, 5, 1, 1);
		this.gridPane.add(this.vistaCartaDeCampoJugadorA, 9, 5, 1, 1);
		this.gridPane.add(this.botonJugadorA, 5, 0,1,1);

		int i = 2;
		for (VistaCartaConcreta unSlot : this.vistaCartaManoJugadorA) {
			this.gridPane.add(unSlot, i, 2, 1, 1);
			i++;
		}

		i = 3;
		for (VistaCartaConcreta unSlot : this.vistaCartaEspecialesJugadorA) {
			this.gridPane.add(unSlot, i, 3, 1, 1);
			i++;
		}

		i = 3;
		for (VistaCartaConcreta unSlot : this.vistaCartaMonstruosJugadorA) {
			this.gridPane.add(unSlot, i, 4, 1, 1);
			i++;
		}

		// JUGADOR B
		this.gridPane.add(this.botonMazoJugadorB, 9, 11, 1, 1);
		this.gridPane.add(this.botonCementerioJugadorB, 9, 7, 1, 1);
		this.gridPane.add(this.vistaCartaDeCampoJugadorB, 1, 7, 1, 1);
		this.gridPane.add(this.botonJugadorB,5, 13,1,1);

		i = 2;
		for (VistaCartaConcreta unSlot : this.vistaCartaManoJugadorB) {
			this.gridPane.add(unSlot, i, 10, 1, 1);
			i++;
		}

		i = 3;
		for (VistaCartaConcreta unSlot : this.vistaCartaEspecialesJugadorB) {
			this.gridPane.add(unSlot, i, 9, 1, 1);
			i++;
		}

		i = 3;
		for (VistaCartaConcreta unSlot : this.vistaCartaMonstruosJugadorB) {
			this.gridPane.add(unSlot, i, 8, 1, 1);
			i++;
		}
		
		//ESTRUCTURA DEL PANEL DE ACCION
		this.gridPane.add(this.labelDeJugadorA, 0, 0, 1, 1);
		this.gridPane.add(this.labelVidaDeJugadorA, 0, 1, 1, 1);
		this.gridPane.add(this.labelDeJugadorB, 0, 12, 1, 1);
		this.gridPane.add(this.labelVidaDeJugadorB, 0, 13, 1, 1);
		this.gridPane.add(this.labelDeTurno, 13, 3, 1, 1);
		this.gridPane.add(this.labelDeFase, 13, 4, 1, 1);

		this.gridPane.add(this.marcoDeLaImagen, 13, 6, 1, 1);
		this.gridPane.add(this.botonDeFinalizarFase, 13, 5, 1, 1);
		this.gridPane.add(this.botonDeListo, 13, 5,1,1);
		
		//Display
		this.gridPane.add(this.displayDeTexto, 5, 6, 1, 1);
		
		//OPCIONES
		this.gridPane.add(this.opcionCambiarAModoAtaque, 13, 7, 1, 1);
		this.gridPane.add(this.opcionCambiarAModoDefensa, 13, 8, 1, 1);
		this.gridPane.add(this.opcionCambiarAModoDefensaBocaAbajo, 13, 9, 1, 1);
		
		this.gridPane.add(this.opcionColocarBocaAbajo, 13, 8, 1, 1);
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
	
	public VistaCartaConcreta obtenerUnLugarVacioParaCartaMonstruoDeJugadorA() {
		for (VistaCartaConcreta lugar : this.vistaCartaMonstruosJugadorA) {
			if(lugar.estaLibre()) {
				return lugar;
			}
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}

	public VistaCartaConcreta obtenerUnLugarVacioParaCartaEspecialDeJugadorA() {
		for (VistaCartaConcreta lugar : this.vistaCartaEspecialesJugadorA) {
			if(lugar.estaLibre()) {
				return lugar;
			}
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}

	public VistaCartaConcreta obtenerUnLugarVacioParaCartaDeCampoDeJugadorA() {
		if(this.vistaCartaDeCampoJugadorA.estaLibre()) {
			return this.vistaCartaDeCampoJugadorA;
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}
	
	public VistaCartaConcreta obtenerUnLugarVacioParaCartaMonstruoDeJugadorB() {
		for (VistaCartaConcreta lugar : this.vistaCartaMonstruosJugadorB) {
			if(lugar.estaLibre()) {
				return lugar;
			}
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}

	public VistaCartaConcreta obtenerUnLugarVacioParaCartaEspecialDeJugadorB() {
		for (VistaCartaConcreta lugar : this.vistaCartaEspecialesJugadorB) {
			if(lugar.estaLibre()) {
				return lugar;
			}
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}

	public VistaCartaConcreta obtenerUnLugarVacioParaCartaDeCampoDeJugadorB() {
		if(this.vistaCartaDeCampoJugadorB.estaLibre()) {
			return this.vistaCartaDeCampoJugadorB;
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}

	public VistaCartaConcreta obtenerUnLugarVacioDeZonaManoJugadorB() {
		for (VistaCartaConcreta lugar : this.vistaCartaManoJugadorB) {
			if(lugar.estaLibre()) {
				return lugar;
			}
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}

	public VistaCartaConcreta obtenerUnLugarVacioDeZonaManoJugadorA() {
		for (VistaCartaConcreta lugar : this.vistaCartaManoJugadorA) {
			if(lugar.estaLibre()) {
				return lugar;
			}
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

	
	
// Configuraciones especificas de botones asociadas a una fase y jugador en turno
	
	public void configurarBotonesFaseInicioDeJuego() {
		this.deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores();
		
		this.marcoDeLaImagen.setDisable(false);
		
		//Labels
		this.labelDeJugadorA.setDisable(false);
		this.labelDeJugadorB.setDisable(false);
		this.labelVidaDeJugadorA.setDisable(false);
		this.labelVidaDeJugadorB.setDisable(false);
		this.labelDeTurno.setDisable(false);
		this.labelDeFase.setDisable(false);
		
		//Botonoes Jugadores
		this.botonJugadorA.setDisable(true);
		this.botonJugadorB.setDisable(true);
		
		//Botones Cementerio
		this.botonCementerioJugadorA.setDisable(true);
		this.botonCementerioJugadorB.setDisable(true);
		
		//Botones que son propios del juego y no de un Campo especifico de un jugador	
		this.botonDeFinalizarFase.setDisable(false);
		this.botonDeListo.setDisable(false);
	}
	
	public void configurarBotonesFaseInicialTunoJugadorB() {
		this.deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores();
		this.botonMazoJugadorB.setDisable(false);
	}

	public void configurarBotonesFaseInicialTunoJugadorA() {
		this.deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores();
		this.botonMazoJugadorA.setDisable(false);
	}

	public void configurarBotonesFasePreparacionTurnoJugadorA() {
		this.deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores();
		this.habilitarTodasLasVistasDe(this.vistaCartaManoJugadorA);
	}

	public void configurarBotonesFasePreparacionTurnoJugadorB() {
		this.deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores();
		this.habilitarTodasLasVistasDe(this.vistaCartaManoJugadorB);
	}

	public void configurarBotonesFaseAtaqueTurnoJugadorA() {
		this.deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores();
		this.habilitarTodasLasVistasNoVaciasDeCartasMonstruoQueNoAtacaron(this.vistaCartaMonstruosJugadorA);
	}

	public void configurarBotonesFaseAtaqueTurnoJugadorB() {
		this.deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores();
		this.habilitarTodasLasVistasNoVaciasDeCartasMonstruoQueNoAtacaron(this.vistaCartaMonstruosJugadorB);
	}

	public void configurarBotonesFaseFinalTurnoJugadorA() {
		this.deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores();
		this.habilitarTodasLasVistasNoVaciasDe(this.vistaCartaEspecialesJugadorA);
	}

	public void configurarBotonesFaseFinalTurnoJugadorB() {
		this.deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores();
		this.habilitarTodasLasVistasNoVaciasDe(this.vistaCartaEspecialesJugadorB);
	}
	
	
	
// Cambios de Estado Interno
	
	public void asignarNuevaVidaALabelDeJugadorA(int nuevaVida) {
		this.labelVidaDeJugadorA.setText(Integer.toString(nuevaVida));
	}
	
	public void asignarNuevaVidaALabelDeJugadorB(int nuevaVida) {
		this.labelVidaDeJugadorB.setText(Integer.toString(nuevaVida));
	}

	public void cambiarImagenPor(ImageView nuevaImagenAMostrar) {
		this.imagenAMostrar.setImage(nuevaImagenAMostrar.getImage());
	}
	
	public void deshabilitarTodosLosBotones() {
		
		this.botonDeFinalizarFase.setDisable(true);
		
		this.botonCementerioJugadorA.setDisable(true);
		this.botonCementerioJugadorB.setDisable(true);
		
		this.botonMazoJugadorA.setDisable(true);
		this.botonMazoJugadorB.setDisable(true);
		
		this.vistaCartaDeCampoJugadorA.setDisable(true);
		this.vistaCartaDeCampoJugadorB.setDisable(true);
		
		this.deshabilitarBotonesQueRepresentanALosJugadores();
		
		this.deshabilitarTodasLasVistasDe(this.vistaCartaManoJugadorA);
		this.deshabilitarTodasLasVistasDe(this.vistaCartaManoJugadorB);
		this.deshabilitarTodasLasVistasDe(this.vistaCartaEspecialesJugadorA);
		this.deshabilitarTodasLasVistasDe(this.vistaCartaEspecialesJugadorB);
		this.deshabilitarTodasLasVistasDe(this.vistaCartaMonstruosJugadorA);
		this.deshabilitarTodasLasVistasDe(this.vistaCartaMonstruosJugadorB);		
	}
	
	public void habilitarLasVistasCartaMonstruoQueNoEstenVaciasDelJugadorA() {
		this.habilitarTodasLasVistasDe(this.vistaCartaMonstruosJugadorA);
		this.deshabilitarTodasLasVistasVaciasDe(this.vistaCartaMonstruosJugadorA);
		if (this.todasLasVistaCartaEstanVacias(this.vistaCartaMonstruosJugadorA)) {
			this.botonJugadorA.setDisable(false);
		}
	}

	public void habilitarLasVistasCartaMonstruoQueNoEstenVaciasDelJugadorB() {
		this.habilitarTodasLasVistasDe(this.vistaCartaMonstruosJugadorB);
		this.deshabilitarTodasLasVistasVaciasDe(this.vistaCartaMonstruosJugadorB);
		if (this.todasLasVistaCartaEstanVacias(this.vistaCartaMonstruosJugadorB)) {
			this.botonJugadorB.setDisable(false);
		}
	}

	public void cambiarLabelDeFasePor(String nombreFaseNueva) {
		this.labelDeFase.setText(nombreFaseNueva);
	}

	public void cambiarLabelDeTurnoActualPor(String nombreJugador) {
		this.labelDeTurno.setText("TURNO: ".concat(nombreJugador));
	}

	public void cambiarLabelDeTextoDisplayPor(String texto) {
		this.displayDeTexto.setText(texto);
	}
	
	public void deshabilitarBotonesQueRepresentanALosJugadores() {
		this.botonJugadorA.setDisable(true);
		this.botonJugadorB.setDisable(true);
	}
	
	
	
// Metodos privados que no son de inicializacion

	private void habilitarTodasLasVistasNoVaciasDeCartasMonstruoQueNoAtacaron(ArrayList<VistaCartaConcreta> collectionDeVistasCarta) {
		for (VistaCartaConcreta vistaCarta : collectionDeVistasCarta) 
			if(!vistaCarta.estaLibre()) {
				if (!((CartaMonstruo) vistaCarta.carta()).yaAtaco()) {
					vistaCarta.setDisable(false);
				}
			}
		}
	
	private void habilitarTodasLasVistasDe(ArrayList<VistaCartaConcreta> collectionDeVistasCarta) {
		for (VistaCartaConcreta vistaCarta : collectionDeVistasCarta) {
			vistaCarta.setDisable(false);
		}
	}
	
	private void deshabilitarTodasLasVistasDe(ArrayList<VistaCartaConcreta> collectionDeVistasCarta) {
		for (VistaCartaConcreta vistaCarta : collectionDeVistasCarta) {
			vistaCarta.setDisable(true);
		}
	}
	
	private void deshabilitarTodasLasVistasVaciasDe(ArrayList<VistaCartaConcreta> collectionDeVistasCarta) {
		for (VistaCartaConcreta vistaCarta : collectionDeVistasCarta) {
			if(vistaCarta.estaLibre()) {
				vistaCarta.setDisable(true);
			}
		}
	}
	
	private void habilitarTodasLasVistasNoVaciasDe(ArrayList<VistaCartaConcreta> collectionDeVistasCarta) {
		for (VistaCartaConcreta vistaCarta : collectionDeVistasCarta) {
			if(!vistaCarta.estaLibre()) {
				vistaCarta.setDisable(false);
			}
		}
	}

	public void deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores() {
		
		//Collections de botones similares de VistaCampoJugadores
		this.deshabilitarTodasLasVistasDe(vistaCartaManoJugadorA);
		this.deshabilitarTodasLasVistasDe(vistaCartaManoJugadorB);
		this.deshabilitarTodasLasVistasDe(vistaCartaEspecialesJugadorA);
		this.deshabilitarTodasLasVistasDe(vistaCartaEspecialesJugadorB);
		this.deshabilitarTodasLasVistasDe(vistaCartaMonstruosJugadorA);
		this.deshabilitarTodasLasVistasDe(vistaCartaMonstruosJugadorB);
		
		//Botones Cartas de Campo
		this.vistaCartaDeCampoJugadorA.setDisable(true);
		this.vistaCartaDeCampoJugadorB.setDisable(true);
		
		//Botones Mazo
		this.botonMazoJugadorA.setDisable(true);
		this.botonMazoJugadorB.setDisable(true);
		
		//Botones Cementerio
		this.botonCementerioJugadorA.setDisable(true);
		this.botonCementerioJugadorB.setDisable(true);
	}

	private boolean todasLasVistaCartaEstanVacias(ArrayList<VistaCartaConcreta> collectionDeVistasCarta) {
		for (VistaCartaConcreta lugar : collectionDeVistasCarta) {
			if (!lugar.estaLibre()) {
				return false;
			}
		}
return true;
	}


	public void habilitarBotonQueRepresentaAlJugador(String nombre) {
		
		if (nombre == this.labelDeJugadorA.getText()) {
			this.botonJugadorA.setDisable(false);
		}
		else {
			this.botonJugadorB.setDisable(false);
		}
	}
}