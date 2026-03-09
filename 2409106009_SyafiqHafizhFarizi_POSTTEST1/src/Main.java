import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<AbsensiKaryawan> dataAbsensi = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int pilihan;

        do {
            System.out.println("\nSISTEM MANAJEMEN ABSENSI KARYAWAN");
            System.out.println("1. Tambah Data Absensi");
            System.out.println("2. Tampilkan Data Absensi");
            System.out.println("3. Update Data Absensi");
            System.out.println("4. Hapus Data Absensi");
            System.out.println("5. Exit");
            System.out.print("Pilih menu: ");

            if (input.hasNextInt()) {
                pilihan = input.nextInt();
            } else {
                System.out.println("Input harus berupa angka!");
                input.next();
                pilihan = 0;
            }

            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilData();
                    break;
                case 3:
                    updateData();
                    break;
                case 4:
                    hapusData();
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia");
            }

        } while (pilihan != 5);
    }

    static void tambahData() {
        System.out.print("ID Karyawan: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Nama Karyawan: ");
        String nama = input.nextLine();

        System.out.print("Tanggal Absensi: ");
        String tanggal = input.nextLine();

        System.out.print("Status (Hadir/Izin/Sakit): ");
        String status = input.nextLine();

        AbsensiKaryawan absensi = new AbsensiKaryawan(id, nama, tanggal, status);
        dataAbsensi.add(absensi);
        System.out.println("Data berhasil ditambahkan.");
    }

    static void tampilData() {

        if (dataAbsensi.isEmpty()) {
            System.out.println("Data masih kosong.");
            return;
        }

        for (AbsensiKaryawan a : dataAbsensi) {
            System.out.println("ID: " + a.getId());
            System.out.println("Nama: " + a.getNama());
            System.out.println("Tanggal: " + a.getTanggal());
            System.out.println("Status: " + a.getStatus());
            System.out.println("-------------------");
        }
    }

    static void updateData() {

        System.out.print("Masukkan ID yang ingin diupdate: ");
        int id = input.nextInt();
        input.nextLine();

        for (AbsensiKaryawan a : dataAbsensi) {
            if (a.getId() == id) {
                System.out.print("Nama baru: ");
                a.setNama(input.nextLine());

                System.out.print("Tanggal baru: ");
                a.setTanggal(input.nextLine());

                System.out.print("Status baru: ");
                a.setStatus(input.nextLine());

                System.out.println("Data berhasil diupdate.");
                return;
            }
        }
        System.out.println("Data tidak ditemukan.");
    }

    static void hapusData() {

        System.out.print("Masukkan ID yang ingin dihapus: ");
        int id = input.nextInt();

        for (AbsensiKaryawan a : dataAbsensi) {
            if (a.getId() == id) {
                dataAbsensi.remove(a);
                System.out.println("Data berhasil dihapus.");
                return;
            }
        }
        System.out.println("Data tidak ditemukan.");
    }
}