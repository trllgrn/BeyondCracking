package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {


    private DynamicArray<Integer> array;

    @BeforeEach
    void setUp() {
        array = new DynamicArray<>();
    }

    //Test Get and Set methods
    @Test
    void append_ShouldAddElement() {
        array.append(1);
        assertEquals(1, array.size());
        assertEquals(1, array.get(0));
    }

    @Test
    void append_ShouldGrowArray() {
        for (int i = 0; i < 11; i++) {
            array.append(i);
        }
        assertEquals(11, array.size());
        assertEquals(10, array.get(10));
    }

    @Test
    void get_ShouldReturnElement() {
        array.append(5);
        assertEquals(5, array.get(0));
    }

    @Test
    void get_ShouldThrowException_WhenIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(0));
        array.append(1);
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(1));
    }

    @Test
    void set_ShouldUpdateElement() {
        array.append(1);
        array.set(0, 2);
        assertEquals(2, array.get(0));
    }

    @Test
    void set_ShouldThrowException_WhenIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> array.set(0, 1));
        array.append(1);
        assertThrows(IndexOutOfBoundsException.class, () -> array.set(-1, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> array.set(1, 1));
    }

    @Test
    void size_ShouldReturnCorrectSize() {
        assertEquals(0, array.size());
        array.append(1);
        assertEquals(1, array.size());
    }

    @Test
    void popBack_ShouldRemoveLastElement() {
        array.append(1);
        array.append(2);
        array.popBack();
        assertEquals(1, array.size());
        assertEquals(1, array.get(0));
    }

    @Test
    void popBack_ShouldThrowException_WhenEmpty() {
        assertThrows(IllegalStateException.class, () -> array.popBack());
    }
}