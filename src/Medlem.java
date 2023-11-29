public class Medlem {
    String navn;
    int alder;
    protected static int næsteID = 0;
    protected int medlemsID;
    double kontingent;



    //Constructor
    public Medlem (String navn, int alder){
        this.medlemsID = næsteID++;
        this.navn = navn;
        this.alder = alder;
        medlemsID = næsteID;
    }

    // toString-metode for at konvert objekter til en string
    @Override
    public String toString() {
        return "Medlem: \n" + "Navn: " + navn + "\n" + "Alder: " + alder + "\n" +"MedlemID: " + medlemsID + "\n";
    }

    // Laver en midlertidig main-metode, opretter 2 eksmepler på nyt medlem for at teste det virker
    public static void main(String[] args) {
        Medlem medlem1 = new Medlem("John Olsen", 60);
        Medlem medlem2 = new Medlem("Mariah Carey", 18);

        System.out.println(medlem1);
        System.out.println(medlem2);

    }
}
