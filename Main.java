import java.util.Scanner;

public class Main {
    private static Library library;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        // Inisialisasi perpustakaan
        library = new Library("Kota Library", "Jl. Literasi No. 123, Jakarta");
        scanner = new Scanner(System.in);
        
        // Tambahkan beberapa buku contoh
        library.addBook(new Book("978-3-16-148410-0", "Java Programming", "John Doe", 2020));
        library.addBook(new Book("978-1-23-456789-7", "Data Structures", "Jane Smith", 2019));
        library.addBook(new Book("978-0-12-345678-9", "Algorithm Design", "Bob Johnson", 2021));
        
        // Tambahkan beberapa anggota contoh
        library.addMember(new Member("M001", "Alice", "Jl. Merah No. 1", "08123456789"));
        library.addMember(new Member("M002", "Bob", "Jl. Biru No. 2", "08234567890"));
        
        // Menu utama
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                try {
                    scanner.nextLine(); // Clear the invalid input
                } catch (Exception ex) {
                    // No more input available
                    choice = 0; // Exit the program
                }
                choice = -1; // Set to invalid choice
                continue;
            }
            
            switch (choice) {
                case 1:
                    displayAllBooks();
                    break;
                case 2:
                    displayAllMembers();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    addNewBook();
                    break;
                case 7:
                    addNewMember();
                    break;
                case 8:
                    library.displayInfo();
                    break;
                case 0:
                    System.out.println("Thank you for using Library System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
        System.out.println("1. Display All Books");
        System.out.println("2. Display All Members");
        System.out.println("3. Search Book");
        System.out.println("4. Borrow Book");
        System.out.println("5. Return Book");
        System.out.println("6. Add New Book");
        System.out.println("7. Add New Member");
        System.out.println("8. Display Library Information");
        System.out.println("0. Exit");
        System.out.println("================================");
    }
    
    private static void displayAllBooks() {
        library.displayAllBooks();
    }
    
    private static void displayAllMembers() {
        library.displayAllMembers();
    }
    
    private static void searchBook() {
        System.out.print("Enter book title keyword: ");
        String keyword = scanner.nextLine();
        
        var results = library.findBookByTitle(keyword);
        if (results.isEmpty()) {
            System.out.println("No books found with keyword: " + keyword);
        } else {
            System.out.println("Found " + results.size() + " book(s):");
            for (Book book : results) {
                book.displayInfo();
            }
        }
    }
    
    private static void borrowBook() {
        System.out.print("Enter book ISBN: ");
        String bookId = scanner.nextLine();
        
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        
        library.borrowBook(bookId, memberId);
    }
    
    private static void returnBook() {
        System.out.print("Enter book ISBN: ");
        String bookId = scanner.nextLine();
        
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        
        library.returnBook(bookId, memberId);
    }
    
    private static void addNewBook() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        
        int year;
        while (true) {
            System.out.print("Enter year: ");
            try {
                year = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid year.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        
        library.addBook(new Book(isbn, title, author, year));
    }
    
    private static void addNewMember() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        
        library.addMember(new Member(memberId, name, address, phone));
    }
}