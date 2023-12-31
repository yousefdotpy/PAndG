package com.packngo;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.packngo.Model.Roles;
import com.packngo.Repository.RoleRepository;
import com.packngo.Security.AppConstant;

@SpringBootApplication
public class PackAndGo implements CommandLineRunner{

	@Autowired
	private RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PackAndGo.class, args);
		System.out.println("Running");
	}
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
	@Override
	public void run(String... args) throws Exception {
	
		Roles  roles = new Roles();
		roles.setRoleId(AppConstant.ADMIN_USER);
		roles.setRoleName("ROLE_ADMIN");
		
		Roles  roles1 = new Roles();
		roles1.setRoleId(AppConstant.NORMAL_USER);
		roles1.setRoleName("ROLE_USERS");
		
		List<Roles> listofRoles=List.of(roles,roles1);
		
		List<Roles> resullt= roleRepository.saveAll(listofRoles);
		resullt.forEach(s->System.out.println(s.getRoleName()));
	}
	

}
