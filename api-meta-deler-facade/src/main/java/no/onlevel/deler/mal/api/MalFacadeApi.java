package no.onlevel.deler.meta.api;

import java.util.List;

import no.onlevel.deler.meta.dto.PartDto;
import no.onlevel.deler.meta.dto.PropertyDto;
import no.onlevel.deler.meta.dto.PropertyValueDto;

public interface ReadMetaFacadeApi {

	List<PartDto> getPartTypes();
	
	List<PropertyDto> getPropertyTypes();
	
	List<PropertyValueDto> getPropertyValues(int propertyId);
	
	void createPart(PartDto part);
	
	void createProperty(PropertyDto property); 
	
	void addPropertyValue(int propertyId, PropertyValueDto property);
	
	
}
