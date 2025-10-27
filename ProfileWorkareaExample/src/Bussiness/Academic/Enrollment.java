/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bussiness.Academic;

import Business.Profiles.StudentProfile;

/**
 * Represents a student’s enrollment in a specific course.
 * Each enrollment is linked to one student and one course.
 */
public class Enrollment {

    private StudentProfile student;
    private Course course;
    private String term;
    private String grade;
    private boolean tuitionPaid;

    public Enrollment(StudentProfile student, Course course) {
        this.student = student;
        this.course = course;
        this.term = course.getTerm();
        this.grade = "NA"; // default until graded
        this.tuitionPaid = false;
    }

    // ======== Getters ========
    public StudentProfile getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getTerm() {
        return term;
    }

    public String getGrade() {
        return grade;
    }

    public boolean isTuitionPaid() {
        return tuitionPaid;
    }

    // ======== Setters ========
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setTuitionPaid(boolean tuitionPaid) {
        this.tuitionPaid = tuitionPaid;
    }

    // ======== Business Logic ========
    public void markPaid() {
        this.tuitionPaid = true;
    }

    @Override
    public String toString() {
        return student.getPerson().getName() + " - " + course.getCourseName();
    }
}

