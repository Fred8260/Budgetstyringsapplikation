package com.example.Budgetmanager;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.Budgetmanager.Transaction;

public class ReportGenerator {
    private List<Transaction> transactions;

    public ReportGenerator(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void generateCategoryReport() {
        Map<String, Double> categoryTotals = transactions.stream()
                .collect(Collectors.groupingBy(t -> t.getCategory().getName(),
                        Collectors.summingDouble(Transaction::getAmount)));

        System.out.println("Kategori rapport:");
        categoryTotals.forEach((category, total) ->
                System.out.println(category + ": " + total));
    }
}
