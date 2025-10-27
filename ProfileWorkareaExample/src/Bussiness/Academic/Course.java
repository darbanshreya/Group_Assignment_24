/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bussiness.Academic;

/**
 * Represents a single course in the Digital University System.
 * @author Shreya
 */
public class Course {
    private String courseId;
    private String courseName;
    private String faculty;
    private int credits;
    private String term;
    private int totalSeats;
    private int availableSeats;
    
    // Constructor
    public Course(String courseId, String courseName, String faculty, int credits, String term, int totalSeats) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.faculty = faculty;
        this.credits = credits;
        this.term = term;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }
    
    // ======== Getters ========
    public String getCourseId() {
        return courseId;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public String getFaculty() {
        return faculty;
    }
    
    // Alias for getFaculty() - used by some components
    public String getInstructor() {
        return faculty;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public String getTerm() {
        return term;
    }
    
    // Alias for getTerm() - used by CourseDirectory search
    public String getSemester() {
        return term;
    }
    
    public int getTotalSeats() {
        return totalSeats;
    }
    
    public int getAvailableSeats() {
        return availableSeats;
    }
    
    // Check if course has available seats
    public boolean hasAvailableSeats() {
        return availableSeats > 0;
    }
    
    // ======== Setters ========
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    
    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    public void setTerm(String term) {
        this.term = term;
    }
    
    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
    
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    
    // ======== Seat Management ========
    public void reduceSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }
    
    public void increaseSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
        }
    }
    
    // ======== Helper Methods ========
    @Override
    public String toString() {
        return courseId + " - " + courseName + " (" + availableSeats + "/" + totalSeats + " seats)";
    }
    
    /**
     * Check if this course matches the given course ID
     * @param id Course ID to check
     * @return true if matches, false otherwise
     */
    public boolean isMatch(String id) {
        return this.courseId.equalsIgnoreCase(id);
    }
}