import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Klub {

    ArrayList<Medlem> KlubMedlemmer = new ArrayList<>();// liste over alle klubmedlemmer
    ArrayList<Stævne> stævneliste=new ArrayList<>();

    public static Stævne opretStævne(String stævneNavn, LocalDate stævneDato, ArrayList<Stævne> stævneliste){
        Stævne stævner = new Stævne(stævneNavn, stævneDato);
        stævneliste.add(stævner);
    }

    public static void checkListForRestance (ArrayList<Medlem> klubMedlemmer) {
        klubMedlemmer.sort(Comparator.comparing(Medlem -> Medlem.medlemsID)); // sorter liste efter medlemsID fra laveste til højeste
        int n = 0;
        for (Medlem medlem : klubMedlemmer) { // gennemløber arraylisten, og tjekker hvert objekt for restance > 0
            if (medlem.kontingent > 0) {
                System.out.println("\nNavn:\t  "+medlem.navn+"\nMedlemID: "+medlem.medlemsID+"\nRestance: "+medlem.kontingent);
                n++; // counter for totalt antal medlemmer i restance
            }
        }
        System.out.println("\nAntal medlemmer i restance: "+n);
    }
    public void soegMedlemID (int medlemID) {
        Optional<Medlem> fundetMedlem = KlubMedlemmer.stream() // Optional bruges som variable type, for at benytte stream metoderne.
                .filter(Medlem -> Medlem.getMedlemID().equals(medlemID)) // Dette tillader os at simplet filtrer for medlems ID,
                .findFirst();                                            // og returnere dette til fundetMedlem. Dette gøres da jeg kun er
        // interesseret i et enkelt objekt og ikke en liste.

        if (fundetMedlem.isPresent()) {
            System.out.println("\nFundet medlem:");
            System.out.println(fundetMedlem.get()+"\n");
        }
        else
            System.out.println("Intet medlem fundet.");
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

        public void tilføjMedlem(Medlem nyMedlem) {
            KlubMedlemmer.add(nyMedlem);
        }
//      Metode til udskrive alle medlemmers toString og samle antal medlemmer
        public void udskrivMedlemmer() {
            System.out.println("Medlemmer i klubben: ");

            for (Medlem medlem : KlubMedlemmer) {
                System.out.println(medlem.toString());
            }
            System.out.println("Total antal medlemmer: " + KlubMedlemmer.size());
        }
}