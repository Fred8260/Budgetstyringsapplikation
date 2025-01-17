import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Opretter en instans af BudgetManager
        BudgetManager manager = new BudgetManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tilføj transaktion");
            System.out.println("2. Generer rapport");
            System.out.println("3. Udskriv til CSV");
            System.out.println("0. Afslut");
            System.out.print("Vælg en mulighed: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Ryd scanner-buffer

            if (choice == 1) {
                System.out.print("Indtast beløb: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Indtast kategori: ");
                String categoryInput = scanner.nextLine();
                Category category = new Category(categoryInput);  // Opret Category-objekt
                System.out.print("Er det indtægt? (true/false): ");
                boolean isIncome = scanner.nextBoolean();
                manager.addTransaction(new Transaction(amount, category, LocalDate.now(), isIncome));
            } else if (choice == 2) {
                manager.generateReport();
            } else if (choice == 3){
                System.out.println("Indtast filnavn for CSV (f.eks. data.csv): ");
                String filename = scanner.nextLine();
                manager.exportToCSV(filename);
            }
            else if (choice == 0) {
                System.out.println("Programmet afsluttes.");
                break;
            } else {
                System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }

        scanner.close();
    }
}
