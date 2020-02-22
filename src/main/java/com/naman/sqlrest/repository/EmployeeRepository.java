package com.naman.sqlrest.repository;

import com.naman.sqlrest.entity.Employee;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository /*extends JpaRepository<Employee, Long> */{
    List<Employee> findAll();
    Employee findById(long id);
    void save(Employee employee);
    void deleteById(long id);
}
