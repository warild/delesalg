package no.onlevel.deler.repo;

import java.util.List;

import no.onlevel.deler.mal.repo.api.TilMalRepoApi;
import no.onlevel.deler.mal.repo.domain.EgenskapTypeDto;
import no.onlevel.deler.mal.repo.domain.MalDto;

public class SkrivMalRepo implements TilMalRepoApi {

	@Override
	public String nyMalType(String typeNavn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endreMalType(int malId, MalDto mal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void slettMalType(int malId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nyEgenskapType(EgenskapTypeDto egenskap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endreEgenskapType(int egenskapId, EgenskapTypeDto egenskap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void slettEgenskapType(int egenskapId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void opprettMal(int malId, List<String> egenskapTypeNavn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taVekkMalEgenskap(int malId, int egenskapId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leggTilMalEgenskap(int malId, int egenskapId) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void nyeMalEgenskaper(String malType, List<String> egenskapTyperListe) {
		// TODO Auto-generated method stub
		
	}





	
	
}
