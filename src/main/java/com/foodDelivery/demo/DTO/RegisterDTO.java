package com.foodDelivery.demo.DTO;

import com.foodDelivery.demo.Model.Role;
import lombok.Data;

import java.util.List;

@Data
public class RegisterDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private List<Role> roles;
}
