import java.time.LocalDate;

enum Disciplin {RYG, BRYST, BUTTERFLY}
public class Resultat {
    LocalDate dato;
    double tid;
    Disciplin disciplin;
    int medlemsID;
    String navn;
    int placering;
    public double getTid() {
        return tid;
    }
    public Disciplin getDisciplin(){
        return disciplin;
    }

    public String toString(){ //Giver basal information omkring hvordan det gik.
        if (placering != 0) {
        return "\nNavn: "+navn+"\nMedlemsID: "+medlemsID+"\nDeciplin: "+disciplin+"\nDatoen er den: "+dato+"\nDin tid var: "+tid+"sekunder.\nPlacering: "+placering;
    }
        else
            return "\nNavn: "+navn+"\nMedlemsID: "+medlemsID+"\nDeciplin: "+disciplin+"\nDatoen er den: "+dato+"\nDin tid var: "+tid+"sekunder.";
    }

}