/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bussiness.Finance;

import Business.Profiles.StudentProfile;
import java.util.Date;

/**
 * Represents a tuition invoice for a student.
 * Generated when a student enrolls in courses.
 * @author Shreya
 */
public class TuitionInvoice {
    private StudentProfile student;
    private double amount;
    private String term;
    private boolean paid;
    private Date invoiceDate;
    private Date paymentDate;
    
    public TuitionInvoice(StudentProfile student, double amount, String term) {
        this.student = student;
        this.amount = amount;
        this.term = term;
        this.paid = false;
        this.invoiceDate = new Date();
        this.paymentDate = null;
    }
    
    // ======== Getters ========
    public StudentProfile getStudent() {
        return student;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public boolean isPaid() {
        return paid;
    }
    
    public String getTerm() {
        return term;
    }
    
    public Date getInvoiceDate() {
        return invoiceDate;
    }
    
    public Date getPaymentDate() {
        return paymentDate;
    }
    
    // ======== Methods ========
    /**
     * Mark this invoice as paid
     */
    public void markPaid() {
        if (!this.paid) {
            this.paid = true;
            this.paymentDate = new Date();
            student.payTuition(amount);
        }
    }
    
    /**
     * Refund the tuition (when course is dropped)
     */
    public void refund() {
        if (paid) {
            student.payTuition(-amount); // Negative amount = refund
            paid = false;
            paymentDate = null;
        }
    }
    
    @Override
    public String toString() {
        return "Invoice for " + student.getPerson().getName() + 
               " - $" + String.format("%.2f", amount) + 
               " (" + term + ") - " + (paid ? "PAID" : "UNPAID");
    }
}