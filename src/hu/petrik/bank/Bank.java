package hu.petrik.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Szamla> szamlaLista;

    public Bank() {
        szamlaLista = new ArrayList<>();
    }

    public Szamla szamlanyitas(Tulajdonos tulajdonos, int hitelKeret) {
        Szamla ujSzamla;
        if (hitelKeret == 0) {
            ujSzamla = new MegtakaritsiSzamla(tulajdonos);
        } else {
            ujSzamla = new HitelSzamla(tulajdonos, hitelKeret);
        }
        szamlaLista.add(ujSzamla);
        return ujSzamla;
    }

    public int getOsszEgyenleg(Tulajdonos tulajdonos) {
        int egyenleg = 0;
        for (Szamla sz : szamlaLista) {
            if (sz.getTulajdonos().equals(tulajdonos)) {
                egyenleg += sz.getAktualisEgyenleg();
            }
        }
        return egyenleg;
    }

    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos) {
        Szamla legnagyobbSzamla = null;
        int egyenleg = 0;
        for (Szamla sz : szamlaLista) {
            if (sz.getTulajdonos().equals(tulajdonos)) {
                if (egyenleg < sz.getAktualisEgyenleg()) {
                    legnagyobbSzamla = sz;
                    egyenleg = sz.getAktualisEgyenleg();
                }
            }
        }
        return legnagyobbSzamla;
    }

    public long getOsszHitelkeret() {
        long hitelKeret = 0;
        for (Szamla sz : szamlaLista) {
            if (sz instanceof HitelSzamla){
                HitelSzamla tmp = (HitelSzamla) sz;
                hitelKeret += tmp.getHitelKeret();
            }
        }
        return hitelKeret;
    }
}
