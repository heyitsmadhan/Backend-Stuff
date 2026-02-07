package com.fun.BackendStuff.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false,unique = false,length = 50)
    private String productName;

    @Column(nullable = false)
    private BigDecimal productPrice;

    @Column(nullable = false)
    private Integer stockQuantity;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime productCreatedAt;

    @LastModifiedDate
    private LocalDateTime productUpdatedAt;
}
