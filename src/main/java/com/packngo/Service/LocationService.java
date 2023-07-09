package com.packngo.Service;

import java.util.List;

import com.packngo.DTO.LocationDTO;
import com.packngo.Exception.LocationNotFoundException;

public interface LocationService {

	
	public LocationDTO enterLocation(LocationDTO locationDTO) throws LocationNotFoundException;
	
	public String deleteLocation(Integer locationID)throws LocationNotFoundException;
	
	public LocationDTO getLocationById(Integer locationId) throws LocationNotFoundException;
	
	public List<LocationDTO> getAllLocation() throws LocationNotFoundException;
	
	public LocationDTO updateLocationDto(Integer locationId, LocationDTO locationDTO) throws LocationNotFoundException;
	
	
}
