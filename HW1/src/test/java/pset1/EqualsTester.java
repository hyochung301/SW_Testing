package pset1;

import static org.junit.Assert.*;
import org.junit.Test;

public class EqualsTester {
    /*
     * P1: For any non-null reference value x, x.equals(null) should return false.
     */

    @Test public void t0() {
        assertFalse(new Object().equals(null));
    }

    @Test public void nonNull2() {
        C c = new C(0);
        assertFalse(c.equals(null));
    }

    @Test public void nonNull3() {
        D d = new D(0, 1);
        assertFalse(d.equals(null));
    }

    /*
     * P2: It is reflexive: for any non-null reference value x, x.equals(x)
     * should return true.
     */

    @Test public void reflexive1() {
        Object x = new Object();
        assertTrue(x.equals(x));
    }

    @Test public void reflexive2() {
        C c = new C(0);
        assertTrue(c.equals(c));
    }

    @Test public void reflexive3() {
        D d = new D(0, 1);
        assertTrue(d.equals(d));
    }

    /*
     * P3: It is symmetric: for any non-null reference values x and y, x.equals(y)
     * should return true if and only if y.equals(x) returns true.
     */

    @Test public void symmetric1() {
        C c = new C(0);
        Object x = new Object();
        if (x.equals(c)) {
            assertTrue(c.equals(x));
        } else {
            assertFalse(c.equals(x));
        }
    }

    // O, D
    @Test public void symmetric2() {
        D d = new D(0, 1);
        Object x = new Object();
        if (x.equals(d)) {
            assertTrue(d.equals(x));
        } else {
            assertFalse(d.equals(x));
        }
    }

    // O, O
    @Test public void symmetric3() {
        Object x2 = new Object();
        Object x1 = new Object();
        if (x1.equals(x2)) {
            assertTrue(x2.equals(x1));
        } else {
            assertFalse(x2.equals(x1));
        }
    }

    // C, C
    @Test public void symmetric4() {
        C c2 = new C(0);
        C c1 = new C(0);
        if (c1.equals(c2)) {
            assertTrue(c2.equals(c1));
        } else {
            assertFalse(c2.equals(c1));
        }
    }

    // C, D
    @Test public void symmetric5() {
        D d = new D(0, 1);
        C c = new C(0);
        if (c.equals(d)) {
            assertTrue(d.equals(c));
        } else {
            assertFalse(d.equals(c));
        }
    }

    // C, O
    @Test public void symmetric6() {
        Object x = new Object();
        C c = new C(0);
        if (c.equals(x)) {
            assertTrue(x.equals(c));
        } else {
            assertFalse(x.equals(c));
        }
    }

    // D, D
    @Test public void symmetric7() {
        D d2 = new D(0, 1);
        D d1 = new D(0, 1);
        if (d1.equals(d2)) {
            assertTrue(d2.equals(d1));
        } else {
            assertFalse(d2.equals(d1));
        }
    }

    // D, C
    @Test public void symmetric8() {
        C c = new C(0);
        D d = new D(0, 1);
        if (d.equals(c)) {
            assertTrue(c.equals(d));
        } else {
            assertFalse(c.equals(d));
        }
    }

    // D, O
    @Test public void symmetric9() {
        Object x = new Object();
        D d = new D(0, 1);
        if (d.equals(x)) {
            assertTrue(x.equals(d));
        } else {
            assertFalse(x.equals(d));
        }
    }

    /*
     * P4: It is transitive: for any non-null reference values x, y, and z,
     * if x.equals(y) returns true and y.equals(z) returns true, then
     * x.equals(z) should return true.
     */
    // you do not need to write tests for P4
}