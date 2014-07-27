package no.onlevel.deler.mal.repo.domain;

public class MalTypeDto {
	int malId;
	String type;
	String typeNavn;
	String info;
	Integer linjeNr;

	public int getMalId() {
		return malId;
	}

	public void setMalId(int malId) {
		this.malId = malId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeNavn() {
		return typeNavn;
	}

	public void setTypeNavn(String typeNavn) {
		this.typeNavn = typeNavn;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getLinjeNr() {
		return linjeNr;
	}

	public void setLinjeNr(Integer linjeNr) {
		this.linjeNr = linjeNr;
	}
}
