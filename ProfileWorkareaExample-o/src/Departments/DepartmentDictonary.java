/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Departments;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class DepartmentDictonary {

    List<Department> departments;

    public DepartmentDictonary() {
        departments = new ArrayList<>();
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department dept) {
        this.departments.add(dept);
    }

    public Department getDepartmentByName(String dept) {
        for (Department d : this.departments) {
            if (dept.equalsIgnoreCase(d.getName())) {
                return d;
            }
        }
        return null;
    }

}
