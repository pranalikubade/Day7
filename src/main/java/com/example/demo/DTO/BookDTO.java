package com.example.demo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public class BookDTO {
    @NotBlank(message = "Name is required")
    public String name;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "Invalid email format")
    @NotBlank(message = "Email is required")
    public String email;

    @NotBlank(message = "Phone number is required")
   @Pattern(regexp = "^(?:(?:\\\\+91)|(?:91)|(?:0))[7-9][0-9]{9}$", message = "Invalid phone number")
    public String phoneNumber;

    public String city;

    @NotNull(message = "Address is required")
    public String address;
    public String pin;
    public String state;
}
