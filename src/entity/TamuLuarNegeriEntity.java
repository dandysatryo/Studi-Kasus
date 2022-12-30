package entity;

public class TamuLuarNegeriEntity extends BiodataEntity{
    private int pasport;

    public TamuLuarNegeriEntity(String nama, String noHp, String alamat, int lama,int pasport) {
        super(nama, noHp, alamat, lama);
        this.pasport = pasport;
    }

    public int getPasport() {
        return this.pasport;
    }

    public void setPasport(int pasport) {
        this.pasport = pasport;
    }

}