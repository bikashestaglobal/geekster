package com.geekster.chatty.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number is not valid")
    private String mobile;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Min(5)
    private String password;
}
