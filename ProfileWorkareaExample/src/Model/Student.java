package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Academic model representing a student's academic record.
 * Tracks enrollment, grades, and tuition payments.
 * Author: Shreya Darban
 */
public class Student {

    private String studentId;
    private String name;
    private String email;
    private String program;

    // courseId → letter grade
    private Map<String, String> courseGrades;

    // courseId → tuition paid or not
    private Map<String, Boolean> tuitionPayments;

    // courseId list
    private List<String> enrolledCourseIds;

    public Student(String studentId, String name, String email, String program) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.program = program;
        this.courseGrades = new HashMap<>();
        this.tuitionPayments = new HashMap<>();
        this.enrolledCourseIds = new ArrayList<>();
    }

    // ======== Basic Getters / Setters ========
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }

    public List<String> getEnrolledCourseIds() { return enrolledCourseIds; }

    // ======== Enrollment Methods ========
    public void enrollInCourse(String courseId) {
        if (!enrolledCourseIds.contains(courseId)) {
            enrolledCourseIds.add(courseId);
            tuitionPayments.put(courseId, false); // default unpaid
        }
    }

    public boolean hasPaidForCourse(String courseId) {
        return tuitionPayments.getOrDefault(courseId, false);
    }

    public void setTuitionPaid(String courseId, boolean paid) {
        tuitionPayments.put(courseId, paid);
    }

    // ======== Grades ========
    public void setGradeForCourse(String courseId, String grade) {
        courseGrades.put(courseId, grade);
    }

    public String getGradeForCourse(String courseId) {
        return courseGrades.getOrDefault(courseId, "N/A");
    }

    public Map<String, String> getCourseGrades() { return courseGrades; }

    // ======== GPA Calculation ========
    public double calculateGPA(List<Course> courses) {
        double totalPoints = 0;
        int totalCredits = 0;

        for (Course course : courses) {
            String grade = courseGrades.get(course.getCourseId());
            if (grade != null && !grade.equals("N/A")) {
                double gradePoint = GradeCalculator.getGradePoint(grade);
                totalPoints += gradePoint * course.getCredits(); // FIXED
                totalCredits += course.getCredits();
            }
        }

        return totalCredits > 0 ? totalPoints / totalCredits : 0.0;
    }

    @Override
    public String toString() {
        return studentId + " - " + name + " (" + program + ")";
    }
}
