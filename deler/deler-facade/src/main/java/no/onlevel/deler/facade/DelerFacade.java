package no.onlevel.deler.facade;

import no.onlevel.deler.facade.api.FacadeApi;
import no.onlevel.deler.facade.api.NyVerdiGuiRespons;
import no.onlevel.deler.service.AdminService;
import no.onlevel.deler.service.api.AdminServiceApi;


public class DelerFacade implements FacadeApi{

	AdminServiceApi service = new AdminService();
	
	@Override
	public NyVerdiGuiRespons lagreNyVaregruppe(String nyVaregruppeTekst) {
		
		
		if (nyVaregruppeTekst.trim().equals("")) {
			return new NyVerdiGuiRespons("FEIL", "Skriv inn navn");
		}
		if (!nyVaregruppeTekst.trim().matches("^[a-zA-Z0-9Ê¯Â∆ÿ≈ _-]*$")) { 
			return new NyVerdiGuiRespons("FEIL", "Ugyldig tegn i navn");
		}
		try {
			service.lagreNyVaregruppe("navn"); 			
		} catch (Exception e) {
			return new NyVerdiGuiRespons("FEIL", e.getMessage());
		}		
		return new NyVerdiGuiRespons("OK", "Lagret!");
	}
}
