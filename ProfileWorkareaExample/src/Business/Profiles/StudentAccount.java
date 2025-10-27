/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import java.util.ArrayList;

/**
 *
 * @author Shreya
 * Represents a student's financial account including tuition payments and balance tracking.
 */
public class StudentAccount {

    private double balance;
    private ArrayList<String> paymentHistory;

    public StudentAccount() {
        this.balance = 0.0; // Default balance
        this.paymentHistory = new ArrayList<>();
    }

    // ======== Tuition and Payment Methods ========

    public void addCharge(double amount) {
        balance += amount;
        paymentHistory.add("Charge added: $" + amount);
    }

    public void makePayment(double amount) {
        if (amount <= 0) {
            paymentHistory.add("Invalid payment attempted: $" + amount);
            return;
        }
        balance -= amount;
        paymentHistory.add("Payment made: $" + amount);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<String> getPaymentHistory() {
        return paymentHistory;
    }

    // For display in UI
    public String getLatestTransaction() {
        if (paymentHistory.isEmpty()) {
            return "No transactions yet.";
        }
        return paymentHistory.get(paymentHistory.size() - 1);
    }

    @Override
    public String toString() {
        return "Balance: $" + balance;
    }
}
