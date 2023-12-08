import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Stævne {

    LocalDate stævneDato;

    ArrayList<Resultat> resultats = new ArrayList<>();

    String stævneNavn;
    protected static int næsteID = 0; //sætter ID'sl værdi til 0, fordi metoden siger +1 når et medlem bliver oprettet, så første medlem får tallet 1.
    protected int stævneID;

    public Stævne(String stævneNavn, LocalDate stævneDato){
        this.stævneNavn=stævneNavn;
        this.stævneDato=stævneDato;
        næsteID++;
        stævneID = næsteID;
    }


    public void tilfoejResultat(Disciplin disciplin, Medlem medlem, double tid, int placering, int stævneNummer) {
        var resultat = new Resultat();
        resultat.disciplin = disciplin;
        resultat.medlemsID = medlem.medlemsID;
        resultat.navn = medlem.navn;
        resultat.tid = tid;
        resultat.dato = stævneDato;
        resultat.placering = placering;
        resultat.stævnenummer = stævneNummer;
        resultats.add(resultat);
    }
}

