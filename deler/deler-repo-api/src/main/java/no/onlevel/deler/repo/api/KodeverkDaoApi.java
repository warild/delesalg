package no.onlevel.deler.repo.api;

import no.onlevel.deler.repo.domain.NyVerdiRespons;

/** 
 * Metoder for å oppdatere app
 *
 */
public interface KodeverkDaoApi {
		
	NyVerdiRespons lagreNyVaregruppe(String nyVaregruppe);
	
}
