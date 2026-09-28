package com.rentx.controller;

import com.rentx.model.*;
import com.rentx.repository.*;
import org.springframework.web.bind.annotation.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

@RestController @RequestMapping("/api/orders") @CrossOrigin
public class OrderController {
 private final OrderRepository orders; private final OrderItemRepository items; private final ProductRepository products;
 public OrderController(OrderRepository orders,OrderItemRepository items,ProductRepository products){
  this.orders=orders;this.items=items;this.products=products;
 }

 public static class CartLine {
  public Long productId; public int quantity;
 }
 public static class CheckoutRequest {
  public String customerName,customerEmail,phone,address,startDate,endDate,paymentMethod;
  public List<CartLine> items;
 }

 @PostMapping
 public Map<String,Object> create(@RequestBody CheckoutRequest req){
  if(req.items==null || req.items.isEmpty()) throw new IllegalArgumentException("Cart is empty");
  var start=java.time.LocalDate.parse(req.startDate); var end=java.time.LocalDate.parse(req.endDate);
  long days=ChronoUnit.DAYS.between(start,end);
  if(days<1) throw new IllegalArgumentException("End date must be after start date");

  double subtotal=0,deposit=0;
  List<Product> selected=new ArrayList<>();
  for(CartLine line:req.items){
   Product p=products.findById(line.productId).orElseThrow();
   if(!p.isAvailable()) throw new IllegalStateException(p.getName()+" is unavailable");
   if(line.quantity<1 || line.quantity>3) throw new IllegalArgumentException("Quantity must be 1-3");
   selected.add(p);
   subtotal += p.getPricePerDay()*days*line.quantity;
   deposit += p.getSecurityDeposit()*line.quantity;
  }

  Order o=new Order();
  o.setCustomerName(req.customerName);o.setCustomerEmail(req.customerEmail);o.setPhone(req.phone);
  o.setAddress(req.address);o.setStartDate(start);o.setEndDate(end);o.setDays((int)days);
  o.setRentalSubtotal(subtotal);o.setSecurityDeposit(deposit);o.setGrandTotal(subtotal+deposit);
  o.setPaymentMethod(req.paymentMethod==null?"DEMO":req.paymentMethod);
  o.setPaymentStatus("PAID");o.setStatus("CONFIRMED");
  o=orders.save(o);

  int i=0;
  for(CartLine line:req.items){
   Product p=selected.get(i++);
   items.save(new OrderItem(o.getId(),p.getId(),p.getName(),line.quantity,p.getPricePerDay(),
     p.getPricePerDay()*days*line.quantity));
   p.setAvailable(false);products.save(p);
  }
  return Map.of("orderId",o.getId(),"message","Rental confirmed","total",o.getGrandTotal());
 }

 @GetMapping("/{id}")
 public Map<String,Object> get(@PathVariable Long id){
  Order o=orders.findById(id).orElseThrow();
  return Map.of("order",o,"items",items.findByOrderId(id));
 }

 @GetMapping("/customer")
 public List<Order> customer(@RequestParam String email){
  return orders.findByCustomerEmailIgnoreCaseOrderByCreatedAtDesc(email);
 }

 @PutMapping("/{id}/cancel")
 public Order cancel(@PathVariable Long id){
  Order o=orders.findById(id).orElseThrow();
  o.setStatus("CANCELLED");
  for(OrderItem item:items.findByOrderId(id)){
   products.findById(item.getProductId()).ifPresent(p->{p.setAvailable(true);products.save(p);});
  }
  return orders.save(o);
 }
}
