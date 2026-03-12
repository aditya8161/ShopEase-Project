package com.ShopEase.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto
{
    @NotBlank(message = "First Name cannot be blank or empty")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank or empty")
    private String lastName;

    @NotBlank(message = "password cannot be blank or empty")
    private String password;

    @NotBlank(message = "Email cannot be blank or empty")
    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
    @NotBlank(message = "Phone cannot be blank or empty")
    private String phone;

    private List<String> phoneList =new ArrayList<>();


    private String role;
}
