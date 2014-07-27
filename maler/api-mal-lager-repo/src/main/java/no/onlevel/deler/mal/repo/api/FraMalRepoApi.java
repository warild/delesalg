package no.onlevel.deler.mal.repo.api;

import java.util.List;
import java.util.Set;

import no.onlevel.deler.mal.repo.domain.EgenskapTypeDto;
import no.onlevel.deler.mal.repo.domain.MalDto;
import no.onlevel.deler.mal.repo.domain.MalTypeDto;
/** 
 * Metoder for å hente egenskaper og maler fra repo
 *
 */
public interface FraMalRepoApi {

	List<EgenskapTypeDto> lesAlleEgenskaper();
	Set<String> lesAlleMaler();
	Set<String> lesEgenskapTyper();
	
	MalDto lesEnMal(String malType);
	
	List<MalTypeDto> lesMalTyper();
			
	List<EgenskapTypeDto> lesEgenskaper();
	
	EgenskapTypeDto lesEnEgenskap(int egenskapId);
}
	
