package no.onlevel.deler.service.api;

import no.onlevel.deler.service.domain.NyVerdiRespons;
import no.onlevel.deler.service.exception.VaregruppenavnFinnesException;

/** 
 * Metoder for å oppdatere app
 *
 */
public interface AdminServiceApi {
		
	NyVerdiRespons lagreNyVaregruppe(String nyVaregruppe) throws VaregruppenavnFinnesException;
	
}
