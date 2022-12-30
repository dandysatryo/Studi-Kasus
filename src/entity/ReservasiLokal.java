package entity;
import utils.DateString;
public class ReservasiLokal {
    private TamuLokalEntity tamuLokal;
    private KamarEntity kamar;
    private String checkin;
    private String checout;

    public ReservasiLokal(TamuLokalEntity tamuLokal, KamarEntity kamar) {
        this.tamuLokal = tamuLokal;
        this.kamar = kamar;
        this.checkin = DateString.now();
    }

    public ReservasiLokal() {
    }

    public TamuLokalEntity getTamuLokal() {
        return this.tamuLokal;
    }

    public void setTamuLokal(TamuLokalEntity tamuLokal) {
        this.tamuLokal = tamuLokal;
    }

    public KamarEntity getKamar() {
        return this.kamar;
    }

    public void setKamar(KamarEntity kamar) {
        this.kamar = kamar;
    }

    public String getCheckin() {
        return this.checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getChecout() {
        return this.checout;
    }

    public void setChecout(String checout) {
        this.checout = checout;
    }
}