package no.onlevel.deler.gui.controller;
        

import java.util.Optional;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import no.onlevel.deler.facade.DelerFacade;
import no.onlevel.deler.facade.api.FacadeApi;
import no.onlevel.deler.facade.api.NyVerdiGuiRespons;
import no.onlevel.deler.gui.controller.domene.NyVerdiRequest;

/**
 *
 */
public class AdminController {
	private static final String NYVERDI_FXML = "/no/onlevel/deler/gui/nyVerdi.fxml";
	
	private FacadeApi facade = new DelerFacade();
	
	@FXML
	private TableView<String> varegruppeTabell ;

	@FXML
	private TableView<String> vareTabell ;
	
	@FXML
	private TabPane varegruppeTabs;
	@FXML
	private Button nyVaregruppeKnapp;
	

	@FXML
	private TableView<String> deleGruppeTabell ;
	
	@FXML
	private TableView<String> deleTabell ;
	
	@FXML
	private TableView<String> verdiTabell ;

	@FXML
	private ListView<String> egenskapListe ;

	
	// populate
	@FXML
	public void initialize() {
		
		nyVaregruppeKnapp.addEventHandler(MouseEvent.MOUSE_CLICKED, nyVareGruppe);

		ObservableList<String> items =FXCollections.observableArrayList (
			    "Lastebiler", "Lastebildeler", "P�bygg", "Dekk og felger");
		egenskapListe.setItems(items);

	}
	
	// 1: Opprett guiObjekt herfra
	// 2: Les verdier fra guiObjektet n�r det returnerer.
	
	// legg event p� knappen
	// metoden i egen ...
	// Facade.lagreNyGruppe()
	// 
	
	// Kode som utf�res n�r knapp trykkes (helt vanlig kode, men den implementerer/overskriver/returnerer et interface (EventHandler<MouseEvent>) )
	private EventHandler<MouseEvent> nyVareGruppe = (MouseEvent event) -> {
		// s� tynn gui som mulig
		// validering innenfor facaden - da kan den brukes av annen gui ogs�.
		// controller er orkestrator
		// 1: Hendelse
		// 2: Vis GUI -> returobjekt -> controller
		// 3: controller -> Kall Facade
		// 4: controller -> H�ndter retur fra facade
		// - vis gui p� ny eller oppdater gui.
		
		String rammeTekst = "Varegruppe";
		String ledetekst = "Navn p� ny varegruppe";
		String feilmeldingTekst = "";
		String tekstfeltTekst = "";
	
		// Vis bilde		
		NyVerdiRequest nyVerdi = getNyVerdiFx(rammeTekst, ledetekst, feilmeldingTekst,  tekstfeltTekst);
		if (nyVerdi.getTryktKnapp().equals(ButtonData.OK_DONE)) {			
			// Kall facaden for � lagre verdien
			NyVerdiGuiRespons respons = facade.lagreNyVaregruppe(nyVerdi.getNyVerdi());
			
			while (nyVerdi.getTryktKnapp().equals(ButtonData.OK_DONE) && respons.getStatus() != "OK") {
				System.out.println(nyVerdi.getNyVerdi());
				
				feilmeldingTekst = respons.getMelding();
				tekstfeltTekst = nyVerdi.getNyVerdi();
				nyVerdi = getNyVerdiFx(rammeTekst, ledetekst, feilmeldingTekst,  tekstfeltTekst);
				if (nyVerdi.getTryktKnapp().equals(ButtonData.OK_DONE)) {
					respons = facade.lagreNyVaregruppe(nyVerdi.getNyVerdi());
				}
			} 
		}		
	};

	private NyVerdiRequest getNyVerdiFx(String rammeTekst, String ledetekst, String feilmeldingTekst, String tekstfeltTekst)  {
		// Opprett Dialog
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setTitle(rammeTekst);
		dialog.setHeaderText(null);
		dialog.setGraphic(null);

		// Lag Pane som skal plasseres i Dialog
		GridPane grid = new GridPane();
		grid.setHgap(5);
		grid.setVgap(5);
		dialog.getDialogPane().setContent(grid);
				
		// Plasser controllene i Pane 
		Label feilmeldingLabel = new Label(feilmeldingTekst);
		Label ledetekstLabel = new Label(ledetekst);
		TextField nyttNavnInput = new TextField();
		
		feilmeldingLabel.setTextFill(Color.web("#f00"));; 
		if (feilmeldingTekst.length() > 0) {
			nyttNavnInput.setStyle("-fx-border-color: #f00;");				
		}	
		nyttNavnInput.setText(tekstfeltTekst);
		grid.add(feilmeldingLabel, 1, 0);  // kolonne, rad
		grid.add(ledetekstLabel, 1, 1);
		grid.add(nyttNavnInput, 2, 1);
		// Sett inn knapper	
		ButtonType okKnapp = new ButtonType("Ok", ButtonData.OK_DONE);
		ButtonType avbrytKnapp = new ButtonType("Avbryt", ButtonData.CANCEL_CLOSE);
		dialog.getDialogPane().getButtonTypes().addAll(avbrytKnapp, okKnapp);

		// Vis bilde		
		Platform.runLater(() -> nyttNavnInput.requestFocus());				
		Optional<ButtonType> tryktKnapp = dialog.showAndWait();
		  
		return new NyVerdiRequest(tryktKnapp.get().getButtonData(), nyttNavnInput.getText());
	}
	

	private EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
		System.out.println(" ffffffffffff ");
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
