# User Query
This is simple api which covers the native query in spring boot

## Frameworks and Language

In this web api I used the Spring Boot Framework, Java language and for database I used mysql.

## Dataflow
controller => services => Repository

### Database design
int id primary key auto increment,
String first_name, 
String last_name, 
String age, 
Timestamp admission_date, 
Timestamp created_at, 
Timestamp updated_at,

## Data Structured
To making this project I used ArrayList, and HashMap Data structure.

## Project Summery
This is basically the web api project to manage the user data.

## Endpoints
### Create User
curl --location 'localhost:8080/api/v1/users' \
--header 'Content-Type: application/json' \
--data '{
"firstName":"Prakash",
"lastName":"Kumar",
"age": 24,
"active": true
}'

### Get All Users
curl --location 'localhost:8080/api/v1/users' \
--header 'Content-Type: application/json' \
--data '{
"firstName":"Prakash",
"lastName":"Kumar",
"age": 24,
"active": true
}'

### Get User By Id
curl --location --request GET 'localhost:8080/api/v1/users/id/4' \
--header 'Content-Type: application/json' \
--data '{
"firstName":"Bikash",
"lastName":"Singh",
"age": 24,
"active": true
}'

### Get User By First Name
curl --location --request GET 'localhost:8080/api/v1/users/firstName/sonu' \
--header 'Content-Type: application/json' \
--data '{
"firstName":"Bikash",
"lastName":"Singh",
"age": 24,
"active": true
}'

## Get User By Last Name
curl --location --request GET 'localhost:8080/api/v1/users/lastName/Sinha' \
--header 'Content-Type: application/json' \
--data '{
"firstName":"Bikash",
"lastName":"Singh",
"age": 24,
"active": true
}'

### Get User By Age
curl --location --request GET 'localhost:8080/api/v1/users/age/24' \
--header 'Content-Type: application/json' \
--data '{
"firstName":"Bikash",
"lastName":"Singh",
"age": 24,
"active": true
}'

### Active user by active status
curl --location --request GET 'localhost:8080/api/v1/users/active/false' \
--header 'Content-Type: application/json' \
--data '{
"firstName":"Bikash",
"lastName":"Singh",
"age": 24,
"active": true
}'