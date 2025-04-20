package com.ps;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create inventory of 20 books with real titles
        Book[] books = new Book[20];
        String[] realTitles = {
                "To Kill a Mockingbird", "1984", "The Great Gatsby", "The Catcher in the Rye", "Pride and Prejudice",
                "The Hobbit", "Moby-Dick", "War and Peace", "Jane Eyre", "The Lord of the Rings",
                "Animal Farm", "Brave New World", "Wuthering Heights", "Crime and Punishment", "The Alchemist",
                "The Book Thief", "Frankenstein", "The Kite Runner", "Of Mice and Men", "The Hunger Games"
        };

        for (int i = 0; i < books.length; i++) {
            books[i] = new Book(i + 1, "ISBN" + (1000 + i), realTitles[i]);
        }

        boolean running = true;

        while (running) {
            // Main menu
            System.out.println("\n--- Neighborhood Library ---");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("\nAvailable Books:");
                for (Book book : books) {
                    if (!book.isCheckedOut()) {
                        System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
                    }
                }

                System.out.print("\nEnter the ID of the book you want to check out (0 to go back): ");
                int bookId = Integer.parseInt(scanner.nextLine());

                if (bookId != 0) {
                    boolean found = false;
                    for (Book book : books) {
                        if (book.getId() == bookId && !book.isCheckedOut()) {
                            System.out.print("Enter your name: ");
                            String name = scanner.nextLine();
                            book.checkOut(name);
                            System.out.printf("The book \"%s\" (ID %d) is checked out successfully!\n", book.getTitle(), book.getId());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Invalid book ID or the book is already checked out.");
                    }
                }

            } else if (choice.equals("2")) {
                System.out.println("\nChecked Out Books:");
                boolean anyCheckedOut = false;
                for (Book book : books) {
                    if (book.isCheckedOut()) {
                        System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn()
                                + ", Title: " + book.getTitle()
                                + ", Checked out to: " + book.getCheckedOutTo());
                        anyCheckedOut = true;
                    }
                }

                if (anyCheckedOut) {
                    System.out.print("\nEnter:\nC - to Check In a book\nX - to go back to the home screen\nYour choice: ");
                    String action = scanner.nextLine().toUpperCase();

                    if (action.equals("C")) {
                        System.out.print("Enter the ID of the book to check in: ");
                        int checkInId = Integer.parseInt(scanner.nextLine());
                        boolean found = false;

                        for (Book book : books) {
                            if (book.getId() == checkInId && book.isCheckedOut()) {
                                book.checkIn();
                                System.out.println("Book checked in successfully!");
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Invalid ID or that book is not checked out.");
                        }

                    } else if (action.equals("X")) {
                        // Go back to home screen
                        continue;
                    } else {
                        System.out.println("Invalid option. Returning to main menu.");
                    }

                } else {
                    System.out.println("No books are currently checked out.");
                }

            } else if (choice.equals("3")) {
                running = false;
                System.out.println("Goodbye! Thanks for visiting the library.");
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}

