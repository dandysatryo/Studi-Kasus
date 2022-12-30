package entity;

public class KamarEntity {
    private String no_kamar;
    private String tipe_kamar;
    private boolean Status_kamar;

    public KamarEntity(String no_kamar, String tipe_kamar, boolean Status_kamar) {
        this.no_kamar = no_kamar;
        this.tipe_kamar = tipe_kamar;
        this.Status_kamar = Status_kamar;
    }

    public KamarEntity() {
    }

    public String getNo_kamar() {
        return this.no_kamar;
    }

    public void setNo_kamar(String no_kamar) {
        this.no_kamar = no_kamar;
    }

    public String getTipe_kamar() {
        return this.tipe_kamar;
    }

    public void setTipe_kamar(String tipe_kamar) {
        this.tipe_kamar = tipe_kamar;
    }

    public boolean isStatus_kamar() {
        return this.Status_kamar;
    }

    public boolean getStatus_kamar() {
        return this.Status_kamar;
    }

    public void setStatus_kamar(boolean Status_kamar) {
        this.Status_kamar = Status_kamar;
    }
}