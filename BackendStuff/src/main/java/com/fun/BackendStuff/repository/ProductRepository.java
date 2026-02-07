package com.fun.BackendStuff.repository;

import java.util.*;
import com.fun.BackendStuff.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product,Long> {


    @Query("SELECT p FROM Product p WHERE p.category.categoryId=:cId")
    List<Product>findProductsByCategory(@Param("cId") long categoryId);
    boolean existsByProductNameAndCategory_CategoryId(String productName,long categoryId);
}
