import java.util.ArrayList;

public class Database {
    ArrayList<Superhero> superheroes = new ArrayList<>();

    public void createSuperhero(String heroName, String heroPower, String realName, int creationYear, boolean human){
        Superhero hero = new Superhero(heroName, heroPower, realName, creationYear, human);
        superheroes.add(hero);
    }
}
