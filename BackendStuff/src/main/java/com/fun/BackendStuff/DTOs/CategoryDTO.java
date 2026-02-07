package com.fun.BackendStuff.DTOs;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long categoryId;

    @NotBlank(message = "category name is required")
    @Size(min = 3,max = 50,message = "category name must be between 3 and 50 characters length")
    private String categoryName;
    private LocalDateTime categoryCreatedAt;
    private LocalDateTime categoryUpdatedAt;



}
