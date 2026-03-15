public class AbsensiKaryawan {

    private Karyawan karyawan;
    private String tanggal;
    private String status;

    public AbsensiKaryawan(Karyawan karyawan, String tanggal, String status) {
        this.karyawan = karyawan;
        this.tanggal = tanggal;
        setStatus(status); // menggunakan setter agar tervalidasi
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setStatus(String status) {

        switch (status.toLowerCase()) {
            case "hadir":
            case "izin":
            case "sakit":
                this.status = status;
                break;

            default:
                System.out.println("Status tidak valid! Default: Hadir");
                this.status = "Hadir";
        }
    }
}