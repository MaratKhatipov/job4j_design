package kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertNull;


public class MaxMinTest {
    MaxMin test = new MaxMin();
    Comparator<Integer> comparator = Comparator.comparingInt(o -> o);

    @Test
    public void whenNotMaxElementThenNull() {
        List<Integer> list = new ArrayList<>();
        assertNull(test.max(list, comparator));
    }

    @Test
    public void whenNotMinElementThenNull() {
        List<Integer> list = new ArrayList<>();
        assertNull(test.min(list, comparator));
    }

    @Test
    public void whenMaxElementThen92() {
        List<Integer> list = new ArrayList<>(List.of(1, 3, 15, 14, 42, 63, 13, 92, 23, 5));
        int expected = 92;
        assertThat(test.max(list, comparator), is(expected));
    }

    @Test
    public void whenMinElementThen1() {
        List<Integer> list = new ArrayList<>(List.of(1, 3, 15, 14, 42, 63, 13, 92, 23, 5));
        int expected = 1;
        assertThat(expected, is(test.min(list, comparator)));
    }

    @Test
    public void whenAllNumbEquals() {
        List<Integer> list = new ArrayList<>(List.of(3, 3, 3, 3, 3, 3, 3, 3, 3, 3));
        int expected = 3;
        assertThat(expected, is(test.min(list, comparator)));
        assertThat(expected, is(test.max(list, comparator)));
    }
}