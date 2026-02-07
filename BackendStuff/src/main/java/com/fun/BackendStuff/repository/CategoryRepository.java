package com.fun.BackendStuff.repository;

import com.fun.BackendStuff.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category>findByCategoryName(String cName);

    boolean existsByCategoryName(String cName);
}
