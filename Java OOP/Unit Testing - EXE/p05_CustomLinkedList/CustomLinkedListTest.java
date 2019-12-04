package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
    private CustomLinkedList linkedList;

    @Before
    public void setup() {
        this.linkedList = new CustomLinkedList();

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForGettingElementAtIndexLessThanZero() {
        this.linkedList.get(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForGettingElementAtIndexBiggerThanElementsCount() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CustomLinkedList clasz = new CustomLinkedList();
        Method method = CustomLinkedList.class.getDeclaredMethod("getCount");
        method.setAccessible(true);
        int count = (int) method.invoke(clasz);

        this.linkedList.get(count + 1);
    }

    @Test
    public void addMethodShouldIncrementCount() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CustomLinkedList clasz = new CustomLinkedList();
        clasz.add(5);
        Method method = CustomLinkedList.class.getDeclaredMethod("getCount");
        method.setAccessible(true);
        int count = (int) method.invoke(clasz);

        assertEquals(1, count);
    }

    @Test
    public void shouldContainElementAfterAddMethod() {
        final int element = 4;
        this.linkedList.add(element);

        assertTrue(this.linkedList.contains(element));
    }

    @Test
    public void getMethodShouldReturnCorrectElement() {
        final int element = 234;
        this.linkedList.add(element);


        assertEquals(element, this.linkedList.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSettingAnIndexLessThanZero() {
        this.linkedList.set(-5, "str");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSettingAnIndexBiggerThanCount() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        CustomLinkedList clasz = new CustomLinkedList();
        Method method = CustomLinkedList.class.getDeclaredMethod("getCount");
        method.setAccessible(true);
        int count = (int) method.invoke(clasz);

        this.linkedList.set(count + 1, "asd");
    }

    @Test
    public void shouldSetElementAtCorrectIndex() {
        this.linkedList.add(5);
        this.linkedList.add(345);
        this.linkedList.set(1, 77);

        assertEquals(this.linkedList.get(1), 77);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtMethodShouldThrowExceptionForRemovingElementAtIndexLessThanZero() {
        this.linkedList.removeAt(-6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtMethodShouldThrowExceptionForRemovingElementAtIndexBiggerThanCount() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        CustomLinkedList clasz = new CustomLinkedList();
        Method method = CustomLinkedList.class.getDeclaredMethod("getCount");
        method.setAccessible(true);
        int count = (int) method.invoke(clasz);

        this.linkedList.removeAt(++count);
    }

    @Test
    public void removeAtMethodShouldReturnCorrectElement() {
        int elementAtZero = 4;
        this.linkedList.add(elementAtZero);
        this.linkedList.add(8);

        assertEquals(this.linkedList.removeAt(0), elementAtZero);
    }

    @Test
    public void removeMethodShouldReturnCorrectIndexWhenContained() {
        String element1 = "rwe";
        String element2 = "$$$";
        int index = 1;
        this.linkedList.add(element1);
        this.linkedList.add(element2);

        assertEquals(this.linkedList.remove(element2), index);
    }

    @Test
    public void removeMethodShouldReturnNegativeIndexWhenElementNotContained() {
        String element1 = "rwe";
        String element2 = "$$$";
        String element3 = "$#$#$#";
        int index = -1;
        this.linkedList.add(element1);
        this.linkedList.add(element2);

        assertEquals(this.linkedList.remove(element3), index);
    }




}
