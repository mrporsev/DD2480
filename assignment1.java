
/**
 * assignment1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.lang.Math;


public class assignment1 {

    public class POINT   // One point class
    {


        POINT(double x, double y)
        {
            this.x = x;
            this.y = y;
        }
        double x;
        double y;

        double getX()
        {
            return this.x;
        }

        double getY()
        {
            return this.y;
        }
    }

    public class Points
    {
        public Points(int size) // Constructs Points array with random numbers
        {
            Random rand = new Random();
            double upperbound = 10.0;
            double double_random = rand.nextDouble(upperbound);
            this.POINTS = new POINT[size];
            for(int i = 0; i < size; i++)
            {
                POINT point = new POINT(double_random,double_random);
                this.POINTS[i] = point;
                double_random = rand.nextDouble(upperbound);

            }
        }

        public Points(int size, double val) // Constructs Points array with val as coordinates
        {
            for(int i = 0; i < size; i++)
            {
                this.POINTS = new POINT[size];
                POINT point = new POINT(val,val);
                this.POINTS[i] = point;
            }

        }

        POINT[] getPOINTS()
        {
            return this.POINTS;
        }



        POINT[] POINTS;
    }
    public class Globals   // Global class that stores global variables
    {

        public static int NUMPOINTS = 10;



    }

    public class PARAMETERS
    {
        double LENGTH1 = 0;
        double RADIUS1;
        double EPSILON;
        double AREA1;
        int Q_PTS;
        int QUADS;
        double DIST;
        int N_PTS;
        int K_PTS;
        int A_PTS;
        int B_PTS;
        int C_PTS;
        int D_PTS;
        int E_PTS;
        int F_PTS;
        int G_PTS;
        double RADIUS2;
        double LENGTH2;
        double AREA2;
    }



    /**
     *
     * @param a data point a
     * @param b data point b
     * @return lenght between a and b
     */
    double lengt_between_points(POINT a, POINT b)
    {

        double x_a = a.getX();
        double y_a = a.getY();
        double x_b = b.getX();
        double y_b = b.getY();

        double dis_x = Math.abs(x_a - x_b);
        double dis_y = Math.abs(y_a - y_b);
        double tot_dis = Math.sqrt(Math.pow(dis_x,2) + Math.pow(dis_y,2)); // d=√((x2 – x1)² + (y2 – y1)²). formula

        return tot_dis;
    }

    /**
     *
     * @param a data point a
     * @param b data point b
     * @param arr array of data points
     * @return array of datapoints that lie between a and b
     */
    List<POINT> points_inbetween(POINT a, POINT b, POINT[] arr) //  Checks if there exists any points in the list c inbetween two points a and b.
    {
        double x_a = a.getX();
        double y_a = a.getY();
        double x_b = b.getX();
        double y_b = b.getY();
        POINT c;

        double dist_a_c = 0;
        double dist_b_c = 0;
        double dist_a_b = lengt_between_points(a,b);
        List<POINT> res = new ArrayList<POINT>();

        for(int i = 0; i < arr.length; i++)
        {
            c = arr[i];

            if(c.equals(a) || c.equals(b))
            {
                break;
            }

            dist_a_c = lengt_between_points(a,c);
            dist_b_c = lengt_between_points(b,c);

            if(dist_a_c + dist_b_c == dist_a_b)
            {
                res.add(c);
            }

        }
        return res;
    }

    public boolean calc_CMV(int cond) // Return true or false depending on if condition checks out
    {
        PARAMETERS Parameters = new PARAMETERS();
        Points Points = new Points(Globals.NUMPOINTS);

        switch (cond){
            case 0: // Kinda tested


                double dis = 0;

                POINT cur_point;
                POINT next_point;

                for(int i = 0; i < Globals.NUMPOINTS; i++)
                {

                    cur_point = Points.POINTS[i];

                    for(int j = 0; j < Globals.NUMPOINTS; j++)
                    {
                        next_point = Points.POINTS[j];
                        dis = lengt_between_points(cur_point,next_point);

                        if(dis > Parameters.LENGTH1)
                        {
                            return false;
                        }

                    }
                }
                return true;

            case 1:
                /*
                 * There exists at least one set of three consecutive data points that cannot
                 * all be contained
                 * within or on a circle of radius RADIUS1.
                 * (0 ≤ RADIUS1)
                 * The same as saying that the distance between a point and every other can't be
                 * bigger than the diameter?
                 */

                double diameter = 2 * RADIUS1;
                int[] pointA;
                int[] pointB;
                int[] pointC;

                for (int i = 0; i < listOfCoordinates.length - 2; i++) {

                    pointA = listOfCoordinates[i];
                    pointB = listOfCoordinates[i + 1];
                    pointC = listOfCoordinates[i + 2];

                    // Distance between x-coordinates
                    int xDistanceAB = Math.abs(pointA[0] - pointB[0]);
                    int xDistanceBC = Math.abs(pointB[0] - pointC[0]);
                    int xDistanceCA = Math.abs(pointC[0] - pointA[0]);

                    // Distance between y-coordinates
                    int yDistanceAB = Math.abs(pointA[1] - pointB[1]);
                    int yDistanceBC = Math.abs(pointB[1] - pointC[1]);
                    int yDistanceCA = Math.abs(pointC[1] - pointA[1]);

                    // Distance between the points
                    double distanceAB = Math.sqrt((xDistanceAB * xDistanceAB) + (yDistanceAB * yDistanceAB));
                    double distanceBC = Math.sqrt((xDistanceBC * xDistanceBC) + (yDistanceBC * yDistanceBC));
                    double distanceCA = Math.sqrt((xDistanceCA * xDistanceCA) + (yDistanceCA * yDistanceCA));

                    // If the length between some of the points are greater than the diameter, they
                    // can't be within the radius
                    if ((distanceAB > diameter) || (distanceBC > diameter) || (distanceCA > diameter)) {
                        return false;
                    }
                }
                return false;

            case 2:
                /*
                 * There exists at least one set of three consecutive data points which form an
                 * angle such that:
                 * angle < (PI−EPSILON)
                 * or
                 * angle > (PI+EPSILON)
                 * The second of the three consecutive points is always the vertex of the angle.
                 * If either the first point or the last point (or both) coincides with the
                 * vertex,
                 * the angle is undefined and the LIC is not satisfied by those three points.
                 * (0 ≤ EPSILON < PI)
                 */

                int[] pointA;
                int[] pointB;
                int[] pointC;

                for (int i = 0; i < listOfCoordinates.length - 2; i++) {

                    pointA = listOfCoordinates[i];
                    pointB = listOfCoordinates[i + 1]; // The vertex
                    pointC = listOfCoordinates[i + 2];

                    // Distance between x-coordinates
                    int xDistanceAB = Math.abs(pointA[0] - pointB[0]);
                    int xDistanceBC = Math.abs(pointB[0] - pointC[0]);
                    int xDistanceCA = Math.abs(pointC[0] - pointA[0]);

                    // Distance between y-coordinates
                    int yDistanceAB = Math.abs(pointA[1] - pointB[1]);
                    int yDistanceBC = Math.abs(pointB[1] - pointC[1]);
                    int yDistanceCA = Math.abs(pointC[1] - pointA[1]);

                    // Distance between the points
                    double distanceAB = Math.sqrt((xDistanceAB * xDistanceAB) + (yDistanceAB * yDistanceAB)); // A - B
                    double distanceBC = Math.sqrt((xDistanceBC * xDistanceBC) + (yDistanceBC * yDistanceBC)); // B - C
                    double distanceCA = Math.sqrt((xDistanceCA * xDistanceCA) + (yDistanceCA * yDistanceCA)); // C - A

                    // The angle of the second point (B)
                    double angle = Math
                            .acos(((distanceAB * distanceAB) + (distanceBC * distanceBC) + (distanceCA * distanceCA))
                                    / (2 * distanceAB * distanceBC));

                    if ((angle < (Math.PI - EPSILON)) || (angle > (Math.PI + EPSILON))) {
                        return true;
                    }
                }
                return false;

            case 3:
                /*
                 * There exists at least one set of three consecutive data points that are the
                 * vertices of a triangle
                 * with area greater than AREA1.
                 * (0 ≤ AREA1)
                 */

                int[] pointA;
                int[] pointB;
                int[] pointC;

                for (int i = 0; i < listOfCoordinates.length - 2; i++) {

                    pointA = listOfCoordinates[i];
                    pointB = listOfCoordinates[i + 1];
                    pointC = listOfCoordinates[i + 2];

                    // Distance between x-coordinates
                    int xDistanceAB = Math.abs(pointA[0] - pointB[0]);
                    int xDistanceBC = Math.abs(pointB[0] - pointC[0]);
                    int xDistanceCA = Math.abs(pointC[0] - pointA[0]);

                    // Distance between y-coordinates
                    int yDistanceAB = Math.abs(pointA[1] - pointB[1]);
                    int yDistanceBC = Math.abs(pointB[1] - pointC[1]);
                    int yDistanceCA = Math.abs(pointC[1] - pointA[1]);

                    // Distance between the points
                    double distanceAB = Math.sqrt((xDistanceAB * xDistanceAB) + (yDistanceAB * yDistanceAB));
                    double distanceBC = Math.sqrt((xDistanceBC * xDistanceBC) + (yDistanceBC * yDistanceBC));
                    double distanceCA = Math.sqrt((xDistanceCA * xDistanceCA) + (yDistanceCA * yDistanceCA));

                    // Heron's formula
                    double s = (distanceAB + distanceBC + distanceCA) / 2;
                    double area = Math.sqrt(s * (s - distanceAB) * (s - distanceBC) * (s - distanceCA));

                    if (area > AREA1) {
                        return true;
                    }
                }
                return false;

            case 4:
                /*
                 * There exists at least one set of Q_PTS consecutive data points that lie in
                 * more than QUADS quadrants. Where there is ambiguity as to which quadrant
                 * contains a given point, priority of decision will be by quadrant number,
                 * i.e., I, II, III, IV.
                 * For example, the data point (0,0) is in quadrant I, the point (-l,0) is in
                 * quadrant II,
                 * the point (0,-l) is in quadrant III, the point (0,1) is in quadrant I and the
                 * point (1,0)
                 * is in quadrant I.
                 * (2 ≤ Q_PTS ≤ NUMPOINTS), (1 ≤ QUADS ≤ 3)
                 */

                for (int i = 0; i < listOfCoordinates.length - Q_PTS; i++) {

                    boolean[] existsInQuadrant = { false, false, false, false };

                    for (int qthPoint = 0; qthPoint < Q_PTS; qthPoint++) {

                        int xCoordinateQthPoint = listOfCoordinates[i + qthPoint];
                        int yCoordinateQthPoint = listOfCoordinates[i + qthPoint];

                        // First quadrant (x >= 0 and y >= 0)
                        if ((xCoordinateQthPoint >= 0) && (yCoordinateQthPoint >= 0)) {
                            existsInQuadrant[0] = true;
                        }

                        // Second quadrant (x < 0 and y >= 0)
                        else if ((xCoordinateQthPoint >= 0) && (yCoordinateQthPoint >= 0)) {
                            existsInQuadrant[1] = true;
                        }

                        // Third quadrant (x <= 0 and y < 0)
                        else if ((xCoordinateQthPoint <= 0) && (yCoordinateQthPoint >= 0)) {
                            existsInQuadrant[2] = true;
                        }

                        // Fourth quadrant (x >= 0 and y < 0)
                        else if ((xCoordinateQthPoint >= 0) && (yCoordinateQthPoint >= 0)) {
                            existsInQuadrant[3] = true;
                        }
                    }

                    int numberOfPointsInQuadrants = 0;

                    // Checks number of data points existing in quadrants
                    for (int j = 0; i < existsInQuadrant.length; j++) {

                        if (existsInQuadrant[j] == true) {
                            numberOfPointsInQuadrants++;
                        }
                    }

                    // If the number of existing data points are greater than QUADS, return true
                    if (numberOfPointsInQuadrants > QUADS) {
                        return true;
                    }
                }
                return false;

            case 5:
                /*
                 * There exists at least one set of two consecutive data points, (X[i],Y[i]) and
                 * (X[j],Y[j]), such that X[j] - X[i] < 0. (where i = j-1)
                 */

                for (int i = 0; i < listOfCoordinates.length - 1; i++) {

                    // TODO:
                    // Need to decide how to structure the x- & y-coordinates so
                    // "X[...]" are placeholders for now (just as "listOfCoordinates")
                    if ((X[i + 1] - X[i]) < 0) { // Since i = j-1 --> j = i+1
                        return true;
                    }
                }
                return false;

            case 6:

            case 7: // Untested

                if(Globals.NUMPOINTS < 3)
                {
                    return false;
                }

                POINT p1;
                POINT p2;
                List<POINT> points_between;
                POINT k1;
                POINT k2;
                double dis1;



                for(int i = 0; i < Globals.NUMPOINTS - 1; i++)
                {
                    p1 = Points.POINTS[i];
                    p2 = Points.POINTS[i+1];
                    points_between = points_inbetween(p1,p2,Points.POINTS);

                    if(points_between.size() == Parameters.K_PTS)
                    {
                        for(int j = 0; j < points_between.size(); j++)
                        {
                            k1 = points_between.get(j);

                                    for(int k = 0; k < points_between.size(); k++)
                                    {
                                        k2 = points_between.get(k);
                                        dis1 = lengt_between_points(k1,k2);
                                        if(dis1 <= Parameters.LENGTH1 && !k1.equals(k2))
                                        {
                                            return false;
                                        }
                                    }
                        }
                    }

                }
                return true;


            case 8:
                /*
                 * There exists at least one set of three data points separated by exactly A_PTS
                 * and B_PTS consecutive intervening points, respectively, that cannot be
                 * contained within or on a circle of radius RADIUS1. The condition is not met
                 * when NUMPOINTS < 5.
                 * 1 ≤ A_PTS, 1 ≤ B_PTS
                 * A_PTS + B_PTS ≤ (NUMPOINTS−3)
                 */

                if (NUMPOINTS < 5) {
                    return false;
                }
                if (A_PTS < 1 || B_PTS < 1 || A_PTS + B_PTS < NUMPOINTS - 3) {
                    return false;
                }

                double diameter = 2 * RADIUS1;
                int[] pointA;
                int[] pointB;
                int[] pointC;

                for (int i = 0; i < listOfCoordinates.length - 3 - A_PTS - B_PTS; i++) {

                    pointA = listOfCoordinates[i];
                    pointB = listOfCoordinates[i + A_PTS]; // Maybe have to take +1 too if A_PTS and B_PTS are 1?
                    pointC = listOfCoordinates[i + B_PTS]; // and + A_PTS here? Otherwise, they can pick the same point?

                    // Distance between x-coordinates
                    int xDistanceAB = Math.abs(pointA[0] - pointB[0]);
                    int xDistanceBC = Math.abs(pointB[0] - pointC[0]);
                    int xDistanceCA = Math.abs(pointC[0] - pointA[0]);

                    // Distance between y-coordinates
                    int yDistanceAB = Math.abs(pointA[1] - pointB[1]);
                    int yDistanceBC = Math.abs(pointB[1] - pointC[1]);
                    int yDistanceCA = Math.abs(pointC[1] - pointA[1]);

                    // Distance between the points
                    double distanceAB = Math.sqrt((xDistanceAB * xDistanceAB) + (yDistanceAB * yDistanceAB));
                    double distanceBC = Math.sqrt((xDistanceBC * xDistanceBC) + (yDistanceBC * yDistanceBC));
                    double distanceCA = Math.sqrt((xDistanceCA * xDistanceCA) + (yDistanceCA * yDistanceCA));

                    // If the length between some of the points are greater than the diameter, they
                    // can't be within the radius
                    if ((distanceAB > diameter) || (distanceBC > diameter) || (distanceCA > diameter)) {
                        return false;
                    }
                }
                return false;

            case 9:
                /*
                 * There exists at least one set of three data points separated by exactly C_PTS
                 * and D_PTS consecutive intervening points, respectively, that form an angle
                 * such that:
                 * angle < (PI−EPSILON)
                 * or
                 * angle > (PI+EPSILON)
                 * The second point of the set of three points is always the vertex of the
                 * angle. If either the first point or the last point (or both) coincide with
                 * the vertex, the angle is undefined and the LIC is not satisfied by those
                 * three points. When NUMPOINTS < 5, the condition is not met.
                 * 1 ≤ C PTS, 1 ≤ D PTS
                 * C_PTS + D_PTS ≤ NUMPOINTS−3
                 */

                if (NUMPOINTS < 5) {
                    return false;
                }
                if (C_PTS < 1 || D_PTS < 1 || C_PTS + D_PTS < NUMPOINTS - 3) {
                    return false;
                }

                int[] pointA;
                int[] pointB;
                int[] pointC;

                for (int i = 0; i < listOfCoordinates.length - 3 - C_PTS - D_PTS; i++) {

                    pointA = listOfCoordinates[i];
                    pointB = listOfCoordinates[i + C_PTS]; // The vertex (MAYBE +1 also? Same question as case 8)
                    pointC = listOfCoordinates[i + D_PTS];

                    // Distance between x-coordinates
                    int xDistanceAB = Math.abs(pointA[0] - pointB[0]);
                    int xDistanceBC = Math.abs(pointB[0] - pointC[0]);
                    int xDistanceCA = Math.abs(pointC[0] - pointA[0]);

                    // Distance between y-coordinates
                    int yDistanceAB = Math.abs(pointA[1] - pointB[1]);
                    int yDistanceBC = Math.abs(pointB[1] - pointC[1]);
                    int yDistanceCA = Math.abs(pointC[1] - pointA[1]);

                    // Distance between the points
                    double distanceAB = Math.sqrt((xDistanceAB * xDistanceAB) + (yDistanceAB * yDistanceAB)); // A - B
                    double distanceBC = Math.sqrt((xDistanceBC * xDistanceBC) + (yDistanceBC * yDistanceBC)); // B - C
                    double distanceCA = Math.sqrt((xDistanceCA * xDistanceCA) + (yDistanceCA * yDistanceCA)); // C - A

                    // The angle of the second point (B)
                    double angle = Math
                            .acos(((distanceAB * distanceAB) + (distanceBC * distanceBC) + (distanceCA * distanceCA))
                                    / (2 * distanceAB * distanceBC));

                    if ((angle < (Math.PI - EPSILON)) || (angle > (Math.PI + EPSILON))) {
                        return true;
                    }
                }
                return false;

            case 10:
                /*
                 * There exists at least one set of three data points separated by exactly E_PTS
                 * and F_PTS consecutive intervening points, respectively, that are the vertices
                 * of a triangle with area greater than AREA1. The condition is not met when
                 * NUMPOINTS < 5.
                 * 1 ≤ E_PTS, 1 ≤ F_PTS
                 * E_PTS + F_PTS ≤ NUMPOINTS−3
                 */

                if (NUMPOINTS < 5) {
                    return false;
                }
                if (E_PTS < 1 || F_PTS < 1 || E_PTS + F_PTS < NUMPOINTS - 3) {
                    return false;
                }

                int[] pointA;
                int[] pointB;
                int[] pointC;

                for (int i = 0; i < listOfCoordinates.length - 3 - E_PTS - F_PTS; i++) {

                    pointA = listOfCoordinates[i];
                    pointB = listOfCoordinates[i + E_PTS]; // MAYBE +1 also? Same question as case 8&9)
                    pointC = listOfCoordinates[i + F_PTS];

                    // Distance between x-coordinates
                    int xDistanceAB = Math.abs(pointA[0] - pointB[0]);
                    int xDistanceBC = Math.abs(pointB[0] - pointC[0]);
                    int xDistanceCA = Math.abs(pointC[0] - pointA[0]);

                    // Distance between y-coordinates
                    int yDistanceAB = Math.abs(pointA[1] - pointB[1]);
                    int yDistanceBC = Math.abs(pointB[1] - pointC[1]);
                    int yDistanceCA = Math.abs(pointC[1] - pointA[1]);

                    // Distance between the points
                    double distanceAB = Math.sqrt((xDistanceAB * xDistanceAB) + (yDistanceAB * yDistanceAB));
                    double distanceBC = Math.sqrt((xDistanceBC * xDistanceBC) + (yDistanceBC * yDistanceBC));
                    double distanceCA = Math.sqrt((xDistanceCA * xDistanceCA) + (yDistanceCA * yDistanceCA));

                    // Heron's formula
                    double s = (distanceAB + distanceBC + distanceCA) / 2;
                    double area = Math.sqrt(s * (s - distanceAB) * (s - distanceBC) * (s - distanceCA));

                    if (area > AREA1) {
                        return true;
                    }
                }
                return false;

            case 11:
                /*
                 * There exists at least one set of two data points, (X[i],Y[i]) and
                 * (X[j],Y[j]), separated by exactly G PTS consecutive intervening points, such
                 * that X[j] - X[i] < 0. (where i < j ) The condition is not met when
                 * NUMPOINTS < 3.
                 * 1 ≤ G PTS ≤ NUMPOINTS−2
                 */
                if (NUMPOINTS < 3) {
                    return false;
                }
                if (G_PTS < 1 || G_PTS < NUMPOINTS - 2) {
                    return false;
                }

                for (int i = 0; i < listOfCoordinates.length - 1 - G_PTS; i++) {

                    // TODO:
                    // Need to decide how to structure the x- & y-coordinates so
                    // "X[...]" are placeholders for now (just as "listOfCoordinates")
                    if ((X[i + G_PTS] - X[i]) < 0) { // Since i = j-1 --> j = i+1 (Maybe +1 as above?)
                        return true;
                    }
                }
                return false;

            case 12:

            case 13:

            case 14:

        }

        return false;
    }


    public boolean[] CMV(PARAMETERS Parameters)
    {
        boolean[] CMV = new boolean[15];

        for(int i = 0; i < 15; i++)
        {
            CMV[i] = calc_CMV(i);
        }

        return CMV;
    }

    public static int[][] PUM(int[] CVM, int[][] LCM) // PRELIMINARY
    {
        int[][] PUM = new int[0][0];
        return PUM;
    }

    public static int[] FUV(int[][] PUM) // PRELIMINARY
    {
        int[] FUV = new int[0];
        return FUV;
    }

    public static void decide(int NUMPOINTS, int[][] POINTS, PARAMETERS Parameters, int[][] LCM, int[] PUV) {

        /*
         * Preliminary plan of how it should work
         * first calculate CMV then PUM and then FUV and if FUV is approved send launch
         * approve
         * 
         * boolean launch = false;
         * 
         * int[] CMV = CMV(PARAMETERS Parameters);
         * int[][] PUM = PUM(CMV,LCM);
         * int[] FUV = FUV(PUM);
         * 
         * 
         * if(FUV)
         * {
         * launch = true;
         * }
         * 
         */

    }

    public static void main(String[] args) {

        // here the decide function should be run
        // decide()


        assignment1 assignment1 = new assignment1();
        System.out.println(assignment1.calc_CMV(7));


    }
}