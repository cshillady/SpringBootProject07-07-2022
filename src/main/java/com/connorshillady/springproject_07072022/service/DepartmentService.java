package com.connorshillady.springproject_07072022.service;

import com.connorshillady.springproject_07072022.dao.DepartmentDAO;
import com.connorshillady.springproject_07072022.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentService {
  private final DepartmentDAO departmentDAO;
  @Autowired
  public DepartmentService(@Qualifier("fakeDepartmentDAO") DepartmentDAO departmentDAO) {
    this.departmentDAO = departmentDAO;
  }
  public int addDepartment(Department department) {
    return departmentDAO.insertDepartment(department);
  }
  public ArrayList<Department> selectAllDepartments() {
    return departmentDAO.selectAllDepartments();
  }
  public Optional<Department> getDepartmentById(UUID deptID) {
    return departmentDAO.selectDepartmentById(deptID);
  }
  public int deleteDepartment(UUID deptID) {
    return departmentDAO.deleteDepartmentById(deptID);
  }
  public int updateDepartment(UUID deptID, Department department) {
    return departmentDAO.updateDepartmentById(deptID, department);
  }
}