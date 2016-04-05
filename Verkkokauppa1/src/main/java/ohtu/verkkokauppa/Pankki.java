package ohtu.verkkokauppa;

public class Pankki implements PankkiInterface {

    //private static Pankki instanssi;

    /* public static Pankki getInstance() {
        if (instanssi == null) {
            instanssi = new Pankki();
        }

        return instanssi;
    } */
    
    private KirjanpitoInterface kirjanpitoI;

    public Pankki(KirjanpitoInterface kirjanpitoI) {
        this.kirjanpitoI = kirjanpitoI;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpitoI.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
