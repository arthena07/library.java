public class TestProgram {
    public static void main(String[] args) {
        System.out.println("=== TESTING LIBRARY SYSTEM ===");
        
        // Test 1: Membuat objek Book
        System.out.println("\n1. Testing Book class:");
        Book book1 = new Book("978-3-16-148410-0", "Java Programming", "John Doe", 2020);
        Book book2 = new Book("978-1-23-456789-7", "Data Structures", "Jane Smith", 2019);
        
        book1.displayInfo();
        book2.displayInfo();
        
        // Test 2: Membuat objek Member
        System.out.println("\n2. Testing Member class:");
        Member member1 = new Member("M001", "Alice", "Jl. Merah No. 1", "08123456789");
        Member member2 = new Member("M002", "Bob", "Jl. Biru No. 2", "08234567890");
        
        member1.displayInfo();
        member2.displayInfo();
        
        // Test 3: Membuat objek Library
        System.out.println("\n3. Testing Library class:");
        Library library = new Library("Test Library", "Test Address");
        
        // Menambah buku dan anggota
        library.addBook(book1);
        library.addBook(book2);
        library.addMember(member1);
        library.addMember(member2);
        
        // Menampilkan semua buku dan anggota
        library.displayAllBooks();
        library.displayAllMembers();
        
        // Test 4: Meminjam buku
        System.out.println("\n4. Testing borrow functionality:");
        boolean borrowResult1 = library.borrowBook("978-3-16-148410-0", "M001");
        System.out.println("Borrow result: " + (borrowResult1 ? "Success" : "Failed"));
        
        // Coba pinjam buku yang sama lagi
        boolean borrowResult2 = library.borrowBook("978-3-16-148410-0", "M002");
        System.out.println("Borrow same book again: " + (borrowResult2 ? "Success" : "Failed"));
        
        // Test 5: Mengembalikan buku
        System.out.println("\n5. Testing return functionality:");
        boolean returnResult = library.returnBook("978-3-16-148410-0", "M001");
        System.out.println("Return result: " + (returnResult ? "Success" : "Failed"));
        
        // Coba kembalikan buku yang sudah dikembalikan
        boolean returnResult2 = library.returnBook("978-3-16-148410-0", "M001");
        System.out.println("Return same book again: " + (returnResult2 ? "Success" : "Failed"));
        
        // Test 6: Mencari buku
        System.out.println("\n6. Testing search functionality:");
        var searchResults = library.findBookByTitle("Java");
        System.out.println("Found " + searchResults.size() + " book(s) with keyword 'Java':");
        for (Book book : searchResults) {
            System.out.println("- " + book.getTitle());
        }
        
        // Test 7: Batas peminjaman anggota
        System.out.println("\n7. Testing member borrow limit:");
        System.out.println("Member " + member1.getName() + " can borrow: " + member1.canBorrow());
        
        // Pinjam beberapa buku untuk mencapai batas
        library.borrowBook("978-3-16-148410-0", "M001");
        library.borrowBook("978-1-23-456789-7", "M001");
        
        System.out.println("After borrowing 2 books:");
        System.out.println("Current borrowed count: " + member1.getCurrentBorrowedCount());
        System.out.println("Can borrow more: " + member1.canBorrow());
        
        // Tambah buku ketiga
        Book book3 = new Book("978-0-12-345678-9", "Algorithm Design", "Bob Johnson", 2021);
        library.addBook(book3);
        library.borrowBook("978-0-12-345678-9", "M001");
        
        System.out.println("After borrowing 3 books:");
        System.out.println("Current borrowed count: " + member1.getCurrentBorrowedCount());
        System.out.println("Can borrow more: " + member1.canBorrow());
        
        // Coba pinjam buku keempat (seharusnya gagal)
        Book book4 = new Book("978-1-11-111111-1", "Advanced Java", "Alice Smith", 2022);
        library.addBook(book4);
        boolean borrowResult4 = library.borrowBook("978-1-11-111111-1", "M001");
        System.out.println("Attempt to borrow 4th book: " + (borrowResult4 ? "Success" : "Failed"));
        
        System.out.println("\n=== ALL TESTS COMPLETED ===");
    }
}
