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

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public String getHeroPower() {
        return heroPower;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public String humanStatus() {
        if (human == true) {
            return "Ja";
        } else {
            return "Nej";
        }
    }

    public void editHeroName(String editHeroName) {
        this.heroName = editHeroName;
    }
    public void editRealName(String editRealName) {
        this.realName = editRealName;
    }
    public void editHeroPower(String editHeroPower) {
        this.heroPower = editHeroPower;
    }
    public void editCreationYear(String editCreationYear) {
        this.creationYear = Integer.parseInt(editCreationYear);
    }
    public void editHumanStatus(String editHumanStatus) {
        this.human = Boolean.parseBoolean(editHumanStatus);
    }


}

