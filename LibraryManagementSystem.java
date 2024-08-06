
import java.util.*;

// Book class represents a book entity
class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", available=" + available +
                '}';
    }
}

// Library class manages the collection of books
class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display all books in the library
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Find a book by its ID
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Borrow a book
    public void borrowBook(int id) {
        Book book = findBookById(id);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("You have successfully borrowed the book: " + book.getTitle());
        } else if (book != null && !book.isAvailable()) {
            System.out.println("Sorry, the book is not available for borrowing.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // Return a book
    public void returnBook(int id) {
        Book book = findBookById(id);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("You have successfully returned the book: " + book.getTitle());
        } else if (book != null && book.isAvailable()) {
            System.out.println("This book is already available in the library.");
        } else {
            System.out.println("Book not found.");
        }
    }
}

// Main class to run the library management system
public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library();

        // Adding some initial books to the library
        library.addBook(new Book(1, "Java Programming", "John Doe"));
        library.addBook(new Book(2, "Python Programming", "Jane Smith"));
        library.addBook(new Book(3, "Data Structures and Algorithms", "Alice Johnson"));

        // Display all books in the library
        System.out.println("Library books:");
        library.displayBooks();

        // Borrowing a book
        System.out.println("\nBorrowing a book:");
        library.borrowBook(2); // Borrow Python Programming

        // Display all books after borrowing
        System.out.println("\nLibrary books after borrowing:");
        library.displayBooks();

        // Returning a book
        System.out.println("\nReturning a book:");
        library.returnBook(2); // Return Python Programming

        // Display all books after returning
        System.out.println("\nLibrary books after returning:");
        library.displayBooks();
    }
}