package no.onlevel.deler.service.exception;

public class VaregruppenavnFinnesException extends Exception{
	
	private static final long serialVersionUID = 1L;
		
	public String getMessage() {
		return "Varegruppen finnes allerede.";
	}
}
