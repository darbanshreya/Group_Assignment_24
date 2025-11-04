package Business.Person;

import java.util.UUID;

/**
 * Represents a generic person in the Digital University System.
 * Used as a base entity for Students, Faculty, and Employees.
 *
 * @author Shreya
 */
public class Person {

    private String personId;   // Unique ID
    private String name;
    private String email;
    private String phoneNumber;
    private String department;

    // ======== Constructors ========

    /** Default constructor with only name (auto-generates ID) */
    public Person(String name) {
        this.personId = UUID.randomUUID().toString();
        this.name = name;
        this.email = "";
        this.phoneNumber = "";
        this.department = "";
    }

    /** Full constructor with details */
    public Person(String name, String email, String phoneNumber, String department) {
        this.personId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }

    /** Overloaded constructor allowing manual ID (for imports or DB sync) */
    public Person(String personId, String name, String email, String phoneNumber, String department) {
        this.personId = (personId != null && !personId.isEmpty()) ? personId : UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }

    // ======== Getters ========

    public String getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    // ======== Setters ========

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // ======== Utility Methods ========

    /** Match person by ID */
    public boolean isMatch(String id) {
        return this.personId.equals(id);
    }

    @Override
    public String toString() {
        return name + " | " + email + " | ID: " + personId;
    }
}
