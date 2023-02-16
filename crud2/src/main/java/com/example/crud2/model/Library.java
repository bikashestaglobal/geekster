package com.example.crud2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Library {
    private int id;
    private String name;
    private String address;
    private String facilities;
    private String number;


}
