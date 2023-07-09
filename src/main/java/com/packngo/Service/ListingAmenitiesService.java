package com.packngo.Service;

import com.packngo.Exception.AmenitiesNotFoundException;
import com.packngo.Exception.ListingAmenitiesException;
import com.packngo.Exception.ListingNotFoundException;

public interface ListingAmenitiesService {

	
	public String assignListingAmenities(Integer listingId,Integer amenitiesId)throws
					AmenitiesNotFoundException,ListingNotFoundException;
	public String deleteListingAmenities(Integer listingAmenityId) throws ListingAmenitiesException;
	
	
	
}
