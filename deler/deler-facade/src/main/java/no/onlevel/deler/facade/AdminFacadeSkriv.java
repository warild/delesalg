package no.onlevel.deler.facade;

import no.onlevel.deler.facade.api.AdminFacadeApi;
import no.onlevel.deler.facade.api.NyVerdiGuiRespons;
import no.onlevel.deler.facade.domain.VaregruppeVarer;
import no.onlevel.deler.service.AdminService;
import no.onlevel.deler.service.api.AdminServiceApi;
import no.onlevel.deler.service.exception.VaregruppenavnFinnesException;

/**
 * Facade = Application layer i DDD Har en front-end der metodene er ulike.
 * Disse kaller metodr som ligger backend i samme klasse. Backendmetoder kaller
 * andre tjenester eller gjør jobben selv.
 *
 * facaden har ikke nivåinndeling. Alt er flatt i forkant. I bak-kant har vi
 * trestruktur
 *
 * Domenet er en tre-struktur. En XML kan uttrykke hele denne strukturen. 
 * Klasser kan kun uttrykke ett nivå i denne strukturen. Og vi kan ikke bruke samme klasse til å uttrykke alle nivåene (? JAXB vil ha ulike klassenavn?)
 * Backend er en tre-struktur. Front-end er en flat stuktur - slik at gui kan lages på alle måter
 * En klasse inneholder funksjonalitet for nivået. Horisontalt (causalt) og vertikalt (logisk)?.
 * 
 * 
 * 
 * 
 */
public class AdminFacadeSkriv implements AdminFacadeApi {

	ValideringService valideringService = new ValideringService();
	AdminServiceApi lagringService = new AdminService();

	String VAREGRUPPE_LISTE = "t=vare/t=varegruppe";

	public NyVerdiGuiRespons opprettNyVaregruppe(String nyVaregruppe) {
		
		NyVerdiGuiRespons e;
		e = validerNyttVaregruppenavn(nyVaregruppe);
		e = lagreNyttVaregruppenavn(nyVaregruppe);
		return e; 
	}

	// ------------ facade backend ---------------------------

	private NyVerdiGuiRespons validerNyttVaregruppenavn(String navn) {

		try {
			valideringService.harInnhold(navn);
			valideringService.harGyldigeTegn(navn);
			valideringService.erIkkeIListen(VAREGRUPPE_LISTE, navn);
		} catch (Exception e) {
			return new NyVerdiGuiRespons("Valideringsfeil", e.getMessage());
		}

		return null; // NyVerdiGuiRespons
	}
	
	private NyVerdiGuiRespons lagreNyttVaregruppenavn(String navn) {
		try {
			lagringService.lagre(navn, VAREGRUPPE_LISTE);
		} catch (Exception e) {
			return new NyVerdiGuiRespons("Lagringsfeil", e.getMessage());
		}
		return new NyVerdiGuiRespons("Ok", "Ny varegruppe opprettet.");
	}

}
