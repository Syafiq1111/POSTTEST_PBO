public class Karyawan {

    private int id;
    private String nama;
    private String jabatan;

    protected String departemen = "Umum";

    public Karyawan(int id, String nama, String jabatan) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.isEmpty()) {
            this.nama = nama;
        } else {
            System.out.println("Nama tidak boleh kosong!");
        }
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    void tampilDepartemen() {
        System.out.println("Departemen: " + departemen);
    }
}