package com.geekster.valiation.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotEmpty(message = "Username must not empty")
    private String userName;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be a valid email")
    private String email;

    @NotNull
    private Date dateOfBirth;

    @Pattern(regexp = "^91[789]\\d{9}$", message = "Mobile must be the valid mobile 91 & 10 digit number")
    private String number;

    @NotNull
    private java.sql.Date date;

    @NotNull
    private Time time;
    private Date createdAt;
    private Date updatedAt;
}
