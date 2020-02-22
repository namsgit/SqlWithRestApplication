package com.naman.sqlrest;

import com.naman.sqlrest.entity.Department;
import com.naman.sqlrest.entity.Employee;
import com.naman.sqlrest.repository.DepartmentRepository;
import com.naman.sqlrest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 https://www.javahelps.com/2017/11/restful-crud-with-java-and-mysql-in.html
 https://spring.io/guides/gs/accessing-data-mysql/
 https://kyup.com/tutorials/create-new-user-grant-permissions-mysql/
 https://spring.io/guides/gs/accessing-data-mysql/

 Things to do on mysql shell for setting up database:
 CREATE DATABASE user_db;
 CREATE USER 'user'@'localhost' IDENTIFIED BY 'password';
 GRANT ALL PRIVILEGES ON user_db.*  TO 'user'@'localhost';

 To see the table entries type following in mysql shell:
  select * from user_db.employee

  Before production
  mysql> revoke all on db_example.* from 'springuser'@'localhost';
  mysql> grant select, insert, delete, update on db_example.* to 'springuser'@'localhost';

*/

@SpringBootApplication
public class SqlOnRestApplication implements CommandLineRunner {
	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SqlOnRestApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Saving dept in the repo");
		Department department = new Department();
		department.setDepartmentName("sag");
		departmentRepository.save(department);

		Department department1 = new Department();
		department1.setDepartmentName("cimd");
		departmentRepository.save(department1);


		System.out.println("Saving employees in the reop");
		Employee employee = new Employee();
		employee.setName("naman");
		employee.setDepartment(department);
		employee.setSalary("10000000");
		repository.save(employee);

		Employee employee1 = new Employee();
		employee1.setName("jan");
		employee1.setDepartment(department1);
		employee1.setSalary("100000");
		repository.save(employee1);
	}
}
