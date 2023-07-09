package com.packngo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packngo.Exception.AmenitiesNotFoundException;
import com.packngo.Exception.ListingAmenitiesException;
import com.packngo.Exception.ListingNotFoundException;
import com.packngo.Model.Amenities;
import com.packngo.Model.Listing;
import com.packngo.Model.ListingAmenities;
import com.packngo.Repository.AmenitesRepository;
import com.packngo.Repository.ListingAmenitiesRepository;
import com.packngo.Repository.ListingRepository;

@Service
public class ListingAmenitiesServiceImpl implements ListingAmenitiesService {

	@Autowired 
	private AmenitesRepository amenitesRepository;
	@Autowired 
	private ListingAmenitiesRepository listingAmenitiesRepository;
	@Autowired 
	private ListingRepository listingRepository;
	
	
	
	
	@Override
	public String assignListingAmenities(Integer listingId, Integer amenitiesId)
			throws AmenitiesNotFoundException, ListingNotFoundException {
		
		Listing listing=listingRepository.findById(listingId).orElseThrow(()->new ListingNotFoundException("No Listing is present"));
		Amenities amenities=amenitesRepository.findById(amenitiesId).orElseThrow(()->new AmenitiesNotFoundException("No amenities found.."));
		
		ListingAmenities listingAmenities=new ListingAmenities();
		listingAmenities.setAmenities(amenities);
		listingAmenities.setListing(listing);
		listingAmenitiesRepository.save(listingAmenities);
		return "Assigned Listing-> "+listingId+ " to amenities with-> "+ amenitiesId;
	}




	@Override
	public String deleteListingAmenities(Integer listingAmenityId) throws ListingAmenitiesException {
		ListingAmenities listingAmenities=listingAmenitiesRepository.findById(listingAmenityId)
											.orElseThrow(()->new ListingAmenitiesException("Not present with this id"));
		listingAmenities.setAmenities(null);
		listingAmenities.setListing(null);
		listingAmenitiesRepository.delete(listingAmenities);
		
		return "Successfully deleted......";
	}

	
}
