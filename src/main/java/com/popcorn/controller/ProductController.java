package com.popcorn.controller;

import com.popcorn.document.ProductDocument;
import com.popcorn.repository.ProductRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/api/v1/products")
//@RequiredArgsConstructor
@Slf4j
public class ProductController {
    /*private final ProductRepository productRepository;

    @PostMapping
    public ProductDocument createDocument(@RequestBody ProductDocument productDocument) {
        log.info("ProductController::createDocument");
        return productRepository.save(productDocument);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProductDocument> getAllProducts(HttpServletRequest request) {
        log.info("ProductController::getAllProducts");
        return productRepository.findAll();
    }*/
}
