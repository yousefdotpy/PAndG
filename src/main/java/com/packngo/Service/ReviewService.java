package com.packngo.Service;

import com.packngo.DTO.ReviewDTO;
import com.packngo.DTO.ReviewDTO1;
import com.packngo.Exception.ListingNotFoundException;
import com.packngo.Exception.ReviewNotFoundException;
import com.packngo.Exception.UsersNotfoundException;

public interface ReviewService {

	public ReviewDTO addComment(Integer userId,Integer listingId,ReviewDTO reviewDTO)throws
		UsersNotfoundException,ListingNotFoundException;
	public String deleteComment(Integer reviewId) throws ReviewNotFoundException;
	
	public ReviewDTO1 update(Integer reviewId,ReviewDTO1 reviewDTO)  throws ReviewNotFoundException;
}
