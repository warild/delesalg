package no.onlevel.deler.repo.domain;

/**
 * Klasse for retur-meldingen til gui etter at en verdi er forsøkt lagret
 * 
 */
public class NyVerdiRespons {
	private String status = "OK";
	private String melding = "";
	private String feilkode = "";

	public NyVerdiRespons(String status, String feilkode, String melding) {
		this.status = status;
		this.melding = melding;
		this.melding = feilkode;
	}

	public String getStatus() {
		return status;
	}

	public String getMelding() {
		return melding;
	}

	public String getFeilkode() {
		return feilkode;
	}
}
