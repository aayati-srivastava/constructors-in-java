class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // 1. Default constructor → empty book
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.isbn = "0000000000";
        this.isAvailable = true;
    }

    // 2. Constructor with title and author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isbn = "0000000000";
        this.isAvailable = true;
    }

    // 3. Constructor with all details
    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    // Method: borrowBook
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("📕 '" + title + "' has been borrowed.");
        } else {
            System.out.println("❌ '" + title + "' is already borrowed!");
        }
    }

    // Method: returnBook
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("📗 '" + title + "' has been returned.");
        } else {
            System.out.println("❌ '" + title + "' was not borrowed.");
        }
    }

    // Method: displayBookInfo
    public void displayBookInfo() {
        System.out.println("📚 Book Information");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available: " + (isAvailable ? "Yes ✅" : "No ❌"));
        System.out.println("-------------------------");
    }
}

// Main class
public class LibrarySystem {
    public static void main(String[] args) {
        // Creating books with different constructors
        Book b1 = new Book();  // Default
        Book b2 = new Book("1984", "George Orwell");  // Title + Author
        Book b3 = new Book("The Hobbit", "J.R.R. Tolkien", "978-0261102217", true);  // Full details

        // Display initial info
        b1.displayBookInfo();
        b2.displayBookInfo();
        b3.displayBookInfo();

        // Borrow and return operations
        b2.borrowBook();
        b2.displayBookInfo();

        b2.borrowBook(); // should fail (already borrowed)

        b2.returnBook();
        b2.displayBookInfo();
    }
}
