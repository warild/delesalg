package no.onlevel.deler.service;

import java.util.List;

import no.onlevel.deler.repo.api.KodeverkDao;
import no.onlevel.deler.repo.api.KodeverkDaoApi;
import no.onlevel.deler.repo.domain.TypeVerdi;
import no.onlevel.deler.service.api.AdminServiceApi;
import no.onlevel.deler.service.domain.NyVerdiRespons;
import no.onlevel.deler.service.exception.VaregruppenavnFinnesException;




public class AdminService implements AdminServiceApi{

	private KodeverkDaoApi kodeverkDaoApi = new KodeverkDao();
	
	@Override
	public NyVerdiRespons lagreNyVaregruppe(String nyVaregruppe) throws VaregruppenavnFinnesException {
		// sjekk om varegruppen fins fra før, hvist så kast exception.
		List<TypeVerdi> varegrupper = kodeverkDaoApi.lesAlleVaregrupper(); 
		for (TypeVerdi typeVerdi : varegrupper) {
			if (typeVerdi.getNavn().toLowerCase().equals(nyVaregruppe.toLowerCase())) {
				throw new VaregruppenavnFinnesException();
			}		
		}
		
		kodeverkDaoApi.lagreNyVaregruppe(nyVaregruppe); 
// TODO: retur
		return null;
	}
		
			




}
