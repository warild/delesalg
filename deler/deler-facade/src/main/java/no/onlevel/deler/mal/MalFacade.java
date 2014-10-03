package no.onlevel.deler.mal;

import java.util.List;

import javax.annotation.Resource;

import no.onlevel.deler.mal.domain.Egenskap;
import no.onlevel.deler.mal.domain.Gruppe;
import no.onlevel.deler.mal.repo.exception.NyMalException;

public class MalFacade {
	
	@Resource
	private MalService malService;
	
	/**
	 * Vis alle malTyper - slik at en mal kan velges ut til å vises/endres/slettes
	 */
	public List<Gruppe> visAlleMalTyper(){
		return malService.hentAlleMalTyper();
	}

	/**
	 * Vis alle egenskaper - slik at en mal kan velges ut til å vises/endres/slettes
	 */
	public List<Egenskap> visAlleEgenskaper(){
		return malService.hentAlleEgenskaper();
	}

	
	
	
	
	/**
	 * Opprett en ny mal for en vare(del)
	 */
	public void opprettMal(String typeNavn, List<String> egenskapTyperListe) {		 
		try {
			malService.lagMal(typeNavn, egenskapTyperListe);
		} catch (NyMalException e) {
			// kast ny exception???
		}
	}
		
	/**
	 * Vis en malType...
	 */
	public Gruppe visMal(String malType){
		return malService.hentEnMal(malType);
	}
	
	void slettMal(String malNavn, List<Egenskap> egenskapListe){
		
	}
	
	/**
	 * 
	 * @param malId
	 * @param egenskap
	 */
	void leggTilMalEgenskap(int malId, Egenskap egenskap){
		
	}
	
	void endreMalEgenskap(int malId, Egenskap egenskap){
		
	}
	
	void slettMalEgenskap(int malId, int egenskapId){
		
	}
}
