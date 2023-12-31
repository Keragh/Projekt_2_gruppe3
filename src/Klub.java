import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class Klub {

    ArrayList<Medlem> KlubMedlemmer = new ArrayList<>();// liste over alle klubmedlemmer
    ArrayList<Stævne> stævneliste = new ArrayList<>();

    public void initializeKlubmedlemmer() throws IOException {

        ReadData readData = new ReadData();
        ArrayList<String> savedData = readData.getMedlem();

        int i = 0;
        while (savedData.size() > i) {
            readData.opretIndlæstMedlem(savedData,i);
            Medlem indlæstMedlem = new Medlem(readData.navn, readData.saveAlder, readData.saveHold, readData.saveErAktiv);
            KlubMedlemmer.add(indlæstMedlem);
            i++;
        }
    }

    public void initializeStævner() throws IOException {
        ReadData readData = new ReadData();
        ArrayList<String> savedData = readData.getStævne();

        int i = 0;
        while (savedData.size() > i) {
            readData.opretIndlæstStævne(savedData,i);
            Stævne stævne = new Stævne(readData.stævneNavn, readData.stævneDato);
            stævneliste.add(stævne);
            i++;
        }
    }

    public void opretStævne(String stævneNavn, LocalDate stævneDato){
        Stævne stævner = new Stævne(stævneNavn, stævneDato);
        stævneliste.add(stævner);
    }

    public void opretMedlem(String navn, int alder, boolean hold, boolean erAktiv){
        Medlem medlem = new Medlem(navn, alder, hold, erAktiv);
        KlubMedlemmer.add(medlem);
        System.out.println("Oprettet medlem: ");
        System.out.println(medlem + "\n");
    }
    public String spellingControl(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }

    public void checkListForRestance (ArrayList<Medlem> klubMedlemmer) {
        klubMedlemmer.sort(Comparator.comparing(Medlem -> Medlem.medlemsID)); // sorter liste efter medlemsID fra laveste til højeste
        int n = 0;
        for (Medlem medlem : klubMedlemmer) { // gennemløber arraylisten, og tjekker hvert objekt for restance > 0
            if (medlem.kontingent > 0) {
                System.out.println("\nNavn:\t  "+medlem.navn+"\nMedlemID: "+medlem.medlemsID+"\nRestance: "+medlem.kontingent);
                n++; // counter for totalt antal medlemmer i restance
            }
        }
        System.out.println("\nAntal medlemmer i restance: "+n+"\n");
    }
    public Medlem soegMedlemID (int medlemID) {
        Optional<Medlem> fundetMedlem = KlubMedlemmer.stream() // Optional bruges som variable type, for at benytte stream metoderne.
                .filter(Medlem -> Medlem.getMedlemID().equals(medlemID)) // Dette tillader os at simplet filtrer for medlems ID,
                .findFirst();                                            // og returnere dette til fundetMedlem. Dette gøres da jeg kun er
                                                                            // interesseret i et enkelt objekt og ikke en liste.
        return fundetMedlem.orElse(null);
    }
    public void soegMedlemNavn (String medlemNavn) {
        List<Medlem> fundetMedlemmer = KlubMedlemmer.stream()                   // her oprettes en midlertidig liste til at indeholde
                .filter(Medlem -> Medlem.getMedlemNavn().equals(medlemNavn))    // de filtrerede medlemmer fra Klubmedlemmer listen.
                .toList();

        if (!fundetMedlemmer.isEmpty()) {           // hvis medlemmer blev fundet, print. ellers, print ikke.
            int n = 0;
            for (Medlem medlem: fundetMedlemmer) {
                n++;
                System.out.println(medlem+"\n");
            }
            System.out.println("Antal medlemmer som hedder "+medlemNavn+": "+n+"\n");
        }
        else
            System.out.println("\nIntet medlem fundet.\n");
    }

    public void soegHold (Boolean hold) {
        List<Medlem> fundetMedlemmer = KlubMedlemmer.stream()
                .filter(Medlem -> Medlem.getHold().equals(hold))
                .toList();

        if (!fundetMedlemmer.isEmpty()) {           // samme som ovenstående metode (soegMedlemmer), blot sorteret efter hold i stedet.
            int n = 0;
            for (Medlem medlem : fundetMedlemmer) {
                n++;
                System.out.println(medlem + "\n");
            }
            if (hold) {
                System.out.println("\nAntal medlemmer af Konkurrenceholdet: " + n);
            } else if (!hold) {
                System.out.println("\nAntal medlemmer af Motionsholdet: " + n);
            } else
                System.out.println("\nKlubben har ingen medlemmer på nuværende tidspunkt.");
        }
    }
        //Metode til udskrive alle medlemmers toString og samle antal medlemmer
        public void udskrivMedlemmer() {
            System.out.println("Medlemmer i klubben: ");

            for (Medlem medlem : KlubMedlemmer) {
                System.out.println(medlem.toString());
            }
            System.out.println("\nTotal antal medlemmer: " + KlubMedlemmer.size()+"\n");
        }
    }
