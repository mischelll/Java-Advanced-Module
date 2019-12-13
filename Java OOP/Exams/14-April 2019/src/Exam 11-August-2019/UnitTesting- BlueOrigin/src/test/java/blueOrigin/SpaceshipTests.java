package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTests {
    private static final String NULL_NAME = null;
    private static final String EMPTY_NAME = "  ";
    private static final int INVALID_CAPACITY = -10;

    private static final int VALID_CAPACITY = 2;
    private static final String VALID_NAME = "TestShip";

    private static final int ZERO_LIST_COUNT = 0;

    private Spaceship spaceship;


    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionForSettingNullName() {
        this.spaceship = new Spaceship(NULL_NAME, VALID_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionForSettingEmptyName() {
        this.spaceship = new Spaceship(EMPTY_NAME, VALID_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNegativeCapacity() {
        this.spaceship = new Spaceship(VALID_NAME, INVALID_CAPACITY);
    }


    @Before
    public void setup() {
        this.spaceship = new Spaceship(VALID_NAME, VALID_CAPACITY);
    }

    @Test
    public void getCountShouldReturnZero() {
        assertEquals(ZERO_LIST_COUNT, this.spaceship.getCount());
    }

    @Test
    public void getNameShouldReturnCorrectName() {
        assertEquals(VALID_NAME, this.spaceship.getName());
    }

    @Test
    public void getCapacityShouldReturnCorrectNumber() {
        assertEquals(VALID_CAPACITY, this.spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForHavingAstronautsOverCapacity(){
        this.spaceship.add(new Astronaut("name",3.9));
        this.spaceship.add(new Astronaut("test",9.9));
        this.spaceship.add(new Astronaut("test2",9.9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForAddingAstronautsWithTheSameName(){
        this.spaceship.add(new Astronaut("test2",9.9));
        this.spaceship.add(new Astronaut("test2",9.9));
    }

    @Test
    public void shouldAddAstronautCorrectly(){
        this.spaceship.add(new Astronaut("test",9.9));
        this.spaceship.add(new Astronaut("test2",9.9));

        assertEquals(this.spaceship.getCount(),this.spaceship.getCapacity());
    }

    @Test
    public void shouldRemoveAstronautWithGivenName(){
        this.spaceship.add(new Astronaut("test",9.9));
        this.spaceship.add(new Astronaut("test2",9.9));

        boolean checkRemove = this.spaceship.remove("test");

        assertTrue(checkRemove);
    }

    @Test
    public void shouldRemoveAstronautWithNonExistentName(){
        this.spaceship.add(new Astronaut("test",9.9));
        this.spaceship.add(new Astronaut("test2",9.9));

        boolean checkRemove = this.spaceship.remove("test34");

        assertFalse(checkRemove);
    }

}
