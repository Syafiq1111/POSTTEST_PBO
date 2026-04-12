// Superclass:
public class Karyawan {
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

    // Overriding 1
    public void tampilInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Jabatan: " + jabatan);
        System.out.println("Departemen: " + departemen);
    }

    // Overriding 2
    public void tugasUtama() {
        System.out.println("Tugas: Menjalankan operasional perusahaan.");
    }

    // Overloading 1
    public void tampilInfo(String label) {
        System.out.println("=== " + label + " ===");
        tampilInfo();
    }

    // Overloading 2
    public void tampilInfo(boolean ringkas) {
        if (ringkas) {
            System.out.println("[" + id + "] " + nama + " - " + departemen);
        } else {
            tampilInfo();
        }
    }
}

// Subclass 1:
class KaryawanIT extends Karyawan {
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
}

// Subclass 2:
class KaryawanHR extends Karyawan {
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
}

// Subclass 3:
class KaryawanFinance extends Karyawan {
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
}