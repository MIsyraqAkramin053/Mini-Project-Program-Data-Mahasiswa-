import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Mahasiswa> daftar = new ArrayList<>();

        int pilihan;
        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Tambah data mahasiswa");
            System.out.println("2. Lihat semua data mahasiswa");
            System.out.println("3. Edit data mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = Integer.parseInt(input.nextLine());
            System.out.println();

            switch (pilihan) {

                case 1: { // MENAMBAH MAHASISWA
                    System.out.print("Berapa mahasiswa yang mau ditambahkan? ");
                    int tambah = Integer.parseInt(input.nextLine());

                    for (int i = 0; i < tambah; i++) {
                        System.out.println("=== Input Mahasiswa ke-" + (daftar.size() + 1) + " ===");

                        Mahasiswa mhs = new Mahasiswa();

                        System.out.print("Nama  : ");
                        mhs.nama = input.nextLine();

                        System.out.print("NIM   : ");
                        mhs.nim = input.nextLine();

                        System.out.print("Nilai : ");
                        double nilai = Double.parseDouble(input.nextLine());
                        while (nilai < 0 || nilai > 100) {
                            System.out.println("Nilai harus 0 - 100!");
                            System.out.print("Nilai : ");
                            nilai = Double.parseDouble(input.nextLine());
                        }
                        mhs.nilai = nilai;

                        daftar.add(mhs);
                        System.out.println();
                    }
                    break;
                }

                case 2: { // MELIHAT MAHASISWA
                    if (daftar.isEmpty()) {
                        System.out.println("Belum ada data.");
                    } else {
                        System.out.println("===== DATA MAHASISWA (total: " + daftar.size() + ") =====");
                        for (int i = 0; i < daftar.size(); i++) {
                            System.out.println("--- Mahasiswa ke-" + (i + 1) + " ---");
                            daftar.get(i).tampilkanData();
                            daftar.get(i).cekKelulusan();
                            System.out.println();
                        }
                    }
                    break;
                }

                case 3: { // MENGEDIT MAHASISWA
                    if (daftar.isEmpty()) {
                        System.out.println("Belum ada data untuk diedit.");
                        break;
                    }

                    // Menampilkan daftar singkat supaya mudah memilih nomor mahasiswa yang mau diedit
                    System.out.println("===== DAFTAR MAHASISWA =====");
                    for (int i = 0; i < daftar.size(); i++) {
                        System.out.println((i + 1) + ". " + daftar.get(i).nama
                                + " (" + daftar.get(i).nim + ")");
                    }

                    System.out.print("Nomor mahasiswa yang mau diedit: ");
                    int nomor = Integer.parseInt(input.nextLine());

                    if (nomor < 1 || nomor > daftar.size()) {
                        System.out.println("Nomor tidak valid.");
                    } else {
                        Mahasiswa mhs = daftar.get(nomor - 1);

                        System.out.println("Data saat ini:");
                        mhs.tampilkanData();
                        System.out.println("(Kosongkan lalu tekan Enter jika tidak ingin mengubah)");

                        System.out.print("Nama baru  : ");
                        String namaBaru = input.nextLine();
                        if (!namaBaru.isEmpty()) {
                            mhs.nama = namaBaru;
                        }

                        System.out.print("NIM baru   : ");
                        String nimBaru = input.nextLine();
                        if (!nimBaru.isEmpty()) {
                            mhs.nim = nimBaru;
                        }

                        System.out.print("Nilai baru : ");
                        String nilaiBaru = input.nextLine();
                        if (!nilaiBaru.isEmpty()) {
                            double nilai = Double.parseDouble(nilaiBaru);
                            while (nilai < 0 || nilai > 100) {
                                System.out.println("Nilai harus 0 - 100!");
                                System.out.print("Nilai baru : ");
                                nilai = Double.parseDouble(input.nextLine());
                            }
                            mhs.nilai = nilai;
                        }

                        System.out.println();
                        System.out.println("Data berhasil diperbarui:");
                        mhs.tampilkanData();
                        mhs.cekKelulusan();
                    }
                    break;
                }

                case 0:
                    System.out.println("Selesai. Total mahasiswa: " + daftar.size());
                    break;

                default:
                    System.out.println("Pilihan salah!");
            }
            System.out.println();

        } while (pilihan != 0);

        input.close();
    }
}
