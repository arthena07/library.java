public class Member {
    private String memberId;
    private String name;
    private String address;
    private String phone;
    private int maxBorrowLimit;
    private int currentBorrowedCount;
    
    // Constructor
    public Member(String memberId, String name, String address, String phone) {
        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.maxBorrowLimit = 3; // Default: maksimal 3 buku
        this.currentBorrowedCount = 0;
    }
    
    // Getter methods
    public String getMemberId() {
        return memberId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public int getMaxBorrowLimit() {
        return maxBorrowLimit;
    }
    
    public int getCurrentBorrowedCount() {
        return currentBorrowedCount;
    }
    
    // Setter methods
    public void setMaxBorrowLimit(int maxBorrowLimit) {
        this.maxBorrowLimit = maxBorrowLimit;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    // Method untuk memeriksa apakah anggota bisa meminjam buku lagi
    public boolean canBorrow() {
        return currentBorrowedCount < maxBorrowLimit;
    }
    
    // Method untuk menambah jumlah buku yang dipinjam
    public boolean incrementBorrowedCount() {
        if (canBorrow()) {
            currentBorrowedCount++;
            return true;
        }
        return false;
    }
    
    // Method untuk mengurangi jumlah buku yang dipinjam
    public boolean decrementBorrowedCount() {
        if (currentBorrowedCount > 0) {
            currentBorrowedCount--;
            return true;
        }
        return false;
    }
    
    // Method untuk menampilkan informasi anggota
    public void displayInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Borrowed Books: " + currentBorrowedCount + "/" + maxBorrowLimit);
        System.out.println("------------------------");
    }
    
    @Override
    public String toString() {
        return "Member[ID=" + memberId + ", Name=" + name + ", Address=" + address + 
               ", Phone=" + phone + ", Borrowed=" + currentBorrowedCount + "/" + maxBorrowLimit + "]";
    }
}