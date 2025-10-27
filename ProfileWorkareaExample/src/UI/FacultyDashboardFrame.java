package ui;

import Model.Assignment;
import Model.Course;
import Model.Faculty;
import Model.Student;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingUtilities;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
public class FacultyDashboardFrame extends javax.swing.JFrame {
    
    private Faculty currentFaculty;
    private CourseManagementPanel coursePanel;
    private ProfileManagementPanel profilePanel;
    private StudentManagementPanel studentPanel;
    private GradingPanel gradingPanel;
    private PerformanceReportPanel reportPanel;

    public FacultyDashboardFrame(Faculty faculty) {
        this.currentFaculty = faculty;
        initComponents();
        removeOldHandlers();
        setupHandlers();
        setupPanels();
        loadWelcome();
    }
    
    private void removeOldHandlers() {
        for (ActionListener al : btnCourseManagement.getActionListeners()) {
            btnCourseManagement.removeActionListener(al);
        }
        for (ActionListener al : btnProfileManagement.getActionListeners()) {
            btnProfileManagement.removeActionListener(al);
        }
        for (ActionListener al : btnStudentManagement.getActionListeners()) {
            btnStudentManagement.removeActionListener(al);
        }
        for (ActionListener al : btnGrading.getActionListeners()) {
            btnGrading.removeActionListener(al);
        }
        for (ActionListener al : btnPerformanceReport.getActionListeners()) {
            btnPerformanceReport.removeActionListener(al);
        }
        for (ActionListener al : btnTuitionInsight.getActionListeners()) {
            btnTuitionInsight.removeActionListener(al);
        }
        for (ActionListener al : btnLogout.getActionListeners()) {
            btnLogout.removeActionListener(al);
        }
    }
    
    private void setupHandlers() {
        btnCourseManagement.addActionListener(e -> showPanel("course"));
        btnProfileManagement.addActionListener(e -> showPanel("profile"));
        btnStudentManagement.addActionListener(e -> showPanel("student"));
        btnGrading.addActionListener(e -> showPanel("grading"));
        btnPerformanceReport.addActionListener(e -> showPanel("report"));
        btnTuitionInsight.addActionListener(e -> showTuition());
        btnLogout.addActionListener(e -> logout());
    }
    
    private void showPanel(String name) {
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, name);
    }
    
    private void setupPanels() {
        coursePanel = new CourseManagementPanel(currentFaculty);
        profilePanel = new ProfileManagementPanel(currentFaculty);
        studentPanel = new StudentManagementPanel(currentFaculty);
        gradingPanel = new GradingPanel(currentFaculty);
        reportPanel = new PerformanceReportPanel(currentFaculty);
        
        contentPanel.add(coursePanel, "course");
        contentPanel.add(profilePanel, "profile");
        contentPanel.add(studentPanel, "student");
        contentPanel.add(gradingPanel, "grading");
        contentPanel.add(reportPanel, "report");
    }
    
    private void loadWelcome() {
        if (currentFaculty != null) {
            lblWelcome.setText("Welcome, " + currentFaculty.getName());
            lblFacultyId.setText("Faculty ID: " + currentFaculty.getFacultyId());
        }
    }
    
    private void showTuition() {
        if (currentFaculty == null || currentFaculty.getAssignedCourses() == null) {
            JOptionPane.showMessageDialog(this, "No courses assigned", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        double total = 0;
        for (Course c : currentFaculty.getAssignedCourses()) {
            total += c.getTotalTuitionCollected();
        }
        
        JOptionPane.showMessageDialog(this, 
            String.format("Total Tuition: $%.2f", total),
            "Tuition Insight", JOptionPane.INFORMATION_MESSAGE);
    }
    
  private void logout() {
    int result = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to logout?", 
        "Logout Confirmation", 
        JOptionPane.YES_NO_OPTION);
    
    if (result == JOptionPane.YES_OPTION) {
        this.dispose();
        
        SwingUtilities.invokeLater(() -> {
            new Business.ProfileWorkAreaMainFrame().setVisible(true);
        });
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        lblFacultyId = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        sideMenuPanel = new javax.swing.JPanel();
        btnCourseManagement = new javax.swing.JButton();
        btnProfileManagement = new javax.swing.JButton();
        btnStudentManagement = new javax.swing.JButton();
        btnGrading = new javax.swing.JButton();
        btnPerformanceReport = new javax.swing.JButton();
        btnTuitionInsight = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Faculty Dashboard");
        setPreferredSize(new java.awt.Dimension(1200, 700));

        topPanel.setPreferredSize(new java.awt.Dimension(1200, 60));

        lblWelcome.setText("Welcome");

        lblFacultyId.setText("Faculty ID:");

        btnLogout.setText("Logout");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblWelcome)
                .addGap(30, 30, 30)
                .addComponent(lblFacultyId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 800, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(20, 20, 20))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome)
                    .addComponent(lblFacultyId)
                    .addComponent(btnLogout))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        sideMenuPanel.setPreferredSize(new java.awt.Dimension(200, 600));
        sideMenuPanel.setLayout(new java.awt.GridLayout(6, 1, 5, 5));

        btnCourseManagement.setText("Course Management");
        sideMenuPanel.add(btnCourseManagement);

        btnProfileManagement.setText("Profile Management");
        sideMenuPanel.add(btnProfileManagement);

        btnStudentManagement.setText("Student Management");
        sideMenuPanel.add(btnStudentManagement);

        btnGrading.setText("Grading");
        sideMenuPanel.add(btnGrading);

        btnPerformanceReport.setText("Performance Reports");
        sideMenuPanel.add(btnPerformanceReport);

        btnTuitionInsight.setText("Tuition Insights");
        sideMenuPanel.add(btnTuitionInsight);

        getContentPane().add(sideMenuPanel, java.awt.BorderLayout.LINE_START);

        contentPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCourseManagement;
    private javax.swing.JButton btnGrading;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPerformanceReport;
    private javax.swing.JButton btnProfileManagement;
    private javax.swing.JButton btnStudentManagement;
    private javax.swing.JButton btnTuitionInsight;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel lblFacultyId;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel sideMenuPanel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create test faculty
            Faculty faculty = new Faculty("F001", "Dr. John Smith", "john.smith@university.edu", "Computer Science");
            faculty.setPhone("555-1234");
            faculty.setOfficeHours("Mon/Wed 2-4 PM");
            
            // Create test courses
            Course course1 = new Course("INFO5100", "Application Engineering", "Fall 2024", 4, 2500.0);
            course1.setDescription("Learn to build enterprise applications");
            course1.setSchedule("Mon/Wed 6:00-9:00 PM");
            course1.setCapacity(30);
            course1.setSyllabus("Week 1: Introduction\nWeek 2: Java Basics");
            course1.setEnrollmentOpen(true);
            
            Course course2 = new Course("INFO6205", "Data Structures", "Fall 2024", 4, 2500.0);
            course2.setDescription("Advanced algorithms");
            course2.setSchedule("Tue/Thu 6:00-9:00 PM");
            course2.setCapacity(25);
            course2.setEnrollmentOpen(true);
            
            // Create students
            Student student1 = new Student("S001", "Alice Johnson", "alice@university.edu", "MSIS");
            Student student2 = new Student("S002", "Bob Williams", "bob@university.edu", "MSIS");
            Student student3 = new Student("S003", "Carol Davis", "carol@university.edu", "MSIS");
            
            // Enroll students
            course1.addStudent(student1);
            course1.addStudent(student2);
            course1.addStudent(student3);
            
            student1.enrollInCourse("INFO5100");
            student2.enrollInCourse("INFO5100");
            student3.enrollInCourse("INFO5100");
            
            student1.setTuitionPaid("INFO5100", true);
            student2.setTuitionPaid("INFO5100", true);
            student3.setTuitionPaid("INFO5100", false);
            
            // Create assignments
            Assignment assignment1 = new Assignment("A1", "Homework 1", "INFO5100", 100);
            assignment1.setScore("S001", 95);
            assignment1.setScore("S002", 87);
            assignment1.setScore("S003", 92);
            
            Assignment assignment2 = new Assignment("A2", "Homework 2", "INFO5100", 100);
            assignment2.setScore("S001", 88);
            assignment2.setScore("S002", 90);
            assignment2.setScore("S003", 85);
            
            course1.addAssignment(assignment1);
            course1.addAssignment(assignment2);
            
            student1.setGradeForCourse("INFO5100", "A");
            student2.setGradeForCourse("INFO5100", "B+");
            student3.setGradeForCourse("INFO5100", "A-");
            
            course2.addStudent(student1);
            course2.addStudent(student2);
            
            faculty.addCourse(course1);
            faculty.addCourse(course2);
            
            // Launch dashboard
            FacultyDashboardFrame dashboard = new FacultyDashboardFrame(faculty);
            dashboard.setVisible(true);
        });
}
}