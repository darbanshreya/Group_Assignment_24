/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author Shreya
 * Manages all student profiles within the Digital University System.
 */
public class StudentDirectory {

    private ArrayList<StudentProfile> studentlist;

    public StudentDirectory() {
        studentlist = new ArrayList<>();
    }

    // Create a new student profile
    public StudentProfile newStudentProfile(Person p) {
        StudentProfile sp = new StudentProfile(p);
        studentlist.add(sp);
        return sp;
    }

    // Find a student by ID
    public StudentProfile findStudent(String id) {
        for (StudentProfile sp : studentlist) {
            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; // Not found
    }

    // ======== Additional Methods ========

    // Get all students
    public ArrayList<StudentProfile> getStudentList() {
        return studentlist;
    }

    // Remove a student
    public void removeStudent(StudentProfile sp) {
        studentlist.remove(sp);
    }

    // Search students by name (useful for Admin)
    public ArrayList<StudentProfile> searchByName(String keyword) {
        ArrayList<StudentProfile> results = new ArrayList<>();
        for (StudentProfile sp : studentlist) {
            if (sp.getPerson().getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(sp);
            }
        }
        return results;
    }

    // Count total students
    public int getTotalStudents() {
        return studentlist.size();
    }
}
