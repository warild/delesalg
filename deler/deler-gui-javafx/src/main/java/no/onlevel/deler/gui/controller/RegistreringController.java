package no.onlevel.deler.gui.controller;
        

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.onlevel.deler.facade.DelerFacade;
import no.onlevel.deler.gui.controller.TableViewSample.Person;
import no.onlevel.deler.gui.controller.TreeTableViewSample.Employee;

/**
 * //https://blogs.oracle.com/acaicedo/entry/managing_multiple_screens_in_javafx1
 *
 */
public class RegistreringController extends Application {

	//main
	// ser alltid under resources...
	private static final String FXML = "/no/onlevel/deler/gui/registrering.fxml"; 
	
	public static void main(String[] args) {
		launch(args); // returnerer når applikasjonen avsluttes
	}

	
//	private Stage primaryStage;
	
	// setup
	@Override
	public void start(Stage forestilling) {
		// .init() kjøres før .start()

		FXMLLoader sceneLoader = new FXMLLoader();
		sceneLoader.setLocation(RegistreringController.class.getResource(FXML));
		try {
			deleSalg = (Pane) sceneLoader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		// Show the scene containing the layout.

//		this.primaryStage = forestilling;
//		this.primaryStage.setTitle("Deler");

		forestilling.setScene(new Scene(deleSalg));
		forestilling.show();

		// Spring
		// ApplicationContext context = new
		// AnnotationConfigApplicationContext(CustomerAppConfiguration.class);
		// ScreensConfiguration screens =
		// context.getBean(ScreensConfiguration.class);
		// screens.setPrimaryStage(stage);
		// screens.loginDialog().show();
	}

	// @FXML knytter controller i .fxml-fila til variabler i controller
	// Dermed er controller knyttet tett på gui og kontroller kan gjøre mye
	// gui-relatert....

	// Fx bruker fx:id for å kalle metode i controller.
	// Controller bruker id for å sette verdi i fx.
	
	@FXML
	private VBox menypanel;
	
	@FXML
	private Pane deleSalg;

	@FXML
	private Button registrerInnkjopKnapp;

	@FXML
	private Button sokDel;

	@FXML
	private Button registrerSalg;

	@FXML
	private Label temaTittel;

	@FXML
	private Label vv;

	@FXML
	private TreeView<TreeItemInnkommet> varetyper;

	@FXML
	private TableView<Egenskap> selgerTabell ;

	@FXML
	private Label testLabel;

	
	@Override
	public void init() {
		// start db
	}

	@Override
	public void stop() {
		// stop db
	}

	// populate
	@FXML
	public void initialize() {
		
		

		
		
		varetyper.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);

		TreeItem<TreeItemInnkommet> root = new TreeItem<TreeItemInnkommet>(new TreeItemInnkommet("id1", "Velg en vare"));
		root.getValue();
		varetyper.setRoot(root);
		varetyper.setShowRoot(false);
		root.setExpanded(true);

		TreeItem<TreeItemInnkommet> rootItemA = new TreeItem<>(new TreeItemInnkommet("id2", "Kjøretøy"));
		TreeItem<TreeItemInnkommet> itemA1 = new TreeItem<>(new TreeItemInnkommet("id3", "Lastebil"));
		TreeItem<TreeItemInnkommet> itemA2 = new TreeItem<>(new TreeItemInnkommet("id3", "Traktor"));
		TreeItem<TreeItemInnkommet> itemA3 = new TreeItem<>(new TreeItemInnkommet("id3", "Buss"));

		TreeItem<TreeItemInnkommet> rootItemB = new TreeItem<>(new TreeItemInnkommet("id3", "Påbygg"));
		TreeItem<TreeItemInnkommet> itemB1 = new TreeItem<>(new TreeItemInnkommet("id3", "Lasteplan"));
		TreeItem<TreeItemInnkommet> itemB2 = new TreeItem<>(new TreeItemInnkommet("id3", "Kran"));
		TreeItem<TreeItemInnkommet> itemB3 = new TreeItem<>(new TreeItemInnkommet("id3", "Hengerfeste"));

		TreeItem<TreeItemInnkommet> rootItemC = new TreeItem<>(new TreeItemInnkommet("id3", "Deler til lastebil"));
		TreeItem<TreeItemInnkommet> itemC1 = new TreeItem<>(new TreeItemInnkommet("id3", "Volvo"));
		TreeItem<TreeItemInnkommet> itemC11 = new TreeItem<>(new TreeItemInnkommet("id4", "Gearkasse"));
		
		
		TreeItem<TreeItemInnkommet> itemC2 = new TreeItem<>(new TreeItemInnkommet("id3", "Scania"));

		TreeItem<TreeItemInnkommet> rootItemD = new TreeItem<>(new TreeItemInnkommet("id3", "Partivarer"));
		rootItemA.getChildren().add(itemA1);
		rootItemA.getChildren().add(itemA2);
		rootItemA.getChildren().add(itemA3);
		rootItemB.getChildren().add(itemB1);
		rootItemB.getChildren().add(itemB2);
		rootItemB.getChildren().add(itemB3);
		rootItemC.getChildren().add(itemC1);
		itemC1.getChildren().add(itemC11);
		rootItemC.getChildren().add(itemC2);
		rootItemA.setExpanded(true);
		rootItemB.setExpanded(true);
		rootItemC.setExpanded(true);
		rootItemD.setExpanded(false);
		varetyper.getRoot().getChildren().add(rootItemA);
		varetyper.getRoot().getChildren().add(rootItemB);
		varetyper.getRoot().getChildren().add(rootItemC);
		varetyper.getRoot().getChildren().add(rootItemD);

		
	    ObservableList<Egenskap> data =
	            FXCollections.observableArrayList(
	                new Egenskap("Navn", "Joe Smith"),
	                new Egenskap("Gate/vei", "Havnegt 2"),
	                new Egenskap("Post", "0202 Oslo"),
	                new Egenskap("Tlf", "2222 3333")
	            );
		
	    selgerTabell.setEditable(true);
        
        TableColumn<Egenskap, String> selgerType = new TableColumn<Egenskap, String>("Egenskap");
        TableColumn<Egenskap,String>  selgerVerdi = new TableColumn<Egenskap,String> ("Tekst");
        selgerType.setMinWidth(150);
        selgerVerdi.setMinWidth(153);
        selgerVerdi.setEditable(true);

        selgerType.setCellValueFactory(new PropertyValueFactory<Egenskap, String>("navn"));
        PropertyValueFactory<Egenskap, String> propFactory = new PropertyValueFactory<Egenskap, String>("verdi");        
        selgerVerdi.setCellValueFactory(propFactory);
 
 
        selgerTabell.setItems(data); 
        selgerTabell.getColumns().add(selgerType);
        selgerTabell.getColumns().add(selgerVerdi);
        
//		egenskaperTabell.getSelectionModel().setCellSelectionEnabled(true);
//		egenskaperTabell.setEditable(true);

		//--
		 // create the tree model
		 CheckBoxTreeItem<String> jonathanGiles = new CheckBoxTreeItem<String>("Motor");
		 CheckBoxTreeItem<String> juliaGiles = new CheckBoxTreeItem<String>("Gearkasse");
		 CheckBoxTreeItem<String> mattGiles = new CheckBoxTreeItem<String>("Mellomaksel");
		 CheckBoxTreeItem<String> sueGiles = new CheckBoxTreeItem<String>("Kardang");
		 TreeItem<String> gilesFamily = new CheckBoxTreeItem<String>("Drivlinje");
		 gilesFamily.setExpanded(true);
		 gilesFamily.getChildren().addAll(jonathanGiles, juliaGiles, mattGiles, sueGiles);
		 
		 CheckBoxTreeItem<String> hytte = new CheckBoxTreeItem<String>("Hytte");
		 CheckBoxTreeItem<String> plan = new CheckBoxTreeItem<String>("Plan");
		 CheckBoxTreeItem<String> kasse = new CheckBoxTreeItem<String>("Kasse");
		 CheckBoxTreeItem<String> aggregeat = new CheckBoxTreeItem<String>("Kjøleaggregat");
		 TreeItem<String> paabygg = new CheckBoxTreeItem<String>("Påbygg");
		 paabygg.setExpanded(true);
		 paabygg.getChildren().addAll(hytte, plan, kasse, aggregeat);
		 
		 
		 // create the treeView		 
		 //checkboxtreeView = new TreeView<String>();
//		 checkboxTreeView.setRoot(new TreeItem<String>("Lastebil"));
//		 checkboxTreeView.getRoot().setExpanded(true);
//		 checkboxTreeView.setShowRoot(false);;
//		 checkboxTreeView.getRoot().getChildren().add(gilesFamily);
//		 checkboxTreeView.getRoot().getChildren().add(paabygg);		       
//		 // set the cell factory
//		 checkboxTreeView.setCellFactory(CheckBoxTreeCell.<String>forTreeView());

	}

	private EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
		System.out.println(varetyper.getSelectionModel()
				.selectedIndexProperty().toString());

		testLabel.setText(varetyper.getSelectionModel().getSelectedItem()
				.getValue().getNavn());
		// Vis tabell med input:

	};

	@FXML
	public void registrerInnkjop(ActionEvent a) {
		registrerInnkjopKnapp.setTooltip(new Tooltip("Tooltipppp"));
		temaTittel.setText("Test---");
		System.out.println("console OP");

	}

	//------
    public static class Egenskap {
    	 
        private final SimpleStringProperty navn;
        private final SimpleStringProperty verdi;

        private Egenskap(String navn, String verdi) {
            this.navn = new SimpleStringProperty(navn);
            this.verdi = new SimpleStringProperty(verdi);
        }

		public String getNavn() {
			return navn.get();
		}

		public String getVerdi() {
			return verdi.get();
		}
		public void setVerdi(String verdi) {
			this.verdi.set(verdi);
		}

 
    }
}
