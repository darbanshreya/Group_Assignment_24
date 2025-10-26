/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import Bussiness.Academic.CourseDirectory;
import Bussiness.Academic.Course;
import Bussiness.Academic.EnrollmentDirectory;

/**
 * Initializes the Digital University System with sample data.
 * @author Shreya
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Information Systems");

        // ====== 1. Create Person Directory ======
        PersonDirectory persondirectory = business.getPersonDirectory();

        // Admin Person
        Person person001 = persondirectory.newPerson("John Smith");

        // ====== 2. Create Employee & Student Profiles ======
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);

        StudentDirectory studentdirectory = business.getStudentDirectory();

        // Create 30 Students
        for (int i = 1; i <= 30; i++) {
            Person p = persondirectory.newPerson("Student " + i);
            StudentProfile sp = studentdirectory.newStudentProfile(p);
        }

        // ====== 3. Create User Accounts ======
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount adminAccount = uadirectory.newUserAccount(employeeprofile0, "admin", "****");

        int count = 1;
        for (StudentProfile sp : studentdirectory.getStudentList()) {
            uadirectory.newUserAccount(sp, "student" + count, "pass" + count);
            count++;
        }

        // ====== 4. Create Sample Courses ======
        CourseDirectory coursedir = business.getCourseDirectory();
        coursedir.addCourse("INFO5100", "Application Engineering", "Dr. Lee", 4, "Fall 2025", 25);
        coursedir.addCourse("INFO6105", "Data Science", "Dr. Smith", 4, "Fall 2025", 25);
        coursedir.addCourse("INFO6200", "Database Design", "Dr. Brown", 4, "Fall 2025", 25);
        coursedir.addCourse("INFO6210", "Web Development", "Prof. Carter", 4, "Fall 2025", 25);
        coursedir.addCourse("INFO7100", "Advanced Analytics", "Dr. Miller", 4, "Fall 2025", 25);

        // ====== 5. Enroll a few demo students ======
        EnrollmentDirectory enrollDir = business.getEnrollmentDirectory();
        if (studentdirectory.getStudentList() != null && !studentdirectory.getStudentList().isEmpty() && 
            coursedir.getCourseList() != null && !coursedir.getCourseList().isEmpty()) {
            StudentProfile demoStudent = studentdirectory.getStudentList().get(0);
            Course demoCourse = coursedir.getCourseList().get(0);
            enrollDir.addEnrollment(demoStudent, demoCourse);
        }

        return business;
    }
}
