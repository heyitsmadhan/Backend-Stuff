package com.fun.BackendStuff.service;

import com.fun.BackendStuff.DTOs.CategoryDTO;
import com.fun.BackendStuff.DTOs.ProductDTO;
import com.fun.BackendStuff.entity.Category;
import com.fun.BackendStuff.entity.Product;
import com.fun.BackendStuff.exception.CategoryIdNotFoundException;
import com.fun.BackendStuff.exception.ProductAlreadyExistsException;
import com.fun.BackendStuff.exception.ProductNotFoundException;
import com.fun.BackendStuff.repository.CategoryRepository;
import com.fun.BackendStuff.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    public ProductDTO createProduct(ProductDTO productDTO)
    {
        Category category =  categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new CategoryIdNotFoundException("category with id: "+productDTO.getCategoryId()+"not found!"));

        if(productRepository.existsByProductNameAndCategory_CategoryId(productDTO.getProductName(),productDTO.getCategoryId()))
        {
            throw new ProductAlreadyExistsException("product with name: "+productDTO.getProductName()+"already exits");
        }

        Product product = mapper.map(productDTO, Product.class);
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);
        return mapper.map(savedProduct,ProductDTO.class);
    }

    public List<ProductDTO>getAllProductByCategoryId(long categoryId)
    {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new CategoryIdNotFoundException("category with id: "+categoryId+"not found!"));

        return productRepository.findProductsByCategory(categoryId)
                .stream()
                .map(product -> mapper.map(product,ProductDTO.class))
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(long productId)
    {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ProductNotFoundException("product with id: "+productId+" not found!"));
        return mapper.map(product,ProductDTO.class);
    }

}
