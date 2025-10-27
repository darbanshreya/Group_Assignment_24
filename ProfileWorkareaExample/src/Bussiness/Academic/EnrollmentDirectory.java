/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bussiness.Academic;

import Business.Profiles.StudentProfile;
import java.util.ArrayList;

/**
 * Manages all enrollments in the Digital University System.
 */
public class EnrollmentDirectory {

    private ArrayList<Enrollment> enrollmentList;

    public EnrollmentDirectory() {
        enrollmentList = new ArrayList<>();
    }

    public Enrollment addEnrollment(StudentProfile student, Course course) {
        Enrollment e = new Enrollment(student, course);
        enrollmentList.add(e);
        course.reduceSeat();
        student.addTuitionCharge(course.getCredits() * 1000.0); // $1000 per credit
        return e;
    }

    public void dropEnrollment(Enrollment e) {
        if (e != null) {
            enrollmentList.remove(e);
            e.getCourse().increaseSeat();
            e.getStudent().payTuition(-e.getCourse().getCredits() * 1000.0); // refund
        }
    }

    public ArrayList<Enrollment> getEnrollmentList() {
        return enrollmentList;
    }

    public ArrayList<Enrollment> getEnrollmentsByStudent(StudentProfile student) {
        ArrayList<Enrollment> results = new ArrayList<>();
        for (Enrollment e : enrollmentList) {
            if (e.getStudent().equals(student)) {
                results.add(e);
            }
        }
        return results;
    }

    public void removeAllForCourse(Course course) {
        enrollmentList.removeIf(e -> e.getCourse().equals(course));
    }

    public int getTotalEnrollments() {
        return enrollmentList.size();
    }
}

