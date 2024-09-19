package pset1;

import static org.junit.Assert.*;
import org.junit.Test;
import pset1.SLList.Node;

public class SLListRepOkTester {
    @Test public void t0() {
        SLList l = new SLList();
        assertTrue(l.repOk());
    }

    @Test public void t1() {
        SLList l = new SLList();
        Node n = new Node();
        // your code goes here
        l.first = n;
        l.last = n;
        assertTrue(l.repOk());
    }

    // only one element, but cycle
    @Test public void t2() {
        SLList l = new SLList();
        Node n = new Node();
        n.next = n;
        l.first = n;
        l.last = n;
        assertFalse(l.repOk());
    }
    // list with two nodes properly inserted
    @Test public void t3() {
        SLList l = new SLList();

        Node first = new Node();
        Node last = new Node();

        first.next = last;
        l.first = first;
        l.last = last;

        assertTrue(l.repOk());
    }

    // second element cycles to first element
    @Test public void t4() {
        SLList l = new SLList();

        Node first = new Node();
        Node last = new Node();

        first.next = last;
        last.next = first;
        l.first = first;
        l.last = last;

        assertFalse(l.repOk());
    }


    // first element cycles to itself
    @Test public void t5() {
        SLList l = new SLList();

        Node first = new Node();
        Node last = new Node();

        first.next = first;
        l.first = first;
        l.last = last;

        assertFalse(l.repOk());
    }

    // second element cycles to itself
    @Test public void t6() {
        SLList l = new SLList();

        Node first = new Node();
        Node last = new Node();

        first.next = last;
        last.next = last;
        l.first = first;
        l.last = last;

        assertFalse(l.repOk());
    }
}