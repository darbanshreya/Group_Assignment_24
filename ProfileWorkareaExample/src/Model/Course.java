/* 
 * Final Unified Course class for the Digital University System.
 * Combines features of both faculty and academic courses.
 * Used across Faculty, Enrollment, and Tuition modules.
 * Author: Shreya Darban
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import Business.Profiles.StudentProfile;

/**
 * Represents a course that can be taught by faculty and taken by students.
 * Includes details for schedule, tuition, capacity, assignments, and enrollments.
 */
public class Course {

    // ======== Core Attributes ========
    private String courseId;
    private String courseName;
    private String faculty; // instructor or professor name
    private String description;
    private String schedule;
    private String term; // same as semester
    private int credits;
    private int totalSeats;
    private int availableSeats;
    private String syllabus;
    private boolean enrollmentOpen;
    private double tuitionPerCourse; // tuition for one course

    // ======== Relations ========
    private List<StudentProfile> enrolledStudents;
    private List<Assignment> assignments;

    // ======== Constructors ========
    public Course(String courseId, String courseName, String term, int credits, double tuitionPerCourse) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.term = term;
        this.credits = credits;
        this.tuitionPerCourse = tuitionPerCourse;
        this.totalSeats = 30;
        this.availableSeats = totalSeats;
        this.enrollmentOpen = true;
        this.enrolledStudents = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    // Optional overload (default tuition)
    public Course(String courseId, String courseName, String term, int credits) {
        this(courseId, courseName, term, credits, 2500.0);
    }

    // ======== Getters ========
    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getFaculty() { return faculty; }
    public String getInstructor() { return faculty; }
    public String getDescription() { return description; }
    public String getSchedule() { return schedule; }
    public String getTerm() { return term; }
    public String getSemester() { return term; }
    public int getCredits() { return credits; }
    public int getTotalSeats() { return totalSeats; }
    public int getAvailableSeats() { return availableSeats; }
    public String getSyllabus() { return syllabus; }
    public boolean isEnrollmentOpen() { return enrollmentOpen; }
    public List<StudentProfile> getEnrolledStudents() { return enrolledStudents; }
    public List<Assignment> getAssignments() { return assignments; }

    // ======== Setters ========
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setFaculty(String faculty) { this.faculty = faculty; }
    public void setCredits(int credits) { this.credits = credits; }
    public void setTerm(String term) { this.term = term; }
    public void setDescription(String description) { this.description = description; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
    public void setSyllabus(String syllabus) { this.syllabus = syllabus; }
    public void setEnrollmentOpen(boolean enrollmentOpen) { this.enrollmentOpen = enrollmentOpen; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
    public void setTuitionPerCourse(double tuitionPerCourse) { this.tuitionPerCourse = tuitionPerCourse; }

    // ======== Tuition / Finance ========

    /**
     * Returns the tuition fee per course (used by EnrollmentDirectory & TuitionDirectory).
     */
    public double getTuitionFee() {
        // You can later enhance this to calculate based on credits (e.g., credits * 1000)
        return tuitionPerCourse;
    }

    /**
     * Alias for compatibility with other modules.
     */
    public double getTuitionPerCourse() {
        return tuitionPerCourse;
    }

    /**
     * Calculates total tuition collected from enrolled students.
     */
    public double getTotalTuitionCollected() {
        return enrolledStudents.size() * tuitionPerCourse;
    }

    // ======== Enrollment Management ========
    public boolean hasAvailableSeats() {
        return availableSeats > 0;
    }

    public void addStudent(StudentProfile student) {
        if (enrollmentOpen && hasAvailableSeats() && !enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            availableSeats--;
        }
    }

    public void removeStudent(StudentProfile student) {
        if (enrolledStudents.remove(student)) {
            availableSeats++;
        }
    }

    // ======== Assignment Management ========
    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    // ======== Seat Management ========
    public void reduceSeat() {
        if (availableSeats > 0) availableSeats--;
    }

    public void increaseSeat() {
        if (availableSeats < totalSeats) availableSeats++;
    }

    // ======== Utility ========
    public boolean isMatch(String id) {
        return this.courseId.equalsIgnoreCase(id);
    }

    @Override
    public String toString() {
        return courseId + " - " + courseName + " (" + faculty + ") [" + availableSeats + "/" + totalSeats + "]";
    }
}
