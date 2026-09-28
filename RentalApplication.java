package com.rentx;

import com.rentx.model.Product;
import com.rentx.repository.ProductRepository;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentalApplication {
  public static void main(String[] args) {
    SpringApplication.run(RentalApplication.class, args);
  }

  @Bean
  CommandLineRunner seed(ProductRepository repo) {
    return args -> {
      if (repo.count() == 0) {
        repo.save(new Product("MacBook Air M2","Apple","Laptop",
          "13-inch laptop for study, coding and work.",999,5000,
          "https://images.unsplash.com/photo-1517336714739-489689fd1ca8"));
        repo.save(new Product("iPhone 15 Pro","Apple","Smartphone",
          "Premium smartphone for photography, work and entertainment.",799,5000,
          "https://images.unsplash.com/photo-1695048133142-1a20484d2569"));
        repo.save(new Product("Sony Alpha Camera","Sony","Camera",
          "Mirrorless camera for travel, events and content creation.",699,4000,
          "https://images.unsplash.com/photo-1516035069371-29a1b244cc32"));
        repo.save(new Product("iPad Air","Apple","Tablet",
          "Lightweight tablet for study, design and entertainment.",499,3000,
          "https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0"));
        repo.save(new Product("Dell XPS 15","Dell","Laptop",
          "High-performance Windows laptop for professional work.",899,4500,
          "https://images.unsplash.com/photo-1593642702821-c8da6771f0c6"));
        repo.save(new Product("Galaxy S24","Samsung","Smartphone",
          "Modern Android smartphone with a high-quality display.",599,3500,
          "https://images.unsplash.com/photo-1610945415295-d9bbf067e59c"));
      }
    };
  }
}
