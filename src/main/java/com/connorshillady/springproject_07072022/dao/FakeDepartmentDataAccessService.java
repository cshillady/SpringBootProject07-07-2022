package com.connorshillady.springproject_07072022.dao;

import com.connorshillady.springproject_07072022.model.Department;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.UUID;

@Repository("fakeDepartmentDAO")
public class FakeDepartmentDataAccessService implements DepartmentDAO {
  private static ArrayList<Department> DepartmentDB = new ArrayList<>();
  @Override
  public int insertDepartment(UUID deptID, Department department) {
    DepartmentDB.add(new Department(deptID, department.getDeptName()));
    return 1;
  }
  @Override
  public ArrayList<Department> selectAllDepartments() {
    return DepartmentDB;
  }
}