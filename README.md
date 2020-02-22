# SqlWithRestApplication
This is a simple application for inroduction to Rest services which server data from Sql DB.

# STEP 1: Set up a sql db. 

To create DB: 
CREATE DATABASE user_db;
CREATE USER 'user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON user_db.*  TO 'user'@'localhost';

To see entries in the DB:
select * from user_db.employee;

Before production:
revoke all on db_example.* from 'springuser'@'localhost';
grant select, insert, delete, update on db_example.* to 'springuser'@'localhost';


# STEP 2: Execute the code. 

References:
https://www.javahelps.com/2017/11/restful-crud-with-java-and-mysql-in.html
https://spring.io/guides/gs/accessing-data-mysql/
https://kyup.com/tutorials/create-new-user-grant-permissions-mysql/
https://spring.io/guides/gs/accessing-data-mysql/
