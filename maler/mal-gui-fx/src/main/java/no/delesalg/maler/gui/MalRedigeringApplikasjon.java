package no.delesalg.maler.gui;

import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
/** 
 * Gui for håndtering av maler. Malene lagre som xml-filer. Enkelt å bytte ut filer.
 *
 */
public class MalRedigeringApplikasjon extends Application {
	public static void main(String[] args) {
		launch(MalRedigeringApplikasjon.class, args);		
	}


    
    private final Node rootIcon = new ImageView();

        List<Employee> employees = Arrays.<Employee>asList(
                new Employee("Ethan Williams", "Sales Department"),
                new Employee("Emma Jones", "Sales Department"),
                new Employee("Michael Brown", "Sales Department"),
                new Employee("Anna Black", "Sales Department"),
                new Employee("Rodger York", "Sales Department"),
                new Employee("Susan Collins", "Sales Department"),
                new Employee("Mike Graham", "IT Support"),
                new Employee("Judy Mayer", "IT Support"),
                new Employee("Gregory Smith", "IT Support"),
                new Employee("Jacob Smith", "Accounts Department"),
                new Employee("Isabella Johnson", "Accounts Department"));
        TreeItem<String> rootNode = 
            new TreeItem<String>("MyCompany Human Resources", rootIcon);

        
      /* 
       * Stage = window
       * Scene = container: inneholder scener eller controller som skal vises
       * Node = controller = scene
       * 
  HBox og VBox - legger ut elementene horisontalt (x-dimensjonen, dvs. bortover) eller vertikalt (y-dimensjonen, dvs. nedover) og gjør dem like store i den andre dimensjonen.
  TilePane   - plasserer elementene i et rutenett, TilePane gjør alle ruten like store 
  GridPane    - plasserer elementene i et rutenett, GridPane er mer fleksibel.
  BorderPane - fordeler elementene i regioner, midten (for hovedinnholdet), top, bunn, venstre og høyre, og passer for hovedinnholdet i applikasjonen.
  AnchorPane - henger elementene fast i punkter knyttet til en eller flere av sidene
  Pane - generell container uten spesifikk layout, så posisjonen på elementer må settes manuelt.
 
       * 
       * 
       */
	@Override
	
	// Vindu = Stage
	public void start(Stage stage) throws Exception {
		 
/*
		  HBox og VBox - legger ut elementene horisontalt (x-dimensjonen, dvs. bortover) eller vertikalt (y-dimensjonen, dvs. nedover) og gjør dem like store i den andre dimensjonen.
		  TilePane     - plasserer elementene i et rutenett, TilePane gjør alle ruten like store 
		  GridPane     - plasserer elementene i et rutenett, GridPane er mer fleksibel.
		  BorderPane   - fordeler elementene i regioner, midten (for hovedinnholdet), top, bunn, venstre og høyre, og passer for hovedinnholdet i applikasjonen.
		  AnchorPane   - henger elementene fast i punkter knyttet til en eller flere av sidene
		  Pane         - generell container uten spesifikk layout, så posisjonen på elementer må settes manuelt.
*/		 

		 // 1. opprett alle kontroller
		 // tittel
		 Text title = new Text("Welcome");
		 title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));		 
		 
		 // brukernavnText
		 Label userNameText = new Label("User Name:");		 
		 // brukernavnInput
		 TextField userNameInput = new TextField();
		 		 
		 // passordText
		 Label passwordText = new Label("Password:");		 
		 // passordInput
		 PasswordField passwordInput = new PasswordField();
		 
		 // 2. Sett opp punkter til å feste kontrollene på
		 GridPane grid = new GridPane();
		 grid.setAlignment(Pos.CENTER);
		 grid.setHgap(10);  // horisontal avstand mellom punkter
		 grid.setVgap(10);  // vertikal avstand mellom punkter
		 grid.setPadding(new Insets(10, 10, 10, 10));  // Padding fra de fire sider
		 
		 // 3. fest kontrollene
		 					 //kol, rad
		 grid.add(title,         0, 0);
		 grid.add(userNameText,  1, 1); 
		 grid.add(userNameInput, 2, 2); 
		 grid.add(passwordText,  3, 3);
		 grid.add(passwordInput, 4, 4);
		 
		 // 4. sett opphengte kontroller inn i en scene (=del av vindu)
		 // Scene = vindusinnhold
		 Scene scene = new Scene(grid, 500, 200);  // vindusInnhold(bredd, høyde)
		 
		 // 5. sett scene(r) inn i vindu
		 // Vindu
		 stage.setScene(scene);  // Vindusinnhold -> vindu
		 stage.setTitle("Varelager");
         stage.show(); // vis
		 
		 //------------
	            rootNode.setExpanded(true);
	            for (Employee employee : employees) {
	                TreeItem<String> empLeaf = new TreeItem<String>(employee.getName());
	                boolean found = false;
	                for (TreeItem<String> depNode : rootNode.getChildren()) {
	                    if (depNode.getValue().contentEquals(employee.getDepartment())){
	                        depNode.getChildren().add(empLeaf);
	                        found = true;
	                        break;
	                    }
	                }
	                if (!found) {
	                    TreeItem<String> depNode = new TreeItem<String>(
	                        employee.getDepartment(), 
	                        new ImageView()
	                    );
	                    rootNode.getChildren().add(depNode);
	                    depNode.getChildren().add(empLeaf);
	                }
	            }
	     

	            VBox box = new VBox();
//	            final Scene scene = new Scene(box, 400, 300);
//	            scene.setFill(Color.LIGHTGRAY);
	     
	            TreeView<String> treeView = new TreeView<String>(rootNode);
	            
	            box.getChildren().add(treeView);
	            
	            
	            
	        }
	     
	        public static class Employee {
	     
	            private final SimpleStringProperty name;
	            private final SimpleStringProperty department;
	     
	            private Employee(String name, String department) {
	                this.name = new SimpleStringProperty(name);
	                this.department = new SimpleStringProperty(department);
	            }
	     
	            public String getName() {
	                return name.get();
	            }
	     
	            public void setName(String fName) {
	                name.set(fName);
	            }
	     
	            public String getDepartment() {
	                return department.get();
	            }
	     
	            public void setDepartment(String fName) {
	                department.set(fName);
	            }
	        }
		
	}	



