/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author ravin
 */
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private String courseId;
    private double maxPoints;
    private Map<String, Double> studentScores; // studentId -> score
    
    public Assignment(String assignmentId, String assignmentName, String courseId, double maxPoints) {
        this.assignmentId = assignmentId;
        this.assignmentName = assignmentName;
        this.courseId = courseId;
        this.maxPoints = maxPoints;
        this.studentScores = new HashMap<>();
    
}
     public String getAssignmentId() { return assignmentId; }
    public void setAssignmentId(String assignmentId) { this.assignmentId = assignmentId; }
    
    public String getAssignmentName() { return assignmentName; }
    public void setAssignmentName(String name) { this.assignmentName = name; }
    
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    
    public double getMaxPoints() { return maxPoints; }
    public void setMaxPoints(double maxPoints) { this.maxPoints = maxPoints; }
    
    public Map<String, Double> getStudentScores() { return studentScores; }
    
    public void setScore(String studentId, double score) {
        if (score >= 0 && score <= maxPoints) {
            studentScores.put(studentId, score);
        }
    }
    
    public double getScore(String studentId) {
        return studentScores.getOrDefault(studentId, 0.0);
    }
}
