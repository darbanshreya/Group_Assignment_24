package Business;

import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;
import Business.Profiles.FacultyProfile;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import Model.Assignment;
import Model.Course;
import Model.Faculty;
import Model.Student;

/**
 * @author kal bugrara
 * Modified by: [Your Name] - Added Faculty test data
 */
class ConfigureABusiness {
    
    static Business initialize() {
        Business business = new Business("Information Systems");
        
        PersonDirectory persondirectory = business.getPersonDirectory();
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        StudentDirectory studentdirectory = business.getStudentDirectory();
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        
        // ========== CREATE PERSONS (30+ total) ==========
        
        // Admin
        Person person001 = persondirectory.newPerson("John Smith");
        Person person002 = persondirectory.newPerson("Gina Montana");
        
        // Faculty Persons (10)
        Person personF001 = persondirectory.newPerson("Dr. Robert Johnson");
        Person personF002 = persondirectory.newPerson("Dr. Emily Davis");
        Person personF003 = persondirectory.newPerson("Prof. Michael Chen");
        Person personF004 = persondirectory.newPerson("Dr. Sarah Williams");
        Person personF005 = persondirectory.newPerson("Prof. David Martinez");
        Person personF006 = persondirectory.newPerson("Dr. Lisa Anderson");
        Person personF007 = persondirectory.newPerson("Prof. James Taylor");
        Person personF008 = persondirectory.newPerson("Dr. Jennifer Wilson");
        Person personF009 = persondirectory.newPerson("Prof. Christopher Lee");
        Person personF010 = persondirectory.newPerson("Dr. Amanda Brown");
        
        // Student Persons (10)
        Person personS001 = persondirectory.newPerson("Alice Johnson");
        Person personS002 = persondirectory.newPerson("Bob Williams");
        Person personS003 = persondirectory.newPerson("Carol Davis");
        Person personS004 = persondirectory.newPerson("David Miller");
        Person personS005 = persondirectory.newPerson("Emma Garcia");
        Person personS006 = persondirectory.newPerson("Frank Rodriguez");
        Person personS007 = persondirectory.newPerson("Grace Martinez");
        Person personS008 = persondirectory.newPerson("Henry Lopez");
        Person personS009 = persondirectory.newPerson("Isabella Gonzalez");
        Person personS010 = persondirectory.newPerson("Jack Anderson");
        
        // Additional persons
        Person person010 = persondirectory.newPerson("Kevin White");
        Person person011 = persondirectory.newPerson("Laura Harris");
        Person person012 = persondirectory.newPerson("Mark Clark");
        Person person013 = persondirectory.newPerson("Nancy Lewis");
        Person person014 = persondirectory.newPerson("Oliver Walker");
        Person person015 = persondirectory.newPerson("Patricia Hall");
        Person person016 = persondirectory.newPerson("Quinn Young");
        Person person017 = persondirectory.newPerson("Rachel King");
        
        // ========== CREATE ADMIN ==========
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);
        
        // ========== CREATE STUDENTS (10) ==========
        StudentProfile studentProfile1 = studentdirectory.newStudentProfile(personS001);
        StudentProfile studentProfile2 = studentdirectory.newStudentProfile(personS002);
        StudentProfile studentProfile3 = studentdirectory.newStudentProfile(personS003);
        StudentProfile studentProfile4 = studentdirectory.newStudentProfile(personS004);
        StudentProfile studentProfile5 = studentdirectory.newStudentProfile(personS005);
        StudentProfile studentProfile6 = studentdirectory.newStudentProfile(personS006);
        StudentProfile studentProfile7 = studentdirectory.newStudentProfile(personS007);
        StudentProfile studentProfile8 = studentdirectory.newStudentProfile(personS008);
        StudentProfile studentProfile9 = studentdirectory.newStudentProfile(personS009);
        StudentProfile studentProfile10 = studentdirectory.newStudentProfile(personS010);
        
        // ========== CREATE FACULTY MODELS ==========
        
        Faculty faculty1 = new Faculty("F001", "Dr. Robert Johnson", "robert.j@university.edu", "Computer Science");
        faculty1.setPhone("555-0001");
        faculty1.setOfficeHours("Mon/Wed 2-4 PM");
        
        Faculty faculty2 = new Faculty("F002", "Dr. Emily Davis", "emily.d@university.edu", "Information Systems");
        faculty2.setPhone("555-0002");
        faculty2.setOfficeHours("Tue/Thu 10-12 PM");
        
        Faculty faculty3 = new Faculty("F003", "Prof. Michael Chen", "michael.c@university.edu", "Data Science");
        faculty3.setPhone("555-0003");
        faculty3.setOfficeHours("Mon/Wed/Fri 1-3 PM");
        
        Faculty faculty4 = new Faculty("F004", "Dr. Sarah Williams", "sarah.w@university.edu", "Software Engineering");
        faculty4.setPhone("555-0004");
        faculty4.setOfficeHours("Tue/Thu 2-4 PM");
        
        Faculty faculty5 = new Faculty("F005", "Prof. David Martinez", "david.m@university.edu", "Database Systems");
        Faculty faculty6 = new Faculty("F006", "Dr. Lisa Anderson", "lisa.a@university.edu", "Networks");
        Faculty faculty7 = new Faculty("F007", "Prof. James Taylor", "james.t@university.edu", "Web Development");
        Faculty faculty8 = new Faculty("F008", "Dr. Jennifer Wilson", "jennifer.w@university.edu", "Machine Learning");
        Faculty faculty9 = new Faculty("F009", "Prof. Christopher Lee", "chris.l@university.edu", "Cybersecurity");
        Faculty faculty10 = new Faculty("F010", "Dr. Amanda Brown", "amanda.b@university.edu", "Cloud Computing");
        
        // ========== CREATE COURSES (5+) ==========
        
        Course course1 = new Course("INFO5100", "Application Engineering", "Fall 2024", 4, 2500.0);
        course1.setDescription("Enterprise application development");
        course1.setSchedule("Mon/Wed 6:00-9:00 PM");
        course1.setCapacity(30);
        course1.setSyllabus("Week 1: Java\nWeek 2: OOP\nWeek 3: GUI");
        course1.setEnrollmentOpen(true);
        
        Course course2 = new Course("INFO6205", "Data Structures", "Fall 2024", 4, 2500.0);
        course2.setDescription("Algorithms and data structures");
        course2.setSchedule("Tue/Thu 6:00-9:00 PM");
        course2.setCapacity(25);
        course2.setEnrollmentOpen(true);
        
        Course course3 = new Course("INFO5200", "Database Management", "Fall 2024", 4, 2500.0);
        course3.setDescription("Database design and SQL");
        course3.setSchedule("Mon/Wed 3:00-6:00 PM");
        course3.setCapacity(30);
        course3.setEnrollmentOpen(true);
        
        Course course4 = new Course("INFO6150", "Web Design", "Fall 2024", 4, 2500.0);
        course4.setDescription("Web development and UX");
        course4.setSchedule("Tue/Thu 3:00-6:00 PM");
        course4.setCapacity(25);
        course4.setEnrollmentOpen(true);
        
        Course course5 = new Course("INFO7390", "Machine Learning", "Fall 2024", 4, 2500.0);
        course5.setDescription("ML fundamentals");
        course5.setSchedule("Mon/Wed 7:00-10:00 PM");
        course5.setCapacity(20);
        course5.setEnrollmentOpen(true);
        
        // ========== CREATE STUDENTS ==========
        
        Student student1 = new Student("S001", "Alice Johnson", "alice@university.edu", "MSIS");
        Student student2 = new Student("S002", "Bob Williams", "bob@university.edu", "MSIS");
        Student student3 = new Student("S003", "Carol Davis", "carol@university.edu", "MSIS");
        Student student4 = new Student("S004", "David Miller", "david@university.edu", "MSIS");
        Student student5 = new Student("S005", "Emma Garcia", "emma@university.edu", "MSIS");
        Student student6 = new Student("S006", "Frank Rodriguez", "frank@university.edu", "MSIS");
        Student student7 = new Student("S007", "Grace Martinez", "grace@university.edu", "MSIS");
        Student student8 = new Student("S008", "Henry Lopez", "henry@university.edu", "MSIS");
        Student student9 = new Student("S009", "Isabella Gonzalez", "isabella@university.edu", "MSIS");
        Student student10 = new Student("S010", "Jack Anderson", "jack@university.edu", "MSIS");
        
        // ========== ENROLL STUDENTS IN COURSES ==========
        
        course1.addStudent(student1);
        course1.addStudent(student2);
        course1.addStudent(student3);
        course1.addStudent(student4);
        course1.addStudent(student5);
        
        student1.enrollInCourse("INFO5100");
        student2.enrollInCourse("INFO5100");
        student3.enrollInCourse("INFO5100");
        student4.enrollInCourse("INFO5100");
        student5.enrollInCourse("INFO5100");
        
        student1.setTuitionPaid("INFO5100", true);
        student2.setTuitionPaid("INFO5100", true);
        student3.setTuitionPaid("INFO5100", true);
        student4.setTuitionPaid("INFO5100", false);
        student5.setTuitionPaid("INFO5100", true);
        
        // Create assignments for Course 1
        Assignment a1 = new Assignment("A1", "Homework 1", "INFO5100", 100);
        a1.setScore("S001", 95);
        a1.setScore("S002", 87);
        a1.setScore("S003", 92);
        a1.setScore("S004", 89);
        a1.setScore("S005", 91);
        
        Assignment a2 = new Assignment("A2", "Homework 2", "INFO5100", 100);
        a2.setScore("S001", 88);
        a2.setScore("S002", 90);
        a2.setScore("S003", 85);
        a2.setScore("S004", 93);
        a2.setScore("S005", 87);
        
        course1.addAssignment(a1);
        course1.addAssignment(a2);
        
        student1.setGradeForCourse("INFO5100", "A");
        student2.setGradeForCourse("INFO5100", "B+");
        student3.setGradeForCourse("INFO5100", "A-");
        student4.setGradeForCourse("INFO5100", "A");
        student5.setGradeForCourse("INFO5100", "A-");
        
        // Enroll in Course 2
        course2.addStudent(student1);
        course2.addStudent(student2);
        course2.addStudent(student6);
        
        // Enroll in Course 3
        course3.addStudent(student3);
        course3.addStudent(student7);
        course3.addStudent(student8);
        
        // Enroll in Course 4
        course4.addStudent(student9);
        course4.addStudent(student10);
        
        // Enroll in Course 5
        course5.addStudent(student1);
        course5.addStudent(student6);
        
        // ========== ASSIGN COURSES TO FACULTY ==========
        
        faculty1.addCourse(course1);
        faculty1.addCourse(course2);
        faculty2.addCourse(course3);
        faculty3.addCourse(course4);
        faculty4.addCourse(course5);
        
        // ========== CREATE FACULTY PROFILES ==========
        
        FacultyProfile facultyProfile1 = new FacultyProfile(personF001, faculty1);
        FacultyProfile facultyProfile2 = new FacultyProfile(personF002, faculty2);
        FacultyProfile facultyProfile3 = new FacultyProfile(personF003, faculty3);
        FacultyProfile facultyProfile4 = new FacultyProfile(personF004, faculty4);
        FacultyProfile facultyProfile5 = new FacultyProfile(personF005, faculty5);
        FacultyProfile facultyProfile6 = new FacultyProfile(personF006, faculty6);
        FacultyProfile facultyProfile7 = new FacultyProfile(personF007, faculty7);
        FacultyProfile facultyProfile8 = new FacultyProfile(personF008, faculty8);
        FacultyProfile facultyProfile9 = new FacultyProfile(personF009, faculty9);
        FacultyProfile facultyProfile10 = new FacultyProfile(personF010, faculty10);
        
        // ========== CREATE USER ACCOUNTS ==========
        
        UserAccount ua_admin = uadirectory.newUserAccount(employeeprofile0, "admin", "****");
        
        UserAccount ua_s1 = uadirectory.newUserAccount(studentProfile1, "alice", "****");
        UserAccount ua_s2 = uadirectory.newUserAccount(studentProfile2, "bob", "****");
        UserAccount ua_s3 = uadirectory.newUserAccount(studentProfile3, "carol", "****");
        UserAccount ua_s4 = uadirectory.newUserAccount(studentProfile4, "david", "****");
        UserAccount ua_s5 = uadirectory.newUserAccount(studentProfile5, "emma", "****");
        UserAccount ua_s6 = uadirectory.newUserAccount(studentProfile6, "frank", "****");
        UserAccount ua_s7 = uadirectory.newUserAccount(studentProfile7, "grace", "****");
        UserAccount ua_s8 = uadirectory.newUserAccount(studentProfile8, "henry", "****");
        UserAccount ua_s9 = uadirectory.newUserAccount(studentProfile9, "isabella", "****");
        UserAccount ua_s10 = uadirectory.newUserAccount(studentProfile10, "jack", "****");
        
        UserAccount ua_f1 = uadirectory.newUserAccount(facultyProfile1, "robert", "****");
        UserAccount ua_f2 = uadirectory.newUserAccount(facultyProfile2, "emily", "****");
        UserAccount ua_f3 = uadirectory.newUserAccount(facultyProfile3, "michael", "****");
        UserAccount ua_f4 = uadirectory.newUserAccount(facultyProfile4, "sarah", "****");
        UserAccount ua_f5 = uadirectory.newUserAccount(facultyProfile5, "davidm", "****");
        UserAccount ua_f6 = uadirectory.newUserAccount(facultyProfile6, "lisa", "****");
        UserAccount ua_f7 = uadirectory.newUserAccount(facultyProfile7, "james", "****");
        UserAccount ua_f8 = uadirectory.newUserAccount(facultyProfile8, "jennifer", "****");
        UserAccount ua_f9 = uadirectory.newUserAccount(facultyProfile9, "chris", "****");
        UserAccount ua_f10 = uadirectory.newUserAccount(facultyProfile10, "amanda", "****");
        
        return business;
    }
}