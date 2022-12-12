package com.foodDelivery.demo;

//import com.foodDelivery.demo.Model.Role;
//import com.foodDelivery.demo.Model.User;
//import com.foodDelivery.demo.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

//	@Autowired
//	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
