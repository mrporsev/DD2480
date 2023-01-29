
/**
 * assignment1
 */

import java.lang.Math;

public class assignment1 {

    public class PARAMETERS {
        double LENGTH1;
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

    public static boolean calc_CMV(PARAMETERS Parameters, int cond) // Return true or false depending on if condition
                                                                    // checks out
    {
        switch (cond) {
            case 0:

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

            case 7:

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

            case 11:

            case 12:

            case 13:

            case 14:

        }

    }

    public static int[] CMV(PARAMETERS Parameters) {
        int[] CMV = new int[15];

        for (int i = 0; i < 15; i++) {
            CMV[i] = calc_CMV(Parameters, i);
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
    }
}