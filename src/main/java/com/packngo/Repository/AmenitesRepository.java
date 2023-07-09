package com.packngo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packngo.Model.Amenities;

public interface AmenitesRepository  extends JpaRepository<Amenities, Integer>{
	
	public Amenities findByAmenityName(String name);

}
