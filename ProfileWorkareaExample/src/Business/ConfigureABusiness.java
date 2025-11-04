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
import Business.Profiles.FacultyProfile;
import Business.UserAccounts.UserAccountDirectory;

import Model.Assignment;
import Model.Course;
import Model.Faculty;
import Model.Student;

// Added for integration with Academic structure
import Bussiness.Academic.CourseDirectory;
import Bussiness.Academic.EnrollmentDirectory;

/**
 * Initializes and configures the Business ecosystem with sample data.
 * Version WITHOUT Role class — uses Profile type for access control.
 * Author: Shreya Darban
 */
public class ConfigureABusiness {

    public static Business initialize() {

        Business business = new Business("Information Systems");

        // ======== Integrate new directories ========
        CourseDirectory courseDirectory = business.getCourseDirectory();
        EnrollmentDirectory enrollmentDirectory = business.getEnrollmentDirectory();

        PersonDirectory personDirectory = business.getPersonDirectory();
        EmployeeDirectory employeeDirectory = business.getEmployeeDirectory();
        StudentDirectory studentDirectory = business.getStudentDirectory();
        UserAccountDirectory uaDirectory = business.getUserAccountDirectory();

        // ========== CREATE PERSONS ==========
        Person adminPerson = personDirectory.newPerson("John Smith");

        // Faculty Persons
        Person personF001 = personDirectory.newPerson("Dr. Robert Johnson");
        Person personF002 = personDirectory.newPerson("Dr. Emily Davis");
        Person personF003 = personDirectory.newPerson("Prof. Michael Chen");
        Person personF004 = personDirectory.newPerson("Dr. Sarah Williams");
        Person personF005 = personDirectory.newPerson("Prof. David Martinez");

        // Student Persons
        Person personS001 = personDirectory.newPerson("Alice Johnson");
        Person personS002 = personDirectory.newPerson("Bob Williams");
        Person personS003 = personDirectory.newPerson("Carol Davis");
        Person personS004 = personDirectory.newPerson("David Miller");
        Person personS005 = personDirectory.newPerson("Emma Garcia");

        // ========== CREATE ADMIN ==========
        EmployeeProfile employeeProfile0 = employeeDirectory.newEmployeeProfile(adminPerson);

        // ========== CREATE STUDENTS ==========
        StudentProfile studentProfile1 = studentDirectory.newStudentProfile(personS001);
        StudentProfile studentProfile2 = studentDirectory.newStudentProfile(personS002);
        StudentProfile studentProfile3 = studentDirectory.newStudentProfile(personS003);
        StudentProfile studentProfile4 = studentDirectory.newStudentProfile(personS004);
        StudentProfile studentProfile5 = studentDirectory.newStudentProfile(personS005);

        // ========== CREATE FACULTY ==========
        Faculty faculty1 = new Faculty("F001", "Dr. Robert Johnson", "robert.j@university.edu", "Computer Science");
        Faculty faculty2 = new Faculty("F002", "Dr. Emily Davis", "emily.d@university.edu", "Information Systems");
        Faculty faculty3 = new Faculty("F003", "Prof. Michael Chen", "michael.c@university.edu", "Data Science");
        Faculty faculty4 = new Faculty("F004", "Dr. Sarah Williams", "sarah.w@university.edu", "Software Engineering");
        Faculty faculty5 = new Faculty("F005", "Prof. David Martinez", "david.m@university.edu", "Database Systems");

        // ========== CREATE COURSES ==========
        Course course1 = new Course("INFO5100", "Application Engineering", "Fall 2024", 4, 2500.0);
        course1.setDescription("Enterprise application development");
        course1.setSchedule("Mon/Wed 6:00-9:00 PM");
        course1.setTotalSeats(30);
        course1.setSyllabus("Week 1: Java\nWeek 2: OOP\nWeek 3: GUI");

        Course course2 = new Course("INFO6205", "Data Structures", "Fall 2024", 4, 2500.0);
        course2.setDescription("Algorithms and data structures");
        course2.setSchedule("Tue/Thu 6:00-9:00 PM");
        course2.setTotalSeats(25);

        Course course3 = new Course("INFO5200", "Database Management", "Fall 2024", 4, 2500.0);
        course3.setDescription("Database design and SQL");
        course3.setSchedule("Mon/Wed 3:00-6:00 PM");
        course3.setTotalSeats(30);

        Course course4 = new Course("INFO6150", "Web Design", "Fall 2024", 4, 2500.0);
        course4.setDescription("Web development and UX");
        course4.setSchedule("Tue/Thu 3:00-6:00 PM");
        course4.setTotalSeats(25);

        Course course5 = new Course("INFO7390", "Machine Learning", "Fall 2024", 4, 2500.0);
        course5.setDescription("ML fundamentals");
        course5.setSchedule("Mon/Wed 7:00-10:00 PM");
        course5.setTotalSeats(20);

        // Register in Academic Course Directory
        courseDirectory.addCourse("INFO5100", "Application Engineering", "Dr. Lee", 4, "Fall 2025", 25);
        courseDirectory.addCourse("INFO6200", "Database Design", "Dr. Brown", 4, "Fall 2025", 25);
        courseDirectory.addCourse("INFO6210", "Web Development", "Prof. Carter", 4, "Fall 2025", 25);
        courseDirectory.addCourse("INFO7100", "Advanced Analytics", "Dr. Miller", 4, "Fall 2025", 25);

        // ========== CREATE STUDENT OBJECTS ==========
        Student student1 = new Student("S001", "Alice Johnson", "alice@university.edu", "MSIS");
        Student student2 = new Student("S002", "Bob Williams", "bob@university.edu", "MSIS");
        Student student3 = new Student("S003", "Carol Davis", "carol@university.edu", "MSIS");
        Student student4 = new Student("S004", "David Miller", "david@university.edu", "MSIS");
        Student student5 = new Student("S005", "Emma Garcia", "emma@university.edu", "MSIS");

        // ========== ENROLL STUDENTS ==========
        enrollmentDirectory.addEnrollment(studentProfile1, course1);
        enrollmentDirectory.addEnrollment(studentProfile2, course1);
        enrollmentDirectory.addEnrollment(studentProfile3, course2);
        enrollmentDirectory.addEnrollment(studentProfile4, course3);
        enrollmentDirectory.addEnrollment(studentProfile5, course4);

        // Add assignments
        Assignment a1 = new Assignment("A1", "Homework 1", "INFO5100", 100);
        a1.setScore("S001", 95);
        a1.setScore("S002", 87);

        Assignment a2 = new Assignment("A2", "Homework 2", "INFO5100", 100);
        a2.setScore("S001", 88);
        a2.setScore("S002", 90);

        course1.addAssignment(a1);
        course1.addAssignment(a2);

        // ========== CREATE FACULTY PROFILES ==========
        FacultyProfile facultyProfile1 = new FacultyProfile(personF001, faculty1);
        FacultyProfile facultyProfile2 = new FacultyProfile(personF002, faculty2);
        FacultyProfile facultyProfile3 = new FacultyProfile(personF003, faculty3);
        FacultyProfile facultyProfile4 = new FacultyProfile(personF004, faculty4);
        FacultyProfile facultyProfile5 = new FacultyProfile(personF005, faculty5);

        // ========== CREATE USER ACCOUNTS (NO ROLE CLASS) ==========
        uaDirectory.newUserAccount(employeeProfile0, "admin", "admin");

        uaDirectory.newUserAccount(studentProfile1, "alice", "1234");
        uaDirectory.newUserAccount(studentProfile2, "bob", "1234");
        uaDirectory.newUserAccount(studentProfile3, "carol", "1234");
        uaDirectory.newUserAccount(studentProfile4, "david", "1234");
        uaDirectory.newUserAccount(studentProfile5, "emma", "1234");

        uaDirectory.newUserAccount(facultyProfile1, "robert", "1234");
        uaDirectory.newUserAccount(facultyProfile2, "emily", "1234");
        uaDirectory.newUserAccount(facultyProfile3, "michael", "1234");
        uaDirectory.newUserAccount(facultyProfile4, "sarah", "1234");
        uaDirectory.newUserAccount(facultyProfile5, "davidm", "1234");

        return business;
    }
}
