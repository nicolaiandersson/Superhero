public class Superhero {
    private String heroName;
    private String heroPower;
    private String realName;
    private int creationYear;
    private boolean human;

    public Superhero(String heroName, String heroPower, String realName, int creationYear, boolean human) {
        this.heroName = heroName;
        this.heroPower = heroPower;
        this.realName = realName;
        this.creationYear = creationYear;
        this.human = human;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "realName='" + realName + '\'' +
                ", heroName=" + heroName +
                ", creationYear=" + creationYear +
                ", heroPower='" + heroPower + '\'' +
                ", human=" + human +
                '}';
    }
}