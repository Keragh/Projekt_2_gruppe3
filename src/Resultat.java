import java.time.LocalDate;

enum Disciplin {RYG, BRYST, BUTTERFLIES}
public class Resultat {
    LocalDate dato;
    double tid;
    Disciplin disciplin;
    int medlemsID;

    public int getMedlemID() {
        return medlemsID;
    }

    public double getTid() {
        return tid;
    }
    public Disciplin getDisciplin(){
        return disciplin;
    }

    public String toString(){ //Giver basal information omkring hvordan det gik.
        return "\nDeciplin: "+disciplin+"\nDatoen er den: "+dato+"\nDin tid var: "+tid;
    }
}



