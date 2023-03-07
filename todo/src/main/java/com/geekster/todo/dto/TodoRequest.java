package com.geekster.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;
    private Boolean status;
}
