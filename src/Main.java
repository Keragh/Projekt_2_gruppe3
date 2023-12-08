import java.io.IOException;

public class Main{
    public static void main(String[]args) throws IOException {
    Menu menu = new Menu();
    menu.menu(); // objekt hovedmenuen oprettes og køres. Den indeholder et loop som sørger for, at når denne metode slutter, slutter programmet.
    menu.saveData(menu.klub.KlubMedlemmer, menu.resultater.resultatListe, menu.klub.stævneliste);
    }
}