import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Main program = new Main();
        program.start();
    }
    public void start(){
        udskrivVelkomst();
    }

        Scanner scan = new Scanner(System.in);
        Database database = new Database();

    public void udskrivVelkomst() {
        System.out.println("Velkommen til Superhelte-databasen");
    }

    public void createSuperhero(){
        System.out.println("Indtast superheltens navn ");
        String heroName = scan.next();

        System.out.println("Indtast superkræfterne " + heroName + " har ");
        String heroPower = scan.next();

        System.out.println("Hvilket årstal er " + heroName + " skabt?" );
        int creationYear = scan.nextInt();

        System.out.println("Hvad er heltens rigtige navn?");
        String realName = scan.next();

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

        database.createSuperhero(realName,heroPower,realName,creationYear,human);
        udskrivVelkomst();
    }
}

