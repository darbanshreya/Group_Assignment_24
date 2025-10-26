/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.StudentDirectory;
import Business.UserAccounts.UserAccountDirectory;
import Bussiness.Academic.CourseDirectory;
import Bussiness.Academic.EnrollmentDirectory;
import Bussiness.Finance.TuitionDirectory;

/**
 * Central class managing all business directories for the Digital University System.
 * @author Shreya
 */
public class Business {

    private String name;
    private PersonDirectory personDirectory;
    private EmployeeDirectory employeeDirectory;
    private StudentDirectory studentDirectory;
    private UserAccountDirectory userAccountDirectory;

    // Added directories for academic and finance
    private CourseDirectory courseDirectory;
    private EnrollmentDirectory enrollmentDirectory;
    private TuitionDirectory tuitionDirectory;

    public Business(String name) {
        this.name = name;
        this.personDirectory = new PersonDirectory();
        this.employeeDirectory = new EmployeeDirectory(this); // Pass 'this' reference
        this.studentDirectory = new StudentDirectory();
        this.userAccountDirectory = new UserAccountDirectory();
        this.courseDirectory = new CourseDirectory();
        this.enrollmentDirectory = new EnrollmentDirectory();
        this.tuitionDirectory = new TuitionDirectory();
    }

    // ============ Getters ============

    public String getName() {
        return name;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public StudentDirectory getStudentDirectory() {
        return studentDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public CourseDirectory getCourseDirectory() {
        return courseDirectory;
    }

    public EnrollmentDirectory getEnrollmentDirectory() {
        return enrollmentDirectory;
    }

    public TuitionDirectory getTuitionDirectory() {
        return tuitionDirectory;
    }

    // ============ Setters (if needed) ============

    public void setCourseDirectory(CourseDirectory courseDirectory) {
        this.courseDirectory = courseDirectory;
    }

    public void setEnrollmentDirectory(EnrollmentDirectory enrollmentDirectory) {
        this.enrollmentDirectory = enrollmentDirectory;
    }

    public void setTuitionDirectory(TuitionDirectory tuitionDirectory) {
        this.tuitionDirectory = tuitionDirectory;
    }
}