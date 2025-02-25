package com.example.Budgetmanager;

import java.time.LocalDate;

/**
 * Transaction class to represent a financial transaction.
 * Can be either an income or an expenditure.
 */
public class Transaction {
    private double amount;
    private Category category;
    private LocalDate date;
    private boolean isIncome;

    // Constructor
    public Transaction(double amount, Category category, LocalDate date, boolean isIncome) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.isIncome = isIncome;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isIncome() {
        return isIncome;
    }

    // Setters for updating the transaction fields
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setIncome(boolean isIncome) {
        this.isIncome = isIncome;
    }

    /**
     * Returns a string representation of the transaction.
     */
    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", isIncome=" + isIncome +
                '}';
    }
}
