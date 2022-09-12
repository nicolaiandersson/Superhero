import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String heroName;
        String heroPower;
        String realName;
        int creationYear;
        boolean human;

        System.out.println("Velkommen til Superhelte-databasen");
        System.out.println("Indtast superheltens navn ");
        heroName = scan.next();

        System.out.println("Indtast superkræfterne " + heroName + " har ");
        heroPower = scan.next();

        System.out.println("Hvilket årstal er " + heroName + " skabt?" );
        creationYear = scan.nextInt();

        System.out.println("Er " + heroName +  " menneske?");
        human = scan.nextBoolean();


        Superhero superheroes = new Superhero();


    }
}
