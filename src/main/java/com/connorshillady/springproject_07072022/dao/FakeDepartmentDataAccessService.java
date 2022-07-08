package com.connorshillady.springproject_07072022.dao;

import com.connorshillady.springproject_07072022.model.Department;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Optional;
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
  @Override
  public int deleteDepartmentById(UUID deptID) {
    Optional<Department> departmentMaybe = selectDepartmentById(deptID);
    if (departmentMaybe.isEmpty()) {
      return 0;
    }
    DepartmentDB.remove(departmentMaybe.get());
    return 1;
  }
  @Override
  public int updateDepartmentById(UUID deptID, Department updateDepartment) {
    return selectDepartmentById(deptID)
        .map(originalDepartment -> {
          int updateIndex = DepartmentDB.indexOf(originalDepartment);
          if (updateIndex >= 0) {
            DepartmentDB.set(updateIndex, updateDepartment);
            return 1;
          }
          return 0;
        }).orElse(0);
  }
  public Optional<Department> selectDepartmentById(UUID deptID) {
    return DepartmentDB.stream().filter(department -> department.getDeptID().equals(deptID)).findFirst();
  }
}