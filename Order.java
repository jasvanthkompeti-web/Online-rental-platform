package com.rentx.model;
import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name="rental_orders")
public class Order {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String customerName, customerEmail, phone, address;
 private LocalDate startDate,endDate;
 private int days;
 private double rentalSubtotal, securityDeposit, grandTotal;
 private String paymentMethod, paymentStatus="PAID", status="CONFIRMED";
 private LocalDateTime createdAt=LocalDateTime.now();

 public Order(){}
 public Long getId(){return id;} public String getCustomerName(){return customerName;}
 public String getCustomerEmail(){return customerEmail;} public String getPhone(){return phone;}
 public String getAddress(){return address;} public LocalDate getStartDate(){return startDate;}
 public LocalDate getEndDate(){return endDate;} public int getDays(){return days;}
 public double getRentalSubtotal(){return rentalSubtotal;} public double getSecurityDeposit(){return securityDeposit;}
 public double getGrandTotal(){return grandTotal;} public String getPaymentMethod(){return paymentMethod;}
 public String getPaymentStatus(){return paymentStatus;} public String getStatus(){return status;}
 public LocalDateTime getCreatedAt(){return createdAt;}
 public void setCustomerName(String v){customerName=v;} public void setCustomerEmail(String v){customerEmail=v;}
 public void setPhone(String v){phone=v;} public void setAddress(String v){address=v;}
 public void setStartDate(LocalDate v){startDate=v;} public void setEndDate(LocalDate v){endDate=v;}
 public void setDays(int v){days=v;} public void setRentalSubtotal(double v){rentalSubtotal=v;}
 public void setSecurityDeposit(double v){securityDeposit=v;} public void setGrandTotal(double v){grandTotal=v;}
 public void setPaymentMethod(String v){paymentMethod=v;} public void setPaymentStatus(String v){paymentStatus=v;}
 public void setStatus(String v){status=v;}
}
