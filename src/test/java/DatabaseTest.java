import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database database;

    @BeforeEach
    public void beforeTest() {
        database = new Database();
    }


    @org.junit.jupiter.api.Test
    void createOneHero() {
        //Arrange
        Database database = new Database();
        //Act
        database.createSuperhero("Hulk", "Stærk", "Bruce Banner", 1970, true);
        ArrayList<Superhero> results = database.getSuperheroes();

        int expected = 1;
        int actual = database.getSuperheroes().size();
        //Assert
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void exampleHeroes() {

        //Arrange
        Database database = new Database();
        //Act
        database.createSuperhero("Spiderman", "Edderkop", "Peter Parker", 1980, true);
        ArrayList<Superhero> results = database.getSuperheroes();

        int expected = 4;
        int actual = database.getSuperheroes().size();
        //Assert
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void searchFor() {
        //Arrange
        Database database = new Database();
        //Act
        database.createSuperhero("Spiderman", "Edderkop", "Peter Parker", 1980, true);
        ArrayList<Superhero> results = database.searchFor("Spiderman");

        int expected = 1;
        int actual = results.size();
        //Assert
        assertEquals(expected, actual);
    }
}
