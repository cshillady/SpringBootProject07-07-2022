package com.connorshillady.springproject_07072022.service;

import com.connorshillady.springproject_07072022.dao.DepartmentDAO;
import com.connorshillady.springproject_07072022.model.Department;
import com.connorshillady.springproject_07072022.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
}