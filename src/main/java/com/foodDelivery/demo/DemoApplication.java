package com.foodDelivery.demo;

import com.foodDelivery.demo.Model.Role;
import com.foodDelivery.demo.Model.User;
import com.foodDelivery.demo.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	UserRepository userRepository;

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception{
//		//Inserting the data into MySQL table at startup
//		Role userRole1 = new Role(1, "Admin",null);
//		Role userRole2 = new Role(2, "User",null);

//		userRepository.save(userRole1);
//	}
}
