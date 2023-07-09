package com.packngo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packngo.Model.Bookings;

public interface BookingRepository  extends JpaRepository<Bookings, Integer>{

}
