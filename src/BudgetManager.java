import java.util.ArrayList;
import java.util.List;

public class BudgetManager {
    private List<Transaction> transactions;

    public BudgetManager(){
        transactions = new ArrayList<>();
    }
    public void addTransaction(Transaction transaction){
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

    // Metode til at få rapporter, fx månedlige totaler
    public void generateReport() {
        System.out.println("Total indtægter: " + getTotalIncome());
        System.out.println("Total udgifter: " + getTotalExpenditure());
        // Tilføj evt. kategorirapporter her
    }
}
