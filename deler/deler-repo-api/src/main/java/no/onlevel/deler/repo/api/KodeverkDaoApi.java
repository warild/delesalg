package no.onlevel.deler.repo.api;

import java.util.List;

import no.onlevel.deler.repo.domain.NyVerdiRespons;
import no.onlevel.deler.repo.domain.TypeVerdi;

/** 
 * Metoder for å oppdatere app
 *
 */
public interface KodeverkDaoApi {
	
	public List<TypeVerdi> lesAlleVaregrupper();
	
	public NyVerdiRespons lagreNyVaregruppe(String nyVaregruppe);

}
