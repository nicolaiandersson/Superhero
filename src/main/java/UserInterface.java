import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class UserInterface {


    private Scanner scan = new Scanner(System.in);
    private Database database = new Database();


    //programmet startes
    public void start() {
        //velkommen besked
        System.out.println("Velkommen til Superhelte-databasen");
        menu();
    }

    //programmet lader brugeren vælge en metode fra menuen
    public void menu() {
        int menuvalg = 0;
        boolean error = false;
        do {
            System.out.println("Tast 1 for at oprette ny superhelt");
            System.out.println("Tast 2 for at se listen af superhelte");
            System.out.println("Tast 3 for at søge på en superhelt");
            System.out.println("Tast 4 for at redigere en gemt superhelt");
            System.out.println("Tast 9 for at afslutte");
            try {
                menuvalg = scan.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Du skal taste et tal fra menuen, prøv igen");
                error = true;
                scan.nextLine();
            }
            if (menuvalg == 1) {
                createHero();
            } else if (menuvalg == 2) {
                printHeroes();
            } else if (menuvalg == 3) {
                searchHero();
            } else if (menuvalg == 4) {
                editHero();
            } else if (menuvalg == 9) {
                System.out.println("Programmet afsluttes");
            }
            //loopet er i gang så længe brugeren ikke har tastet 9
        } while (menuvalg != 9 && (error));
        menu();
    }

    //programmet lader brugeren skabe en superhelt
    public void createHero() {
        System.out.println("Indtast superheltens navn ");
        String heroName = scan.next();

        System.out.println("Indtast superkræfterne " + heroName + " har ");
        String heroPower = scan.next();

        System.out.println("Hvilket årstal er " + heroName + " skabt?");
        int creationYear = 0;
        boolean error = false;
        do {
            try {
                creationYear = scan.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Du skal skrive et årstal, prøv igen");
                error = true;
                scan.nextLine();
            }
        } while (error);


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
        //brugeren vælger hvilken metode programmet skal starte
    }

    //programmet printer listen af skabte superhelte
    public void printHeroes() {
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

    //programmet printer den superhelt brugeren søger på
    public void searchHero() {
        System.out.println("Søg på en superhelt: ");
        scan.nextLine();
        String searchTerm = scan.nextLine();
        ArrayList<Superhero> searchResults = database.searchFor(searchTerm);

        int index = 1;
        if (searchResults.isEmpty()) {
            System.out.println("Superhelt ikke fundet, prøv igen");
            searchHero();
        } else {
            for (Superhero searchResult : searchResults) {
                System.out.println(index++ + ": " + searchResult.getHeroName());
            }
            System.out.println("Tast det tal der står før navnet på den superhelt du vil redigere, og tryk enter: ");
            int userChoice = 1;
            boolean error = true;

            do {
                try {
                    userChoice = Integer.parseInt(scan.nextLine());
                    error = false;
                    System.out.println("Heltenavn: " + searchResults.get(userChoice - 1).getHeroName());
                    System.out.println("Superkræfter: " + searchResults.get(userChoice - 1).getHeroPower());
                    System.out.println("Rigtige navn: " + searchResults.get(userChoice - 1).getRealName());
                    System.out.println("Skabelsesår: " + searchResults.get(userChoice - 1).getCreationYear());
                    System.out.println("Menneske: " + searchResults.get(userChoice - 1).humanStatus());

                } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Prøv igen");
                    error = true;
                    scan.nextLine();
                }
            } while (error == true);
            menu();
        }
    }

    //programmet lader brugeren redigere en skabt superhelt
    public void editHero() {
            System.out.println("Søg på den superhelt du vil redigere: ");
            String searchTerm = scan.nextLine();
            ArrayList<Superhero> searchResults = database.searchFor(searchTerm);

            if (searchResults.isEmpty()) {
                System.out.println("Superhelt ikke fundet. prøv igen");
                editHero();
            } else {
                int index = 1;
                for (Superhero searchResult : searchResults) {
                     System.out.println(index++ + ": " + searchResult.getHeroName());
                }
                int userChoice = 1;
                boolean error = true;

                    userChoice = Integer.parseInt(scan.nextLine());
                    Superhero editHero = searchResults.get(userChoice - 1);
                    System.out.println("Rediger " + editHero.getHeroName());
                    System.out.println("---------------------------");
                    System.out.println("Indtast nyt heltenavn: ");
                    String changeHeroName = scan.nextLine();
                    if (!changeHeroName.isEmpty()) {
                        editHero.editHeroName(changeHeroName);
                    }
                    System.out.println("Indtast nye superkræfter: ");
                    String changeHeroPower = scan.nextLine();
                    if (!changeHeroPower.isEmpty()) {
                        editHero.editHeroPower(changeHeroPower);
                    }
                    System.out.println("Indtast nyt rigtigt navn: ");
                    String changeRealName = scan.next();
                    if (!changeRealName.isEmpty()) {
                        editHero.editRealName(changeRealName);
                    }
                    System.out.println("Indtast nyt skabelsesår: ");
                    do {
                        try {
                            String changeCreationYear = scan.nextLine();
                            if (!changeCreationYear.isEmpty()) {
                                editHero.editCreationYear(changeCreationYear);
                            }
                            error = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Du skal skrive et årstal, prøv igen");
                            error = true;
                        }
                    } while (error == true);
                    scan.nextLine();
                    System.out.println("Indtast ny menneskestatus (j/n): ");
                    String changeHumanStatus = scan.next();
                    if (!changeHumanStatus.isEmpty()) {
                        editHero.editHumanStatus(changeHumanStatus);
                    }
                System.out.println("Superhelten er gemt");
                System.out.println("---------------------------");
                menu();
            }
        }
    }




