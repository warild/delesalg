package no.onlevel.deler.gui.fx.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import no.onlevel.deler.gui.controller.AdminController;
import no.onlevel.deler.gui.controller.FinnController;
import no.onlevel.deler.gui.controller.RegistrerKjop;

public class MainController extends Application{
	
	// ser alltid under resources...
	private static final String APP_FXML = "/no/onlevel/deler/gui/fx/main.fxml";
	
	private static final String REGISTRER_FXML = "/no/onlevel/deler/gui/registrerKjop.fxml";
	private static final String FINN_FXML      = "/no/onlevel/deler/gui/finn.fxml";
	private static final String ADMIN_FXML = "/no/onlevel/deler/gui/admin.fxml";
	
	public static void main(String[] args) {
		launch(args); // returnerer når applikasjonen avsluttes
	}
	
	@Override
	public void start(Stage app) throws IOException {
		System.out.println("start 1");

		// fxml: forestilling som inneholder meny+retistrering+finn+rapport+.. som settes sammen som forestilling
				
//		Pane side = lagMeny();
		
		Pane side = null;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainController.class.getResource(APP_FXML));
		// loader.setController(MainController.class);
		try {
			side = (Pane) loader.load(); // kjører .ini
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Pane innhold = (Pane) side.getChildren().get(1); // 0=meny  1=innhold
//		innhold.getChildren().add(lagRegistrering());
		Scene scene = new Scene(side);		
		app.setScene(scene);
		app.show();
	}
	
	@FXML
	private Pane side;
	
	@FXML
	private TabPane app;
	
	@FXML
	private Tab registrerTab;
	@FXML
	private Tab finnTab;	
	@FXML
	private Tab adminTab;	
	
	@FXML
	private Pane innhold;

	@FXML
	private MenuItem vedlikehold;
	@FXML
	private MenuItem varegrupper;
	
	@FXML
	private Button rapporter;	

	@FXML
	private Button registrerInnkjop;

	@FXML
	private Button finnDel;
	
	@FXML
	public void initialize() {
		
		// Innhold i Registrering-tab 
		FXMLLoader registreringLoader = new FXMLLoader();
		FXMLLoader finnLoader = new FXMLLoader();
		FXMLLoader adminLoader = new FXMLLoader();
		registreringLoader.setLocation(RegistrerKjop.class.getResource(REGISTRER_FXML));
		finnLoader.setLocation(FinnController.class.getResource(FINN_FXML));
		adminLoader.setLocation(FinnController.class.getResource(ADMIN_FXML));
		try {			
			Pane registrerPane = registreringLoader.load();
			Pane finnPane = finnLoader.load();
			Pane adminPane = adminLoader.load();
			
			registrerTab.setContent(registrerPane);
			finnTab.setContent(finnPane);
			adminTab.setContent(adminPane);
			
			Image imageNy = new Image("/Nyregistrering.png");
			Image imageFinn = new Image("/Finn.png");
			Image imageAdmin = new Image("/Rapport.png");
			
			registrerTab.setGraphic(new ImageView(imageNy)); 
			finnTab.setGraphic(new ImageView(imageFinn));
			adminTab.setGraphic(new ImageView(imageAdmin));
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		//--
//		registrerInnkjop.addEventHandler(MouseEvent.MOUSE_CLICKED, klikkRegistrering);	
//		finnDel.addEventHandler(MouseEvent.MOUSE_CLICKED, klikkFinn);
//		varegrupper.addEventHandler(ActionEvent.ACTION, klikkVaregrupper);
		
		// Ikoner
//		Image nyRegistreringIkon = new Image(getClass().getResourceAsStream("/Nyregistrering.png"));		
//		registrerInnkjop.setGraphic(new ImageView(nyRegistreringIkon));
//		registrerInnkjop.setAlignment(Pos.BOTTOM_LEFT);
//		
//		Image finnDelIkon = new Image(getClass().getResourceAsStream("/Finn.png"));
//		finnDel.setGraphic(new ImageView(finnDelIkon));
//		
//		finnDel.setAlignment(Pos.BOTTOM_LEFT);
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
	
	private EventHandler<ActionEvent> klikkVaregrupper = (ActionEvent event) -> {
		System.out.println("33");
		Pane side = null;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(AdminController.class.getResource(ADMIN_FXML));		
		try {
			side = (Pane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		Scene scene = new Scene(side);		
		
		Stage stage = new Stage();
		stage.setScene(scene);
        stage.show();

        System.out.println("33s");
		
		event.consume();
	};
	
	/*
	 * Gui byggeklosser
	 */
	private Pane lagMeny() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainController.class.getResource(APP_FXML));	
//		loader.setController(MainController.class);
		try {
			return (Pane) loader.load(); // kjører .ini 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private Pane lagRegistrering() {
		FXMLLoader registreringLoader = new FXMLLoader();
		registreringLoader.setLocation(RegistrerKjop.class.getResource(REGISTRER_FXML));
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
