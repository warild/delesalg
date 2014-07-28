package no.onlevel.deler.repo.fil;

import static org.junit.Assert.*;

import java.util.List;

import no.onlevel.deler.mal.repo.domain.EgenskapTypeDto;
import no.onlevel.deler.repo.fil.FraMalRepoFil;

import org.junit.Test;

public class FraMalRepoTest {

	@Test
	public void lesFraFilTest() {
		FraMalRepoFil fraMalRepo = new FraMalRepoFil();
		fraMalRepo.setAlleEgenskaperFilnavn("src//test//resources//egenskaperEnum.txt");
		
		List<EgenskapTypeDto> liste = fraMalRepo.lesAlleEgenskaper();
				
		assertNotNull(liste);
		assertEquals("", "merke", liste.get(0).getType());
		assertEquals("", "Merke", liste.get(0).getTypeNavn());
		assertEquals("", "", liste.get(0).getVerdi());
		assertEquals("", new Integer(1), liste.get(0).getLinjeNr());		
	}

	
}
