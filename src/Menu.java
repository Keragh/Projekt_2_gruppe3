import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
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
            System.out.println("0. for at afslutte program");

            int op = sc.nextInt();
            if (op == 0) {
                break;
            }


            switch (op) {
                case 1:
                    while (true) {

                        int op1;
                        System.out.println("Medlem");
                        System.out.println("1. Opret medlem");
                        System.out.println("2. Søg medlem med navn");
                        System.out.println("3. Søg medlem med medlemID");
                        System.out.println("4. Ændre medlemsstatus");
                        try {
                        op1 = sc.nextInt();



                            if (op1 == 0) {
                                break;
                            }

                            switch (op1) {
                                case 1:
                                    System.out.println("Opret medlem");
                                    System.out.println("Indtast navn: ");
                                    String navn = sc.next();
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
                                    String navn1 = sc.next();
                                    klub.soegMedlemNavn(navn1);
                                    break;
                                case 3:
                                    System.out.println("Indtast medlemsID:");
                                    int medlemID = sc.nextInt();
                                    Medlem midlertidigtmedlem = klub.soegMedlemID(medlemID);
                                    if (midlertidigtmedlem != null) {
                                        System.out.println(midlertidigtmedlem+"\n");
                                    }
                                    else
                                        System.out.println("Intet medlem fundet.\n");
                                    break;
                                case 4:
                                    System.out.println("Indtast medlemsID:");
                                    int medlemID1 = sc.nextInt();
                                    Medlem midlertidigtmedlem1 = klub.soegMedlemID(medlemID1);
                                    if (midlertidigtmedlem1 != null) {
                                        System.out.println(midlertidigtmedlem1+"\n");
                                        if (midlertidigtmedlem1.aktivitetsStatus) {
                                            System.out.println("Vil du ændre medlemsstatus til passivt medlemsskab?");
                                            System.out.println("1. Ja");
                                            System.out.println("2. Nej");
                                            int op4 = sc.nextInt();
                                            if (op4 == 1) {
                                                midlertidigtmedlem1.aktivitetsStatus = false;
                                            }
                                            else break;
                                        }
                                        else {
                                            System.out.println("Vil du ændre medlemsstatus til aktivt medlemsskab?");
                                            System.out.println("1. Ja");
                                            System.out.println("2. Nej");
                                            int op4 = sc.nextInt();
                                            if (op4 == 1) {
                                                midlertidigtmedlem1.aktivitetsStatus = true;
                                            }
                                            else break;
                                        }
                                    }
                                    else
                                        System.out.println("Intet medlem fundet.\n");
                                    break;
                            }
                        } catch (InputMismatchException ie) {
                            System.out.println("Forkert input. Prøv igen");
                            sc.next();
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
                        System.out.println("1. Opret stævne: ");
                        System.out.println("2. Tilføj resultat til stævne");
                        System.out.println("3. Print alle resultater for stævne");

                        int op03 = sc.nextInt();
                        if (op03 == 0) {
                            break;
                        }

                        switch (op03) {
                            case 1:
                                System.out.println("Indtast stævnenavn:");
                                String stævnenavn = sc.nextLine(); // <-- dette er bugget - skipper stævnenavn direkte til dato.

                                System.out.println("Enter a date (dd.MM.yyyy): ");
                                String dato = sc.nextLine();

                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                                LocalDate newDato = LocalDate.parse(dato, dtf);
                                klub.opretStævne(stævnenavn, newDato);
                                break;
                            case 2:
                                System.out.println("Vælg stævne:");
                                int n = 1;
                                for (Stævne stævner : klub.stævneliste) {
                                    System.out.println(n+"."+stævner.stævneNavn);
                                    n++;
                                }
                                int op5 = sc.nextInt();
                                Stævne midlertidigtStævne = klub.stævneliste.get(op5-1);
                                System.out.println("Opret opnåede resultat: \n");

                                System.out.println("Indtast medlemsid: ");
                                int id = sc.nextInt();
                                Medlem tempMedlem = klub.soegMedlemID(id);

                                Disciplin valgtDisciplin = null;
                                while(true) {

                                    System.out.println("Vælg disciplin ");
                                    System.out.println("1. Bryst");
                                    System.out.println("2. Ryg");
                                    System.out.println("3. Butterfly");
                                    int dis = sc.nextInt();


                                    switch (dis){
                                        case 1:
                                            valgtDisciplin = Disciplin.BRYST;
                                            break;
                                        case 2:
                                            valgtDisciplin = Disciplin.RYG;
                                            break;
                                        case 3:
                                            valgtDisciplin = Disciplin.BUTTERFLY;
                                            break;
                                        default:
                                            System.out.println("Forkert valg, prøv igen");
                                            continue;
                                    }
                                    break;
                                }

                                System.out.println("Indtast opnået tid");
                                double tidopnået = sc.nextDouble();

                                midlertidigtStævne.tilfoejResultat(valgtDisciplin, tempMedlem, tidopnået);

                                System.out.println("Det opnåede resultat er tilføjet til stævnet.");
                            case 3:
                                System.out.println("Vælg stævne:");
                                int m = 1;
                                for (Stævne stævner : klub.stævneliste) {
                                    System.out.println(m+"."+stævner.stævneNavn);
                                    m++;
                                }
                                int op6 = sc.nextInt();
                                Stævne midlertidigtStævne1 = klub.stævneliste.get(op6-1);

                                for (Resultat resultat : midlertidigtStævne1.resultats) {
                                    System.out.println(resultat);
                                }
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
                            case 1:
                                System.out.println("Opret resultat");
                                System.out.println("Indtast medlemsid: ");
                                int id = sc.nextInt();
                                // check om id er validt

                                boolean disciplinFlag = true;
                                Disciplin valgtDisciplin = null;
                                while(disciplinFlag) {

                                    System.out.println("Vælg disciplin ");
                                    System.out.println("1. Bryst");
                                    System.out.println("2. Ryg");
                                    System.out.println("3. Butterfly");
                                    int dis = sc.nextInt();


                                    switch (dis){
                                        case 1:
                                            valgtDisciplin = Disciplin.BRYST;
                                            break;
                                        case 2:
                                            valgtDisciplin = Disciplin.RYG;
                                            break;
                                        case 3:
                                            valgtDisciplin = Disciplin.BUTTERFLY;
                                            break;
                                        default:
                                            System.out.println("Forkert valg, prøv igen");
                                            continue;
                                    }
                                    disciplinFlag = false;
                                }
                                System.out.println("Indtast opnået tid");
                                double tidopnået = sc.nextDouble();

                                System.out.println("Indtast en dato (dd.mm.yyyy): ");
                                String dato = sc.next();
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                                LocalDate newDato = LocalDate.parse(dato, dtf);

                                resultater.tilfoejResultat(valgtDisciplin, id, tidopnået, newDato);

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