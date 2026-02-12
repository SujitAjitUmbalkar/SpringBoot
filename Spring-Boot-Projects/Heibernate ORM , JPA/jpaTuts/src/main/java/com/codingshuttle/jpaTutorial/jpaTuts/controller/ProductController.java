package com.codingshuttle.jpaTutorial.jpaTuts.controller;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.codingshuttle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
public class ProductController
{
    private final ProductRepository productRepository;

@GetMapping
    public   List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "Id") String sortby )
    {
//        return  productRepository.findAll(Sort.by(Sort.Direction.DESC,sortby , "price" , "sku"));

        return productRepository.findAll(Sort.by
                (
                Sort.Order.desc(sortby),
                Sort.Order.asc("price")
                )
        );
    }

}
