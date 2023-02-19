# E Commerce Api

It is a simple Online Shopping API that is written in Spring Boot

## Dataflow

Controller->Service->Repository->Database

## Database Design
This API has basically four tables, user, address, product, and orders.

## API Endpoints

## User API Details
```bash
Endpoints             Method         Description 
-> /api/v1/users       GET           get All Users
-> /api/v1/users/1     GET           get User by id
-> /api/v1/users       POST          create user
-> /api/v1/users/1     PUT           update User
-> /api/v1/users/1     DELETE        delete User

```

## Address API Details
```bash
Endpoints               Method         Description 
-> /api/v1/address       GET           get All address
-> /api/v1/address/1     GET           get address by id
-> /api/v1/address       POST          create address
-> /api/v1/address/1     PUT           update address
-> /api/v1/address/1     DELETE        delete address

```


## Product API Details
```bash
Endpoints               Method         Description 
-> /api/v1/products       GET           get All products
-> /api/v1/products/1     GET           get product by id
-> /api/v1/products       POST          create product
-> /api/v1/products/1     PUT           update product
-> /api/v1/products/1     DELETE        delete product
```

## Order API Details
```bash
Endpoints               Method         Description 
-> /api/v1/orders       GET           get All orders
-> /api/v1/orders/1     GET           get order by id
-> /api/v1/orders       POST          create orders
-> /api/v1/orders/1     PUT           update order
-> /api/v1/orders/1     DELETE        delete order
```

## Summery
It is a simple E-Commerce web API that is written in spring boot