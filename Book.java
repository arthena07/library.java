public class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean available;
    
    // Constructor
    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true; // Default: buku tersedia saat dibuat
    }
    
    // Getter methods
    public String getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getYear() {
        return year;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    // Setter methods
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    // Method untuk meminjam buku
    public boolean borrowBook() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }
    
    // Method untuk mengembalikan buku
    public boolean returnBook() {
        if (!available) {
            available = true;
            return true;
        }
        return false;
    }
    
    // Method untuk menampilkan informasi buku
    public void displayInfo() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Status: " + (available ? "Available" : "Borrowed"));
        System.out.println("------------------------");
    }
    
    @Override
    public String toString() {
        return "Book[ISBN=" + isbn + ", Title=" + title + ", Author=" + author + 
               ", Year=" + year + ", Available=" + available + "]";
    }
}