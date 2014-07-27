package no.onlevel.deler.repo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import no.onlevel.deler.mal.repo.api.FraMalRepoApi;
import no.onlevel.deler.mal.repo.domain.EgenskapTypeDto;
import no.onlevel.deler.mal.repo.domain.MalDto;
import no.onlevel.deler.mal.repo.domain.MalTypeDto;

public class FraMalRepo implements FraMalRepoApi {

	@Override
	public List<EgenskapTypeDto> lesEgenskaper() {
		// TODO Auto-generated method stub
		return null;
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
			FileReader fileReader = new FileReader("varelager//egenskaperEnum.txt");
		    String line = null;
		    List<String> records = new ArrayList<String>();
		 
		    // wrap a BufferedReader around FileReader
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		 
		    // use the readLine method of the BufferedReader to read one line at a time.
		    // the readLine method returns null when there is nothing else to read.
		    while ((line = bufferedReader.readLine()) != null)
		    {
		        records.add(line);
		    }
		   
		    // close the BufferedReader when we're done
		    bufferedReader.close();
		    return records;
		    
			
			
		} catch (FileNotFoundException e) {
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
	public List<EgenskapTypeDto> lesAlleEgenskaper() {
		// TODO Auto-generated method stub
		return null;
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
}
