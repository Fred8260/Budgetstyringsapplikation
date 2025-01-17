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

    // Beregner balancen ved at trække udgifter fra indtægter
    public double getBalance() {
        return getTotalIncome() - getTotalExpenditure();
    }

    // Generer rapport og vis balance
    public void generateReport() {
        System.out.println("Total indtægter: " + getTotalIncome());
        System.out.println("Total udgifter: " + getTotalExpenditure());
        System.out.println("Aktuel balance: " + getBalance()); // Vis balancen
    }

    public void exportToCSV(String filename) {
        // Hvis filnavnet ikke ender på ".csv", tilføjes det
        if (!filename.endsWith(".csv")) {
            filename += ".csv";
        }

        // Opretter filstien og BufferedWriter
        Path filePath = Paths.get(filename);
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

            // Tilføj balance til CSV
            writer.write("\nBalance: " + getBalance() + "\n");

            // Udskriv den fulde filsti til konsollen
            System.out.println("CSV fil gemt som: " + filePath.toAbsolutePath().toString());

        } catch (IOException e) {
            System.out.println("Fejl ved skrivning af CSV: " + e.getMessage());
        }

    }


    // Export to XML-metode (som tidligere)
    public void exportToXML(String filename) {
        // Hvis filnavnet ikke ender på ".xml", tilføjes det
        if (!filename.endsWith(".xml")) {
            filename += ".xml";
        }

        // Opretter filstien og BufferedWriter
        Path filePath = Paths.get(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
            writer.write("<Budget>\n");

            // Skriver transaktioner
            for (Transaction transaction : transactions) {
                writer.write("  <Transaction>\n");
                writer.write("    <Amount>" + transaction.getAmount() + "</Amount>\n");
                writer.write("    <Category>" + transaction.getCategory().getName() + "</Category>\n");
                writer.write("    <Date>" + transaction.getDate() + "</Date>\n");
                writer.write("    <Income>" + (transaction.isIncome() ? "true" : "false") + "</Income>\n");
                writer.write("  </Transaction>\n");
            }

            // Tilføj balance til XML
            writer.write("  <Balance>" + getBalance() + "</Balance>\n");

            writer.write("</Budget>\n");

            // Udskriv den fulde filsti til konsollen
            System.out.println("XML fil gemt som: " + filePath.toAbsolutePath().toString());

        } catch (IOException e) {
            System.out.println("Fejl ved skrivning af XML: " + e.getMessage());
        }

    }

}

