package no.onlevel.deler.mal.domain;

/**
 * VerdiObjekt: Inneholder de egenskapene som utgj�r linjene i en mal
 *
 */
public class Egenskap {
	String gruppe;
	String type;
	String typeNavn;
	String verdi;
	String info;
	Integer linjeNr;
	

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
	public String getVerdi() {
		return verdi;
	}
	public void setVerdi(String verdi) {
		this.verdi = verdi;
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
	public String getGruppe() {
		return gruppe;
	}
	public void setGruppe(String gruppe) {
		this.gruppe = gruppe;
	}	
}
