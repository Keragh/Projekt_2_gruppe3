public class Medlem {
    String navn;
    int alder;
    protected static int næsteId = 0;
    protected int medlemsId;



    //Constructor
    public Medlem (String navn, int alder){
        this.medlemsId = næsteId++;
        this.navn = navn;
        this.alder = alder;
        medlemsId = næsteId;
    }

    // toString-metode for at konvert objekter til en string
    @Override
    public String toString() {
        return "Medlem: \n" + "Navn: " + navn + "\n" + "Alder: " + alder + "\n" +"MedlemID: " + medlemsId + "\n";
    }

    public static void main(String[] args) {
        // Opretter 2 eksmepler på nyt medlem for at teste det virker
        Medlem medlem1 = new Medlem("John Olsen", 60);
        Medlem medlem2 = new Medlem("Mariah Carey", 18);

        System.out.println(medlem1);
        System.out.println(medlem2);

    }
}
