# Summary Sistem Manajemen Perpustakaan

## Deskripsi Umum
Proyek ini merupakan implementasi Sistem Manajemen Perpustakaan sederhana menggunakan bahasa pemrograman Java. Sistem ini dirancang untuk mengelola operasi dasar perpustakaan seperti peminjaman buku, pengembalian buku, manajemen anggota, dan katalog buku.

## Struktur Kelas

### 1. Kelas Book
**File:** [`Book.java`](Book.java:1)

**Atribut:**
- `isbn`: String - Nomor ISBN buku
- `title`: String - Judul buku
- `author`: String - Penulis buku
- `year`: int - Tahun terbit
- `available`: boolean - Status ketersediaan buku

**Metode Utama:**
- [`borrowBook()`](Book.java:44): Meminjam buku jika tersedia
- [`returnBook()`](Book.java:53): Mengembalikan buku
- [`displayInfo()`](Book.java:62): Menampilkan informasi lengkap buku
- Getter dan setter untuk semua atribut

### 2. Kelas Member
**File:** [`Member.java`](Member.java:1)

**Atribut:**
- `memberId`: String - ID unik anggota
- `name`: String - Nama anggota
- `address`: String - Alamat anggota
- `phone`: String - Nomor telepon
- `maxBorrowLimit`: int - Batas maksimum peminjaman (default: 3)
- `currentBorrowedCount`: int - Jumlah buku yang sedang dipinjam

**Metode Utama:**
- [`canBorrow()`](Member.java:58): Memeriksa apakah anggota masih bisa meminjam
- [`incrementBorrowedCount()`](Member.java:63): Menambah jumlah buku yang dipinjam
- [`decrementBorrowedCount()`](Member.java:72): Mengurangi jumlah buku yang dipinjam
- [`displayInfo()`](Member.java:81): Menampilkan informasi lengkap anggota

### 3. Kelas Library
**File:** [`Library.java`](Library.java:1)

**Atribut:**
- `name`: String - Nama perpustakaan
- `address`: String - Alamat perpustakaan
- `books`: ArrayList<Book> - Koleksi buku
- `members`: ArrayList<Member> - Data anggota

**Metode Utama:**
- [`addBook(Book b)`](Library.java:27): Menambah buku baru ke koleksi
- [`addMember(Member m)`](Library.java:33): Mendaftarkan anggota baru
- [`findBookById(String id)`](Library.java:63): Mencari buku berdasarkan ISBN
- [`findBookByTitle(String keyword)`](Library.java:73): Mencari buku berdasarkan judul
- [`findMemberById(String id)`](Library.java:84): Mencari anggota berdasarkan ID
- [`borrowBook(String bookId, String memberId)`](Library.java:94): Memproses peminjaman buku
- [`returnBook(String bookId, String memberId)`](Library.java:127): Memproses pengembalian buku
- [`displayAllBooks()`](Library.java:39): Menampilkan semua buku
- [`displayAllMembers()`](Library.java:51): Menampilkan semua anggota

### 4. Kelas Main
**File:** [`Main.java`](Main.java:1)

**Fungsi:**
- Menyediakan antarmuka pengguna berbasis menu konsol
- Mengimplementasikan logika untuk semua fitur sistem:
  1. Menampilkan semua buku
  2. Menampilkan semua anggota
  3. Mencari buku
  4. Meminjam buku
  5. Mengembalikan buku
  6. Menambah buku baru
  7. Menambah anggota baru
  8. Menampilkan informasi perpustakaan

### 5. Kelas TestProgram
**File:** [`TestProgram.java`](TestProgram.java:1)

**Fungsi:**
- Menyediakan pengujian otomatis untuk semua fitur utama sistem
- Menguji fungsionalitas:
  - Pembuatan objek Book dan Member
  - Operasi perpustakaan dasar
  - Validasi peminjaman dan pengembalian
  - Pencarian buku
  - Batas peminjaman anggota

## Fitur Utama Sistem

1. **Manajemen Buku**
   - Penambahan buku baru dengan ISBN, judul, penulis, dan tahun terbit
   - Pelacakan status ketersediaan buku
   - Pencarian buku berdasarkan ISBN atau judul

2. **Manajemen Anggota**
   - Pendaftaran anggota baru dengan data lengkap
   - Batas maksimum peminjaman (3 buku per anggota)
   - Pelacakan jumlah buku yang sedang dipinjam

3. **Operasi Peminjaman**
   - Validasi ketersediaan buku
   - Validasi batas peminjaman anggota
   - Pembaruan status buku dan jumlah peminjaman anggota

4. **Operasi Pengembalian**
   - Validasi status buku yang dipinjam
   - Pembaruan status ketersediaan buku
   - Pengurangan jumlah peminjaman anggota

5. **Antarmuka Pengguna**
   - Menu interaktif berbasis konsol
   - Input validation untuk mencegah error
   - Pesan feedback untuk setiap operasi

## Alur Program

1. **Inisialisasi**
   - Membuat objek Library dengan nama dan alamat
   - Menambahkan data contoh (buku dan anggota)

2. **Menu Utama**
   - Menampilkan pilihan fitur
   - Menerima input pengguna
   - Memproses pilihan dengan validasi

3. **Operasi Berdasarkan Pilihan**
   - Setiap fitur memiliki method tersendiri
   - Method memanggil fungsi dari kelas Library
   - Menampilkan hasil atau pesan error

## Validasi dan Error Handling

1. **Input Validation**
   - Pemeriksaan input numerik untuk menu dan tahun
   - Penanganan input tidak valid dengan pesan error

2. **Business Logic Validation**
   - Pemeriksaan ketersediaan buku sebelum peminjaman
   - Pemeriksaan batas peminjaman anggota
   - Validasi keberadaan buku dan anggota

## Konsep Pemrograman yang Diterapkan

1. **Object-Oriented Programming (OOP)**
   - Enkapsulasi: atribut private dengan method public
   - Abstraksi: method yang menyembunyikan implementasi detail
   - Konstruktor untuk inisialisasi objek

2. **Struktur Data**
   - Penggunaan ArrayList untuk menyimpan koleksi objek
   - Implementasi searching dan sorting dasar

3. **Control Flow**
   - Switch-case untuk menu selection
   - Loop untuk menu berulang
   - Conditional statements untuk validasi

4. **Input/Output**
   - Scanner untuk input pengguna
   - System.out untuk output ke konsol

## Potensi Pengembangan

1. **Fitur Tambahan**
   - Sistem denda untuk keterlambatan pengembalian
   - Reservasi buku
   - Kategori buku
   - Laporan statistik

2. **Penyimpanan Data**
   - Database integration
   - File I/O untuk persistensi data

3. **User Interface**
   - GUI menggunakan JavaFX atau Swing
   - Web interface

4. **Multi-user**
   - Sistem login dengan role-based access
   - Admin dan user interfaces

## Kesimpulan

Sistem Manajemen Perpustakaan ini merupakan implementasi yang baik dari konsep-konsep dasar pemrograman Java dan OOP. Sistem ini menyediakan semua fungsi dasar yang diperlukan untuk mengelola perpustakaan kecil dengan antarmuka yang user-friendly dan validasi yang memadai. Struktur kode yang terorganisir dengan baik memudahkan untuk pengembangan lebih lanjut.