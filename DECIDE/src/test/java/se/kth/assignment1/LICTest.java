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
        /*
         * Tests condition 0 and whether there exists at least one set of two
         * consecutive data points that are a distance greater than LENGTH1=3 apart.
         * Should return true.
         */
        Parameters Parameters = new Parameters();
        Parameters.LENGTH1 = 3;
        int NUMPOINTS = 2;
        Points points = new Points(NUMPOINTS);
        Point point1 = new Point(0, 0);
        Point point2 = new Point(10, 10);
        points.add(point1);
        points.add(point2);
        var test1 = LIC.cond0(Parameters, points);
        assertTrue(test1);

        /*
         * Tests condition 0 and whether there exists at least one set of two
         * consecutive data points that are a distance greater than LENGTH1=3 apart.
         * Should return false.
         */
        Points points2 = new Points(NUMPOINTS);
        point1 = new Point(0, 0);
        point2 = new Point(1, 1);
        points2.add(point1);
        points2.add(point2);
        var test2 = LIC.cond0(Parameters, points2);
        assertFalse(test2);

        /*
         * Tests condition 0 and the correctnes of input. Should return false since the
         * condition 0 <= LENGTH1 needs to be fulfilled.
         */
        Points points3 = new Points(NUMPOINTS);
        Parameters.LENGTH1 = -1;
        point1 = new Point(0, 0);
        point2 = new Point(1, 1);
        points2.add(point1);
        points2.add(point2);
        var test3 = LIC.cond0(Parameters, points3);
        assertFalse(test3);
    }

    /**
     * Test positive, negative and invalid input case for the condition:
     * There exists at least one set of three consecutive data points that cannot all be contained
     * within or on a circle of radius RADIUS1.
     * (0 ≤ RADIUS1)
     */
    @Test
    void cond1() {

        //Positve test case: The points are cointained in the AREA1
        LIC lic = new LIC();
        Points points = new Points(3);
        points.add(new Point(0, 0));
        points.add(new Point(1, 1));
        points.add(new Point(2, 2));

        Parameters parameters = new Parameters();
        parameters.RADIUS1 = 1;

        boolean result = lic.cond1(points, parameters);
        assertTrue(result);

        //Negative test case: The points are not cointained in the AREA1
        parameters.RADIUS1 = 100;
        result =lic.cond1(points,parameters);
        assertFalse(result);

        //invalid input test
        parameters.RADIUS1 = -1;
        result =lic.cond1(points,parameters);
        assertFalse(result);
    }

    @Test
    void cond2() {
        /*
         * Tests condition 2 and whether there exists at least one set of three
         * consecutive data points which form an angle such that:
         * angle < (PI-EPSILON)
         * or
         * angle > (PI-EPSILON)
         * Where the second data point is the vertex in which the angle is.
         * Should return true.
         */
        Parameters Parameters = new Parameters();
        Parameters.EPSILON = 1;
        int NUMPOINTS = 3;
        Points points = new Points(NUMPOINTS);
        Point point1 = new Point(0, 0);
        Point point2 = new Point(2, 2);
        Point point3 = new Point(3, 0);
        points.add(point1);
        points.add(point2);
        points.add(point3);
        var test1 = LIC.cond2(points, Parameters);
        assertTrue(test1);

        /*
         * Tests condition 2 and whether there exists at least one set of three
         * consecutive data points which form an angle such that:
         * angle < (PI-EPSILON)
         * or
         * angle > (PI-EPSILON)
         * Where the second data point is the vertex in which the angle is.
         * Should return false.
         */
        Parameters.EPSILON = 1;
        int NUMPOINTS2 = 3;
        Points points2 = new Points(NUMPOINTS2);
        Point point4 = new Point(0, 0);
        Point point5 = new Point(1, 0);
        Point point6 = new Point(2, 0);
        points2.add(point4);
        points2.add(point5);
        points2.add(point6);
        var test2 = LIC.cond2(points2, Parameters);
        assertFalse(test2);

        /*
         * Tests condition 2 and the correctnes of input. Should return false since the
         * condition 0 <= EPSILON < PI needs to be fulfilled. In this case EPSILON=5 so
         * it should return false.
         */
        Parameters.EPSILON = 5;
        int NUMPOINTS3 = 3;
        Points points3 = new Points(NUMPOINTS3);
        Point point7 = new Point(0, 0);
        Point point8 = new Point(2, 2);
        Point point9 = new Point(3, 0);
        points3.add(point7);
        points3.add(point8);
        points3.add(point9);
        var test3 = LIC.cond2(points3, Parameters);
        assertFalse(test3);
    }

    /**
     * Test positive, negative and invalid input case for the condition:
     There exists at least one set of three consecutive data points that are the vertices of a triangle
     with area greater than AREA1.
     (0 ≤ AREA1)
     */
    @Test
    void cond3() {

        //False case: area = AREA1
        LIC lic = new LIC();
        Points points = new Points(3);
        points.add(new Point(0, 0));
        points.add(new Point(3, 0));
        points.add(new Point(0, 3));

        Parameters parameters = new Parameters();
        parameters.AREA1 = 9;

        boolean result = lic.cond3(points, parameters);
        assertFalse(result);

        //Positive case: area > AREA1
        parameters.AREA1 = 1;
        result = lic.cond3(points, parameters);
        assertTrue(result);

        //Invalid input case:  AREA1 = -1
        parameters.AREA1 = -1;
        result = lic.cond3(points, parameters);
        assertFalse(result);

    }

    @Test
    void cond4() {
        /*
         * Tests condition 4 and whether there exists at least one set of Q_PTS
         * consecutive data points that lie in more than QUADS quadrants.
         * The test should return true.
         */
        LIC lic = new LIC();
        Parameters parameters = new Parameters();
        Points points = new Points(4);
        points.add(new Point(1, 1));
        points.add(new Point(-1, 1));
        points.add(new Point(-1, -1));
        points.add(new Point(1, -1));
        parameters.QPTS = 3;
        parameters.QUADS = 2;
        boolean result = lic.cond4(points, parameters);
        assertTrue(result);

        /*
         * Tests condition 4 and whether there exists at least one set of Q_PTS
         * consecutive data points that lie in more than QUADS quadrants.
         * The test should return false since all four points lie in the same quadrant.
         */
        Points points2 = new Points(4);
        points2.add(new Point(1, 1));
        points2.add(new Point(1, 0));
        points2.add(new Point(0, 1));
        points2.add(new Point(1, 1));
        parameters.QPTS = 3;
        parameters.QUADS = 2;
        boolean result2 = lic.cond4(points2, parameters);
        assertFalse(result2);

        /*
         * Tests condition 4 and the correctnes of input. Should return false since the
         * condition 1 <= QUADS <= 3 needs to be fulfilled. In this case QUADS=4 so
         * it should return false.
         */
        Points points3 = new Points(4);
        points3.add(new Point(1, 1));
        points3.add(new Point(-1, 1));
        points3.add(new Point(-1, -1));
        points3.add(new Point(1, -1));
        parameters.QPTS = 3;
        parameters.QUADS = 4;
        boolean result3 = lic.cond4(points3, parameters);
        assertFalse(result3);
    }

    /**
     * Test positive, negative and invalid input case for the condition:
     There exists at least one set of two consecutive data points, (X[i],Y[i]) and (X[j],Y[j]), such
     that X[j] - X[i] < 0. (where i = j-1)
     */
    @Test
    void cond5() {

        //Positive case: 1-2 = -1 < 0
        LIC lic = new LIC();
        Points points = new Points(2);
        points.add(new Point(1, 1));
        points.add(new Point(2, 2));

        Parameters parameters = new Parameters();

        boolean result = lic.cond5(points, parameters);
        assertTrue(result);

        //Negative case: 2-1 = 1 > 0
        Points points2 = new Points(2);
        points2.add(new Point(2, 2));
        points2.add(new Point(1, 1));
        result = lic.cond5(points2, parameters);
        assertFalse(result);

        //Invalid case: NUMPOINTS < 2
        Points points3 = new Points(1);
        points3.add(new Point(1,1));
        result = lic.cond5(points3, parameters);
        assertFalse(result);


    }

    @Test
    void cond6() {
        LIC lic = new LIC();
        Parameters parameters = new Parameters();

        /**
         * positive case :
         * Should return true since distance to the middle points from the coincident point is > 2
         */
        Points points1 = new Points(4);
        points1.add(new Point(0, 0));
        points1.add(new Point(2, 0));
        points1.add(new Point(0, 3));
        points1.add(new Point(0, 0));

        parameters.NPTS = 4;
        parameters.DIST = 2;

        assertTrue(lic.cond6(parameters, points1));

        /**
         * negative case :
         * Should return true sinceno  distance to the middle points from the coincident point is > 5
         */
        Points points2 = new Points(4);
        points1.add(new Point(0, 0));
        points1.add(new Point(2, 0));
        points1.add(new Point(0, 3));
        points1.add(new Point(0, 0));

        parameters.NPTS = 4;
        parameters.DIST = 5;

        assertFalse(lic.cond6(parameters, points2));

        /**
         * Invalid input case :
         * returns false when points.size() < 3 or parameters.NPTS < 3 or
         * parameters.NPTS > points.size().
         * In the test case, the size of points is 3, which is less than parameters.NPTS
         * of 4, so the function returns false, and the assertion fails.
         */


        Points points = new Points(3);
        points.add(new Point(1, 2));
        points.add(new Point(1, 3));
        points.add(new Point(3, 3));

        parameters.NPTS = 3;
        parameters.DIST = 10;

        boolean result = lic.cond6(parameters, points);
        assertFalse(result);
    }

    /**
     * Test positive, negative and invalid input case for the condition:
     There exists at least one set of two data points separated by exactly K PTS consecutive
     intervening points that are a distance greater than the length, LENGTH1, apart. The condition
     is not met when NUMPOINTS < 3.
     1 ≤ K PTS ≤ (NUMPOINTS−2)

     */
    @Test
    void cond7() {

        //Positive case: point 0,0 is LENGHT1 apart from 2,2
        Parameters Parameters = new Parameters();
        Parameters.KPTS = 1;
        Parameters.LENGTH1 = 1;
        int NUMPOINTS = 3;
        Points points = new Points(NUMPOINTS);
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 1);
        Point point3 = new Point(2, 2);
        points.add(point1);
        points.add(point2);
        points.add(point3);
        var test1 = LIC.cond7(Parameters, points);
        assertTrue(test1);

        //Negative case point 0,0 is not LENGHT1 apart from 2,2
        Parameters.LENGTH1 = 10;
        Points points1 = new Points(NUMPOINTS);
        points1.add(new Point(0,0));
        points1.add(new Point(1,1));
        points1.add(new Point(2,2));
        boolean res = LIC.cond7(Parameters, points1);
        assertFalse(res);

        //Invalid case: NUMPOINTS < 3
        Points points2 = new Points(2);
        res = LIC.cond7(Parameters, points2);
        assertFalse(res);
    }

    @Test
    void cond8() {
        /*
         * Tests condition 8 and whether there exists at least one set of three
         * data points separated by exactly A_PTS and B_PTS consecutive intervening
         * points, respectively, that cannot be contained within or on a circle of
         * radius RADIUS1.
         * The test should return true.
         */
        Parameters Parameters = new Parameters();
        Parameters.APTS = 1;
        Parameters.BPTS = 1;
        Parameters.RADIUS1 = 1;
        int NUMPOINTS = 5;
        Points points = new Points(NUMPOINTS);
        points.add(new Point(100, 100));
        points.add(new Point(0, 0));
        points.add(new Point(-100, -100));
        points.add(new Point(1, 1));
        points.add(new Point(50, 50));
        var test1 = LIC.cond8(points, Parameters);
        assertTrue(test1);

        /*
         * Tests condition 8 and whether there exists at least one set of three
         * data points separated by exactly A_PTS and B_PTS consecutive intervening
         * points, respectively, that cannot be contained within or on a circle of
         * radius RADIUS1.
         * The test should return false since the points are within the radius
         * RADIUS1=10.
         */
        Parameters.APTS = 1;
        Parameters.BPTS = 1;
        Parameters.RADIUS1 = 10;
        int NUMPOINTS2 = 5;
        Points points2 = new Points(NUMPOINTS2);
        points2.add(new Point(1, 1));
        points2.add(new Point(0, 0));
        points2.add(new Point(-1, -1));
        points2.add(new Point(1, -1));
        points2.add(new Point(1, 0));
        var test2 = LIC.cond8(points2, Parameters);
        assertFalse(test2);

        /*
         * Tests condition 8 and the correctnes of input. Should return false since the
         * condition NUMPOINTS < 5 needs to be fulfilled. In this case NUMPOINTS=4 so
         * it should return false.
         */
        Parameters.APTS = 1;
        Parameters.BPTS = 1;
        Parameters.RADIUS1 = 10;
        int NUMPOINTS3 = 4;
        Points points3 = new Points(NUMPOINTS3);
        points3.add(new Point(100, 100));
        points3.add(new Point(0, 0));
        points3.add(new Point(-100, -100));
        points3.add(new Point(50, 50));
        var test3 = LIC.cond8(points3, Parameters);
        assertFalse(test3);
    }

    @Test
    void cond9() {
        LIC lic = new LIC();
        Points points = new Points(5);
        points.add(new Point(0, 0));
        points.add(new Point(1, 0));
        points.add(new Point(2, 2));
        points.add(new Point(2, 2));
        points.add(new Point(3, 0));

        Parameters parameters = new Parameters();
        parameters.EPSILON = 1;
        parameters.CPTS = 1;
        parameters.DPTS = 1;

        boolean result = lic.cond9(points, parameters);
        assertTrue(result);
    }

    /**
     * Test positive, negative and invalid input case for the condition:
     There exists at least one set of three data points separated by exactly E PTS and F PTS consecutive
     intervening points, respectively, that are the vertices of a triangle with area greater
     than AREA1. The condition is not met when NUMPOINTS < 5.
     1 ≤ E PTS, 1 ≤ F PTS
     E PTS+F PTS ≤ NUMPOINTS−3
     */
    @Test
    void cond10() {
        /**
         * In this test case, EPTS = 1 and FPTS = 1, which means that the three points
         * are separated by exactly 1 and 1 consecutive
         * intervening points respectively.
         * The area of the triangle formed by these three points is calculated using
         * Heron's formula and is compared to AREA1 = 1.
         * The area of the triangle is greater than AREA1, so the method returns true.
         * Hence, the assertTrue statement doesn't throw an error and the test case
         * passes.
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

        //False case: The area of the triange < AREA1.
        parameters.AREA1 = 100;
        assertFalse(LIC.cond10(points, parameters));

        //Invalid input: NUMPOINTS < 5
        parameters.AREA1 = -1;
        Points points2 = new Points(1);
        points2.add(new Point(1,1));
        assertFalse(LIC.cond10(points2, parameters));

    }

    @Test
    void cond11() {
        Parameters Parameters = new Parameters();
        /**
         * Postive case:
         * point[0] and point[2] are separated by 1 point (GPTS) and x[0] - x[1] < 0
         */

        Parameters.GPTS = 1;
        int NUMPOINTS = 3;
        Points points = new Points(NUMPOINTS);
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 1);
        Point point3 = new Point(3, 3);

        points.add(point1);
        points.add(point2);
        points.add(point3);

        var test1 = LIC.cond11(points, Parameters);
        assertTrue(test1);

        /**
         * negative test :
         * first and last point are such that x[j] - x[i] = 3 > 0
         */
        Parameters.GPTS = 1;
        Points points2 = new Points(NUMPOINTS);
        points2.add(new Point(5, 0));
        points2.add(new Point(1, 1));
        points2.add(new Point(2, 0));

        assertFalse(LIC.cond11(points2, Parameters));

        /**
         * invalid input case:
         * Here NUMPOINTS = 2, which is in invalid input, hence the condition should be false
         */
        points.remove(point1);
        assertFalse(LIC.cond11(points, Parameters));
    }

    /**
     * Test positive, negative and invalid input case for the condition:
     There exists at least one set of two data points, separated by exactly K PTS consecutive
     intervening points, which are a distance greater than the length, LENGTH1, apart. In addition,
     there exists at least one set of two data points (which can be the same or different from
     the two data points just mentioned), separated by exactly K PTS consecutive intervening
     points, that are a distance less than the length, LENGTH2, apart. Both parts must be true
     for the LIC to be true. The condition is not met when NUMPOINTS < 3.
     0 ≤ LENGTH2
     */
    @Test
    void cond12() {

        //Positive test case: point 0,0 and 2,2 are > LENGHT1 = 1 apart with K_PTS = 1
        //and 0,0 and 2,2 are < LENGHT2 = 5 apart with K_PTS = 1
        Parameters Parameters = new Parameters();
        Parameters.KPTS = 1;
        Parameters.LENGTH1 = 1;
        Parameters.LENGTH2 = 5;
        int NUMPOINTS = 4;
        Points points = new Points(NUMPOINTS);
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 1);
        Point point3 = new Point(2, 2);
        Point point4 = new Point(1.1, 1.1);

        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);

        var test1 = LIC.cond12(Parameters, points);
        assertTrue(test1);

        //Negative test case: point 0,0 and 2,2 are < LENGHT1  apart
        Parameters.LENGTH1 = 100;
        boolean res = LIC.cond12(Parameters, points);
        assertFalse(res);

        //Invalid input case: NUMPOINTS < 3
        Points points2 = new Points(2);
        res = LIC.cond12(Parameters, points);
        assertFalse(res);


    }

    /**
     * Test positive, negative and invalid input case for the condition:
     There exists at least one set of three data points, separated by exactly A PTS and B PTS
     consecutive intervening points, respectively, that cannot be contained within or on a circle of
     radius RADIUS1. In addition, there exists at least one set of three data points (which can be
     the same or different from the three data points just mentioned) separated by exactly A PTS
     and B PTS consecutive intervening points, respectively, that can be contained in or on a
     circle of radius RADIUS2. Both parts must be true for the LIC to be true. The condition is
     not met when NUMPOINTS < 5.
     0 ≤ RADIUS2
     */
    @Test
    void cond13() {
        /**
         * According to the implementation of the cond13 method, it returns true if the
         * distance between the APTS-th
         * and EPTS-th points in the points list is less than or equal to the sum of
         * RADIUS1 and RADIUS2.
         * In this case, the distance between the first and the third points is
         * sqrt((2-0)^2 + (2-0)^2) = 2.82, which is greater than 2 (RADIUS1) + 0
         * (RADIUS2).
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
        parameters.EPTS = 1;
        parameters.RADIUS1 = 100;
        parameters.RADIUS2 = 0;

        assertFalse(LIC.cond13(parameters, points));

        //True test case: Distance = 2.82 > AREA = 0
        //parameters.EPTS = 2;
        parameters.RADIUS1 = 0;
        parameters.RADIUS2 = 100;
        assertTrue(LIC.cond13(parameters, points));

        //Invalid case: RADIUS1 < 0
        parameters.RADIUS1 = - 1;
        assertFalse(LIC.cond13(parameters, points));



    }

    @Test
    void cond14() {
        Parameters Parameters = new Parameters();

        /*
        positive test case :
        Test when there exist an area greater than AREA1 and a area less then AREA2
         */
        Parameters.EPTS = 1;
        Parameters.FPTS = 1;
        Parameters.AREA1 = 1;
        Parameters.AREA2 = 100000;

        int NUMPOINTS = 5;
        Points points = new Points(NUMPOINTS);
        Point point1 = new Point(-5, 0);
        Point point2 = new Point(1, 1);
        Point point3 = new Point(0, 10);
        Point point4 = new Point(1.1, 1.1);
        Point point5 = new Point(5, 0);

        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
        points.add(point5);

        var test1 = LIC.cond14(points, Parameters);
        assertTrue(test1);

        /*
        invalid input case : Not enough number of points (NUMPOINTS < 5) should return false
         */
        points.remove(point1);
        points.remove(point2);

        assertFalse(LIC.cond14(points, Parameters));

        /*
        negative test case :
         */
        Points points2 = new Points(6);
        points2.add(new Point(0, 0));
        points2.add(new Point(0, 0));
        points2.add(new Point(1, 0));
        points2.add(new Point(2, 0));
        points2.add(new Point(0, 1));
        points2.add(new Point(0, 2));

        Parameters.AREA1 = 1.05;
        Parameters.AREA2 = 0.40;

        assertFalse(LIC.cond14(points2, Parameters));




    }
}
