package no.onlevel.deler.gui.controller;
        

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * //https://blogs.oracle.com/acaicedo/entry/managing_multiple_screens_in_javafx1
 *
 */
public class FinnController {



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
	private Label temaTittel;

	@FXML
	private Label vv;

	@FXML
	private TreeView<TreeItemInnkommet> varetyper;

	@FXML
	private TableView<Egenskap> selgerTabell ;

	@FXML
	private Label testLabel;

	


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
