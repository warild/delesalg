package no.onlevel.deler.repo.fil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import no.onlevel.deler.mal.repo.api.FraMalRepoApi;
import no.onlevel.deler.mal.repo.domain.EgenskapTypeDto;
import no.onlevel.deler.mal.repo.domain.MalDto;
import no.onlevel.deler.mal.repo.domain.MalTypeDto;

public class FraMalRepoFil implements FraMalRepoApi {
	
	private String alleEgenskaperFilnavn = "src//test//resources//egenskaperEnum.txt";

	@Override
	public List<EgenskapTypeDto> lesAlleEgenskaper() {
	    // wrap a BufferedReader around FileReader
	    FileReader fileReader = null;
	    BufferedReader bufferedReader =  null;
	    List<EgenskapTypeDto> records = new ArrayList<EgenskapTypeDto>();
	    
		try {
			fileReader = new FileReader(alleEgenskaperFilnavn);
			bufferedReader = new BufferedReader(fileReader);
			
			String line = null;
			// use the readLine method of the BufferedReader to read one line at a time.
			// the readLine method returns null when there is nothing else to read.
			while ((line = bufferedReader.readLine()) != null) {
				String[] EgenskapObjekt = line.split("¤");
				EgenskapTypeDto egenskapTypeDto = new EgenskapTypeDto();
				egenskapTypeDto.setType(EgenskapObjekt[0]);
				egenskapTypeDto.setTypeNavn(EgenskapObjekt[1]);
				egenskapTypeDto.setVerdi(EgenskapObjekt[2]);
				egenskapTypeDto.setInfo(EgenskapObjekt[3]);				
				egenskapTypeDto.setLinjeNr(Integer.parseInt(EgenskapObjekt[4]));
				
				records.add(egenskapTypeDto);
			}		   
			// close the BufferedReader when we're done
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return records;			
	}

	@Override
	public EgenskapTypeDto lesEnEgenskap(int egenskapId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MalTypeDto> lesMalTyper() {
		//Test
		List<MalTypeDto> list = new ArrayList<MalTypeDto>();
		MalDto malDto = new MalDto();
		malDto.setMalId(1);
		malDto.setType("typeLastebil");
		malDto.setTypeNavn("typeNavnLastebil");
		malDto.setLinjeNr(1);
		list.add(malDto);
		return list;
	}

	@Override
	public MalDto lesEnMal(String malType) {
		try {
		    String line = null;
		    List<String> records = new ArrayList<String>();
		 
		    // wrap a BufferedReader around FileReader
		    FileReader fileReader = new FileReader("varelager//egenskaperEnum.txt");
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		 
		    // use the readLine method of the BufferedReader to read one line at a time.
		    // the readLine method returns null when there is nothing else to read.
		    while ((line = bufferedReader.readLine()) != null)
		    {
		        records.add(line);
		    }		   
		    // close the BufferedReader when we're done
		    bufferedReader.close();
		    
		    
		    return null;
		    
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// throws kunne ikke nå data.... 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MalDto malDto = new MalDto();
		malDto.setMalId(2);
		malDto.setType("type");
		malDto.setTypeNavn("typeNavn");
		malDto.setLinjeNr(1);
		return malDto;
	}


	@Override
	public Set<String> lesAlleMaler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> lesEgenskapTyper() {
		// TODO Auto-generated method stub
		return null;
	}



	public void setAlleEgenskaperFilnavn(String alleEgenskaperFilnavn) {
		this.alleEgenskaperFilnavn = alleEgenskaperFilnavn;
	}
}
