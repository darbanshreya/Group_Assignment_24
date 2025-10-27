/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ravin
 */
public class Course {
     private String courseId;
    private String title;
    private String description;
    private String schedule;
    private int capacity;
    private int enrolledCount;
    private String syllabus;
    private boolean enrollmentOpen;
    private String semester;
    private int creditHours;
    private double tuitionPerCourse;
    private List<Student> enrolledStudents;
    private List<Assignment> assignments;
    
    public Course(String courseId, String title, String semester, int creditHours, double tuitionPerCourse) {
        this.courseId = courseId;
        this.title = title;
        this.semester = semester;
        this.creditHours = creditHours;
        this.tuitionPerCourse = tuitionPerCourse;
        this.enrolledStudents = new ArrayList<>();
        this.assignments = new ArrayList<>();
        this.enrollmentOpen = true;
        this.capacity = 30;
    }

    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getSchedule() { return schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
    
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    
    public int getEnrolledCount() { return enrolledStudents.size(); }
    
    public String getSyllabus() { return syllabus; }
    public void setSyllabus(String syllabus) { this.syllabus = syllabus; }
    
    public boolean isEnrollmentOpen() { return enrollmentOpen; }
    public void setEnrollmentOpen(boolean enrollmentOpen) { this.enrollmentOpen = enrollmentOpen; }
    
    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }
    
    public int getCreditHours() { return creditHours; }
    public void setCreditHours(int creditHours) { this.creditHours = creditHours; }
    
    public double getTuitionPerCourse() { return tuitionPerCourse; }
    public void setTuitionPerCourse(double tuition) { this.tuitionPerCourse = tuition; }
    
    public List<Student> getEnrolledStudents() { return enrolledStudents; }
    public void setEnrolledStudents(List<Student> students) { this.enrolledStudents = students; }
    
    public List<Assignment> getAssignments() { return assignments; }
    public void setAssignments(List<Assignment> assignments) { this.assignments = assignments; }
    
    public void addStudent(Student student) {
        if (!enrolledStudents.contains(student) && enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
        }
    }
    
    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }
    
    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
    
    public double getTotalTuitionCollected() {
        return enrolledStudents.stream()
            .filter(s -> s.hasPaidForCourse(this.courseId))
            .count() * tuitionPerCourse;
    }
}