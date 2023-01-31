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

        Parameters Parameters = new Parameters();
        Parameters.EPSILON = 1;
        int NUMPOINTS = 3;
        Points points = new Points(NUMPOINTS);
        Point point1 = new Point(0,0);
        Point point2 = new Point(2,2);
        Point point3 = new Point(3,0);

        points.add(point1);
        points.add(point2);
        points.add(point3);

        var test1=LIC.cond2(points,Parameters);
        assertTrue(test1);

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

        Parameters Parameters = new Parameters();
        Parameters.KPTS = 1;
        Parameters.LENGTH1 = 1;
        int NUMPOINTS = 3;
        Points points = new Points(NUMPOINTS);
        Point point1 = new Point(0,0);
        Point point2 = new Point(1,1);
        Point point3 = new Point(2,2);
        points.add(point1);
        points.add(point2);
        points.add(point3);
        var test1=LIC.cond7(Parameters,points);
        assertTrue(test1);
    }

    @Test
    void cond8() {

        Parameters Parameters = new Parameters();
        Parameters.APTS = 1;
        Parameters.BPTS = 1;
        Parameters.RADIUS1 = 1;
        int NUMPOINTS = 5;
        Points points = new Points(NUMPOINTS);
        Point point1 = new Point(100,100);
        Point point2 = new Point(0,0);
        Point point3 = new Point(-100,-100);
        Point point4 = new Point(1,1);
        Point point5 = new Point(50,50);

        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
        points.add(point5);

        var test1=LIC.cond8(points,Parameters);
        assertTrue(test1);
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

        Parameters Parameters = new Parameters();
        Parameters.GPTS = 1;

        int NUMPOINTS = 3;
        Points points = new Points(NUMPOINTS);
        Point point1 = new Point(0,0);
        Point point2 = new Point(1,1);
        Point point3 = new Point(3,3);

        points.add(point1);
        points.add(point2);
        points.add(point3);

        var test1=LIC.cond11(points,Parameters);
        assertTrue(test1);
    }

    @Test
    void cond12() {
        Parameters Parameters = new Parameters();
        Parameters.KPTS = 1;
        Parameters.LENGTH1 = 1;
        Parameters.LENGTH2 = 5;
        int NUMPOINTS = 4;
        Points points = new Points(NUMPOINTS);
        Point point1 = new Point(0,0);
        Point point2 = new Point(1,1);
        Point point3 = new Point(2,2);
        Point point4 = new Point(1.1,1.1);

        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);

        var test1=LIC.cond12(Parameters,points);
        assertTrue(test1);
    }

    @Test
    void cond13() {
        /**
         * According to the implementation of the cond13 method, it returns true if the distance between the APTS-th
         * and EPTS-th points in the points list is less than or equal to the sum of RADIUS1 and RADIUS2.
         * In this case, the distance between the first and the third points is sqrt((2-0)^2 + (2-0)^2) = 2.82, which is greater than 2 (RADIUS1) + 0 (RADIUS2).
         * Thus, the method should return false, and the test case passes.
         */
        Points points = new Points(5);
        points.add(new Point(0, 0));
        points.add(new Point(1, 1));
        points.add(new Point(2, 2));
        points.add(new Point(3, 3));
        points.add(new Point(4, 4));

        Parameters parameters = new Parameters();
        parameters.APTS = 1;
        parameters.EPTS = 2;
        parameters.RADIUS1 = 2;
        parameters.RADIUS2 = 0;

        assertFalse(LIC.cond13(parameters, points));
    }

    @Test
    void cond14() {
    }
}
