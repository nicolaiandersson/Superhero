public class Database {
    private Superhero[] superheroes;

    public void createSuperhero(String heroName, String heroPower, String realName, int creationYear, boolean human){
        Superhero hero = new Superhero(heroName, heroPower, realName, creationYear, human);
    }
}
