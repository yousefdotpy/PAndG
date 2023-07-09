package com.packngo.Model;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Bookings")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	@Column(name ="check_in" )
	private LocalDate checkIn;
	@Column(name ="check_out" )
	private LocalDate checkOut;
	@Column(name ="total_price" )
	private double totalPrice;
//	@Enumerated(EnumType.STRING)
    private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinTable(name = "guest_id")
	@JoinColumn (name = "guest_id")
	private Users users;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "listing_id")
	private Listing listing;


	


}
