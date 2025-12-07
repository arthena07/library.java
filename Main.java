import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Library library = new Library();

        // DAFTAR BUKU
        library.addBook(new Book("001", "Pemrograman Java", "Andi", 2019));
        library.addBook(new Book("002", "Struktur Data", "Budi", 2020));
        library.addBook(new Book("003", "Basis Data", "Cici", 2021));

        // DAFTAR MEMBER
        library.addMember(new Member("M01", "Hana"));
        library.addMember(new Member("M02", "Naura"));

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Lihat daftar buku");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Kembalikan buku");
            System.out.println("4. Lihat daftar member");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = input.nextInt();
            input.nextLine(); // CLEAR BUFFER

            switch (pilihan) {
                case 1:
                    library.showBooks();
                    break;

                case 2:
                    System.out.print("Masukkan ID buku: ");
                    String bookId = input.nextLine();
                    System.out.print("Masukkan ID member: ");
                    String memberId = input.nextLine();
                    library.borrowBook(bookId, memberId);
                    break;

                case 3:
                    System.out.print("Masukkan ID buku: ");
                    String returnId = input.nextLine();
                    library.returnBook(returnId);
                    break;

                case 4:
                    library.showMembers();
                    break;

                case 5:
                    System.out.println("Program selesai!");
                    return;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
