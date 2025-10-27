/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.UUID;

/**
 *
 * @author Shreya
 * Represents a generic person in the Digital University System.
 */
public class Person {

    private String personId;   // Unique ID
    private String name;
    private String email;
    private String phone;
    private String department;

    // Constructor for simple creation (auto-generate ID)
    public Person(String name) {
        this.personId = UUID.randomUUID().toString(); // unique ID
        this.name = name;
        this.email = "";
        this.phone = "";
        this.department = "";
    }

    // Constructor for full details
    public Person(String name, String email, String phone, String department) {
        this.personId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // ======== Utility Methods ========
    public boolean isMatch(String id) {
        return this.personId.equals(id);
    }

    @Override
    public String toString() {
        return name + " (" + personId + ")";
    }
}
