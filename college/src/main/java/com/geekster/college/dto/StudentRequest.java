package com.geekster.college.dto;
import com.geekster.college.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentRequest {
    private String name;
    private String age;
    private String phoneNumber;
    private String branch;
    private String department;

    private Address address;
}
