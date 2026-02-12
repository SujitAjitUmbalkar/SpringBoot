package com.codingshuttle.jpaTutorial.jpaTuts.controller;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.codingshuttle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final int PAGE_SIZE = 5;

@GetMapping
    public Page<ProductEntity> getAllProducts(
                                                                                    @RequestParam(defaultValue = "") String title,
                                                                                    @RequestParam(defaultValue = "id") String sortBy,
                                                                                    @RequestParam(defaultValue = "0") Integer pageNumber
                                                                            )
    {
        return productRepository.findByTitleContainingIgnoreCase
            (
                title,
                PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy) )
        );
    }

}
