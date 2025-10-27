package Business.Profiles;

import Business.Person.Person;

/**
 * Represents a student profile containing personal, academic, and financial information.
 */
public class StudentProfile extends Profile {

    private Person person;
    private StudentAccount studentAccount;

    public StudentProfile(Person p) {
        super(p);
        this.person = p;
        this.studentAccount = new StudentAccount();
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }

    public StudentAccount getStudentAccount() {
        return studentAccount;
    }

    public Person getPerson() {
        return person;
    }

    // ======== Tuition / Finance Methods ========

    /** Add a new tuition charge for this student. */
    public void addTuitionCharge(double amount) {
        if (studentAccount != null) {
            studentAccount.addCharge(amount);
        }
    }

    /** Pay off tuition partially or fully. */
    public void payTuition(double amount) {
        if (studentAccount != null) {
            studentAccount.makePayment(amount);
        }
    }

    /** Retrieve the current balance owed. */
    public double getOutstandingBalance() {
        return studentAccount != null ? studentAccount.getBalance() : 0.0;
    }
}
