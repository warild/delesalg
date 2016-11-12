package no.onlevel.deler.repo.api;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import no.onlevel.deler.repo.api.KodeverkDaoApi;
import no.onlevel.deler.repo.domain.TypeVerdi;
import no.onlevel.deler.repo.domain.NyVerdiRespons;
import no.onlevel.deler.repo.domain.TypeVerdiListe;

/**
 * Metoder for å oppdatere kodeverk
 *
 */
public class KodeverkDao implements KodeverkDaoApi {

	private final String VAREGRUPPER_FIL = "varegrupper.xml";

	/**
	 * Front - Facade - orkestrator. Kaller backend metoder - som også ligger i denne klassen.
	 * 
	 */
	@Override
	public List<TypeVerdi> lesAlleVaregrupper() {
		List<TypeVerdi> varegrupper = new ArrayList<TypeVerdi>();

		TypeVerdiListe typeVerdiListe = lesListeFraXmlFil(VAREGRUPPER_FIL);
		if (typeVerdiListe == null) {
			return varegrupper;
		} else {
			return typeVerdiListe.getListe();
		}		
	}

	
	/**
	 * Frontend - facade
	 */
	@Override
	public NyVerdiRespons lagreNyVaregruppe(String nyVaregruppeNavn) {

		// 1: xml-fil til objekt
		// 2: legg til ny varegruppe
		// 3: lagre med JAXB


		// 1: xml-fil til objekt
		 TypeVerdiListe varegrupperListe = lesListeFraXmlFil(VAREGRUPPER_FIL);	
		 if (varegrupperListe == null) {
			 varegrupperListe = new TypeVerdiListe("varegrupper", "Varegrupper");
		 }

		// 2: legg til ny varegruppe
		String nyVaregruppeType = nyVaregruppeNavn.toLowerCase().replaceAll(" ", "").replaceAll("æ", "ae").replaceAll("ø", "oe").replaceAll("å", "aa");
		TypeVerdi nyVaregruppe = new TypeVerdi(nyVaregruppeType, nyVaregruppeNavn);		
		varegrupperListe.getListe().add(nyVaregruppe);
		// TODO: Sjekk at type ikke fins fra før 
		
		// 3: lagre med JAXB
		skrivListeTilXmlFil(varegrupperListe, VAREGRUPPER_FIL);

		return new NyVerdiRespons("status", "feilkode", "melding");
	}

	/*
	 * Backend - fil til objekt
	 */
	private TypeVerdiListe lesListeFraXmlFil(String filnavn) {
		TypeVerdiListe typeVerdiListe = new TypeVerdiListe();
		
		File file = new File(filnavn);		
		if (!file.exists()) {
			return null;
		}
		
		JAXBContext jaxbContext = null;
		Unmarshaller jaxbUnmarshaller = null;
		try {
			jaxbContext = JAXBContext.newInstance(TypeVerdiListe.class);
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			typeVerdiListe = (TypeVerdiListe) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			// TODO Kast exception om at det er feil i fil			
			e.printStackTrace();
		}
		return typeVerdiListe;
	}

	/*
	 * Backend - objekt til fil
	 */
	private boolean skrivListeTilXmlFil(TypeVerdiListe liste, String filnavn) {
		
		File file = new File(filnavn);		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		JAXBContext jaxbContext = null;
		Marshaller jaxbMarshaller = null;
		try {
			jaxbContext = JAXBContext.newInstance(TypeVerdiListe.class);
			jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(liste, file);
			jaxbMarshaller.marshal(liste, System.out);
		} catch (JAXBException e) {
			// TODO Kast exception om at lagreing til fil gikk feil			
			e.printStackTrace();
		}
		return true;
	}
	
}
