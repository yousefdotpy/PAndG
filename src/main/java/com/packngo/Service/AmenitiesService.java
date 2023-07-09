package com.packngo.Service;

import java.util.List;

import com.packngo.DTO.AmenitiesDTO;
import com.packngo.Exception.AmenitiesNotFoundException;

public interface AmenitiesService {

	public AmenitiesDTO addAmenities(AmenitiesDTO amenitiesDTO) throws AmenitiesNotFoundException;
	
	public String deleteAmenities(Integer id) throws AmenitiesNotFoundException;
	
	public AmenitiesDTO getByID(Integer id) throws AmenitiesNotFoundException;
	
	public List<AmenitiesDTO> getAllAmenities();
	
	public AmenitiesDTO updateAmenity(Integer id, AmenitiesDTO amenitiesDTO) throws AmenitiesNotFoundException;
	
	
}
