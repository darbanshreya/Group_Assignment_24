package ui;

import Model.Faculty;
import Model.Course;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.CardLayout;
import java.awt.event.ActionListener;

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

        lblWelcome.setText("Welcome,[Faculty Name]");

        lblFacultyId.setText("Faculty ID:[ID]");

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        sideMenuPanel.setLayout(new java.awt.GridLayout(6, 1));

        btnCourseManagement.setText("Course Management");
        btnCourseManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCourseManagementActionPerformed(evt);
            }
        });
        sideMenuPanel.add(btnCourseManagement);

        btnProfileManagement.setText("Profile Management");
        btnProfileManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileManagementActionPerformed(evt);
            }
        });
        sideMenuPanel.add(btnProfileManagement);

        btnStudentManagement.setText("Student Management");
        btnStudentManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentManagementActionPerformed(evt);
            }
        });
        sideMenuPanel.add(btnStudentManagement);

        btnGrading.setText("Grading");
        btnGrading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGradingActionPerformed(evt);
            }
        });
        sideMenuPanel.add(btnGrading);

        btnPerformanceReport.setText("Performance Report");
        btnPerformanceReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerformanceReportActionPerformed(evt);
            }
        });
        sideMenuPanel.add(btnPerformanceReport);

        btnTuitionInsight.setText("Tuition Insight");
        btnTuitionInsight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTuitionInsightActionPerformed(evt);
            }
        });
        sideMenuPanel.add(btnTuitionInsight);

        contentPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(lblFacultyId, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addContainerGap())
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sideMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(sideMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLogout)
                            .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblFacultyId)
                                .addComponent(lblWelcome)))
                        .addGap(166, 166, 166)
                        .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // Empty stub - actual handler in setupHandlers()
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnCourseManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCourseManagementActionPerformed
        // Empty stub - actual handler in setupHandlers()
    }//GEN-LAST:event_btnCourseManagementActionPerformed

    private void btnProfileManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileManagementActionPerformed
        // Empty stub - actual handler in setupHandlers()
    }//GEN-LAST:event_btnProfileManagementActionPerformed

    private void btnStudentManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentManagementActionPerformed
        // Empty stub - actual handler in setupHandlers()
    }//GEN-LAST:event_btnStudentManagementActionPerformed

    private void btnGradingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGradingActionPerformed
        // Empty stub - actual handler in setupHandlers()
    }//GEN-LAST:event_btnGradingActionPerformed

    private void btnPerformanceReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerformanceReportActionPerformed
        // Empty stub - actual handler in setupHandlers()
    }//GEN-LAST:event_btnPerformanceReportActionPerformed

    private void btnTuitionInsightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTuitionInsightActionPerformed
        // Empty stub - actual handler in setupHandlers()
    }//GEN-LAST:event_btnTuitionInsightActionPerformed

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
}