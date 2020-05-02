package com.naman.sqlrest.repository;

import com.naman.sqlrest.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* To add custom function to repository on top of JPA repository add a another reopsitory which
   is of the form  ${Original Repository name}Custom
*/

public interface DepartmentRepositoryCustom {
    Department findDepartmentByName(String departmentName);
}
