package com.foodDelivery.demo;

//import com.foodDelivery.demo.Model.Role;
//import com.foodDelivery.demo.Model.User;
import com.foodDelivery.demo.Entity.User;
import com.foodDelivery.demo.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication(scanBasePackages = {"com.foodDelivery.demo.*"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveUser(new User(1, "Akshat", "Sinha", "akshat97", "akshatsinha97@gmail.com", "12345", new ArrayList<>()));
		};
	}


}
