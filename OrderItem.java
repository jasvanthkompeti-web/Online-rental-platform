package com.rentx.model;
import jakarta.persistence.*;

@Entity
@Table(name="order_items")
public class OrderItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private Long orderId, productId;
 private String productName;
 private int quantity;
 private double pricePerDay, lineTotal;

 public OrderItem(){}
 public OrderItem(Long orderId,Long productId,String productName,int quantity,double pricePerDay,double lineTotal){
  this.orderId=orderId;this.productId=productId;this.productName=productName;this.quantity=quantity;
  this.pricePerDay=pricePerDay;this.lineTotal=lineTotal;
 }
 public Long getId(){return id;} public Long getOrderId(){return orderId;} public Long getProductId(){return productId;}
 public String getProductName(){return productName;} public int getQuantity(){return quantity;}
 public double getPricePerDay(){return pricePerDay;} public double getLineTotal(){return lineTotal;}
}
