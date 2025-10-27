/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bussiness.Finance;

import Business.Profiles.StudentProfile;
import java.util.ArrayList;

/**
 * Directory for managing all tuition invoices and payments.
 * @author Shreya
 */
public class TuitionDirectory {
    private ArrayList<TuitionInvoice> invoiceList;
    
    public TuitionDirectory() {
        invoiceList = new ArrayList<>();
    }
    
    /**
     * Create a new tuition invoice for a student
     * @param student Student profile
     * @param amount Tuition amount
     * @param term Academic term
     * @return The created invoice
     */
    public TuitionInvoice createInvoice(StudentProfile student, double amount, String term) {
        if (student == null || amount <= 0 || term == null || term.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid invoice parameters");
        }
        
        TuitionInvoice invoice = new TuitionInvoice(student, amount, term);
        invoiceList.add(invoice);
        student.addTuitionCharge(amount);
        return invoice;
    }
    
    /**
     * Get all invoices for a specific student
     * @param student Student profile
     * @return List of invoices for that student
     */
    public ArrayList<TuitionInvoice> getInvoicesByStudent(StudentProfile student) {
        ArrayList<TuitionInvoice> results = new ArrayList<>();
        if (student == null) {
            return results;
        }
        
        for (TuitionInvoice ti : invoiceList) {
            if (ti.getStudent().equals(student)) {
                results.add(ti);
            }
        }
        return results;
    }
    
    /**
     * Mark an invoice as paid
     * @param ti Tuition invoice to mark as paid
     */
    public void markInvoicePaid(TuitionInvoice ti) {
        if (ti != null && !ti.isPaid()) {
            ti.markPaid();
        }
    }
    
    /**
     * Get all invoices
     * @return List of all tuition invoices
     */
    public ArrayList<TuitionInvoice> getInvoiceList() {
        return invoiceList;
    }
    
    /**
     * Calculate total tuition collected (paid invoices)
     * @return Total amount collected
     */
    public double getTotalTuitionCollected() {
        double sum = 0.0;
        for (TuitionInvoice ti : invoiceList) {
            if (ti.isPaid()) {
                sum += ti.getAmount();
            }
        }
        return sum;
    }
    
    /**
     * Calculate outstanding tuition (unpaid invoices)
     * @return Total outstanding amount
     */
    public double getOutstandingTuition() {
        double sum = 0.0;
        for (TuitionInvoice ti : invoiceList) {
            if (!ti.isPaid()) {
                sum += ti.getAmount();
            }
        }
        return sum;
    }
    
    /**
     * Get invoices by term/semester
     * @param term Academic term
     * @return List of invoices for that term
     */
    public ArrayList<TuitionInvoice> getInvoicesByTerm(String term) {
        ArrayList<TuitionInvoice> results = new ArrayList<>();
        if (term == null || term.trim().isEmpty()) {
            return results;
        }
        
        for (TuitionInvoice ti : invoiceList) {
            if (ti.getTerm().equalsIgnoreCase(term)) {
                results.add(ti);
            }
        }
        return results;
    }
    
    /**
     * Get all unpaid invoices
     * @return List of unpaid invoices
     */
    public ArrayList<TuitionInvoice> getUnpaidInvoices() {
        ArrayList<TuitionInvoice> results = new ArrayList<>();
        for (TuitionInvoice ti : invoiceList) {
            if (!ti.isPaid()) {
                results.add(ti);
            }
        }
        return results;
    }
    
    /**
     * Get all paid invoices
     * @return List of paid invoices
     */
    public ArrayList<TuitionInvoice> getPaidInvoices() {
        ArrayList<TuitionInvoice> results = new ArrayList<>();
        for (TuitionInvoice ti : invoiceList) {
            if (ti.isPaid()) {
                results.add(ti);
            }
        }
        return results;
    }
    
    /**
     * Get total number of invoices
     * @return Count of invoices
     */
    public int getTotalInvoices() {
        return invoiceList.size();
    }
    
    /**
     * Calculate tuition revenue by term
     * @param term Academic term
     * @return Total revenue for that term
     */
    public double getRevenueByTerm(String term) {
        double sum = 0.0;
        for (TuitionInvoice ti : invoiceList) {
            if (ti.getTerm().equalsIgnoreCase(term) && ti.isPaid()) {
                sum += ti.getAmount();
            }
        }
        return sum;
    }
}