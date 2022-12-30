package entity;

public class TamuLokalEntity extends BiodataEntity{
    private int ktp;

    public TamuLokalEntity(String nama, String noHp, String alamat, int lama,int ktp) {
        super(nama, noHp, alamat, lama);
        this.ktp = ktp;
    }

    public int getKtp() {
        return this.ktp;
    }

    public void setKtp(int ktp) {
        this.ktp = ktp;
    }
}