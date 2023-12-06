public class Medlem {
    String navn;
    int alder;
    boolean hold; // note til selv - true = konkurrencehold, false = motionshold - temp !
    protected static int næsteID = 0; //sætter ID'sl værdi til 0, fordi metoden siger +1 når et medlem bliver oprettet, så første medlem får tallet 1.
    protected int medlemsID;
    boolean aktivitetsStatus;
    double kontingent;

    //opretter konstrukter for at initialisere variablerne
    public Medlem (String navn, int alder, boolean hold, boolean erAktiv){
        this.navn = navn;
        this.alder = alder;
        this.hold = hold;
        næsteID++;
        medlemsID = næsteID;
        this.aktivitetsStatus = erAktiv;
        this.kontingent = saetKontigent(erAktiv, alder);
    }

    public void betalKontingent (){ //metode for at betale kontingent.
        this.kontingent = 0;        //når man kalder metoden bliver kontingent sat til 0, dvs at medlemmet har betalt.
        System.out.println("\nMedlems Navn: " + navn + "\n" + "MedlemID: " + medlemsID + "\n" + "Har betalt kontingent.");
    }                               //printer en service besked
    public Integer getMedlemID () {
        return medlemsID;
    }
    public String getMedlemNavn () {
        return navn;
    }
    public Boolean getHold () {
        return hold;
    }
    public String holdNavn () {
        if (hold) {return "Konkurrencehold";}
        else return "Motionshold";
    }
    public int saetKontigent(boolean aktivitetsStatus, int alder) {
        if (!aktivitetsStatus) {
            return 500;
        }
        else
        if (alder <= 17) {
            return 1000;
        } else if (alder <= 65) {
            return 1600;
        } else {
            return (int)(1600*0.75); //For at få beløb 25% rabat
        }
    }
    // Metode til at ændre aktivitetsstatus
    public void sætAktiv(boolean erAktiv) {
        this.aktivitetsStatus = erAktiv;
    }
    // toString-metode for at konvert objekter til en string
    @Override
    public String toString() {
        return "\nNavn: " + navn + "\n" + "Alder: " + alder + "\n" +"MedlemID: " + medlemsID + "\nHold: "+holdNavn();
    }

    // Laver en midlertidig main-metode, opretter 2 eksmepler på nyt medlem for at teste det virker
    public static void main(String[] args) {
        Medlem medlem1 = new Medlem("John Olsen", 60, true, true);
        Medlem medlem2 = new Medlem("Mariah Carey", 18, false, true);

        System.out.println(medlem1);
        System.out.println(medlem2);

        //test af metode
        medlem1.betalKontingent();

    }
}
