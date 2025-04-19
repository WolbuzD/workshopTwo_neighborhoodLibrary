package com.ps;

import java.lang.reflect.Array;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       //Let's create an Array to hold the inventory of 20 books
        Book[] books = new Book[20];

        //Now we need to fill in sample books using a Loop:
        for(int i=0; i<20; i++){
            books[i]= new Book(i + 1, "ISBN" + (1000 + i), "Book Title" + (i + 1));

           // System.out.println(books[i].getId()+" "+ books[i].getIsbn() +" "+ books[i].getTitle());
        }

       // Keep the program running until the user chooses to exit
        boolean running = true;

        while(running){
            // Show main menu
            System.out.println("\n--- Neighborhood Library ---");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            String choice = scanner.nextLine();

            if(choice.equals("1")){
                //show available books(meaning the books that are not checked out)
                for(int i =0; i< books.length; i++){
                    if(!books[i].isCheckedOut()){
                        System.out.println("ID: " + books[i].getId()+"ISBN: " + books[i].getIsbn() + ", Title: " + books[i].getTitle());
                    }
                }

                // Ask user if they want to check out a book
                System.out.print("\nEnter the ID of the book you want to check out (0 to go back): ");
                int bookId = Integer.parseInt(scanner.nextLine());

                if(bookId !=0){
                    for (int i = 0; i < books.length; i++) {
                        if (books[i].getId() == bookId && !books[i].isCheckedOut()) {
                            System.out.print("Enter your name: ");
                            String name = scanner.nextLine();
                            books[i].checkOut(name);
                            System.out.printf("The Book %s with the ID %d is checked out successfully!",books[i].getTitle(), books[i].getId());
                        }
                    }
                }

            } else if (choice.equals("2")) {
                // Show books that are checked out
                System.out.println("\nChecked Out Books:");
                boolean anyCheckedOut = false;

                for (int i = 0; i < books.length; i++) {
                    if (books[i].isCheckedOut()) {
                        System.out.println("ID: " + books[i].getId() + ", Title: " + books[i].getTitle() + ", Checked out to: " + books[i].getCheckedOutTo());
                        anyCheckedOut = true;
                    }
                }

                if (anyCheckedOut) {
                    // Ask if user wants to check in a book
                    System.out.print("\nEnter the ID of the book to check in (0 to go back): ");
                    int checkInId = Integer.parseInt(scanner.nextLine());

                    if (checkInId != 0) {
                        boolean found = false;
                        for (int i = 0; i < books.length; i++) {
                            if (books[i].getId() == checkInId && books[i].isCheckedOut()) {
                                books[i].checkIn();
                                System.out.println("Book checked in successfully!");
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Invalid ID or that book is not checked out.");
                        }
                    }
                } else {
                    System.out.println("No books are currently checked out.");
                }

            }
            else if (choice.equals("3")) {
                // Exit the program
                running = false;
                System.out.println("Goodbye!");
            }
            else {
                System.out.println("Invalid option. Try again.");
            }


        }

     scanner.close();

    }
}
