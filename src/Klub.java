import java.util.ArrayList;

public class Klub {
    ArrayList<Medlem> KlubMedlemmer = new ArrayList<>(); // liste over alle klubmedlemmer

    public static void checkListForRestance (ArrayList<Medlem> klubMedlemmer) {
        klubMedlemmer.sort(Comparator.comparing(Medlem -> Medlem.medlemID)); // sorter liste efter medlemsID fra laveste til højeste
        int n = 0;
        for (Medlem medlem : medlemList) { // gennemløber arraylisten, og tjekker hvert objekt for restance > 0
            if (medlem.restance > 0) {
                System.out.println("\nNavn:\t  "+medlem.navn+"\nMedlemID: "+medlem.medlemID+"\nRestance: "+medlem.restance);
                n++; // counter for totalt antal medlemmer i restance
            }
        }
        System.out.println("\nAntal medlemmer i restance: "+n);
    }
}
