package no.onlevel.deler.repo.fil;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//import no.onlevel.deler.mal.repo.domain.EgenskapTypeDto;
//import no.onlevel.deler.repo.fil.FraMalRepoFil;

import org.junit.Test;

public class MalRepoTest {

	private static final String FILNAVN = "src//test//resources//egenskaperEnumTest.txt";
	
	@Test
	public void vektorTest() throws IOException {
		double vOmdreining = 0;
		double fartVind = 1;
		double fartRotor = 1;
		double vVinge = 0;
		
		// bruker rotasjonsvinkel som referanse.
		// vindens styrke endrer seg etter rotasjonen.
		// rotasjonsfarten = konst
		// opplevd vind er -vindfart*cos(rotasjonsvinkel) + rotasjonsfart 
		
		FartVektor innkommendeVind = new FartVektor(1, 90);
		FartVektor rotor = new FartVektor(1, 90);

		
	}
	
	class FartVektor{
		private double styrke;
		private double retning; 
		public FartVektor(double styrke, double retning) {
			this.styrke = styrke;
			this.retning = retning;
		}
		public double getStyrke() {
			return styrke;
		}
		public void setStyrke(double styrke) {
			this.styrke = styrke;
		}
		public double getRetning() {
			return retning;
		}
		public void setRetning(double retning) {
			this.retning = retning;
		}
	
		
		
	}
	
	
	
	@Test
	public void skrivTilFilTest() throws IOException {
		// slett testfil..
		Files.delete(Paths.get(FILNAVN));

		// skriv til fil
//		TilMalRepoFil tilMalRepo = new TilMalRepoFil();
//		tilMalRepo.setAlleEgenskaperFilnavn(FILNAVN);
//		
//		EgenskapTypeDto egenskapTypeDto = new EgenskapTypeDto();
//		egenskapTypeDto.setType("wtype");
//		egenskapTypeDto.setTypeNavn("typeNavnc");
//		egenskapTypeDto.setVerdi("verdi");
//		egenskapTypeDto.setInfo("info");
//		egenskapTypeDto.setLinjeNr(6);
//		
//		tilMalRepo.opprettNyEgenskap(egenskapTypeDto);
		
		// Les fra fil
//		FraMalRepoFil fraMalRepo = new FraMalRepoFil();
//		fraMalRepo.setAlleEgenskaperFilnavn(FILNAVN);
		
//		List<EgenskapTypeDto> liste = fraMalRepo.lesAlleEgenskaper();
				
//		assertNotNull(liste);
//		assertEquals("", "wtype", liste.get(0).getType());
//		assertEquals("", "typeNavnc", liste.get(0).getTypeNavn());
//		assertEquals("", "verdi", liste.get(0).getVerdi());
//		assertEquals("", "info", liste.get(0).getInfo());
//		assertEquals("", new Integer(6), liste.get(0).getLinjeNr());	
				
	}

	
}
