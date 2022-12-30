package entity;
import utils.DateString;
public class ReservasiLuar {
    private TamuLuarNegeriEntity tamuLuar;
    private KamarEntity kamar;
    private String checkin;
    private String checout;

    public ReservasiLuar(TamuLuarNegeriEntity tamuLuar, KamarEntity kamar) {
        this.tamuLuar = tamuLuar;
        this.kamar = kamar;
        this.checkin = DateString.now();
    }


    public TamuLuarNegeriEntity getTamuLuar() {
        return this.tamuLuar;
    }

    public void setTamuLuar(TamuLuarNegeriEntity tamuLuar) {
        this.tamuLuar = tamuLuar;
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
