package com.foodDelivery.demo;

//import com.foodDelivery.demo.Model.Role;
//import com.foodDelivery.demo.Model.User;
import com.foodDelivery.demo.Entity.User;
import com.foodDelivery.demo.Repository.RoleRepository;
import com.foodDelivery.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;

@SpringBootApplication(scanBasePackages = {"com.foodDelivery.demo.*"})
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
