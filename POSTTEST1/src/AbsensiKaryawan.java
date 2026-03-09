public class AbsensiKaryawan {
    private int id;
    private String nama;
    private String tanggal;
    private String status;

    public AbsensiKaryawan(int id, String nama, String tanggal, String status) {
        this.id = id;
        this.nama = nama;
        this.tanggal = tanggal;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


