/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.WorkAreas.StudentRole;
import Business.Business;
import Business.Profiles.StudentProfile;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Shreya
 */
public class GraduationJPanel extends javax.swing.JPanel {
    private Business business;
    private StudentProfile student;
    private javax.swing.JPanel cardPanel;

    /**
     * Creates new form GraduationJPanel
     */
    public GraduationJPanel(Business business, StudentProfile student, javax.swing.JPanel cardPanel) {
    initComponents();
    this.business = business;
    this.student = student;
    this.cardPanel = cardPanel; // ✅ store reference

    populateGraduationAudit();
}

    private void populateGraduationAudit() {
       
        try {
            // ===================== Program Requirements =====================
            int totalRequiredCredits = 32; // Typical MSIS credit requirement
            int coreRequiredCredits = 4;  // INFO 5100 is the only core required course
            int electiveRequiredCredits = 28; // Remaining credits are electives


            // ===================== Mock Completed Data =====================
            // ===================== Example Completed Courses =====================
    Object[][] completedCourses = {
    {"INFO5100", "Application Engineering & Development", 4, "Completed", "Core"},
    {"INFO6205", "Program Structure & Algorithms", 4, "Completed", "Elective"},
    {"INFO6210", "Data Management & Database Design", 4, "Completed", "Elective"},
    {"INFO6150", "Web Design & UX", 4, "Completed", "Elective"},
    {"INFO7250", "Big Data Systems", 4, "In Progress", "Elective"},
    {"INFO7374", "Advanced Data Science", 4, "Not Started", "Elective"}
};


            // ===================== Calculate Credits =====================
            int completedCredits = 0;
            int coreCompleted = 0;
            int electiveCompleted = 0;

            for (Object[] row : completedCourses) {
                String status = row[3].toString();
                int credits = (int) row[2];
                String type = row[4].toString();

                if (status.equalsIgnoreCase("Completed")) {
                    completedCredits += credits;
                    if (type.equalsIgnoreCase("Core")) coreCompleted += credits;
                    else electiveCompleted += credits;
                }
            }

            int remainingCredits = totalRequiredCredits - completedCredits;
            int remainingCore = coreRequiredCredits - coreCompleted;
            int remainingElective = electiveRequiredCredits - electiveCompleted;
            int progressPercent = Math.min(100, (int) ((completedCredits / (double) totalRequiredCredits) * 100));


            // ===================== Update Labels =====================
            lblTotalCreditsRequired.setText("Total Credits Required: " + totalRequiredCredits);
            lblCreditsCompleted.setText("Credits Completed: " + completedCredits);
            lblCreditsRemaining.setText("Credits Remaining: " + remainingCredits);
            lblCoreCourseRequirement.setText("Core Course Requirement: " + coreCompleted + "/" + coreRequiredCredits + " credits");
            lblElectiveCredits.setText("Elective Credits: " + electiveCompleted + "/" + electiveRequiredCredits + " credits");
            lblCompletedCredits.setText("Completed: " + completedCredits + " credits");
            lblNeededCredits.setText("Needed: " + remainingCredits + " credits");

            // ===================== Update Progress Bar =====================
            ProgressBar.setValue(progressPercent);
            ProgressBar.setString(progressPercent + "% Completed");
            ProgressBar.setStringPainted(true);
            if (progressPercent >= 100) {
    ProgressBar.setForeground(new java.awt.Color(0, 153, 0)); // green
} else if (progressPercent >= 75) {
    ProgressBar.setForeground(new java.awt.Color(255, 204, 0)); // yellow
} else {
    ProgressBar.setForeground(new java.awt.Color(255, 102, 102)); // red
}


            // ===================== Fill Table =====================
            DefaultTableModel model = (DefaultTableModel) tblGraduationAudit.getModel();
            model.setRowCount(0);
            for (Object[] row : completedCourses) {
                model.addRow(new Object[]{row[0], row[1], row[2], row[3]});
            }

            boolean coreCompletedFlag = coreCompleted >= coreRequiredCredits;

if (completedCredits >= totalRequiredCredits && coreCompletedFlag) {
    lblStatus.setText("Status: ✅ Ready to Graduate (All Requirements Met)");
} else if (coreCompletedFlag && completedCredits >= totalRequiredCredits * 0.75) {
    lblStatus.setText("Status: ⏳ On Track — Core Completed, Finish Electives");
} else if (!coreCompletedFlag) {
    lblStatus.setText("Status: ⚠️ Core Course (INFO5100) Not Completed");
} else {
    lblStatus.setText("Status: 🚧 In Progress — Continue Completing Courses");
}


        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading graduation audit: " + e.getMessage());
        
        }
    
    }
  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGraduationAudit = new javax.swing.JLabel();
        lblTotalCreditsRequired = new javax.swing.JLabel();
        lblCreditsCompleted = new javax.swing.JLabel();
        lblCreditsRemaining = new javax.swing.JLabel();
        lblProgress = new javax.swing.JLabel();
        ProgressBar = new javax.swing.JProgressBar();
        lblCoreCourseRequirement = new javax.swing.JLabel();
        lblElectiveCredits = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGraduationAudit = new javax.swing.JTable();
        lblStatus = new javax.swing.JLabel();
        lblCompletedCredits = new javax.swing.JLabel();
        lblNeededCredits = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        lblGraduationAudit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblGraduationAudit.setText("Graduation Requirements Audit - MSIS Program");

        lblTotalCreditsRequired.setText("Total Credits Required:");

        lblCreditsCompleted.setText("Credits Completed:");

        lblCreditsRemaining.setText("Credits Remaining:");

        lblProgress.setText("Progress:");

        lblCoreCourseRequirement.setText("Core Course Requirement:");

        lblElectiveCredits.setText("Elective Credits:                                           ");

        tblGraduationAudit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course Code", "Course Name", "Credits", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblGraduationAudit);

        lblStatus.setText(" Status:       ");

        lblCompletedCredits.setText("Completed:   ");

        lblNeededCredits.setText("Needed: ");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStatus)
                            .addComponent(lblCompletedCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNeededCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblGraduationAudit)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblTotalCreditsRequired)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblProgress)
                                    .addGap(18, 18, 18)
                                    .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblCreditsCompleted)
                                .addComponent(lblCreditsRemaining)
                                .addComponent(lblCoreCourseRequirement)
                                .addComponent(lblElectiveCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(71, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGraduationAudit)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(lblTotalCreditsRequired)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCreditsCompleted)
                .addGap(16, 16, 16)
                .addComponent(lblCreditsRemaining)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProgress, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCoreCourseRequirement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblElectiveCredits)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCompletedCredits)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNeededCredits)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblStatus)
                .addContainerGap(256, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        cardPanel.remove(this);
    java.awt.CardLayout layout = (java.awt.CardLayout) cardPanel.getLayout();
    layout.previous(cardPanel);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCompletedCredits;
    private javax.swing.JLabel lblCoreCourseRequirement;
    private javax.swing.JLabel lblCreditsCompleted;
    private javax.swing.JLabel lblCreditsRemaining;
    private javax.swing.JLabel lblElectiveCredits;
    private javax.swing.JLabel lblGraduationAudit;
    private javax.swing.JLabel lblNeededCredits;
    private javax.swing.JLabel lblProgress;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTotalCreditsRequired;
    private javax.swing.JTable tblGraduationAudit;
    // End of variables declaration//GEN-END:variables
}
