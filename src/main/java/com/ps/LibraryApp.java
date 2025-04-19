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

            }


        }



    }
}
