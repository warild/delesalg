package no.onlevel.deler.mal.api;

import java.util.List;

import no.onlevel.deler.mal.domain.Egenskap;
/** 
 * Metoder for å vise, opprette, endre og slette egenskapene til en mal
 *
 */
public interface EgenskapFacadeApi {
		
	List<Egenskap> hentAlleEgenskaper(String gruppe);
	
	Egenskap hentEgenskap(String gruppe, String egenskapType);
	
	void opprettEgenskap(String gruppe, Egenskap egenskap);
	
	void endreEgenskap(int egenskapId, Egenskap egenskap);
	
	void slettEgenskap(int egenskapId);
}
