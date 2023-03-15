package com.geekster.awsmysql.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostRequest {
    @NotBlank
    @NotEmpty
    private String title;

    @NotBlank
    @NotEmpty
    private String description;
}
