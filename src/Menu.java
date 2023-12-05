import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {
    // her er vores menu

    public void menu() {
        Scanner sc = new Scanner(System.in);

        Klub klub = new Klub();
        Resultater resultater = new Resultater();
        while (true) {
            System.out.println("Hovedmenu");
            System.out.println("1. Medlem");
            System.out.println("2. Klub & Hold");
            System.out.println("3. Stævne");
            System.out.println("4. Resultat");

            int op = sc.nextInt();
            if (op == 0) {
                break;
            }


            switch (op) {
                case 1:
                    while (true) {
                        System.out.println("Medlem");
                        System.out.println("1. Opret medlem");
                        System.out.println("2. Søg medlem med navn");
                        System.out.println("3. Søg medlem med medlemID");
                        System.out.println("4. Ændre medlemsstatus");

                        int op1 = sc.nextInt();
                        if (op1 == 0) {
                            break;
                        }

                        switch (op1) {
                            case 1:
                                System.out.println("Opret medlem");
                                System.out.println("Indtast navn: ");
                                String navn = sc.nextLine();
                                System.out.println("Indtast alder: ");
                                int alder = sc.nextInt();
                                System.out.println("Vælg hold: ");
                                System.out.println("1. Konkurrencehold / 2. Motionhold ");
                                int op2 = sc.nextInt();
                                boolean hold = true;
                                if (op2 == 1) {
                                    hold = true;
                                } else if (op2 == 2) {
                                    hold = false;
                                }
                                System.out.println("Vælg aktivitisstatus");
                                System.out.println("1. Aktivt / 2. Passivt ");
                                int op3 = sc.nextInt();
                                boolean erAktiv = true;
                                if (op3 == 1) {
                                    erAktiv = true;
                                } else if (op3 == 2) {
                                    erAktiv = false;
                                }
                                klub.opretMedlem(navn, alder, hold, erAktiv);
                                break;
                            case 2:
                                System.out.println("Søg medlem med navn");
                                String navn1 = sc.nextLine();
                                klub.soegMedlemNavn(navn1);
                                break;
                            case 3:
                                System.out.println("Søg medlem med medlemID");
                                int medlem1 = sc.nextInt();
                                klub.soegMedlemID(medlem1);
                                break;
                            case 4:
                                System.out.println("Ændre medlemsstatus");


                                //JH fikser medlemsstatus - medlemID skal vælge medlem


                                break;
                        }
                    }

                case 2:
                    while (true) {
                        System.out.println("Klub & Hold");
                        System.out.println("1. Print hold: ");
                        System.out.println("2. Print alle medlemmer: ");
                        System.out.println("3. Print medlemmer i restance: ");

                        int op02 = sc.nextInt();
                        if (op02 == 0) {
                            break;
                        }

                        switch (op02) {
                            case 1:
                                System.out.println("Vælg hold: ");
                                System.out.println("1. Konkurrencehold / 2. Motionhold ");
                                int op2 = sc.nextInt();
                                boolean hold = true;
                                if (op2 == 1) {
                                    hold = true;
                                } else if (op2 == 2) {
                                    hold = false;
                                }
                                klub.soegHold(hold);
                                break;

                            case 2:
                                klub.udskrivMedlemmer();
                                break;

                            case 3:
                                klub.checkListForRestance(klub.KlubMedlemmer);
                                break;
                        }
                    }
                case 3:
                    while (true) {
                        System.out.println("Stævne");
                        System.out.println("1.  Opret stævne: ");
                        System.out.println("2.  Tilføj resultat til stævne");

                        int op03 = sc.nextInt();
                        if (op03 == 0) {
                            break;
                        }

                        switch (op03) {
                            case 1:
                                System.out.println("Indtast stævnenavn:");
                                String stævnenavn = sc.nextLine();
                                System.out.println("Enter a date (yyyy.mm.dd): ");
                                String dato = sc.nextLine();
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.mm.dd");
                                LocalDate newDato = LocalDate.parse(dato, dtf);
                                klub.opretStævne(stævnenavn, newDato);
                                break;
                        }
                    }
                case 4:
                    while (true) {
                        System.out.println("Resultat");
                        System.out.println("1. Opret resultat");
                        System.out.println("2. Print alle resultater");
                        System.out.println("3. Print top5 for disciplin");

                        int op04 = sc.nextInt();
                        if (op04 == 0) {
                            break;
                        }
                        switch (op04) {
                        //    case 1:
                          //      resultater.tilfoejResultat();

                            case 2:
                                for (Resultat res : resultater.resultatListe){
                                    System.out.println(res);
                                    break;
                                }
                            case 3:
                                for (Resultat resultat : resultater.Findtop5forDiciplin(Disciplin.RYG)) {
                                    System.out.println(resultat);
                                }
                                for (Resultat resultat : resultater.Findtop5forDiciplin(Disciplin.BRYST)) {
                                    System.out.println(resultat);
                                }
                                for (Resultat resultat : resultater.Findtop5forDiciplin(Disciplin.BUTTERFLY)) {
                                    System.out.println(resultat);
                                }
                                break;

                        }
                    }

            }
        }
    }
}