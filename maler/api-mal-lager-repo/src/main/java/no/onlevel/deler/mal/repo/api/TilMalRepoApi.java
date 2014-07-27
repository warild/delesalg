package no.onlevel.deler.mal.repo.api;

import java.util.List;

import no.onlevel.deler.mal.repo.domain.EgenskapTypeDto;
import no.onlevel.deler.mal.repo.domain.MalDto;
/**
 * Metoder for å opprette, endre og slette maler
 * 
 * Repo relasjoner: Maler -> Mal/Egenskaper -> Egenskap
 *
 */
public interface TilMalRepoApi {

	void nyEgenskapType(EgenskapTypeDto egenskapTypeDto);
	
	String nyMalType(String typeNavn);
	void nyeMalEgenskaper(String malType, List<String> egenskapTyperListe);	
	
	
	void endreMalType(int malId, MalDto mal);

	void slettMalType(int malId);
		
	void endreEgenskapType(int egenskapId, EgenskapTypeDto egenskap);	
	void slettEgenskapType(int egenskapId);
	

	void opprettMal(int malId, List<String> egenskapTypeNavn);
	
	void taVekkMalEgenskap(int malId, int egenskapId);
	
	void leggTilMalEgenskap(int malId, int egenskapId);
}
