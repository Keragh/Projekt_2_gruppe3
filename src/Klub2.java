import java.lang.reflect.Member;
import java.util.ArrayList;
//I Klub klassen, opret en metode som printer alle medlemmers toString fra arraylisten samt total antal af medlemmer.
public class Klub2 {
    ArrayList<Medlem> medlemmer;
    //Konstruktør
    public Klub2() {
        medlemmer = new ArrayList();
    }
    //Metode til at tilføje et medlem til klubben
    public void tilføjMedlem(Medlem nyMedlem) {
        medlemmer.add(nyMedlem);
    }
    //Metode til udskrive alle medlemmers toString og samle antal medlemmer
    public void udskrivMedlemmer() {
        System.out.println("Medlemmer i klubben: ");

        for (Medlem medlem : medlemmer) {
            System.out.println(medlem.toString());
        }
        System.out.println("Total antal medlemmer: " + medlemmer.size());
    }
    class Medlem{
        String navn;
        int alder;
        public Medlem(String navn, int alder){
            this.navn=navn;
            this.alder=alder;
        }
        @Override
        public String toString(){
            return "Navn: "+navn+" , Alder: "+ alder;
        }
    }
}
