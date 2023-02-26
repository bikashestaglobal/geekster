package com.geekster.college.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaptopRequest {
    private String name;
    private String brand;
    private Integer price;
    private Integer studentId;
}
