package com.naman.sqlrest.repository;

import com.naman.sqlrest.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //Department getDepartmentByName(String departmentName);
}
