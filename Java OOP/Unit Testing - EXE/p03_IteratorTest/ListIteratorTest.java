package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private final static String ELEMENT_ONE = "ONE";
    private final static String ELEMENT_TWO = "TWO";
    private final static String ELEMENT_THREE = "THREE";

    private String[] elements = {ELEMENT_ONE, ELEMENT_TWO, ELEMENT_THREE};
    private ListIterator listIterator;

    @Before
    public void setup() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionForInitializationWithNullElements() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(null);
    }

    @Test
    public void shouldHaveNextElement() {
        boolean hasNext = this.listIterator.hasNext();

        assertTrue(hasNext);
    }

    @Test
    public void shouldReturnFalseForNotHavingANextElement() throws OperationNotSupportedException {
        this.listIterator = new ListIterator();
        boolean hasNext = this.listIterator.hasNext();

        assertFalse(hasNext);
    }

    @Test
    public void shouldMoveInternalIndex() {
        boolean move = this.listIterator.move();

        assertTrue(move);
    }

    @Test
    public void shouldNotBeAbleToMoveInternalIndex() throws OperationNotSupportedException {
        for (int i = 0; i < elements.length; i++) {
            this.listIterator.move();
        }

        boolean move = this.listIterator.move();

        assertFalse(move);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionForPrintingOnEmptyList() throws OperationNotSupportedException {
        this.listIterator = new ListIterator();

        this.listIterator.print();
    }

    @Test           //print() method
    public void shouldReturnElementAtCurrentIndex() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = this.listIterator.getClass();
        Field fields = clazz.getDeclaredField("elements");
        fields.setAccessible(true);

        List<String> stringList = (List<String>) fields.get(this.listIterator);

        this.listIterator.move();

        assertEquals(this.listIterator.print(), stringList.get(1));

    }
}
