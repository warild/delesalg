package no.onlevel.deler.mal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sun.security.action.GetLongAction;
import no.onlevel.deler.mal.domain.Egenskap;
import no.onlevel.deler.mal.domain.Mal;
import no.onlevel.deler.mal.repo.api.FraMalRepoApi;
import no.onlevel.deler.mal.repo.api.TilMalRepoApi;
import no.onlevel.deler.mal.repo.domain.EgenskapTypeDto;
import no.onlevel.deler.mal.repo.domain.MalDto;
import no.onlevel.deler.mal.repo.domain.MalTypeDto;
import no.onlevel.deler.mal.repo.exception.NyEgenskapException;
import no.onlevel.deler.mal.repo.exception.NyMalException;

public class MalService {

	private final static String TYPENAVN_MANGLER = "Malen mangler navn.";
	private final static String TYPENAVN_BRUKT = "Navnet på malen er allerede i bruk.";
	private final static String EGENSKAPER_MANGLER = "Malen har ingen egenskaper.";
	private final static String EGENSKAPER_FINS_IKKE = "Malen har fått egenskaper som ikke lenger fins.";
	private final static String EGENSKAP_BRUKT = "Egenskapen er allerede registrert.";	
	
	private FraMalRepoApi fraMalRepo;
	private TilMalRepoApi tilMalRepo;
	
	
	/**
	 * Henter ei liste med alle (unike) egenskaptyper.
	 * 
	 * @return
	 */
	public List<Egenskap> hentAlleEgenskaper() {
		List<EgenskapTypeDto> egenskapTypeDtoListe = fraMalRepo.lesAlleEgenskaper();
		List<Egenskap> egenskapTypeListe = new ArrayList<Egenskap>();
		for (int nr = 0; nr < egenskapTypeDtoListe.size(); nr++) {
			EgenskapTypeDto egenskapTypeDto = egenskapTypeDtoListe.get(nr);			
			Egenskap egenskap = mapEgenskaper(egenskapTypeDto);
			egenskapTypeListe.add(egenskap);
		}
		return egenskapTypeListe;
	}
	
	
	/**
	 * Opprett ny egenskap.
	 * 
	 * @return
	 * @throws NyEgenskapException 
	 */
	public void opprettNyEgenskapType(Egenskap egenskap) throws NyEgenskapException {
		List<EgenskapTypeDto> egenskapTypeDtoListe = fraMalRepo.lesAlleEgenskaper();
		
		Set<String> egenskapTypeNavnSet = new HashSet<String>();
		Set<String> egenskapTypeSet = new HashSet<String>();
		for (int nr = 0; nr < egenskapTypeDtoListe.size(); nr++) {
			egenskapTypeSet.add(egenskapTypeDtoListe.get(nr).getType());
			egenskapTypeNavnSet.add(egenskapTypeDtoListe.get(nr).getTypeNavn());
		}
		
		// Eksisterer typeNavnet allerede? - returner feilmelding
		if (egenskapTypeNavnSet.contains(egenskap.getTypeNavn())) {
			throw new NyEgenskapException(EGENSKAP_BRUKT);
		}
		
		// Eksisterer typen allerede? - set til et tall til slutt
		String egenskapType = egenskap.getType().toLowerCase().trim().replace(" ", "");
		Integer dublettNr = 1;
		String egenskapTypeAlternativ = egenskapType;
		while (egenskapTypeSet.contains(egenskapTypeAlternativ)){
			egenskapTypeAlternativ = egenskapType + dublettNr.toString();
			dublettNr++;
		}
		egenskap.setType(egenskapTypeAlternativ);
		
		// sett linjenr
		if (egenskap.getLinjeNr() == null) {
			egenskap.setLinjeNr(egenskapTypeNavnSet.size());
		}
		
		// Opprett ny egenskap
		tilMalRepo.opprettNyEgenskap(mapEgenskapTypeDto(egenskap));
	}
	
	
	/**
	 * Henter ei liste med alle (unike) maltyper.
	 * 
	 * @return
	 */
	public List<Mal> hentAlleMalTyper() {
		List<MalTypeDto> malTypeDtoListe = fraMalRepo.lesMalTyper();
		List<Mal> malTypeListe = new ArrayList<Mal>();
		for (int nr = 0; nr < malTypeDtoListe.size(); nr++) {
			MalTypeDto malTypeDto = malTypeDtoListe.get(nr);

			Mal mal = new Mal(malTypeDto.getMalId(), malTypeDto.getType(),
					malTypeDto.getTypeNavn(), malTypeDto.getInfo(),
					malTypeDto.getLinjeNr());

			malTypeListe.add(mal);
		}
		return malTypeListe;
	}

	

	
	/**
	 * Henter en mal. (??? trengs?)
	 * 
	 * @return
	 */
	public Mal hentEnMal(String malType) {
		MalDto malDto = fraMalRepo.lesEnMal(malType);
		if (malDto == null) {
			// exception ???
			return null;
		} else {
			// lagMal(malDto)
			return new Mal(malDto.getMalId(), malDto.getType(),
					malDto.getTypeNavn(), malDto.getInfo(), malDto.getLinjeNr());
		}
	}

	/**
	 * Opprett en ny mal
	 */
	public void lagMal(String typeNavn, List<String> egenskapTyperListe) throws NyMalException {	
		// bør repo sjekke? Nei - repo er kun opptatt med select/insert/update/delete
		
		if (typeNavn == null || typeNavn == "") {
			throw new NyMalException(TYPENAVN_MANGLER);
		}
		
		if (ugyldigMalTypeNavn(typeNavn)) {
			throw new NyMalException(TYPENAVN_BRUKT);
		}
		
		if (egenskapTyperListe == null || egenskapTyperListe.size() == 0) {
			throw new NyMalException(EGENSKAPER_MANGLER);
		}

		if (ugyldigEgenskapType(egenskapTyperListe)) {
			throw new NyMalException(EGENSKAPER_FINS_IKKE);
		}
		
		String malType = tilMalRepo.nyMalType(typeNavn);
		tilMalRepo.nyeMalEgenskaper(malType, egenskapTyperListe);		
	}

	/*
	 * hjelpemetoder
	 */
	private boolean ugyldigMalTypeNavn(String typeNavn) {
		return fraMalRepo.lesAlleMaler().contains(typeNavn);
	}

	private boolean ugyldigEgenskapType(List<String> egenskapTypeListe) {
		Set<String> egenskapSet = fraMalRepo.lesEgenskapTyper();
		for (int nr = 0; nr < egenskapTypeListe.size(); nr++) {
			if (!egenskapSet.contains(egenskapTypeListe.get(nr))) {
				return false;
			}
		}
		return true;
	}
	
	private Egenskap mapEgenskaper(EgenskapTypeDto egenskapTypeDto) {		
		Egenskap egenskap = new Egenskap();
		egenskap.setEgenskapId(egenskapTypeDto.getEgenskapId());
		egenskap.setType(egenskapTypeDto.getType());
		egenskap.setTypeNavn(egenskapTypeDto.getTypeNavn());
		egenskap.setVerdi(egenskapTypeDto.getVerdi());
		egenskap.setInfo(egenskapTypeDto.getInfo());
		return egenskap; 
	}

	private EgenskapTypeDto mapEgenskapTypeDto(Egenskap egenskap) {
		EgenskapTypeDto egenskapTypeDto = new EgenskapTypeDto();
		egenskapTypeDto.setType(egenskap.getType());
		egenskapTypeDto.setTypeNavn(egenskap.getTypeNavn());
		egenskapTypeDto.setVerdi(egenskap.getVerdi());
		egenskapTypeDto.setInfo(egenskap.getInfo());
		egenskapTypeDto.setLinjeNr(egenskap.getLinjeNr());
		return egenskapTypeDto;
	}
}
