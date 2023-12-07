import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void menu() {
        Scanner sc = new Scanner(System.in);

        Klub klub = new Klub();
        Resultater resultater = new Resultater();
        while (true) {
            System.out.println("Hovedmenu"); //hovedmenu
            System.out.println("1. Medlem");
            System.out.println("2. Klub & Hold");
            System.out.println("3. Stævne");
            System.out.println("4. Resultat");
            System.out.println("0. For at afslutte program");

            try {
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
                            System.out.println("5. Afbetal Restance");
                            System.out.println("6. Slet medlem");
                            System.out.println("0. Tilbage");
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
                                        System.out.println("1. Konkurrencehold / 2. Motionhold "); // alt information om et nytoprettet medlem skrives ind i denne metode.
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
                                        System.out.println("Søg medlem med navn"); //listen af medlemmer gennemkigges og sorteres for navn, i metoden soegMedlemNavn
                                        String navn1 = sc.next();
                                        klub.soegMedlemNavn(navn1);
                                        break;
                                    case 3:
                                        System.out.println("Indtast medlemsID:");   //listen af medlemmer gennemkigges og sorteres efter medlemsid, i metoden soegMedlemID
                                        int medlemID = sc.nextInt();                // metoden returnere medlemsobjektet som den finder.
                                        Medlem midlertidigtmedlem = klub.soegMedlemID(medlemID);
                                        if (midlertidigtmedlem != null) {
                                            System.out.println(midlertidigtmedlem + "\n");
                                        } else
                                            System.out.println("Intet medlem fundet.\n");
                                        break;
                                    case 4:
                                        System.out.println("Indtast medlemsID:");
                                        int medlemID1 = sc.nextInt();
                                        Medlem midlertidigtmedlem1 = klub.soegMedlemID(medlemID1); //søger efter medlem via medlemsid
                                        if (midlertidigtmedlem1 != null) {
                                            System.out.println(midlertidigtmedlem1 + "\n");
                                            if (midlertidigtmedlem1.aktivitetsStatus) {
                                                System.out.println("Vil du ændre medlemsstatus til passivt medlemsskab?");
                                                System.out.println("1. Ja");
                                                System.out.println("2. Nej");
                                                int op4 = sc.nextInt();
                                                if (op4 == 1) {
                                                    midlertidigtmedlem1.aktivitetsStatus = false;
                                                    midlertidigtmedlem1.saetKontigent(midlertidigtmedlem1.aktivitetsStatus, midlertidigtmedlem1.alder);
                                                } else break;
                                            } else {
                                                System.out.println("Vil du ændre medlemsstatus til aktivt medlemsskab?"); // ændre aktivitetsstatus alt efter hvad den nuværende er.
                                                System.out.println("1. Ja");
                                                System.out.println("2. Nej");
                                                int op4 = sc.nextInt();
                                                if (op4 == 1) {
                                                    midlertidigtmedlem1.aktivitetsStatus = true;
                                                    midlertidigtmedlem1.saetKontigent(midlertidigtmedlem1.aktivitetsStatus, midlertidigtmedlem1.alder);
                                                } else break;
                                            }
                                        } else
                                            System.out.println("Intet medlem fundet.\n");
                                        break;
                                    case 5:
                                        System.out.println("Indtast medlemID: ");
                                        int medlemID3 = sc.nextInt();
                                        Medlem midlertidigtmedlem3 = klub.soegMedlemID(medlemID3);
                                        System.out.println("Gennemfør afbetaling af restance?");
                                        System.out.println("1. Ja");
                                        System.out.println("2. Nej");
                                        int op5 = sc.nextInt();
                                        if (op5 == 1) {
                                            midlertidigtmedlem3.betalKontingent();
                                        }
                                        break;
                                    case 6:
                                        System.out.println("Indtast medlemsID:");
                                        int medlemID2 = sc.nextInt();
                                        Medlem midlertidigtmedlem2 = klub.soegMedlemID(medlemID2); //fjerner medlem fra listen af medlemmer, fundet via. medlemsid.
                                        klub.KlubMedlemmer.remove(midlertidigtmedlem2);
                                }
                            } catch (InputMismatchException ie) {
                                System.out.println("\nForkert input. Prøv igen\n");
                                sc.next();
                            }

                        }
                        break;
                    case 2:
                        while (true) {
                            System.out.println("\nKlub & Hold");
                            System.out.println("1. Print hold: ");
                            System.out.println("2. Print alle medlemmer: ");
                            System.out.println("3. Print medlemmer i restance: ");
                            System.out.println("0. Tilbage");

                            try {
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
                            } catch (InputMismatchException ie) {
                                System.out.println("\nForkert input. Prøv igen\n");
                                sc.next();
                            }
                        }
                        break;
                    case 3:
                        while (true) {
                            System.out.println("\nStævne");
                            System.out.println("1. Opret stævne: ");
                            System.out.println("2. Tilføj resultat til stævne");
                            System.out.println("3. Print alle resultater for stævne");
                            System.out.println("0. Tilbage");

                            try {
                                int op03 = sc.nextInt();
                                if (op03 == 0) {
                                    break;
                                }

                                switch (op03) {
                                    case 1:
                                        System.out.println("Indtast stævnenavn:");
                                        String stævnenavn = sc.next();

                                        System.out.println("Indtast dato (dd.MM.yyyy): ");
                                        String dato = sc.next();

                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                                        LocalDate newDato = LocalDate.parse(dato, dtf);
                                        klub.opretStævne(stævnenavn, newDato);
                                        break;
                                    case 2:
                                        System.out.println("Vælg stævne:");
                                        int n = 1;
                                        for (Stævne stævner : klub.stævneliste) {
                                            System.out.println(n + ". " + stævner.stævneNavn);
                                            n++;
                                        }
                                        int op5 = sc.nextInt();
                                        Stævne midlertidigtStævne = klub.stævneliste.get(op5 - 1);

                                        System.out.println("\nIndtast medlemsID: ");
                                        int id = sc.nextInt();
                                        Medlem tempMedlem = klub.soegMedlemID(id);

                                        Disciplin valgtDisciplin;
                                        while (true) {

                                            System.out.println("\nVælg disciplin ");
                                            System.out.println("1. Bryst");
                                            System.out.println("2. Ryg");
                                            System.out.println("3. Butterfly");
                                            int dis = sc.nextInt();


                                            switch (dis) {
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
                                                    System.out.println("\nForkert valg, prøv igen\n");
                                                    continue;
                                            }
                                            break;
                                        }

                                        System.out.println("\nIndtast opnået tid i sekunder:");
                                        double tidopnået = sc.nextDouble();

                                        System.out.println("\nIndtast opnået placering: ");
                                        int placering = sc.nextInt();

                                        midlertidigtStævne.tilfoejResultat(valgtDisciplin, tempMedlem, tidopnået, placering);
                                        resultater.tilfoejResultat(valgtDisciplin, tempMedlem.medlemsID, tempMedlem.navn, tidopnået, midlertidigtStævne.stævneDato);
                                        System.out.println("\nDet opnåede resultat er tilføjet til stævnet.\n");
                                        break;
                                    case 3:
                                        System.out.println("\nVælg stævne:");
                                        int m = 1;
                                        for (Stævne stævner : klub.stævneliste) {
                                            System.out.println(m + ". " + stævner.stævneNavn);
                                            m++;
                                        }
                                        int op6 = sc.nextInt();
                                        Stævne midlertidigtStævne1 = klub.stævneliste.get(op6 - 1);

                                        for (Resultat resultat : midlertidigtStævne1.resultats) {
                                            System.out.println("\n" + resultat);
                                        }
                                        break;
                                }
                            } catch (InputMismatchException ie) {
                                System.out.println("\nForkert input. Prøv igen");
                                sc.next();
                            }
                        }
                        break;
                    case 4:
                        while (true) {
                            System.out.println("\nResultat");
                            System.out.println("1. Opret resultat");
                            System.out.println("2. Print alle resultater");
                            System.out.println("3. Print top 5 for disciplin");
                            System.out.println("4. Slet resultat");
                            System.out.println("0. Tilbage");

                            try {
                                int op04 = sc.nextInt();
                                if (op04 == 0) {
                                    break;
                                }
                                switch (op04) {
                                    case 1:
                                        System.out.println("Opret resultat");
                                        System.out.println("Indtast medlemsID: ");
                                        int id = sc.nextInt();
                                        Medlem tempMedlem = klub.soegMedlemID(id);
                                        // check om id er validt

                                        boolean disciplinFlag = true;
                                        Disciplin valgtDisciplin = null;
                                        while (disciplinFlag) {

                                            System.out.println("Vælg disciplin ");
                                            System.out.println("1. Bryst");
                                            System.out.println("2. Ryg");
                                            System.out.println("3. Butterfly");
                                            int dis = sc.nextInt();


                                            switch (dis) {
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
                                        System.out.println("Indtast opnået tid i sekunder:");
                                        double tidopnået = sc.nextDouble();

                                        System.out.println("Indtast en dato (dd.mm.yyyy): ");
                                        String dato = sc.next();
                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                                        LocalDate newDato = LocalDate.parse(dato, dtf);

                                        resultater.tilfoejResultat(valgtDisciplin, tempMedlem.medlemsID, tempMedlem.navn, tidopnået, newDato);
                                        break;
                                    case 2:
                                        for (Resultat res : resultater.resultatListe) {
                                            System.out.println(res);
                                        }
                                        break;
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
                            } catch (InputMismatchException ie) {
                                System.out.println("\nForkert input. Prøv igen");
                                sc.next();
                            }
                        }
                        break;
                }
            } catch (InputMismatchException ie) {
                System.out.println("\nForkert input. Prøv igen\n");
                sc.next();
            }
        }
    }
}