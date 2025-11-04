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
 * Acts as the master controller connecting Academic, Finance, and Access Control subsystems.
 *
 * Author: Shreya Darban
 */
public class Business {

    private String name;
    private PersonDirectory personDirectory;
    private EmployeeDirectory employeeDirectory;
    private StudentDirectory studentDirectory;
    private UserAccountDirectory userAccountDirectory;

    // Academic & Financial modules
    private CourseDirectory courseDirectory;
    private EnrollmentDirectory enrollmentDirectory;
    private TuitionDirectory tuitionDirectory;

    // =================== Constructor ===================
    public Business(String name) {
        this.name = name;
        this.personDirectory = new PersonDirectory();
        this.employeeDirectory = new EmployeeDirectory(this); // Pass business reference
        this.studentDirectory = new StudentDirectory();
        this.userAccountDirectory = new UserAccountDirectory();
        this.courseDirectory = new CourseDirectory();
        this.tuitionDirectory = new TuitionDirectory();
        this.enrollmentDirectory = new EnrollmentDirectory(this); // ✅ FIX: Pass 'this'
    }

    // =================== Getters ===================
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

    // =================== Setters (optional) ===================
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
