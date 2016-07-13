package no.onlevel.deler.service.api;

import no.onlevel.deler.service.domain.NyVerdiRespons;

/** 
 * Metoder for å oppdatere app
 *
 */
public interface AdminServiceApi {
		
	NyVerdiRespons lagreNyVaregruppe(String nyVaregruppe);
	
}
