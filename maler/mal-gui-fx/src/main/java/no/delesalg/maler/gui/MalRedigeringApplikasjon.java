package no.delesalg.maler.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import java.util.Map;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Gui for håndtering av maler. Malene lagre som xml-filer. Enkelt å bytte ut
 * filer.
 *
 */
public class MalRedigeringApplikasjon extends Application {
	public static void main(String[] args) {
		// hent inn data
		launch(MalRedigeringApplikasjon.class, args);
	}

	// observable = observere properties ?? - og sette properties i klassebn i rett kolonne??
    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
                new Person("A", "Z", "a@example.com"),
                new Person("B", "X", "b@example.com"),
                new Person("C", "W", "c@example.com"),
                new Person("D", "Y", "d@example.com"),
                new Person("E", "V", "e@example.com")
            );	
	/*
	 * Stage = window Scene = container: inneholder scener eller controller som
	 * skal vises Node = controller = scene
	 */
	@Override
	// Vindu = Stage
	public void start(Stage stage) throws Exception {

		/*
		 * HBox og VBox - legger ut elementene horisontalt (x-dimensjonen, dvs.
		 * bortover) eller vertikalt (y-dimensjonen, dvs. nedover) og gjør dem
		 * like store i den andre dimensjonen. TilePane - plasserer elementene i
		 * et rutenett, TilePane gjør alle ruten like store GridPane - plasserer
		 * elementene i et rutenett, GridPane er mer fleksibel. BorderPane -
		 * fordeler elementene i regioner, midten (for hovedinnholdet), top,
		 * bunn, venstre og høyre, og passer for hovedinnholdet i applikasjonen.
		 * AnchorPane - henger elementene fast i punkter knyttet til en eller
		 * flere av sidene Pane - generell container uten spesifikk layout, så
		 * posisjonen på elementer må settes manuelt.
		 */

		// 1. opprett alle kontroller

		/*
		 * TableView, TableColumn, and TableCell. You can populate a table by
		 * implementing the data model and by applying a cell factory.
		 */
		
		
		Scene scene = new Scene(new Group());
		stage.setTitle("Table View Sample");
		stage.setWidth(300);
		stage.setHeight(500);

		final Label label = new Label("Adresser");
		label.setFont(new Font("Arial", 20));

		// TABELL:
		// Tabellvisning Klassen som skal vises som rader i <Property>
		TableView<Person> table = new TableView<Person>(); //Ei rad = en Person
		
		// Definer kolonner <objekt, kolonneId>
		TableColumn<Person, String> col_1 = new TableColumn<>("Kolonnetittel_1");
		TableColumn<Person, String> col_2 = new TableColumn<>("Kolonnetittel_2");
		col_1.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		col_2.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		table.getColumns().add(col_1);
		table.getColumns().add(col_2);
		table.setItems(data);
		
		//col_1.setMinWidth(100);
		TableView<List<String>> table2 = new TableView<List<String>>();
		TableColumn<Map, String> c2 = new TableColumn<Map, String>("Kolonnetittel_2");
		c2.setCellValueFactory(new MapValueFactory<String>("Column1MapKey"));
		
		ObservableList<List<String>> tableData;
		// Wrapper for å vise araylist (rad)
		ObservableList<String> generiskRad = FXCollections.observableArrayList(new ArrayList<String>());
		
		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);

		((Group) scene.getRoot()).getChildren().addAll(vbox);
		stage.setScene(scene);
        stage.show();
		
		
	 }
		// ------------------------
		
		
	    public static class Person {
	        private final SimpleStringProperty firstName;
	        private final SimpleStringProperty lastName;
	        private final SimpleStringProperty email;

	        private Person(String fName, String lName, String email) {
	            this.firstName = new SimpleStringProperty(fName);
	            this.lastName = new SimpleStringProperty(lName);
	            this.email = new SimpleStringProperty(email);
	        }

	        public String getFirstName() {
	            return firstName.get();
	        }
	        public void setFirstName(String fName) {
	            firstName.set(fName);
	        }
	       
	        public String getLastName() {
	            return lastName.get();
	        }
	        public void setLastName(String fName) {
	            lastName.set(fName);
	        }
	       
	        public String getEmail() {
	            return email.get();
	        }
	        public void setEmail(String fName) {
	            email.set(fName);
	        }
	       
	    }
	
}