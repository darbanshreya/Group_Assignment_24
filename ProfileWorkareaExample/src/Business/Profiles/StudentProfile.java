package Business.Profiles;

import Business.Person.Person;
import Model.Student;

/**
 * Represents a student's business profile combining personal,
 * academic, and financial information.
 * 
 * Author: Shreya Darban
 */
public class StudentProfile extends Profile {

    private Person person;
    private StudentAccount studentAccount;
    private Student academicRecord; // Link to Model.Student

    // ======== New Profile Fields for UI ========
    private String department;
    private String program;
    private String phoneNumber; // convenience field (can mirror Person.phoneNumber)

    public StudentProfile(Person p) {
        super(p);
        this.person = p;
        this.studentAccount = new StudentAccount();
        this.academicRecord = new Student(p.getPersonId(), p.getName(), "", "Undeclared");
        this.department = "Not Assigned";
        this.program = "Undeclared";
        this.phoneNumber = p.getPhoneNumber();
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }

    // ======== Academic Integration ========
    public Student getAcademicRecord() {
        return academicRecord;
    }

    public String getStudentId() {
        return academicRecord != null ? academicRecord.getStudentId() : person.getPersonId();
    }

    public String getStudentName() {
        return person.getName();
    }

    // ======== Tuition / Finance Methods ========
    public void addTuitionCharge(double amount) {
        if (studentAccount != null) {
            studentAccount.addCharge(amount);
        }
    }

    public void payTuition(double amount) {
        if (studentAccount != null) {
            studentAccount.makePayment(amount);
        }
    }

    public double getOutstandingBalance() {
        return studentAccount != null ? studentAccount.getBalance() : 0.0;
    }

    public StudentAccount getStudentAccount() {
        return studentAccount;
    }

    public Person getPerson() {
        return person;
    }

    // ======== New UI/Personal Details ========
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = (department != null && !department.isEmpty()) ? department : "Not Assigned";
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = (program != null && !program.isEmpty()) ? program : "Undeclared";
    }

    public String getPhoneNumber() {
        return phoneNumber != null ? phoneNumber : person.getPhoneNumber();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        if (person != null) {
            person.setPhoneNumber(phoneNumber); // keep Person data synced
        }
    }

    @Override
    public String toString() {
        return person.getName() + " (" + getStudentId() + ")";
    }
}
