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
    }

    @Test
    void cond6() {
        /**
         * returns false when points.size() < 3 or parameters.NPTS < 3 or parameters.NPTS > points.size().
         * In the test case, the size of points is 3, which is less than parameters.NPTS of 4, so the function returns false, and the assertion fails.
         */
        LIC lic = new LIC();
        Parameters parameters = new Parameters();
        Points points = new Points(3);
        points.add(new Point(1,2));
        points.add(new Point(1,3));
        points.add(new Point(3,3));

        parameters.NPTS = 3;
        parameters.DIST = 10;

        boolean result = lic.cond6(parameters, points);
        assertFalse(result);
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
        /**
         * In this test case, EPTS = 1 and FPTS = 1, which means that the three points are separated by exactly 1 and 1 consecutive
         * intervening points respectively.
         * The area of the triangle formed by these three points is calculated using Heron's formula and is compared to AREA1 = 1.
         * The area of the triangle is greater than AREA1, so the method returns true.
         * Hence, the assertTrue statement doesn't throw an error and the test case passes.
         */
        Points points = new Points(5);
        points.add(new Point(0, 0));
        points.add(new Point(2, 0));
        points.add(new Point(1, 1));
        points.add(new Point(2, 2));
        points.add(new Point(0, 2));

        Parameters parameters = new Parameters();
        parameters.EPTS = 1;
        parameters.FPTS = 1;
        parameters.AREA1 = 0.5;

        assertTrue(LIC.cond10(points, parameters));
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
