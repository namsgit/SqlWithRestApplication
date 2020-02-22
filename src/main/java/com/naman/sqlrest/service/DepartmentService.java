package com.naman.sqlrest.service;

import com.naman.sqlrest.entity.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> retrieveDepartment();

    public Department getDepartment(Long id);

    public void saveDepartment(Department department);

    public void deleteDepartment(Long id);

    public void updateDepartment(Department department);
}