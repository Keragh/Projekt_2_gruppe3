import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Resultater {
    ArrayList<Resultat> resultatListe = new ArrayList<>();

    void tilfoejResultat(Disciplin disciplin, int medlemsId, String navn, double tid, LocalDate dato, int placering, int stævnenummer) {
        var resultat = new Resultat();
        resultat.disciplin = disciplin;
        resultat.medlemsID = medlemsId;
        resultat.navn = navn;
        resultat.tid = tid;
        resultat.dato = dato;
        resultat.placering = placering;
        resultat.stævnenummer = stævnenummer;
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