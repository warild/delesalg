package no.onlevel.deler.gui.controller;

import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TreeTableViewSample extends Application {

	public static void main(String[] args) {
		Application.launch(TreeTableViewSample.class, args);
	}

	List<Employee> employees = Arrays.<Employee> asList(
			new Employee("Ethan Williams", "ethan.williams@example.com"),
			new Employee("Emma Jones", "emma.jones@example.com"),
			new Employee("Michael Brown", "michael.brown@example.com"),
			new Employee("Anna Black", "anna.black@example.com"),
			new Employee("Rodger York", "roger.york@example.com"),
			new Employee("Susan Collins", "susan.collins@example.com"));

	private final ImageView depIcon = new ImageView(
			new Image(getClass().getResourceAsStream("department.png")));

	// Root
	final TreeItem<Employee> root = new TreeItem<>(new Employee("Sales Department", ""), depIcon);

	@Override
	public void start(Stage stage) {
		root.setExpanded(true);

		// root<TreeItem> - add<TreeItem>
		employees.stream().forEach((employee) -> {
			root.getChildren().add(new TreeItem<>(employee));
		});


		// kolonne<TreeTableColumn> 
		TreeTableColumn<Employee, String> empColumn = new TreeTableColumn<>("Employee");		
		empColumn.setPrefWidth(150);		
		// cellfactory 
		empColumn.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Employee, String> param) ->
				new ReadOnlyStringWrapper(param.getValue().getValue().getName())
				);

		// kolonne 2
		TreeTableColumn<Employee, String> emailColumn =
				new TreeTableColumn<>("Email");
		emailColumn.setPrefWidth(190);
		emailColumn.setCellValueFactory(
				// kolonne2 - cellfactory
				(TreeTableColumn.CellDataFeatures<Employee, String> param) ->
				new ReadOnlyStringWrapper(param.getValue().getValue().getEmail())
				);

		
		// HER bygges <TreeTableView> 
		TreeTableView<Employee> treeTableView = new TreeTableView<>(root);
		treeTableView.getColumns().setAll(empColumn, emailColumn);
		
		final Scene scene = new Scene(new Group(), 400, 400);
		scene.setFill(Color.LIGHTGRAY);
		
		Group sceneRoot = (Group) scene.getRoot();
		sceneRoot.getChildren().add(treeTableView);
				
		stage.setScene(scene);
		stage.setTitle("Tree Table View Sample");
		stage.show();
		
		// stage-> scene-> sceneroot-> treeTableView (root) -> col1, col2
	}

	public class Employee {

		private SimpleStringProperty name;
		private SimpleStringProperty email;

		public SimpleStringProperty nameProperty() {
			if (name == null) {
				name = new SimpleStringProperty(this, "name");
			}
			return name;
		}

		public SimpleStringProperty emailProperty() {
			if (email == null) {
				email = new SimpleStringProperty(this, "email");
			}
			return email;
		}

		private Employee(String name, String email) {
			this.name = new SimpleStringProperty(name);
			this.email = new SimpleStringProperty(email);
		}

		public String getName() {
			return name.get();
		}

		public void setName(String fName) {
			name.set(fName);
		}

		public String getEmail() {
			return email.get();
		}

		public void setEmail(String fName) {
			email.set(fName);
		}
	}

}
