import java.time.LocalDate;
import java.util.ArrayList;

public class Stævne {
    LocalDate dato;
    String navn;
    ArrayList<String> konkurrenceSvommere = new ArrayList<>();
    ArrayList<Integer> placering = new ArrayList<>();

    public Stævne(LocalDate dato, String navn, ArrayList<String> konkurrenceSvommere, ArrayList<Integer> placering){
        this.dato=dato;
        this.navn=navn;
        this.konkurrenceSvommere =konkurrenceSvommere;
        this.placering=placering;
    }

}