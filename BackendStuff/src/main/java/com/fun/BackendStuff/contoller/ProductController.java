package com.fun.BackendStuff.contoller;


import com.fun.BackendStuff.DTOs.ProductDTO;
import com.fun.BackendStuff.repository.ProductRepository;
import com.fun.BackendStuff.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping("/createproduct")
    public ResponseEntity<ProductDTO>createProduct(@Valid @RequestBody ProductDTO productDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDTO));
    }

    @GetMapping("/getallproducts/{categoryId}")
    public ResponseEntity<List<ProductDTO>>getAllProductsByCategory(@PathVariable long categoryId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProductByCategoryId(categoryId));
    }

    @GetMapping("/getproduct/{productId}")
    public ResponseEntity<ProductDTO>getProductById(@PathVariable long productId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(productId));
    }

    @GetMapping("/productcheck")
    public ResponseEntity<String>check()
    {
        return ResponseEntity.status(HttpStatus.OK).body("Product endpoint is working!");
    }
}
