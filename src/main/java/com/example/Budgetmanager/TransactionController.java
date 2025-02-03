package com.example.Budgetmanager;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "*") // Tillader anmodninger fra alle domæner
public class TransactionController {

    private final BudgetManager budgetManager;

    public TransactionController(BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
    }

    // Hent alle transaktioner
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return budgetManager.getTransactions();
    }

    // Tilføj en ny transaktion
    @PostMapping
    public void addTransaction(@RequestBody Transaction transaction) {
        budgetManager.addTransaction(transaction);
    }

    // Opdater en eksisterende transaktion
    @PutMapping("/{index}")
    public void updateTransaction(@PathVariable int index, @RequestBody Transaction transaction) {
        budgetManager.updateTransaction(index, transaction.getAmount(), transaction.getCategory(), transaction.getDate(), transaction.isIncome());
    }

    // Slet en transaktion
    @DeleteMapping("/{index}")
    public void deleteTransaction(@PathVariable int index) {
        budgetManager.getTransactions().remove(index);
    }
}
