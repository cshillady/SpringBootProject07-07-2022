package com.connorshillady.springproject_07072022.dao;

import com.connorshillady.springproject_07072022.model.Department;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public interface DepartmentDAO {
  int insertDepartment(UUID deptID, Department department);
  default int insertDepartment(Department department) {
    UUID deptID = UUID.randomUUID();
    return insertDepartment(deptID, department);
  }
  ArrayList<Department> selectAllDepartments();
  Optional<Department> selectDepartmentById(UUID id);
  int deleteDepartmentById(UUID id);
  int updateDepartmentById(UUID id, Department department);
}