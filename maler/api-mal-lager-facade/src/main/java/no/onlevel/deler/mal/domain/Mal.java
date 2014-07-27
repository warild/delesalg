package no.onlevel.deler.mal.domain;


public class Mal {

	int malId;
	String type;
	String typeNavn;
	String info;
	Integer linjeNr;
	
	public Mal(int malId, String type, String typeNavn, String info, Integer linjeNr){
		this.malId = malId; 
		this.type = type; 
		this.typeNavn = typeNavn; 
		this.info = info; 
		this.linjeNr = linjeNr;
	}

}
