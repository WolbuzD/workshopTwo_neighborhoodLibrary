# 📚 Neighborhood Library Console App

This is a simple Java console application that simulates a neighborhood library system. Users can view available books, check out a book, or return a checked-out book.

---

## 💡 Features

- View a list of 20 sample books with unique IDs and ISBNs.
- Check out a book by entering its ID and your name.
- View all books that are currently checked out.
- Return a checked-out book by entering its ID.
- Easy-to-use text-based menu system.

---

## 🛠️ Technologies Used

- Java (JDK 8+)
- Object-Oriented Programming (OOP)
- Arrays
- Console input with `Scanner`

---

## 🧾 How It Works

### Main Menu Options:

**1. Show Available Books**  
Lists all books that have not been checked out yet.  
Prompts the user to check out a book by entering its ID and name.

**2. Show Checked Out Books**  
Lists all books that have been checked out, along with the user name.  
Prompts the user to return a book by entering its ID.

**3. Exit**  
Closes the application.

---

## ▶️ Running the Application

1. Compile the Java files:

```bash
javac LibraryApp.java Book.java

