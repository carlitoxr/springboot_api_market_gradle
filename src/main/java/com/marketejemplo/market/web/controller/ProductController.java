package com.marketejemplo.market.web.controller;

import com.marketejemplo.market.domain.Product;
import com.marketejemplo.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @RequestMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable("productId") int productId) {
        return productService.getProduct(productId);
    }
    @RequestMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId")  int categoryId) {
        return productService.getByCategory(categoryId);
    }
    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }
    @DeleteMapping("/delete/{productId}")
    public boolean delete(@PathVariable("productId") int productId) {
        return productService.delete(productId);
    }
}
