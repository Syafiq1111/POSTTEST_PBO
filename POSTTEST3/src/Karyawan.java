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

    public void tampilInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Jabatan: " + jabatan);
        System.out.println("Departemen: " + departemen);
    }
}

// Subclass 1:
class KaryawanIT extends Karyawan {
    private String techStack;

    public KaryawanIT(int id, String nama, String jabatan, String techStack) {
        super(id, nama, jabatan, "IT");
        this.techStack = techStack;
    }

    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Tech Stack: " + techStack);
    }
}

// Subclass 2:
class KaryawanHR extends Karyawan {
    private String spesialisasi;

    public KaryawanHR(int id, String nama, String jabatan, String spesialisasi) {
        super(id, nama, jabatan, "HR");
        this.spesialisasi = spesialisasi;
    }

    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Spesialisasi: " + spesialisasi);
    }
}

// Subclass 3: POIN PLUSSSSS
class KaryawanFinance extends Karyawan {
    private String sertifikasi;

    public KaryawanFinance(int id, String nama, String jabatan, String sertifikasi) {
        super(id, nama, jabatan, "Finance");
        this.sertifikasi = sertifikasi;
    }

    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Sertifikasi: " + sertifikasi);
    }
}