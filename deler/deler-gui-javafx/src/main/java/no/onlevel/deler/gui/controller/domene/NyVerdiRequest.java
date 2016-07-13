package no.onlevel.deler.gui.controller.domene;

import javafx.scene.control.ButtonBar.ButtonData;

/** Klasse for den verdien som er skrevet inn i gui når det skal legges til ny verdi av en eller annen type
 * 
 */
public class NyVerdiRequest {
	private ButtonData tryktKnapp = null;
	private String nyVerdi = "";

	public NyVerdiRequest(ButtonData tryktKnapp, String nyVerdi) {
		this.tryktKnapp= tryktKnapp;
		this.nyVerdi = nyVerdi;		
	}
	
	public String getNyVerdi() {
		return nyVerdi;
	}

	public ButtonData getTryktKnapp() {
		return tryktKnapp;
	}


}
