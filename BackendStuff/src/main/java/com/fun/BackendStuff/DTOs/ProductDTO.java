package com.fun.BackendStuff.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO
{
    private Long productId;

    @NotBlank(message = "product name cannot be blank")
    @Size(min = 3,max = 50)
    private String productName;

    @NotNull
    @DecimalMin(value = "10.0",inclusive = false)
    private BigDecimal productPrice;

    @NotNull
    @Min(0)
    private Integer stockQuantity;

    @NotNull
    private Long categoryId;

    private LocalDateTime productCreatedAt;

    private LocalDateTime productUpdatedAt;
}
