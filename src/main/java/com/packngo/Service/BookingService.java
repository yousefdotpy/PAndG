package com.packngo.Service;

import java.util.List;

import com.packngo.DTO.BookingDTO;
import com.packngo.DTO.BookingObjDto;
import com.packngo.Exception.BookingNotFoundException;
import com.packngo.Exception.ListingNotFoundException;
import com.packngo.Exception.UsersNotfoundException;

public interface BookingService {

	public BookingDTO createBookingByUser(Integer userId, Integer listingId, BookingDTO bookingDTO ) throws BookingNotFoundException,
	UsersNotfoundException,ListingNotFoundException;
	public String deleteBooking(Integer userId, Integer bookingId) throws UsersNotfoundException,BookingNotFoundException;
	
	public BookingDTO getBookingById(Integer bookingId)throws BookingNotFoundException;
	
	public List<BookingDTO> getAllBooking()throws BookingNotFoundException;
	
	public BookingObjDto updateBooking(Integer bookingId,BookingObjDto bookingObjDto)throws BookingNotFoundException;
	 
	
}
