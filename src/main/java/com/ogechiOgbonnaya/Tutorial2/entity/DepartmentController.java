package com.ogechiOgbonnaya.Tutorial2.entity;


import com.ogechiOgbonnaya.Tutorial2.service.DepartmentService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;



    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchAllDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);

    }
    @DeleteMapping("/departments/{id}")
    public  String deleteDepartmentByID(@PathVariable("id") Long  departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully!!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }
    //endpoint based on dept

    @GetMapping("/departments/names/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return  departmentService.fetchDepartmentByName(departmentName);
    }

}
