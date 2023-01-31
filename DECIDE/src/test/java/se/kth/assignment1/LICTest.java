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

    }

    @Test
    void cond1() {
        LIC lic = new LIC();
        Points points = new Points(3);
        points.add(new Point(0, 0));
        points.add(new Point(2, 2));
        points.add(new Point(4, 4));

        Parameters parameters = new Parameters();
        parameters.RADIUS1 = 1;

        boolean result = lic.cond1(points, parameters);
        assertFalse(result);
    }

    @Test
    void cond2() {
    }

    /**
     * Testing condition 3 with triangle area equal to AREA1, should give false
     */
    @Test
    void cond3() {
        LIC lic = new LIC();
        Points points = new Points(3);
        points.add(new Point(0, 0));
        points.add(new Point(3, 0));
        points.add(new Point(0, 3));

        Parameters parameters = new Parameters();
        parameters.AREA1 = 9;

        boolean result = lic.cond3(points, parameters);
        assertFalse(result);
    }

    @Test
    void cond4() {
    }

    @Test
    void cond5() {
        LIC lic = new LIC();
        Points points = new Points(2);
        points.add(new Point(0, 0));
        points.add(new Point(3, 3));

        Parameters parameters = new Parameters();

        boolean result = lic.cond5(points, parameters);
        assertTrue(result);
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
