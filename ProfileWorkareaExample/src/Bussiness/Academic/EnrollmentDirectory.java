package Bussiness.Academic;

import Business.Business;
import Business.Profiles.StudentProfile;
import Model.Course;
import Bussiness.Finance.TuitionDirectory;
import java.util.ArrayList;

/**
 * Directory to manage all student enrollments in the Digital University System.
 * Handles adding, dropping, GPA calculation, seat management, and tuition linkage.
 *
 * Author: Shreya Darban
 */
public class EnrollmentDirectory {

    private ArrayList<Enrollment> enrollmentList;
    private Business business; // ✅ Access to TuitionDirectory and other modules

    // ✅ Constructor links with Business
    public EnrollmentDirectory(Business business) {
        this.business = business;
        enrollmentList = new ArrayList<>();
    }

    /**
     * ✅ Enrolls a student in a given course and automatically creates a tuition invoice.
     */
    public Enrollment addEnrollment(StudentProfile student, Course course) {
        if (student == null || course == null) {
            throw new IllegalArgumentException("Student or Course cannot be null");
        }

        // Prevent duplicate enrollment
        if (isAlreadyEnrolled(student, course)) {
            System.out.println("Already enrolled in course: " + course.getCourseId());
            return null;
        }

        // Optional safeguard: block if unpaid tuition is too high
        double balance = business.getTuitionDirectory().getTotalTuitionForStudent(student);
        if (balance > 10000) {
            System.out.println("Enrollment blocked — unpaid balance exceeds $10,000.");
            return null;
        }

        // Proceed with enrollment
        Enrollment e = new Enrollment(student, course);
        enrollmentList.add(e);

        // Reduce seat count if available
        if (course.hasAvailableSeats()) {
            course.reduceSeat();
        }

        System.out.println("Enrollment added for student: "
                + student.getPerson().getName()
                + " in course: " + course.getCourseName());

        // ✅ Automatically bill tuition for this course
        double tuitionFee = course.getTuitionFee(); // <-- fixed here
        String term = course.getTerm();

        if (tuitionFee > 0) {
            business.getTuitionDirectory().createInvoice(student, tuitionFee, term);
            System.out.println("Tuition invoice generated for $" + tuitionFee +
                    " (" + course.getCourseId() + " - " + term + ")");
        }

        return e;
    }

    /**
     * ✅ Drops a student from a course (if found) and triggers refund logic.
     */
    public boolean dropEnrollment(StudentProfile student, Course course) {
        if (student == null || course == null) return false;

        Enrollment toRemove = null;
        for (Enrollment e : enrollmentList) {
            if (e.getStudent().equals(student) && e.getCourse().equals(course)) {
                toRemove = e;
                break;
            }
        }

        if (toRemove != null) {
            enrollmentList.remove(toRemove);
            course.increaseSeat();

            System.out.println("Dropped " + course.getCourseId() +
                    " for " + student.getPerson().getName());

            // ✅ Automatically refund
            business.getTuitionDirectory().refundTuition(student, course);
            System.out.println("Refund processed for dropped course: " + course.getCourseId());

            return true;
        }
        return false;
    }

    /** Returns all enrollments for a given student. */
    public ArrayList<Enrollment> getEnrollmentsByStudent(StudentProfile student) {
        ArrayList<Enrollment> results = new ArrayList<>();
        for (Enrollment e : enrollmentList) {
            if (e.getStudent().equals(student)) {
                results.add(e);
            }
        }
        return results;
    }

    /** Checks if a student is already enrolled in a course. */
    public boolean isAlreadyEnrolled(StudentProfile student, Course course) {
        for (Enrollment e : enrollmentList) {
            if (e.getStudent().equals(student) && e.getCourse().equals(course)) {
                return true;
            }
        }
        return false;
    }

    /** Gets total credits a student is enrolled in (used for 8-credit cap). */
    public int getTotalCredits(StudentProfile student) {
        int totalCredits = 0;
        for (Enrollment e : enrollmentList) {
            if (e.getStudent().equals(student)) {
                totalCredits += e.getCourse().getCredits();
            }
        }
        return totalCredits;
    }

    /** Returns all enrollments across the university. */
    public ArrayList<Enrollment> getAllEnrollments() {
        return enrollmentList;
    }

    /** Returns total number of enrollments. */
    public int getEnrollmentCount() {
        return enrollmentList.size();
    }

    /** ✅ Calculates GPA for a student (used in TranscriptJPanel). */
    public double calculateGPA(StudentProfile student) {
        double totalQualityPoints = 0;
        int totalCredits = 0;

        for (Enrollment e : enrollmentList) {
            if (e.getStudent().equals(student) && !e.getGrade().equals("NA")) {
                double gradePoint = convertGradeToPoints(e.getGrade());
                totalQualityPoints += (gradePoint * e.getCourse().getCredits());
                totalCredits += e.getCourse().getCredits();
            }
        }

        if (totalCredits == 0) return 0;
        return totalQualityPoints / totalCredits;
    }

    /** Converts letter grade to GPA points. */
    private double convertGradeToPoints(String grade) {
        switch (grade.toUpperCase()) {
            case "A":  return 4.0;
            case "A-": return 3.7;
            case "B+": return 3.3;
            case "B":  return 3.0;
            case "B-": return 2.7;
            case "C+": return 2.3;
            case "C":  return 2.0;
            case "C-": return 1.7;
            default:   return 0.0;
        }
    }
}
