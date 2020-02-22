package com.naman.sqlrest.controller;

import com.naman.sqlrest.entity.Department;
import com.naman.sqlrest.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentRestController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/api/department")
    public List<Department> getAllDepartment() {
        return departmentService.retrieveDepartment();
    }

    @GetMapping("/api/department/{departmentId}")
    public Department getDepartment(@PathVariable(name="departmentId")Long departmentId) {
        return departmentService.getDepartment(departmentId);
    }

    @PostMapping("/api/department")
    public void saveDepartment(@RequestBody Department department){
        System.out.println(department.toString());
        departmentService.saveDepartment(department);
        System.out.println("Dept Saved Successfully");
    }

    @DeleteMapping("/api/department/{departmentId}")
    public void deleteDepartment(@PathVariable(name="departmentId")Long departmentId){
        departmentService.deleteDepartment(departmentId);
        System.out.println("Dept Deleted Successfully");
    }

    @PutMapping("/api/department/{departmentId}")
    public void updateDepartment(@RequestBody Department department,
                               @PathVariable(name="departmentId")Long departmentId){
        Department department1 = departmentService.getDepartment(departmentId);
        if(department1 != null){
            departmentService.updateDepartment(department);
        }
    }
}
