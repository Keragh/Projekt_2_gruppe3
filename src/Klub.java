import java.util.ArrayList;
import java.util.Comparator;

public class Klub {
    ArrayList<Medlem> KlubMedlemmer = new ArrayList<>(); // liste over alle klubmedlemmer

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
}
