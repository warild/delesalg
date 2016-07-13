package no.onlevel.deler.gui.controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import no.onlevel.deler.gui.fx.main.MainController;

public class ForestillingController extends Application {

	// ser alltid under resources...
	private static final String MENY_FXML = "/no/onlevel/deler/gui/meny.fxml";
	private static final String REGISTRERING_FXML = "/no/onlevel/deler/gui/registrering.fxml";

	private Scene scene;
	
	public static void main(String[] args) {
		launch(args); // returnerer når applikasjonen avsluttes
	}

	// 1: start()
	// 2: fra start kall registrering() eller kall Finn() eller Rapport()
	// 3: registrering() setter sammen sida. Enten ved å kalle ei fxml-fil eller
	// ved å kalle to .fxml-sider og sette dem sammen
	// registreringController kan kun returnere en pane med sitt innhold.
	// admin kan bruke..
	// forestillingController holder orden på sidene. registrering returnere kun
	// sin gui

	/**
	 * .init() kjøres før .start()
	 * @throws IOException 
	 */
	@Override
	public void start(Stage forestilling) throws IOException {
		// ForestillingControlleren bytter scener.
		// Den får med hvilke fxml-filer (del-scener) som brukes (i fxml-fila
		// står tilknyttet controller).
		// Logikken i ForestillingController bestemmer hvilken scene det byttes
		// til...

		// fxml: forestilling som inneholder meny+retistrering+finn+rapport+.. som settes sammen som forestilling

		meny = lagMeny();
		meny.getChildren().add(lagRegistrering());
		
		scene = new Scene(meny);		
		forestilling.setScene(scene);
		forestilling.show();
	}
	
	private Pane lagMeny() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainController.class.getResource(MENY_FXML));		
		return  (Pane) loader.load();
	}

	private Pane lagRegistrering() throws IOException {
		FXMLLoader registreringLoader = new FXMLLoader();
		registreringLoader.setLocation(RegistrerKjop.class.getResource(REGISTRERING_FXML));
		return registreringLoader.load();
	}
	

	
	
	@FXML
	private Pane meny;

	@FXML
	private Pane registrering;	

	
	@FXML
	public void initialize() {

	}
}
