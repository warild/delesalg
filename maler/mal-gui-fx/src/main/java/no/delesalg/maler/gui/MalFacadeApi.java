package no.delesalg.maler.gui;

import java.util.List;

import no.onlevel.deler.mal.domain.Egenskap;
import no.onlevel.deler.mal.domain.Gruppe;
/**
 * Metoder for å vise, opprette, endre og slette maler
 *
 */
public interface MalFacadeApi {

	List<Gruppe> hentMaler();
	
	Gruppe hentMal(int malId);
	
	void opprettMal(Gruppe mal, List<Egenskap> egenskapListe);
	
	void endreMal(int malId, Gruppe mal);

	void leggTilEgenskap(int malId, Egenskap egenskap);
	
	void slettEgenskap(int malId, int egenskapId);
	
	void slettMal(String malNavn, List<Egenskap> egenskapListe);
}
