public class ArdhaWicaksonoRiawan_25161562027_Stack {

    // === BAGIAN 1: Deklarasi Stack ===
    static String[] stack = new String[10];
    static int top = -1;

    // === BAGIAN 2: Operasi Stack ===

    // Method push()
    static void push(String tiket) {

        // Cek apakah stack penuh
        if (top == stack.length - 1) {
            System.out.println("Stack penuh!");
        } else {

            // Tambahkan data ke stack
            top++;
            stack[top] = tiket;
        }
    }

    // Method pop()
    static String pop() {

        // Cek apakah stack kosong
        if (isEmpty()) {
            return "Stack kosong!";
        } else {

            // Ambil data paling atas
            String data = stack[top];

            // Kurangi posisi top
            top--;

            // Kembalikan data
            return data;
        }
    }

    // Method peek()
    static String peek() {

        // Cek apakah stack kosong
        if (isEmpty()) {
            return "Stack kosong";
        } else {

            // Mengembalikan data paling atas tanpa menghapus
            return stack[top];
        }
    }

    // Method mengecek stack kosong
    static boolean isEmpty() {
        return top == -1;
    }

    // Method menampilkan isi stack
    static void tampilkanStack() {

        System.out.println("=== Isi Stack (TOP -> BOTTOM) ===");

        // Menampilkan isi stack dari atas ke bawah
        for (int i = top; i >= 0; i--) {
            System.out.println("| " + stack[i] + " |");
        }

        System.out.println("=================================");
    }

    // BONUS: Method hitungTotal()
    static void hitungTotal() {

        int total = 0;

        // Menelusuri seluruh isi stack
        for (int i = 0; i <= top; i++) {

            String tiket = stack[i];

            // Cari posisi "Rp"
            int posisiRp = tiket.indexOf("Rp");

            // Ambil nominal harga setelah "Rp"
            String hargaStr = tiket.substring(posisiRp + 2);

            // Hapus tanda titik
            hargaStr = hargaStr.replace(".", "");

            // Ubah string menjadi integer
            int harga = Integer.parseInt(hargaStr);

            // Tambahkan ke total
            total += harga;
        }

        // Format angka ribuan
        String totalFormat = String.format("%,d", total).replace(",", ".");

        // Tampilkan total transaksi
        System.out.println("Total transaksi: Rp" + totalFormat);
    }

    // === BAGIAN 3: Main Program ===
    public static void main(String[] args) {

        // Push 3 transaksi tiket ke stack
        push("Tiket-A01: Avengers Rp50.000");
        push("Tiket-B02: Interstellar Rp45.000");
        push("Tiket-C03: Inception Rp45.000");

        // Bonus: hitung total transaksi
        hitungTotal();

        // Tampilkan isi stack
        tampilkanStack();

        // Tampilkan tiket paling atas
        System.out.println("Tiket terakhir masuk: " + peek());

        // Batalkan tiket paling atas
        System.out.println("Tiket dibatalkan: " + pop());

        // Tampilkan isi stack setelah pop
        tampilkanStack();
    }
}