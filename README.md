# RentX Pro — Electronics Rental Platform

A full-stack electronics rental application built with Spring Boot, PostgreSQL, HTML, CSS and JavaScript.

## Features
- Product catalog for laptops, iPhones, cameras and tablets
- Search and category filtering
- Product details
- Add to cart
- Cart quantity controls
- Rental start/end dates
- Automatic rental-day and subtotal calculation
- Checkout/customer details
- Demo payment flow
- Rental order creation
- Invoice/bill page and printable bill
- Rental history lookup by email
- Cancel rental and release product
- PostgreSQL persistence
- Render deployment configuration

## Local setup
Requirements: Java 17+, Maven, PostgreSQL.

Create database:
`rentaldb`

Default local credentials in application.properties:
username `postgres`, password `postgres`.

Run:
`cd backend`
`mvn spring-boot:run`

Open:
`http://localhost:8080`

## API
GET `/api/products`
GET `/api/products/{id}`
GET `/api/products/search?q=iphone`
POST `/api/orders`
GET `/api/orders/{id}`
GET `/api/orders/customer?email=...`
PUT `/api/orders/{id}/cancel`

## Render
Push the whole project to GitHub and create a Render Blueprint using `render.yaml`.

## Important
The payment screen is a DEMO payment flow. Do not collect real card numbers in this starter project. For real payments, integrate a PCI-compliant provider such as Razorpay or Stripe and verify payments server-side.
