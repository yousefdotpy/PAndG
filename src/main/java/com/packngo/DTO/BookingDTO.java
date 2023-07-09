package com.packngo.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
	private Integer bookingId;
	
	private LocalDate checkIn;
	
	private LocalDate checkOut;
	
	private double totalPrice;

	private String status;
	
	private UserDTO1 usersDTO;
	
	private ListingDTO1 listingDTO;
	
	
	
}
