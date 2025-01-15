import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Opretter en instans af BudgetManager
        BudgetManager manager = new BudgetManager();

        // Tilføj nogle transaktioner
        manager.addTransaction(new Transaction(500, "Løn", LocalDate.now(), true)); // Indtægt
        manager.addTransaction(new Transaction(100, "Mad", LocalDate.now(), false)); // Udgift
        manager.addTransaction(new Transaction(50, "Transport", LocalDate.now(), false)); // Udgift

        // Generer rapport
        manager.generateReport();
    }
}
