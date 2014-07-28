package no.onlevel.deler.repo.fil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import no.onlevel.deler.mal.repo.api.TilMalRepoApi;
import no.onlevel.deler.mal.repo.domain.EgenskapTypeDto;
import no.onlevel.deler.mal.repo.domain.MalDto;

public class TilMalRepoFil implements TilMalRepoApi {

	private String alleEgenskaperFilnavn = "src//test//resources//egenskaperEnum.txt";
	
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
	public void opprettNyEgenskap(EgenskapTypeDto egenskapDto) {
	    FileWriter fileWriter = null;
	    BufferedWriter bufferedWriter =  null;
	    boolean append = true;
		try {
			fileWriter = new FileWriter(alleEgenskaperFilnavn, append);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			String line = egenskapDto.getType() + "¤" +egenskapDto.getTypeNavn()+ "¤" +egenskapDto.getVerdi()+ "¤" +egenskapDto.getInfo()+ "¤" +
			egenskapDto.getLinjeNr();
			bufferedWriter.write(line);
			bufferedWriter.newLine();
			
			// close the BufferedReader when we're done
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
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

	public void setAlleEgenskaperFilnavn(String alleEgenskaperFilnavn) {
		this.alleEgenskaperFilnavn = alleEgenskaperFilnavn;
	}





	
	
}
