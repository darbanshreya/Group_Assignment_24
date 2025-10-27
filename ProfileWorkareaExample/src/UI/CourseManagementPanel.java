package ui;

import Model.Course;
import Model.Faculty;

import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CourseManagementPanel extends javax.swing.JPanel {
    
    private Faculty currentFaculty;
    private Course selectedCourse;

    public CourseManagementPanel(Faculty faculty) {
        this.currentFaculty = faculty;
        initComponents();
        removeOldHandlers();
        setupHandlers();
        loadCourses();
    }
    
    private void removeOldHandlers() {
        for (ActionListener al : cmbCourses.getActionListeners()) {
            cmbCourses.removeActionListener(al);
        }
        for (ActionListener al : btnUpdateCourse.getActionListeners()) {
            btnUpdateCourse.removeActionListener(al);
        }
        for (ActionListener al : btnUploadSyllabus.getActionListeners()) {
            btnUploadSyllabus.removeActionListener(al);
        }
    }
    
    private void setupHandlers() {
        cmbCourses.addActionListener(e -> selectCourse());
        btnUpdateCourse.addActionListener(e -> updateCourse());
        btnUploadSyllabus.addActionListener(e -> uploadSyllabus());
    }
    
    private void loadCourses() {
        cmbCourses.removeAllItems();
        if (currentFaculty != null && currentFaculty.getAssignedCourses() != null) {
            for (Course course : currentFaculty.getAssignedCourses()) {
                cmbCourses.addItem(course.getCourseId() + " - " + course.getTitle());
            }
        }
    }
    
    private void selectCourse() {
        int index = cmbCourses.getSelectedIndex();
        if (index >= 0 && currentFaculty != null && currentFaculty.getAssignedCourses() != null) {
            selectedCourse = currentFaculty.getAssignedCourses().get(index);
            loadCourseDetails();
        }
    }
    
    private void loadCourseDetails() {
        if (selectedCourse != null) {
            txtCourseId.setText(selectedCourse.getCourseId());
            txtCourseTitle.setText(selectedCourse.getTitle());
            txtDescription.setText(selectedCourse.getDescription() != null ? selectedCourse.getDescription() : "");
            txtSchedule.setText(selectedCourse.getSchedule() != null ? selectedCourse.getSchedule() : "");
            spnCapacity.setValue(selectedCourse.getCapacity());
            txtSyllabus.setText(selectedCourse.getSyllabus() != null ? selectedCourse.getSyllabus() : "");
            cmbEnrollmentStatus.setSelectedItem(selectedCourse.isEnrollmentOpen() ? "Open" : "Closed");
        }
    }
    
    private void updateCourse() {
        if (selectedCourse == null) {
            JOptionPane.showMessageDialog(this, "Please select a course first", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (txtCourseTitle.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Course title cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (txtSchedule.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Schedule cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        selectedCourse.setTitle(txtCourseTitle.getText().trim());
        selectedCourse.setDescription(txtDescription.getText().trim());
        selectedCourse.setSchedule(txtSchedule.getText().trim());
        selectedCourse.setCapacity((Integer) spnCapacity.getValue());
        selectedCourse.setSyllabus(txtSyllabus.getText().trim());
        selectedCourse.setEnrollmentOpen(cmbEnrollmentStatus.getSelectedItem().equals("Open"));
        
        JOptionPane.showMessageDialog(this, "Course updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        loadCourses();
    }
    
    private void uploadSyllabus() {
        if (selectedCourse == null) {
            JOptionPane.showMessageDialog(this, "Please select a course first", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Syllabus File");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text Files", "txt"));
        
        int result = fileChooser.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            
            try {
                byte[] fileBytes = Files.readAllBytes(selectedFile.toPath());
                String content = new String(fileBytes);
                
                txtSyllabus.setText(content);
                selectedCourse.setSyllabus(content);
                
                JOptionPane.showMessageDialog(this, "Syllabus uploaded successfully: " + selectedFile.getName(), "Success", JOptionPane.INFORMATION_MESSAGE);
                    
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbCourses = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtCourseId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCourseTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtSchedule = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        spnCapacity = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSyllabus = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        cmbEnrollmentStatus = new javax.swing.JComboBox<>();
        btnUpdateCourse = new javax.swing.JButton();
        btnUploadSyllabus = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setText("Course Management");
        add(lblTitle, java.awt.BorderLayout.PAGE_START);

        formPanel.setLayout(null);

        jLabel1.setText("Select Course:");
        formPanel.add(jLabel1);
        jLabel1.setBounds(20, 20, 100, 16);

        formPanel.add(cmbCourses);
        cmbCourses.setBounds(150, 20, 300, 22);

        jLabel2.setText("Course ID:");
        formPanel.add(jLabel2);
        jLabel2.setBounds(20, 60, 100, 16);

        txtCourseId.setEditable(false);
        formPanel.add(txtCourseId);
        txtCourseId.setBounds(150, 60, 300, 22);

        jLabel3.setText("Course Title:");
        formPanel.add(jLabel3);
        jLabel3.setBounds(20, 100, 100, 16);

        formPanel.add(txtCourseTitle);
        txtCourseTitle.setBounds(150, 100, 300, 22);

        jLabel4.setText("Description:");
        formPanel.add(jLabel4);
        jLabel4.setBounds(20, 140, 100, 16);

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtDescription);

        formPanel.add(jScrollPane1);
        jScrollPane1.setBounds(150, 140, 400, 96);

        jLabel5.setText("Schedule:");
        formPanel.add(jLabel5);
        jLabel5.setBounds(20, 250, 100, 16);

        formPanel.add(txtSchedule);
        txtSchedule.setBounds(150, 250, 300, 22);

        jLabel6.setText("Capacity:");
        formPanel.add(jLabel6);
        jLabel6.setBounds(20, 290, 100, 16);

        spnCapacity.setModel(new javax.swing.SpinnerNumberModel(30, 10, 100, 1));
        formPanel.add(spnCapacity);
        spnCapacity.setBounds(150, 290, 100, 22);

        jLabel7.setText("Syllabus:");
        formPanel.add(jLabel7);
        jLabel7.setBounds(20, 330, 100, 16);

        txtSyllabus.setColumns(20);
        txtSyllabus.setRows(5);
        txtSyllabus.setLineWrap(true);
        txtSyllabus.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtSyllabus);

        formPanel.add(jScrollPane2);
        jScrollPane2.setBounds(150, 330, 400, 96);

        jLabel8.setText("Enrollment Status:");
        formPanel.add(jLabel8);
        jLabel8.setBounds(20, 480, 120, 16);

        cmbEnrollmentStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Open", "Closed" }));
        formPanel.add(cmbEnrollmentStatus);
        cmbEnrollmentStatus.setBounds(150, 480, 100, 22);

        btnUpdateCourse.setText("Update Course");
        formPanel.add(btnUpdateCourse);
        btnUpdateCourse.setBounds(150, 520, 130, 23);

        btnUploadSyllabus.setText("Upload Syllabus");
        formPanel.add(btnUploadSyllabus);
        btnUploadSyllabus.setBounds(290, 520, 130, 23);

        add(formPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdateCourse;
    private javax.swing.JButton btnUploadSyllabus;
    private javax.swing.JComboBox<String> cmbCourses;
    private javax.swing.JComboBox<String> cmbEnrollmentStatus;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JSpinner spnCapacity;
    private javax.swing.JTextField txtCourseId;
    private javax.swing.JTextField txtCourseTitle;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtSchedule;
    private javax.swing.JTextArea txtSyllabus;
    // End of variables declaration//GEN-END:variables
}