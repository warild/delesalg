package no.onlevel.deler.gui.controller;

public class TreeItemInnkommet {
	private String navn;
	private String id;
	
	public TreeItemInnkommet(String id, String navn){
		this.id = id; 
		this.navn = navn;
	}
	
	public String toString() {
		return this.navn;
	}
	
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
