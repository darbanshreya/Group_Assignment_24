/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bussiness.Academic;

import java.util.ArrayList;

/**
 * Manages all courses in the Digital University System.
 * @author HP
 */
public class CourseDirectory {
    private ArrayList<Course> courseList;
    
    public CourseDirectory() {
        courseList = new ArrayList<>();
    }
    
    /**
     * Add a new course to the directory
     * @param courseId Course code (e.g., INFO5100)
     * @param courseName Course name
     * @param instructor Instructor name
     * @param credits Number of credits
     * @param semester Semester (e.g., Fall 2025)
     * @param capacity Maximum enrollment capacity
     * @return The newly created Course object
     */
    public Course addCourse(String courseId, String courseName, String instructor, 
                           int credits, String semester, int capacity) {
        Course c = new Course(courseId, courseName, instructor, credits, semester, capacity);
        courseList.add(c);
        return c;
    }
    
    /**
     * Get all courses
     * @return ArrayList of all courses
     */
    public ArrayList<Course> getCourseList() {
        return courseList;
    }
    
    /**
     * Remove a course from the directory
     * @param c Course to remove
     */
    public void removeCourse(Course c) {
        courseList.remove(c);
    }
    
    /**
     * Find a course by its ID
     * @param courseId Course ID to search for
     * @return Course if found, null otherwise
     */
    public Course findCourse(String courseId) {
        for (Course c : courseList) {
            if (c.getCourseId().equalsIgnoreCase(courseId)) {
                return c;
            }
        }
        return null;
    }
    
    /**
     * Search courses by semester
     * @param semester Semester to filter by
     * @return ArrayList of courses in that semester
     */
    public ArrayList<Course> searchBySemester(String semester) {
        ArrayList<Course> results = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getSemester().equalsIgnoreCase(semester)) {
                results.add(c);
            }
        }
        return results;
    }
    
    /**
     * Search courses by instructor name
     * @param instructor Instructor name to search for
     * @return ArrayList of courses taught by that instructor
     */
    public ArrayList<Course> searchByInstructor(String instructor) {
        ArrayList<Course> results = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getInstructor().toLowerCase().contains(instructor.toLowerCase())) {
                results.add(c);
            }
        }
        return results;
    }
    
    /**
     * Search courses by course name
     * @param courseName Course name to search for
     * @return ArrayList of matching courses
     */
    public ArrayList<Course> searchByCourseName(String courseName) {
        ArrayList<Course> results = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getCourseName().toLowerCase().contains(courseName.toLowerCase())) {
                results.add(c);
            }
        }
        return results;
    }
    
    /**
     * Get total number of courses
     * @return Count of courses
     */
    public int getTotalCourses() {
        return courseList.size();
    }
}