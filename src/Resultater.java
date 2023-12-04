import java.time.LocalDate;
import java.util.ArrayList;

public class Resultater {
    ArrayList<Resultat> resultatListe = new ArrayList<>();

    void tilfoejResultat(Disciplin disciplin, String medlemID, double tid, LocalDate dato) {
        var resultat = new Resultat();
        resultat.disciplin = disciplin;
        resultat.medlemID = medlemID;
        resultat.tid = tid;
        resultat.dato = dato;
        resultatListe.add(resultat);
    }
}
