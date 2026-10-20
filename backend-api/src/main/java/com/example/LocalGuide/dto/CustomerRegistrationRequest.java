package com.example.LocalGuide.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerRegistrationRequest (
    @NotBlank @Size(max = 100) String firstName,
    @NotBlank @Size(max = 100) String lastName,
    @NotBlank @Size(max = 100) String state,
    @NotBlank @Size(max = 100) String city,
    @NotBlank @Email @Size(max = 254) String email,
    @NotBlank @Size(min = 8, max = 72) String password,
    @Size(max = 20) String phoneNumber,
    @Size(max = 1000) String bio
)
{}