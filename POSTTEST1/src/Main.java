import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();
    static ArrayList<AbsensiKaryawan> dataAbsensi = new ArrayList<>();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int pilihan;

        do {
            System.out.println("\nSISTEM MANAJEMEN ABSENSI KARYAWAN");
            System.out.println("1. Tambah Data Karyawan");
            System.out.println("2. Tampilkan Data Karyawan");
            System.out.println("3. Tambah Data Absensi");
            System.out.println("4. Tampilkan Data Absensi");
            System.out.println("5. Exit");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    tambahKaryawan();
                    break;
                case 2:
                    tampilKaryawan();
                    break;
                case 3:
                    tambahAbsensi();
                    break;
                case 4:
                    tampilAbsensi();
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia");
            }
        } while (pilihan != 5);
    }

    static void tambahKaryawan() {

        System.out.print("ID Karyawan: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Nama Karyawan: ");
        String nama = input.nextLine();

        System.out.print("Jabatan: ");
        String jabatan = input.nextLine();

        Karyawan karyawan = new Karyawan(id, nama, jabatan);
        daftarKaryawan.add(karyawan);

        System.out.println("Data karyawan berhasil ditambahkan.");
    }

    static void tampilKaryawan() {

        if (daftarKaryawan.isEmpty()) {
            System.out.println("Data karyawan kosong.");
            return;
        }

        for (Karyawan k : daftarKaryawan) {
            System.out.println("ID: " + k.getId());
            System.out.println("Nama: " + k.getNama());
            System.out.println("Jabatan: " + k.getJabatan());
            System.out.println("--------------------");
        }
    }

    static void tambahAbsensi() {

        System.out.print("Masukkan ID Karyawan: ");
        int id = input.nextInt();
        input.nextLine();

        for (Karyawan k : daftarKaryawan) {
            if (k.getId() == id) {
                System.out.print("Tanggal: ");
                String tanggal = input.nextLine();

                System.out.print("Status (Hadir/Izin/Sakit): ");
                String status = input.nextLine();

                AbsensiKaryawan absensi = new AbsensiKaryawan(k, tanggal, status);
                dataAbsensi.add(absensi);

                System.out.println("Absensi berhasil ditambahkan.");
                return;
            }
        }
        System.out.println("ID karyawan tidak ditemukan.");
    }

    static void tampilAbsensi() {

        if (dataAbsensi.isEmpty()) {
            System.out.println("Data absensi kosong.");
            return;
        }

        for (AbsensiKaryawan a : dataAbsensi) {

            System.out.println("ID Karyawan: " + a.getKaryawan().getId());
            System.out.println("Nama: " + a.getKaryawan().getNama());
            System.out.println("Tanggal: " + a.getTanggal());
            System.out.println("Status: " + a.getStatus());
            System.out.println("--------------------");
        }
    }
}