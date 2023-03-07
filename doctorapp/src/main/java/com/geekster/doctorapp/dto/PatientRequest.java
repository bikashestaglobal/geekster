package com.geekster.doctorapp.dto;

import com.geekster.doctorapp.model.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor()
@NoArgsConstructor
public class PatientRequest {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String mobile;

    @NotNull
    @NotBlank
    private String gender;

    @NotNull
    private Integer doctorId;

    @NotNull
    @NotBlank
    private String age;

}
