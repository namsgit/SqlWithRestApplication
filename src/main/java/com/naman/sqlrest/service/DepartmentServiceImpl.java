package com.naman.sqlrest.service;

import com.naman.sqlrest.entity.Department;
import com.naman.sqlrest.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> retrieveDepartment() {
        List<Department> depts = departmentRepository.findAll();
        return depts;
    }

    @Override
    public Department getDepartment(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
         return department.get();
//        Optional<Employee> employee = employeeRepository.findById(employeeId);
//        return employee.get();
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);

    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);

    }

    @Override
    public void updateDepartment(Department department) {
        departmentRepository.save(department);
    }
}
