package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Anthony Derfler (cderfler)

/**
 * Test Class for Linked List
 * 
 * @author Anthony Derfler (cderfler)
 * @version 19.4.11
 */
public class LinkedListTest extends TestCase {

    // test list
    private LinkedList<String> list;


    /**
     * sets up the test list for each test
     */
    public void setUp() {
        list = new LinkedList<String>();
    }


    /**
     * makes sure it gets the correct size
     */
    public void testGetSize() {
        assertEquals(0, list.getSize());

        list.add("a");
        list.add("b");
        assertEquals(2, list.getSize());

        list.remove("a");
        assertEquals(1, list.getSize());
    }


    /**
     * makes sure it can add a new node to the end of a list while incrementing
     * its size correctly
     */
    public void testAddA() {
        Exception thrown = null;
        try {
            list.add(null);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof NullPointerException);

        list.add("a");
        assertEquals("a", list.getFront());
        assertEquals(1, list.getSize());

        list.add("b");
        assertEquals("a", list.getFront());
        assertEquals(2, list.getSize());
        assertEquals("b", list.get(1));

        list.add("c");
        assertEquals("a", list.getFront());
        assertEquals(3, list.getSize());
        assertEquals("c", list.get(2));

        list.add("d");
        assertEquals("a", list.getFront());
        assertEquals(4, list.getSize());
        assertEquals("d", list.get(3));

    }


    /**
     * makes sure it can add a node anywhere in the list at the correct spot,
     * connects to its adjacent nodes, and increments its size
     */
    public void testAddB() {
        list.add(0, "z");
        assertEquals("z", list.getFront());
        assertEquals("z", list.get(0));
        assertEquals(1, list.getSize());

        list.add("a");
        list.add("b");
        list.add("c");

        list.add(0, "y");
        assertEquals("y", list.getFront());
        assertEquals("y", list.get(0));
        assertEquals(5, list.getSize());

        list.add(5, "x");

        assertEquals("x", list.get(5));
        assertEquals(6, list.getSize());

        list.add(4, "w");

        assertEquals("w", list.get(4));
        assertEquals(7, list.getSize());
        
        list.add(5, "m");
        assertEquals("m", list.get(5));
        assertEquals(8, list.getSize());

        Exception thrown = null;
        try {
            list.add(12, "m");
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);

    }


    /**
     * checks that it can remove a specified object and return if it was
     * successful
     */
    public void testRemoveA() {
        assertFalse(list.remove("a"));
        

        list.add("a");
        assertTrue(list.remove("a"));
        assertEquals(0, list.getSize());

        list.add("a");
        list.add("b");
        list.add("c");

        assertTrue(list.remove("b"));

        assertEquals("a", list.get(0));
        assertEquals("c", list.get(1));

        list.add("d");
        assertTrue(list.remove("d"));
        assertEquals("a", list.get(0));
        assertEquals("c", list.get(1));
        assertEquals(2, list.getSize());
        
        assertFalse(list.remove("z"));
    }


    /**
     * makes sure it can remove an item at a specified index, throwing an
     * exception if the index is out of bounds
     */
    public void testRemoveB() {
        Exception thrown = null;
        try {
            list.remove(0);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        assertEquals("d", list.remove(3));
        assertEquals(3, list.getSize());

        try {
            list.remove(10);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        assertEquals("b", list.remove(1));
        assertEquals(2, list.getSize());
        assertEquals("a", list.remove(0));
        assertEquals("c", list.remove(0));
        assertTrue(list.isEmpty());

    }


    /**
     * makes sure it returns the correct front of the list
     */
    public void testGetFront() {
        assertNull(list.getFront());

        list.add("a");
        list.add("b");
        assertEquals("a", list.getFront());
    }


    /**
     * makes sure it can get an item at a specified index
     */
    public void testGet() {
        Exception thrown = null;
        try {
            list.get(0);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        list.add("a");
        list.add("b");
        list.add("c");

        try {
            list.get(5);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));

    }


    /**
     * makes sure it knows if it's empty or not
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("a");
        assertFalse(list.isEmpty());
    }


    /**
     * makes sure it knows if it contains a specified object
     */
    public void testContains() {
        Exception thrown = null;
        try {
            list.contains(null);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof NullPointerException);

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        assertTrue(list.contains("a"));
        assertTrue(list.contains("b"));
        assertTrue(list.contains("c"));
        assertTrue(list.contains("d"));
        assertFalse(list.contains("e"));
    }


    /**
     * makes sure it clears the list correctly
     */
    public void testClear() {
        list.add("a");
        list.add("b");

        list.clear();
        assertTrue(list.isEmpty());
    }


    /**
     * makes sure it can be converted to a string
     */
    public void testToString() {
        assertEquals("", list.toString());
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        assertEquals("a, b, c, d", list.toString());
    }


    /**
     * makes sure it can retrieve the index where a specified object is
     */
    public void testGetIndex() {
        Exception thrown = null;
        try {
            list.getIndex(null);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof NullPointerException);

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        assertEquals(0, list.getIndex("a"));
        assertEquals(1, list.getIndex("b"));
        assertEquals(2, list.getIndex("c"));
        assertEquals(3, list.getIndex("d"));
        assertEquals(-1, list.getIndex("e"));
    }


    /**
     * tests the iterator
     */
    public void testIterator() {
        Iterator<String> iter = list.iterator();
        assertFalse(iter.hasNext());

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        assertTrue(iter.hasNext());
        assertEquals("a", iter.next());
        assertEquals("b", iter.next());
        assertEquals("c", iter.next());
        assertEquals("d", iter.next());
        assertFalse(iter.hasNext());

        Exception thrown = null;
        try {
            iter.next();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof NoSuchElementException);

    }

}
