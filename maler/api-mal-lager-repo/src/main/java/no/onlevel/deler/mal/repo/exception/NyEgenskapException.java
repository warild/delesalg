package no.onlevel.deler.mal.repo.exception;

public class NyEgenskapException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String melding;

	/**
	 * 
	 */

	public NyEgenskapException(String melding) {
		this.melding = melding;
	}
	
	public String getMelding() {
		return melding;
	}
}
