package no.onlevel.deler.gui.controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenyController extends Application{
	
	// ser alltid under resources...
	private static final String MENYSIDE_FXML = "/no/onlevel/deler/gui/meny.fxml";
	private static final String REGISTRER_FXML = "/no/onlevel/deler/gui/registrering.fxml";
	private static final String FINN_FXML = "/no/onlevel/deler/gui/finn.fxml";
	
	public static void main(String[] args) {
		launch(args); // returnerer når applikasjonen avsluttes
	}
	
	@Override
	public void start(Stage forestilling) throws IOException {
		// ForestillingControlleren bytter scener.
		// Den får med hvilke fxml-filer (del-scener) som brukes (i fxml-fila
		// står tilknyttet controller).
		// Logikken i ForestillingController bestemmer hvilken scene det byttes
		// til...

		// fxml: forestilling som inneholder meny+retistrering+finn+rapport+.. som settes sammen som forestilling
		Pane side = lagMeny();		
		Pane innhold = (Pane) side.getChildren().get(1); // 0=meny  1=innhold
		innhold.getChildren().add(lagRegistrering());
		Scene scene = new Scene(side);		
		forestilling.setScene(scene);
		forestilling.show();
	}
	
	@FXML
	private Pane side;
	
	@FXML
	private Pane innhold;
	
	@FXML
	private Button rapporter;	

	@FXML
	private Button registrerInnkjop;

	@FXML
	private Button finnDel;
	
	@FXML
	public void initialize() {
		registrerInnkjop.addEventHandler(MouseEvent.MOUSE_CLICKED, klikkRegistrering);	
		finnDel.addEventHandler(MouseEvent.MOUSE_CLICKED, klikkFinn);
		finnDel.addEventHandler(MouseEvent.MOUSE_CLICKED, klikkRapporter);
				
		Image nyRegistreringIkon = new Image(getClass().getResourceAsStream("/Nyregistrering.png"));		
		registrerInnkjop.setGraphic(new ImageView(nyRegistreringIkon));
		registrerInnkjop.setAlignment(Pos.BOTTOM_LEFT);
	}
	
	/*
	 * Event handlere
	 */
	private EventHandler<MouseEvent> klikkRegistrering = (MouseEvent event) -> {
		innhold.getChildren().clear();		
		innhold.getChildren().add(lagRegistrering());
		
		System.out.println("11");
		event.consume();
	};
	
	private EventHandler<MouseEvent> klikkFinn = (MouseEvent event) -> {
		innhold.getChildren().clear();	
		innhold.getChildren().add(lagFinnDel());
		
		System.out.println("22");
		event.consume();
	};
	
	private EventHandler<MouseEvent> klikkRapporter = (MouseEvent event) -> {
		
		event.consume();
	};
	
	/*
	 * Gui byggeklosser
	 */
	private Pane lagMeny() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenyController.class.getResource(MENYSIDE_FXML));		
		try {
			return  (Pane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private Pane lagRegistrering() {
		FXMLLoader registreringLoader = new FXMLLoader();
		registreringLoader.setLocation(RegistreringController.class.getResource(REGISTRER_FXML));
		try {
			return registreringLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private Pane lagFinnDel() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FinnController.class.getResource(FINN_FXML));
		try {
			return loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
