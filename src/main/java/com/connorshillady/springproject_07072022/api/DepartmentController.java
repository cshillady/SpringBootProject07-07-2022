package com.connorshillady.springproject_07072022.api;

import com.connorshillady.springproject_07072022.model.Department;
import com.connorshillady.springproject_07072022.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {
  private final DepartmentService departmentService;
  @Autowired
  public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }
  @PostMapping
  public void addDepartment(Department department) {
    departmentService.addDepartment(new Department(UUID.randomUUID(), "HR"));
    departmentService.addDepartment(new Department(UUID.randomUUID(), "IT"));
    departmentService.addDepartment(new Department(UUID.randomUUID(), "Sales"));
    departmentService.addDepartment(new Department(UUID.randomUUID(), "Billing"));
  }
  @GetMapping
  public ArrayList<Department> getAllDepartments() {
    return departmentService.selectAllDepartments();
  }
}