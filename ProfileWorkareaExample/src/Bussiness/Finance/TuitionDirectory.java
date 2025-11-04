package Bussiness.Finance;

import Business.Profiles.StudentProfile;
import Model.Course;
import java.util.ArrayList;
import java.util.Date;

/**
 * Directory for managing all tuition invoices and payments.
 * Handles creation, refunds, payments, and tuition reporting per student.
 *
 * Author: Shreya
 */
public class TuitionDirectory {

    private ArrayList<TuitionInvoice> invoiceList;
    private ArrayList<Payment> paymentHistory; // Track all student payments & refunds

    // =================== Constructor ===================
    public TuitionDirectory() {
        invoiceList = new ArrayList<>();
        paymentHistory = new ArrayList<>();
    }

    // =================== INVOICE MANAGEMENT ===================

    /** ✅ Create a new tuition invoice for a student (usually per course enrollment) */
    public TuitionInvoice createInvoice(StudentProfile student, double amount, String term) {
        if (student == null || amount <= 0 || term == null || term.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid invoice parameters");
        }

        TuitionInvoice invoice = new TuitionInvoice(student, amount, term);
        invoiceList.add(invoice);

        // Optional: update student’s own financial record (if implemented)
        student.addTuitionCharge(amount);
        return invoice;
    }

    /** ✅ Get all invoices for a specific student */
    public ArrayList<TuitionInvoice> getInvoicesByStudent(StudentProfile student) {
        ArrayList<TuitionInvoice> results = new ArrayList<>();
        if (student == null) return results;

        for (TuitionInvoice ti : invoiceList) {
            if (ti.getStudent().equals(student)) {
                results.add(ti);
            }
        }
        return results;
    }

    /** ✅ Mark an invoice as paid */
    public void markInvoicePaid(TuitionInvoice ti) {
        if (ti != null && !ti.isPaid()) {
            ti.markPaid();
        }
    }

    /** ✅ Get all invoices */
    public ArrayList<TuitionInvoice> getInvoiceList() {
        return invoiceList;
    }

    // =================== FINANCIAL CALCULATIONS ===================

    /** ✅ Calculate total tuition collected (all paid invoices) */
    public double getTotalTuitionCollected() {
        double sum = 0.0;
        for (TuitionInvoice ti : invoiceList) {
            if (ti.isPaid()) {
                sum += ti.getAmount();
            }
        }
        return sum;
    }

    /** ✅ Calculate total outstanding tuition (unpaid invoices) */
    public double getOutstandingTuition() {
        double sum = 0.0;
        for (TuitionInvoice ti : invoiceList) {
            if (!ti.isPaid()) {
                sum += ti.getAmount();
            }
        }
        return sum;
    }

    /** ✅ Calculate unpaid tuition for a specific student */
    public double getTotalTuitionForStudent(StudentProfile student) {
        if (student == null) return 0.0;
        double total = 0.0;
        for (TuitionInvoice ti : invoiceList) {
            if (ti.getStudent().equals(student) && !ti.isPaid()) {
                total += ti.getAmount();
            }
        }
        return total;
    }

    /** ✅ Calculate total tuition revenue for a specific term */
    public double getRevenueByTerm(String term) {
        double sum = 0.0;
        for (TuitionInvoice ti : invoiceList) {
            if (ti.getTerm().equalsIgnoreCase(term) && ti.isPaid()) {
                sum += ti.getAmount();
            }
        }
        return sum;
    }

    // =================== REFUND & PAYMENT HANDLING ===================

    /** ✅ Refund tuition for a dropped course (removes unpaid invoice and logs refund) */
    public void refundTuition(StudentProfile student, Course c) {
        if (student == null || c == null) return;

        TuitionInvoice toRemove = null;
        for (TuitionInvoice ti : invoiceList) {
            if (ti.getStudent().equals(student)
                    && ti.getTerm().equalsIgnoreCase(c.getTerm())
                    && !ti.isPaid()) {
                toRemove = ti;
                break;
            }
        }

        if (toRemove != null) {
            refundTuition(student, toRemove.getAmount()); // log refund
            invoiceList.remove(toRemove);
            System.out.println("Refund processed for " + student.getPerson().getName() +
                    " (" + c.getCourseId() + ") Amount: $" + toRemove.getAmount());
        }
    }

    /** ✅ Direct refund method used by FinanceJPanel Refund button */
    public void refundTuition(StudentProfile student, double refundAmount) {
        if (student == null || refundAmount <= 0) return;

        TuitionInvoice refund = new TuitionInvoice(student, -refundAmount, "REFUND");
        refund.markPaid();
        invoiceList.add(refund);

        double newBalance = getTotalTuitionForStudent(student);
        paymentHistory.add(new Payment(new Date(), -refundAmount, newBalance, "Refund", student));

        System.out.println("Refund issued to " + student.getPerson().getName() +
                " | Amount: $" + refundAmount);
    }

    /** ✅ Record payment for a student (used by FinanceJPanel Pay buttons) */
    public void recordPayment(StudentProfile student, double amount, String method) {
        if (student == null || amount <= 0) return;

        double remaining = amount;
        for (TuitionInvoice ti : invoiceList) {
            if (ti.getStudent().equals(student) && !ti.isPaid()) {
                double invoiceAmount = ti.getAmount();

                if (remaining >= invoiceAmount) {
                    ti.markPaid();
                    remaining -= invoiceAmount;
                } else {
                    ti.setAmount(invoiceAmount - remaining);
                    remaining = 0;
                }
            }
            if (remaining <= 0) break;
        }

        double newBalance = getTotalTuitionForStudent(student);
        paymentHistory.add(new Payment(new Date(), amount, newBalance, method, student));

        System.out.println("Payment recorded for " + student.getPerson().getName() +
                " | Amount: $" + amount + " | Method: " + method);
    }

    // =================== ACCOUNT MANAGEMENT ===================

    /** ✅ Initialize student with default balance = 0 (used during registration/login) */
    public void initializeStudentAccount(StudentProfile student) {
        if (student == null) return;
        boolean exists = false;
        for (TuitionInvoice ti : invoiceList) {
            if (ti.getStudent().equals(student)) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            TuitionInvoice zeroInvoice = new TuitionInvoice(student, 0.0, "INIT");
            zeroInvoice.markPaid();
            invoiceList.add(zeroInvoice);
        }
    }

    // =================== PAYMENT HISTORY ===================

    /** ✅ Return all payments/refunds for a specific student */
    public ArrayList<Payment> getPaymentsForStudent(StudentProfile student) {
        ArrayList<Payment> results = new ArrayList<>();
        if (student == null) return results;

        for (Payment p : paymentHistory) {
            if (p.getStudent().equals(student)) {
                results.add(p);
            }
        }
        return results;
    }

    /** ✅ Helper: total paid by student (for admin summary) */
    public double getTotalPaidForStudent(StudentProfile student) {
        double paid = 0.0;
        for (Payment p : paymentHistory) {
            if (p.getStudent().equals(student) && p.getAmount() > 0) {
                paid += p.getAmount();
            }
        }
        return paid;
    }

    // =================== INNER CLASS ===================

    /** ✅ Payment record for FinanceJPanel display */
    public static class Payment {
        private Date date;
        private double amount;
        private double balanceAfter;
        private String method;
        private StudentProfile student;

        public Payment(Date date, double amount, double balanceAfter, String method, StudentProfile student) {
            this.date = date;
            this.amount = amount;
            this.balanceAfter = balanceAfter;
            this.method = method;
            this.student = student;
        }

        public Date getDate() { return date; }
        public double getAmount() { return amount; }
        public double getBalanceAfter() { return balanceAfter; }
        public String getMethod() { return method; }
        public StudentProfile getStudent() { return student; }
    }
}
