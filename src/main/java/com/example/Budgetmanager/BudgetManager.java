package com.example.Budgetmanager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class BudgetManager {
    private List<Transaction> transactions;

    public BudgetManager() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public double getTotalIncome() {
        return transactions.stream()
                .filter(Transaction::isIncome)
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double getTotalExpenditure() {
        return transactions.stream()
                .filter(transaction -> !transaction.isIncome())
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double getBalance() {
        return getTotalIncome() - getTotalExpenditure();
    }

    public void generateReport() {
        System.out.println("Total indtægter: " + getTotalIncome());
        System.out.println("Total udgifter: " + getTotalExpenditure());
        System.out.println("Aktuel balance: " + getBalance());
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Metode til at opdatere en transaktion baseret på indeks
    public void updateTransaction(int index, double newAmount, Category newCategory, LocalDate newDate, boolean newIsIncome) {
        if (index >= 0 && index < transactions.size()) {
            Transaction transaction = transactions.get(index); // Hent transaktionen baseret på indeks
            transaction.setAmount(newAmount); // Opdater beløb
            transaction.setCategory(newCategory); // Opdater kategori
            transaction.setDate(newDate); // Opdater dato
            transaction.setIncome(newIsIncome); // Opdater om det er indtægt
            System.out.println("Transaktion opdateret: " + transaction);
        } else {
            System.out.println("Transaktion ikke fundet.");
        }
    }

    public void exportToCSV(String filename) {
        // Tilføj ".csv" hvis filnavnet ikke allerede indeholder det
        if (!filename.endsWith(".csv")) {
            filename += ".csv";
        }

        try (FileWriter writer = new FileWriter(filename)) {
            writer.append("Amount,Category,Date,IsIncome\n");
            for (Transaction transaction : transactions) {
                writer.append(transaction.getAmount() + ",");
                writer.append(transaction.getCategory().getName() + ",");
                writer.append(transaction.getDate().toString() + ",");
                writer.append(transaction.isIncome() + "\n");
            }
            System.out.println("Data eksporteret til CSV: " + filename);
        } catch (IOException e) {
            System.out.println("Fejl ved eksport til CSV: " + e.getMessage());
        }
    }

    public void exportToXML(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.append("<transactions>\n");
            for (Transaction transaction : transactions) {
                writer.append("  <transaction>\n");
                writer.append("    <amount>" + transaction.getAmount() + "</amount>\n");
                writer.append("    <category>" + transaction.getCategory().getName() + "</category>\n");
                writer.append("    <date>" + transaction.getDate() + "</date>\n");
                writer.append("    <isIncome>" + transaction.isIncome() + "</isIncome>\n");
                writer.append("  </transaction>\n");
            }
            writer.append("</transactions>");
            System.out.println("Data eksporteret til XML: " + filename);
        } catch (IOException e) {
            System.out.println("Fejl ved eksport til XML: " + e.getMessage());
        }
    }
}
