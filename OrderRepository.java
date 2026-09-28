package com.rentx.repository;
import com.rentx.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface OrderRepository extends JpaRepository<Order,Long>{
 List<Order> findByCustomerEmailIgnoreCaseOrderByCreatedAtDesc(String email);
}
