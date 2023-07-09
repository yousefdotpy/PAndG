package com.packngo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packngo.Model.Reviews;

public interface ReviewRepository extends JpaRepository<Reviews, Integer>{
	

}
