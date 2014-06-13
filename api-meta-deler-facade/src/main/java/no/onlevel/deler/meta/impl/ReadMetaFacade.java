package no.onlevel.deler.meta.impl;

import java.util.List;

import no.onlevel.deler.meta.api.ReadMetaFacadeApi;
import no.onlevel.deler.meta.dto.PartDto;
import no.onlevel.deler.meta.dto.PropertyDto;
import no.onlevel.deler.meta.dto.PropertyValueDto;

public class ReadMetaFacade implements ReadMetaFacadeApi {
// les eksisterende info
	public List<PartDto> getPartTypes() {		
		return null;
	}
	
	public List<PropertyDto> getPropertyTypes() {		
		return null;
	}
	
	public List<PropertyValueDto> getPropertyValues(int propertyId) {		
		return null;
	}

	public void createPart(PartDto part) {
		
	}
	
	public void createProperty(PropertyDto property) {
	}
	
	public void addPropertyValue(int propertyId, PropertyValueDto property) {
	}
	
	//	- vis noen/tilat alle - vis+tillat=begrenset - vis/tillat = alle
	
 /*    createNewPartType(properties)
 * 4. Endre/Slette
 *    addvalue(propId)
 *    removeValue(propId)
 *    addPropertyToPart(id)
 *    removePropertyFromPart(id, prop)
 *    removepart(id)
 * 
 * 
 * Template:
 * C: partType -> partId...
 *   D: name
 *   C: partType
 * */
}
