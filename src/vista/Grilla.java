package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import botones.BotonCementerio;
import botones.BotonFinalizarFase;
import botones.BotonMazo;
import botones.VistaCarta;
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
import opciones.InvocarEnModoDefensaBocaAbajoConSacrificio;
import opciones.InvocarEnModoDefensaConSacrificio;
import opciones.Listo;
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
	private ArrayList<VistaCarta> vistaCartaManoJugadorA;
	private ArrayList<VistaCarta> vistaCartaManoJugadorB;
	private ArrayList<VistaCarta> vistaCartaEspecialesJugadorA;
	private ArrayList<VistaCarta> vistaCartaEspecialesJugadorB;
	private ArrayList<VistaCarta> vistaCartaMonstruosJugadorA;
	private ArrayList<VistaCarta> vistaCartaMonstruosJugadorB;
	
	//Botones Cartas de Campo
	private VistaCarta vistaCartaDeCampoJugadorA;
	private VistaCarta vistaCartaDeCampoJugadorB;
	
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

	public Grilla(JugadorA jugadorA, JugadorB jugadorB, Juego juego,Vista vista) throws Exception {

		this.inicializarGridPane();
		
		this.inicializarSoporteParaImagenDeCartaSeleccionada();
		
		this.inicializarLabels();
		
		this.inicializarVistasCartaDeVistaCampoJugadores(vista);

		this.vistaCartaDeCampoJugadorA = new VistaCarta(vista);
		this.vistaCartaDeCampoJugadorB = new VistaCarta(vista);

		this.botonMazoJugadorA = new BotonMazo(juego);
		this.botonMazoJugadorB = new BotonMazo(juego);

		this.botonCementerioJugadorA = new BotonCementerio();
		this.botonCementerioJugadorB = new BotonCementerio();

		this.botonDeFinalizarFase = new BotonFinalizarFase(juego);
		this.botonDeListo = new Listo(vista);

		this.inicializarOpciones(vista);
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
		this.opcionInvocarEnModoDefensaConSacrificio = new InvocarEnModoDefensaConSacrificio(vista);
		this.opcionInvocarEnModoDefensaBocaAbajoConSacrificio = new InvocarEnModoDefensaBocaAbajoConSacrificio(vista);	
		
		this.opcionAtacar = new Atacar(vista);
		this.opcionDescartar = new Descartar(vista);
	}

	private void inicializarVistasCartaDeVistaCampoJugadores(Vista vista) {
		
		//Se inicializa la collection de "slots" (Vistas) que se corresponden con la mano
		this.vistaCartaManoJugadorA = new ArrayList<VistaCarta>();		
		this.vistaCartaManoJugadorA.add(new VistaCarta(vista));
		this.vistaCartaManoJugadorA.add(new VistaCarta(vista));
		this.vistaCartaManoJugadorA.add(new VistaCarta(vista));
		this.vistaCartaManoJugadorA.add(new VistaCarta(vista));
		this.vistaCartaManoJugadorA.add(new VistaCarta(vista));
		this.vistaCartaManoJugadorA.add(new VistaCarta(vista));
		this.vistaCartaManoJugadorA.add(new VistaCarta(vista));

		this.vistaCartaManoJugadorB = new ArrayList<VistaCarta>();		
		this.vistaCartaManoJugadorB.add(new VistaCarta(vista));
		this.vistaCartaManoJugadorB.add(new VistaCarta(vista));
		this.vistaCartaManoJugadorB.add(new VistaCarta(vista));
		this.vistaCartaManoJugadorB.add(new VistaCarta(vista));
		this.vistaCartaManoJugadorB.add(new VistaCarta(vista));
		this.vistaCartaManoJugadorB.add(new VistaCarta(vista));
		this.vistaCartaManoJugadorB.add(new VistaCarta(vista));

		//Se inicializa la collection de "slots" (Vistas) que se corresponden con la zona de cartas especiales
		this.vistaCartaEspecialesJugadorA = new ArrayList<VistaCarta>();
		this.vistaCartaEspecialesJugadorA.add(new VistaCarta(vista));
		this.vistaCartaEspecialesJugadorA.add(new VistaCarta(vista));
		this.vistaCartaEspecialesJugadorA.add(new VistaCarta(vista));
		this.vistaCartaEspecialesJugadorA.add(new VistaCarta(vista));
		this.vistaCartaEspecialesJugadorA.add(new VistaCarta(vista));

		this.vistaCartaEspecialesJugadorB = new ArrayList<VistaCarta>();
		this.vistaCartaEspecialesJugadorB.add(new VistaCarta(vista));
		this.vistaCartaEspecialesJugadorB.add(new VistaCarta(vista));
		this.vistaCartaEspecialesJugadorB.add(new VistaCarta(vista));
		this.vistaCartaEspecialesJugadorB.add(new VistaCarta(vista));
		this.vistaCartaEspecialesJugadorB.add(new VistaCarta(vista));

		//Se inicializa la collection de "slots" (Vistas) que se corresponden con la zona de cartas monstruo
		this.vistaCartaMonstruosJugadorA = new ArrayList<VistaCarta>();
		this.vistaCartaMonstruosJugadorA.add(new VistaCarta(vista));
		this.vistaCartaMonstruosJugadorA.add(new VistaCarta(vista));
		this.vistaCartaMonstruosJugadorA.add(new VistaCarta(vista));
		this.vistaCartaMonstruosJugadorA.add(new VistaCarta(vista));
		this.vistaCartaMonstruosJugadorA.add(new VistaCarta(vista));

		this.vistaCartaMonstruosJugadorB = new ArrayList<VistaCarta>();
		this.vistaCartaMonstruosJugadorB.add(new VistaCarta(vista));
		this.vistaCartaMonstruosJugadorB.add(new VistaCarta(vista));
		this.vistaCartaMonstruosJugadorB.add(new VistaCarta(vista));
		this.vistaCartaMonstruosJugadorB.add(new VistaCarta(vista));
		this.vistaCartaMonstruosJugadorB.add(new VistaCarta(vista));	
	}

	private void inicializarLabels() {
		this.displayDeTexto = new Label("");
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

		int i = 2;
		for (VistaCarta unSlot : this.vistaCartaManoJugadorA) {
			this.gridPane.add(unSlot, i, 2, 1, 1);
			i++;
		}

		i = 3;
		for (VistaCarta unSlot : this.vistaCartaEspecialesJugadorA) {
			this.gridPane.add(unSlot, i, 3, 1, 1);
			i++;
		}

		i = 3;
		for (VistaCarta unSlot : this.vistaCartaMonstruosJugadorA) {
			this.gridPane.add(unSlot, i, 4, 1, 1);
			i++;
		}

		// JUGADOR B
		this.gridPane.add(this.botonMazoJugadorB, 9, 11, 1, 1);
		this.gridPane.add(this.botonCementerioJugadorB, 9, 7, 1, 1);
		this.gridPane.add(this.vistaCartaDeCampoJugadorB, 1, 7, 1, 1);

		i = 2;
		for (VistaCarta unSlot : this.vistaCartaManoJugadorB) {
			this.gridPane.add(unSlot, i, 10, 1, 1);
			i++;
		}

		i = 3;
		for (VistaCarta unSlot : this.vistaCartaEspecialesJugadorB) {
			this.gridPane.add(unSlot, i, 9, 1, 1);
			i++;
		}

		i = 3;
		for (VistaCarta unSlot : this.vistaCartaMonstruosJugadorB) {
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
		this.gridPane.add(this.displayDeTexto, 1, 2, 1, 1);
		
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
		for (VistaCarta lugar : this.vistaCartaMonstruosJugadorA) {
			if(lugar.estaLibre()) {
				return lugar;
			}
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}

	public VistaCarta obtenerUnLugarVacioParaCartaEspecialDeJugadorA() {
		for (VistaCarta lugar : this.vistaCartaEspecialesJugadorA) {
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
		for (VistaCarta lugar : this.vistaCartaMonstruosJugadorB) {
			if(lugar.estaLibre()) {
				return lugar;
			}
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}

	public VistaCarta obtenerUnLugarVacioParaCartaEspecialDeJugadorB() {
		for (VistaCarta lugar : this.vistaCartaEspecialesJugadorB) {
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

	public VistaCarta obtenerUnLugarVacioDeZonaManoJugadorB() {
		for (VistaCarta lugar : this.vistaCartaManoJugadorB) {
			if(lugar.estaLibre()) {
				return lugar;
			}
		}
		return null;
		//Si se llega a ejecutar este metodo es porque se chequeo que habia al menos un slot libre
	}

	public VistaCarta obtenerUnLugarVacioDeZonaManoJugadorA() {
		for (VistaCarta lugar : this.vistaCartaManoJugadorA) {
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
		
		//Botones Cementerio
		this.botonCementerioJugadorA.setDisable(true);
		this.botonCementerioJugadorB.setDisable(true);
		
		//Botones que son propios del juego y no de un Campo especifico de un jugador	
		this.botonDeFinalizarFase.setDisable(false);
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
		this.habilitarTodasLasVistasDe(this.vistaCartaMonstruosJugadorA);
	}

	public void configurarBotonesFaseAtaqueTurnoJugadorB() {
		this.deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores();
		this.habilitarTodasLasVistasDe(this.vistaCartaMonstruosJugadorB);
	}

	public void configurarBotonesFaseFinalTurnoJugadorA() {
		this.deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores();
		this.habilitarTodasLasVistasDe(this.vistaCartaEspecialesJugadorA);
	}

	public void configurarBotonesFaseFinalTurnoJugadorB() {
		this.deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores();
		this.habilitarTodasLasVistasDe(this.vistaCartaEspecialesJugadorB);
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
	
	public void activarSoloLasVistasCartaMonstruosDeJugadorA() {
		this.habilitarTodasLasVistasDe(this.vistaCartaMonstruosJugadorA);
	}

	public void activarSoloLasVistasCartaMonstruosDeJugadorB() {
		this.habilitarTodasLasVistasDe(this.vistaCartaMonstruosJugadorB);		
	}

	public void cambiarLabelDeFasePor(String nombreFaseNueva) {
		this.labelDeFase.setText(nombreFaseNueva);
	}

	public void cambiarLabelDeTurnoActualPorJugadorA() {
		this.labelDeTurno.setText("TURNO: ".concat(this.labelDeJugadorA.getText()));
	}
	
	public void cambiarLabelDeTurnoActualPorJugadorB() {
		this.labelDeTurno.setText("TURNO: ".concat(this.labelDeJugadorB.getText()));
	}

	public void cambiarLabelDeTextoDisplayPor(String texto) {
		this.displayDeTexto.setText(texto);
	}
	
	
	
// Metodos privados que no son de inicializacion
	
	private void habilitarTodasLasVistasDe(ArrayList<VistaCarta> collectionDeVistasCarta) {
		for (VistaCarta vistaCarta : collectionDeVistasCarta) {
			vistaCarta.setDisable(false);
		}
	}
	
	private void deshabilitarTodasLasVistasDe(ArrayList<VistaCarta> collectionDeVistasCarta) {
		for (VistaCarta vistaCarta : collectionDeVistasCarta) {
			vistaCarta.setDisable(true);
		}
	}

	private void deshabilitarTodosLosBotonesAsociadosAVistaCampoJugadores() {
		
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



}