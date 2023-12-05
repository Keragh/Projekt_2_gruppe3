import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Stævne {

    LocalDate stævneDato;

    ArrayList<Resultat> resultats = new ArrayList<>();

    String stævneNavn;


    public Stævne(String stævneNavn, LocalDate stævneDato){
        this.stævneNavn=stævneNavn;
        this.stævneDato=stævneDato;
    }


    public void tilfoejResultat(Disciplin disciplin, Medlem medlem, double tid) {
        var resultat = new Resultat();
        resultat.disciplin = disciplin;
        resultat.medlemsID = medlem.medlemsID;
        resultat.tid = tid;
        resultat.dato = stævneDato;
        resultats.add(resultat);
    }
}

