package com.geekster.doctorapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor()
@NoArgsConstructor
public class DoctorRequest {
    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String mobile;

    @NotBlank
    @NotNull
    private String speciality;
}
