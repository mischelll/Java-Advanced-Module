package p04_BubbleSort;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {
    private static final int[] EMPTY_ARR = {};
    private static final int[] ARR_EXAMPLE = {3, 7, 1, 9, 5, 5, 42, -99};
    private static final int[] ARR_EXAMPLE_SORTED = {-99, 1, 3, 5, 5, 7, 9, 42};

    @Test
    public void shouldReturnSortedArrayAsGiven() {
        Bubble.sort(ARR_EXAMPLE);

        assertArrayEquals(ARR_EXAMPLE, ARR_EXAMPLE_SORTED);
    }

   
}
