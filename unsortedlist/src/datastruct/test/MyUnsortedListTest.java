package datastruct.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datastruct.EmptyListException;
import datastruct.MyUnsortedList;

class MyUnsortedListTest {

    private MyUnsortedList<Integer> list;

   
    @BeforeEach
    public void setUp() {
        list = MyUnsortedList.of(1, 2, 3, 4, 5);
    }

    @Test
    public void testIsEmpty() {
        assertFalse(list.isEmpty());
        MyUnsortedList<Integer> emptyList = MyUnsortedList.of();
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(5, list.size());
    }

    @Test
    public void testPrepend() {
        list.prepend(0);
        assertEquals(6, list.size());
        assertEquals(Integer.valueOf(0), list.remove(0));
    }

    @Test
    public void testAppend() {
        list.append(6);
        assertEquals(6, list.size());
        assertEquals(Integer.valueOf(6), list.popLast());
    }

    @Test
    public void testInsert() {
        list.insert(99, 2);
        assertEquals(Integer.valueOf(99), list.remove(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(100, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(100, 10));
    }

    @Test
    public void testRemove() {
        assertEquals(Integer.valueOf(3), list.remove(2));
        assertEquals(4, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(10));
    }

    @Test
    public void testPop() {
        assertEquals(Integer.valueOf(1), list.pop());
        assertEquals(4, list.size());
        MyUnsortedList<Integer> emptyList = MyUnsortedList.of();
        assertThrows(EmptyListException.class, emptyList::pop);
    }

    @Test
    public void testPopLast() {
        assertEquals(Integer.valueOf(5), list.popLast());
        assertEquals(4, list.size());
        MyUnsortedList<Integer> emptyList = MyUnsortedList.of();
        assertThrows(EmptyListException.class, emptyList::popLast);
    }

   

    @Test
    public void testEquals() {
        MyUnsortedList<Integer> otherList = MyUnsortedList.of(1, 2, 3, 4, 5);
        assertTrue(list.equals(otherList));
        otherList.pop();
        assertFalse(list.equals(otherList));
    }
}
