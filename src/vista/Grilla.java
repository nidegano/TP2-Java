package vista;

import java.io.FileInputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import juego.Jugador;

public class Grilla extends Application {
	
	private Jugador jugador1;
	private Jugador jugador2;
	private ArrayList<BotonCarta> botonesManoJugador1;
	private ArrayList<BotonCarta> botonesManoJugador2;
	
	public Grilla(Jugador jugador1, Jugador jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.botonesManoJugador1 = new ArrayList<BotonCarta>();
		this.botonesManoJugador2 = new ArrayList<BotonCarta>();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Al-Go-Oh!");
		
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		FileInputStream input = new FileInputStream("resources/images/carta_dorso.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setImage(image);

        HBox hbox = new HBox(imageView);

		//JUGADOR 1
        BotonMazo botonJugador1Mazo = new BotonMazo("Mazo");
		botonJugador1Mazo.setMaxSize(100, 200);
		
		BotonCarta botonJugador1Cementerio = new BotonCarta("Cementerio", imageView);
		botonJugador1Cementerio.setMaxSize(100, 200);
		
		BotonCarta botonJugador1Campo = new BotonCarta("Campo", imageView);
		botonJugador1Campo.setMaxSize(100, 200);

		BotonCarta botonJugador1Mano1 = new BotonCarta("Mano 1", imageView);
		BotonCarta botonJugador1Mano2 = new BotonCarta("Mano 2", imageView);
		BotonCarta botonJugador1Mano3 = new BotonCarta("Mano 3", imageView);
		BotonCarta botonJugador1Mano4 = new BotonCarta("Mano 4", imageView);
		BotonCarta botonJugador1Mano5 = new BotonCarta("Mano 5", imageView);
		BotonCarta botonJugador1Mano6 = new BotonCarta("Mano 6", imageView);
		BotonCarta botonJugador1Mano7 = new BotonCarta("Mano 7", imageView);
		botonJugador1Mano1.setMaxSize(100, 200);
		botonJugador1Mano2.setMaxSize(100, 200);
		botonJugador1Mano3.setMaxSize(100, 200);
		botonJugador1Mano4.setMaxSize(100, 200);
		botonJugador1Mano5.setMaxSize(100, 200);
		botonJugador1Mano6.setMaxSize(100, 200);
		botonJugador1Mano7.setMaxSize(100, 200);
		this.botonesManoJugador1.add(botonJugador1Mano1);
		this.botonesManoJugador1.add(botonJugador1Mano2);
		this.botonesManoJugador1.add(botonJugador1Mano3);
		this.botonesManoJugador1.add(botonJugador1Mano4);
		this.botonesManoJugador1.add(botonJugador1Mano5);
		this.botonesManoJugador1.add(botonJugador1Mano6);
		this.botonesManoJugador1.add(botonJugador1Mano7);


		BotonCarta botonJugador1Especial1 = new BotonCarta("Especial 1", imageView);
		BotonCarta botonJugador1Especial2 = new BotonCarta("Especial 2", imageView);
		BotonCarta botonJugador1Especial3 = new BotonCarta("Especial 3", imageView);
		BotonCarta botonJugador1Especial4 = new BotonCarta("Especial 4", imageView);
		BotonCarta botonJugador1Especial5 = new BotonCarta("Especial 5", imageView);
		botonJugador1Especial1.setMaxSize(100, 200);
		botonJugador1Especial2.setMaxSize(100, 200);
		botonJugador1Especial3.setMaxSize(100, 200);
		botonJugador1Especial4.setMaxSize(100, 200);
		botonJugador1Especial5.setMaxSize(100, 200);

		BotonCarta botonJugador1Monstruo1 = new BotonCarta("Monstruo 1", imageView);
		BotonCarta botonJugador1Monstruo2 = new BotonCarta("Monstruo 2", imageView);
		BotonCarta botonJugador1Monstruo3 = new BotonCarta("Monstruo 3", imageView);
		BotonCarta botonJugador1Monstruo4 = new BotonCarta("Monstruo 4", imageView);
		BotonCarta botonJugador1Monstruo5 = new BotonCarta("Monstruo 5", imageView);
		botonJugador1Monstruo1.setMaxSize(100, 200);
		botonJugador1Monstruo2.setMaxSize(100, 200);
		botonJugador1Monstruo3.setMaxSize(100, 200);
		botonJugador1Monstruo4.setMaxSize(100, 200);
		botonJugador1Monstruo5.setMaxSize(100, 200);

		gridPane.add(botonJugador1Mazo, 1, 1, 1, 1);
		gridPane.add(botonJugador1Cementerio, 1, 5, 1, 1);
		gridPane.add(botonJugador1Campo, 9, 5, 1, 1);

		gridPane.add(botonJugador1Mano1, 2, 2, 1, 1);
		gridPane.add(botonJugador1Mano2, 3, 2, 1, 1);
		gridPane.add(botonJugador1Mano3, 4, 2, 1, 1);
		gridPane.add(botonJugador1Mano4, 5, 2, 1, 1);
		gridPane.add(botonJugador1Mano5, 6, 2, 1, 1);
		gridPane.add(botonJugador1Mano6, 7, 2, 1, 1);
		gridPane.add(botonJugador1Mano7, 8, 2, 1, 1);

		gridPane.add(botonJugador1Especial1, 3, 3, 1, 1);
		gridPane.add(botonJugador1Especial2, 4, 3, 1, 1);
		gridPane.add(botonJugador1Especial3, 5, 3, 1, 1);
		gridPane.add(botonJugador1Especial4, 6, 3, 1, 1);
		gridPane.add(botonJugador1Especial5, 7, 3, 1, 1);

		gridPane.add(botonJugador1Monstruo1, 3, 4, 1, 1);
		gridPane.add(botonJugador1Monstruo2, 4, 4, 1, 1);
		gridPane.add(botonJugador1Monstruo3, 5, 4, 1, 1);
		gridPane.add(botonJugador1Monstruo4, 6, 4, 1, 1);
		gridPane.add(botonJugador1Monstruo5, 7, 4, 1, 1);
		

		//JUGADOR 2
		BotonMazo botonJugador2Mazo = new BotonMazo("Mazo");
		botonJugador2Mazo.setMaxSize(100, 200);
		
		BotonCarta botonJugador2Cementerio = new BotonCarta("Cementerio", imageView);
		botonJugador2Cementerio.setMaxSize(100, 200);
		
		BotonCarta botonJugador2Campo = new BotonCarta("Campo", imageView);
		botonJugador2Campo.setMaxSize(100, 200);

		BotonCarta botonJugador2Mano1 = new BotonCarta("Mano 1", imageView);
		BotonCarta botonJugador2Mano2 = new BotonCarta("Mano 2", imageView);
		BotonCarta botonJugador2Mano3 = new BotonCarta("Mano 3", imageView);
		BotonCarta botonJugador2Mano4 = new BotonCarta("Mano 4", imageView);
		BotonCarta botonJugador2Mano5 = new BotonCarta("Mano 5", imageView);
		BotonCarta botonJugador2Mano6 = new BotonCarta("Mano 6", imageView);
		BotonCarta botonJugador2Mano7 = new BotonCarta("Mano 7", imageView);
		botonJugador2Mano1.setMaxSize(100, 200);
		botonJugador2Mano2.setMaxSize(100, 200);
		botonJugador2Mano3.setMaxSize(100, 200);
		botonJugador2Mano4.setMaxSize(100, 200);
		botonJugador2Mano5.setMaxSize(100, 200);
		botonJugador2Mano6.setMaxSize(100, 200);
		botonJugador2Mano7.setMaxSize(100, 200);
		this.botonesManoJugador2.add(botonJugador2Mano1);
		this.botonesManoJugador2.add(botonJugador2Mano2);
		this.botonesManoJugador2.add(botonJugador2Mano3);
		this.botonesManoJugador2.add(botonJugador2Mano4);
		this.botonesManoJugador2.add(botonJugador2Mano5);
		this.botonesManoJugador2.add(botonJugador2Mano6);
		this.botonesManoJugador2.add(botonJugador2Mano7);

		BotonCarta botonJugador2Especial1 = new BotonCarta("Especial 1", imageView);
		BotonCarta botonJugador2Especial2 = new BotonCarta("Especial 2", imageView);
		BotonCarta botonJugador2Especial3 = new BotonCarta("Especial 3", imageView);
		BotonCarta botonJugador2Especial4 = new BotonCarta("Especial 4", imageView);
		BotonCarta botonJugador2Especial5 = new BotonCarta("Especial 5", imageView);
		botonJugador2Especial1.setMaxSize(100, 200);
		botonJugador2Especial2.setMaxSize(100, 200);
		botonJugador2Especial3.setMaxSize(100, 200);
		botonJugador2Especial4.setMaxSize(100, 200);
		botonJugador2Especial5.setMaxSize(100, 200);

		BotonCarta botonJugador2Monstruo1 = new BotonCarta("Monstruo 1", imageView);
		BotonCarta botonJugador2Monstruo2 = new BotonCarta("Monstruo 2", imageView);
		BotonCarta botonJugador2Monstruo3 = new BotonCarta("Monstruo 3", imageView);
		BotonCarta botonJugador2Monstruo4 = new BotonCarta("Monstruo 4", imageView);
		BotonCarta botonJugador2Monstruo5 = new BotonCarta("Monstruo 5", imageView);
		botonJugador2Monstruo1.setMaxSize(100, 200);
		botonJugador2Monstruo2.setMaxSize(100, 200);
		botonJugador2Monstruo3.setMaxSize(100, 200);
		botonJugador2Monstruo4.setMaxSize(100, 200);
		botonJugador2Monstruo5.setMaxSize(100, 200);

		gridPane.add(botonJugador2Mazo, 9, 11, 1, 1);
		gridPane.add(botonJugador2Cementerio, 9, 7, 1, 1);
		gridPane.add(botonJugador2Campo, 1, 7, 1, 1);

		gridPane.add(botonJugador2Mano1, 2, 10, 1, 1);
		gridPane.add(botonJugador2Mano2, 3, 10, 1, 1);
		gridPane.add(botonJugador2Mano3, 4, 10, 1, 1);
		gridPane.add(botonJugador2Mano4, 5, 10, 1, 1);
		gridPane.add(botonJugador2Mano5, 6, 10, 1, 1);
		gridPane.add(botonJugador2Mano6, 7, 10, 1, 1);
		gridPane.add(botonJugador2Mano7, 8, 10, 1, 1);

		gridPane.add(botonJugador2Especial1, 3, 9, 1, 1);
		gridPane.add(botonJugador2Especial2, 4, 9, 1, 1);
		gridPane.add(botonJugador2Especial3, 5, 9, 1, 1);
		gridPane.add(botonJugador2Especial4, 6, 9, 1, 1);
		gridPane.add(botonJugador2Especial5, 7, 9, 1, 1);

		gridPane.add(botonJugador2Monstruo1, 3, 8, 1, 1);
		gridPane.add(botonJugador2Monstruo2, 4, 8, 1, 1);
		gridPane.add(botonJugador2Monstruo3, 5, 8, 1, 1);
		gridPane.add(botonJugador2Monstruo4, 6, 8, 1, 1);
		gridPane.add(botonJugador2Monstruo5, 7, 8, 1, 1);
		
		gridPane.add(hbox, 11, 6, 1, 1);

		this.asignarMano();

		Scene scene = new Scene(gridPane, 1200, 1200);
		primaryStage.setFullScreen(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void asignarMano() {
		int i = 0;
		for (BotonCarta unBoton : this.botonesManoJugador1) {
			unBoton.asignarCarta(this.jugador1.obtenerMano().obtenerCarta(i));
			i ++;
		}
		i = 0;
		for (BotonCarta unBoton : this.botonesManoJugador2) {
			unBoton.asignarCarta(this.jugador2.obtenerMano().obtenerCarta(i));
			i ++;
		}
	}

}
