import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
   private Database database;

    @BeforeEach
    public void beforeTest() {
        database = new Database();
        database.createSuperhero("Hulk", "Stærk", "Bruce Banner", 1970, true);
        database.createSuperhero("Spiderman", "Edderkoppe-evner", "Peter Parker", 1999, true);
        database.createSuperhero("Iron Man", "Mange penge", "Tony Stark", 1970, true);
        database.createSuperhero("Batman", "Flagermus-dragt", "Bruce Wayne", 1980, true);
    }
    

    @org.junit.jupiter.api.Test
    void createOneHero() {
        //Arrange
        int expected = database.getSuperheroes().size()+1;
        //Act
        database.createSuperhero("Spiderman", "Edderkoppe-evner", "Peter Parker", 1999, true);
        int actual = database.getSuperheroes().size();
        //Assert
        assertEquals(expected, actual);
    }

    void createMultipleHeroes() {
        //Arrange
        int expected = database.getSuperheroes().size() + 3;
        //Act
        database.createSuperhero("Spiderman", "Edderkoppe-evner", "Peter Parker", 1999, true);
        database.createSuperhero("Iron Man", "Mange penge", "Tony Stark", 1970, true);
        database.createSuperhero("Batman", "Flagermus-dragt", "Bruce Wayne", 1980, true);

        int actual = database.getSuperheroes().size();

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void searchForZeroHero() {
        //Arrange
        ArrayList<Superhero> expected = new ArrayList<>(1);
        //Act
        ArrayList<Superhero> actual = database.searchFor("test");
        //Assert
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void searchForOneHero() {
        //Arrange
        ArrayList<Superhero> results = database.searchFor("Hulk");
        int expected = 1;
        //Act
        int actual = results.size();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void searchForMultipleSuperheroes() {
        //Arrange
        ArrayList<Superhero> results = database.searchFor("man");
        int expected = 3;
        //Act
        int actual = results.size();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void deleteSuperhero() {
        //Arrange
        ArrayList<Superhero> results = database.getSuperheroes();
        Superhero superhero = database.getSuperheroes().get(0);

        int expectedSize = results.size()-1;
        boolean expectedResult = true;

        //Act
        ArrayList<Superhero> resultAfterDelete = database.getSuperheroes();
        boolean actualResult = database.deleteSuperhero(superhero);

        //Assert
        assertEquals(expectedResult,actualResult);
        assertEquals(expectedSize, expectedSize);
    }
}
