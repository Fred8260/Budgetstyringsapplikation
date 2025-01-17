import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public void exportToCSV(String filename) {
        // Hvis filnavnet ikke ender på ".csv", tilføjes det
        if (!filename.endsWith(".csv")) {
            filename += ".csv";
        }

        // Opretter filstien og BufferedWriter
        Path filePath = Paths.get(filename);  // Denne linje kaster ikke IOException

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
            // Skriver headeren
            writer.write("Amount,Category,Date,Income\n");

            // Skriver transaktioner
            for (Transaction transaction : transactions) {
                writer.write(transaction.getAmount() + "," +
                        transaction.getCategory().getName() + "," +
                        transaction.getDate() + "," +
                        (transaction.isIncome() ? "true" : "false") + "\n");
            }

            // Udskriv den fulde filsti til konsollen
            System.out.println("CSV fil gemt som: " + filePath.toAbsolutePath().toString());

        } catch (IOException e) {
            System.out.println("Fejl ved skrivning af CSV: " + e.getMessage());
        }

    }
}
