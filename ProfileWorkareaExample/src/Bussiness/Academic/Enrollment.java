package Bussiness.Academic;

import Business.Profiles.StudentProfile;
import Model.Course;

/**
 * Represents a student's enrollment in a specific course.
 * Each enrollment is linked to one student and one course.
 * Includes tuition calculation and payment tracking.
 *
 * Author: Shreya Darban
 */
public class Enrollment {

    private StudentProfile student;
    private Course course;
    private String term;
    private String grade;
    private boolean tuitionPaid;
    private double tuitionAmount;

    // Tuition cost per credit hour (for finance module)
    private static final double COST_PER_CREDIT = 1000.0;

    // ======== Constructor ========
    public Enrollment(StudentProfile student, Course course) {
        this.student = student;
        this.course = course;
        this.term = course.getTerm();
        this.grade = "NA"; // default until graded
        this.tuitionPaid = false;
        this.tuitionAmount = course.getCredits() * COST_PER_CREDIT;
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

    public double getTuitionAmount() {
        return tuitionAmount;
    }

    // ======== Setters ========

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setTuitionPaid(boolean tuitionPaid) {
        this.tuitionPaid = tuitionPaid;
    }

    public void setTuitionAmount(double tuitionAmount) {
        this.tuitionAmount = tuitionAmount;
    }

    // ======== Business Logic ========

    /** Mark this enrollment as paid. */
    public void markPaid() {
        this.tuitionPaid = true;
    }

    /** Refund tuition in case of course drop (optional). */
    public void refundTuition() {
        this.tuitionPaid = false;
    }

    /** Return readable info. */
    @Override
    public String toString() {
        return student.getPerson().getName() + " - " + course.getCourseName();
    }
}
