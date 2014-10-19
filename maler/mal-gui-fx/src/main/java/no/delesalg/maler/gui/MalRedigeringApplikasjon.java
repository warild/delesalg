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
 * Gui for håndtering av maler
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
	public void start(Stage stage) throws Exception {
		 stage.setTitle("Varelager");

		 GridPane grid = new GridPane();
		 grid.setAlignment(Pos.CENTER);
		 grid.setHgap(10);
		 grid.setVgap(10);
		 grid.setPadding(new Insets(25, 25, 25, 25));

		 Scene scene = new Scene(grid, 300, 275);
		 stage.setScene(scene);

		 Text scenetitle = new Text("Welcome");
		 scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		 grid.add(scenetitle, 0, 0, 2, 1);

		 Label userName = new Label("User Name:");
		 grid.add(userName, 0, 1);

		 TextField userTextField = new TextField();
		 grid.add(userTextField, 1, 1);

		 Label pw = new Label("Password:");
		 grid.add(pw, 0, 2);

		 PasswordField pwBox = new PasswordField();
		 grid.add(pwBox, 1, 2);
		

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
	            stage.setScene(scene);
	            stage.show();
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



