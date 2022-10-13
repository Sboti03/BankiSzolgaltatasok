package hu.petrik.bank;

public class MegtakaritsiSzamla extends Szamla {

    private double kamat;
    public static double alapKamat = 1.1;

    public MegtakaritsiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.kamat = alapKamat;
    }

    @Override
    public boolean kivesz(int osszeg) {
        boolean kiTudVenni = false;
        if ((getAktualisEgyenleg() - osszeg) >= 0) {
            kiTudVenni = true;
            aktualisEgyenleg -= osszeg;
        }
        return kiTudVenni;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }

    public void kamatJovairas() {
        aktualisEgyenleg *= kamat;
    }
}
