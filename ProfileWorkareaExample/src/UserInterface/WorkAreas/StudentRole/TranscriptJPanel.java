/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.WorkAreas.StudentRole;
import Business.Business;
import Business.Profiles.StudentProfile;
import Bussiness.Academic.Enrollment;
import Bussiness.Academic.EnrollmentDirectory;
import java.awt.CardLayout;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Shreya
 */
public class TranscriptJPanel extends javax.swing.JPanel {
    private Business business;
    private StudentProfile student;
    private EnrollmentDirectory enrollmentDirectory;
    private JPanel cardPanel;
    /**
     * Creates new form TranscriptJPanel
     */
    public TranscriptJPanel(Business business, StudentProfile student, JPanel cardPanel) {
    initComponents();
    this.business = business;
    this.student = student;
    this.cardPanel = cardPanel;
    this.enrollmentDirectory = business.getEnrollmentDirectory();


        populateTermDropdown();
        ComboBoxTerm.setSelectedIndex(0); // ✅ ensure valid selection
        populateTranscriptTable("All Terms"); // initial load
    }
    
    private void populateTermDropdown() {
        ComboBoxTerm.removeAllItems();
        ComboBoxTerm.addItem("All Terms");
        ComboBoxTerm.addItem("Fall 2025");
        ComboBoxTerm.addItem("Spring 2026");
        ComboBoxTerm.addItem("Fall 2026");
        ComboBoxTerm.addItem("Spring 2027");
    }
    /*
 * GPA Calculation:
 * 1. Convert letter grade → grade points
 * 2. Multiply grade points × course credits = quality points
 * 3. Term GPA = Σ(quality points per term) / Σ(credits per term)
 * 4. Overall GPA = Σ(quality points for all terms) / Σ(credits for all terms)
 */

    private void populateTranscriptTable(String selectedTerm) {
     DefaultTableModel model = (DefaultTableModel) tblTranscript.getModel();
     model.setRowCount(0);

    try {
        // term → {totalQualityPoints, totalCredits}
        HashMap<String, double[]> termStats = new HashMap<>();

        double overallQualityPoints = 0.0;
        double overallCredits = 0.0;

        Object[][] data = {
            {"Fall 2025", "INFO5100", "Application Engineering & Development", "A", 4},
            {"Fall 2025", "INFO6205", "Program Structure & Algorithms", "A-", 4},
            {"Spring 2026", "INFO6210", "Data Management & Database Design", "B+", 4},
            {"Spring 2026", "INFO6150", "Web Design & UX", "B", 4},
            {"Fall 2026", "INFO7250", "Big Data Systems", "A", 4},
            {"Fall 2026", "INFO7374", "Advanced Data Science", "B+", 4},
        };

        // ---------- compute term & overall quality points ----------
        for (Object[] row : data) {
            String term = row[0].toString();
            String grade = row[3].toString();
            int credits = (int) row[4];
            double gradeValue = convertGradeToPoints(grade);
            double qualityPoints = gradeValue * credits;

            overallQualityPoints += qualityPoints;
            overallCredits += credits;

            termStats.putIfAbsent(term, new double[]{0, 0});
            termStats.get(term)[0] += qualityPoints; // total quality points
            termStats.get(term)[1] += credits;       // total credits
        }

        double overallGPA = overallCredits > 0 ? overallQualityPoints / overallCredits : 0.0;
        overallGPA = Math.min(overallGPA, 4.0); // cap GPA to 4.0 max

        // ---------- build table ----------
        for (Object[] row : data) {
            String term = row[0].toString();
            if (!selectedTerm.equals("All Terms") && !term.equalsIgnoreCase(selectedTerm)) continue;

            String grade = row[3].toString();
            int credits = (int) row[4];

            double[] stats = termStats.get(term);
            double termGPA = stats[1] > 0 ? stats[0] / stats[1] : 0.0;

            String standing = getAcademicStanding(termGPA, overallGPA);

            model.addRow(new Object[]{
                term,
                row[1],          // Course ID
                row[2],          // Course Name
                grade,
                String.format("%.2f", termGPA),
                String.format("%.2f", overallGPA),
                standing
            });
           
            if (termGPA < 3.0 || overallGPA < 3.0) 
            {
            tblTranscript.setForeground(java.awt.Color.RED);
            } 
            else 
            {
            tblTranscript.setForeground(java.awt.Color.BLACK);
            }

            
        }

    } 
    
    catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error loading transcript: " + e.getMessage());
    }
    }

    /** Convert letter grade to grade points */
   private double convertGradeToPoints(String grade) {
        switch (grade) {
            case "A+": return 4.0;
            case "A": return 4.0;
            case "A-": return 3.7;
            case "B+": return 3.3;
            case "B": return 3.0;
            case "B-": return 2.7;
            case "C+": return 2.3;
            case "C": return 2.0;
            default: return 0.0;
        }
    }

    /** Determine academic standing based on GPA */
   private String getAcademicStanding(double termGPA, double overallGPA) {
    if (overallGPA < 3.0) 
    {
    return "Academic Probation";
    } 
    else if (termGPA < 3.0 && overallGPA >= 3.0) 
    {
    return "Academic Warning";
    } 
    else 
    {
    return "Good Standing";
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

        btnBack = new javax.swing.JButton();
        lblAcademicTranscript = new javax.swing.JLabel();
        lblSelectTerm = new javax.swing.JLabel();
        lblGradeScale = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTranscript = new javax.swing.JTable();
        ComboBoxTerm = new javax.swing.JComboBox<>();

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblAcademicTranscript.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblAcademicTranscript.setText("Academic  Transcript");

        lblSelectTerm.setText("Select Term");

        lblGradeScale.setText(" Grade Scale: A=4.0, A-=3.7, B+=3.3, B=3.0, B-=2.7");

        tblTranscript.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Term", "Course ID", "Course Name", "Grade", "Term GPA", "Overall GPA", "Academic Standing"
            }
        ));
        jScrollPane1.setViewportView(tblTranscript);

        ComboBoxTerm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fall 2025", "Spring 2026", "Fall 2026", " " }));
        ComboBoxTerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxTermActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAcademicTranscript)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSelectTerm)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblGradeScale)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblAcademicTranscript)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSelectTerm)
                            .addComponent(ComboBoxTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btnBack)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblGradeScale)
                .addGap(143, 143, 143))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxTermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxTermActionPerformed
        // TODO add your handling code here:
        Object selected = ComboBoxTerm.getSelectedItem();
        if (selected == null) return;  // ✅ prevent null crash
        populateTranscriptTable(selected.toString());
    }//GEN-LAST:event_ComboBoxTermActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        cardPanel.remove(this);
    CardLayout layout = (CardLayout) cardPanel.getLayout();
    layout.previous(cardPanel);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxTerm;
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAcademicTranscript;
    private javax.swing.JLabel lblGradeScale;
    private javax.swing.JLabel lblSelectTerm;
    private javax.swing.JTable tblTranscript;
    // End of variables declaration//GEN-END:variables
}
