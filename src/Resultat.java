import java.time.LocalDate;

public class Resultat {
    String disciplin;
    LocalDate dato;
    double tid;

    public Resultat(String disciplin, LocalDate dato, double tid){
        this.disciplin=disciplin;
        this.dato=dato;
        this.tid=tid;
    }
    public String toString(){ //Giver basal information omkring hvordan det gik.
        return "\nDeciplin: "+disciplin+"\nDatoen er den: "+dato+"\nDin tid var: "+tid;
    }
}
