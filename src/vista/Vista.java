package vista;


import java.util.ArrayList;
import java.io.FileInputStream;
import com.sun.prism.Image;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import juego.Jugador;

public class Vista extends Application {
	
	private GridPane grilla;
	
	private GridPane grillaCampoJugador1;
	private GridPane grillaCampoJugador2;
	
	private Label labelJugador1;
	private Label labelJugador2;
	
	private HBox layoutZonaMonstruosJugador1;
	private HBox layoutZonaCartasEspecialesJugador1;
	private HBox layoutZonaCartasEnManoJugador1;
	private HBox layoutZonaCartaDeCampoJugador1;
	private HBox layoutZonaMazoJugador1;
	private HBox layoutZonaCementerioJugador1;
	
	private HBox layoutZonaMonstruosJugador2;
	private HBox layoutZonaCartasEspecialesJugador2;
	private HBox layoutZonaCartasEnManoJugador2;
	private HBox layoutZonaCartaDeCampoJugador2;
	private HBox layoutZonaMazoJugador2;
	private HBox layoutZonaCementerioJugador2;
	
	private Jugador jugador1;
	private Jugador jugador2;
	
	private ArrayList<BotonMano> botonesCartasEnManoJugador1;
	private ArrayList<BotonCartaEspecial> botonesCartasEspecialesJugador1;
	private ArrayList<BotonCartaMonstruo> botonesCartasMonstruosJugador1;
	private BotonCampo botonCartaCampoJugador1;
	
	private ArrayList<BotonMano> botonesCartasEnManoJugador2;	
	private ArrayList<BotonCartaEspecial> botonesCartasEspecialesJugador2;	
	private ArrayList<BotonCartaMonstruo> botonesCartasMonstruosJugador2;
	private BotonCampo botonCartaCampoJugador2;	
	
	
	public Vista(Jugador jugador1, Jugador jugador2) throws Exception {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		
		this.labelJugador1 = new Label("Jugador1");
		this.labelJugador2 = new Label("Jugador2");
		
		this.grilla = new GridPane();
		this.grilla.setHgap(10);
		this.grilla.setVgap(10);
		
		this.grillaCampoJugador1 = new GridPane();
		this.grillaCampoJugador1.setHgap(10);
		this.grillaCampoJugador1.setVgap(10);
		
		this.grillaCampoJugador2 = new GridPane();
		this.grillaCampoJugador2.setHgap(10);
		this.grillaCampoJugador2.setVgap(10);
		
		this.inicializarCollectionsDeBotones();
		
		this.inicializarLayouts();
		
		this.inicializarGrillaCampoJugador1();
		this.inicializarGrillaCampoJugador2();
		
		this.grilla.add(this.grillaCampoJugador2, 1, 1);
		this.grilla.add(this.grillaCampoJugador1, 1, 3);

		
	}
	
	private void inicializarCollectionsDeBotones() {
		this.botonesCartasEnManoJugador1 = new ArrayList<BotonMano>();
		this.botonesCartasEspecialesJugador1 = new ArrayList<BotonCartaEspecial>();
		this.botonesCartasMonstruosJugador1 = new ArrayList<BotonCartaMonstruo>();
		
		this.botonesCartasEnManoJugador2 = new ArrayList<BotonMano>();
		this.botonesCartasEspecialesJugador2 = new ArrayList<BotonCartaEspecial>();
		this.botonesCartasMonstruosJugador2 = new ArrayList<BotonCartaMonstruo>();
	}

	private void inicializarGrillaCampoJugador2() {
		this.grillaCampoJugador2.add(labelJugador2, 3, 2);
		this.grillaCampoJugador2.add(this.layoutZonaCartaDeCampoJugador2, 3, 3);
		this.grillaCampoJugador2.add(this.layoutZonaCementerioJugador2, 1, 3);
		this.grillaCampoJugador2.add(this.layoutZonaMazoJugador2, 1, 2);
		this.grillaCampoJugador2.add(this.layoutZonaMonstruosJugador2, 2, 3);
		this.grillaCampoJugador2.add(this.layoutZonaCartasEspecialesJugador2, 2, 2);
		this.grillaCampoJugador2.add(this.layoutZonaCartasEnManoJugador2, 2, 1);		
	}

	private void inicializarGrillaCampoJugador1() {
		this.grillaCampoJugador2.add(labelJugador1, 1, 2);
		this.grillaCampoJugador1.add(this.layoutZonaCartaDeCampoJugador1, 1, 1);
		this.grillaCampoJugador1.add(this.layoutZonaCementerioJugador1, 3, 1);
		this.grillaCampoJugador1.add(this.layoutZonaMazoJugador1, 3, 2);
		this.grillaCampoJugador1.add(this.layoutZonaMonstruosJugador1, 2, 1);
		this.grillaCampoJugador1.add(this.layoutZonaCartasEspecialesJugador1, 2, 2);
		this.grillaCampoJugador1.add(this.layoutZonaCartasEnManoJugador1, 2, 3);		
	}

	private void inicializarLayouts() {
		
		FileInputStream input = new FileInputStream("resources/images/espacio_blanco.png");
		Image imagenDeEspacioEnBlanco = new Image(input);
		ImageView espacioEnBlanco = new ImageView(imagenDeEspacioEnBlanco);
		
		this.layoutZonaMonstruosJugador1 = new HBox();
		this.layoutZonaCartasEspecialesJugador1 = new HBox();
		this.layoutZonaCartasEnManoJugador1 = new HBox();
		this.layoutZonaCartaDeCampoJugador1 = new HBox();
		this.layoutZonaMazoJugador1 = new HBox();
		this.layoutZonaCementerioJugador1 = new HBox();
		
		this.layoutZonaMonstruosJugador2 = new HBox();
		this.layoutZonaCartasEspecialesJugador2 = new HBox();
		this.layoutZonaCartasEnManoJugador2 = new HBox();
		this.layoutZonaCartaDeCampoJugador2 = new HBox();
		this.layoutZonaMazoJugador2 = new HBox();
		this.layoutZonaCementerioJugador2 = new HBox();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Al-Go-Oh!");

		Scene scene = new Scene(this.grilla, 1200, 1200);
		primaryStage.setFullScreen(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/*private void agregarBotonesALaGrilla() {
		//JUGADOR 1
		this.grilla.add(this.botonMazoJugador1, 1, 1, 1, 1);
		this.grilla.add(this.botonCementerioJugador1, 1, 5, 1, 1);
		this.grilla.add(this.botonCartaCampoJugador1, 9, 5, 1, 1);

		int i = 2;
		for (BotonMano unBoton : this.botonesCartasEnManoJugador1) {
			this.grilla.add(unBoton, i, 2, 1, 1);
			i ++;
		}
		
		i = 3;
		for (BotonCartaEspecial unBoton : this.botonesCartasEspecialesJugador1) {
			this.grilla.add(unBoton, i, 3, 1, 1);
			i ++;
		}
	
		i = 3;
		for (BotonCartaMonstruo unBoton : this.botonesCartasMonstruosJugador1) {
			this.grilla.add(unBoton, i, 4, 1, 1);
			i ++;
		}

		//JUGADOR 2
		this.grilla.add(this.botonMazoJugador2, 9, 11, 1, 1);
		this.grilla.add(this.botonCementerioJugador2, 9, 7, 1, 1);
		this.grilla.add(this.botonCartaCampoJugador2, 1, 7, 1, 1);
		
		i = 2;
		for (BotonMano unBoton : this.botonesCartasEnManoJugador2) {
			this.grilla.add(unBoton, i, 10, 1, 1);
			i ++;
		}

		i = 3;
		for (BotonCartaEspecial unBoton : this.botonesCartasEspecialesJugador2) {
			this.grilla.add(unBoton, i, 9, 1, 1);
			i ++;
		}
		
		i = 3;
		for (BotonCartaMonstruo unBoton : this.botonesCartasMonstruosJugador2) {
			this.grilla.add(unBoton, i, 8, 1, 1);
			i ++;
		}
		
		// PANEL DE ACCION
		this.grilla.add(this.labelJugador1, 0, 0, 1, 1);
		this.grilla.add(this.labelJugador2, 0, 12, 1, 1);

		this.grilla.add(this.hbox, 13, 6, 1, 1);

		this.grilla.add(this.botonInvocar, 13, 7, 1, 1);
		this.grilla.add(this.botonSacrificar, 13, 8, 1, 1);

		this.grilla.add(this.botonAtacar, 13, 7, 1, 1);
		this.grilla.add(this.botonCambioModoAtaque, 13, 8, 1, 1);
		this.grilla.add(this.botonCambioModoDefensa, 13, 9, 1, 1);

	}*/

	/*private void asignarMano() {
		int i = 0;
		for (BotonMano unBoton : this.botonesCartasEnManoJugador1) {
			unBoton.asignarCarta(this.jugador1.obtenerMano().obtenerCarta(i), this);
			i ++;
		}
		i = 0;
		for (BotonMano unBoton : this.botonesCartasEnManoJugador2) {
			unBoton.asignarCarta(this.jugador2.obtenerMano().obtenerCarta(i), this);
			i ++;
		}
	}*/

	/*public void actualizarGrillaPorSeleccionDeCartaDeMano(Carta unaCarta) {
		this.botonInvocar.setVisible(true);
		this.botonSacrificar.setVisible(true);
		this.botonAtacar.setVisible(false);
		this.botonCambioModoAtaque.setVisible(false);
		this.botonCambioModoDefensa.setVisible(false);
		this.botonInvocar.asignarCarta(unaCarta, this);
	}
	
	public void actualizarGrillaPorSeleccionDeCartaMonstruo() {
		this.botonAtacar.setVisible(true);
		this.botonCambioModoAtaque.setVisible(true);
		this.botonCambioModoDefensa.setVisible(true);
		this.botonInvocar.setVisible(false);
		this.botonSacrificar.setVisible(false);
	}

	public void actualizarGrillaPorInvocacionDeMonstruo(Carta unaCarta) {
		this.botonAtacar.setVisible(false);
		this.botonCambioModoAtaque.setVisible(false);
		this.botonCambioModoDefensa.setVisible(false);
		this.botonInvocar.setVisible(false);
		this.botonSacrificar.setVisible(false);
		
		BotonMano unBotonMano = this.obtenerBotonDeCarta(unaCarta,this.botonesCartasEnManoJugador1);
		unBotonMano.limpiar();

		// Tiene que ser un this.botonesCartasMonstruoJugadorX.obtenerBotonLibre()
		BotonCartaMonstruo unBotonCartaMonstruo = this.botonesCartasMonstruosJugador1.get(0);

		unBotonCartaMonstruo.asignarCarta(unaCarta, this);
	}

	private BotonMano obtenerBotonDeCarta(Carta unaCarta, ArrayList<BotonMano> botones) {
		for (BotonMano unBoton : botones) {
			if (unBoton.obtenerCarta().equals(unaCarta))
				return unBoton;
		}
		return null;
	}*/

}
