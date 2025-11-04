package Bussiness.Finance;

import Business.Profiles.StudentProfile;
import java.util.Date;

/**
 * Represents a tuition invoice for a student.
 * Created when a student enrolls in a course.
 * Tracks payments and refunds.
 *
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

    // ======== Getters and Setters ========
    public StudentProfile getStudent() {
        return student;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    // ======== Business Logic Methods ========

    /** ✅ Mark this invoice as paid */
    public void markPaid() {
        if (!this.paid) {
            this.paid = true;
            this.paymentDate = new Date();
            if (student != null) {
                student.payTuition(amount);
            }
            System.out.println("Invoice marked PAID for " + student.getPerson().getName()
                    + " | Amount: $" + amount);
        }
    }

    /** ✅ Undo payment (e.g., refund) */
    public void markUnpaid() {
        if (this.paid) {
            this.paid = false;
            this.paymentDate = null;
            if (student != null) {
                student.payTuition(-amount); // credit back to balance
            }
            System.out.println("Invoice reverted to UNPAID for " + student.getPerson().getName());
        }
    }

    /** ✅ Issue refund (used when a course is dropped or FinanceJPanel requests refund) */
    public void refund() {
        if (paid) {
            student.payTuition(-amount); // negative = refund
            this.paid = false;
            this.paymentDate = null;
            System.out.println("Refund processed for " + student.getPerson().getName()
                    + " | Amount: $" + amount);
        }
    }

    @Override
    public String toString() {
        return "Invoice for " + student.getPerson().getName() +
               " - $" + String.format("%.2f", amount) +
               " (" + term + ") - " + (paid ? "PAID" : "UNPAID");
    }
}
