interface IKerja {
    void mulaiKerja();   // Method 1
    void selesaiKerja(); // Method 2
}

    abstract class Karyawan {
    private int id;
    private String nama;
    private String jabatan;
    protected String departemen;

    public Karyawan(int id, String nama, String jabatan, String departemen) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
        this.departemen = departemen;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getJabatan() { return jabatan; }

    public void tampilInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Jabatan: " + jabatan);
        System.out.println("Departemen: " + departemen);
    }

    public abstract void tugasUtama();

    public void tampilInfo(String label) {
        System.out.println("=== " + label + " ===");
        tampilInfo();
    }

    public void tampilInfo(boolean ringkas) {
        if (ringkas) {
            System.out.println("[" + id + "] " + nama + " - " + departemen);
        } else {
            tampilInfo();
        }
    }
}

// Subclass 1: IT
class KaryawanIT extends Karyawan implements IKerja {
    private String techStack;

    public KaryawanIT(int id, String nama, String jabatan, String techStack) {
        super(id, nama, jabatan, "IT");
        this.techStack = techStack;
    }

    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Tech Stack: " + techStack);
    }

    @Override
    public void tugasUtama() {
        System.out.println("Tugas: Mengembangkan dan memelihara infrastruktur perangkat lunak.");
    }

    @Override
    public void mulaiKerja() {
        System.out.println("Status: Membuka IDE dan mulai coding.");
    }

    @Override
    public void selesaiKerja() {
        System.out.println("Status: Push code ke repository dan mematikan server.");
    }
}

// Subclass 2: HR
class KaryawanHR extends Karyawan implements IKerja {
    private String spesialisasi;

    public KaryawanHR(int id, String nama, String jabatan, String spesialisasi) {
        super(id, nama, jabatan, "HR");
        this.spesialisasi = spesialisasi;
    }

    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Spesialisasi: " + spesialisasi);
    }

    @Override
    public void tugasUtama() {
        System.out.println("Tugas: Mengelola sumber daya manusia dan rekrutmen.");
    }

    @Override
    public void mulaiKerja() {
        System.out.println("Status: Meninjau CV kandidat dan jadwal interview.");
    }

    @Override
    public void selesaiKerja() {
        System.out.println("Status: Mengirim email follow up dan rekap absensi.");
    }
}

// Subclass 3: Finance
class KaryawanFinance extends Karyawan implements IKerja {
    private String sertifikasi;

    public KaryawanFinance(int id, String nama, String jabatan, String sertifikasi) {
        super(id, nama, jabatan, "Finance");
        this.sertifikasi = sertifikasi;
    }

    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Sertifikasi: " + sertifikasi);
    }

    @Override
    public void tugasUtama() {
        System.out.println("Tugas: Mengelola laporan keuangan dan anggaran perusahaan.");
    }

    @Override
    public void mulaiKerja() {
        System.out.println("Status: Membuka spreadsheet dan memproses invoice.");
    }

    @Override
    public void selesaiKerja() {
        System.out.println("Status: Tutup buku harian dan validasi transaksi.");
    }
}