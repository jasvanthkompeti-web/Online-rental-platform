package com.rentx.repository;
import com.rentx.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface ProductRepository extends JpaRepository<Product,Long>{
 List<Product> findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(String name,String brand);
 List<Product> findByCategoryIgnoreCase(String category);
}
