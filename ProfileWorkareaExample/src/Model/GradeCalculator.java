/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author ravin
 */
public class GradeCalculator {
    private static final Map<String, Double> GRADE_POINTS = new HashMap<>();
    
    static {
        GRADE_POINTS.put("A", 4.0);
        GRADE_POINTS.put("A-", 3.7);
        GRADE_POINTS.put("B+", 3.3);
        GRADE_POINTS.put("B", 3.0);
        GRADE_POINTS.put("B-", 2.7);
        GRADE_POINTS.put("C+", 2.3);
        GRADE_POINTS.put("C", 2.0);
        GRADE_POINTS.put("C-", 1.7);
        GRADE_POINTS.put("F", 0.0);
    
}
     public static double getGradePoint(String letterGrade) {
        return GRADE_POINTS.getOrDefault(letterGrade, 0.0);
    }
    
    public static String calculateLetterGrade(double percentage) {
        if (percentage >= 93) return "A";
           else if (percentage >= 90) return "A-";
        else if (percentage >= 87) return "B+";
        else if (percentage >= 83) return "B";
        else if (percentage >= 80) return "B-";
        else if (percentage >= 77) return "C+";
        else if (percentage >= 73) return "C";
        else if (percentage >= 70) return "C-";
        else return "F";
    }
    public static double calculateStudentTotalPercentage(Student student, Course course) {
        List<Assignment> assignments = course.getAssignments();
        if (assignments.isEmpty()) return 0.0;
        
        double totalEarned = 0;
        double totalPossible = 0;
        
        for (Assignment assignment : assignments) {
            totalEarned += assignment.getScore(student.getStudentId());
            totalPossible += assignment.getMaxPoints();
        }
        
        return totalPossible > 0 ? (totalEarned / totalPossible) * 100 : 0.0;
    }
    public static double calculateClassAverageGrade(Course course) {
        List<Student> students = course.getEnrolledStudents();
        if (students.isEmpty()) return 0.0;
        
        double totalPercentage = 0;
        for (Student student : students) {
            totalPercentage += calculateStudentTotalPercentage(student, course);
        }
        
        return totalPercentage / students.size();
    }
     public static Map<String, Integer> calculateGradeDistribution(Course course) {
        Map<String, Integer> distribution = new HashMap<>();
        distribution.put("A", 0);
        distribution.put("A-", 0);
        distribution.put("B+", 0);
        distribution.put("B", 0);
        distribution.put("B-", 0);
        distribution.put("C+", 0);
        distribution.put("C", 0);
        distribution.put("C-", 0);
        distribution.put("F", 0);
        
        for (Student student : course.getEnrolledStudents()) {
            double percentage = calculateStudentTotalPercentage(student, course);
            String letterGrade = calculateLetterGrade(percentage);
            distribution.put(letterGrade, distribution.get(letterGrade) + 1);
        }
        
        return distribution;
    }
}
