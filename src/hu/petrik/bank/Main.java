package hu.petrik.bank;

public class Main {
    public static void main(String[] args) {
        Bank otp = new Bank();

        Tulajdonos t1 = new Tulajdonos("Teszt Tulaj 1");
        Tulajdonos t2 = new Tulajdonos("Teszt Tulaj 2");
        Tulajdonos t4 = new Tulajdonos("Teszt Tulaj 4");
        Tulajdonos t5 = new Tulajdonos("Teszt Tulaj 5");

        MegtakaritsiSzamla sz1 = (MegtakaritsiSzamla) otp.szamlanyitas(t1, 0);
        otp.szamlanyitas(t1, 1000).befizet(12344);
        MegtakaritsiSzamla sz2 = (MegtakaritsiSzamla) otp.szamlanyitas(t2, 0);
        HitelSzamla sz3 = (HitelSzamla) otp.szamlanyitas(t4, 250000);
        HitelSzamla sz4 = (HitelSzamla) otp.szamlanyitas(t5, 10);

        System.out.println(sz1.getTulajdonos() + " Aktuális egyenleg: " + sz1.getAktualisEgyenleg());

        sz1.befizet(500);
        sz2.befizet(500);
        sz3.befizet(500);

        Kartya k1 = sz1.ujKartya("1234 1234 1234");
        Kartya k3 = sz3.ujKartya("34535 535435 534535");
        Kartya k4 = sz4.ujKartya("34535 53453 43534535");

        System.out.println(sz1.getTulajdonos().getNev() + " Aktuális egyenleg: " + sz1.getAktualisEgyenleg());
        k1.vasarlas(200);
        System.out.println(sz1.getTulajdonos().getNev() + " Aktuális egyenleg: " + sz1.getAktualisEgyenleg());
        k1.vasarlas(500);

        System.out.println(sz3.getTulajdonos().getNev() + " Aktuális egyenleg: " + sz3.getAktualisEgyenleg());
        k3.vasarlas(242424);
        System.out.println(sz3.getTulajdonos().getNev() + " Aktuális egyenleg: " + sz3.getAktualisEgyenleg());

        System.out.println(k4.getTulajdonos().getNev() + " Aktuális egyenleg: " + sz4.getAktualisEgyenleg());
        k4.vasarlas(10);
        System.out.println(k4.getTulajdonos().getNev() + " Aktuális egyenleg: " + sz4.getAktualisEgyenleg());

        k4.vasarlas(1);
        System.out.println(k4.getTulajdonos().getNev() + " Aktuális egyenleg: " + sz4.getAktualisEgyenleg());

        sz2.befizet(2134);


        System.out.println(t1.getNev() + " Össz egyenleg: " + otp.getOsszEgyenleg(t1));

        t1.setNev("Másik név");
        System.out.println(t1.getNev() + " Össz egyenleg: " + otp.getOsszEgyenleg(t1));

        System.out.println("Össz hitel: " + otp.getOsszHitelkeret());

        System.out.println("Legnagyobb egyenlegű számla: " + otp.getLegnagyobbEgyenleguSzamla(t1).getAktualisEgyenleg());
    }
}