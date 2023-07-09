package com.packngo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packngo.Model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
