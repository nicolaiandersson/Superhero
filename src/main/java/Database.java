import java.util.ArrayList;
public class Database {
    ArrayList<Superhero> superheroes = new ArrayList<>();

    public void exampleHeroes() {
        createSuperhero("Spiderman", "Edderkoppe-evner", "Peter Parker", 1999, true);
        createSuperhero("Iron Man", "Mange penge", "Tony Stark", 1970, true);
        createSuperhero("Hulk", "Stor og stærk", "Ved ikke", 1950, true);
        createSuperhero("Batman", "Flagermus-dragt", "Bruce Wayne", 1980, true);
    }

    public Superhero createSuperhero(String heroName, String heroPower, String realName, int creationYear, boolean human) {
        Superhero hero = new Superhero(heroName, heroPower, realName, creationYear, human);
        superheroes.add(hero);
        return hero;
    }

    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public ArrayList<Superhero> searchFor(String searchTerm) {
        ArrayList<Superhero> searchResults = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            String name = superhero.getHeroName().toLowerCase();
            if (name.contains(searchTerm.toLowerCase())) {
                searchResults.add(superhero);
            }
        }
        return searchResults;
    }
}