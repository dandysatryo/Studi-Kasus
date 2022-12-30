package entity;

public abstract class BiodataEntity {
    private String nama;
    private String noHp;
    private String alamat;
    private int lama;

    public BiodataEntity(String nama, String noHp, String alamat, int lama) {
        this.nama = nama;
        this.noHp = noHp;
        this.alamat = alamat;
        this.lama = lama;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() {
        return this.noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getLama() {
        return this.lama;
    }

    public void setLama(int lama) {
        this.lama = lama;
    }

}