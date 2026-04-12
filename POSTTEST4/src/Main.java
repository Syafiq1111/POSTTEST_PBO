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
            System.out.println("5. Update Data Absensi");
            System.out.println("6. Hapus Data Absensi");
            System.out.println("7. Exit");
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
                    updateAbsensi();
                    break;
                case 6:
                    hapusAbsensi();
                    break;
                case 7:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia");
            }
        } while (pilihan != 7);
    }

    static void tambahKaryawan() {
        System.out.println("\nPilih Tipe Karyawan:\n1. IT\n2. HR\n3. Finance");
        System.out.print("Pilihan: ");
        int tipe = input.nextInt();

        System.out.print("ID Karyawan: ");
        int id = input.nextInt(); input.nextLine();
        System.out.print("Nama Karyawan: ");
        String nama = input.nextLine();
        System.out.print("Jabatan: ");
        String jabatan = input.nextLine();

        if (tipe == 1) {
            System.out.print("Tech Stack: "); String ts = input.nextLine();
            daftarKaryawan.add(new KaryawanIT(id, nama, jabatan, ts));
        } else if (tipe == 2) {
            System.out.print("Spesialisasi: "); String sp = input.nextLine();
            daftarKaryawan.add(new KaryawanHR(id, nama, jabatan, sp));
        } else if (tipe == 3) {
            System.out.print("Sertifikasi: "); String ser = input.nextLine();
            daftarKaryawan.add(new KaryawanFinance(id, nama, jabatan, ser));
        }
        System.out.println("Data karyawan berhasil ditambahkan.");
    }

    static void tampilKaryawan() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Data karyawan kosong.");
            return;
        }

        System.out.println("\n--- DAFTAR KARYAWAN (PENERAPAN POLIMORFISME) ---");
        for (Karyawan k : daftarKaryawan) {
            // Method Overloading
            k.tampilInfo("DETAIL KARYAWAN");

            // Method Overriding
            k.tugasUtama();

            System.out.println("--------------------");
        }
    }

    static void tambahAbsensi() {
        System.out.print("Masukkan ID Karyawan: ");
        int id = input.nextInt(); input.nextLine();
        for (Karyawan k : daftarKaryawan) {
            if (k.getId() == id) {
                System.out.print("Tanggal: "); String tanggal = input.nextLine();
                System.out.print("Status (Hadir/Izin/Sakit): "); String status = input.nextLine();
                dataAbsensi.add(new AbsensiKaryawan(k, tanggal, status));
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

    static void updateAbsensi() {
        System.out.print("Masukkan ID Karyawan yang ingin diupdate: ");
        int id = input.nextInt(); input.nextLine();
        for (AbsensiKaryawan a : dataAbsensi) {
            if (a.getKaryawan().getId() == id) {
                System.out.print("Tanggal baru: "); a.setTanggal(input.nextLine());
                System.out.print("Status baru (Hadir/Izin/Sakit): "); a.setStatus(input.nextLine());
                System.out.println("Data absensi berhasil diupdate.");
                return;
            }
        }
        System.out.println("Data absensi tidak ditemukan.");
    }

    static void hapusAbsensi() {
        System.out.print("Masukkan ID Karyawan yang ingin dihapus: ");
        int id = input.nextInt();
        for (int i = 0; i < dataAbsensi.size(); i++) {
            if (dataAbsensi.get(i).getKaryawan().getId() == id) {
                dataAbsensi.remove(i);
                System.out.println("Data absensi berhasil dihapus.");
                return;
            }
        }
        System.out.println("Data absensi tidak ditemukan.");
    }
}