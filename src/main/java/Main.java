import java.util.Scanner;
public class Main {

    Scanner scan = new Scanner(System.in);
    Database database = new Database();

    public static void main(String[] arg) {
        Main program = new Main();
        program.start();
    }

    public void start() {
        //velkommen besked
        System.out.println("Velkommen til Superhelte-databasen");
        createSuperhero();
    }


    public void createSuperhero() {
        //menu så brugeren kan starte eller afslutte programmet
        int menuvalg;
        do {
            System.out.println("Tast 1 for at oprette ny superhelt");
            System.out.println("Tast 2 for at se listen af superhelte");
            System.out.println("Tast 3 for at søge på en superhelt");
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
                database.createSuperhero(heroName, heroPower, realName, creationYear, human);

            } else if (menuvalg == 2) {
                printSuperheroes();
            } else if (menuvalg == 3) {
                searchHero();
            } else if (menuvalg == 9) {
                System.out.println("Programmet afsluttes");
            }

        } while (menuvalg != 9);

    }

    public void printSuperheroes() {
        System.out.println("Liste af superhelte:");
        System.out.println("---------------------------");
        for (Superhero superhero : database.getSuperheroes()) {
            System.out.println("Heltenavn: " + superhero.getHeroName());
            System.out.println("Superkræfter: " + superhero.getHeroPower());
            System.out.println("Rigtige navn: " + superhero.getRealName());
            System.out.println("Skabelsesår: " + superhero.getCreationYear());
            System.out.println("Menneske: " + superhero.humanStatus());
            System.out.println("---------------------------");
        }

    }

    public void searchHero() {
        for (Superhero superhero : database.getSuperheroes()) {
            System.out.println("Søg på en superhelt: ");
            String searchTerm = scan.next();
            Superhero found = database.searchFor(searchTerm);
            if (found == null) {
                System.out.println("Superhelt ikke fundet");
            } else {
                System.out.println("---------------------------");
                System.out.println("Heltenavn: " + found.getHeroName());
                System.out.println("Superkræfter: " + found.getHeroPower());
                System.out.println("Rigtige navn: " + found.getRealName());
                System.out.println("Skabelsesår: " + found.getCreationYear());
                System.out.println("Menneske: " + found.humanStatus());
                System.out.println("---------------------------");
            }
        }
    }
}


