package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private final Integer[] numbers = {1, 2, 3, 4};
    private Database database;

    @Before
    public void setup() throws OperationNotSupportedException {
        this.database = new Database(numbers);
    }

    @Test
    public void databaseShouldCreateValidObject() {

        Integer[] elements = this.database.getElements();

        Assert.assertEquals(numbers.length, elements.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShouldThrowExceptionForNullParameters() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShouldThrowExceptionForMoreThanSixteenElements() throws OperationNotSupportedException {
        new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShouldThrowExceptionForLessThanOneElements() throws OperationNotSupportedException {
        new Database();
    }

    @Test
    public void databaseShouldSetElementsInCorrectOrder() {
        Integer[] elemnets = this.database.getElements();

        Assert.assertArrayEquals(numbers, elemnets);
    }

    @Test
    public void databaseShouldAddElement() throws OperationNotSupportedException {
        final int elementToAdd = 99;
        this.database.add(elementToAdd);

        Integer[] elements = this.database.getElements();
        int lastElement = elements[elements.length - 1];

        Assert.assertEquals(elementToAdd, lastElement);
    }

    @Test
    public void databaseShouldRemoveElementAtLastIndex() throws OperationNotSupportedException {
        this.database.remove();
        Integer[] elements = this.database.getElements();
        int lastElement = elements[elements.length - 1];

        Assert.assertEquals(3, lastElement);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShouldThrowExceptionForRemovingNullElement() throws OperationNotSupportedException {
        Database database = new Database();
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShouldThrowExceptionForAddingNullElement() throws OperationNotSupportedException {
        this.database.add(null);
    }
}
