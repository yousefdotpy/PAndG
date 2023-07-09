package com.packngo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packngo.DTO.UsersDTO;
import com.packngo.Exception.UsersNotfoundException;
import com.packngo.JWT.JWTTokenHelper;
import com.packngo.Model.JWTAuthRequest;
import com.packngo.PayLoad.JWTResponseAPI;
import com.packngo.Service.UsersService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private  JWTTokenHelper jwtTokenHelper;
	@Autowired 
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/user/save")
	public ResponseEntity<UsersDTO> registerNewUserHandler(@RequestBody UsersDTO usersDTO) throws UsersNotfoundException{
		return new ResponseEntity<UsersDTO>(usersService.registerNewUser(usersDTO),HttpStatus.CREATED);
	}
	@PostMapping("/admin/save")
	public ResponseEntity<UsersDTO> registerAsAdminHandler(@RequestBody UsersDTO usersDTO) throws UsersNotfoundException{
		return new ResponseEntity<UsersDTO>(usersService.registerAdmin(usersDTO),HttpStatus.CREATED);
	}
	@PostMapping("/login")
	public ResponseEntity<JWTResponseAPI> createJWTToken(@RequestBody JWTAuthRequest jwtAuthRequest) {
		
		this.authenticate(jwtAuthRequest.getUsername(),jwtAuthRequest.getPassword());
		UserDetails userDetails=userDetailsService.loadUserByUsername(jwtAuthRequest.getUsername());
		String token=jwtTokenHelper.generateToken(userDetails);
		JWTResponseAPI jwtResponseAPI=new JWTResponseAPI();
		jwtResponseAPI.setToken(token);
		return new ResponseEntity<JWTResponseAPI>(jwtResponseAPI,HttpStatus.ACCEPTED);
	}
	private void authenticate(String username, String password) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(username, password);
		
		authenticationManager.authenticate(usernamePasswordAuthenticationToken);
	}
	
}
