
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class Main {

    public static int pouzeCelaCisla(Scanner sc)
    {
        int cislo;
        try
        {
            cislo = sc.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("Nastala vyjimka typu "+ e);
            System.out.println("zadejte prosim cele cislo ");
            sc.nextLine();
            cislo = pouzeCelaCisla(sc);
        }
        return cislo;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc=new Scanner(System.in);
        TheDatabaze mojeDatabaze=new TheDatabaze();
        Hodnocenifilmosu hodko=new Hodnocenifilmosu();
        int volba;

        String jmeno;
        boolean hranyfilm = true;
        String rejza;
        int rok;
        int vek = 0;
        int countHercu;
        String[] trojani = new String[10];
        String [] hvezdicky = new String[10];
        int[] bodiky = new int[10];
        String [] recenzi = new String[10];

        boolean run=true;
        while(run)
        {
            System.out.println("Vyberte pozadovanou cinnost:");
            System.out.println("1 ... vlozeni noveho filmu"); //Done
            System.out.println("2 ... uprav info o filmu");
            System.out.println("3 ... odstraneni studenta "); //Done
            System.out.println("4 ... napsat hodnoceni filmu");
            System.out.println("5 ... vypis vsech filmu z databaze");
            System.out.println("6 ... vypsat informace o konkretnim filmu");
            System.out.println("7 ... Vypsat hodne angazovane herce");
            System.out.println("8 ... Vypsat filmy s hercem");
            System.out.println("9 ... Ulozeni filmu do souboru");
            System.out.println("10 ... Nacteni filmu ze souboru");
            System.out.println("11 ... ukonceni aplikace");

            volba=pouzeCelaCisla(sc);
            switch(volba) {


                case 1:
                    System.out.println("Zadejte jmeno filmu:");
                    jmeno = sc.next();
                    System.out.println("Je film hrany(ano/ne)? ");
                    if (sc.next().equals("ano"))
                        hranyfilm = true;
                    else
                        hranyfilm = false;
                    System.out.println("Zadejte jmeno rezisera:");
                    rejza = sc.next();
                    System.out.println("Zadejte rok vydani:");
                    rok = Main.pouzeCelaCisla(sc);
                    if (hranyfilm) {
                        System.out.println("Zadejte pocet hercu:");
                        countHercu = Main.pouzeCelaCisla(sc);
                        for (int i = 0; i < countHercu; i++) {
                            System.out.println("Zadejte jmeno herce: ");
                            trojani[i] = sc.next();
                        }
                    } else {
                        System.out.println("Zadejte doporuceny vek divaka:");
                        vek = Main.pouzeCelaCisla(sc);
                        System.out.println("Zadejte pocet animatoru:");
                        countHercu = Main.pouzeCelaCisla(sc);
                        for (int i = 0; i < countHercu; i++) {
                            System.out.println("Zadejte jmeno animatora: ");
                            trojani[i] = sc.next();
                        }
                    }

                    hvezdicky[0] = "Zatim zadne hodnoceni";
                    recenzi[0] = "Zatim zadne hodnoceni";

                    if (!mojeDatabaze.setFilmHrany(jmeno, hranyfilm, rejza, rok, vek, countHercu, trojani, hvezdicky, recenzi))
                        System.out.println("Film v databazi jiz existuje");
                    break;

                case 2:
                    System.out.println("Zadejte jmeno filmu:");
                    jmeno = sc.next();
                    System.out.println("Co si prejete upravit:");
                    System.out.println("1 ... jmeno filmu"); //Done
                    System.out.println("2 ... jmeno rezisera");
                    System.out.println("3 ... rok vydani"); //Done
                    FilmHrany info = null;
                    info = mojeDatabaze.getFilmHrany(jmeno);
                    volba = pouzeCelaCisla(sc);
                    switch (volba) {
                        case 1:
                            if (info != null) {
                                System.out.println(" Nove jmeno filmu: ");
                                info.setJmeno(sc.next());
                            }
                            break;
                        case 2:
                            if (info != null) {
                                System.out.println(" Nove jmeno rezisera: ");
                                info.setReziser(sc.next());
                            }
                            break;
                        case 3:
                            if (info != null) {
                                System.out.println(" Novy rok vydani: ");
                                info.setRokVydani(sc.nextInt());
                            }
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Zadejte jmeno filmu k odstraneni");
                    jmeno = sc.next();
                    if (mojeDatabaze.vymazFilm(jmeno))
                        System.out.println(jmeno + " odstranen ");
                    else
                        System.out.println(jmeno + " neni v databazi ");
                    break;

                case 4:
                    System.out.println("Zadejte jmeno filmu:");
                    jmeno = sc.next();
                    info = mojeDatabaze.getFilmHrany(jmeno);
                    if (info != null) {
                        if (info.getHrany()) {
                            System.out.println("Zadej hvezdicky (1-5):");
                            hvezdicky[0] = (sc.next());
                            if (!hodko.setHodnoceniFilmu(jmeno, hvezdicky))
                                System.out.println("Film jiz byl ohodnocen");
                            break;
                        } else {
                            System.out.println("Zadej pocet bodu (1-10): ");
                            bodiky[0] = (sc.nextInt());
                            if (!hodko.setHodnoceniAnimaku(jmeno, bodiky))
                                System.out.println("Film jiz byl ohodnocen");
                            break;
                        }
                    }

                case 5:
                    mojeDatabaze.vypisDatabaze();
                    hodko.vypisHodnoceni();
                    break;

                case 6:
                    System.out.println("Zadejte jmeno filmu");
                    jmeno = sc.next();
                    info = mojeDatabaze.getFilmHrany(jmeno);
                    if (info != null) {
                        if (info.getHrany()) {
                            System.out.println("Jmeno: " + info.getJmeno() + " Reziser: " + info.getReziser() + " rok vydani: " + info.getRokVydani());
                            System.out.println(" Herci: ");
                            for (int i = 0; i < info.getPocetHercu(); i++) {
                                System.out.println(info.getHerci(i));
                            }
                        } else {
                            System.out.println("Jmeno: " + info.getJmeno() + " Reziser: " + info.getReziser() + " rok vydani: " + info.getRokVydani() + " Doporuceny vek: " + info.getVekDivaka());
                            System.out.println(" Animatori: ");
                            for (int i = 0; i < info.getPocetHercu(); i++) {
                                System.out.println(info.getHerci(i));
                            }
                        }
                    } else
                        System.out.println("Vybrana polozka neexistuje");
                    break;


                case 8:
                    System.out.println("Zadejte jmeno filmu, ktery chcete ohodnotit:");
                    jmeno = sc.next();
                    info = mojeDatabaze.getFilmHrany(jmeno);
                    if (info.getHrany() == true) {
                        System.out.println("Zadejte pocet hvezdicek (1-5):");

                    } else {
                        System.out.println("Jmeno: " + info.getJmeno() + " Reziser: " + info.getReziser() + " rok vydani: " + info.getRokVydani() + " Doporuceny vek: " + info.getVekDivaka());
                        System.out.println(" Animatori: ");
                        for (int i = 0; i < info.getPocetHercu(); i++) {
                            info.getHerci(i);
                            System.out.println(" ");
                        }
                    }
                    break;

                case 9:
                    System.out.println("Zadejte jmeno filmu");
                    jmeno = sc.next();
                    info = mojeDatabaze.getFilmHrany(jmeno);
                    FileWriter writer = new FileWriter("soubor.txt");
                    if (info != null) {
                        if (info.getHrany()) {
                            try {
                                writer.write("Jmeno: " + info.getJmeno() + " Reziser: " + info.getReziser() + " rok vydani: " + info.getRokVydani());  // zapíšeme data do souboru
                                writer.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                            writer.write("Jmeno: " + info.getJmeno() + " Reziser: " + info.getReziser() + " rok vydani: " + info.getRokVydani() + " Doporuceny vek: " + info.getVekDivaka());  // zapíšeme data do souboru
                            writer.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                        break;
                        case 11:
                            run = false;
                            break;
                    }

            }
    }

}
