package com.rentx.model;
import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String name, brand, category;
 @Column(length=1500) private String description;
 private double pricePerDay, securityDeposit;
 private String imageUrl;
 private boolean available=true;

 public Product(){}
 public Product(String name,String brand,String category,String description,double pricePerDay,double securityDeposit,String imageUrl){
  this.name=name;this.brand=brand;this.category=category;this.description=description;
  this.pricePerDay=pricePerDay;this.securityDeposit=securityDeposit;this.imageUrl=imageUrl;
 }
 public Long getId(){return id;} public String getName(){return name;} public String getBrand(){return brand;}
 public String getCategory(){return category;} public String getDescription(){return description;}
 public double getPricePerDay(){return pricePerDay;} public double getSecurityDeposit(){return securityDeposit;}
 public String getImageUrl(){return imageUrl;} public boolean isAvailable(){return available;}
 public void setName(String v){name=v;} public void setBrand(String v){brand=v;} public void setCategory(String v){category=v;}
 public void setDescription(String v){description=v;} public void setPricePerDay(double v){pricePerDay=v;}
 public void setSecurityDeposit(double v){securityDeposit=v;} public void setImageUrl(String v){imageUrl=v;}
 public void setAvailable(boolean v){available=v;}
}
