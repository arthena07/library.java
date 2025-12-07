public class Main {
    public static void main(String[] args) {

        Library lib = new Library();
        lib.addBook(new Book("111", "Java Basics", "John Doe", 2020));
        lib.addBook(new Book("222", "OOP Principles", "Alice", 2021));

        lib.addMember(new Member("M01", "Hana"));
        lib.addMember(new Member("M02", "Dipa"));

        lib.showBooks();
        lib.showMembers();

        System.out.println("\nBorrowing Book 111 by member M01...");
        lib.borrowBook("111", "M01");

        lib.showBooks();

        System.out.println("\nReturning Book 111...");
        lib.returnBook("111");

        lib.showBooks();
    }
}
