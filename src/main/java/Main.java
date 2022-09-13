import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        Database database = new Database();

    //velkommen besked
        System.out.println("Velkommen til Superhelte-databasen");

    //menu så brugeren kan starte eller afslutte programmet
        int menuvalg;
        do {
            System.out.println("Tast 1 for at oprette ny superhelt");
            System.out.println("Tast 9 for at afslutte");
            menuvalg = scan.nextInt();

    // programmet startes hvis der tastes 1, så brugeren kan lave en superhelt
            if (menuvalg == 1) {
                System.out.println("Indtast superheltens navn ");
                String heroName = scan.next();

                System.out.println("Indtast superkræfterne " + heroName + " har ");
                String heroPower = scan.next();

                System.out.println("Hvilket årstal er " + heroName + " skabt?");
                int creationYear = scan.nextInt();

                System.out.println("Hvad er heltens rigtige navn?");
                String realName = scan.next();

    //loop til ja/nej om superhelten er menneske eller ej
                boolean human = true;
                char humanStatus;
                do {
                    System.out.println("Er " + heroName + " menneske? (j/n)");
                    humanStatus = scan.next().charAt(0);
                    if (humanStatus == 'j') {
                        human = true;
                    } else if (humanStatus == 'n') {
                        human = false;
                    } else {
                        System.out.println("Ugyldigt. Tast j for ja, eller n for nej");
                    }
                } while (humanStatus != 'j' && humanStatus != 'n');

    //superhelten bliver gemt ved databasen
                database.createSuperhero(realName, heroPower, realName, creationYear, human);

            } else if (menuvalg == 9) {
                System.out.println("Programmet afsluttes");
            }
            for (Superhero superhero : database.getSuperheroes()) {
                System.out.println("Heltenavn: " + superhero.getHeroName());
                System.out.println("Superkræfter: " + superhero.getHeroPower());
                System.out.println("Rigtige navn: " + superhero.getRealName());
                System.out.println("Skabelsesår: " + superhero.getCreationYear());
                System.out.println("Menneske: " + superhero.humanStatus());
            }

        } while (menuvalg != 1 && menuvalg !=9);

        }
    }


