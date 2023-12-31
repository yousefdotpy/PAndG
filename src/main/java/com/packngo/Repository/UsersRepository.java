package com.packngo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packngo.Model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	public Optional<Users> findByEmail(String email);
	
}
