package com.expensetracker.expensetracker;

import java.util.*;

public class ExpenseDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseDAO dao = new ExpenseDAO();

        while (true) {
            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Filter by Category");
            System.out.println("6. Filter by Date Range");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();

                    Expense exp = new Expense(title, amount, category, date);
                    dao.addExpense(exp);
                    break;

                case 2:
                    List<Expense> list = dao.getAllExpenses();
                    System.out.println("\n---- All Expenses ----");
                    for (Expense e : list) {
                        System.out.println(e.getId() + " | " + e.getTitle() + " | ₹" + e.getAmount()
                                + " | " + e.getCategory() + " | " + e.getDate());
                    }
                    break;
                case 3:
                    System.out.print("Enter Expense ID to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteExpense(deleteId);
                    break;
                case 4:
                    System.out.print("Enter Expense ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("New Amount: ");
                    double newAmount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("New Category: ");
                    String newCat = sc.nextLine();
                    System.out.print("New Date (YYYY-MM-DD): ");
                    String newDate = sc.nextLine();

                    Expense updatedExp = new Expense(newTitle, newAmount, newCat, newDate);
                    dao.updateExpense(updateId, updatedExp);
                    break;
                case 5:
                    System.out.print("Enter category: ");
                    String filterCat = sc.nextLine();
                    List<Expense> filteredByCat = dao.filterByCategory(filterCat);
                    for (Expense e : filteredByCat) {
                        System.out.println(e.getId() + " | " + e.getTitle() + " | ₹" + e.getAmount()
                                + " | " + e.getCategory() + " | " + e.getDate());
                    }
                    break;

                case 6:
                    System.out.print("From Date (YYYY-MM-DD): ");
                    String from = sc.nextLine();
                    System.out.print("To Date (YYYY-MM-DD): ");
                    String to = sc.nextLine();
                    List<Expense> filteredByDate = dao.filterByDateRange(from, to);
                    for (Expense e : filteredByDate) {
                        System.out.println(e.getId() + " | " + e.getTitle() + " | ₹" + e.getAmount()
                                + " | " + e.getCategory() + " | " + e.getDate());
                    }
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
