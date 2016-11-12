package no.onlevel.deler.facade;

import no.onlevel.deler.service.AdminService;
import no.onlevel.deler.service.api.AdminServiceApi;

public class ValideringService {

	AdminLesApi lagringService = new AdminLes();
	
	public void harInnhold(String navn) {
		if (navn.trim().equals("")) {
			// throw new ValideringException("FEIL", "Skriv inn navn"); Kaster
			// exception som fanges opp...
		}
	}

	public void harGyldigeTegn(String navn) {
		if (!navn.trim().matches("^[a-zA-Z0-9Ê¯Â∆ÿ≈ _-]*$")) {
			// return new NyVerdiGuiRespons("FEIL", "Ugyldig tegn i navnet");
		}
	}

	public void erIkkeIListen(String liste, String navn) {
		//leseService.getListe(liste);
		if (liste.contains(navn)) {
			// throw new ValideringException("FEIL", "Skriv inn navn"); Kaster
		}

	}

}
