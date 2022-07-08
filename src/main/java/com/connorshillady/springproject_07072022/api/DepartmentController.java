package com.connorshillady.springproject_07072022.api;

import com.connorshillady.springproject_07072022.model.Department;
import com.connorshillady.springproject_07072022.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
  @GetMapping(value = "/post/{deptID}/{deptName}")
  public void addDepartment(@PathVariable UUID deptID, @PathVariable String deptName) {
    departmentService.addDepartment(new Department(deptID, deptName));
  }
  @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    /*
      {
        "id": "",
        "name": "james"
      }
    */
  public void addDepartment(@RequestBody Department department) {
    departmentService.addDepartment(department);
  }
  @GetMapping
  public ArrayList<Department> getAllDepartments() {
    return departmentService.selectAllDepartments();
  }
  @GetMapping(value = "/{deptID}")
  public Department getDepartment(@PathVariable("deptID") UUID deptID) {
    return departmentService.getDepartmentById(deptID).orElse(null);
  }
  @DeleteMapping(value = "/{deptID}")
  public int deleteDepartment(@PathVariable("deptID") UUID deptID) {
    return departmentService.deleteDepartment(deptID);
  }
  @PutMapping(value = "/{deptID}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public int updateDepartment(@PathVariable("deptID") UUID deptID, @RequestBody Department department) {
    return departmentService.updateDepartment(deptID, department);
  }
}