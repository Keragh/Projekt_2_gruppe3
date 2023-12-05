import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Resultater {
    ArrayList<Resultat> resultatListe = new ArrayList<>();

    void tilfoejResultat(Disciplin disciplin, Medlem medlem, double tid, LocalDate dato) {
        var resultat = new Resultat();
        resultat.disciplin = disciplin;
        resultat.medlemsID = medlem.medlemsID;
        resultat.tid = tid;
        resultat.dato = dato;
        resultatListe.add(resultat);
    }
    List<Resultat> Findtop5forDiciplin (Disciplin disciplin){
        // sorterer resulatListe i disciplin og returnere liste af top 5 for disciplin
        return resultatListe.stream()
                .sorted(Comparator.comparing(Resultat::getTid))
                .filter(c -> disciplin.equals(c.getDisciplin()))
                .limit(5)
                .collect(Collectors.toList());
    }
}