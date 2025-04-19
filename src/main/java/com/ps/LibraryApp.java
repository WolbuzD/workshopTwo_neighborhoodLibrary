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
            books[i]= new Book(i + 1, "ISBN" + (1000 + i), "Book Title " + (i + 1));

           // System.out.println(books[i].getId()+" "+ books[i].getIsbn() +" "+ books[i].getTitle());
        }
    }
}
