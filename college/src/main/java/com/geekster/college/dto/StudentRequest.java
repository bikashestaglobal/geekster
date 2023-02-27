package com.geekster.college.dto;
import com.geekster.college.model.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String age;

    @NotBlank
    private String phoneNumber;
    private String branch;
    private String department;

    private Address address;
}
