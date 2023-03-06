package com.geekster.instagram.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUser {
    @NotEmpty(message = "Name must not be empty !")
    private String name;

    @Email(message = "Email must be the valid email !")
    @NotEmpty(message = "Email must not be empty !")
    private String email;

    @NotEmpty(message = "Password must not be Empty")
    @Min(5)
    private String password;
}
