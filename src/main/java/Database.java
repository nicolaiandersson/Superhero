public class Database {
    private Superhero[] superheroes;
    private int heroAmount;

    public Database() {
        superheroes = new Superhero[5];
        heroAmount = 0;
    }
    public void createSuperhero(String heroName, String heroPower, String realName, int creationYear, boolean human){
        Superhero hero = new Superhero(heroName, heroPower, realName, creationYear, human);
        System.out.println(hero);
    }
}
