import java.time.LocalDate;

enum Disciplin {RYG, BRYST, BUTTERFLIES}
public class Resultat {
    LocalDate dato;
    double tid;
    Disciplin disciplin;
    String medlemID;

    public String getMedlemID() {
        return medlemID;
    }

    public double getTid() {
        return tid;
    }

    public String toString(){ //Giver basal information omkring hvordan det gik.
        return "\nDeciplin: "+disciplin+"\nDatoen er den: "+dato+"\nDin tid var: "+tid;
    }
}



