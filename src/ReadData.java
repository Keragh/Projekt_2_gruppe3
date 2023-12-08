import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReadData {
    String navn;
    int saveAlder;
    boolean saveHold;
    boolean saveErAktiv;
    String stævneNavn;
    LocalDate stævneDato;
    Disciplin disciplin;
    int resultatmedlemsID;
    LocalDate dato;
    double tid;
    int placering;
    int stævneID;


    public void opretIndlæstResultat(ArrayList<String> fundetResultatListe, int index) {
        disciplin = Disciplin.valueOf(extractData(fundetResultatListe.get(index),0));
        resultatmedlemsID = Integer.parseInt(extractData(fundetResultatListe.get(index),1));
        tid = Double.parseDouble(extractData(fundetResultatListe.get(index),2));

        String tempResultatDato = extractData(fundetResultatListe.get(index),3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dato = LocalDate.parse(tempResultatDato, formatter);

        placering = Integer.parseInt(extractData(fundetResultatListe.get(index), 4));
        stævneID = Integer.parseInt(extractData(fundetResultatListe.get(index), 5));
    }

    public void opretIndlæstMedlem(ArrayList<String> fundetMedlemListe, int index) {
        navn = extractData(fundetMedlemListe.get(index), 0);
        String alder = extractData(fundetMedlemListe.get(index), 1);
        String hold = extractData(fundetMedlemListe.get(index), 2);
        String erAktiv = extractData(fundetMedlemListe.get(index), 3);

        saveAlder = convertAlder.getOrDefault(alder, 0);

        if (hold.equals("true")) {
            saveHold = true;
        } else if (hold.equals("false")) {
            saveHold = false;
        }

        if (erAktiv.equals("true")) {
            saveErAktiv = true;
        } else if (erAktiv.equals("false")) {
            saveErAktiv = false;
        }
    }
    public void opretIndlæstStævne(ArrayList<String> fundetStævneListe, int index) {
        stævneNavn = extractData(fundetStævneListe.get(index), 0);
        String tempStævneDato = extractData(fundetStævneListe.get(index), 1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        stævneDato = LocalDate.parse(tempStævneDato, formatter);
    }

    public ArrayList<String> getMedlem() throws IOException {
        FileReader medlemsListe = new FileReader("MedlemsListe.txt");
        BufferedReader readIn = new BufferedReader(medlemsListe);
        ArrayList<String> fundetMedlemListe = new ArrayList<>();
        String line;
        while ((line = readIn.readLine()) != null) {
            fundetMedlemListe.add(line);
        }
        readIn.close();
        return fundetMedlemListe;
    }

    public ArrayList<String> getStævne() throws IOException {
        FileReader stævneListe = new FileReader("StævneListe.txt");
        BufferedReader readIn = new BufferedReader(stævneListe);
        ArrayList<String> fundetStævneListe = new ArrayList<>();
        String line;
        while ((line = readIn.readLine()) != null) {
                fundetStævneListe.add(line);
            }
        readIn.close();
        return fundetStævneListe;
    }
    public ArrayList<String> getResultat() throws IOException {
        FileReader resultatListe = new FileReader("ResultatListe.txt");
        BufferedReader readIn = new BufferedReader(resultatListe);
        ArrayList<String> fundetResultatListe = new ArrayList<>();
        String line;
        while ((line = readIn.readLine()) != null) {
                fundetResultatListe.add(line);
            }
        readIn.close();
        return fundetResultatListe;
    }
    public String extractData(String splitInput, int i) {
        String[] parts = splitInput.split(",");
        return parts[i];
    }

    private static final Map<String, Integer> convertAlder = new HashMap<>();

    static {
        convertAlder.put("1", 1);
        convertAlder.put("2", 2);
        convertAlder.put("3", 3);
        convertAlder.put("4", 4);
        convertAlder.put("5", 5);
        convertAlder.put("6", 6);
        convertAlder.put("7", 7);
        convertAlder.put("8", 8);
        convertAlder.put("9", 9);
        convertAlder.put("10", 10);
        convertAlder.put("11", 11);
        convertAlder.put("12", 12);
        convertAlder.put("13", 13);
        convertAlder.put("14", 14);
        convertAlder.put("15", 15);
        convertAlder.put("16", 16);
        convertAlder.put("17", 17);
        convertAlder.put("18", 18);
        convertAlder.put("19", 19);
        convertAlder.put("20", 20);
        convertAlder.put("21", 21);
        convertAlder.put("22", 22);
        convertAlder.put("23", 23);
        convertAlder.put("24", 24);
        convertAlder.put("25", 25);
        convertAlder.put("26", 26);
        convertAlder.put("27", 27);
        convertAlder.put("28", 28);
        convertAlder.put("29", 29);
        convertAlder.put("30", 30);
        convertAlder.put("31", 31);
        convertAlder.put("32", 32);
        convertAlder.put("33", 33);
        convertAlder.put("34", 34);
        convertAlder.put("35", 35);
        convertAlder.put("36", 36);
        convertAlder.put("37", 37);
        convertAlder.put("38", 38);
        convertAlder.put("39", 39);
        convertAlder.put("40", 40);
        convertAlder.put("41", 41);
        convertAlder.put("42", 42);
        convertAlder.put("43", 43);
        convertAlder.put("44", 44);
        convertAlder.put("45", 45);
        convertAlder.put("46", 46);
        convertAlder.put("47", 47);
        convertAlder.put("48", 48);
        convertAlder.put("49", 49);
        convertAlder.put("50", 50);
        convertAlder.put("51", 51);
        convertAlder.put("52", 52);
        convertAlder.put("53", 53);
        convertAlder.put("54", 54);
        convertAlder.put("55", 55);
        convertAlder.put("56", 56);
        convertAlder.put("57", 57);
        convertAlder.put("58", 58);
        convertAlder.put("59", 59);
        convertAlder.put("60", 60);
        convertAlder.put("61", 61);
        convertAlder.put("62", 62);
        convertAlder.put("63", 63);
        convertAlder.put("64", 64);
        convertAlder.put("65", 65);
        convertAlder.put("66", 66);
        convertAlder.put("67", 67);
        convertAlder.put("68", 68);
        convertAlder.put("69", 69);
        convertAlder.put("70", 70);
        convertAlder.put("71", 71);
        convertAlder.put("72", 72);
        convertAlder.put("73", 73);
        convertAlder.put("74", 74);
        convertAlder.put("75", 75);
        convertAlder.put("76", 76);
        convertAlder.put("77", 77);
        convertAlder.put("78", 78);
        convertAlder.put("79", 79);
        convertAlder.put("80", 80);
        convertAlder.put("81", 81);
        convertAlder.put("82", 82);
        convertAlder.put("83", 83);
        convertAlder.put("84", 84);
        convertAlder.put("85", 85);
        convertAlder.put("86", 86);
        convertAlder.put("87", 87);
        convertAlder.put("88", 88);
        convertAlder.put("89", 89);
        convertAlder.put("90", 90);
        convertAlder.put("91", 91);
        convertAlder.put("92", 92);
        convertAlder.put("93", 93);
        convertAlder.put("94", 94);
        convertAlder.put("95", 95);
        convertAlder.put("96", 96);
        convertAlder.put("97", 97);
        convertAlder.put("98", 98);
        convertAlder.put("99", 99);
        convertAlder.put("100", 100);
        convertAlder.put("101", 101);
        convertAlder.put("102", 102);
        convertAlder.put("103", 103);
        convertAlder.put("104", 104);
        convertAlder.put("105", 105);
        convertAlder.put("106", 106);
        convertAlder.put("107", 107);
        convertAlder.put("108", 108);
        convertAlder.put("109", 109);
        convertAlder.put("110", 110);
        convertAlder.put("111", 111);
        convertAlder.put("112", 112);
        convertAlder.put("113", 113);
        convertAlder.put("114", 114);
        convertAlder.put("115", 115);
        convertAlder.put("116", 116);
        convertAlder.put("117", 117);
        convertAlder.put("118", 118);
        convertAlder.put("119", 119);
        convertAlder.put("120", 120);
    }
}
