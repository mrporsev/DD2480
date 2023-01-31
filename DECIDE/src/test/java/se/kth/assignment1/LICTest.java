package se.kth.assignment1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LICTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void cond0() {
        Parameters Parameters = new Parameters();
        Parameters.LENGTH1 = 3;
        int NUMPOINTS = 2;
        Points points = new Points(NUMPOINTS);
        Point point1 = new Point(0,0);
        Point point2 = new Point(10,10);
        points.add(point1);
        points.add(point2);
        var test1=LIC.cond0(Parameters,points);
        assertTrue(test1);

        Points points2 = new Points(NUMPOINTS);
        point1 = new Point(0,0);
        point2 = new Point(1,1);
        points2.add(point1);
        points2.add(point2);
        var test2 = LIC.cond0(Parameters,points2);
        assertFalse(test2);
    }

    @Test
    void cond1() {
    
    }

    @Test
    void cond2() {

        Parameters Parameters = new Parameters();
        Parameters.EPSILON = 2;
        int NUMPOINTS = 2;
        Points points = new Points(NUMPOINTS);
        Point point1 = new Point(5,0);
        Point point2 = new Point(5,10);
        points.add(point1);
        points.add(point2);
        var test1=LIC.cond0(Parameters,points);
        assertTrue(test1);

    }

    @Test
    void cond3() {
    }

    @Test
    void cond4() {
    }

    @Test
    void cond5() {
    }

    @Test
    void cond6() {
    }

    @Test
    void cond7() {
    }

    @Test
    void cond8() {
    }

    @Test
    void cond9() {
    }

    @Test
    void cond10() {
    }

    @Test
    void cond11() {
    }

    @Test
    void cond12() {
    }

    @Test
    void cond13() {
    }

    @Test
    void cond14() {
    }
}
