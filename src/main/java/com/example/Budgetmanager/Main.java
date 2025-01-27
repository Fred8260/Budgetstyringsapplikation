package com.example.Budgetmanager;

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
            System.out.println("2. Generer kategori-rapport");
            System.out.println("3. Generer balance-rapport");
            System.out.println("4. Udskriv til CSV");
            System.out.println("5. Udskriv til XML");
            System.out.println("6. Opdater transaktion");
            System.out.println("0. Afslut");
            System.out.print("Vælg en mulighed: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Ryd scanner-buffer

            if (choice == 1) {
                System.out.print("Indtast beløb: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                // Vælg kategori
                System.out.println("Vælg kategori:");
                System.out.println("1. " + CategoryType.FOOD);
                System.out.println("2. " + CategoryType.TRANSPORT);
                System.out.println("3. " + CategoryType.ENTERTAINMENT);
                System.out.println("4. " + CategoryType.HOUSING);
                System.out.println("5. " + CategoryType.UTILITIES);
                System.out.println("6. " + CategoryType.SALARY);
                System.out.println("7. Anden kategori");

                int categoryChoice = scanner.nextInt();
                scanner.nextLine(); // Ryd scanner-buffer
                Category category;

                switch (categoryChoice) {
                    case 1:
                        category = new Category(CategoryType.FOOD.name()); // Konverter til Category
                        break;
                    case 2:
                        category = new Category(CategoryType.TRANSPORT.name()); // Konverter til Category
                        break;
                    case 3:
                        category = new Category(CategoryType.ENTERTAINMENT.name()); // Konverter til Category
                        break;
                    case 4:
                        category = new Category(CategoryType.HOUSING.name()); // Konverter til Category
                        break;
                    case 5:
                        category = new Category(CategoryType.UTILITIES.name()); // Konverter til Category
                        break;
                    case 6:
                        category = new Category(CategoryType.SALARY.name()); // Konverter til Category
                        break;
                    case 7:
                        System.out.print("Indtast din egen kategori: ");
                        String customCategory = scanner.nextLine();
                        category = new Category(customCategory); // Brugerdefineret kategori
                        break;
                    default:
                        System.out.println("Ugyldigt valg. Vælger 'Anden kategori'.");
                        System.out.print("Indtast din egen kategori: ");
                        String customCategoryDefault = scanner.nextLine();
                        category = new Category(customCategoryDefault); // Brugerdefineret kategori
                }

                System.out.print("Er det indtægt? (true/false): ");
                boolean isIncome = scanner.nextBoolean();
                scanner.nextLine(); // Ryd scanner-buffer

                manager.addTransaction(new Transaction(amount, category, LocalDate.now(), isIncome));
            } else if (choice == 2) {
                // Opret en ReportGenerator og kald generateCategoryReport
                ReportGenerator reportGenerator = new ReportGenerator(manager.getTransactions());
                reportGenerator.generateCategoryReport();
            } else if (choice == 3) {
                manager.generateReport();  // Genererer balance-rapport
            } else if (choice == 4) {
                System.out.print("Indtast filnavn for CSV (f.eks. data.csv): ");
                String filename = scanner.nextLine();
                manager.exportToCSV(filename);
            } else if (choice == 5) {
                System.out.print("Indtast filnavn for XML (f.eks. data.xml): ");
                String filename = scanner.nextLine();
                manager.exportToXML(filename);
            } else if (choice == 6) {
                // Vis alle transaktioner og lad brugeren vælge en at opdatere
                System.out.println("Vælg en transaktion at opdatere:");
                for (int i = 0; i < manager.getTransactions().size(); i++) {
                    Transaction transaction = manager.getTransactions().get(i);
                    System.out.println(i + ". " + transaction);
                }

                System.out.print("Indtast nummeret på transaktionen du vil opdatere: ");
                int index = scanner.nextInt();
                scanner.nextLine();  // Ryd scanner-buffer

                // Sørg for at index er gyldigt
                if (index >= 0 && index < manager.getTransactions().size()) {
                    System.out.print("Indtast nyt beløb: ");
                    double newAmount = scanner.nextDouble();
                    scanner.nextLine();

                    // Vælg kategori
                    System.out.println("Vælg kategori:");
                    System.out.println("1. " + CategoryType.FOOD);
                    System.out.println("2. " + CategoryType.TRANSPORT);
                    System.out.println("3. " + CategoryType.ENTERTAINMENT);
                    System.out.println("4. " + CategoryType.HOUSING);
                    System.out.println("5. " + CategoryType.UTILITIES);
                    System.out.println("6. " + CategoryType.SALARY);
                    System.out.println("7. Anden kategori");

                    int categoryChoice = scanner.nextInt();
                    scanner.nextLine(); // Ryd scanner-buffer
                    Category newCategory;

                    switch (categoryChoice) {
                        case 1:
                            newCategory = new Category(CategoryType.FOOD.name());
                            break;
                        case 2:
                            newCategory = new Category(CategoryType.TRANSPORT.name());
                            break;
                        case 3:
                            newCategory = new Category(CategoryType.ENTERTAINMENT.name());
                            break;
                        case 4:
                            newCategory = new Category(CategoryType.HOUSING.name());
                            break;
                        case 5:
                            newCategory = new Category(CategoryType.UTILITIES.name());
                            break;
                        case 6:
                            newCategory = new Category(CategoryType.SALARY.name());
                            break;
                        case 7:
                            System.out.print("Indtast din egen kategori: ");
                            String customCategory = scanner.nextLine();
                            newCategory = new Category(customCategory);
                            break;
                        default:
                            System.out.println("Ugyldigt valg. Vælger 'Anden kategori'.");
                            System.out.print("Indtast din egen kategori: ");
                            String customCategoryDefault = scanner.nextLine();
                            newCategory = new Category(customCategoryDefault);
                    }

                    System.out.print("Er det indtægt? (true/false): ");
                    boolean newIsIncome = scanner.nextBoolean();
                    scanner.nextLine(); // Ryd scanner-buffer

                    // Opdater transaktionen
                    manager.updateTransaction(index, newAmount, newCategory, LocalDate.now(), newIsIncome);
                } else {
                    System.out.println("Ugyldigt indeks. Prøv igen.");
                }
            } else if (choice == 0) {
                System.out.println("Programmet afsluttes.");
                break;
            } else {
                System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }

        scanner.close();
    }
}
