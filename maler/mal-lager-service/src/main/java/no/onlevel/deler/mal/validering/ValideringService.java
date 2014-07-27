package no.onlevel.deler.mal.validering;

import java.util.List;

import no.onlevel.deler.mal.domain.Egenskap;
import no.onlevel.deler.mal.repo.api.FraMalRepoApi;

public class ValideringService {

	private FraMalRepoApi fraMalRepo;
	
	/**
	 *  Sjekker at navnet på malen er ledig
	 *  
	 * @param typeNavn
	 * @return
	 */
	public boolean ugyldigMalTypeNavn(String typeNavn) {
		return fraMalRepo.lesAlleMaler().contains(typeNavn);		
	}

	public boolean ugyldigEgenskapListe(List<Egenskap> egenskapListe) {
		if (egenskapListe == null) {
			return false;
		} else {
			// * sjekk at egenskapListe har verdier
			// * sjekk at egenskapListe sine verdier er gyldige (fins i db)
			return true;			
		}
	}
}
