package no.onlevel.deler.repo.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Klasse for xml binding
 * 
 */
@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement( name = "c" )
public class TypeVerdi {
	
	@XmlElement( name = "t" )
	private String type;
	
	@XmlElement( name = "d" )
	private String navn;

	public TypeVerdi(){}
	
	public TypeVerdi(String type, String navn){
		this.type = type;
		this.navn = navn;
	}
	
	public String getNavn() {
		return navn;
	}

	public String getType() {
		return type;
	}

}
