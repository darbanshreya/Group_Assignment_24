/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ravin
 */
public class Faculty {
    private String facultyId;
    private String name;
    private String email;
    private String department;
    private String phone;
    private String officeHours;
    private List<Course> assignedCourses;
    
        public Faculty(String facultyId, String name, String email, String department) {
        this.facultyId = facultyId;
        this.name = name;
        this.email = email;
        this.department = department;
        this.assignedCourses = new ArrayList<>();
        }    

   public String getFacultyId() { return facultyId; }
    public void setFacultyId(String facultyId) { this.facultyId = facultyId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getOfficeHours() { return officeHours; }
    public void setOfficeHours(String officeHours) { this.officeHours = officeHours; }
    
    public List<Course> getAssignedCourses() { return assignedCourses; }
    public void setAssignedCourses(List<Course> courses) { this.assignedCourses = courses; }
    
    public void addCourse(Course course) {
        if (!assignedCourses.contains(course)) {
            assignedCourses.add(course);
        }
    }
}