package com.geekster.hotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRequest {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String ingredients;

    @NotNull
    @NotBlank
    private String instructions;

    @NotNull
    private Integer userId;
}
