package com.packngo.Service;

import java.util.List;

import com.packngo.DTO.ListingDTO;
import com.packngo.Exception.ListingNotFoundException;
import com.packngo.Exception.LocationNotFoundException;
import com.packngo.Exception.UsersNotfoundException;
import com.packngo.Model.ListingResponse;

public interface ListingService {

	public ListingDTO createListing(Integer userId, Integer locationId, ListingDTO listingDTO) 
			throws UsersNotfoundException,LocationNotFoundException,ListingNotFoundException;
	public String deleteListing(Integer userId,Integer listingId) throws UsersNotfoundException,ListingNotFoundException;
	
	public ListingDTO getListing(Integer listingId) throws ListingNotFoundException;
	
	public List<ListingDTO> getAllListingByUser(Integer userId) throws UsersNotfoundException,ListingNotFoundException;
	
	public ListingDTO updateListing(ListingDTO listingDTO,Integer listingId)throws ListingNotFoundException;
	
	public List<ListingDTO>  getAllListingDetails()throws ListingNotFoundException;
	
	public List<ListingDTO> searchByTitle(String keyword) throws ListingNotFoundException;
	
	public ListingResponse getAllListingByUser(Integer userId,Integer pageNo,Integer pageSize) throws UsersNotfoundException,ListingNotFoundException;
	
	public List<ListingDTO> searchByDescription(String key); 
	
//	sortby normal id---- accsending
	
}
