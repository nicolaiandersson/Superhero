import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

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
        database.createSuperhero("Hulk", "Stærk", "Bruce Banner", 1970, true);
        int expected = 1;
        //Act
        int actual = database.getSuperheroes().size();
        //Assert
        assertEquals(expected, actual);
    }
}
