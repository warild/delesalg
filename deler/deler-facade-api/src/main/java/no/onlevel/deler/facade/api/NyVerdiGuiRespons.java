package no.onlevel.deler.facade.api;

/**
 * Klasse for retur-meldingen til gui etter at en verdi er forsøkt lagret
 * 
 */
public class NyVerdiGuiRespons {
	private String status = "OK";
	private String melding = "";

	public NyVerdiGuiRespons(String status, String melding) {
		this.status = status;
		this.melding = melding;
	}

	public String getStatus() {
		return status;
	}

	public String getMelding() {
		return melding;
	}
}
