package no.onlevel.deler.repo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Klasse for xml binding
 * 
 */
@XmlAccessorType (XmlAccessType.FIELD)  
@XmlRootElement( name = "xml" )
public class TypeVerdiListe {
		
	@XmlElement( name = "t" )
	private String type;
	
	@XmlElement( name = "d" )
	private String navn;

	@XmlElement( name = "c" )
	private List<TypeVerdi> contentListe;

	public TypeVerdiListe(){
		contentListe = new ArrayList<TypeVerdi>();	
	}
	public TypeVerdiListe(String type, String navn){
		contentListe = new ArrayList<TypeVerdi>();
		this.type = type;
		this.navn = navn;
	}	
	
	public List<TypeVerdi> getListe() {
		return contentListe;
	}

	public String getNavn() {
		return navn;
	}

	public String getType() {
		return type;
	}
}
