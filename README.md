# ecommerce-test
ecommerce-test

# Users Service
The service can show all list of users, create update and delete

to run this service you need installed java version 11 , maven and docker

to run unit test execute the command *mvn clean install verify -DiTests* 

on the postman folder there is a collection to test this service

you can edit the users

you can see all the users

# Endpoints method action

- /users get  -> get all usera
- /users/user/{userId} get  -> get user byID
- /users/user/{userId} put  -> update user
- /users/user post  -> create user
- /users/user/{userId} delete  -> delete user

# Products Service
This service can show all list of products, create update and delete

to run this service you need installed java version 11 , maven and docker

on the postman folder there is a collection to test this service

you can edit products

you can see all the produts 

# Endpoints method action

- /products get  -> get all products
- /products/product/{productId} get  -> get product byID
- /products/product/{productId} put  -> update product
- /products/product post  -> create product
- /products/product/{productId} delete  -> delete product


Diagram is here [ecommerce diagram](https://lucid.app/lucidchart/38e5afa4-132e-4464-8026-af5bde8f4a15/edit?viewport_loc=-2206%2C-1215%2C5919%2C3052%2C0_0&invitationId=inv_f9c85f1e-6fa3-4448-b708-ccc24e1fe7ca)

Typically, the service is started on port 8082. It can be run within a Docker container with a connection to PostgreSQL. More details on how to start the application will be provided in the [HELP.md](./HELP.md) file.

swagger documentation is here [SWAGGER](http://localhost:8082/ecommerce-service/swagger-ui/index.html#/products-controller/saveProductUsingPOST)