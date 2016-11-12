package no.onlevel.deler.repo;
import static org.junit.Assert.*;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import no.onlevel.deler.repo.domain.NyVerdiRespons;
import no.onlevel.deler.repo.domain.TypeVerdiListe;

import org.junit.Test;


public class FilOperasjonerTest {

	private final String VAREGRUPPER_FIL = "varegrupper.xml"; 
	@Test
	public void test() {
		// sjekk at filen fins, hvis ikke opprett ny
		// Lagre med type og navn
		// 1: les fil
		// 2: fil til xml (JAXB)
		// 3: les alle typer
		// 4: lag type som er unik
		// 5: legg til ny varegruppe
		// 6: lagre med JAXB
		
		TypeVerdiListe typeVerdiListe = null;
		
		File file = new File(this.getClass().getClassLoader().getResource(VAREGRUPPER_FIL).getFile());		
		if (file.exists()) {						
			JAXBContext jaxbContext = null;
			Unmarshaller jaxbUnmarshaller = null;
			try {
				jaxbContext = JAXBContext.newInstance(TypeVerdiListe.class);
				jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				typeVerdiListe = (TypeVerdiListe) jaxbUnmarshaller.unmarshal(file);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(typeVerdiListe.getNavn());
			System.out.println(typeVerdiListe.getListe().get(0).getNavn());
			System.out.println(typeVerdiListe.getListe().get(1).getNavn());

		}
				
		
		
		
		
//		File file = new File("src/main/resources/varegrupper.xml");
//		
//		if (!file.exists()) {
//			System.out.println("src/main/resources/varegrupper.xml");
//			
//		}
//			JAXBContext jaxbContext = null;
//			Unmarshaller jaxbUnmarshaller = null;
//			TypeVerdiListe typeVerdiListe = null;
//			try {
//				jaxbContext = JAXBContext.newInstance(TypeVerdiListe.class);
//				jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//				typeVerdiListe = (TypeVerdiListe) jaxbUnmarshaller.unmarshal(file);
//			} catch (JAXBException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			System.out.println(typeVerdiListe.getNavn());
//			System.out.println(typeVerdiListe.getTypeVerdiListe().get(0).getNavn());
//			System.out.println(typeVerdiListe.getTypeVerdiListe().get(1).getNavn());
//		
//			//System.out.println(nyVaregruppe + " lagret !!!!! ");
		
	
	}

}
