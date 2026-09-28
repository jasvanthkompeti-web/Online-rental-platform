package com.rentx.controller;
import com.rentx.model.Product;
import com.rentx.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController @RequestMapping("/api/products") @CrossOrigin
public class ProductController {
 private final ProductRepository repo;
 public ProductController(ProductRepository repo){this.repo=repo;}
 @GetMapping public List<Product> all(){return repo.findAll();}
 @GetMapping("/{id}") public Product one(@PathVariable Long id){return repo.findById(id).orElseThrow();}
 @GetMapping("/search") public List<Product> search(@RequestParam String q){
  return repo.findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(q,q);
 }
 @GetMapping("/category/{category}") public List<Product> category(@PathVariable String category){
  return repo.findByCategoryIgnoreCase(category);
 }
}
