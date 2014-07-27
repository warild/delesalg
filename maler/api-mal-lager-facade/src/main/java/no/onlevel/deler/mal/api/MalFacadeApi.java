package no.onlevel.deler.mal.api;

import java.util.List;

import no.onlevel.deler.mal.domain.Egenskap;
import no.onlevel.deler.mal.domain.Mal;
/**
 * Metoder for å vise, opprette, endre og slette maler
 *
 */
public interface MalFacadeApi {

	List<Mal> hentMaler();
	
	Mal hentMal(int malId);
	
	void opprettMal(Mal mal, List<Egenskap> egenskapListe);
	
	void endreMal(int malId, Mal mal);

	void leggTilEgenskap(int malId, Egenskap egenskap);
	
	void slettEgenskap(int malId, int egenskapId);
	
	void slettMal(String malNavn, List<Egenskap> egenskapListe);
}
