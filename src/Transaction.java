import java.time.LocalDate;

/**
 * Transaction class to represent a financial transaction.
 * Can be either an income or an expenditure.
 */

public class Transaction {
    // Fields and constructor omitted for brevity

    private double amount;
    private String category;
    private LocalDate date;
    private boolean isIncome;


    // Constructor
    public Transaction(double amount, String category, LocalDate date, boolean isIncome) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.isIncome = isIncome;
    }

    public String getCategory() {
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
