package Bussiness.Academic;

import java.util.ArrayList;
import Model.Course;

/**
 * Manages all courses in the Digital University System.
 * Provides utilities to search, add, and manage courses.
 *
 * Author: Shreya Darban
 */
public class CourseDirectory {

    private ArrayList<Course> courseList;

    public CourseDirectory() {
        courseList = new ArrayList<>();
    }

    /** Add a new course to the directory. */
    public Course addCourse(String courseId, String courseName, String faculty,
                            int credits, String term, int totalSeats) {

        double defaultTuition = 2500.0; // default per-course tuition
        Course c = new Course(courseId, courseName, term, credits, defaultTuition);
        c.setFaculty(faculty);
        c.setTotalSeats(totalSeats);
        c.setAvailableSeats(totalSeats);
        courseList.add(c);
        return c;
    }

    /** Get all available courses. */
    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    /** Remove a course from the directory. */
    public void removeCourse(Course c) {
        courseList.remove(c);
    }

    /** Find a course by its ID. */
    public Course findCourse(String courseId) {
        for (Course c : courseList) {
            if (c.getCourseId().equalsIgnoreCase(courseId)) {
                return c;
            }
        }
        return null;
    }

    /** Search for courses by Course ID. */
    public ArrayList<Course> searchByCourseId(String courseId) {
        ArrayList<Course> results = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getCourseId().toLowerCase().contains(courseId.toLowerCase())) {
                results.add(c);
            }
        }
        return results;
    }

    /** Search for courses by Term. */
    public ArrayList<Course> searchByTerm(String term) {
        ArrayList<Course> results = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getTerm().equalsIgnoreCase(term)) {
                results.add(c);
            }
        }
        return results;
    }

    /** Search for courses by Faculty (Instructor name). */
    public ArrayList<Course> searchByFaculty(String faculty) {
        ArrayList<Course> results = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getFaculty() != null &&
                c.getFaculty().toLowerCase().contains(faculty.toLowerCase())) {
                results.add(c);
            }
        }
        return results;
    }

    /** Search for courses by Course Name. */
    public ArrayList<Course> searchByCourseName(String courseName) {
        ArrayList<Course> results = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getCourseName().toLowerCase().contains(courseName.toLowerCase())) {
                results.add(c);
            }
        }
        return results;
    }

    /** Get total number of courses in the directory. */
    public int getTotalCourses() {
        return courseList.size();
    }
}
