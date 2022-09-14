import java.util.ArrayList;
public class Database {
    ArrayList<Superhero> superheroes = new ArrayList<>();

    public void createSuperhero(String heroName, String heroPower, String realName, int creationYear, boolean human) {
        Superhero hero = new Superhero(heroName, heroPower, realName, creationYear, human);
        superheroes.add(hero);
    }

    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public Superhero searchFor(String searchTerm) {
        for (Superhero superhero : superheroes) {
            String name = superhero.getHeroName().toLowerCase();
            if (name.contains(searchTerm.toLowerCase())) {
                return superhero;

            }
        }
        return null;
    }
}
