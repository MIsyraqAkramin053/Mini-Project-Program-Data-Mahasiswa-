public class Mahasiswa {

    // Atribut yang akan dimiliki oleh setiap mahasiswa
    String nama;
    String nim;
    double nilai;

    // Atribut apa saja yang akan ditampilkan pada data mahasiswa
    void tampilkanData() {
        System.out.println("Nama  : " + nama);
        System.out.println("NIM   : " + nim);
        System.out.println("Nilai : " + nilai);
    }

    // Mengecek dan menampilkan status kelulusan, dengan syarat (lulus jika nilai >= 75)
    void cekKelulusan() {
        if (nilai >= 75) {
            System.out.println("Status: Lulus");
        } else {
            System.out.println("Status: Tidak Lulus");
        }
    }
}
