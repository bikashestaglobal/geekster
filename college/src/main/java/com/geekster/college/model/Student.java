package com.geekster.college.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Entity
@Table(name = "student_tbl")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String age;

    @Column(name = "phone_number")
    private String phoneNumber;
    private String branch;
    private String department;

    @ManyToMany(mappedBy = "studentList")
    @JsonBackReference
    private List<Course> courseList;
    @Embedded
    private Address address;
}
