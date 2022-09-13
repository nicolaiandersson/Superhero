import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Database database = new Database();


        System.out.println("Velkommen til Superhelte-databasen");
        System.out.println("Indtast superheltens navn ");
        String heroName = scan.next();

        System.out.println("Indtast superkræfterne " + heroName + " har ");
        String heroPower = scan.next();

        System.out.println("Hvilket årstal er " + heroName + " skabt?" );
        int creationYear = scan.nextInt();

        System.out.println("Hvad er heltens rigtige navn?");
        String realName = scan.next();

        System.out.println("Er " + heroName +  " menneske?");
        boolean human = scan.nextBoolean();




    }
}
