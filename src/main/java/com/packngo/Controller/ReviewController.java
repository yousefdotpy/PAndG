package com.packngo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packngo.DTO.ReviewDTO;
import com.packngo.DTO.ReviewDTO1;
import com.packngo.Exception.ListingNotFoundException;
import com.packngo.Exception.ReviewNotFoundException;
import com.packngo.Exception.UsersNotfoundException;
import com.packngo.Service.ReviewService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	
	@PostMapping("/add/user/{userid}/listing/{listingid}")
	public ResponseEntity<ReviewDTO> addReviewHandler(@RequestBody ReviewDTO reviewDTO,@PathVariable("userid")Integer userid,
						@PathVariable("listingid")Integer listingid)throws ListingNotFoundException,UsersNotfoundException{
		return new ResponseEntity<ReviewDTO>(reviewService.addComment(userid, listingid, reviewDTO),HttpStatus.CREATED);
	}
	@DeleteMapping("delete/review/{reviewid}")
	public ResponseEntity<String> deleteReviewHandler(@PathVariable("reviewid")Integer reviewid)throws ReviewNotFoundException{
		return new ResponseEntity<String>(reviewService.deleteComment(reviewid),HttpStatus.OK);
	}
	@PutMapping("update/review/{reviewid}")
	public ResponseEntity<ReviewDTO1> updateReviewHandler(@PathVariable("reviewid")Integer reviewid,@RequestBody ReviewDTO1 reviewDTO1)
		throws ReviewNotFoundException{
		
		return new ResponseEntity<ReviewDTO1>(reviewService.update(reviewid, reviewDTO1),HttpStatus.ACCEPTED);
	}
}
