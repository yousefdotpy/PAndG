package com.packngo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packngo.Exception.AmenitiesNotFoundException;
import com.packngo.Exception.ListingAmenitiesException;
import com.packngo.Exception.ListingNotFoundException;
import com.packngo.Service.ListingAmenitiesService;

@RestController
@RequestMapping("/listingAmenities")
public class ListingAmenitiesController {
	@Autowired
	private ListingAmenitiesService listingAmenitiesService;
	
	@PostMapping("/add/listingId/{listingId}/AmenitiesId/{amenitesId}")
	public ResponseEntity<String> assignListingAmenities(@PathVariable("listingId")Integer listingId,
				@PathVariable("amenitesId")Integer amenitesId) throws AmenitiesNotFoundException,ListingNotFoundException{
		return new ResponseEntity<String>(listingAmenitiesService.assignListingAmenities(listingId, amenitesId),HttpStatus.CREATED);
	}
	@DeleteMapping("/delete/listingAmenitiesId/{listingAmenitiesId}")
	public ResponseEntity<String> assignListingAmenities(@PathVariable("listingAmenitiesId")Integer listingAmenitiesId) throws ListingAmenitiesException	{
		return new ResponseEntity<String>(listingAmenitiesService.deleteListingAmenities(listingAmenitiesId),HttpStatus.OK);
	}
}
