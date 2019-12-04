package p02_DatabaseExtended;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class DatabaseExtendedTest {
    private static final Person PERSON_ONE = new Person(213, "Person1");
    private static final Person PERSON_TWO = new Person(234, "Person2");
    private Person[] people = {PERSON_ONE, PERSON_TWO};
    private Database database;


    @Before
    public void setup() throws OperationNotSupportedException {
        this.database = new Database(people);
    }

    @Test
    public void databaseShouldCreateValidObject() {
        Person[] people2 = this.database.getElements();

        Assert.assertEquals(people.length, people2.length);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShouldThrowExceptionForMoreThanSixteenElements() throws OperationNotSupportedException {
        Person people2[] = new Person[17];
        Database database1 = new Database(people2);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShouldThrowExceptionForNullPeopleArray() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        this.database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShouldThrowExceptionForAddingNullPerson() throws OperationNotSupportedException {
        Person person = null;
        this.database.add(person);
    }


    @Test
    public void databaseShouldAddPersonCorrectly() throws OperationNotSupportedException {
        Person person = new Person(123, "fsda");
        this.database.add(person);

        Person people2[] = this.database.getElements();
        Person lastElement = people2[people2.length - 1];

        Assert.assertEquals(person, lastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionForRemovingPersonInEmptyDatabase() throws OperationNotSupportedException {
        this.database = new Database();
        this.database.remove();
    }

    @Test
    public void shouldRemovePersonFromDatabaseCorrectly() throws OperationNotSupportedException {
        this.database.remove();
        Person people[] = this.database.getElements();
        Person lastElement = people[people.length - 1];

        Assert.assertEquals(PERSON_ONE, lastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionForFindingAPersonByNullUsername() throws OperationNotSupportedException {
        final String username = null;
        this.database.findByUsername(username);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionForFindingAPersonWithNonExistentUsername() throws OperationNotSupportedException {
        final String username = "asdgadfv";
        this.database.findByUsername(username);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionForFindingAPersonByAlreadyExistingUsername() throws OperationNotSupportedException {
        Person person = new Person(123, "qwerty");
        this.database.add(person);
        this.database.add(person);

        this.database.findByUsername(person.getUsername());
    }

    @Test
    public void shouldFindPersonByUsernameCorrectly() throws OperationNotSupportedException {

        Assert.assertEquals(this.database.findByUsername(PERSON_ONE.getUsername()), PERSON_ONE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionForFindingPersonByNonExistentId() throws OperationNotSupportedException {
      this.database.findById(404);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionForFindingPersonByAlreadyExistingId() throws OperationNotSupportedException {
        this.database.add(PERSON_ONE);
        this.database.add(PERSON_ONE);

        this.database.findById(PERSON_ONE.getId());
    }

    @Test
    public void shouldFindPersonByIdCorrectly() throws OperationNotSupportedException {
        Assert.assertEquals(this.database.findById(PERSON_TWO.getId()),PERSON_TWO);
    }

}
