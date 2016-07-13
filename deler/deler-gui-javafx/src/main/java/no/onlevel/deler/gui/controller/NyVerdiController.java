package no.onlevel.deler.gui.controller;
        

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 */
public class NyVerdiController {
	
	public NyVerdiController() {
		
	}
	
	@FXML
	private TextField nyVerdiVerdi;
    
	@FXML
	private Label NyVerdiTekst ;
    
	@FXML
	private Button nyVerdiOk;
    
	@FXML
	private Button nyVerdiAvbryt; 
    
	// populate
	@FXML
	public void initialize() {
		nyVerdiOk.addEventHandler(MouseEvent.MOUSE_CLICKED, nyVerdi);		
	}
	
	// Kode som utføres når knapp trykkes
	private EventHandler<MouseEvent> nyVerdi = (MouseEvent event) -> {
		// er verdi fylt ut?
		// er verdi riktig formattert?
		// er verdi unik ?
		System.out.println(nyVerdiVerdi.getText());
		
	};
	

	public TextField getNyVerdiTekst() {
		return nyVerdiVerdi;
	}
}
