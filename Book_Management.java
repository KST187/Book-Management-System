import java.util.*;

// The Book class represents a book with a unique ID and a name.
class Book {
    private int bookId;
    private String bookName;

    // Constructor to initialize the book with an ID and name.
    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    // Getter for bookId
    public int getBookId() {
        return bookId;
    }

    // Setter for bookId
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    // Getter for bookName
    public String getBookName() {
        return bookName;
    }

    // Setter for bookName
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    // Override toString to provide a custom string representation of a Book object.
    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Name: " + bookName;
    }
}

// The BookManager class handles operations related to books.
class BookManager {
    private List<Book> books;

    // Constructor initializes the list of books.
    public BookManager() {
        books = new ArrayList<>();
    }

    // Adds a new book to the list.
    public void addBook(int bookId, String bookName) {
        if (isBookIdExists(bookId)) {
            System.out.println("Book with ID " + bookId + " already exists.");
        } else {
            Book book = new Book(bookId, bookName);
            books.add(book);
            System.out.println("Book added successfully.");
        }
    }

    // Retrieves a book by its ID.
    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Updates the name of a book.
    public void updateBook(int bookId, String newBookName) {
        Book book = getBookById(bookId);
        if (book != null) {
            book.setBookName(newBookName);
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // Deletes a book by its ID.
    public void deleteBook(int bookId) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getBookId() == bookId) {
                iterator.remove();
                System.out.println("Book deleted successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Displays all books in the list.
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Checks if a book with the given ID already exists.
    public boolean isBookIdExists(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return true;
            }
        }
        return false;
    }
}

// The Main class contains the main method where the program starts execution.
public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        Scanner scanner = new Scanner(System.in);

        try {
            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Add Book");
                System.out.println("2. Retrieve Book by ID");
                System.out.println("3. Update Book");
                System.out.println("4. Delete Book");
                System.out.println("5. Display All Books");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        int bookId = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter Book Name: ");
                        String bookName = scanner.nextLine();
                        manager.addBook(bookId, bookName);
                        break;
                    case 2:
                        System.out.print("Enter Book ID to retrieve: ");
                        int retrieveId = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        Book retrievedBook = manager.getBookById(retrieveId);
                        if (retrievedBook != null) {
                            System.out.println(retrievedBook);
                        } else {
                            System.out.println("Book not found.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter Book ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter new Book Name: ");
                        String newBookName = scanner.nextLine();
                        manager.updateBook(updateId, newBookName);
                        break;
                    case 4:
                        System.out.print("Enter Book ID to delete: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        manager.deleteBook(deleteId);
                        break;
                    case 5:
                        manager.displayAllBooks();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
