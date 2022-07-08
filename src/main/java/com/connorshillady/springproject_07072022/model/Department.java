package com.connorshillady.springproject_07072022.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class Department {
  public final UUID deptID;
  public final String deptName;
  public Department(@JsonProperty("deptID") UUID deptID, @JsonProperty("deptName") String deptName) {
    this.deptID = deptID;
    this.deptName = deptName;
  }
  public UUID getDeptID() {
    return deptID;
  }
  public String getDeptName() {
    return deptName;
  }
}