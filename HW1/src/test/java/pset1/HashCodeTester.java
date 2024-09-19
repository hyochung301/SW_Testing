package pset1;

import static org.junit.Assert.*;
import org.junit.Test;

public class HashCodeTester {

    /*
     * P5: If two objects are equal according to the equals(Object)
     * method, then calling the hashCode method on each of
     * the two objects must produce the same integer result.
     */

    // O, O
    @Test public void t1() {
        Object x2 = new Object();
        Object x1 = new Object();
        if (x1.equals(x2)) {
            assertTrue(x2.hashCode() == x1.hashCode());
        }
    }

    // O, C
    @Test public void t2() {
        C c = new C(0);
        Object x = new Object();
        if (x.equals(c)) {
            assertTrue(c.hashCode() == x.hashCode());
        }
    }

    // O, D
    @Test public void t3() {
        D d = new D(0, 1);
        Object x = new Object();
        if (x.equals(d)) {
            assertTrue(d.hashCode() == x.hashCode());
        }
    }

    // C, C
    @Test public void t4() {
        C c2 = new C(0);
        C c1 = new C(0);
        if (c1.equals(c2)) {
            assertTrue(c2.hashCode() == c1.hashCode());
        }
    }

    // C, D
    @Test public void t5() {
        D d = new D(0, 1);
        C c = new C(0);
        if (c.equals(d)) {
            assertTrue(d.hashCode() == c.hashCode());
        }
    }

    // C, O
    @Test public void t6() {
        Object x = new Object();
        C c = new C(0);
        if (c.equals(x)) {
            assertTrue(x.hashCode() == c.hashCode());
        }
    }

    // D, D
    @Test public void t7() {
        D d2 = new D(0, 1);
        D d1 = new D(0, 1);
        if (d1.equals(d2)) {
            assertTrue(d2.hashCode() == d1.hashCode());
        }
    }

    // D, C
    @Test public void t8() {
        C c = new C(0);
        D d = new D(0, 1);
        if (d.equals(c)) {
            assertTrue(c.hashCode() == d.hashCode());
        }
    }

    // D, O
    @Test public void t9() {
        Object x = new Object();
        D d = new D(0, 1);
        if (d.equals(x)) {
            assertTrue(x.hashCode() == d.hashCode());
        }
    }
}