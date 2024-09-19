package pset1;

import static org.junit.Assert.*;
import org.junit.Test;

public class SLListAddTester {
    @Test
    public void test0() {
        SLList l = new SLList();
        assertTrue(l.repOk());
        l.add(true);

        // write a sequence of assertTrue method invocations that
        // perform checks on the values for all the declared fields
        // of list and node objects reachable from l

        assertTrue(l.first != null); //must always have first & last
        assertTrue(l.last != null);

        assertTrue(l.first.elem == true); //check value
        assertTrue(l.last.elem == true);

        assertTrue(l.first.next == null); //only one node in the list
        assertTrue(l.last.next == null);

        assertTrue(l.first == l.last); //since only one node, first must equal last
    }

    @Test
    public void test1() {
        SLList l = new SLList();
        assertTrue(l.repOk());
        l.add(true);
        assertTrue(l.repOk());
        l.add(false);
        assertTrue(l.repOk());

        // write a sequence of assertTrue method invocations that
        // perform checks on the values for all the declared fields
        // of list and node objects reachable from l

        assertTrue(l.first != null); //both first and last shouldn't be null
        assertTrue(l.last != null);

        assertTrue(l.first.elem == true); //value for first
        assertTrue(l.first.next != null);

        assertTrue(l.first.next.elem == false); //value for second
        assertTrue(l.last.elem == false);

        assertTrue(l.first.next.next == null); //must be the end of list after two nodes
        assertTrue(l.last.next == null);

        assertTrue(l.first.next == l.last); //the second node should be the last node
    }
}
