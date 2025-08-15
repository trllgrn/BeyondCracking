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

    // Book Tests
    // Test Get and Set methods
    @Test
    void testGetAndSet() {
        // Setup array with [0,1,2,3,4]
        for (int i = 0; i < 5; i++) {
            array.append(i);
        }

        // Test get
        assertEquals(0, array.get(0), "get(0) should return 0");
        assertEquals(4, array.get(4), "get(4) should return 4");

        // Test set
        array.set(0, 10);
        assertEquals(10, array.get(0), "After set(0,10), get(0) should return 10");

        // Test error cases
        assertThrows(IndexOutOfBoundsException.class,
                () -> array.get(-1),
                "get(-1) should throw IndexOutOfBoundsException");

        assertThrows(IndexOutOfBoundsException.class,
                () -> array.get(5),
                "get(5) should throw IndexOutOfBoundsException");

        assertThrows(IndexOutOfBoundsException.class,
                () -> array.set(-1, 0),
                "set(-1,0) should throw IndexOutOfBoundsException");

        assertThrows(IndexOutOfBoundsException.class,
                () -> array.set(5, 0),
                "set(5,0) should throw IndexOutOfBoundsException");
    }

    @Test
    void testAppend() {
        // Test append to empty array
        array.append(1);
        assertEquals(1, array.size(), "Size should be 1 after append");
        assertEquals(1, array.get(0), "Element at 0 should be 1");

        // Test multiple appends
        array.append(2);
        array.append(3);
        assertEquals(3, array.size(), "Size should be 3 after appends");
        assertEquals(2, array.get(1), "Element at 1 should be 2");
        assertEquals(3, array.get(2), "Element at 2 should be 3");
    }

    @Test
    void testPopBack() {
        // Test pop from empty array
        assertThrows(IllegalStateException.class,
                () -> array.popBack(),
                "popBack() on empty array should throw IllegalStateException");

        // Setup array with [1,2,3]
        array.append(1);
        array.append(2);
        array.append(3);

        // Test pop_back
        array.popBack();
        assertEquals(2, array.size(), "Size should be 2 after popBack");
        assertThrows(IndexOutOfBoundsException.class,
                () -> array.get(2),
                "get(2) should throw IndexOutOfBoundsException after popBack");
    }

    @Test
    void testResize() {
        // Test initial capacity
        assertEquals(10, array.getCapacity(), "Initial capacity should be 10");

        // Test grow capacity
        for (int i = 0; i < 11; i++) {
            array.append(i);
        }
        assertEquals(20, array.getCapacity(), "Capacity should double to 20");

        // Test shrink capacity
        for (int i = 0; i < 8; i++) {
            array.popBack();
        }
        assertEquals(10, array.getCapacity(), "Capacity should shrink back to 10");
    }
}