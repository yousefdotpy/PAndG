package com.packngo.Service;

import java.util.List;

import com.packngo.DTO.UsersDTO;
import com.packngo.Exception.UsersNotfoundException;


public interface UsersService {
	
	public UsersDTO registerNewUser(UsersDTO userDto) throws UsersNotfoundException;
	
	public UsersDTO registerAdmin(UsersDTO usersDTO) throws UsersNotfoundException;
	
	public UsersDTO useGetById(Integer userId) throws UsersNotfoundException;
	
	public List<UsersDTO> allUser() throws UsersNotfoundException;
	
	public UsersDTO updateUser(UsersDTO usersDTO, Integer userId) throws UsersNotfoundException;
	
	public String deleteUser(Integer userId) throws UsersNotfoundException;
	
	
	
	
	

}
