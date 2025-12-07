import java.util.ArrayList;

public class Library {
    private String name;
    private String address;
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    
    // Constructor
    public Library(String name, String address) {
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    // Method untuk menambah buku
    public void addBook(Book b) {
        books.add(b);
        System.out.println("Book added: " + b.getTitle());
    }
    
    // Method untuk menambah anggota
    public void addMember(Member m) {
        members.add(m);
        System.out.println("Member added: " + m.getName());
    }
    
    // Method untuk menampilkan semua buku
    public void displayAllBooks() {
        System.out.println("=== All Books in " + name + " ===");
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book b : books) {
                b.displayInfo();
            }
        }
    }
    
    // Method untuk menampilkan semua anggota
    public void displayAllMembers() {
        System.out.println("=== All Members of " + name + " ===");
        if (members.isEmpty()) {
            System.out.println("No members registered.");
        } else {
            for (Member m : members) {
                m.displayInfo();
            }
        }
    }
    
    // Method untuk mencari buku berdasarkan ISBN
    public Book findBookById(String id) {
        for (Book b : books) {
            if (b.getIsbn().equals(id)) {
                return b;
            }
        }
        return null;
    }
    
    // Method untuk mencari buku berdasarkan judul
    public ArrayList<Book> findBookByTitle(String keyword) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }
    
    // Method untuk mencari anggota berdasarkan ID
    public Member findMemberById(String id) {
        for (Member m : members) {
            if (m.getMemberId().equals(id)) {
                return m;
            }
        }
        return null;
    }
    
    // Method untuk meminjam buku
    public boolean borrowBook(String bookId, String memberId) {
        Book b = findBookById(bookId);
        Member m = findMemberById(memberId);
        
        if (b == null) {
            System.out.println("Book not found!");
            return false;
        }
        
        if (m == null) {
            System.out.println("Member not found!");
            return false;
        }
        
        if (!b.isAvailable()) {
            System.out.println("Book is already borrowed!");
            return false;
        }
        
        if (!m.canBorrow()) {
            System.out.println("Member has reached maximum borrow limit!");
            return false;
        }
        
        if (b.borrowBook() && m.incrementBorrowedCount()) {
            System.out.println("Book \"" + b.getTitle() + "\" successfully borrowed by " + m.getName());
            return true;
        }
        
        return false;
    }
    
    // Method untuk mengembalikan buku
    public boolean returnBook(String bookId, String memberId) {
        Book b = findBookById(bookId);
        Member m = findMemberById(memberId);
        
        if (b == null) {
            System.out.println("Book not found!");
            return false;
        }
        
        if (m == null) {
            System.out.println("Member not found!");
            return false;
        }
        
        if (b.isAvailable()) {
            System.out.println("Book is already available!");
            return false;
        }
        
        if (b.returnBook() && m.decrementBorrowedCount()) {
            System.out.println("Book \"" + b.getTitle() + "\" successfully returned by " + m.getName());
            return true;
        }
        
        return false;
    }
    
    // Method untuk menampilkan informasi perpustakaan
    public void displayInfo() {
        System.out.println("=== Library Information ===");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Total Books: " + books.size());
        System.out.println("Total Members: " + members.size());
        System.out.println("============================");
    }
}